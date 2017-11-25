/*
Define function: fib(n) 
Return the nth number in the fibonacci sequence.
*/
function fibonacci (num) {
    let a = 0;
    let b = 1;
    let temp;

    while (num >= 0) {
        temp = a;
        a = a + b;
        b = temp;
        num--;
    }

    return a;
}

/*
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted array.
*/
function bubbleSort(numArray) {
    for(let h = 0; h < numArray.length; h++) {
        for(let i = 0; i < numArray.length; i++) {
            if(numArray[i] > numArray[i+1]) {
                let temp = numArray[i];
                numArray[i] = numArray[i+1];
                numArray[i+1] = temp;
            }
        }
    }

    for(let j = 0; j < numArray.length; j++) {
        console.log(numArray[j]);
    }
}

/*
Define function: reverseStr(someStr)
Reverse and return the String.
*/
function reversedString(a_string) {
    let lastIndex = a_string.length - 1;
    let reversedString;

    for(let i = 0; i < a_string.length; i++) {
        let temp = a_string.charAt(lastIndex);
        reversedString = reversedString + temp;
        lastIndex--;
    }
    return reversedString;
}

/**
Define function: factorial(someNum)
Use recursion to compute and return the factorial of someNum.
 */
function factorial(someNum) {
    let factor = someNum - 1;
    
    while(factor != 0) {
        someNum = someNum * factor;
        factor--;
    }
    return someNum;
}

/*Define function substring(someStr, length, offset)
Return the substring contained between offset and (offset + length) inclusively.
*/
function mySubString(a_string, someNum) {
    let newString = '';

    for(let i = 0; i <= someNum; i++) {
        newString = newString += a_string.charAt(i);
    }
    return newString;
}
/*
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.
*/
function evenNumber(someNum) {
    if((Math.floor(someNum/2))*2 == someNum){
        console.log('number is even')
    } else {
        console.log('the number is odd')
    }
}

/*
Define function isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false
*/
function myPalindrome(someStr) {
    if(someStr === someStr.split("").reverse().join("")) {
        return true;
    }
    return false;
}
/*
Define function: printShape(shape, height, character)
shape is a String and is either "Square", "Triangle", "Diamond".
height is a Number and is the height of the shape. Assume the number is odd.
character is a String that represents the contents of the shape. Assume this String contains just one character.
Use a switch statement to determine which shape was passed in.
Use the console.log function to print the desired shape.
*/

function printShape(shape, height, character) {
    if(shape == "square") {
        let cols = height;
        for(let i = 0; i < height; i++) {
			//loop through the columns and print an asterisk for each column of the row
			for(let j = 0; j < cols; j++) {
				console.log(character);
			}
			//go to next row
			console.log();
		}

    }
    
    if(shape == "triangle") {
        let spaces = height - 1;
		for(let i = 0; i < height; i++) {
			//this row is going to print asterisks that is equal to the row minus the spaces count
			for(let j = 0; j < height - spaces; j++) {
				console.log(character);
			}
			console.log();
			spaces--;
		}
    }
    
    if(shape == "diamond") {
        let spaces = height - 1;
		for(let i = 0; i < height; i++) {
			
			//print the spaces out in front of each row
			for(let j = 0; j < spaces; j++) {
				console.log(" ");
			}
			
			for(let j = 0; j < height - spaces; j++) {
				console.log("* ");
			}
			console.log();
            spaces--;
        }
    }
}

// 9. Object literal
// Define function traverseObject(someObj)
// Print every property and it's value.
function traverseObject(someObj) {
    for(prop in someObj) {
        console.log('prop: ' + prop + ' ' + 'value: ' + someObj[prop]);
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
    someArr.splice(2, 1);
    console.log(someArr.length);
}

// 12. Defining an object using a constructor
// Define a function Person(name, age)
// The following line should set a Person object to the variable john:
// 	var john = new Person("John", 30);
function Person(name, age) {
    this.name = name;
    this.age = age
}


// 13. Defining an object using an object literal
// Define function getPerson(name, age)
// The following line should set a Person object to the variable john:
// 	var john = getPerson("John", 30);
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
    let targetTags = document.getElementsByTagName("span")[2].textContent;
    console.log(targetTags);
}

// 2. Sales
// Define function getPeopleInSales()
// Print the names of all the people in the sales department.
function getPeopleInSales() {
    let peopleInSales = $('td:contains(Sales)').prev($('td')).text();
    return peopleInSales;
}

// 3. Click Here
// Define function getAnchorChildren()
// Find all anchor elements with a <span> child.
// Print the contents of <span>
function getAnchorChildren() {
    let anchorElementsWithSpans = $('a > span').text();
    return anchorElementsWithSpans;
}

// 4. Hobbies
// Define function getHobbies()
// Find all checked options in the 'skills' select element.
// Print the value and the contents.
function getHobbies() {
    //let checkedSkills = $('select[name="skills"]:selected');
    let checkedSkills = $('select[name="skills"] option:selected').text();
    return checkedSkills;
}

// 5. Custom Attribute
// Define function getCustomAttribute()
// Find all elements with "data-customAttr" attribute
// Print the value of the attribute.
// Print the element that has the attribute.
function getCustomAttribute() {
    let customAttribute = $('*[data-customAttr]');
    return customAttribute;
}
