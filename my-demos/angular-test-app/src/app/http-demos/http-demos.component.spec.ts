import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HttpDemosComponent } from './http-demos.component';

describe('HttpDemosComponent', () => {
  let component: HttpDemosComponent;
  let fixture: ComponentFixture<HttpDemosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HttpDemosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HttpDemosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
