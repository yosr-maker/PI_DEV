import { CalendarComponent } from './calendar/calendar.component';
import { ContributionListComponent } from './contribution-list/contribution-list.component';
import { ParticipationListComponent } from './participation-list/participation-list.component';
import { EventParticipationComponent } from './event-participation/event-participation.component';
import { AddEventAdminComponent } from './add-event-admin/add-event-admin.component';
import { UserComponent } from './user/user.component';
import { ReclamationComponent } from './reclamation/reclamation.component';
import { ContactComponent } from './contact/contact.component';
import { AdminEventComponent } from './admin-event/admin-event.component';
import { ContributionComponent } from './contribution/contribution.component';
import { ParticipationComponent } from './participation/participation.component';
import { EventsComponent } from './events/events.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminProductsComponent } from './admin-products/admin-products.component';
import { DeliverytabComponent } from './deliverytab/deliverytab.component';
import { ForumComponent } from './forum/forum.component';
import { HomeComponent } from './home/home.component';
import { PanierComponent } from './panier/panier.component';
import { ProductDetailComponent } from './product-detail/product-detail.component';
import { ProductComponent } from './product/product.component';

const routes: Routes = [

  {path: '', component: HomeComponent},
  {path: 'adminEvent', component: AdminProductsComponent},
  {path: 'addEventAdmin', component: AddEventAdminComponent},
  {path :'tableau', component: DeliverytabComponent},
  {path :'forum', component: ForumComponent },
  {path :'product-detail/:id', component: ProductDetailComponent },
  {path :'tableau', component: DeliverytabComponent},
  {path :'forum', component: ForumComponent },
  {path :'product-deatil', component: ProductDetailComponent },
  {path :'products', component: ProductComponent },
  {path :'cart', component: PanierComponent },
  {path :'eventList', component: EventsComponent },
  {path :'contact', component: ContactComponent },
  {path :'reclamation', component: ReclamationComponent },
  {path :'participation', component: ParticipationComponent },
  {path :'contribution', component: ContributionComponent },
  {path :'adminEvent', component: AdminEventComponent },
  {path :'eventParticipation', component:EventParticipationComponent },
  {path :'participationList', component:ParticipationListComponent },
  {path :'contributionList', component:ContributionListComponent },
  {path :'user', component: UserComponent },
  {path :'calendar', component: CalendarComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
