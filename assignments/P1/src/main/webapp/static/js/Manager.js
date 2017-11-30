document.addEventListener('DOMContentLoaded', start);
let Reims = null;
let Users = null;
let Types = [];
let statuss = [];
let Me = null;
let flag = false;
function showPending() {
    console.log(flag);
    if(flag)
    {
        flag = !flag;
        let pending = Reims.filter(i => i.statusId == (statuss.filter(i => i.name === 'pending')[0].id));
        console.log(pending);
        clearTable();
        setPendingButton('All Pending', pending.length)
        setReimTableContents(pending);
        
    }
    else
    {
        flag = !flag;
        let pending = Reims.filter(i => (i.statusId == (statuss.filter(i => i.name === 'pending')[0].id) && i.author !== Me.id));
        console.log(pending);
        clearTable();
        setPendingButton('Not My Pending', pending.length)
        setReimTableContents(pending);
    }


}
function showMine() {
    let mine = Reims.filter(i => i.author === Me.id);
    clearTable();
    setReimTableContents(mine);
}
function showAll() {
    clearTable();
    setReimTableContents(Reims);
}


function addReim() {
    $('#pleaseWaitDialog').modal();
    let type = document.getElementById('typedropdown').selectedOptions[0].name;
    let amount = document.getElementById('amountinput').value;
    let description = document.getElementById('descriptiontextbox').value;
    let reim =
        {
            typeId: type,
            amount: amount,
            description: description,
        };
    let xhttp = new XMLHttpRequest();
    xhttp.onload = (resp) => {
        if (xhttp.status !== 500) {
            console.log('response is ');
            console.log(resp);
            let reimId = JSON.parse(resp.target.response);
            console.log(reimId);

            if (reimId)
                sendFile(reimId);
            else {
                clearTable();
                getReims();
            }
        }
        else {
            alert('fail');
        }
    }
    xhttp.open('POST', './submit/newreim');
    xhttp.send(JSON.stringify(reim));
}
function sendFile(reimId) {
    let fileInput = document.getElementById('fileinput');
    let file = fileInput.files[0];
    let formData = new FormData();
    console.log(file);
    formData.append('receipt', file, reimId.number);
    let xhr = new XMLHttpRequest();
    xhr.open('POST', './file');
    xhr.onload = (resp) => {
        if (xhr.status !== 500) {
            $('#newReimModal').modal('hide');
            clearTable();
            getReims();
        } else {
            alert('An error occurred!');
        }
    }
    xhr.send(formData);
}

function clearTable() {
    console.log('clearingTable');
    let tableBody = document.getElementById('tableBody');
    tableBody.innerHTML = '';
}

function populateDropDown() {
    console.log('getting drop down');
    let xhttp = new XMLHttpRequest();
    xhttp.onload = (resp) => {
        if (xhttp.status === 200) {
            Types = JSON.parse(resp.target.response);
            let drop = document.getElementById('typedropdown');
            for (let i = 0; i < Types.length; i++) {
                let option = document.createElement('option');
                let content = document.createTextNode(Types[i].name);
                option.name = Types[i].id;
                option.appendChild(content);
                drop.appendChild(option);
            }
        }
        else {
            alert('fail');
        }
    }
    xhttp.open('Get', './types/types');
    xhttp.send();
}

function sort() {
    let sortByThis = event.path[0].id;
    sortResults(Reims, sortByThis, true);
    clearTable();
    setReimTableContents(Reims);
}


