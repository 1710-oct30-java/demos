import { Injectable } from "@angular/core";
import { Reimbursement } from "../../beans/Reimbursement";



@Injectable()
export class ReimbursementService { 
    reimbursements: Array<Reimbursement>;
}