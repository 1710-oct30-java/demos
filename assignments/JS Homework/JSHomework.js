//  Javascript Homework
//  Due Friday Morning
//  Put all homework in:
//  	...../1704-apr10-java/Firstname_Lastname_Code/Javascript_Homework/

//  -------------------------------------------------------------------------------
//  PART I

//  Create a single Javascript file called packet.js to answer these questions.
//  Please put the question itself as a comment above each answer.
//  -------------------------------------------------------------------------------

//  1. Fibonacci
//  Define function: fib(n) 
//  Return the nth number in the fibonacci sequence.
function fib(n)
{
    if(n === 0)
        return n;
    if(n === 1)
        return n;
    let n1 = 0;
    let n2 = 1;
    let count = n-2;
    while(count > 0)
    {
        let temp = n1 + n2;
        n2 = temp;
        n1 = n2;
        count = count - 1;
    }
    return n2;
}
//  2. Bubble Sort
//  Define function: bubbleSort(numArray)
//  Use the bubble sort algorithm to sort the array.
//  Return the sorted array.
function bubbleSort(numArray)
{
    let flag = false;
    let i = 0;
    do{
        flag = false; 
        for(i = 0; i < numArray.length - 1; i++)
        {
            if(numArray[i] > numArray[i+1])
            {
                let temp = numArray[i+1];
                numArray[i+1] = numArray[i];
                numArray[i] = temp;
                flag = true;
            }
        }
    }while(flag)
    return numArray;
}
//  3. Reverse String
//  Define function: reverseStr(someStr)
//  Reverse and return the String.
function reverseStr(someStr)
{
    let temp = "";
    let i = 0;
    for(i = someStr.length -1; i >= 0; i--)
    {
       temp =  temp.concat(someStr[i]);
    }
    return temp;
}
//  4. Factorial
//  Define function: factorial(someNum)
//  Use recursion to compute and return the factorial of someNum.
function factorial(someNum)
{
    if(someNum === 0)
        return 0;
    return someNum + factorial(someNum-1);
}
//  5. Substring
//  Define function substring(someStr, length, offset)
//  Return the substring contained between offset and (offset + length) inclusively.
//  If incorrect input is entered, use the alert function and describe why the input was incorrect.
function substring(someStr, length, offset )
{
    if(typeof(someStr) !== "string")
    {
        alert("Your string isn't a string!");
        return;
    }
    else if(typeof(length) !== "number" || typeof(offset) !== "number")
    {
        alert("Your int isn't a number!");
        return;
    }
    else if (length + offset >= someStr.length)
    {
        alert("ARRAYINDEXOUTOFBOUNDSEXCEPTION e");
        return;
    }
    else if ( length < 0 || offset < 0)
    {
        alert("NO NEGATIVE NUMBERS!");
        return;
    }
    else
    {
        let a = "";
        for(let i = offset; i < offset + length; i++)
        {
            a = a.concat(someStr[i]);
        }
        return a;
    }
}
//  6. Even Number
//  Define function: isEven(someNum)
//  Return true if even, false if odd.
//  Do not use % operator.
function isEven(someNum)
{
    return someNum === (Math.floor(someNum/2) * 2)
}
//  7. Palindrome
//  Define function isPalindrome(someStr)
//  Return true if someStr is a palindrome, otherwise return false
function isPalindrome(someStr)
{
    let i = 0;
    let j = someStr.length-1;
    while(i < j)
    {
        if(someStr[i] !== someStr[j])
        {
            return false;
        }
        i++;
        j--;
    }
    return true;
    
}
//  8. Shapes
//  Define function: printShape(shape, height, character)
//  shape is a String and is either "Square", "Triangle", "Diamond".
//  height is a Number and is the height of the shape. Assume the number is odd.
//  character is a String that represents the contents of the shape. Assume this String contains just one character.
//  Use a switch statement to determine which shape was passed in.
//  Use the console.log function to print the desired shape.
//  Example for printShape("Square", 3, "%");
//  %%%
//  %%%
//  %%%
//  Example for printShape("Triangle", 3, "$");
//  $
//  $$
//  $$$
//  Example for printShape("Diamond", 5, "*");
//    *
//   ***
//  *****
//   ***
//    *
function printShape(shape, height, character)
{
    switch(shape)
    {
        case("Square"):
        for(let i = 0; i < height; i ++)
        {
            let printthis = "";
            for(let j = 0; j < height; j++)
            {
                printthis = printthis.concat(character);   
            }
            console.log(printthis);
        }
        break;
        case("Triangle"):
        for(let i = 0; i < height; i++)
        {
            let printthis = "";
            for(let j = 0; j <= i; j ++)
            {
                printthis = printthis.concat(character);
            }
            console.log(printthis);
        }
        break;
        case("Diamond"):
        for(let i = 0; i < height; i++)
        {
            let printthis = "";
            //insert spaces
            let spaces = Math.abs(i - Math.floor(height/2));
            for(let k = 0; k < spaces; k++)
            {
                printthis = printthis.concat(" ");
            }
            //insert characters
            for(let j = 0; j < height - (spaces*2); j++)
            {
                printthis = printthis.concat(character);
            }
            for(let k = 0; k < spaces; k++)
            {
                printthis = printthis.concat(" ");
            }
            console.log(printthis);
        }
        break;
        default:
            alert("bad shape")
            return;
    }
}
//  9. Object literal
//  Define function traverseObject(someObj)
//  Print every property and it's value.
function traverseObject(someObj)
{
    for(let prop in someObj)
    {
        console.log(`Property: ${prop} and Value: ${someObj[prop]}`)
    }
}
//  10. Delete Element
//  Define function deleteElement(someArr)
//  Print length
//  Delete the third element in the array.
//  Print length
//  The lengths should be the same.
function deleteElement(someArr)
{
    console.log(`SomeArr length before delete : ${someArr.length}`);
    delete someArr[3];
    console.log(`SomeArr length after delete : ${someArr.length}`);
}
//  11. Splice Element
//  Define function spliceElement(someArr)
//  Print length
//  Splice the third element in the array.
//  Print length
//  The lengths should be one less than the original length.
function spliceElement(someArr)
{
    console.log(`SomeArr length before splice : ${someArr.length}`);
    someArr.splice(3,1);
    console.log(`SomeArr length after splice : ${someArr.length}`);
}
//  12. Defining an object using a constructor
//  Define a function Person(name, age)
//  The following line should set a Person object to the variable john:
//  	var john = new Person("John", 30);
function Person(name, age)
{
    this.name = name;
    this.age = age;
}
//  13. Defining an object using an object literal
//  Define function getPerson(name, age)
//  The following line should set a Person object to the variable john:
//  	var john = getPerson("John", 30);
 function getPerson(name,age)
 {
     return { name: name, age: age};
 }
 
 
 
 
