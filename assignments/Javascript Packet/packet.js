// 1. Fibonacci
// Define function: fib(n) 
// Return the nth number in the fibonacci sequence.

function fib(n){
    let n1 = 0;
    let n2 = 1;
    let temp;

    if (n == 0){
        return 0;
    }
    else if (n == 1){
        return 1;
    }

    else {
        for (let i = 0; i < n; i++){
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }
        return n3;
    }
}

// 2. Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array.
// Return thesorted array.
function bubbleSort(numArray){
    for (let i = 0; i < numArray.length; i++){
        for (let j = 0; j < numArray.length-1; j++) {
            if (numArray[j] > numArray[j+1]) {
                let temp = numArray[j];
                numArray[j] = numArray[j+1];
                numArray[j+1] = temp;
            }
        }
    }
    return numArray;
}

// 3. Reverse String
// Define function: reverseStr(someStr)
// Reverse and return the String.
function reverseStr(someStr){
    let reversedString = '';
    for (let i = someStr.length-1; i >= 0; i--) {
        reversedString += someStr.charAt(i); 
    }
    return reversedString;
}

// 4. Factorial
// Define function: factorial(someNum)
// Use recursion to compute and return the factorial of someNum.
function factorial(someNum) {
    if (someNum < 0){
        alert('negative number');
    }
    else if (someNum == 0){
        return 1;
    } else {
        return (someNum * factorial(someNum-1));
    }
}

// 5. Substring
// Define function substring(someStr, length, offset)
// Return the substring contained between offset and (offset + length) inclusively.
// If incorrect input is entered, use the alert function and describe why the input was incorrect.
function subString(someStr, length, offset){
    let substring = '';

    if (offset < 0){
        alert('negative offset');
    }
    else if (offset + length > someStr.length-1){
        alert('string out of bounds');
    }

    else {
        for (let i = offset; i <= offset+length; i++){
            substring += someStr.charAt(i);
        }
    }
    return substring;
}

// 6. Even Number
// Define function: isEven(someNum)
// Return true if even, false if odd.
// Do not use % operator.
function isEven(someNum){
    if (someNum == 0){
        return 'even';
    }
    else {
        while (someNum > 0) {
            someNum -=2;
            if (someNum == 0) {
                return 'even';
            }
            else if (someNum < 0){
                return 'odd';
            }
        }
    }
}

// 7. Palindrome
// Define function isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false
function isPalindrome(someStr){
    let palindrome = true;
    for (let i = 0, j = someStr.length-1; i <= Math.floor(someStr.length/2) && j >= Math.floor(someStr.length/2); i++, j--){
        if (someStr.charAt(i) != someStr.charAt(j)){
            palindrome = false;
        }
    }
    return palindrome;
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
function printShape(shape, height, character){
    switch(shape) {
        case 'Triangle':
        let printTriangle = '';
        for (let i = 1; i <= height; i++){
                printTriangle += character;
                console.log(printTriangle);
        }
        break;
        case 'Square':
        let printSquare = '';
        for (let i = 1; i <= height; i++){
                printSquare += character;
            }
            console.log(printSquare);
            console.log(printSquare);
            console.log(printSquare);
        break;
        case 'Diamond':
        //2 space 1 character 2 space
        //0 space 3 character 0 space
        //2 space 1 character 2 space
        let space = height-1;
        for (space; space >=0; space-=2){
        let printDiamond = '';
            for (let j = 0; j < space/2; j++){
                printDiamond += ' ';
            }
            for (let k = height-space; k > 0; k--){
                printDiamond += character;
            }
            for (let l = 0; l < space; l++){
                printDiamond += ' ';
            }
            console.log(printDiamond);
        }
        space+=4;
        for (space; space <= height-1; space+=2){
            let printDiamond = '';
            for (let j = 0; j < space/2; j++){
                printDiamond += ' ';
            }
            for (let k = height-space; k > 0; k--){
                printDiamond += character;
            }
            for (let l = 0; l < space; l++){
                printDiamond += ' ';
            }
            console.log(printDiamond);
        }
        break;
        default:
        console.log('unknown shape');
    }
}

// 9. Object literal
// Define function traverseObject(someObj)
// Print every property and it's value.
function traverseObject(someObj){
    for (let prop in someObj){
        console.log(prop + ": " + someObj[prop]); 
    }
}

// 10. Delete Element
// Define function deleteElement(someArr)
// Print length
// Delete the third element in the array.
// Print length
// The lengths should be the same.
function deleteElement(someArr){
    console.log('before deletion: ' + someArr.length);
    delete someArr[2];
    console.log('after deletion: ' + someArr.length);
}

// 10. Delete Element
// Define function deleteElement(someArr)
// Print length
// Delete the third element in the array.
// Print length
// The lengths should be the same.
function spliceElement(someArr){
    console.log('before splice: ' + someArr.length);
    let index = 2;
    someArr.splice(index, 1);
    console.log('after splice: ' + someArr.length);
}

// 12. Defining an object using a constructor
// Define a function Person(name, age)
// The following line should set a Person object to the variable john:
// 	var john = new Person("John", 30);
function Person(name, age){
        this.name = name;
        this.age = age;

        this.getName = function(){
            return name;
        }

        this.getAge = function(){
            return age;
        }

}

// 13. Defining an object using an object literal
// Define function getPerson(name, age)
// The following line should set a Person object to the variable john:
// 	var john = getPerson("John", 30);
function getPerson(name,age){
    let person = {
        'name' : name,
        'age' : age
    };
    return person;
}


