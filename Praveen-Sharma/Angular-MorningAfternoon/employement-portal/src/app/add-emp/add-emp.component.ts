import { AddEmpService } from '../add-emp.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-emp',
  templateUrl: './add-emp.component.html',
  styleUrls: ['./add-emp.component.css']
})
export class AddEmpComponent implements OnInit {

  addEmpForm;

  constructor(fb: FormBuilder, private addEmpService: AddEmpService, private router: Router) { 
    this.addEmpForm = fb.group({
      name: ['', Validators.required],
      id: ['', Validators.required],
      age: ['', Validators.required],
      dob: ['', Validators.required]
    });
  }

  ngOnInit(): void {
  }

  addEmp() {
    this.addEmpService.addEmp(this.addEmpForm.value).subscribe(
      success => {
        this.router.navigate(['/']);
      }
    );
  }

}
