// Javascript Homework
// Due Friday Morning

// -----------------------------------------------------------------------------------
// PART I

// Create a single Javascript file called packet.js to answer these questions.
// Please put the question itself as a comment above each answer.
// -----------------------------------------------------------------------------------

// 1. Fibonacci
// Define function: fib(n) 
// Return the nth number in the fibonacci sequence.
function fib(n) {
    let a = 0, b = 1, temp

    while (n >= 0) {
        temp = a
        a += b
        b = temp
        n--
        console.log(b)
    }
}
fib(10)
// 2. Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array.
// Return the sorted array.

function bubbleSort(numArray) {
    let length = numArray.length;
    for (let i = (length - 1); i >= 0; i--) {
        //Number of passes
        for (var j = (length - i); j > 0; j--) {
            //Compare the adjacent positions
            if (numArray[j] < numArray[j - 1]) {
                //Swap the numbers
                let tmp = numArray[j];
                numArray[j] = numArray[j - 1];
                numArray[j - 1] = tmp;
            }
        }
    }
    return numArray;
}
let numbersForArray = [51, 32, 45, 36, 24, 11, 8, 31, 23];
bubbleSort(numbersForArray);

// 3. Reverse String
// Define function: reverseStr(someStr)
// Reverse and return the String.

function reverseStr(someStr) {
    return someStr.split("").reverse().join("");
}
reverseStr("reverse");

// 4. Factorial
// Define function: factorial(someNum)
// Use recursion to compute and return the factorial of someNum.

function factoriali(someNum) {
    if (someNum < 0)
        return -1;
    else if (someNum == 0)
        return 1;
    else {
        return (someNum * factorial(someNum - 1));
    }
}
factorial(5);

// 5. Substring
// Define function substring(someStr, length, offset)
// Return the substring contained between offset and (offset + length) inclusively.
// If incorrect input is entered, use the alert function and describe why the input was incorrect.

function subString(someStr, length, offset) {
    return str.substring(offset, length);
}
let str = 'helloworld';
subString(str, str.length, 4);

let num = 5;

// 6. Even Number
// Define function: isEven(someNum)
// Return true if even, false if odd.
// Do not use % operator.

function isEven(someNum) {
    if ((someNum & 1) == 0) {
        return true
    }
    return false;
}

// 7. Palindrome
// Define function isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false

