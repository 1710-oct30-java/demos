function clearTable() {
    console.log('clearingTable');
    let tableHead = document.getElementById('tableHead');
    tableHead.innerHTML = '';
    let tableBody = document.getElementById('tableBody');
    tableBody.innerHTML = '';
}
function setTableHeaders(headers, ids) {
    console.log('settingTableHeaders');
    let tablehead = document.getElementById('tableHead');
    let tr = document.createElement('tr');
    tr.onclick = sort;
    for (let i = 0; i < headers.length; i++) {
        tr.appendChild(addelement('th', headers[i], ids[i]));
    }
    tablehead.appendChild(tr);
}
function setReimTableContents(Reims) {
    console.log('SettingReimTableContents');
    let tablebody = document.getElementById('tableBody');
    console.log(Reims.length)
    for (let i = 0; i < Reims.length; i++) {
        let tr = document.createElement('tr');
        tr.id = Reims[i].id;
        tr.setAttribute('data-toggle', 'modal');
        tr.setAttribute('data-target', '#reimbursementInfo');
        tr.onclick = populateModal;
        tr.appendChild(addCheckBox(Reims[i].id));
        tr.appendChild(addelement('td', Reims[i].id, ''));
        tr.appendChild(addelement('td', Reims[i].amount, ''));
        tr.appendChild(addelement('td', Reims[i].submitted, ''));
        tr.appendChild(addelement('td', Reims[i].resolved, ''));
        let author = Reims[i].author;
        let resolver = Reims[i].resolver;
        tr.appendChild(addelement('td', Users.filter(i => i.id == author)[0].username));
        if (author !== resolver) {
            tr.appendChild(addelement('td', Users.filter(i => i.id == resolver)[0].username));
        }
        else {
            tr.appendChild(addelement('td', null));
        }
        tr.appendChild(addelement('td', statuss[Reims[i].statusId - 1].name));
        tr.appendChild(addelement('td', types[Reims[i].typeId - 1].name));
        setColor(Reims[i],tr);
        tablebody.appendChild(tr);
    }
}
function addCheckBox(number) {
    let input = document.createElement('input');
    input.type = 'checkbox';
    input.name = number;
    input.class = 'checkbox';
    input.onclick = stop;
    return input;
}
function setUserTableContents(Users) {
    console.log('SettingUserTableContents');
    let tablebody = document.getElementById('tableBody');
    for (let i = 0; i < Users.length; i++) {
        let tr = document.createElement('tr');
        tr.appendChild(addCheckBox(Users[i].id));
        tr.id = Users[i].id;
        tr.setAttribute('data-toggle', 'modal');
        tr.setAttribute('data-target', '#Modal');
        tr.onclick = populateUserModal;
        for (let key of Object.keys(Users[i])) {
            tr.appendChild(addelement('td', Users[i][key], ''));
        }
        let roleId = Users[i].roleId;
        console.log(roleId);
        switch (roles.filter(i => i.id === roleId)[0].name) {
            case ('admin'):
                tr.style.backgroundColor = '#616bf9'
                break;
            case ('finance manager'):
                tr.style.backgroundColor = '#ffffff'
                break;
            case ('employee'):
                tr.style.backgroundColor = '#ff666d'
                break;
            default:
                return;
        }
        tablebody.appendChild(tr);
    }
}
