import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PaymentComponent } from './payment/payment.component';
import { HeaderComponent } from './header/header.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';
import { HomeComponent } from './home/home.component';
import { ContactComponent } from './contact/contact.component';
import { SupportComponent } from './support/support.component';
import { SearchComponent } from './search/search.component';
import { MatMenuModule } from "@angular/material/menu";
import { MatCardModule } from '@angular/material/card';
import { AreaCardComponent } from './components/area-card/area-card.component';
import { SuggestionComponent } from './components/suggestion/suggestion.component';
import { HttpClientModule } from '@angular/common/http';
import { FooterComponent } from './footer/footer.component';
import { MatDialogModule } from '@angular/material/dialog';
import { MatSelectModule } from '@angular/material/select';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatTableModule } from '@angular/material/table';
import { Ng2SearchPipeModule } from 'ng2-search-filter';

import {MatDatepickerModule} from '@angular/material/datepicker';
import { MAT_DATE_FORMATS, DateAdapter, MAT_DATE_LOCALE } from '@angular/material/core';
import { MatNativeDateModule } from '@angular/material/core';





import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { MatInputModule } from '@angular/material/input';
import { CarouselModule } from './carousel/carousel.module';
import { ProductDetailsComponent } from './components/product-details/product-details.component';
import { BookingComponent } from './components/booking/booking.component';
import { RegistrationComponent } from './registration/registration.component';

import { BookingListComponent } from './booking-list/booking-list.component';

import { SearchBarComponent } from './components/search-bar/search-bar.component';



import { ReviewFormComponent } from './review-form/review-form.component';

import { LoginComponent } from './login/login.component';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { ReviewComponent } from './review/review.component';



import { NgxStarRatingModule } from 'ngx-star-rating';
import { ReviewListComponent } from './review-list/review-list.component';

import { DatePipe } from '@angular/common';

import { ReviewListFormComponent } from './review-list-form/review-list-form.component';
import { ResetPasswordComponent } from './reset-password/reset-password.component';



@NgModule({
  declarations: [
    AppComponent,
    PaymentComponent,
    HeaderComponent,
    HomeComponent,
    ContactComponent,
    SupportComponent,
    SearchComponent,
    AreaCardComponent,
    SuggestionComponent,
    FooterComponent,
    ProductDetailsComponent,
    BookingComponent,
    RegistrationComponent,

    BookingListComponent,

    SearchBarComponent,

    LoginComponent,
    ReviewFormComponent,
    LoginComponent,
    ReviewComponent,
    ReviewListComponent,
    ReviewListFormComponent,
    ResetPasswordComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatIconModule,
    MatButtonModule,
    MatToolbarModule,
    MatMenuModule,
    MatCardModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    MatInputModule,
    CarouselModule,
    MatDialogModule,
    MatSelectModule,
    MatFormFieldModule,
    MatTableModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatDialogModule,
    MatSnackBarModule,
    NgxStarRatingModule,
    Ng2SearchPipeModule,
    MatDialogModule
  ],
  providers: [DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