function isPalindrome(someStr) {
    var tempStr = someStr.toLowerCase().split('').reverse().join('');

    if (tempStr === someStr) {
        return true;
    }
    else {
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
let printSquare = function (height, character) {
    let str = '';
    for (let i = 0; i < height; i++) {
        str = character;
        for (let j = 1; j < height; j++) {
            str += character;
        }
        console.log(str);
    }
}

let printTriangle = function (height, character) {
    let str = '';
    for (let i = 1; i <= height; i++) {
        str = character;
        for (let j = 1; j < i; j++) {
            str += character;
        }
        console.log(str);
    }
}

let printDiamond = function (height, character) {
    let str = '';
    let center = Math.ceil(height / 2);
    for (let i = 1; i <= height; i++) {
        let value = Math.abs(center - i);
        str += getDiamond(value, ' ') + getDiamond(height - (value * 2), character) + '\n';
    }
    console.log(str);
}
function getDiamond(height, character) {
    str = character;
    for (let i = 1; i < height; i++) {
        str += character;
    }
    return str;
}

let printShape = function (shape, height, character) {
    switch (shape) {
        case 'square':
            printSquare(height, character);
            break;
        case 'triangle':
            printTriangle(height, character);
            break;
        case 'diamond':
            printDiamond(height, character);
            break;
    }
}

printShape = ('square', 3, '*');
printShape = ('triangle', 4, '&');
printShape = ('diamond', 6, '#');
// 9. Object literal
// Define function traverseObject(someObj)
// Print every property and it's value.

function traverseObject(someObj) {
    for (let property in someObj) {
        console.log(Object.values(someObj)[value]);
    }
}

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

function deleteElement(someArr) {

    console.log('length of someArr: ' + someArr.length);
    delete myArr[3];
    console.log('length of someArr after deletion: ' + someArr.length);
}
let myArr = [1, 2, 3, 5, 6, 7, 8];
deleteElement(myArr);

// 11. Splice Element
// Define function spliceElement(someArr)
// Print length
// Splice the third element in the array.
// Print length
// The lengths should be one less than the original length.

function spliceElement(someArr) {
    console.log('length of someArr: ' + someArr.length);
    someArr.splice(3, 1);
    console.log('length of someArr after splice: ' + someArr.length)
}
let newArr = [1, 2, 3, 5, 6, 7, 8];
deleteElement(myArr);

// 12. Defining an object using a constructor
// Define a function Person(name, age)
// The following line should set a Person object to the variable john:
// 	var john = new Person("John", 30);

function Person(name, age) {
    this.name = name;
    this.age = age;
}
let newPerson = new Person('Saad', 24);

// 13. Defining an object using an object literal
// Define function getPerson(name, age)
// The following line should set a Person object to the variable john:
// 	var john = getPerson("John", 30);

function getPerson(name, age) {

    Person = {
        personName: name,
        personAge: age
    };
    return Person;
}
let newPerson = getPerson('Saad', 24);

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

let getUSA = function () {
    let tag = document.getElementsByTagName('span');
    for (let i = 0, max = tag.length; i < max; i++) {
        if (tag[i].textContent == 'USA') {
            return tag[i];
        }
    }
}

// 2. Sales
// Define function getPeopleInSales()
// Print the names of all the people in the sales department.

function getPeopleInSales() {
    let table = document.getElementById('empTable');
    let people = table.children[0].children;
    for (let i = 1; i < people.length; i++) {
        if (people[i].textContent.includes('Sales')) {
            console.log(people[i].cells[0].innerText);
        }
    }
}

// 3. Click Here
// Define function getAnchorChildren()
// Find all anchor elements with a <span> child.
// Print the contents of <span>

function getAnchorChildren() {
    let tag = document.getElementsByTagName('a');
    for (let i = 0; i < tag.length; i++) {
        let span = tag[i].children;
        for (let j = 0; j < span.length; j++) {
            console.log(span[j].innerText);
        }
    }
}
// 4. Hobbies
// Define function getHobbies()
// Find all checked options in the 'skills' select element.
// Print the value and the contents.

function getHobbies() {
    let skills = document.getElementsByName('skills');
    let child = skills[0].children;
    for (let i = 0; i < child.length; i++) {
        if (child[i].getAttribute('selected') == 'selected') {
            console.log(child[i].innerText);
        }
    }
}

// 5. Custom Attribute
// Define function getCustomAttribute()
// Find all elements with "data-customAttr" attribute
// Print the value of the attribute.
// Print the element that has the attribute.

function getCustomAttribute() {
    let customeAttr = document.querySelectorAll('[data-customAttr]');
    for (let i = 0; i < customAttr.length; i++) {
        console.log(customAttr[i].dataset.customattr);
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

document.getElementById('num1').addEventListener('onchange', getSum());
document.getElementById('num2').addEventListener('onchange', getSum());

function getSum() {
    let num1 = Number(document.getElementById('num1'));
    let num2 = Number(document.getElementById('num2'));
    let sum = num1 + num2;
    if (sum === Number) {
        document.getElementById('sum').innerText = sum;
    }
    else {
        document.getElementById('sum').innerText = 'Cannot add';
    }
}
// 7. Skills Event
// NOTE: Write unobtrusive Javascript
// When user selects a skill, create an alert with a message similar to:
// 	"Are you sure CSS is one of your skills?"
// NOTE: no alert should appear when user deselects a skill.

let skill = document.getElementsByName('skills')[0];
let skillAlert = skill.addEventListener('onselect', skillsAlert(skill));

function skillsAlert(skill) {
    alert("Are you sure " + skill.options[skill.selectedIndex].textContent + " is one of your skills?");
}

// 8. Favorite Color Event
// NOTE: Write unobtrusive Javascript
// NOTE: This is regarding the favoriteColor radio buttons.
// When a user selects a color, create an alert with a message similar to:
// 	"So you like green more than blue now?"
// In this example, green is the new value and blue is the old value.
// Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor

let color = document.getElementById('firstForm').favoriteColor;
let oldFavorite = null;
for (let i = 0; i < color.length; i++) {
    color[i].setAttribute('onchange', 'changeColor(this)');
}
function changeColor(button) {
    if (button.checked) {
        let newFavorite = button.value;
        alert(`So you like ${newFavorite} more than ${oldFavorite} now ?`);
        oldFavorite = button.value;
    }
}


// 9. Show/Hide Event
// NOTE: Write unobtrusive Javascript
// When user hovers over an employees name:
// 	Hide the name if shown.
// 	Show the name if hidden.

let empName = document.getElementsByClassName('empName');

function display(empName) {
    if (empName.style.visibility === 'visible') {
        empName.style.visibility = 'hidden';
    }
    else {
        empName.style.visibility = 'visible';
    }
}
for (let i = 0; i < empName.length; i++) {
    empName[i].setAttribute('onmouseover', 'display(this)');
}

// 10. Current Time
// Regarding this element:
// 	<h5 id="currentTime"></h5>
// Show the current time in this element in this format: 9:05:23 AM
// The time should be accurate to the second without having to reload the page.

document.body.setAttribute('onload', 'startTime()');

function startTime() {
    let today = new Date();
    let hour = today.getHours();
    let min = today.getMinutes();
    let sec = today.getSeconds();
    min = getTime(min);
    sec = getTime(sec);
    document.getElementById('currentTime').innerHTML = hour + ":" + min + ":" + sec;
    let keepGoing = setTimeout(startTime, 500);
}
function getTime(i) {
    if (i < 10) { i = "0" + i };
    return i;
}

// 11. Delay
// Regarding this element:
// 	<p id="helloWorld">Hello, World!</p>
// Three seconds after a user clicks on this element, change the text to a random color.

function changeColor() {
    document.getElementById('helloWorld').setAttribute('style', 'color:green');
}
document.getElementById('helloWorld').setAttribute('onclick', 'setTimeout(changeColor, 3000)');

// 12. Walk the DOM
// Define function walkTheDOM(node, func)
// This function should traverse every node in the DOM. Use recursion.
// On each node, call func(node).