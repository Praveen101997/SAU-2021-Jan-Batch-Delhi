import { TestBed } from '@angular/core/testing';

import { DelEmpService } from './del-emp.service';

describe('DelEmpService', () => {
  let service: DelEmpService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DelEmpService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
