/*
1. Fibonacci
Define function: fib(n) 
Return the nth number in the fibonacci sequence.
*/
let fib = (count) => {
    
    let firstNumber=0;
    let secondNumber=1;
    let sum = 0;
    
    //print the first two numbers 0 and 1
    console.log(firstNumber);
    console.log(secondNumber);
    
    //begin fibonacci sequence starting at 2 since 0 and 1 have already been printed
    for(let i=2; i<count; ++i)
    {
        sum = firstNumber+secondNumber;
        console.log
      (sum);
        firstNumber=secondNumber;
        secondNumber=sum;
    }
    }
/*
2. Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted array.
*/
let numArray = [1,0,5,6,3,2,3,7,9,8,4];
let bubbleSort = (numArray) => {
	
	// bubble sort
	for(let j=0; j < numArray.length - 1; j++)
	{
		for(let i=0; i<numArray.length - j - 1; i++)
		{
			if(numArray[i]>numArray[i+1])
			{
				let temp = numArray[i];
				numArray[i] = numArray[i+1];
				numArray[i+1] = temp;
			}
		}
	}
        return numArray;
    
}
/*
3. Reverse String
Define function: reverseStr(someStr)
Reverse and return the String.
*/
let someStr = 'hello';
let reverseStr = (someStr) => {
    newStr = '';

    for (let i = someStr.length - 1; i>=0; i--)
    {
        newStr += someStr[i]; 
    }

    return newStr;
}
/*
4. Factorial
Define function: factorial(someNum)
Use recursion to compute and return the factorial of someNum.
*/
let factorial = (someNum) => {
    
    if (someNum === 0) {
        return 1;
    }
    return someNum * factorial(someNum-1);
}
/*
5. Substring
Define function substring(someStr, length, offset)
Return the substring contained between offset and (offset + length) inclusively.
If incorrect input is entered, use the alert function and describe why the input was incorrect.
*/
let substring = (someStr, length, offset) => {
    strArr = [];

    if (offset > someStr.length || length > someStr.length) {
        window.alert("Offset and length cannot be greater than the length of the string");
    }
    else {
        for (let i = 0; i<=someStr.length; i++)
        {
            strArr += someStr[i]; 
        }

        for (offset; offset<=offset+length; offset--)
        {
            console.log(strArr[offset]);
        }
    }
}
/*
6. Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.
*/
let isEven = (someNum) => {
    let number = Math.floor((someNum/2));
    
    //by multiplying by 2, we will receive either a number
    //that is equal if the number is even or a number that is less
    //if the number is odd
    if(number*2 == someNum)
    {
        console.log("Number is even");
    }
    else
    {
        console.log("Number is odd");
    }
}
/*
7. Palindrome
Define function isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false
*/
let isPalindrome = (someStr) => {
    let j = 1;
    
    for (let i = 0; i<someStr.length; i++)
    {
        if (someStr.charAt(i) == someStr.charAt(someStr.length-j))
        {
            j++;
        }
        else
        {
            return false;
        }
    }
    return true;
}
/*
8. Shapes
Define function: printShape(shape, height, character)
shape is a String and is either "Square", "Triangle", "Diamond".
height is a Number and is the height of the shape. Assume the number is odd.
character is a String that represents the contents of the shape. Assume this String contains just one character.
Use a switch statement to determine which shape was passed in.
Use the console.log function to print the desired shape.
*/
let printShape = (shape, height, character) => {
    
    if (shape == 'Triangle')
    {
        for(let x=0; x<=height; x++)
        {
            for(let y=0; y<x; y++)
            {
                console.log(character);
            }
            console.log("<br>");
        }
    }
    else if (shape == 'Square')
    {
        for (let i = 0; i < height; i++)
        { 
            for (let j = 0; j < height; j++)
            {
                console.log(character);
            } 
            console.log("\n");
        }
    }
    else if (shape == 'Diamond')
    {
        for (let i = 1; i < 10; i += 2) 
        {
            for (let j = 0; j < 9 - i / 2; j++)
              console.log(" ");
      
            for (let j = 0; j < i; j++)
              console.log(character);
      
            console.log("\n");
        }

        
    for (let i = 7; i > 0; i -= 2) 
    {
        for (let j = 0; j < 9 - i / 2; j++)
          console.log(" ");
  
        for (let j = 0; j < i; j++)
          console.log(character);
  
        console.log("\n");
    }
    }
    else
    {
        console.log("Valid shapes are 'Square', 'Triangle', and 'Diamond'")
    }
}
/*
9. Object literal
Define function traverseObject(someObj)
Print every property and it's value.
*/
let person = {
    firstName:"John",
    lastName:"Doe",
    age:50,
    eyeColor:"blue"
};
let traverseObject = (someObj) => {
    let result = "";
    for (x in someObj) {
        if (someObj.hasOwnProperty(x)) {
        result += x + " , " + someObj[x] + "\n";
        }
    }
    return result;
}
/*
10. Delete Element
Define function deleteElement(someArr)
Print length
Delete the third element in the array.
Print length
The lengths should be the same.
*/
let arr = [0,1,2,3,4,5];
let deleteElement = (someArr) => {
    console.log(someArr);

    delete someArr[2];

    console.log(someArr);
}
/*
11. Splice Element
Define function spliceElement(someArr)
Print length
Splice the third element in the array.
Print length
The lengths should be one less than the original length.
*/
let spliceElement = (someArr) => {
    console.log(someArr.length);

    someArr.splice(2,1);

    console.log(someArr.length);
}
/*
12. Defining an object using a constructor
Define a function Person(name, age)
The following line should set a Person object to the variable john:
var john = new Person("John", 30);
*/
let Person = (name, age) => {
    this.name = name;
    this.age = age;
}
/*
13. Defining an object using an object literal
Define function getPerson(name, age)
The following line should set a Person object to the variable john:
var john = getPerson("John", 30);
*/
let getPerson = (name, age) => {
    firstName:name;
    yearsOld:age;
}
/************ 
Part II
************/
/*
1. USA
Define function getUSA()
Find the html element that contains "USA".
Print that element's contents.
*/
let getUSA = () => {
    let find = "USA";
    let anchTag = document.body.getElementsByTagName("*");
    console.log(anchTag);
     for (let i = 0; i < anchTag.length; i++) {
        let j = anchTag[i].textContent.search(find);
        //if no match is the search method returns -1
        if(j != -1){
           //prints the element's content 
           alert(anchTag[i].textContent);
           break;
        }
      
     }
}
/*
2. Sales
Define function getPeopleInSales()
Print the names of all the people in the sales department.
*/
let getPeopleInSales = () => { 
   let table = document.getElementsByTagName("table")[0];
   //iterate through the rows of the table
   for (let i = 0; i <table.rows.length;i++){
    //get cells of each row 
    let cells = table.rows[i].cells;
        //2nd element of cells will be department
        //check if department equals Sales
        //if so print name of sales employee
        if(cells[1].textContent === "Sales"){
          alert(cells[0].textContent);
       }
   }
  
}
/*
3. Click Here
Define function getAnchorChildren()
Find all anchor elements with a <span> child.
Print the contents of <span>
*/
let getAnchorChildren = () => {
    let anchor = document.getElementsByTagName("a");
    for (let j = 0; j<anchor.length; j++)
    {
      if (anchor[j].hasChildNodes)
      {
        //let numChildren = anchor[j].children.length;
        console.log(anchor[j].children);
      }
    }
  }
