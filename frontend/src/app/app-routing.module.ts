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
  {path :'tableau', component: DeliverytabComponent},
  {path :'forum', component: ForumComponent },
  {path :'product-detail/:id', component: ProductDetailComponent },
  {path :'tableau', component: DeliverytabComponent},
  {path :'forum', component: ForumComponent },
  {path :'product-deatil', component: ProductDetailComponent },
  {path :'products', component: ProductComponent },
  {path :'cart', component: PanierComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
