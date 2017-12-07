import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HttpTestsComponent } from './http-tests.component';

describe('HttpTestsComponent', () => {
  let component: HttpTestsComponent;
  let fixture: ComponentFixture<HttpTestsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HttpTestsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HttpTestsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
