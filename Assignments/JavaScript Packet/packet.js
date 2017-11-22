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

let fib = function(n) {
    values = [0, 1];
    if(n == 1) return values[0];
    if(n == 2) return values[1];
    let value;
    for(let i = 3; i <= n; i++) {
        value = values[0] + values[1];
        values[0] = values[1];
        values[1] = value;
    }
    return value;
}

// 2. Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array.
// Return the sorted array.

let bubbleSort = function(arr) {
    let sorted = true;
    do {
        sorted = true;
        for(let i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i+1]) {
                sorted = false;
                let temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
    } while(!sorted);
    
    return arr;
}


// 3. Reverse String
// Define function: reverseStr(someStr)
// Reverse and return the String.

//TODO
let reverseStr = function(str) {

    for(var i = str.length; i >= 0; i--) {
        str += str.charAt(i);
    }
    return str.replace(str.substring(0, str.length/2), '');
}

// 4. Factorial
// Define function: factorial(someNum)
// Use recursion to compute and return the factorial of someNum.

let factorial = function(someNum) {
    if(someNum < 0) return Infinity;
    return someNum == 1 || someNum == 0 ? 1 : someNum *= factorial(someNum-1);
}

// 5. Substring
// Define function substring(someStr, length, offset)
// Return the substring contained between offset and (offset + length) inclusively.
// If incorrect input is entered, use the alert function and describe why the input was incorrect.

let substring = function(someStr, length, offset) {
    //Starting position is less than 0
    if(Math.abs(offset) > someStr.length) {
        alert("Can not create substring of negative value.") 
        return;
    }

    //final point is greater than string length
    if(offset+length >= Math.abs(someStr.length)) {
        alert("Substring offset can not be greater than the length of provided string.")
        return;
    }

    //if offset is negative, start from the end of the String
    if(offset < 0) offset = someStr.length - offset;

    //if length is negative, reverse swap offset and length and return a reversed string
    if(reverse = length < 0){
        length = Math.abs(length);
        [offset, length] = [length, offset];
    }

    let newStr = '';
    //typical behavior
    for(let i = offset; i <= offset+length; i++) {
        newStr += someStr.charAt(i);
    }

    //Return the string, or if reverse is specified reverse the Str first
    return reverse ? reverseStr(newStr) : newStr;

}

// 6. Even Number
// Define function: isEven(someNum)
// Return true if even, false if odd.
// Do not use % operator.

let isEven = function(someNum) {
    let ones = someNum.charAt(-1);
}


// 7. Palindrome
// Define function isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false

