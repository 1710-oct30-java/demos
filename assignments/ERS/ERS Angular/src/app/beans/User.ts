export class User {
    userId: number;
    username: string;
    password: string;
    firstName: string;
    lastName: string;
    email: string;
    roleId: number;

    constructor(username: string) {
        this.username = username;
        this.userId = 0;
        this.password = '';
        this.firstName = '';
        this.lastName ='';
        this.email = '';
        this.roleId = 0;
    }
}