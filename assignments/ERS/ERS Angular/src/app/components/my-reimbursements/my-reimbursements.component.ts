import { Component,  OnInit, Inject } from '@angular/core';
import { Http } from "@angular/http";
import { Reimbursement } from '../../beans/Reimbursement';
import { LoginService } from '../login/login.service';

@Component({
  selector: 'app-my-reimbursements',
  templateUrl: './my-reimbursements.component.html',
  styleUrls: ['./my-reimbursements.component.css'],
})

export class ReimbursementComponent implements OnInit {

  reimbursements: Array<Reimbursement>;
  checkedReimbursements: Array<Reimbursement>;
  noneSelected:boolean;

  constructor(@Inject(Http) public http: Http, @Inject(LoginService) private ls: LoginService) {

  }

  ngOnInit() {
      
      this.http.get('http://localhost:8080/ERS/reimbursements/',  { withCredentials: true }).subscribe(
          (successResponse) => {
              this.reimbursements = successResponse.json();
              this.reimbursements.sort((r1, r2) => r1.authorId - r2.authorId);
              
      },
          (failResponse) => {
              alert('failed');
      });

      
  }

  approve(id) {
    
    for (var i = 0; i < this.reimbursements.length; i++) {
      var re = <any>this.reimbursements[i];


      if (re.reimbursementId == id) {
        re.statusId = 2;
        this.http.put('http://localhost:8080/ERS/reimbursements/', JSON.stringify(re)).subscribe(
          (successResponse) => {
          
              
      },
          (failResponse) => {
              alert('failed');
      });
      }
      

    }


    

  }

  deny(id) {
    for (var i = 0; i < this.reimbursements.length; i++) {
      var re = <any>this.reimbursements[i];


      if (re.reimbursementId == id) {
        re.statusId = 3;
        this.http.put('http://localhost:8080/ERS/reimbursements/', JSON.stringify(re)).subscribe(
          (successResponse) => {
          
              
      },
          (failResponse) => {
              alert('failed');
      });
      }
      

    }


  }


      
}

    