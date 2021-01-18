import { TestBed } from '@angular/core/testing';

import { AddEmpService } from './add-emp.service';

describe('AddEmpService', () => {
  let service: AddEmpService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AddEmpService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
