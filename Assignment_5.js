//Author: Stephen Huelsman

//1. Fibonacci
//Define function: fib(n) 
//Return the nth number in the fibonacci sequence
function fib(n){
    if(n === 0){
        return 0;
    }
    else if (n==1){
        return 1;
    }
    else{
        return fib(n-1) + fib(n-2); 
    }
    
}


//2. Bubble Sort
//Define function: bubbleSort(numArray)
//Use the bubble sort algorithm to sort the array.
//Return the sorted array.
function bubbleSort(numArray){
    let finished = false;
    let temp = 0;
    
    while(finished==false) {
        finished = true;
        for(let i = 0; i < numArray.length-1; i++) {
            if(numArray[i] > numArray[i+1]) {
                temp = numArray[i];
                numArray[i] = numArray[i+1];
                numArray[i+1] = temp;
                finished = false;
            }
        }
    }
    return numArray;
}

//3. Reverse String
//Define function: reverseStr(someStr)
//Reverse and return the String.
function reverseStr(someStr){
    let d = "";
    
    
    for(let x = 0; x < someStr.length(); x++) {
        d = d + someStr.charAt(someStr.length()-1 - x);
        }
    return someStr;
}

//4. Factorial
//Define function: factorial(someNum)
//Use recursion to compute and return the factorial of someNum.
function factorial(someNum){
    if(someNum === 0){
        return 0;
    }
    else if(someNum == 1){
        return 1;
    }
    else{
        return someNum*factorial(someNum-1);
    }
}

//5. Substring
//Define function substring(someStr, length, offset)
//Return the substring contained between offset and (offset + length) inclusively.
//If incorrect input is entered, use the alert function and describe why the input was incorrect.
function substring(someStr, length, offset){
    let output = "";
    if(offset>someStr.length || (offset+length)>someStr.length){
        alert("Offset input too large");
        return output;
    }
    else{
        for(let i = offset; i <(offset+length) ; i++ ) {
			output = output + someStr.charAt(i);
		}
		return output;
    }
}

//6. Even Number
//Define function: isEven(someNum)
//Return true if even, false if odd.
//Do not use % operator.
function isEven(someNum){
    let x = someNum();		
    let y = 0;
    let z = 0;
    
    y = x/2;
    z = y*2;
    
    if(z==x) {
        return true;
    }
    else {
        return false;
    }
}

//7. Palindrome
//Define function isPalindrome(someStr)
//Return true if someStr is a palindrome, otherwise return false
function isPalindrome(someStr){
    let otherStr = someStr.reverseStr;
    if(someStr == otherStr){
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
    let outShape = ``;
    
    switch(shape){
        case "Square":
        for(i=0; i < height; i++){
            for(j=0; j<height;j++){
                outShape = outShape + character;
            }
            outShape = outShape + `\``;
        }
        console.log(outShape);
        break;

        case "Triangle":

        break;
        
        case "Diamond":
        
        break;

    }


}


//9. Object literal
//Define function traverseObject(someObj)
//Print every property and it's value.
function traverseObject(someObj){
    for (let propertyName in someObj){
        propertyValue = someObj[propertyName]
        console.log(propertyName, propertyValue);
    }
}


//10. Delete Element
//Define function deleteElement(someArr)
//Print length
//Delete the third element in the array.
//Print length
//The lengths should be the same.

function deleteElement(someArr){
    print(someArr.length);
    delete someArr[2];
    print(someArr.length);
}

//11. Splice Element
//Define function spliceElement(someArr)
//Print length
//Splice the third element in the array.
//Print length
//The lengths should be one less than the original length.
function deleteElement(someArr){
    print(someArr.length);
    someArr.splice(2,1);
    print(someArr.length);
}

//12. Defining an object using a constructor
//Define a function Person(name, age)
//The following line should set a Person object to the variable john:
//	var john = new Person("John", 30);

function Person(newName, newAge){
    this.name = newName;
    this.age = newAge;
}

//13. Defining an object using an object literal
//Define function getPerson(name, age)
//The following line should set a Person object to the variable john:
//	var john = getPerson("John", 30);

function getPerson(someName, someAge){
    let newPerson = {name: someName, age: someAge}
    return newPerson;
}