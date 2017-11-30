document.addEventListener('DOMContentLoaded', loadReims);
document.addEventListener('DOMContentLoaded', populateDropDown);
$('#newReimModal').on('hidden.bs.modal', function () {
    $(this).find('form').trigger('reset');
})
xmlhttp = new XMLHttpRequest();
let types = null;
let Reims = null;
let me = null;
let statuss = null;

function loadReims() {
    $('#pleaseWaitDialog').modal();
    getMe();
    loadstatuss();
}
function getMe()
{
    $.get('./user/me')
        .done ( (resp) =>
    {
        me = JSON.parse(resp);
        document.getElementById('name').innerText = 'Welcome ' + me.firstName + ' ' + me.lastName;
        getReims();
    })
        .fail( () =>
        {
            console.log('failed to grab user');
        })
}
function getReims() {
    console.log('getting Reims');
    xmlhttp.onload = (resp) => {
        if (xmlhttp.status === 200) {
            Reims = JSON.parse(resp.target.response);
            clearTable();
            sortResults(Reims, 'id', true);
            setReimTableContents(Reims);
            $('#pleaseWaitDialog').modal('hide');
        }
        else {
            alert('fail');
        }
    }
    xmlhttp.open('Get', './user/myReims');
    xmlhttp.send();
}

function clearTable() {
    console.log('clearingTable');
    let tableBody = document.getElementById('tableBody');
    tableBody.innerHTML = '';
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
        tr.appendChild(addelement('td', types[Reims[i].typeId - 1].name));
        tr.appendChild(addelement('td', statuss[Reims[i].statusId - 1].name));
        tablebody.appendChild(tr);
    }
}



function populateDropDown() {
    console.log('getting drop down');
    let xhttp = new XMLHttpRequest();
    xhttp.onload = (resp) => {
        if (xhttp.status === 200) {
            types = JSON.parse(resp.target.response);
            let drop = document.getElementById('typedropdown');
            for (let i = 0; i < types.length; i++) {
                let option = document.createElement('option');
                let content = document.createTextNode(types[i].name);
                option.name = types[i].id;
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

function sendNewReim() {
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
            let reimId = JSON.parse(resp.target.response);
            if(reimId)
                sendFile(reimId);
            else
            {
            clearTable();
            getReims();
            $('#pleaseWaitDialog').modal('hide');
            }
        }
        else {
            alert('fail');
        }
    }
    xhttp.open('POST', './submit/newreim');
    xhttp.send(JSON.stringify(reim));
}
function sendFile(reimId){
    let fileInput = document.getElementById('fileinput');
    let file = fileInput.files[0];
    let formData = new FormData();
    console.log(file);
    formData.append('receipt',file, reimId.number);
    let xhr = new XMLHttpRequest();
    xhr.open('POST', './file');
    xhr.onload = (resp) => {
        if(xhr.status !== 500)
        {
            $('#newReimModal').modal('hide');
            clearTable();
            getReims();
            $('#pleaseWaitDialog').modal('hide');
        } else{
            alert('An error occurred!');
        }
    }
    xhr.send(formData);
}
function loadstatuss() {
    let xhttp = new XMLHttpRequest();
    xhttp.onload = (resp) => {
        if (xhttp.status === 200) {
            statuss = JSON.parse(resp.target.response);
        }
    }
    xhttp.open('Get', './types/status');
    xhttp.send();
}



function populateModal() {

    let id = event.path[1].id;
    let reim = Reims.filter(i => i.id == id)[0];
    document.getElementById('typeM').innerText = types[reim.typeId - 1].name;
    document.getElementById('amountM').innerText = reim.amount;
    document.getElementById('statusM').innerText = statuss[reim.statusId - 1].name;
    document.getElementById('authorM').innerText = 'you';
    if(reim.resolver !== me.id)
    {
        document.getElementById('resolverM').innerText = reim.resolver;
    }
    document.getElementById('submittedM').innerText = reim.submitted;
    document.getElementById('resolvedM').innerText = reim.resolved;
    document.getElementById('receiptM').innerText = reim.receipt;
    document.getElementById('descriptionM').innerText = reim.description;
    document.getElementById('receiptM').innerText = (reim.hasFile ? 'File Submitted' : 'No File Submitted');
    setModalHeader(reim);
}