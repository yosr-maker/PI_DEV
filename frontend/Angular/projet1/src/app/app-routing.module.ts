import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {AddProductComponent} from './add-product/add-product.component';
import {HomeeComponent} from './homee/homee.component';
import {ShowShoppingComponent} from './show-shopping/show-shopping.component';
import {DetailComponent} from './detail/detail.component';
import {EventComponent} from './event/event.component';
import {ParticipationComponent} from './participation/participation.component';
import {ContributionComponent} from './contribution/contribution.component';

const routes: Routes =
  [{path: 'add', component: AddProductComponent},
    {path: 'Home', component: HomeeComponent},
    {path: 'event', component: EventComponent},
    {path: 'participation', component: ParticipationComponent},
    {path: 'ShowShopping', component: ShowShoppingComponent},
    {path: 'contribution', component: ContributionComponent},
    {path: 'detail/:id', component: DetailComponent}];


@NgModule({
  imports: [RouterModule.forRoot(routes, {relativeLinkResolution: 'legacy'})],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
