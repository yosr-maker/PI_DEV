import { Contribution } from './../entity/Contribution';
import { ContributionService } from './../services/contribution.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-contribution-list',
  templateUrl: './contribution-list.component.html',
  styleUrls: ['./contribution-list.component.css']
})
export class ContributionListComponent implements OnInit {
  contributionList:Contribution[];
  constructor(private contributionService: ContributionService) { }


  ngOnInit(): void {
    this.contributionService.getClientContribution(2).subscribe(res=>this.contributionList=res);
  }

}
