/**
 * 1. USA
 * Define function getUSA()
 * Find the html element that contains "USA".
 * Print that element's contents.
 */
function getUSA() {
    let content = document.getElementsByTagName("h1")[0].textContent;
    console.log(content);
    let usa = window.find("USA");
    console.log(usa);
}



/**
 * 2. Sales
 * Define function getPeopleInSales()
 * Print the names of all the people in the sales department.
 */
function getPeopleInSales() {
    let table = document.getElementsByTagName("table")[0];
    
    for(let i = 0; i < table.rows.length; i++) {
        let department = table.rows[i].cells[1].textContent;
        
        if(department.toUpperCase() === "SALES") {
            console.log(table.rows[i].cells[0].textContent);
        }
    }
}



/**
 * 3. Click Here
 * Define function getAnchorChildren()
 * Find all anchor elements with a <span> child.
 * Print the contents of <span>
 */
function getAnchorChildren() {
    let anchors = document.getElementsByTagName("a");
    let span;

    for(let i = 0; i < anchors.length; i++) {
        span = anchors[i].getElementsByTagName("span")[0];
        if(span) {
            console.log(span.textContent);
        }
    }
}



/**
 * 4. Hobbies
 * Define function getHobbies()
 * Find all checked options in the 'skills' select element.
 * Print the value and the contents.
 */
function getHobbies() {
    console.log(document.getElementsByName("skills")[0].textContent);
}



/**
 * 5. Custom Attribute
 * Define function getCustomAttribute()
 * Find all elements with "data-customAttr" attribute
 * Print the value of the attribute.
 * Print the element that has the attribute.
 */
function getCustomAttribute() {
    let length = document.querySelectorAll('[data-customAttr]').length;
    for(let i = 0; i < length; i++) {
        customAttr = document.querySelectorAll('[data-customAttr]')[i]
        console.log(customAttr);
    }
}



/**
 * 6. Sum Event
 * NOTE: Write unobtrusive Javascript
 * Regarding these elements:
 * 	<input id="num1" class="nums" type="text"/>
 * 	<input id="num2" class="nums" type="text"/>
 * 	<h3>Sum: <span id="sum"></span></h3>
 * 
 * Define onchange event handler.
 * Add <input> element values.
 * Put the sum in the <span> element.
 * If values cannot be added, put "Cannot add" in the <span> element
 */
document.getElementById("num1").addEventListener("change", sumEvent);
document.getElementById("num2").addEventListener("change", sumEvent);

function sumEvent() {
    num1 = Number(document.getElementById('num1').value);
    num2 = Number(document.getElementById('num2').value);
    result = num1 + num2;

    if(Number(result)) {
        document.getElementById('sum').innerHTML = num1 + num2;
    }

    else if(Number(result) == 0) {
        document.getElementById('sum').innerHTML = 0;
    }
    
    else {
        document.getElementById('sum').innerHTML = 'Cannot add!';
    }
}



/**
 * 7. Skills Event
 * NOTE: Write unobtrusive Javascript
 * When user selects a skill, create an alert with a message similar to:
 * 	"Are you sure CSS is one of your skills?"
 * NOTE: no alert should appear when user deselects a skill.
 */
document.getElementsByName("skills")[0].addEventListener("change", question7);
let previousIndex = document.getElementsByName('skills')[0].selectedIndex;

function question7() {
    let selected = document.getElementsByName('skills')[0].value;
    
    if(confirm("Are you sure " + selected.toUpperCase() + " is one of your skills?")) {
        previousIndex = document.getElementsByName('skills')[0].selectedIndex;
    }

    else {
        document.getElementsByName('skills')[0].selectedIndex = previousIndex;
    }
}



/**
 * 8. Favorite Color Event
 * NOTE: Write unobtrusive Javascript
 * NOTE: This is regarding the favoriteColor radio buttons.
 * When a user selects a color, create an alert with a message similar to:
 * 	"So you like green more than blue now?"
 * In this example, green is the new value and blue is the old value.
 * Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
 */
