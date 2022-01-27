import { NgModule, OnInit } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserComponent } from './user/user.component';
import { NameComponent } from './name/name.component';
import { HttpClientModule } from '@angular/common/http';
import { ThirdPageComponent } from './third-page/third-page.component';
import { FourComponent } from './four/four.component';
import { FiveComponent } from './five/five.component';
import { SixComponent } from './six/six.component';
import { InstituteComponent } from './institute/institute.component';
import { CardComponent } from './card/card.component';
import { GalleryComponent } from './gallery/gallery.component';



@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    NameComponent,
    ThirdPageComponent,
    FourComponent,
    FiveComponent,
    SixComponent,
    InstituteComponent,
    CardComponent,
    GalleryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule implements OnInit { 
  constructor() { }

  ngOnInit(): void  {
  }
}
