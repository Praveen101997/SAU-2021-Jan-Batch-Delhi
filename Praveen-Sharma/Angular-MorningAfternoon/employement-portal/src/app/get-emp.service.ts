import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GetEmpService {

  constructor() {
    if (!localStorage.getItem('AUEmployee')) {
      localStorage.setItem('AUEmployee', JSON.stringify({}));
      localStorage.setItem('AUEmployeeCount', '0');
    }
  }

  getUser(id: number) {
    return new Observable((observer) => {
      const userData = localStorage.getItem('AUEmployee')|| '{}';
      if (userData == null) {
        observer.error('User Data not available');
      }
      const requestedUserInfo = JSON.parse(userData)[id];
      if (userData[id]) {
        console.log('Sending one ' + requestedUserInfo);
        observer.next(requestedUserInfo);
        observer.complete();
      } else {
        console.log('not found');
        observer.error('User Data not found');
      }
      return {unsubscribe() {}};
    });
  }

  getAllUsers() {
    return new Observable((observer) => {
      // const {next, error} = observer;
      const users = JSON.parse(localStorage.getItem('AUEmployee')|| '{}');
      console.log('TEST');
      console.log(users != null);
      if (users != null) {
        console.log('SENDING ALL');
        console.log(JSON.stringify(users));
        observer.next(users);
        observer.complete();
      } else {
        console.log('Sending error');
        observer.error('No User Data Available');
      }
      return {unsubscribe() {}};
    });
  }
}
