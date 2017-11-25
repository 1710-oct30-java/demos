// Javascript Homework
// Due Friday
// -----------------------------------------------------------------------------------
// PART I

// Create a single Javascript file called packet.js to answer these questions.
// Please put the question itself as a comment above each answer.
// -----------------------------------------------------------------------------------

// 1. Fibonacci
// Define function: fib(n) 
// Return the nth number in the fibonacci sequence.
function fib(n) {
    let result = 1;
    let previousResult = 0;
    let total = 0;
    for (var index = 0; index < n; index++) {
        total += previousResult + result;
        previousResult = result;
        result = total;
    }

    return total;
}

// 2. Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array.
// Return the sorted array.
function bubbleSort(numArray) {
    let sorted = false;

    while (sorted == false) {
        sorted = true;

        for (var i = 0; i < numArray.length; i++) {
            if (i == numArray.length - 1) continue;

            if (numArray[i] > numArray [i+1]) {
   
                sorted = false;
                let temp = numArray[i];
                numArray[i] = numArray[i+1];
                numArray[i+1] = temp;
            }
        }
    }

    return numArray;
}

// 3. Reverse String
// Define function: reverseStr(someStr)
// Reverse and return the String.
function reverseStr(someStr) {
    return someStr.split("").reverse().join(""); 
}

// 4. Factorial
// Define function: factorial(someNum)
// Use recursion to compute and return the factorial of someNum.
function factorial(someNum) {
    if (someNum == 0) return 1;
    else if (someNum < 0) return -1;

    return someNum*(factorial(someNum-1));
}

// 5. Substring
// Define function substring(someStr, length, offset)
// Return the substring contained between offset and (offset + length) inclusively.
// If incorrect input is entered, use the alert function and describe why the input was incorrect.
function substring(someStr, length, offset) {
    if (someStr && toString(someStr)) {
        return someStr.substring(offset, length);
    }
    else alert("Input incorrect.")

}

// 6. Even Number
// Define function: isEven(someNum)
// Return true if even, false if odd.
// Do not use % operator.
function isEven(someNum) {
    while(someNum > 0) {
        someNum -= 2;
    }

    if (someNum == 0) return true;
    else return false;
}

// 7. Palindrome
// Define function isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false
function isPalindrome(someStr) {
    original = someStr;

    someStr = someStr.split("").reverse().join(""); 

    if (original == someStr) return true;
    else return false;
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
    let temp = "";
    switch (shape) {
        case "Square":
            for (var index = 0; index < height; index++) {
                for (var index2 = 0; index2 < height; index2++) {
                    temp += character;                  
                }
                console.log(temp);
                temp ="";
            }
            break;
        case "Triangle":
            for (var index = 0; index < height; index++) {
                for (var index2 = 0; index2 <= index; index2++) {
                    temp += character;
                }
                console.log(temp);
                temp ="";
            }
            break; 
        case "Diamond":
            for (var index = 0; index < array.length; index++) {
                for (var index2 = 0; index2 < array.length; index2++) {
                    
                    
                }
            }
        default:
            break;
    }
}

// 9. Object literal
// Define function traverseObject(someObj)
// Print every property and it's value.
function traverseObject(someObj) {
    for (var x in someObj) {
        console.log(x);
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
    someArr[2] = null;
    console.log(someArr.length);
    console.log(someArr);
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
    console.log(someArr);
}

// 12. Defining an object using a constructor
// Define a function Person(name, age)
// The following line should set a Person object to the variable john:
// 	var john = new Person("John", 30);
function Person(name, age) {
    this.name = name;
    this.age = age;
}

var john = new Person("John", 30);
console.log(john.age);

// 13. Defining an object using an object literal
// Define function getPerson(name, age)
// The following line should set a Person object to the variable john:
// 	var john = getPerson("John", 30);
function getPerson(name, age) {
    return new Person(name, age);
}
 
john = getPerson("John", 40);
console.log(john.age);
 



