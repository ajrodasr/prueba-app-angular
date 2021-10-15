import { TestBed } from '@angular/core/testing';

import { IngreGuardService } from './ingre-guard.service';

describe('IngreGuardService', () => {
  let service: IngreGuardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(IngreGuardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
