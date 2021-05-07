import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
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
import { UserQuestionComponent } from './user-question/user-question.component';


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
    UserQuestionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
