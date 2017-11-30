function addelement(element, string, id) {
    let th = document.createElement(element);
    let content = document.createTextNode(string);
    th.appendChild(content);
    th.id = id;
    return th;
}

function sortResults(array, prop, asc) {
    array = array.sort(function (a, b) {
        if (asc) {
            return (a[prop] > b[prop]) ? 1 : ((a[prop] < b[prop]) ? -1 : 0);
        }
        else {
            return (b[prop] > a[prop]) ? 1 : ((b[prop] < a[prop]) ? -1 : 0);
        }
    });
}

function setModalHeader(reim)
{
    let modal = document.getElementById('header');
    switch (statuss.filter(i => i.id === reim.statusId)[0].name) {
        case ('pending'):
            modal.style.backgroundColor = '#BEE5EB'
            break;
        case ('approved'):
            modal.style.backgroundColor = '#C3E6CB'
            break;
        case ('denied'):
            modal.style.backgroundColor = '#F5C6CB'
            break;
        default:
            return;
    }
}
function setColor(Reim, tr) {
    switch (statuss.filter(i => i.id === Reim.statusId)[0].name) {
        case ('pending'):
            tr.className = 'table-info';
            break;
        case ('approved'):
            tr.className = 'table-success';
            break;
        case ('denied'):
            tr.className = 'table-danger';
            break;
        default:
            return;
    }

}
function sort() {
    let sortByThis = event.path[0].id;
    sortResults(Reims, sortByThis, true);
    clearTable();
    setReimTableContents(Reims);
}