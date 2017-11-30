import {Pipe, PipeTransform, Inject} from '@angular/core'
import { LoginService } from './components/login/login.service';

@Pipe({
    name: 'employee'
})

export class EmployeePipe implements PipeTransform {
    constructor(@Inject(LoginService) private ls: LoginService) {

    }

    transform(employeeId) {
        for (var i = 0; i < this.ls.allUsers.length; i++) {
            var emp = this.ls.allUsers[i];
            
            if (emp.userId == employeeId) {
                return emp.firstName + " " + emp.lastName;
            }
        }
    }
    
}