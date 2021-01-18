import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, Validators } from '@angular/forms';

import { GetEmpService } from '../get-emp.service';
import { AddEmpService } from '../add-emp.service';

@Component({
  selector: 'app-edit-emp',
  templateUrl: './edit-emp.component.html',
  styleUrls: ['./edit-emp.component.css']
})
export class EditEmpComponent implements OnInit {

  editEmpForm;
  name;
  id;
  age;
  dob;
  userKey;

  constructor(
    private addEmpService: AddEmpService,
    private route: ActivatedRoute,
    private router: Router,
    private getEmpService: GetEmpService,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');

    this.getEmpService.getUser(Number(id)).subscribe(
      (data: any) => {
        this.userKey = id;
        this.editEmpForm = this.fb.group({
          name: [data.name, Validators.required],
          id: [data.id, Validators.required],
          age: [data.age, Validators.required],
          dob: [data.dob, Validators.required],
        });

      },
    );
  }

  editEmp() {
    const updatedData = this.editEmpForm.value;
    updatedData.id = this.userKey;
    this.addEmpService.addEmp(updatedData).subscribe(
      success => this.router.navigate(['/']),
    );
  }

}

