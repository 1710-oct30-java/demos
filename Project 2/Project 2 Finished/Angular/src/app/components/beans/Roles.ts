export class Roles {
    roleNum: number;
    roles: Array<Object> = [
        { num: 1, name: 'DINER' },
        { num: 2, name: 'OWNER' }
    ];
    toNumber() {
        this.roleNum = +this.roleNum;
        console.log(this.roleNum);
    }
}
