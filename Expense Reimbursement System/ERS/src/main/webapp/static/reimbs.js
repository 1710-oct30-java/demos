function getReimbs() {

    let xhttp = new XMLHttpRequest();
    console.log('get json called');
    xhttp.onload = (resp) => {
        if (xhttp.status === 200) {
            let jsonReimbs = JSON.parse(xhttp.responseText);

            for (let i = 0; i < jsonReimbs.length; i++) {
                //create tr and td elements
                let newElement = document.createElement('tr');
                let idTd = document.createElement('td');
                let amountTd = document.createElement('td');
                let submittedTd = document.createElement('td');
                let resolvedTd = document.createElement('td');
                let descriptionTd = document.createElement('td');
                let authorTd = document.createElement('td');
                let resolverTd = document.createElement('td');
                let statusIdTd = document.createElement('td');
                let typeIdTd = document.createElement('td');

                // get the row from json
                idTd.innerText = jsonReimbs[i].id;// get from json object;
                amountTd.innerText = `$${jsonReimbs[i].amount.toFixed(2)}`; // get from json object
                // timeSubmittedTd.innerText = jsonReimbs[i].timeSubmitted;// get from json object;
                let formattedTime = new Date(jsonReimbs[i].submitted);
                submittedTd.innerText = `${formattedTime.getMonth()}/${formattedTime.getDate()}/${formattedTime.getFullYear()} ${formattedTime.getHours()}\:${formattedTime.getMinutes()}`;

                // timeResolvedTd.innerText = jsonReimbs[i].timeResolved;// get from json object;
                let formattedTimeRes = new Date(jsonReimbs[i].resolved);
                if (jsonReimbs[i].resolved == null) {
                    resolvedTd.innerText = '';
                } else {
                    console.log(jsonReimbs[i].resolved);
                    resolvedTd.innerText = `${formattedTimeRes.getMonth()}/${formattedTimeRes.getDate()}/${formattedTimeRes.getFullYear()} ${formattedTimeRes.getHours()}\:${formattedTimeRes.getMinutes()}`;
                }

                descriptionTd.innerText = jsonReimbs[i].description;// get from json object;
                authorTd.innerText = jsonReimbs[i].author;// get from json object;
                if (jsonReimbs[i].resolver == 0) {
                    resolverTd.innerText = null;
                } else {
                    resolverTd.innerText = jsonReimbs[i].resolver;// get from json object;
                }
                // statusIdTd.innerText = jsonReimbs[i].statusId;// get from json object;
                if (jsonReimbs[i].statusId == 1) statusIdTd.innerText = 'Pending';
                else if (jsonReimbs[i].statusId == 2) statusIdTd.innerText = 'Approved';
                else if (jsonReimbs[i].statusId == 3) statusIdTd.innerText = 'Denied';
                else statusIdTd.innerText = null;

                // typeIdTd.innerText = jsonReimbs[i].typeId;// get from json object;
                if (jsonReimbs[i].typeId == 1) typeIdTd.innerText = 'Lodging';
                else if (jsonReimbs[i].typeId == 2) typeIdTd.innerText = 'Travel';
                else if (jsonReimbs[i].typeId == 3) typeIdTd.innerText = 'Food';
                else if (jsonReimbs[i].typeId == 4) typeIdTd.innerText = 'Other';
                else statusIdTd.innerText = null;

                // append the json row to the table
                newElement.appendChild(idTd);
                newElement.appendChild(amountTd);
                newElement.appendChild(submittedTd);
                newElement.appendChild(resolvedTd);
                newElement.appendChild(descriptionTd);
                newElement.appendChild(authorTd);
                newElement.appendChild(resolverTd);
                newElement.appendChild(statusIdTd);
                newElement.appendChild(typeIdTd);

                // add i'th element to the table body
                document.getElementById('ers-table-body').appendChild(newElement);
            } // end for loop
        }
        else {
            console.log('failed to load json')
        }
    }
    xhttp.open('GET', `../reimbs/all`);
    xhttp.send();
}