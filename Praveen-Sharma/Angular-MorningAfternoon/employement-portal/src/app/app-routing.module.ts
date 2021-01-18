import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddEmpComponent} from './add-emp/add-emp.component'
import { ListEmpComponent } from './list-emp/list-emp.component';
import { EditEmpComponent } from './edit-emp/edit-emp.component';

const routes: Routes = [
  { path: 'add', component: AddEmpComponent },
  { path: 'edit/:id', component: EditEmpComponent},
  { path: '', component: ListEmpComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

