import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DistrictsDialogComponent } from './districts-dialog.component';

describe('DistrictsDialogComponent', () => {
  let component: DistrictsDialogComponent;
  let fixture: ComponentFixture<DistrictsDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DistrictsDialogComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DistrictsDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
