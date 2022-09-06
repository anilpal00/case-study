import { TestBed } from '@angular/core/testing';

import { AlertifService } from './alertif.service';

describe('AlertifService', () => {
  let service: AlertifService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AlertifService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
