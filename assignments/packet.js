// John Seymour
// JavaScript Assignment

// 1. Fibonacci
// Define function: fib(n) 
// Return the nth number in the fibonacci sequence.
function fib(i) {
    let num = 0
    if (i<=2) {
        return i-1
    } 
    num = fib(i-1) + fib(i-2);
    return num;
}
// 2. Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array.
// Return the sorted array.
function bubbleSort(numArray) {
    let length = numArray.length
    for (let i = (length-1); i>=0; i--) {
        // pass through the items length amt of times
        for (let j = (length-i); j>0; j--) {
            // compared the position side by side
            if (numArray[j]<numArray[j-1]) {
                // swap numbers
                let temp = numArray[j];
                numArray[j] = numArray[j-1];
                numArray[j-1] = temp;
            }
        }
    }
}
// 3. Reverse String
// Define function: reverseStr(someStr)
// Reverse and return the String.
function reverseStr(someStr) {
    let temp = '';
    let len = someStr.length;

    // create a new string reading it from the end first
    while(len>0) { 
        temp += someStr.substring(len-1, len);
        len--;
    }
    return temp;
}
// 4. Factorial
// Define function: factorial(someNum)
// Use recursion to compute and return the factorial of someNum.
function factorial(someNum) {
    if (someNum<0) {
        return -1;
    } else if (someNum==0) {
        return 1;
    } else {
        return (someNum*factorial(someNum-1));
    }
}
// 5. Substring
// Define function substring(someStr, length, offset)
// Return the substring contained between offset and (offset + length) inclusively.
// If incorrect input is entered, use the alert function and describe why the input was incorrect.
function substring(someStr, length, offset) {
    if (typeof someStr !== 'string') {
        alert('someStr is not a string');
    }
    if (length !== parseInt (length,10)) {
        alert('length is not an integer');
    }
    if (offset !== parseInt (offset,10)) {
        alert('offset is not an integer');
    }
    return someStr.substring(offset, offset+length);
}
// 6. Even Number
// Define function: isEven(someNum)
// Return true if even, false if odd.
// Do not use % operator.
function isEven(someNum) {
    if ((someNum & 1) === 0) {
        return true;
    } else {
        return true;
    }
}
// 7. Palindrome
// Define function isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false
function isPalindrome(someStr) {
    if (someStr === reverseStr(someStr)) {
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
function printShape(shape, height, character) {
    switch (shape) {
        case 'Square':
        let str = "";
        for(let i = 0; i< height; i++){
            str += "\n";
            for(let j = 0; j <height; j++){
                str += character;
            }
        }
        return str;
        break;
        case 'Triangle':
        var tri = [];
        for(i= 0; i < height; i++){
            tri[i] = new Array(i + 2).join(character);
            console.log(tri[i]);
        }
            break;
        case 'Diamond':
        let dia = [];
        let l = height;
            for(i= 0; i < height; i++){
                // get string of varying white space to format diamond
                l--;
                let space = ' ';
                for (let i=0;i<l; i++) {
                    space.concat(' ');
                }

                dia[i] = new Array(i + 2).join(space+character);
                console.log(dia[i]);
        }
            break;
        default:
            alert('Invalid shape!');
    }
}

// 9. Object literal
// Define function traverseObject(someObj)
// Print every property and it's value.
function traverseObject(someObj) {
    for (let property in someObj) {
        console.log(someObj[property]);
    }
}
// 10. Delete Element
// Define function deleteElement(someArr)
// Print length
// Delete the third element in the array.
// Print length
// The lengths should be the same.
function deleteElement(someArr) {
    console.log(someArr.length);
    delete someArr[2];
    console.log(someArr.length);
}
// 11. Splice Element
// Define function spliceElement(someArr)
// Print length
// Splice the third element in the array.
// Print length
// The lengths should be one less than the original length.
function spliceElement(someArr) {
    console.log(someArr.length);
    someArr.splice(2,1);
    console.log(someArr.length);
}
// 12. Defining an object using a constructor
// Define a function Person(name, age)
// The following line should set a Person object to the variable john:
// 	var john = new Person("John", 30);
function Person(name, age) {
    this.name=name;
    this.age=age;
}
// 13. Defining an object using an object literal
// Define function getPerson(name, age)
// The following line should set a Person object to the variable john:
// 	var john = getPerson("John", 30);
function getPerson(name, age) {
    return {
        n: name,
        a: age
    }
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
    let elements = document.getElementsByTagName("*");
    let searchText = "USA";
    let found;
    
    for (let i = 0; i < elements.length; i++) {
      if (elements[i].textContent == searchText) {
        found = elements[i];
        return found;
      }
    }
}
// 2. Sales
// Define function getPeopleInSales()
// Print the names of all the people in the sales department.
function getPeopleInSales() {
    let f = document.getElementById("myTable"); // added an id to the html file
    let d = f.getElementsByTagName("td"); // gets the tds in the table
    let people = [];
    for (let i = 0; i < d.length; i++) {
        if (d[i].textContent == "Sales") {
        people.push(d[i-1].textContent); // returns the td to the left of sales
        }
      }
      return people;
}
//3. Click Here -------todo
//Define function getAnchorChildren()
//Find all anchor elements with a <span> child.
//Print the contents of <span>
function getAnchorChildren() {
    let elements = document.getElementsByTagName('a').childNodes;
    for(let i=0; i < elements.length; i++){
        if(elements[i] === 'span'){
            console.log(i);
        }
    }
}
//4. Hobbies -----todo
//Define function getHobbies()
//Find all checked options in the 'skills' select element.
//Print the value and the contents.
function getHobbies() {  
    let skills = document.getElementsByName('skills')[0];
    let selectSkill = skills.options[skills.selectedIndex].value;
    let contentSkill = skills.options[skills.selectedIndex].textContent;
    console.log(contentSkill + ': ' + selectSkill);
}
//5. Custom Attribute
//Define function getCustomAttribute()
//Find all elements with "data-customAttr" attribute
//Print the value of the attribute.
//Print the element that has the attribute.
function getCustomAttribute(){
    let elements = document.querySelectorAll('[data-customAttr]');
    for(let i =0; i<elements.length; i++){
        console.log(elements[i].dataset.customattr);
    }
}
//6. Sum Event
//NOTE: Write unobtrusive Javascript
//Regarding these elements:
//	<input id="num1" class="nums" type="text"/>
//	<input id="num2" class="nums" type="text"/>
//	<h3>Sum: <span id="sum"></span></h3>
//Define onchange event handler.
//Add <input> element values.
//Put the sum in the <span> element.
document.getElementById('num1').addEventListener("change", calculateSum);
document.getElementById('num2').addEventListener("change", calculateSum);
function calculateSum(){
    let val1 = Number(document.getElementById('num1').value);
    let val2 = Number(document.getElementById('num2').value);
    let total = val1 + val2;
    document.getElementById('sum').innerText = total;
}
//7. Skills Event
//NOTE: Write unobtrusive Javascript
//When user selects a skill, create an alert with a message similar to:
//	"Are you sure CSS is one of your skills?"
//NOTE: no alert should appear when user deselects a skill.
let skill = document.getElementsByName('skills')[0];
skill.addEventListener('select', alertUser(skill));
function alertUser(skill) {
    alert("Are you sure " + skill.options[skill.selectedIndex].textContent + " is one of your skills?");
}
//8. Favorite Color Event
//NOTE: Write unobtrusive Javascript
//NOTE: This is regarding the favoriteColor radio buttons.
//When a user selects a color, create an alert with a message similar to:
//	"So you like green more than blue now?"
//In this example, green is the new value and blue is the old value.
//Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
let buttons = document.getElementsByName('favoriteColor');
let newButton;
for(let i = 0; i < buttons.length; i++){
    buttons[i].addEventListener('click', function() {
        alertColor(buttons[i])
    });
}
function alertColor(newButton) {
    alert("So you like " + newButton.innerText + " more than blue now?");
}
//9. Show/Hide Event
//NOTE: Write unobtrusive Javascript
//When user hovers over an employees name:
//	Hide the name if shown.
//	Show the name if hidden.
let name = document.getElementsByClassName('empName');
function display(name){
    name.style.display = 'block';
}
for(let i = 0; i < name.length; i++){
    name[i].addEventListener('mouseover', display(name[i]));
}
//10. Current Time
//Regarding this element:
//	<h5 id="currentTime"></h5>
//Show the current time in this element in this format: 9:05:23 AM
//The time should be accurate to the second without having to reload the page.
function checkTime(i) {
  if (i < 10) {
    i = "0" + i;
  }
  return i;
}
function getTime() {
    let today = new Date();
    let h = today.getHours();
    let m = today.getMinutes();
    let s = today.getSeconds();
    m = checkTime(m);
    s = checkTime(s);
    document.getElementById('currentTime').innerHTML = h + ":" + m + ":" + s;
}
//11. Delay
//Regarding this element:
//	<p id="helloWorld">Hello, World!</p>
//Three seconds after a user clicks on this element, change the text to a random color.
let hello = document.getElementById('helloWorld');
function changeColor() {
    document.getElementById('helloWorld').style.color = 'green';
}
hello.addEventListener('click', setTimeout(changeColor(), 3000));
//12. Walk the DOM
//Define function walkTheDOM(node, func)
//This function should traverse every node in the DOM. Use recursion.
//On each node, call func(node).
function walkTheDOM(node, func) {
   let children = node.childNodes;
   for(let i = 0; i < children.length; i++) {
       walktheDOM(children[i], func);
   }
   func(node);
}