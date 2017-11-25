
    // 1. Define function fib(n)
    // Return the nth number in the fibonacci sequence
    function fib(n) {
      var a = 1, b = 0, temp;

      while (n >= 0) {
        temp = a;
        a = a + b;
        b = temp;
        n--;
      }

      return b;
    }

    //2. Bubble sort
    //   Define function: bubbleSort(numArray)
    //   Use the bubble sort algo to sory the array
    //   Return the sorted arr 

    var a = [20, 1, 33, 72, 2, 98, 17, 4, 9];

    function bubbleSort(a) {
      var swapped;
      do {
        swapped = false;
        for (var i = 0; i < a.length - 1; i++) {
          if (a[i] > a[i + 1]) {
            var temp = a[i];
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

    function reverseString(str) {
      var newString = "";
      for (var i = str.length - 1; i >= 0; i--) {
        newString += str[i];
      }
      return newString;
    }

    // 4. Factorial
    // Define function: factorial(someNum)
    // Use recursion to compute and return the factorial of someNum.

    function factorial(x) {
      if (x === 0) {
        return 1;
      }
      return x * factorial(x - 1);

    }

//     5. Substring
// Define function substring(someStr, length, offset)
// Return the substring contained between offset and (offset + length) inclusively.
// If incorrect input is entered, use the alert function and describe why the input was incorrect.

function isString(str){
    return typeof str === 'string';
}

// create function to check if it is a num
function isInt(num){
    return typeof num === 'number';
}

// test the substring method on valid input
function substring(someStr, length, offset){
    if(isString(someStr) && isInt(length) && isInt(offset)){
        let sub = someStr.substring(length,offset);
        return sub;
    }
    else{
        alert('Input is invalid');
    }
}

let substringTest = substring("hello",1,4);

//6. Even Number
//Define function: isEven(someNum)
//Return true if even, false if odd.
//Do not use % operator.

function isEven(someNum){
    if((someNum/2)*2 == someNum){
        return true;
    }
    else{
        return false;
    }
}


//7. Palindrome
//Define function isPalindrome(someStr)
//Return true if someStr is a palindrome, otherwise return false

function isPalindrome(someStr){
    let reverse = someStr.split('').reverse().join('');
    if(someStr == reverse){
        return true;
    }
    else{
        return false;
    }
}


//8. Shapes
//Define function: printShape(shape, height, character)
//shape is a String and is either "Square", "Triangle", "Diamond".
//height is a Number and is the height of the shape. Assume the number is odd.
//character is a String that represents the contents of the shape. Assume this String contains just one character.
//Use a switch statement to determine which shape was passed in.
//Use the console.log function to print the desired shape.
//Example for printShape("Square", 3, "%");
//%%%
//%%%
//%%%
//Example for printShape("Triangle", 3, "$");
//$
//$$
//$$$
//Example for printShape("Diamond", 5, "*");
//  *
// ***
//*****
// ***
//  *

function printShape(shape, height, character){
    switch(shape){
        case "Square":
            let str = "";
            for(let i = 0; i< height; i++){
                str += "\n";
                for(let j = 0; j <height; j++){
                    str += character;
                }
            }
            return str;
            break;
            
        case "Triangle":
            let tri = [];
            for(let i= 0; i < height; i++){
                tri[i] = new Array(i + 2).join(character);
                console.log(tri[i]);
            }
            break;
            
        case "Diamond":
            // Wasn't able to figure this one out
            break;
            
        default:
            console.log("not a type you can print");
    }
}

//9. Object literal
//Define function traverseObject(someObj)
//Print every property and it's value.

function traverseObject(someObj) {
let obj = {
    name: 'sample',
    pass: 'object',
    email: 'objectemail@sample.com'
};

for(let property in obj){
    console.log(property + ": " + obj[property]);
}
}

//10. Delete Element
//Define function deleteElement(someArr)
//Print length
//Delete the third element in the array.
//Print length
//The lengths should be the same.

let arr = [4,2,7,1];

function deleteElement(someArr){
    console.log(someArr.length);
    delete someArr[2];
    console.log(someArr.length);
}





//11. Splice Element
//Define function spliceElement(someArr)
//Print length
//Splice the third element in the array.
//Print length
//The lengths should be one less than the original length.

let arr2 = [4,2,7,1];

function spliceElement(someArr){
    console.log(someArr.length);
    someArr.splice(3,1);
    console.log(someArr.length);
}



//12. Defining an object using a constructor
//Define a function Person(name, age)
//The following line should set a Person object to the variable john:
//	var john = new Person("John", 30);

let Person = function(name,age){
    this.name = name;
    this.age = age;
}

let john = new Person("john", 30);

//13. Defining an object using an object literal
//Define function getPerson(name, age)
//The following line should set a Person object to the variable john:
//	var john = getPerson("John", 30);

function getPerson(name, age){
    let person = new Object();
    person.name = name;
    person.age = age;
    return person;
}

var john2 = getPerson("john", 30);


// 1. USA
// Define function getUSA()
// Find the html element that contains "USA".
// Print that element's contents.

function getUSA() {

  let search = "USA";

  let all = document.getElementsByTagName("*");
  for (let i=0, max=all.length; i < max; i++) {
    if(all[i].textContent == search) {
      return all[i];
    }
  }
  
}

// 2. Sales
// Define function getPeopleInSales()
// Print the names of all the people in the sales department.

function getPeopleInSales() {
  let people = document.getElementsById("myTable");
  let temp = people.getElementsByTagName("td");
  let people2 = [];
  for(i = 0, max=people.length; i < max; i++) {
    if(temp[i].textContent == "Sales") {
    people2.push(temp[i-1].textContent);
    }
  }
  return people2;
}

  
//3. Click Here
//Define function getAnchorChildren()
//Find all anchor elements with a <span> child.
//Print the contents of <span>

  function getAnchorChildren() {
    let elements = document.getElementsByTagName('a').childNodes;
    let array = [];
    for(let i=0, max = elements.length; i<max; i++){
        if(elements[i] === 'span'){
            array.push(elements[i]);
        }
    }
    return array;
}

//4. Hobbies
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
  document.getElementById('num1').onchange = function(){calculateSum()};
document.getElementById('num2').onchange = function(){calculateSum()};

function calculateSum(){
    let val1 = document.getElementById('num1').value;
    let val2 = document.getElementById('num2').value;
    let total = val1 + val2;
    document.getElementById('sum').innerText = total;
}




//7. Skills Event
//NOTE: Write unobtrusive Javascript
//When user selects a skill, create an alert with a message similar to:
//	"Are you sure CSS is one of your skills?"
//NOTE: no alert should appear when user deselects a skill.


function alertUser(skill) {
    alert("Are you sure " + skill.options[skill.selectedIndex].textContent + " is one of your skills?");
}

let skill = document.getElementsByName('skills')[0];
let skillText = skill.addEventListener('select', alertUser(skill));

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
    document.getElementById('helloWorld').style.color = 'blue';
}
hello.addEventListener('click', setTimeout(changeColor(), 3000));

//12. Walk the DOM
//Define function walkTheDOM(node, func)
//This function should traverse every node in the DOM. Use recursion.
//On each node, call func(node).

function walkTheDOM(node, func) {
   let children = node.childNodes;
   for(let i = 0; i < children.length; i++)
       walktheDOM(children[i], func);
   func(node);
}
