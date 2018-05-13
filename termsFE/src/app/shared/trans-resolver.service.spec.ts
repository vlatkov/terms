import { TestBed, inject } from '@angular/core/testing';

import { HttpJsonLoaderService } from './http-json-loader.service';

describe('HttpJsonLoaderService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [HttpJsonLoaderService]
    });
  });

  it('should be created', inject([HttpJsonLoaderService], (service: HttpJsonLoaderService) => {
    expect(service).toBeTruthy();
  }));
});
