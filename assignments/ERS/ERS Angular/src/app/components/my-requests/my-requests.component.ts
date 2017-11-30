import { Component,  OnInit, Inject } from '@angular/core';
import { Http } from "@angular/http";
import { Reimbursement } from '../../beans/Reimbursement';
import { LoginService } from '../login/login.service';

@Component({
  selector: 'app-my-requests',
  templateUrl: './my-requests.component.html',
  styleUrls: ['./my-requests.component.css'],
})

export class RequestsComponent implements OnInit {

  reimbursements: Array<Reimbursement>;
  checkedReimbursements: Array<Reimbursement>;
  showingMenu = false;


  constructor(@Inject(Http) public http: Http, @Inject(LoginService) private ls: LoginService) {

  }

  ngOnInit() {
      
      this.http.get('http://localhost:8080/ERS/reimbursements/',  { withCredentials: true }).subscribe(
          (successResponse) => {
              this.reimbursements = successResponse.json();
              this.reimbursements = this.reimbursements.filter((reimb) => reimb.authorId == this.ls.currentUser.userId);
              
      },
          (failResponse) => {
              alert('failed');
      });

      
  }

  showMenu() {
    this.showingMenu = !this.showingMenu;
  }

  submit() {
    this.showingMenu = false;
    let amountField = <HTMLInputElement>document.getElementById("amount");
    let amount = parseFloat(amountField.value);
    let descriptionField = <HTMLInputElement>document.getElementById("description");
    let description = descriptionField.value;
    let typeField = <HTMLInputElement>document.getElementById("type");
    let type = parseInt(typeField.value);

    if (isNaN(amount) || isNaN(type)) {
        this.invalidInput();
        return;
    }

    let reim = new Reimbursement();
    reim.reimbursementAmount = amount;
    reim.description = description;
    reim.typeId = type;
    reim.authorId = this.ls.currentUser.userId;
    reim.statusId = 1;

    this.addReimbursement(reim);
  }

  invalidInput() {
      alert("Invalid input.");
  }
  
  addReimbursement(re: Reimbursement) {
      this.http.post('http://localhost:8080/ERS/reimbursements/', JSON.stringify(re)).subscribe(
        (successResponse) => {
        
            
    },
        (failResponse) => {
            alert('failed');
    });
    }
  
}

    