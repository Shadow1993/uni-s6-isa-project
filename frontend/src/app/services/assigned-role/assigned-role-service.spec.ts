import { TestBed } from '@angular/core/testing';

import { AssignedRoleService } from './assigned-role-service';

describe('AssignedRoleService', () => {
  let service: AssignedRoleService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AssignedRoleService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
