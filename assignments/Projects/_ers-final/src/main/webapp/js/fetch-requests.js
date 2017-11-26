
function fetchRequests()
{
    let xhttp = new XMLHttpRequest();
    
    xhttp.onreadystatechange = () => {
        
        if(xhttp.readyState === 4) {
            if(xhttp.status === 200) {
                let result = JSON.parse(xhttp.responseText);
                
                buildRequestTable(result);
            } else {
                //console.log('Failed to retrieve requested reimbursement data');
            }
        }
    }
    
    xhttp.open('GET', './fetch');
    xhttp.send();
}

let tableStrings = [
    [ 'Amount', 'Date Submitted', 'Date Resolved', 'Description', 'Type', 'Status' ],
    [ 'amount', 'submissionDate', 'resolutionDate', 'description', 'type', 'status' ]
];

let statusStrings = [
    ['ers-pending', 'ers-approved', 'ers-denied'],
    ['Pending', 'Approved', 'Denied']
];

let typeStrings = [
    'Lodging', 'Travel', 'Food', 'Other'
];

function buildRequestTable(results)
{
    let tableHolder = document.getElementById('table-container');
    document.getElementById('login-talker').remove();

    for(let i = 0; i < results.length; i++)
    {
        tableHolder.appendChild(createEntry(results[i], i));
    }
}

function createEntry(entry, id)
{
    let main = document.createElement('div');
    main.classList.add('card');
    main.classList.add('ers-clickable');
    main.id = `reimb-head-${id}`;

    let head = document.createElement('div');
    head.classList.add('card-header');
    head.onclick = () => {
        toggleDetails(id);
    }

    let headAmount = document.createElement('span');
    headAmount.classList.add('ers-amount');
    headAmount.innerText = '$ ' + entry.amount;
    head.appendChild(headAmount);

    let headType = document.createElement('span');
    headType.classList.add('ers-type-width');
    headType.innerText = typeStrings[entry.typeId-1];
    head.appendChild(headType);

    let headStatusDrop = document.createElement('span');
    headStatusDrop.classList.add('ers-float-right');
    head.appendChild(headStatusDrop);

    let headStatus = document.createElement('span');
    headStatus.classList.add(statusStrings[0][entry.statusId-1]);
    headStatus.innerText = statusStrings[1][entry.statusId-1];
    headStatusDrop.appendChild(headStatus);

    let headDropdown = document.createElement('span');
    headDropdown.id = `reimb-arrow-${id}`;
    headDropdown.classList.add('ers-drop-arrow');
    headStatusDrop.appendChild(headDropdown);

    let body = document.createElement('div');
    body.id = `reimb-body-${id}`;
    body.classList.add('card-body');
    body.classList.add('ers-hidden');

    let bodyDesc = document.createElement('div');
    bodyDesc.classList.add('ers-padding-bottom-20');
    bodyDesc.innerText = entry.description;

    let bodyResolver = document.createElement('div');
    bodyResolver.innerText = 'Resolver:\n' + entry.resolver;
    bodyResolver.classList.add('ers-float-right');
    bodyDesc.appendChild(bodyResolver);
    body.appendChild(bodyDesc);

    let bodyDates = document.createElement('div');
    body.appendChild(bodyDates);
        
    let dateCreated = document.createElement('span');
    dateCreated.classList.add('ers-inline-block');
    dateCreated.innerText = 'Submitted:\n' + entry.submissionDate;
    bodyDates.appendChild(dateCreated);

    let dateResolved = document.createElement('span');
    dateResolved.classList.add('ers-padding-left-8');
    dateResolved.classList.add('ers-inline-block');
    dateResolved.innerText = 'Resolved:\n' + entry.resolutionDate;
    bodyDates.appendChild(dateResolved);

    main.appendChild(head);
    main.appendChild(body);

    return main;
}

/*
<div class="card flashcard" *ngFor="let bar of candybars">
    <div class="card-header" (click)="toggle(bar)">
        <span class="candy-name">{{ bar.name }}</span>
        <span class="candy-rating"><span class="bolder">{{ bar.rating }}</span>/10</span>
    </div>
    <div class="card-body animated fadeIn" *ngIf="bar.show">
        <p class="card-text"> {{ bar.description }}</p>
        <button class="btn" (click)="remove(bar)">Remove</button>
    </div>
</div>
*/

function toggleDetails(id) {
    const eleToggle = document.getElementById(`reimb-body-${id}`);
    const eleOpen = document.getElementById(`reimb-arrow-${id}`);

    if(eleToggle.classList.contains('ers-hidden'))
    {
        eleToggle.classList.remove('ers-hidden');
        eleOpen.classList.remove('ers-drop-arrow');
        eleOpen.classList.add('ers-raise-arrow');
    }
    else
    {
        eleToggle.classList.add('ers-hidden');
        eleOpen.classList.remove('ers-raise-arrow');
        eleOpen.classList.add('ers-drop-arrow');
    }
}