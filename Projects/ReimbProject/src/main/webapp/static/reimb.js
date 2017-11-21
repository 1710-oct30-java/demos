window.onload = () =>
{
    document.getElementById('rowEntry').innerHTML =
    `<tr>
        <th scope="row">1</th>
        <td>Mark</td>
        <td>Otto</td>
        <td>@mdo</td>
    </tr>`
}


function insert_Row()
{
var x=document.getElementById('reimbTable').insertRow(-1);
var y = x.insertCell(0);
var z = x.insertCell(1);
y.innerHTML="New Cell1";
z.innerHTML="New Cell2";
}