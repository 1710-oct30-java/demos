/*
9. Show/Hide Event
NOTE: Write unobtrusive Javascript
When user hovers over an employees name:
	Hide the name if shown.
    Show the name if hidden.
*/
let showHide = () => {
    let x = document.getElementsByClassName("empName");
    for (let i=0; i<x.length; i++){
    if (x[i].style.display === "none") {
        x[i].style.display = "block";
        continue;
    } 
    else {
        x[i].style.display = "none";
        break;
    }
    }
  }