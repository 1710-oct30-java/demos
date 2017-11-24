// Javascript Homework
// Due Friday Morning
// Put all homework in:
// 	...../1704-apr10-java/Firstname_Lastname_Code/Javascript_Homework/

// -----------------------------------------------------------------------------------
// PART I

// Create a single Javascript file called packet.js to answer these questions.
// Please put the question itself as a comment above each answer.
// -----------------------------------------------------------------------------------

// 1. Fibonacci
// Define function: fib(n) 
// Return the nth number in the fibonacci sequence.
function fib(n) {
    let x = 0;
    let y = 1;
    if (n <= 2) {
        return n - 1;
    }
    for (let i = 0; i < n; i++) {
        let tempY = y;
        y = tempY + x;
        x = tempY;
    }
    return y;
}

// 2. Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array.
// Return the sorted array.
function bubbleSort(a) {
    let swapped;
    do {
        swapped = false;
        for (let i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                let temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
                swapped = true;
            }
        }
    } while (swapped);
}

// 3. Reverse String
// Define function: reverseStr(someStr)
// Reverse and return the String.
function reverseStr(str) {
    return str.split('').reverse().join('');
}

// 4. Factorial
// Define function: factorial(someNum)
// Use recursion to compute and return the factorial of someNum.
function factorial(n) {
    if (n <= 1)
        return 1;
    return n * factorial(n - 1);
}

// 5. Substring
// Define function substring(someStr, length, offset)
// Return the substring contained between offset and (offset + length) inclusively.
// If incorrect input is entered, use the alert function and describe why the input was incorrect.
function substring(str, length, offset) {
    if ((offset + length + 1) > (str.length)) {
        alert('wrong input');
        return;
    }
    else if (offset < 0) {
        alert('wrong input');
        return;
    }
    else if (length < 0) {
        alert('wrong input');
        return;
    }
    return str.substring(offset, offset + length + 1);
}

// 6. Even Number
// Define function: isEven(someNum)
// Return true if even, false if odd.
// Do not use % operator.
function idEven(num) {
    if ((num & 1) == 0) {
        return true
    }
    return false;
}

// 7. Palindrome
// Define function isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false
function isPalindrome(myString) {
    let temp = myString.toLowerCase().split('').reverse().join('');

    if (temp === myString) {
        return true;
    } else {

        return false;
    }
}

// 8. Shapes
// Define function: printShape(shape, height, character)
// shape is a String and is either "Square", "Triangle", "Diamond".
// height is a Number and is the height of the shape. Assume the number is odd.
// character is a String that represents the contents of the shape. Assume this String contains just one character.
// Use a switch statement to determine which shape was passed in.
// Use the console.log function to print the desired shape.
// Example for printShape("Square", 3, "%");
// %%%
// %%%
// %%%
// Example for printShape("Triangle", 3, "$");
// $
// $$
// $$$
// Example for printShape("Diamond", 5, "*");
//   *
//  ***
// *****
//  ***
//   *
function printTriangle(height, character) {
    for (let i = 1; i <= height; i++) {
        let a = '';
        for (let j = 1; j <= i; j++) {
            a = a + '' + character;
        }
        console.log(a);
    }
}

function printSquare(height, character) {
    for (let i = 1; i <= height; i++) {
        let a = '';
        for (let j = 1; j <= height; j++) {
            a = a + '' + character;
        }
        console.log(a);
    }
}

function printDiamond(totalheight, character) {
    let height = totalheight / 2 + 0.5;
    for (let i = 1; i <= height; i++) {
        let a = '';
        for (let j = 1; j <= height - i; j++) {
            a += ' ';
        }

        for (let j = 1; j <= i * 2 - 1; j++) {
            a += character;
        }
        console.log(a);
    }
    for (let i = height - 1; i > 0; i--) {
        let a = '';
        for (let j = 1; j <= height - i; j++) {
            a += ' ';
        }
        for (let j = 1; j <= i * 2 - 1; j++) {
            a += character;
        }
        console.log(a);
    }

}