let isPalindrome = function(someStr) {
    for(var i = 0; i < someStr.length/2; i++) {
        if(! someStr.charAt(i) == someStr.charAt(str.length - i)) return false;
    }
    return true;
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


let printShape = function(shape, size, char) {

    let printSquare = function(size, char) {
        //TODO use concatination rather than just outputting, output at end of line
        
        // if(size == 0) return;
        let str = '';
        for(let x = 0; x < size; x++) {
            str += getLine(size, char) + '\n';
        }
        console.log(str);
    }

    let printTriangle = function(size, char) {
        let str = '';
        for(let i = 1; i <= size; i++) {
            str += getLine(i, char) + '\n';
        }
        console.log(str);
    }

    let printDiamond = function(size, char) {
        let midVal = Math.ceil(size / 2);
        let str = '';
        for(let i = 1; i <= size; i++) {
            let curDiff = Math.abs(midVal - i);
            str += getLine(curDiff, ' ') + getLine(size - (curDiff * 2), char) + '\n';
        }
        console.log(str);
    }

    let getLine = function(length, char) {
        if(length == 0) return '';
        str = char;
        for(let i = 1; i < length; i++) {
            str += char;
        }
        return str;
    }

    switch(shape) {
        case 'square':
            printSquare(size, char);
            break;
        case 'triangle':
            printTriangle(size, char);
            break;
        case 'diamond':
            printDiamond(size, char);
            break;
    }
}

// 9. Object literal
// Define function traverseObject(someObj)
// Print every property and it's value.

let traverseObject = function(someObj) {
    for(value in Object.values(someObj)) {
        console.log(Object.values(someObj)[value]);
    }
}

// 10. Delete Element
// Define function deleteElement(someArr)
// Print length
// Delete the third element in the array.
// Print length
// The lengths should be the same.

let deleteElement = function(someArr) {
    console.log(someArr.length);
    delete someArr[3];
    console.log(someArr.length);
}

// 11. Splice Element
// Define function spliceElement(someArr)
// Print length
// Splice the third element in the array.
// Print length
// The lengths should be one less than the original length.

let spliceElement = function(someArr) {
    console.log(someArr.length);
    someArr.splice(3, 1);
    console.log(someArr.length);
}

// 12. Defining an object using a constructor
// Define a function Person(name, age)
// The following line should set a Person object to the variable john:
// 	var john = new Person("John", 30);

function Person(name, age) {
    this.name = name;
    this.age = age;
}

let john = new Person("John", 30);

// 13. Defining an object using an object literal
// Define function getPerson(name, age)
// The following line should set a Person object to the variable john:
// 	var john = getPerson("John", 30);
 
 function getPerson(n, a) {
    literal = {name: n, age: a};
    return literal;
 }

 let molly = getPerson('Molly', 28);    
 
 
 
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
let usa = $("span:contains('USA')");
console.log(usa[0].innerText);


// 2. Sales
// Define function getPeopleInSales()
// Print the names of all the people in the sales department.
  
let getPeopleInSales = function() {
    let rows = $('table tr:has(td:contains("Sales")) .empName')
            .each( (k, v) => console.log(v.innerText));
}

// 3. Click Here
// Define function getAnchorChildren()
// Find all anchor elements with a <span> child.
// Print the contents of <span>

let getAnchorChildren = function() {
    $("a span").each( (k, v) => console.log(v.innerText));
}
  
// 4. Hobbies
// Define function getHobbies()
// Find all checked options in the 'skills' select element.
// Print the value and the contents.
  
let getHobbies = function() {
    console.log($("select[name='hobbies']").find(":selected").text());
}


// 5. Custom Attribute
// Define function getCustomAttribute()
// Find all elements with "data-customAttr" attribute
// Print the value of the attribute.
// Print the element that has the attribute.

let getCustomAttribute = function() {
    $("*[data-customAttr]").each( (k, v) => {
        console.log($(v).attr('data-customAttr'));
        console.log(v);
    });
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

let setup = function() {
    let first =  document.getElementById('num1');
    let second = document.getElementById('num2');
    
    first .addEventListener('change', updateSum);
    second.addEventListener('change', updateSum);
}

let updateSum = function() {
    console.log('updating...');
    let first =   document.getElementById('num1');
    let second =  document.getElementById('num2');
    let sumSpan = document.getElementById('sum');
    
    let summation = Number(first.value) + Number(second.value);
    sumSpan.innerText = isNaN(summation) ? 'Cannot add' : summation;
    
}

setup();

// 7. Skills Event
// NOTE: Write unobtrusive Javascript
// When user selects a skill, create an alert with a message similar to:
// 	"Are you sure CSS is one of your skills?"
// NOTE: no alert should appear when user deselects a skill.

let skillsSetup = function() {
    $('*[name="skills"]').change(function(e) {
        $(this).find('*:selected').each( (k, v) => {
            window.alert(`Are you sure ${v.innerText} is one of your skills?`)
        });
    });
}

skillsSetup();

// 8. Favorite Color Event
// NOTE: Write unobtrusive Javascript
// NOTE: This is regarding the favoriteColor radio buttons.
// When a user selects a color, create an alert with a message similar to:
// 	"So you like green more than blue now?"
// In this example, green is the new value and blue is the old value.
// Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
let oldFavorite;
$('*[name="favoriteColor').change(function(e) {
    if(oldFavorite === undefined) oldFavorite = $(this);
    else {
        //Get previous and current string values
        let oldColor = $(oldFavorite).attr('value');
        let newColor = $(this).attr('value');
        
        //alert
        window.alert(`So you like ${newColor} more than ${oldColor} now?`);
        
        //set old favorite to this
        oldFavorite = $(this);
    }
    //update background colors (doesn't appear to have any visual change in Chrome)
    $('*[name="favoriteColor').css('background', $(this).attr('value'));

})

// 9. Show/Hide Event
// NOTE: Write unobtrusive Javascript
// When user hovers over an employees name:
// 	Hide the name if shown.
// 	Show the name if hidden.

    $('.empName').mousein(function() {
        $(this).is(":visible").removeAttr('visible');
        
        //if hidden, unhide
        //else hide
    });


// 10. Current Time
// Regarding this element:
// 	<h5 id="currentTime"></h5>
// Show the current time in this element in this format: 9:05:23 AM
// The time should be accurate to the second without having to reload the page.
let eTimer = document.getElementById('currentTime');
setInterval(function() {
    date = new Date();
    let seconds = pad(date.getSeconds());
    let minutes = pad(date.getMinutes());
    let hours = date.getHours();
    let ampm = date.getHours() > 12 || date.getHours() == 24 ? 'PM' : 'AM';
    eTimer.innerText = `${hours}:${minutes}:${seconds} ${ampm}`;
}, 100);

let pad = function(val) {
    return val >= 10 ? val : '0'+val;
}

// 11. Delay
// Regarding this element:
// 	<p id="helloWorld">Hello, World!</p>
// Three seconds after a user clicks on this element, change the text to a random color.

// 12. Walk the DOM
// Define function walkTheDOM(node, func)
// This function should traverse every node in the DOM. Use recursion.
// On each node, call func(node).


