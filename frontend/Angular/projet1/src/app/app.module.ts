import {BrowserModule} from '@angular/platform-browser';
import {AppRoutingModule} from './app-routing.module';

import {AppComponent} from './app.component';
import {ProduitComponent} from './produit/produit.component';
import {NgModule} from '@angular/core' ;
import {FormsModule} from '@angular/forms';
import {ArticlesComponent} from './articles/articles.component';
import {ChildComponent} from './child/child.component';
import {ParentComponent} from './parent/parent.component';
import {HomeComponent} from './home/home.component';
import {ProductComponent} from './product/product.component';
import {ConvertisseurComponent} from './convertisseur/convertisseur.component';
import {ToEuroConvertComponent} from './to-euro-convert/to-euro-convert.component';
import {ActorsComponent} from './actors/actors.component';
import {ActorComponent} from './actor/actor.component';
import {FormProductComponent} from './form-product/form-product.component';
import {TemplateDrivenFormComponent} from './template-driven-form/template-driven-form.component';
import {CrisisListComponent} from './crisis-list/crisis-list.component';
import {HeroesListComponent} from './heroes-list/heroes-list.component';
import {RouterModule} from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import { DeleteUserComponent } from './delete-user/delete-user.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { ShowUserComponent } from './show-user/show-user.component';
import { AddProductComponent } from './add-product/add-product.component';
import { HomeeComponent } from './homee/homee.component';
import { ShowShoppingComponent } from './show-shopping/show-shopping.component';
import { DetailComponent } from './detail/detail.component';
import { TodoListComponent } from './todo-list/todo-list.component';
import { EventComponent } from './event/event.component';
import { ParticipationComponent } from './participation/participation.component';

import { ReactiveFormsModule } from '@angular/forms';
import { ContributionComponent } from './contribution/contribution.component';


import { CommonModule } from '@angular/common';

import { FlatpickrModule } from 'angularx-flatpickr';
import { CalendarModule, DateAdapter } from 'angular-calendar';
import { adapterFactory } from 'angular-calendar/date-adapters/date-fns';
import { NgbModalModule } from '@ng-bootstrap/ng-bootstrap';
import { AdminComponent } from './admin/admin.component';
import { ClaimComponent } from './claim/claim.component';




@NgModule({
  declarations: [
    AppComponent,
    ProduitComponent,
    ArticlesComponent,
    ChildComponent,
    ParentComponent,
    HomeComponent,
    ProductComponent,
    ConvertisseurComponent,
    ToEuroConvertComponent,
    ActorsComponent,
    ActorComponent,
    FormProductComponent,
    TemplateDrivenFormComponent,
    CrisisListComponent,
    HeroesListComponent,
    DeleteUserComponent,
    UpdateUserComponent,
    ShowUserComponent,
    AddProductComponent,
    HomeeComponent,
    ShowShoppingComponent,
    DetailComponent,
    TodoListComponent,
    EventComponent,
    ParticipationComponent,
    ContributionComponent,
    AdminComponent,
    ClaimComponent,




  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    CommonModule,
    FormsModule,
    NgbModalModule,
    FlatpickrModule.forRoot(),
    CalendarModule.forRoot({
      provide: DateAdapter,
      useFactory: adapterFactory,
    }),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
