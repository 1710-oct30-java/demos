export class User {

    userId: number;
    username: string;
    password: string;
    firstName: string;
    lastName: string;
    email: string;
    roleId: number;

    constructor() {
    }

    public static isNull(user: User): boolean {
        return user.username === null &&
            user.password === null &&
            user.firstName === null &&
            user.lastName === null;
    }
}
