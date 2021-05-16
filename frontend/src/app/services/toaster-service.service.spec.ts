import { TestBed } from '@angular/core/testing';

import { ToasterServiceService } from './toaster-service.service';

describe('ToasterServiceService', () => {
  let service: ToasterServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ToasterServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