function printShape(shape, height, character) {
    switch (shape) {
        case 'Triangle':
            printTriangle(height, character);
            break;
        case 'Square':
            printSquare(height, character);
            break;
        case 'Diamond':
            printDiamond(height, character);
            break;
    }
}

// 9. Object literal
// Define function traverseObject(someObj)
// Print every property and it's value.
function traverseObject(myObj) {
    for (let prop in obj) {
        console.log(prop + ' with value: ' + obj[prop]);
    }
}

// 10. Delete Element
// Define function deleteElement(someArr)
// Print length
// Delete the third element in the array.
// Print length
// The lengths should be the same.
function deleteElement(myArr) {
    console.log(myArr);
    console.log('length before: ' + myArr.length);
    delete myArr[3];
    console.log('length after: ' + myArr.length);
    console.log(myArr);
}

// 11. Splice Element
// Define function spliceElement(someArr)
// Print length
// Splice the third element in the array.
// Print length
// The lengths should be one less than the original length.
function spliceElement(myArr) {
    console.log(myArr);
    console.log('length before: ' + myArr.length);
    myArr.splice(3, 1);
    console.log('length after: ' + myArr.length);
    console.log(myArr);
}

// 12. Defining an object using a constructor
// Define a function Person(name, age)
// The following line should set a Person object to the variable john:
// 	let john = new Person("John", 30);
function Person(name, age) {
    this.name = name;
    this.age = age;
}

// 13. Defining an object using an object literal
// Define function getPerson(name, age)
// The following line should set a Person object to the variable john:
// 	let john = getPerson("John", 30);
function getPerson(name, age) {
    return new Person(name, age);
}




// -----------------------------------------------------------------------------------
// PART II

// Part II will focus on Javascript's ability to manipulate the DOM.
// Use the provided index.html
// Put your Javascript in the provided <script> or in an external .js file referenced by that script tag element at the bottom of the page.
// Please put the question itself as a comment above each answer.

// -----------------------------------------------------------------------------------

// 1. USA
// Define function getUSA()
// Find the html element that contains "USA".
// Print that element's contents.
function getUSA() {
    let divs = document.getElementsByTagName('div');
    let len = divs.length;
    for (let i = 0; i < len; i++) {
        if (divs[i].innerHTML.indexOf("USA") != -1) {
            console.log(divs[i].innerHTML);
        }
    }
}

// 2. Sales
// Define function getPeopleInSales()
// Print the names of all the people in the sales department.
function getPeopleInSales() {
    let table = document.getElementsByTagName('tr');
    let len = table.length;
    for (let i = 0; i < len; i++) {
        if (table[i].innerHTML.indexOf("Sales") != -1) {
            console.log(table[i].innerText.substring(0, table[i].innerText.length - 6));
        }
    }
}

// 3. Click Here
// Define function getAnchorChildren()
// Find all anchor elements with a <span> child.
// Print the contents of <span>
function getAnchorChildren() {
    let anchor = document.getElementsByTagName('a');
    let len = anchor.length;
    for (let i = 0; i < len; i++) {
        if (anchor[i].innerHTML.indexOf('span') != -1) {
            console.log(anchor[i].getElementsByTagName('span')[0].innerText);
        }
    }
}

// 4. Hobbies
// Define function getHobbies()
// Find all checked options in the 'skills' select element.
// Print the value and the contents.
function getHobbies() {
    let anchor = document.getElementsByTagName('select');
    for (let i = 0; i < anchor.length; i++) {
        if (anchor[i].getAttribute('name') === 'skills') {
            for (let j = 0; j < anchor[i].children.length; j++) {
                if (anchor[i].children[j].getAttribute('selected') != null) {
                    console.log(anchor[i].children[j].innerText);
                    console.log(anchor[i].children[j]);
                }
            }
        }
    }
}

