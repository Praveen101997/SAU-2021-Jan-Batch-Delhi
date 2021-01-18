import { DelEmpService } from '../del-emp.service';
import { GetEmpService } from '../get-emp.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import * as _ from 'lodash';

@Component({
  selector: 'app-list-emp',
  templateUrl: './list-emp.component.html',
  styleUrls: ['./list-emp.component.css']
})
export class ListEmpComponent implements OnInit {

  constructor(
    private getEmpService: GetEmpService,
    private delEmpService: DelEmpService,
    private router: Router) { }

  users = [];
  numberOfUsers = 0;
  confirmationString;
  modalKey;
  sortFlag = 0;
  searchText;

  ngOnInit() {
    this.getEmpService.getAllUsers().subscribe(
      data => {
        this.users = _.values(data);
      },
    );
    if (this.users) {
      this.numberOfUsers = this.users.length;
    }
  }

  get allUsers() {
    return this.users;
  }

  deleteUser(user) {
    this.modalKey = user.id;
    console.log("In delete");
    this.delEmpService.deleteUser(Number(this.modalKey)).subscribe({
      next: data => {
        this.numberOfUsers -= 1;
        this.users.splice(_.findIndex(this.users, ['id', this.modalKey]), 1);
        this.router.navigate(['/']);
      },
    });
  }
}