function populateModal() {
    if (event.path[0].class == 'checkbox') return;
    let id = event.path[1].id;
    let reim = Reims.filter(i => i.id == id)[0];
    let author = reim.author;
    let resolver = reim.resolver;
    document.getElementById('idM').innerText = reim.id;
    document.getElementById('typeM').innerText = reim.typeId;
    document.getElementById('amountM').innerText = reim.amount;
    setStatus(reim.statusId, author);
    document.getElementById('authorM').innerText = Users.filter(i => i.id == author)[0].username;
    if (author !== resolver) {
        document.getElementById('resolverM').innerText = Users.filter(i => i.id == resolver)[0].username;
    }
    document.getElementById('submittedM').innerText = reim.submitted;
    document.getElementById('resolvedM').innerText = reim.resolved;
    document.getElementById('receiptM').innerText = reim.receipt;
    document.getElementById('descriptionM').innerText = reim.description;
    setModalHeader(reim);
    handleReceipt(reim);

}
function setStatus(num, author) {
    if (author === Me.id || num !== (statuss.filter(i => i.name === 'pending')[0].id))
    {
        console.log('disabling');
        $('#statusM').prop('disabled', true); 
        $('#saveButton').prop('disabled',true);
    }
    else{

    $('#statusM').prop('disabled', false); 
    $('#saveButton').prop('disabled',false);
    }
    console.log('setting status')
    let options = document.getElementById('statusM').children;
    console.log(num);
    for (option of options) {
        console.log(option.name);
        if (option.name == num) {
            console.log(option.name + ' set as selected');
            option.setAttribute('selected', 'selected');
        }
        else {
            console.log(option.name + ' set as not selected');
            option.removeAttribute('selected', 'selected');
        }
    }
}
function handleReceipt(reim) {
    let id = document.getElementById('idM').innerText;
    let receipt = document.getElementById('receiptM');
    if (reim.hasFile) {
        receipt.innerHTML = `<a href = './file/${id}'  target = '_blank'>Fetch Receipt</a>`;
    }
    else {
        receipt.innerText = 'No receipt';
    }
}

function setReimTableContents(Reims) {
    console.log('SettingReimTableContents');
    let tablebody = document.getElementById('tableBody');
    for (let i = 0; i < Reims.length; i++) {
        let tr = document.createElement('tr');
        tr.id = Reims[i].id;
        tr.setAttribute('data-toggle', 'modal');
        tr.setAttribute('data-target', '#reimbursementInfo');
        setColor(Reims[i], tr);
        tr.onclick = populateModal;
        tr.appendChild(addelement('td', Reims[i].id));
        tr.appendChild(addelement('td', Reims[i].amount));
        tr.appendChild(addelement('td', Reims[i].submitted));
        tr.appendChild(addelement('td', Reims[i].resolved));
        tr.appendChild(addelement('td', Types[Reims[i].typeId - 1].name));
        tr.appendChild(addelement('td', statuss[Reims[i].statusId - 1].name));
        tablebody.appendChild(tr);
    }
}

function submitChanges(Reim, number) {
    $('#pleaseWaitDialog').modal();
    let id = document.getElementById('idM').innerText;
    let status = document.getElementById('statusM').selectedOptions[0].name;
    let modifiedReim = Reims.filter(i => i.id == id)[0];
    modifiedReim.statusId = status;
    xHttp = new XMLHttpRequest();
    xHttp.onload = (resp) => {
        if (xHttp.status === 200) {
            $('#reimbursementInfo').modal('hide');
            getReims();
        }
    }
    xHttp.open('PUT', './manager/putReim');
    xHttp.send(JSON.stringify(modifiedReim));
}

function getReims() {
    $.get('./manager/reims')
        .done((resp) => {
            Reims = JSON.parse(resp);
            clearTable();
            sortResults(Reims, 'id', true);
            setReimTableContents(Reims);
            setPendingButton('All Pending', Reims.filter(i => i.statusId == (statuss.filter(i => i.name === 'pending')[0].id)).length);
            $('#pleaseWaitDialog').modal('hide');
        })
}

function getMe() {
    $.get('./manager/me')
        .done((resp) => {
            Me = JSON.parse(resp);
            getUsers();
        })
}

function getUsers() {
    $.get('./manager/users')
        .done((resp) => {
            Users = JSON.parse(resp);
            getTypes();
        })
}

function getTypes() {
    $.get('./types/types')
        .done((resp) => {
            Types = JSON.parse(resp);
            let drop = document.getElementById('typedropdown');
            for (let i = 0; i < Types.length; i++) {
                let option = document.createElement('option');
                let content = document.createTextNode(Types[i].name);
                option.name = Types[i].id;
                option.appendChild(content);
                drop.appendChild(option);
            }
            getStatuss();
        })
}

function getStatuss() {
    $.get('./types/status')
        .done((resp) => {
            statuss = JSON.parse(resp);
            let drop = document.getElementById('statusM');
            for (let i = 0; i < statuss.length; i++) {
                let option = document.createElement('option');
                let content = document.createTextNode(statuss[i].name);
                option.name = statuss[i].id;
                option.appendChild(content);
                drop.appendChild(option);
            }
            getReims();
        })
}

function start() {
    $('#pleaseWaitDialog').modal();
    getMe();

}

function setPendingButton(string, count) {
    console.log(count);
    console.log('SettingReimSetButton');
    let button = document.getElementById('pendingButton');
    button.innerText = string + ': ' + count;
}
