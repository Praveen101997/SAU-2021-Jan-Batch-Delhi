import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DelEmpService {

  constructor() { }

  deleteUser(id: number) {
    return new Observable(observer => {

      const completeData = JSON.parse(localStorage.getItem('AUEmployee')|| '{}');
      if (!completeData || !completeData[id]) {
        observer.error('User Data doesn\'t exist');
      } else {
        delete completeData[id];
        localStorage.setItem('AUEmployee', JSON.stringify(completeData));
        console.log('DELETING');
        observer.next('Success');
        observer.complete();
      }
      return {unsubscribe() {}};
    });
  }
}
