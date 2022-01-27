import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { NameComponent } from './name/name.component';
import { UserComponent } from './user/user.component';
import { ThirdPageComponent } from './third-page/third-page.component';
import { FourComponent } from './four/four.component';
import { FiveComponent } from './five/five.component';
import { SixComponent } from './six/six.component';
import { InstituteComponent } from './institute/institute.component';
import { GalleryComponent } from './gallery/gallery.component'
import { CardComponent } from './card/card.component'

const routes: Routes = [
  { path: 'user', component: UserComponent },
  {path: 'new',component:NameComponent},
  {path: 'zoomImage', component:ThirdPageComponent},
  {path: 'four', component:FourComponent},
  {path: 'five', component:FiveComponent},
  {path: 'six', component:SixComponent},
  {path: 'institute', component:InstituteComponent},
  {path: 'gallery', component:GalleryComponent},
  {path: 'card', component:CardComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