//  ----------------------------------------------------------------------------------------------
//  PART II

//  Part II will focus on Javascript's ability to manipulate the DOM.
//  Use the provided index.html
//  Put your Javascript in the provided <script> or in an external .js file referenced by that script tag element at the bottom of the page.
//  Please put the question itself as a comment above each answer.

//  ----------------------------------------------------------------------------------------------

//  1. USA
//  Define function getUSA()
//  Find the html element that contains "USA".
//  Print that element's contents.
  function getUSA()
  {
    let usa = document.querySelector('[data-customAttr="USA"]');
    console.log(usa);
  }
//  2. Sales
//  Define function getPeopleInSales()
//  Print the names of all the people in the sales department.
  function getPeopleInSales()
  {
    let tableRows = document.getElementsByTagName("tr");
    for(let i = 0; i < tableRows.length; i++)
    {
        if(tableRows[i].innerHTML.includes("Sales"))
        {
            console.log(tableRows[i].innerText.split("\t")[0]);
        }
    }
  }
//  3. Click Here
//  Define function getAnchorChildren()
//  Find all anchor elements with a <span> child.
//  Print the contents of <span>
  function getAnchorChildren()
  {
    let anchors = document.querySelectorAll("a > span");
    for(let i = 0; i < anchors.length; i++)
    {
            console.log(anchors[i]);
        }
  }
//  4. Hobbies
//  Define function getHobbies()
//  Find all checked options in the 'skills' select element.
//  Print the value and the contents.
  function getHobbies()
  {
    let hobbies = document.getElementsByName("skills");
    let checked = hobbies[0].options[hobbies[0].selectedIndex].value;
    console.log(checked);
    console.log(hobbies[0].options[hobbies[0].selectedIndex]);
  }
//  5. Custom Attribute
//  Define function getCustomAttribute()
//  Find all elements with "data-customAttr" attribute
//  Print the value of the attribute.
//  Print the element that has the attribute.
  function getCustomAttribute()
  {
    let custom = document.querySelectorAll("[data-customAttr");
    for(let i = 0; i < custom.length ; i++)
    {
        console.log(custom[i].attributes[0].nodeValue);
        console.log(custom[i].nodeName);
    }

  }
