import { TestBed } from '@angular/core/testing';

import { TAokenIspService } from './taoken-isp.service';

describe('TAokenIspService', () => {
  let service: TAokenIspService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TAokenIspService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
