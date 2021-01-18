import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AddEmpService } from '../app/add-emp.service';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddEmpComponent } from './add-emp/add-emp.component';
import { EditEmpComponent } from './edit-emp/edit-emp.component';
import { TopComponent } from './top/top.component';
import { ListEmpComponent } from './list-emp/list-emp.component';

@NgModule({
  declarations: [
    AppComponent,
    AddEmpComponent,
    EditEmpComponent,
    TopComponent,
    ListEmpComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
    AddEmpService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
