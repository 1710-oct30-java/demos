document.addEventListener('DOMContentLoaded', loadReims);
let Reims = null;
let Pending = [];
let reimChanges = [];
let reimHeaders = ['','ID','Amount','Submitted','Resolved','Author','Resolver','Status','Type'];
let reimIds = ['','id','amount','submitted','resolved','author','resolver','statusId','typeId'];
$('#reimbursementInfo').on('hidden.bs.modal', function () {
    $(this).find('form').trigger('reset');
})
function loadReims() {
    console.log('loading Reims');
    $('#pleaseWaitDialog').modal();
    onlyGetUsers();
}
function getReims()
{
    $.get('./admin/reim') 
        .done( (resp) =>
    {
        try {
            document.getElementById('amountButton').removeEventListener('click', clickedFlagged);
            document.getElementById('allButton').removeEventListener('click', clickedShowAll);
            document.getElementById('resolveButton').removeEventListener('click', clickedSubmitUsers);
            document.getElementById('deleteButton').removeEventListener('click', clickedDeleteUser);
        } catch (err) { console.log('error?') }
        document.getElementById('amountButton').addEventListener('click', clickedPending);
        document.getElementById('allButton').addEventListener('click', clickedShowAllReim);
        document.getElementById('resolveButton').addEventListener('click', clickedSubmitReims);
        document.getElementById('deleteButton').addEventListener('click', clickedDeleteReims);
        document.getElementById('pageName').innerText = 'Reimbursements';
        $('#reimbursementsNav').addClass('active');
        $('#usersNav').removeClass('active');
        $('#pleaseWaitDialog').modal();
        //console.log(resp);
        Reims = JSON.parse(resp);
        //console.log(Reims);
        clearTable();
        setTableHeaders(reimHeaders, reimIds);
        setReimTableContents(Reims);
        setReimSetButton();
        $('#pleaseWaitDialog').modal('hide');

    })
}
function stop()
{
    event.stopPropagation();
}

function setReimSetButton() {
    console.log('SettingReimSetButton');
    let button = document.getElementById('amountButton');
    let count = 0;
    Pending = [];
    let pendingNum = statuss.filter(i => i.name === 'pending')[0].id;
    for (let i = 0; i < Reims.length; i++) {
        if (Number(Reims[i].statusId) === pendingNum) {
            count++;
            Pending.push(Reims[i]);
        }
    }
    button.innerText = 'Pending: ' + count;
}

function clickedPending() {
    console.log('clickedPending');
    clearTable();
    setTableHeaders(reimHeaders, reimIds);
    setReimTableContents(Pending);
}

function clickedShowAllReim() {
    console.log('clickedShowAll');
    clearTable();
    setTableHeaders(reimHeaders, reimIds);
    setReimTableContents(Reims);
}

function sortAdmin(){
    let sortByThis = event.path[0].id;
    console.log('Sorting by: ' + sortByThis);
    if(document.getElementById('pageName').innerText === 'Reimbursements')
    {
        sortResults(Reims,sortByThis,true);
        clearTable();
        setTableHeaders(reimHeaders,reimIds);
        setReimTableContents(Reims);
    }
    else
    {
        sortResults(Users, sortByThis,true);
        clearTable();
        setTableHeaders(userHeaders,userIds);
        setUserTableContents(Users);
    }
    

}

function populateModal(){
    if(event.path[0].class == 'checkbox') 
    {
        $('#pleaseWaitDialog').modal('hide');
        return;
    }
    let id = event.path[1].id;
    let reim = Reims.filter(i => i.id == id)[0];
    let author = reim.author;
    let resolver = reim.resolver;
    document.getElementById('idM').innerText = reim.id;
    document.getElementById('typeM').innerText = reim.typeId;
    document.getElementById('amountM').innerText = reim.amount;
    setStatus(reim.statusId);
    document.getElementById('authorM').innerText = Users.filter(i => i.id == author)[0].username;
    if(author !== resolver)
    {
        document.getElementById('resolverM').innerText = Users.filter(i => i.id == resolver)[0].username;
    }
    document.getElementById('submittedM').innerText = reim.submitted;
    document.getElementById('resolvedM').innerText = reim.resolved;
    document.getElementById('receiptM').innerText = reim.receipt;
    document.getElementById('descriptionM').innerText = reim.description;
    setModalHeader(reim);
    handleReceipt(reim);
}

function handleReceipt(reim){
    let id =document.getElementById('idM').innerText;
    let receipt = document.getElementById('receiptM');
    if(reim.hasFile)
    {
        receipt.innerHTML = `<a href = './file/${id}'  target = '_blank'>Fetch Receipt</a>`;
    }
    else
    {
        receipt.innerText = 'No receipt';
    }
}

function setStatus(num) {
    console.log('setting status')
    let options = document.getElementById('statusM').children;
    console.log(num);
    for (option of options) {
        console.log(option.name);
        if(option.name == num)
        {
            console.log(option.name + ' set as selected');
            option.setAttribute('selected','selected');
        }
        else
        {
            console.log(option.name + ' set as not selected');
            option.removeAttribute('selected','selected');
        }
    }
}

function clickedSubmitReims()
{
    console.log('clickedSubmitReims');
    $('#pleaseWaitDialog').modal();
    console.log(reimChanges);
    if(reimChanges.length === 0 )
    {
        $('#pleaseWaitDialog').modal('hide');
        return;
    }
    let len = reimChanges.length;
    for(let i = 0; i < len; i++)
    {
        putReim(reimChanges[i],len - i);
    }
}

function clickedDeleteReims(){
    console.log('clickedDeleteReims');
    $('#pleaseWaitDialog').modal();
    let number = getChecked();
    if(number.length === 0) 
    {
        $('#pleaseWaitDialog').modal('hide');
        return;
    }
    let len = number.length;
    for(let i = 0; i < len; i++)
    {
        let temp = number[i];
        Reim = Reims.filter(i=>i.id == temp)[0];
        deleteReim(Reim,len - i);
    }
}

function deleteReim(Reim,number)
{
    xHttp = new XMLHttpRequest()
    xHttp.onload = (resp) => {
        if (xHttp.status !== 200) {
        }
        else {
            
            console.log('number is ' + number);
            if (number === 1) {
                getReims();
                $('#pleaseWaitDialog').modal('hide');
            }
        }
    }
    xHttp.open('DELETE', './admin/deleteReim');
    xHttp.send(JSON.stringify(Reim));
}
function saveChangesReim()
{
    let id = document.getElementById('idM').innerText;
    let status = document.getElementById('statusM').selectedOptions[0].name;
    console.log('STATUS: ' + status);
    let modifiedReim = reimChanges.filter(i=>i.id === id)[0];
    if(modifiedReim === undefined)
    {
        modifiedReim = Reims.filter(i => i.id == id)[0];
    }
    else
    {
        modifiedReim.splice(reimChanges.indexOf(modifiedReim),1);
    }
    //#f6ff7f
    document.getElementById(modifiedReim.id).style.background= '#f6ff7f';
    modifiedReim.statusId = status;
    reimChanges.push(modifiedReim);
    $('#reimbursementInfo').modal('hide');
}

function putReim(Reim,number)
{
    xHttp = new XMLHttpRequest();
    xHttp.onload = (resp) => {
        if (xHttp.status === 200) {
            reimChanges.splice(number,1);
            console.log('number is ' + number);
            if (number === 1) {
                getReims();
                $('#pleaseWaitDialog').modal('hide');
            }
        }
    }
    xHttp.open('PUT', './admin/putReim');
    xHttp.send(JSON.stringify(Reim));
}