//  6. Sum Event
//  NOTE: Write unobtrusive Javascript
//  Regarding these elements:
//  	<input id="num1" class="nums" type="text"/>
//  	<input id="num2" class="nums" type="text"/>
//  	<h3>Sum: <span id="sum"></span></h3>
//  Define onchange event handler.
//  Add <input> element values.
//  Put the sum in the <span> element.
//  If values cannot be added, put "Cannot add" in the <span> element
document.getElementById("num1").addEventListener("input",sumEvent);
document.getElementById("num2").addEventListener("input",sumEvent);
function sumEvent()
{
    let num1 = document.getElementById("num1").value;
    let num2 = document.getElementById("num2").value;
    let outcome = parseInt(num1) + parseInt(num2);
    if(isNaN(outcome))
        outcome = "Cannot add"
    document.getElementById("sum").innerHTML = outcome
}
//  7. Skills Event
//  NOTE: Write unobtrusive Javascript
//  When user selects a skill, create an alert with a message similar to:
//  	"Are you sure CSS is one of your skills?"
//  NOTE: no alert should appear when user deselects a skill.
document.getElementsByName("skills")[0].addEventListener("change",skillsEvent);
function skillsEvent()  
{
    let choice = document.getElementsByName("skills");
    let actualchoice = choice[0].options[choice[0].selectedIndex].value;
    alert(`Are you sure ${actualchoice} is one of your skills?`);
}
//  8. Favorite Color Event
//  NOTE: Write unobtrusive Javascript
//  NOTE: This is regarding the favoriteColor radio buttons.
//  When a user selects a color, create an alert with a message similar to:
//  	"So you like green more than blue now?"
//  In this example, green is the new value and blue is the old value.
//  Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
let color = {
    color:"no",
    setColor: function setColor(color){this.color = color;}
}

function prevColor()
{

    for(let i = 0; i < elements.length; i++)
    {
        if(elements[i].checked)
        {
            color.setColor(elements[i].value);
            return;
        }
    }
}
let elements = document.getElementsByName('favoriteColor');
for(let i = 0; i < elements.length; i++)
{
    elements[i].onmousedown = prevColor;
    elements[i].onclick = favoriteColorEvent;
}

function favoriteColorEvent()
{
    let c = "no";
    for(let i = 0; i < elements.length; i++)
    {
        if(elements[i].checked)
        {
            c = elements[i].value;
            break;
        }
    }
    if(c != color.color && color.color !== "no")
    {
        alert(`So you like ${c} more than ${color.color} now?`);
        for(let i = 0; i < elements.length; i++)
        {
            elements[i].style.background = c;
        }
    }
    console.log(c);
}
//  9. Show/Hide Event
//  NOTE: Write unobtrusive Javascript
//  When user hovers over an employees name:
//  	Hide the name if shown.
//  	Show the name if hidden.
let empNames = document.getElementsByClassName("empName");
for(let i = 0; i < empNames.length; i ++)
{
    //empNames[i].addEventListener('onmouseover',show_hideEvent(empNames[i]),false);
    empNames[i].onmouseover = show_hideEvent;
    empNames[i].style.opacity = 1;
}
function show_hideEvent(empName)
{
    if(empName.path[0].style.opacity == 1)
    {
        empName.path[0].style.opacity = 0;
    }
    else
    {
        empName.path[0].style.opacity = 1;
    }
}
//  10. Current Time
//  Regarding this element:
//  	<h5 id="currentTime"></h5>
//  Show the current time in this element in this format: 9:05:23 AM
//  The time should be accurate to the second without having to reload the page.

currentTime();
function currentTime()
{
    let timeelement = document.getElementById("currentTime");
    let date = new Date();
    timeelement.innerText = `${date.getHours()}:${date.getMinutes()}:${date.getSeconds()}`;
    setTimeout(currentTime,1000);
}
//  11. Delay
//  Regarding this element:
//  	<p id="helloWorld">Hello, World!</p>
//  Three seconds after a user clicks on this element, change the text to a random color.
document.getElementById("helloWorld").onclick = Delay;
function Delay()
{
    setTimeout(changeColor,3000);
}
function changeColor()
{
    let colors = ["red","blue","green","black","white","teal","yellow","orange"]
    let ele = document.getElementById("helloWorld");
    ele.style.backgroundColor = colors[Math.floor(Math.random() * 8)];
}
//  12. Walk the DOM
//  Define function walkTheDOM(node, func)
//  This function should traverse every node in the DOM. Use recursion.
//  On each node, call func(node).
function walkTheDOM(node, func)
{
    for(let i = 0; i < node.length; i++)
    {
        walkTheDOM(node[i].childNodes,func);
    }
    func(node);
}
function func(node)
{
    if(node.length > 0)
    console.log(node);
}

