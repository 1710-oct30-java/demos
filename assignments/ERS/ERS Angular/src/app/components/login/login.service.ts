import { Injectable } from "@angular/core";
import { User } from "../../beans/User";


@Injectable()
export class LoginService { 
    currentUser = new User("N/A");
    allUsers: Array<User>;
}