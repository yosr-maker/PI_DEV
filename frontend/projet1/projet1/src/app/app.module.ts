import { MbscModule } from '@mobiscroll/angular';
import { BrowserModule } from '@angular/platform-browser';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { PanierComponent } from './panier/panier.component';
import { ProductComponent } from './product/product.component';
import { ProductDetailComponent } from './product-detail/product-detail.component';
import { TestComponent } from './test/test.component';
import { UserComponent } from './user/user.component';
import { FormulairePayementComponent } from './formulaire-payement/formulaire-payement.component';
import { AuthentificationComponent } from './authentification/authentification.component';
import { ContactComponent } from './contact/contact.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ForumComponent } from './forum/forum.component';
import { EventsComponent } from './events/events.component';
import { AskmeComponent } from './askme/askme.component';
import { BlogComponent } from './blog/blog.component';
import { CategoryFrorumComponent } from './category-frorum/category-frorum.component';
import { DeliverytabComponent } from './deliverytab/deliverytab.component';
import { RouterModule,Routes } from '@angular/router';
import { ParticipationComponent } from './participation/participation.component';
import { HttpClientModule, HttpClientJsonpModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { AdminProductsComponent } from './admin-products/admin-products.component';

import { FormsModule } from "@angular/forms";
import { AdminEventComponent } from './admin-event/admin-event.component';
import { ContributionComponent } from './contribution/contribution.component';



const ROUTES : Routes =[
  {path :'tableau', component: DeliverytabComponent},
  {path :'forum', component: ForumComponent }

]
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    PanierComponent,
    ProductComponent,
    ProductDetailComponent,
    TestComponent,
    UserComponent,
    FormulairePayementComponent,
    AuthentificationComponent,
    ContactComponent,
    ForumComponent,
    EventsComponent,
    AskmeComponent,
    BlogComponent,
    CategoryFrorumComponent,
    DeliverytabComponent,
    ParticipationComponent,
    AdminProductsComponent,
    AdminEventComponent,
    ContributionComponent,
  

   
  ],
  imports: [ 
    MbscModule, 
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule, 
    ReactiveFormsModule,
    MbscModule,
    HttpClientJsonpModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(ROUTES)
  ],
  providers: [],
  bootstrap: [AppComponent],
  schemas : [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule { }

