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
    if(n === 0){
        return 0;
    }
    if(n === 1){
        return 1;
    }
    return fib(n - 1) + fib(n - 2);
}

// 2. Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array.
// Return the sorted array.
function bubbleSort(numArray) {
    let i,j;
    for(i = 0; i < numArray.length; i++){
        for(j = 0; j < numArray.length - 1; j++){
            //check neighbors
				if(numArray[j] > numArray[j+1]) {
					//swap
					numArray[j+1] = numArray[j] + numArray[j+1];
					numArray[j] = numArray[j+1] -  numArray[j];
					numArray[j+1] = numArray[j+1] -  numArray[j];
				}
        }
    }
    return numArray;
}
// 3. Reverse String
// Define function: reverseStr(someStr)
// Reverse and return the String.
function reverseStr(someStr) {
    newStr = '';
    let i;
    for(i = 0; i <= someStr.length; i++){
       newStr += someStr.charAt(someStr.length - i);
    }
    return newStr;
}
// 4. Factorial
// Define function: factorial(someNum)
// Use recursion to compute and return the factorial of someNum.
function factorial(someNum){
    if(someNum === 1){
        return 1;
    }
    return someNum*factorial(someNum-1);
}
// 5. Substring
// Define function substring(someStr, length, offset)
// Return the substring contained between offset and (offset + length) inclusively.
// If incorrect input is entered, use the alert function and describe why the input was incorrect.
function substring(someStr, length, offset){
    if(length > someStr.length){
        alert('input length greater than string length');
    }else if( offset+length > someStr.length){
        alert('offset greater than string length');
    }else{
        return someStr.substr(length, offset);
    }
}
// 6. Even Number
// Define function: isEven(someNum)
// Return true if even, false if odd.
// Do not use % operator.
function isEven(someNum){
    someNum /= 2;
    if(someNum.toString().indexOf('.') === -1){
        return true;
    }
    return false;
}
// 7. Palindrome
// Define function isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false
function isPalindrome(someStr){
    let i;
    someStr = someStr.split('');
    for(i = 0; i < someStr.length/2; i++){
        if(someStr[i] !== someStr[someStr.length-i-1]){
            return false;
        }
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
function printShape(shape,height,character){
    let i,j;
    let output = '';

    if(shape === 'Diamond'){
        for(i = 0; i < height; i++){
            if(i <= height/2){
                for(j = i; j < height/2;j++){
                output+=' ';
                }
                output+= character;
                for(j = 0; j < i; j++){
                    output+=character+character;
                }
            }else{
                for(j = 0; j < i - height/2 + 1; j++){
                    output+=' ';
                }
                output+= character;
                for(j = i; j < height-1;j++){
                    output+=character+character;
                }
            }
            output+='\n'
        }
    }
    else{
        for(i = 0; i < height; i++){
            for(j = 0; j < height; j++){
                if(shape === 'Square'){
                    output+=character;
                }
                if(shape === 'Triangle'){
                    if(i >= j){
                        output+=character;
                    }
                }
            }
            output+='\n';
        }
    }
    console.log(output);
}
// 9. Object literal
// Define function traverseObject(someObj)
// Print every property and it's value.
function tranverseObject(someObj){
    let keys = Object.keys(someObj);
    for(let i = 0; i < keys.length; i++){
        console.log(keys[i] +' : '+ someObj[keys[i]]);
    }
}
// 10. Delete Element
// Define function deleteElement(someArr)
// Print length
// Delete the third element in the array.
// Print length
// The lengths should be the same.
function deleteElement(someArr){
    console.log('original length: '+someArr.length);
    if(someArr[2] !== undefined){
        delete someArr[2];
    }
    console.log('length after: '+someArr.length);
}
// 11. Splice Element
// Define function spliceElement(someArr)
// Print length
// Splice the third element in the array.
// Print length
// The lengths should be one less than the original length.
function spliceElement(someArr){
    console.log('original length: '+someArr.length);
    if(someArr[2] !== undefined){
        someArr.splice(2,1);
    }
    console.log('length after: '+someArr.length);
}
// 12. Defining an object using a constructor
// Define a function Person(name, age)
// The following line should set a Person object to the variable john:
// 	var john = new Person("John", 30);
function Person(name, age){
    this.name = name;
    this.age = age;
}
// 13. Defining an object using an object literal
// Define function getPerson(name, age)
// The following line should set a Person object to the variable john:
// 	var john = getPerson("John", 30);
function getPerson(name, age){
    return({'name':name,'age':age});
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
function getUSA(){
    let divs= document.getElementsByTagName('div');
    for (let i = 0;i < divs.length; i++) {
        if (divs[i].innerHTML.indexOf('USA')!= -1){
        console.log(divs[i])
    }
    }
}
// 2. Sales
// Define function getPeopleInSales()
// Print the names of all the people in the sales department.
function getPeopleInSales(){
    let rows = document.getElementsByTagName('tr');
    for(let i = 0; i < rows.length; i++){
        if(rows[i].children[1].innerText == 'Sales'){
            console.log(rows[i].children[0].innerText)
        }
    }
}
// 3. Click Here
// Define function getAnchorChildren()
// Find all anchor elements with a <span> child.
// Print the contents of <span>
function getAnchorChildren(){
    let span = document.getElementsByTagName('span');
    let a = document.getElementsByTagName('a');
        for(let i = 0; i < a.length; i++){
            for(let j = 0; j < span.length; j++){
                if(a[i].contains(span[j])){
                    console.log(span[j].innerText);
                }
            }
        }
}
// 4. Hobbies
// Define function getHobbies()
// Find all checked options in the 'skills' select element.
// Print the value and the contents.
function getHobbies(){
    let skills = document.getElementsByName('skills')[0];
    for(let i = 0; i < skills.length; i++){
        if(skills[i].getAttribute('selected')!=null){

            console.log(skills[i].value +' : '+skills[i].getAttribute('selected'));
        }
    }
}

// 5. Custom Attribute
// Define function getCustomAttribute()
// Find all elements with "data-customAttr" attribute
// Print the value of the attribute.
// Print the element that has the attribute.
function getCustomAttribute(){
    let customAttrs = document.querySelectorAll('[data-customAttr]');
    for(let i = 0; i < customAttrs.length; i++){ 
        console.log(customAttrs[i].getAttribute('data-customAttr'));
        console.log(customAttrs[i])
    }
}
// 6. Sum Event
// NOTE: Write unobtrusive Javascript
// Regarding these elements:
// 	<input id="num1" class="nums" type="text"/>
// 	<input id="num2" class="nums" type="text"/>
// 	<h3>Sum: <span id="sum"></span></h3>
function sumEvent(){
    let num1 = Number(document.getElementById('num1').value);
    let num2 = Number(document.getElementById('num2').value);
    let sum = num1 + num2;
    if(isNaN(sum)){
        document.getElementById('sum').innerText = 'Cannot add';
    }else{
    document.getElementById('sum').innerText = num1 + num2;
    }
}
// Define onchange event handler.
// Add <input> element values.
// Put the sum in the <span> element.
// If values cannot be added, put "Cannot add" in the <span> element

// 7. Skills Event
// NOTE: Write unobtrusive Javascript
// When user selects a skill, create an alert with a message similar to:
// 	"Are you sure CSS is one of your skills?"
// NOTE: no alert should appear when user deselects a skill.
function cssSkill(){
    let skill = document.getElementsByName('skills')[0];
    if(skill.value == 'css'){
        alert('Are you sure CSS is one of your skills?');
    }
}
// 8. Favorite Color Event
// NOTE: Write unobtrusive Javascript
// NOTE: This is regarding the favoriteColor radio buttons.
// When a user selects a color, create an alert with a message similar to:
// 	"So you like green more than blue now?"
// In this example, green is the new value and blue is the old value.
// Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
let oldColor = null;
let newColor = null;
function colorChange(){
    let col = document.getElementsByName('favoriteColor');
    for(let i = 0; i < col.length; i++){
        if(col[i].checked === true){
            oldColor = newColor;
            newColor = col[i].value;
        }
    }
    if(oldColor != null && newColor != null){
        alert('So you like '+newColor+' more than '+oldColor+' now?');
    }
    if(newColor != null){
        for(let i = 0; i < col.length; i++){
            col[i].style.backgroundColor = newColor;
        }
    }
}
// 9. Show/Hide Event
// NOTE: Write unobtrusive Javascript
// When user hovers over an employees name:
// 	Hide the name if shown.
// 	Show the name if hidden.
function hideShow(event){
    if (event.style.color == "white") {
        event.style.color = "black";
    } else {
        event.style.color = "white";
    }
}
// 10. Current Time
// Regarding this element:
// 	<h5 id="currentTime"></h5>
// Show the current time in this element in this format: 9:05:23 AM
// The time should be accurate to the second without having to reload the page.
setInterval(myClock, 500);
function myClock(){
    var d = new Date();
    var t = d.toLocaleTimeString();
    document.getElementById("currentTime").innerHTML = t;    
}

// 11. Delay
// Regarding this element:
// 	<p id="helloWorld">Hello, World!</p>
// Three seconds after a user clicks on this element, change the text to a random color.
function randomColor(){
    
    let letters = '0123456789ABCDEF';
    let color = '#';
    for (var i = 0; i < 6; i++) {
        color += letters[Math.floor(Math.random() * 16)];
    }
    document.getElementById("helloWorld").style.color = color;
}
   
// 12. Walk the DOM
// Define function walkTheDOM(node, func)
// This function should traverse every node in the DOM. Use recursion.
// On each node, call func(node).
function walkTheDOM(node, func){
    let root = document.documentElement;
    let firstChildern = root.childNodes;

    function func(node){
        let children = node.childNodes;
        if(children != undefined){
            for (let i = 0; i < children.length; i++) {
                func(children[i]);
                console.log('node: ' + children[i]);
                //do somthing to child
            }
        }
    }


    for (let i = 0; i < firstChildern.length; i++) {
        func(firstChildern[i]);
        console.log('node: ' + firstChildern[i]);
        //do somthing to child
    }
    //do something to root
    console.log('node: ' + root);
}