/*
4. Hobbies
Define function getHobbies()
Find all checked options in the 'skills' select element.
Print the value and the contents.
*/
let getHobbies = () => {
    let hobbies = document.getElementsByName("hobbies")[0];
    //use .options to return a collection of all <option> elements
    //in a drop down list and use .selectedIndex to find the options
    //that are selected and finally use .value to return the value of
    //that option 
    let hobbiesSelected = hobbies.options[hobbies.selectedIndex].value;
    let hobbiesContent = hobbies.options[hobbies.selectedIndex].textContent;
    alert(hobbiesContent + ":" + hobbiesSelected);
    //repeat code above for skills
    let skills = document.getElementsByName("skills")[0];
    let skillsSelected = skills.options[skills.selectedIndex].value;
    let skillsContent = skills.options[skills.selectedIndex].textContent;
    alert(skillsContent + ":" + skillsSelected);
}
/*
5. Custom Attribute
Define function getCustomAttribute()
Find all elements with "data-customAttr" attribute
Print the value of the attribute.
Print the element that has the attribute.
*/
let getCustomAttribute = () => {
    //use .querySelectorAll to return the first element that matches
    //the specified CSS selector in the document
    let elements = document.querySelectorAll('[data-customAttr]');
    //iterate through the elements and print them out
    for (let i = 0; i <elements.length;i++){
    alert(elements[i].dataset.customattr);
    }
}
/*
6. Sum Event
NOTE: Write unobtrusive Javascript
Regarding these elements:
	<input id="num1" class="nums" type="text"/>
	<input id="num2" class="nums" type="text"/>
    <h3>Sum: <span id="sum"></span></h3>
*/
let sum = (someElement) => {
    let a;
    let b; 
    let c;

    a = document.getElementById("num1").value;
    b = document.getElementById("num2").value;
    c = a + b;
    document.getElementById("sum").innerHTML = c;
}
/*
7. Skills Event
NOTE: Write unobtrusive Javascript
When user selects a skill, create an alert with a message similar to:
	"Are you sure CSS is one of your skills?"
NOTE: no alert should appear when user deselects a skill.
*/
let skills = (select) => {
    alert("Are you certain "+ select.options[select.selectedIndex].text + " is one of your skills?");
}
/*
8. Favorite Color Event
NOTE: Write unobtrusive Javascript
NOTE: This is regarding the favoriteColor radio buttons.
When a user selects a color, create an alert with a message similar to:
	"So you like green more than blue now?"
In this example, green is the new value and blue is the old value.
Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
*/
let color = (select) => {
    let bColor = document.body.style.backgroundColor;
    alert("So you like "+select.value+" more than "+bColor+ " now?");
    switch(select.value){

      case 'blue':
        bColor = "blue";
        break;
      case 'red':
        bColor = "red";
        break;
      case 'green':
        bColor = "green";
        break;
      case 'orange':
        bColor = "orange";
        break;
    }
    document.body.style.backgroundColor = bColor;
}
/*
9. Show/Hide Event
NOTE: Write unobtrusive Javascript
When user hovers over an employees name:
	Hide the name if shown.
    Show the name if hidden.
*/
let showHide = () => {
    let x = document.getElementsByClassName("empName");
    for (let i=0; i<x.length; i++){
    if (x[i].style.display === "none") {
        x[i].style.display = "block";
        continue;
    } 
    else {
        x[i].style.display = "none";
        break;
    }
    }
  }
/*
10. Current Time
Regarding this element:
	<h5 id="currentTime"></h5>
Show the current time in this element in this format: 9:05:23 AM
The time should be accurate to the second without having to reload the page.
*/
let curTime = () => {
    let dt = new Date();
    document.getElementById("currentTime").innerHTML = dt.toLocaleTimeString();
    window.setTimeout("curTime()", 1000);
}
  curTime();
/*
11. Delay
Regarding this element:
	<p id="helloWorld">Hello, World!</p>
Three seconds after a user clicks on this element, change the text to a random color.
*/
let getRandColor = () => {
    let letters = '0123456789ABCDEF';
    let color = '#';
    for (let i = 0; i < 6; i++) {
      color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
    }
    let setRandColor = () => {
    document.getElementById("helloWorld").style.color = getRandColor();
    }
/*
12. Walk the DOM
Define function walkTheDOM(node, func)
This function should traverse every node in the DOM. Use recursion.
On each node, call func(node).
*/
let walkTheDOM = (node, func) => {
    func(node);
    node = node.firstChild;
    while (node) { 
        walkTheDOM(node, func);
        node = node.nextSibling;
    }
}
  walkTheDOM(document, function (node) {
  console.log("type-", node.nodeType, "name-", node.nodeName);
});