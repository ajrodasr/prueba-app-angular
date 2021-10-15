import { TestBed } from '@angular/core/testing';

import { IngreInterceptorService } from './ingre-interceptor.service';

describe('IngreInterceptorService', () => {
  let service: IngreInterceptorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(IngreInterceptorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
