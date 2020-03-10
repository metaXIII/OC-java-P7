import { TestBed } from '@angular/core/testing';

import { LibrairieService } from './librairie.service';

describe('LibrairieService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: LibrairieService = TestBed.get(LibrairieService);
    expect(service).toBeTruthy();
  });
});