// 5. Custom Attribute
// Define function getCustomAttribute()
// Find all elements with "data-customAttr" attribute
// Print the value of the attribute.
// Print the element that has the attribute.
function getCustomAttribute() {
    let parent = document.getElementsByTagName('*');
    for (let i = 0; i < parent.length; i++) {
        if (parent[i].getAttribute('data-customAttr') != null) {
            console.log(parent[i].getAttribute('data-customAttr'));
            console.log(parent[i]);
        }
    }
    // console.log(parent.length);
    // console.log(document.getElementsByTagName('div')[0].children[1]);
    // console.log(document.getElementsByTagName('div')[0].children[1].length);
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
document.getElementById('num1').addEventListener("change", mySum)
document.getElementById('num2').addEventListener("change", mySum)

function mySum() {
    let a = parseInt(document.getElementById('num1').value);
    let b = parseInt(document.getElementById('num2').value);
    console.log(a);
    console.log(b);
    if (isNaN(a + b)) {
        document.getElementById('sum').innerText = 'Cannot Add';
    }
    else
        document.getElementById('sum').innerText = a + b;
}

// 7. Skills Event
// NOTE: Write unobtrusive Javascript
// When user selects a skill, create an alert with a message similar to:
// 	"Are you sure CSS is one of your skills?"
// NOTE: no alert should appear when user deselects a skill.

let anchor = document.getElementsByTagName('select');
for (let i = 0; i < anchor.length; i++) {
    if (anchor[i].getAttribute('name') === 'skills') {
        anchor[i].setAttribute('onchange', 'checkSelected(this)');
    }
}

function checkSelected(mySkills) {
    let a = mySkills.options[mySkills.selectedIndex].innerHTML;
    alert(`Are you sure ${a} is one of your skills ?`);
}

// 8. Favorite Color Event
// NOTE: Write unobtrusive Javascript
// NOTE: This is regarding the favoriteColor radio buttons.
// When a user selects a color, create an alert with a message similar to:
// 	"So you like green more than blue now?"
// In this example, green is the new value and blue is the old value.
// Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor

let color = document.getElementById('firstForm').favoriteColor;
let prev = null;
for (let i = 0; i < color.length; i++) {
    color[i].setAttribute('onchange', 'colorChecked(this)');
}

function colorChecked(button) {
    if (button.checked) {
        let curr = button.value;
        alert(`So you like ${curr} more than ${prev} now ?`);
        prev = button.value;
    }
}


// 9. Show/Hide Event
// NOTE: Write unobtrusive Javascript
// When user hovers over an employees name:
// 	Hide the name if shown.
// 	Show the name if hidden.

let table = document.getElementsByClassName('empName');
for (let i = 0; i < table.length; i++) {
    table[i].setAttribute('onmouseover', 'showhide(this)');
}
console.log(table[0]);

function showhide(text) {
    if (text.style.visibility === 'visible') {
        text.style.visibility = 'hidden';
    }
    else {
        text.style.visibility = 'visible';
    }
}
// 10. Current Time
// Regarding this element:
// 	<h5 id="currentTime"></h5>
// Show the current time in this element in this format: 9:05:23 AM
// The time should be accurate to the second without having to reload the page.
document.body.setAttribute('onload', 'startTime()');
function startTime() {
    let today = new Date();
    let h = today.getHours();
    let m = today.getMinutes();
    let s = today.getSeconds();
    m = checkTime(m);
    s = checkTime(s);
    document.getElementById('currentTime').innerHTML =
        h + ":" + m + ":" + s;
    let t = setTimeout(startTime, 500);
}

function checkTime(i) {
    if (i < 10) { i = "0" + i };  // add zero in front of numbers < 10
    return i;
}

// 11. Delay
// Regarding this element:
// 	<p id="helloWorld">Hello, World!</p>
// Three seconds after a user clicks on this element, change the text to a random color.
document.getElementById('helloWorld').setAttribute('onclick','setTimeout(changeColor, 3000)');

function changeColor()
{
    document.getElementById('helloWorld').setAttribute('style','color:red');
}

// 12. Walk the DOM
// Define function walkTheDOM(node, func)
// This function should traverse every node in the DOM. Use recursion.
// On each node, call func(node).