let radios = document.getElementById('firstForm');
let colorRadios = document.getElementsByName('favoriteColor');

// document.getElementById(`${radios[i].value}Radio`).style.backgroundColor = radios[i].value;

// set event listeners
for(let i = 0; i < colorRadios.length; i++) {
    colorRadios[i].addEventListener('change', question8);
}

// Update the the text color instead of background color for better readability
function changeColor(colorToChange) {
    let colorText = document.getElementsByName('favoriteColorText');
    for(let i = 0; i < colorText.length; i++) {
        colorText[i].style.color = colorToChange;
    }
}

let previousColor
let color;
let colorIndex;
let colorFirstClick = 0;

function question8() {
    // First click on color radio button
    if(colorFirstClick === 0) {
        for(let i = 0; i < colorRadios.length; i++) {
            if(colorRadios[i].checked) {
                color = colorRadios[i].value;
                if(confirm("So you like " + color + "?")) { // set properties
                    previousColor = color;
                    colorIndex = i;
                    colorFirstClick++;
                    changeColor(colorRadios[i].value);
                }
                else {  // reset radio button
                    colorRadios[i].checked = false;
                }
            }
        }
    }

    // After first click on color radio buttons
    else {
        for(let i = 0; i < colorRadios.length; i++) {
            if(colorRadios[i].checked) {
                color = colorRadios[i].value;
                if(confirm("So you like " + color + " more than " + previousColor + " now?")) {
                    previousColor = color;
                    colorIndex = i;
                    changeColor(colorRadios[i].value);
                }
    
                else {
                    color = previousColor;
                    colorRadios[colorIndex].checked = true;
                    break;
                }
            }
        }
    }
}



/**
 * 9. Show/Hide Event
 * NOTE: Write unobtrusive Javascript
 * When user hovers over an employees name:
 * 	Hide the name if shown.
 * 	Show the name if hidden.
 */
let employees = document.getElementsByClassName("empName");

for(let i = 0; i < employees.length; i++) {
    
    employees[i].setAttribute('id', `emp${i}`);
    employees[i].innerHTML = `<div id=${i}> ${employees[i].innerHTML} </div>`;
    document.getElementById(i).addEventListener("click", question9);
}

visible = true;
function question9() {
    var x = document.getElementById(event.target.id);
    if (!visible) {
        x.style.opacity = 1;
        visible = true;
    } else {
        x.style.opacity = 0;
        visible = false;
    }
}



/**
 * 10. Current Time
 * Regarding this element:
 * 	<h5 id="currentTime"></h5>
 * Show the current time in this element in this format: 9:05:23 AM
 * The time should be accurate to the second without having to reload the page.
 */
function currentTime() {
    let time = new Date();
    time = time.toLocaleString('en-US', { hour: 'numeric', minute:'numeric', second:'numeric', hour12: true });
    document.getElementById('currentTime').innerHTML = time;
    setTimeout(currentTime, 1000);
}
currentTime();



/**
 * 11. Delay
 * Regarding this element:
 * 	<p id="helloWorld">Hello, World!</p>
 * Three seconds after a user clicks on this element, change the text to a random color.
 */
document.getElementById('helloWorld').setAttribute('onclick', 'setTimeout(question11, 3000)');
function question11() {
    document.getElementById('helloWorld').style.color = getRandomColor();
}

function getRandomColor() {
    let letters = '0123456789ABCDEF';
    let color = '#';
    for (let i = 0; i < 6; i++) {
        color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
}



/**
 * 12. Walk the DOM
 * Define function walkTheDOM(node, func)
 * This function should traverse every node in the DOM. Use recursion.
 * On each node, call func(node).
 */
var walkTheDOM = function(node, func)
{
	if(typeof func !== 'function') {
        return;
    }
	let loop = function(node) {
		do {
			func(node);
			if(node.hasChildNodes()) {
                loop(node.firstChild);
            }
		}while(node = node.nextSibling);
	};
	loop(node);
}

let question12 = function(node)
{
	console.log('Element: ', node);
}
// run in console as: walkTheDOM(document.body, question12);