/*1. Fibonacci
Define function: fib(n) 
Return the nth number in the fibonacci sequence.
*/

function fib(n) {
let firstNum = 0;
let secondNum = 1;

let sum = firstNum + secondNum;
let i = 0;

    if(n == 1) {
        return 0;
    }

    else if (n == 2) {
        return 1;
    }

    else {
        for (i = 0;i < n;i++) {
            sum = firstNum + secondNum;
            temp = sum;
            secondNum = temp;


        }
    }
}

/*
2. Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted array.
*/

let numArray = [3,1,2,9,7,5,6,10,8,4];
function bubbleSort(numArray) {
    
    let temp = 0;
    let i = 0;
    let j = 0;
    let k = 0;

    for (j = 0; j < numArray.length-1;j++) {
        for (i = 0; i < numArray.length-1;i++) {

            if(numArray[i] > numArray[i+1]) {
                temp = numArray[i];
                numArray[i] = numArray[i+1];
                numArray[i+1] = temp;
            }
        }
    }

    for (k = 0; k < numArray.length;k++) {
        console.log(numArray[k]);

        if(k < numArray.length-1) {
            console.log(", ");
        }
    }

}

/*
3. Reverse String
Define function: reverseStr(someStr)
Reverse and return the String.
*/
function reverseStr(someStr) {
    this.someStr = someStr;
    let myString = "";
    for (let i = someStr.length-1; i >= 0; i--) {
        myString = myString + someStr[i];
    }
    return myString;
}

/*
4. Factorial
Define function: factorial(someNum)
Use recursion to compute and return the factorial of someNum.
*/
function factorial(someNum) {
    this.someNum = someNum;
    if (someNum == 0) {
        return 1;
    }
    return someNum * factorial(someNum - 1);
}
/*
5. Substring
Define function substring(someStr, length, offset)
Return the substring contained between offset and (offset + length) inclusively.
If incorrect input is entered, use the alert function and describe why the input was incorrect.
*/

/*
6. Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.
*/
function isEven(num) {
    let quotient = num/2;

    if((quotient)*2 == num) {
        console.log("num is even");
        return true;
    }

    else {
        console.log("num is odd");
        return false;
    }
}
/*
7. Palindrome
Define function isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false
*/

function isPalindrome(someStr) {
    this.someStr = someStr;
    let reversedString = "";
    for (let i = someStr.length-1; i >= 0; i--) {
        reversedString = reversedString + someStr[i];
    }

    if(someStr === reversedString) {
        return true;
    }

    else {
        return false;
    }
}
/*
8. Shapes
Define function: printShape(shape, height, character)
shape is a String and is either "Square", "Triangle", "Diamond".
height is a Number and is the height of the shape. Assume the number is odd.
character is a String that represents the contents of the shape. Assume this String contains just one character.
Use a switch statement to determine which shape was passed in.
Use the console.log function to print the desired shape.
Example for printShape("Square", 3, "%");
%%%
%%%
%%%
Example for printShape("Triangle", 3, "$");
$
$$
$$$
Example for printShape("Diamond", 5, "*");
  *
 ***
*****
 ***
  *
*/

function printShape(shape, height, character) {
    this.shape = shape;
    this.height = height;
    this.character = character;

    
}

/*
9. Object literal
Define function traverseObject(someObj)
Print every property and it's value.
*/

/*
10. Delete Element
Define function deleteElement(someArr)
Print length
Delete the third element in the array.
Print length
The lengths should be the same.
*/

/*
11. Splice Element
Define function spliceElement(someArr)
Print length
Splice the third element in the array.
Print length
The lengths should be one less than the original length.
*/

/*
12. Defining an object using a constructor
Define a function Person(name, age)
The following line should set a Person object to the variable john:
	var john = new Person("John", 30);
*/

/*
13. Defining an object using an object literal
Define function getPerson(name, age)
The following line should set a Person object to the variable john:
	var john = getPerson("John", 30);
 */
 
 
 
 /*
-----------------------------------------------------------------------------------
PART II

Part II will focus on Javascript's ability to manipulate the DOM.
Use the provided index.html
Put your Javascript in the provided <script> or in an external .js file referenced by that script tag element at the bottom of the page.
Please put the question itself as a comment above each answer.

-----------------------------------------------------------------------------------
*/

/*
1. USA
Define function getUSA()
Find the html element that contains "USA".
Print that element's contents.
 */ 

/*
2. Sales
Define function getPeopleInSales()
Print the names of all the people in the sales department.
 */ 

/*
3. Click Here
Define function getAnchorChildren()
Find all anchor elements with a <span> child.
Print the contents of <span>
*/

/*
4. Hobbies
Define function getHobbies()
Find all checked options in the 'skills' select element.
Print the value and the contents.
*/ 

/*
5. Custom Attribute
Define function getCustomAttribute()
Find all elements with "data-customAttr" attribute
Print the value of the attribute.
Print the element that has the attribute.
*/

/*
6. Sum Event
NOTE: Write unobtrusive Javascript
Regarding these elements:
	<input id="num1" class="nums" type="text"/>
	<input id="num2" class="nums" type="text"/>
	<h3>Sum: <span id="sum"></span></h3>

Define onchange event handler.
Add <input> element values.
Put the sum in the <span> element.
If values cannot be added, put "Cannot add" in the <span> element
*/

/*
7. Skills Event
NOTE: Write unobtrusive Javascript
When user selects a skill, create an alert with a message similar to:
	"Are you sure CSS is one of your skills?"
NOTE: no alert should appear when user deselects a skill.
*/

/*
8. Favorite Color Event
NOTE: Write unobtrusive Javascript
NOTE: This is regarding the favoriteColor radio buttons.
When a user selects a color, create an alert with a message similar to:
	"So you like green more than blue now?"
In this example, green is the new value and blue is the old value.
Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
*/

/*
9. Show/Hide Event
NOTE: Write unobtrusive Javascript
When user hovers over an employees name:
	Hide the name if shown.
	Show the name if hidden.
*/

/*
10. Current Time
Regarding this element:
	<h5 id="currentTime"></h5>
Show the current time in this element in this format: 9:05:23 AM
The time should be accurate to the second without having to reload the page.
*/

/*
11. Delay
Regarding this element:
	<p id="helloWorld">Hello, World!</p>
Three seconds after a user clicks on this element, change the text to a random color.
*/

/*
12. Walk the DOM
Define function walkTheDOM(node, func)
This function should traverse every node in the DOM. Use recursion.
On each node, call func(node).
*/