// 1. Fibonacci
// Define function: fib(n) 
// Return the nth number in the fibonacci sequence.
function fib(n)
{
    if (n<1)
        return null;
    if (n < 3)
        return 1;
    else
    {
        let a = 1;
        let b = 1;
        let curFib = null;

        for (let i = 2; i < n; i ++)
        {
            curFib = a + b;
            a = b;
            b = curFib;
        }
        return curFib;
    }
}

// 2. Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array.
// Return the sorted array.
function bubbleSort(numArray)
{
    let swapOccured = true;
    
    // Stop trying to sort when array is sorted
    while (swapOccured)
    {
        swapOccured = false;
        
        for (let i = 0; i < numArray.length - 1; i++)
        {
            // Check if pair needs to switch places
            if (numArray[i + 1] < numArray[i])
            {
                // Swap
                let temp = numArray[i];
                numArray[i] = numArray[i + 1];
                numArray[i + 1] = temp;
                swapOccured = true;
            }
        }
    }
    return numArray;
}

// 3. Click Here
// Define function getAnchorChildren()
// Find all anchor elements with a <span> child.
// Print the contents of <span>
function getAnchorChildren()
{
    let anchors = document.getElementsByTagName('a');

    for (let i = 0; i < anchors.length; i++)
    {
        let spans = anchors[i].getElementsByTagName('span');
        if (spans.length > 0)
        {
            for (let j = 0; j < spans.length; j++)
                console.log(spans[j]);
        }
    }
}

// 4. Hobbies
// Define function getHobbies()
// Find all checked options in the 'skills' select element.
// Print the value and the contents.
function getHobbies()
{
    let selectedSkills = document.getElementsByName('skills')[0].querySelectorAll('[selected=selected]');

    for (let i = 0; i < selectedSkills.length; i++)
            console.log(selectedSkills[i]);
}
  
// 5. Custom Attribute
// Define function getCustomAttribute()
// Find all elements with "data-customAttr" attribute
// Print the value of the attribute.
// Print the element that has the attribute.
function getCustomAttribute()
{
    let customs = document.querySelectorAll('[data-customAttr]');
    
        for (let i = 0; i < customs.length; i++)
        {
            console.log(customs[i].getAttribute('data-customAttr'));
            console.log(customs[i]);
        }
}

// 6. Sum Event
// NOTE: Write unobtrusive Javascript
// Regarding these elements:
// 	<input id="num1" class="nums" type="text"/>
// 	<input id="num2" class="nums" type="text"/>
// 	<h3>Sum: <span id="sum"></span></h3>

// Define onchange event handler.
// Add <input> element values.
// Put the sum in the <span> element.
// If values cannot be added, put "Cannot add" in the <span> element
document.getElementById('num1').addEventListener('change', insertSum, true);
document.getElementById('num2').addEventListener('change', insertSum, true);

function insertSum()
{
    let num1 = parseInt(document.getElementById('num1').value);
    let num2 = parseInt(document.getElementById('num2').value);
    let sum = num1 + num2;

    // Prohibit NaN
    if (sum === 0 || sum)
        document.getElementById('sum').innerText = sum;
    else
        document.getElementById('sum').innerText = 'Cannot add';
}

// 7. Skills Event
// NOTE: Write unobtrusive Javascript
// When user selects a skill, create an alert with a message similar to:
// 	"Are you sure CSS is one of your skills?"
// NOTE: no alert should appear when user deselects a skill.

// e.options[e.selectedIndex].value;

document.getElementsByName('skills')[0].addEventListener('change', confirmSkill, true);

function confirmSkill()
{
    let skills = document.getElementsByName('skills')[0];
    let selected = skills.options[skills.selectedIndex].innerText;
    alert('Are you sure ' + selected + ' is one of your skills?');
}

// 8. Favorite Color Event
// NOTE: Write unobtrusive Javascript
// NOTE: This is regarding the favoriteColor radio buttons.
// When a user selects a color, create an alert with a message similar to:
// 	"So you like green more than blue now?"
// In this example, green is the new value and blue is the old value.
// Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor

colorButtons = document.getElementsByName('favoriteColor');
let prevSelected = getFavoriteColor();

for (let i = 0; i < colorButtons.length; i++)
    colorButtons[i].addEventListener('change', confirmColor, true);

function confirmColor(event)
{
    // Get selected radio button
    let selectedButton = getFavoriteColor();
    alert('So you like ' + selectedButton.value + ' more than ' + prevSelected.value + ' now?');

    console.log('Changing radio button background colors:')
    // Set background colors
    for (let i = 0; i < colorButtons.length; i++)
    {
        colorButtons[i].style.backgroundColor = selectedButton.value;
        console.log(colorButtons[i]);
    }

    prevSelected = event.target;
}

function getFavoriteColor()
{
    for (let i = 0; i < colorButtons.length; i++)
    {
        if (colorButtons[i].checked)
            return colorButtons[i];
    }
}

// 9. Show/Hide Event
// NOTE: Write unobtrusive Javascript
// When user hovers over an employees name:
// 	Hide the name if shown.
// 	Show the name if hidden.

employees = document.getElementsByClassName('empName');

for (let i = 0; i < employees.length; i++)
    employees[i].addEventListener('mouseover', toggleNames, true);

function toggleNames(event)
{
    // Set opacity to 0 if opacity is not zero or if it isn't an attribute
    if (parseInt(event.target.style.opacity) || !event.target.hasAttribute("style"))
        event.target.setAttribute("style","opacity:0");
    else
        event.target.setAttribute("style","opacity:1.0");
}

// 10. Current Time
// Regarding this element:
// 	<h5 id="currentTime"></h5>
// Show the current time in this element in this format: 9:05:23 AM
// The time should be accurate to the second without having to reload the page.
clock = document.getElementById('currentTime');
updateTime(); // initial call to avoiding screen shifting
window.setInterval(updateTime, 1000);

function updateTime()
{
    let date = new Date();
    let hours = date.getHours();
    let amPm;

    if (hours > 12)
    {
        hours -= 12;
        amPm = ' PM';
    }
    else
        amPm = ' AM';
    
    clock.innerText = hours + ':' + date.getMinutes() + ':' + date.getSeconds() + amPm;
}

// 11. Delay
// Regarding this element:
// 	<p id="helloWorld">Hello, World!</p>
// Three seconds after a user clicks on this element, change the text to a random color.
let hello = document.getElementById('helloWorld');
hello.addEventListener('click', delay, true);

function delay()
{
    setTimeout(changeColor, 3000);
}

function changeColor()
{
    hello.style.color = getRandomColor();
}

function getRandomColor()
{
    let chars = '0123456789ABCDEF';
    let color = '#';

    for (let i = 0; i < 6; i++)
      color += chars[Math.floor(Math.random() * 16)];

    return color;
}

// 12. Walk the DOM
// Define function walkTheDOM(node, func)
// This function should traverse every node in the DOM. Use recursion.
// On each node, call func(node).
function walkTheDOM(node, func)
{
    let children = node.childNodes;

    for (let i = 0; i < children.length; i++)
    {
        func(children[i]);
        walkTheDOM(children[i], func);
    }
}

// A function for testing walkTheDOM
function step(node)
{
    console.log(node);
}