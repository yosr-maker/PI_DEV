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
import { BodyComponent } from './components/body/body.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { CrudproduckComponent } from './crudproduck/crudproduck.component';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastContainerModule, ToastrModule } from 'ngx-toastr';
import { ReclamationComponent } from './reclamation/reclamation.component';
import { AddEventAdminComponent } from './add-event-admin/add-event-admin.component';
import { UpdateEventAdminComponent } from './update-event-admin/update-event-admin.component';
import { ParticipationListComponent } from './participation-list/participation-list.component';
import { ContributionListComponent } from './contribution-list/contribution-list.component';
import { EventParticipationComponent } from './event-participation/event-participation.component';
import { CommonModule } from '@angular/common';
import { CalendarComponent } from './calendar/calendar.component';




import { FlatpickrModule } from 'angularx-flatpickr';
import { CalendarModule, DateAdapter } from 'angular-calendar';
import { adapterFactory } from 'angular-calendar/date-adapters/date-fns';
import { NgbModalModule } from '@ng-bootstrap/ng-bootstrap';

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
    BodyComponent,
    HeaderComponent,
    FooterComponent,
    CrudproduckComponent,
    ContributionComponent,
    ReclamationComponent,
    AddEventAdminComponent,
    UpdateEventAdminComponent,
    ParticipationListComponent,
    ContributionListComponent,
    EventParticipationComponent,
    CalendarComponent,
  ],
  imports: [ 
    MbscModule, 
    BrowserModule,
    BrowserAnimationsModule,
    CommonModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule, 
    ReactiveFormsModule,
    MbscModule,
    HttpClientJsonpModule,
    HttpClientModule,
    FormsModule,
    ToastrModule.forRoot(),
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
  bootstrap: [AppComponent],
  schemas : [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule { }

