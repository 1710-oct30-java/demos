//Kyle Settles

//-----------------------------------------------------------------------------------
//PART I
//
//Create a single Javascript file called packet.js to answer these questions.
//Please put the question itself as a comment above each answer.
//-----------------------------------------------------------------------------------
//
//1. Fibonacci
//Define function: fib(n) 
//Return the nth number in the fibonacci sequence.

function fib(n) {
    if (n <= 1){
        return 1;
    }
    return fib(n-1) + fib(n-2);
}

console.log(fib(3));

//2. Bubble Sort
//Define function: bubbleSort(numArray)
//Use the bubble sort algorithm to sort the array.
//Return the sorted array.
numArray = [2,1,65,33,56];

function bubbleSort(numArray){
    let swapped;
    
    do{
        swapped = false;
        for(let i=0; i<numArray.length-1; i++){
            if(numArray[i] > numArray[i+1]){
                let temp = numArray[i];
                numArray[i] = numArray[i+1];
                numArray[i+1] = temp;
                swapped = true;
            }
        }
    } while(swapped);
}
bubbleSort(numArray);
console.log(numArray);

//3. Reverse String
//Define function: reverseStr(someStr)
//Reverse and return the String.

function reverse(str) {
    let stringArray = str.split("");
    let reversedString = stringArray.reverse();
    let newString = reversedString.join("");
    
    return newString;
}

let test = "hello";
let reverseTest = reverse(test);

//4. Factorial
//Define function: factorial(someNum)
//Use recursion to compute and return the factorial of someNum.

function factorial(someNum) {
    if(someNum < 0){
        return -1;
    }
    else if(someNum == 0){
        return 1;
    }
    else{
        return (someNum * factorial(someNum - 1));
    }
}
let factorialTest = factorial(5);

//5. Substring
//Define function substring(someStr, length, offset)
//Return the substring contained between offset and (offset + length) inclusively.
//If incorrect input is entered, use the alert function and describe why the input was incorrect.

// create function to check if it is a string
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

let testTrue = isEven(2);
let testFalse = isEven(3);

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

let testPal = isPalindrom('racecar');

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
            
            break;
            
        default:
            console.log("not a type you can print");
    }
}

//9. Object literal
//Define function traverseObject(someObj)
//Print every property and it's value.

let obj = {
    name: 'kyle',
    pass: 'password',
    email: 'kylesettles@email.com'
};

for(let prop in obj){
    console.log(prop + ": " + obj[prop]);
}

//10. Delete Element
//Define function deleteElement(someArr)
//Print length
//Delete the third element in the array.
//Print length
//The lengths should be the same.

function deleteElement(someArr){
    console.log(someArr.length);
    delete someArr[2];
    console.log(someArr.length);
}

let arr = [1,2,3,4,5];

deleteElement(arr);

//11. Splice Element
//Define function spliceElement(someArr)
//Print length
//Splice the third element in the array.
//Print length
//The lengths should be one less than the original length.

function spliceElement(someArr){
    console.log(someArr.length);
    someArr.splice(3,1);
    console.log(someArr.length);
}

let arr2 = [1,2,3,4,5];
spliceElement(arr2);

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

//-----------------------------------------------------------------------------------
//PART II
//
//Part II will focus on Javascript's ability to manipulate the DOM.
//Use the provided index.html
//Put your Javascript in the provided <script> or in an external .js file referenced by that script tag element at the bottom of the page.
//Please put the question itself as a comment above each answer.
//
//-----------------------------------------------------------------------------------
//
//1. USA
//Define function getUSA()
//Find the html element that contains "USA".
//Print that element's contents.




//2. Sales
//Define function getPeopleInSales()
//Print the names of all the people in the sales department.




//3. Click Here
//Define function getAnchorChildren()
//Find all anchor elements with a <span> child.
//Print the contents of <span>




//4. Hobbies
//Define function getHobbies()
//Find all checked options in the 'skills' select element.
//Print the value and the contents.




//5. Custom Attribute
//Define function getCustomAttribute()
//Find all elements with "data-customAttr" attribute
//Print the value of the attribute.
//Print the element that has the attribute.




//6. Sum Event
//NOTE: Write unobtrusive Javascript
//Regarding these elements:
//	<input id="num1" class="nums" type="text"/>
//	<input id="num2" class="nums" type="text"/>
//	<h3>Sum: <span id="sum"></span></h3>




//Define onchange event handler.
//Add <input> element values.
//Put the sum in the <span> element.
//If values cannot be added, put "Cannot add" in the <span> element




//7. Skills Event
//NOTE: Write unobtrusive Javascript
//When user selects a skill, create an alert with a message similar to:
//	"Are you sure CSS is one of your skills?"
//NOTE: no alert should appear when user deselects a skill.




//8. Favorite Color Event
//NOTE: Write unobtrusive Javascript
//NOTE: This is regarding the favoriteColor radio buttons.
//When a user selects a color, create an alert with a message similar to:
//	"So you like green more than blue now?"
//In this example, green is the new value and blue is the old value.
//Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor




//9. Show/Hide Event
//NOTE: Write unobtrusive Javascript
//When user hovers over an employees name:
//	Hide the name if shown.
//	Show the name if hidden.




//10. Current Time
//Regarding this element:
//	<h5 id="currentTime"></h5>
//Show the current time in this element in this format: 9:05:23 AM
//The time should be accurate to the second without having to reload the page.




//11. Delay
//Regarding this element:
//	<p id="helloWorld">Hello, World!</p>
//Three seconds after a user clicks on this element, change the text to a random color.




//12. Walk the DOM
//Define function walkTheDOM(node, func)
//This function should traverse every node in the DOM. Use recursion.
//On each node, call func(node).



