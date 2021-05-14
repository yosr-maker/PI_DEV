import { Component, OnInit } from '@angular/core';


interface Country {
  name: string;
  flag: string;
  area: number;
  population: number;
}
const COUNTRIES: Country[] = [
  {
    name: 'tunisia',
    flag: 'f/f3/Flag_of_Russia.svg',
    area: 17075200,
    population: 146989754
  },
  {
    name: 'Canada',
    flag: 'c/cf/Flag_of_Canada.svg',
    area: 9976140,
    population: 36624199
  },
  {
    name: 'United States',
    flag: 'a/a4/Flag_of_the_United_States.svg',
    area: 9629091,
    population: 324459463
  },
  {
    name: 'China',
    flag: 'f/fa/Flag_of_the_People%27s_Republic_of_China.svg',
    area: 9596960,
    population: 1409517397
  }
];
interface driver {
  idDriver: number;
  lastName: string;
  firstame: string;
  emailDriver: string;
  salaire:number;
  phone: string;
  location: string;
  nbrDeliveryAffected:number;
  
}
const DRIVERS: driver[] = [
  {
     idDriver: 1,
    lastName: 'ihsen',
    firstame: 'kila',
    emailDriver: 'gnrthqrt@dbdt.com',
    salaire:800,
    phone:'22914704',
    location: 'rue hooker dolittle',
    nbrDeliveryAffected:25
  },
  {
     idDriver: 2,
    lastName: 'ihsen',
    firstame: 'ghadab',
    emailDriver: 'gnrthqrt@dbdt.com',
    salaire:800,
    phone:'22914704',
    location: 'rue hooker dolittle',
    nbrDeliveryAffected:50
  },
  {
     idDriver: 3,
    lastName: 'ihsen',
    firstame: 'kila',
    emailDriver: 'gnrthqrt@dbdt.com',
    salaire:800,
    phone:'22914704',
    location: 'rue hooker dolittle',
    nbrDeliveryAffected:80
  }
];



interface delivery {
  idDeli : number;
  weight: number;
  Lenght: number;
  longitude : number;
  laltitude : number;
  dateDelivery : string;
  
}

const DELIVERIES: delivery[] = [
{
    idDeli : 1,
  weight: 25.2,
  Lenght: 12,
  longitude : 2.5,
  laltitude : 15.12,
  dateDelivery : '12-12-2020'
},
{
 
    idDeli : 2,
  weight: 25.2,
  Lenght: 12,
  longitude : 2.5,
  laltitude : 15.12,
  dateDelivery : '20-12-2021'
},
{
  
    idDeli : 3,
  weight: 25.2,
  Lenght: 12,
  longitude : 2.5,
  laltitude : 15.12,
  dateDelivery: '12-12-2022'
}
]
interface automobile{
  idAuto:number;
  typeAuto:string;
  power:string;
}
const AUTOMOBILES: automobile[] = [
  {
      idAuto : 1,
   typeAuto:'panaire',
    power:'5v'
  },
  {
   
      idAuto : 2,
   typeAuto:'panaire',
    power:'6v'
  },
  {
  idAuto : 3,
   typeAuto:'panaire',
    power:'4v'
  }
];

@Component({
  selector: 'app-deliverytab',
  templateUrl: './deliverytab.component.html',
  styleUrls: ['./deliverytab.component.css']
})
export class DeliverytabComponent implements OnInit {


  countries = COUNTRIES;
  drivers = DRIVERS;
  deliveries = DELIVERIES;
  automobiles = AUTOMOBILES;
  constructor() { }



  ngOnInit(): void {
  }

}
