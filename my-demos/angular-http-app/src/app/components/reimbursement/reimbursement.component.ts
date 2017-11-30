import { Component,  OnInit, Input } from '@angular/core';
import { Reimbursement } from '../beans/reimbursement';
@Component({
  selector: 'app-reimbursement',
  templateUrl: './reimbursement.component.html',
  styleUrls: ['./reimbursement.component.css']
})
export class ReimbursementComponent implements OnInit {
  @Input()
  in: Reimbursement;


  constructor() {
  }
  ngOnInit() {
  }
}
