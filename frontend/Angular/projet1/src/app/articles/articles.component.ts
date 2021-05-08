import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-articles',
  templateUrl: './articles.component.html',
  styleUrls: ['./articles.component.css']
})
export class ArticlesComponent implements OnInit {

  listeArticles = [
    {
      titre: 'Le championnat du monde',
      contenu: 'Le champion du monde de cette année est ....',
      auteur: 'Med Taher',
      date: '12/12/2005',
      outofstock: 'yes',
    },
    {
      titre: 'Les nouveaux parents',
      contenu: 'Les nouveaux parents....',
      auteur: 'Ahmed Said',
      date: '11/11/2018',
      outofstock: 'no',
    }];
  nbTotal = this.listeArticles.length;

  constructor() {
  }

  ngOnInit()
    :
    void {
  }

}
