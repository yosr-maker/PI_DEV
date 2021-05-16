

import { EventService } from './../services/event.service';

import { Component, OnInit } from '@angular/core';

import { ChangeDetectionStrategy, ViewChild, TemplateRef, } from '@angular/core';
import { startOfDay, endOfDay, subDays, addDays, endOfMonth, isSameDay, isSameMonth, addHours, } from 'date-fns';
import { Subject } from 'rxjs';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { CalendarEvent, CalendarEventAction, CalendarEventTimesChangedEvent, CalendarView, } from 'angular-calendar';

import { Event } from '../entity/event';




const colors: any = {
  red: {
    primary: '#ad2121',
    secondary: '#FAE3E3',
  },
  blue: {
    primary: '#1e90ff',
    secondary: '#D1E8FF',
  },
  green: {
    primary: '#04aa6d',
    secondary: '#D1E8FF',
  },
  yellow: {
    primary: '#e3bc08',
    secondary: '#FDF1BA',
  },
};


@Component({
  selector: 'app-calendar',
  // changeDetection: ChangeDetectionStrategy.OnPush,
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.scss']
})
export class CalendarComponent implements OnInit {

  event: Event = new Event();
  date: Date = new Date();

  events: CalendarEvent[] = [];
  upcomingEvents: Event[];
  passedEvents: Event[];

  ngOnInit(): void {
    this.eventService.getUpcomingEvents().subscribe(res => {
      this.upcomingEvents = res,

        this.viewDate = new Date();

      let a: CalendarEvent = { title: null, start: null }
      for (let i = 0; i < this.upcomingEvents.length; i++) {
        this.date = this.upcomingEvents[i].date;
        console.log(this.date);
        var year = Number(JSON.stringify(this.date).substr(1, 4));
        var month = Number(JSON.stringify(this.date).substr(6, 2));
        var day = Number(JSON.stringify(this.date).substr(9, 2));

        a.title = this.upcomingEvents[i].name + " is stil available ! ";
        a.start = new Date(year, month-1, day);
        a.color=colors.green;
        this.events.push(Object.assign({}, a));
      } 

      this.eventService.getPassedEvents().subscribe(res => {
        this.passedEvents = res;
        let c: CalendarEvent = { title: null, start: null }
        for (let i = 0; i < this.passedEvents.length; i++) {
          this.date = this.passedEvents[i].date;
          var year = Number(JSON.stringify(this.date).substr(1, 4));
          var month = Number(JSON.stringify(this.date).substr(6, 2));
          var day = Number(JSON.stringify(this.date).substr(9, 2));
          c.title = this.passedEvents[i].name + " has passed :(";;
          c.start = new Date(year, month-1, day);
          c.color=colors.red;
          this.events.push(Object.assign({}, c));
        }
  
      });

    });

    



  }



  constructor(private modal: NgbModal, private eventService: EventService) { 

  }

  @ViewChild('modalContent', { static: true }) modalContent: TemplateRef<any>;

  view: CalendarView = CalendarView.Month;

  CalendarView = CalendarView;

  viewDate: Date;

  modalData: {
    action: string;
    event: CalendarEvent;
  };

  actions: CalendarEventAction[] = [
    {
      label: '<i class="fas fa-fw fa-pencil-alt"></i>',
      a11yLabel: 'Edit',
      onClick: ({ event }: { event: CalendarEvent }): void => {
        this.handleEvent('Edited', event);
      },
    },
    {
      label: '<i class="fas fa-fw fa-trash-alt"></i>',
      a11yLabel: 'Delete',
      onClick: ({ event }: { event: CalendarEvent }): void => {
        this.events = this.events.filter((iEvent) => iEvent !== event);
        this.handleEvent('Deleted', event);
      },
    },
  ];

  refresh: Subject<any> = new Subject();

  activeDayIsOpen: boolean = true;

  dayClicked({ date, events }: { date: Date; events: CalendarEvent[] }): void {
    if (isSameMonth(date, this.viewDate)) {
      if (
        (isSameDay(this.viewDate, date) && this.activeDayIsOpen === true) ||
        events.length === 0
      ) {
        this.activeDayIsOpen = false;
      } else {
        this.activeDayIsOpen = true;
      }
      this.viewDate = date;
    }
  }

  eventTimesChanged({
    event,
    newStart,
    newEnd,
  }: CalendarEventTimesChangedEvent): void {
    this.events = this.events.map((iEvent) => {
      if (iEvent === event) {
        return {
          ...event,
          start: newStart,
          end: newEnd,
        };
      }
      return iEvent;
    });
    this.handleEvent('Dropped or resized', event);
  }

  handleEvent(action: string, event: CalendarEvent): void {
    this.modalData = { event, action };
    this.modal.open(this.modalContent, { size: 'lg' });
  }

  addEvent(): void {
    this.events = [
      ...this.events,
      {
        title: 'New event',
        start: startOfDay(new Date()),
        end: endOfDay(new Date()),
        color: colors.red,
        draggable: true,
        resizable: {
          beforeStart: true,
          afterEnd: true,
        },
      },
    ];
  }

  deleteEvent(eventToDelete: CalendarEvent) {
    this.events = this.events.filter((event) => event !== eventToDelete);
  }

  setView(view: CalendarView) {
    this.view = view;
  }

  closeOpenMonthViewDay() {
    this.activeDayIsOpen = false;
  }

}
