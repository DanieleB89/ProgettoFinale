import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PaginaprincipaleComponent } from './paginaprincipale.component';

describe('PaginaprincipaleComponent', () => {
  let component: PaginaprincipaleComponent;
  let fixture: ComponentFixture<PaginaprincipaleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PaginaprincipaleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PaginaprincipaleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
