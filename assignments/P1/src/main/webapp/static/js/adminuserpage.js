let Users = null;
let flaggedUsers = [];
let statuss = null;
let types = null;
let roles = null;
let changes = [];
let userHeaders = ['','ID','UserName','Password','FirstName','Lastname','Email','Role','Flagged'];
let userIds = ['','id','username','password','firstname','lastname','email','roleId','flag'];
document.addEventListener('DOMContentLoaded', loadstatuss);
document.addEventListener('DOMContentLoaded', loadTypes);
document.addEventListener('DOMContentLoaded', loadRoles);
function loadUsers() {
    console.log('loading Users');
    try {
        document.getElementById('amountButton').removeEventListener('click', clickedPending);
        document.getElementById('allButton').removeEventListener('click', clickedShowAllReim);
        document.getElementById('resolveButton').removeEventListener('click', clickedSubmitReims);
        document.getElementById('deleteButton').removeEventListener('click', clickedDeleteReims);
    } catch (err) { }
    document.getElementById('amountButton').addEventListener('click', clickedFlagged);
    document.getElementById('allButton').addEventListener('click', clickedShowAll);
    document.getElementById('resolveButton').addEventListener('click', clickedSubmitUsers);
    document.getElementById('deleteButton').addEventListener('click', clickedDeleteUser);
    document.getElementById('pageName').innerText = 'Users';
    $('#reimbursementsNav').removeClass('active');
    $('#usersNav').addClass('active');
    $('#pleaseWaitDialog').modal();
    getUsers();

}
function onlyGetUsers() {
    $.get('./admin/all')
        .done((resp) =>
    {
        console.log('got users');
        Users = JSON.parse(resp);
        console.log(Users);
        getReims();
    })
}
function getUsers() {
    console.log('gettingUsers');
    xmlhttp = new XMLHttpRequest();
    xmlhttp.onload = (resp) => {
        if (xmlhttp.status === 200) {
            console.log(resp);
            Users = JSON.parse(resp.target.response);
            sortResults(Users,'roleId',true);
            clearTable();
            setTableHeaders(userHeaders,userIds);
            setUserTableContents(Users);
            setUserSetButton();
            $('#pleaseWaitDialog').modal('hide');
        }
    }
    xmlhttp.open('GET', './admin/all');
    xmlhttp.send();

}

function setUserSetButton() {
    console.log('SettingUserSetButton');
    let button = document.getElementById('amountButton');
    let count = 0;
    flaggedUsers = []
    for (let i = 0; i < Users.length; i++) {
        console.log(Users[i].flag);
        if (Users[i].flag === 'Y') {
            count++;
            flaggedUsers.push(Users[i]);
        }
    }
    button.innerText = 'Flagged: ' + count;
}

function clickedFlagged() {
    console.log('clickedFlagged');
    clearTable();
    setTableHeaders(userHeaders,userIds);
    setUserTableContents(flaggedUsers);
}
function clickedShowAll() {
    console.log('clickedShowAll');
    clearTable();
    setTableHeaders(userHeaders,userIds);
    setUserTableContents(Users);
}

function clickedSubmitUsers() {
    console.log('clickedResolveUsers');
    $('#pleaseWaitDialog').modal();
    if(changes.length === 0)
    {
        $('#pleaseWaitDialog').modal('hide');
         return;
    }
    let len = changes.length;
    for(let i = 0; i < len; i++)
    {
        putUser(changes[i],len - i);
    }
}
function clickedDeleteUser() {
    console.log('clickedDeleteUser');
    $('#pleaseWaitDialog').modal();
    let numbers = getChecked();
    if (numbers.length === 0) 
    {
        $('#pleaseWaitDialog').modal('hide');
        return;
    }
    if (numbers.indexOf('1') !== -1) numbers.splice(numbers.indexOf('1'), 1);
    handleDeleteUsers(numbers);
}
function handleDeleteUsers(numbers) {
    console.log('deleting users');
    console.log(numbers);
    let len = numbers.length;
    for (let i = 0; i < len; i++) {
        let temp = numbers[i];
        User = Users.filter(i => i.id == temp)[0];
        deleteUser(User, len - i);
    }
}

function deleteUser(User, number) {
    xHttp = new XMLHttpRequest()
    xHttp.onload = (resp) => {
        if (xHttp.status !== 200) {
        }
        else {
            
            console.log('number is ' + number);
            if (number === 1) {
                getUsers();
            }
        }
    }
    xHttp.open('DELETE', './admin/deleteUser');
    xHttp.send(JSON.stringify(User));
}
function getChecked() {
    let clicked = document.getElementsByTagName('input');
    let numbers = [];
    for (let i = 0; i < clicked.length; i++) {
        if (clicked[i].checked) {
            numbers.push(clicked[i].name);
        }
    }
    return numbers;
}

