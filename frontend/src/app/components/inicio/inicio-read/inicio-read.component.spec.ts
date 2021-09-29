import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InicioReadComponent } from './inicio-read.component';

describe('InicioReadComponent', () => {
  let component: InicioReadComponent;
  let fixture: ComponentFixture<InicioReadComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InicioReadComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InicioReadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
