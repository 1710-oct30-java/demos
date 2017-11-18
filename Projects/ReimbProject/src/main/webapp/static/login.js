console.log("script started");

function clickedHello()
{
    console.log('Hello Clicked');
}

function removeHello()
{
    document.getElementById("div1").remove();
    console.log('removed');
}

document.getElementById('dummy').innerHTML += 
`
<button id="dangerbutton" type="button" class="btn btn-danger">Danger</button>
`

document.getElementById('dangerbutton').addEventListener('click', ()=> {
    document.getElementById('dangerbutton').remove();
})