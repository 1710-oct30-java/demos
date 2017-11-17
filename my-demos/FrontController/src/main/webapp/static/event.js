console.log('script started');

function worldClicked() {
  console.log('world was clicked');
}

function containerClicked() {
  console.log('countainer mouse out triggered');
}

function innerClick(event) {
  console.log('inner clicked');
  event.stopPropagation();
}

function outerClick() {
  console.log('outer clicked');
}

function removeOuter() {
  document.getElementById('outer').remove();
}

let id = 5
document.getElementById('outer').innerHTML += `
  <div id="newElement${id}">
    new Element
  </div>
`;

function myClick() {
  alert('clicked!!!!');
}

document.getElementById('newElement5')
  .addEventListener('click', () => {
    console.log('clicked');
  });


  document.getElementById('1').innerHTML = `
    <div id="3">
      !!!!!!!!!!!!!!!!!!!
    </div>
  `;

  document.getElementById('3')
    .addEventListener('click', () => {
      console.log('3 clicked');
    })


