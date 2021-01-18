import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AddEmpService {

  constructor() { }

  addEmp(userData) {
    return new Observable((observer) => {
      let completeData = JSON.parse(localStorage.getItem('AUEmployee')|| '{}');
      const completeDataLength = Number(localStorage.getItem('AUEmployeeCount'));
      if (completeData == null) {
        completeData = {};
      }
      let userId;
      if (userData.id) {
        userId = userData.id;
      } else {
        userId = completeDataLength + 1;
        userData.id = userId;
      }
      console.log('saving below data');
      console.log(userData);
      completeData[userId] = userData;
      localStorage.setItem('AUEmployee', JSON.stringify(completeData));
      localStorage.setItem('AUEmployeeCount', (completeDataLength + 1).toString());
      observer.next('Done');
      observer.complete();
      console.log('saved');
    });
  }
}
