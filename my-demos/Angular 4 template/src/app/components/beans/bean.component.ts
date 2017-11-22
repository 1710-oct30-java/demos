import { Component,  OnInit, Input } from '@angular/core';
import { Bean } from '../../beans/Bean';
@Component({
  selector: 'app-bean',
  templateUrl: './bean.component.html',
  styleUrls: ['./bean.component.css']
})
export class BeanComponent implements OnInit {
  @Input()
  in: Bean;
  constructor() {
  }
  ngOnInit() {
  }
}
