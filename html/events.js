console.log("script started");

function outerClick() {
    console.log("container clicked");
}

function helloClicked(event) {
    console.log("clicked");
    event.stopPropagation();
}

function removeOuter() {
    document.getElementById('outer').remove();
    console.log(this);
}

document.getElementById('outer').innerHTML += `
<div id="newElement5">
    new Element
</div>

`;

document.getElementById('newElement5').
addEventListener('click', () => {
    console.log('clicked');
})