function handleResolvedUsers(numbers) {
    for (let i = 0; i < numbers.length; i++) {
        let temp = numbers[i];
        User = Users.filter(i => i.id == temp)[0];
        User.flag = 'N';
        putUser(User, numbers.length - i);
    }

}

function putUser(User, number) {
    xHttp = new XMLHttpRequest();
    xHttp.onload = (resp) => {
        if (xHttp.status !== 200) {
        }
        else {
            changes.splice(number-1,1);
            console.log('number is ' + number);
            if (number === 1) {
                getUsers();
            }
        }
    }
    xHttp.open('PUT', './admin/putUser');
    xHttp.send(JSON.stringify(User));
}

function loadstatuss() {
    let xhttp = new XMLHttpRequest();
    xhttp.onload = (resp) => {
        if (xhttp.status === 200) {
            statuss = JSON.parse(resp.target.response);
            let drop = document.getElementById('statusM');
            for (let i = 0; i <statuss.length; i++) {
                let option = document.createElement('option');
                let content = document.createTextNode(statuss[i].name);
                option.name = statuss[i].id;
                option.appendChild(content);
                drop.appendChild(option);
            }
        }
    }
    xhttp.open('Get', './types/status');
    xhttp.send();
}
function loadTypes() {
    let xhttp = new XMLHttpRequest();
    xhttp.onload = (resp) => {
        if (xhttp.status === 200) {
            types = JSON.parse(resp.target.response);
        }
    }
    xhttp.open('Get', './types/types');
    xhttp.send();
}
function loadRoles() {
    let xhttp = new XMLHttpRequest();
    xhttp.onload = (resp) => {
        if (xhttp.status === 200) {
            console.log(resp);
            roles = JSON.parse(resp.target.response);
            let drop = document.getElementById('roleDropDown');
            for (let i = 0; i < roles.length; i++) {
                let option = document.createElement('option');
                let content = document.createTextNode(roles[i].name);
                option.id = roles[i].id;
                option.appendChild(content);
                drop.appendChild(option);
            }
        }
    }
    xhttp.open('Get', './types/roles');
    xhttp.send();
}
function populateUserModal() {
    let id = event.path[1].id;
    user = Users.filter(i => i.id == id)[0];
    document.getElementById('firstName').innerText = user.firstName;
    document.getElementById('lastName').innerText = user.lastName;
    document.getElementById('userName').innerText = user.username;
    document.getElementById('email1').innerText = user.email;
    setFlagged(user);
    setRole(user);
    let modal = document.getElementById('userHeader');
    switch (roles.filter(i => i.id === user.roleId)[0].name) {
        case ('admin'):
            modal.style.backgroundColor = '#616bf9'
            break;
        case ('finance manager'):
            modal.style.backgroundColor = '#ffffff'
            break;
        case ('employee'):
            modal.style.backgroundColor = '#ff666d'
            break;
        default:
            return;
    }
}
function setFlagged(user) {
    let options = document.getElementById('roleDropDown').children;
    for (option of options) {
        if(option.id == user.roleId)
        {
            option.setAttribute('selected','selected');
        }
        else
        {
            option.removeAttribute('selected','selected');
        }
    }
}

function setRole(user) {
    let options = document.getElementById('flaggedDropDown').children;
    for (option of options) {
        
        if(option.id == user.flag)
        {
            option.setAttribute('selected','selected');
        }
        else
        {
            option.removeAttribute('selected','selected');
        }
    }
}

function saveChanges()
{
    console.log('saving changes');
    let username = document.getElementById('userName').innerText;
    if(username === 'Admin')
    {
        alert('cannot modify Admin');
        return;
    }
    let flag = document.getElementById('flaggedDropDown').selectedOptions[0].id;
    let role = document.getElementById('roleDropDown').selectedOptions[0].id;
    let modifiedUser = changes.filter(i=> i.username === username)[0];
    console.log(modifiedUser);
    if(modifiedUser === undefined)
    {
        modifiedUser = Users.filter(i => i.username === username)[0];
    }
    else
    {
        changes.splice(changes.indexOf(modifiedUser),1);
    }
    modifiedUser.flag = flag;
    modifiedUser.roleId = role;
    console.log(modifiedUser);
    changes.push(modifiedUser);
    $('#Modal').modal('hide');
}

