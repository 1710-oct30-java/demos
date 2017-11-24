/**
 * 1. Fibonacci
 * Define function: fib(n) 
 * Return the nth number in the fibonacci sequence.
 */
function fib(n) {
        let result;

        let previousValue = 0;
        let currentValue = 1;
        let nextValue = 0;

        // First case
        if(n === 0) {
            return 0;
        }

        // Second case
        else if(n === 1) {
            return 1;
        }

        // Else loop to print nth number of fib sequence
        else {
            for (let i = 2; i <= n; i++)
            {
                // Get next Fibonacci number
                nextValue = previousValue + currentValue;
    
                result = nextValue;
    
                // Get next values
                // Previous value becomes current value, and current value becomes next value
                previousValue = currentValue;
                currentValue = nextValue;
            }
    
            return result;
        }
}



/**
 * 2. Bubble Sort
 * Define function: bubbleSort(numArray)
 * Use the bubble sort algorithm to sort the array.
 * Return the sorted array.
 */
function bubbleSort(numArray) {
    for(let i = 0; i < numArray.length; i++)
    {
        for(let j = 1; j < numArray.length; j++)
        {
            // Perform swap if arr[j-1] is greater than arr[j]
            if(numArray[j-1] > numArray[j])
            {
                let tmp = numArray[j-1];
                numArray[j-1] = numArray[j];
                numArray[j] = tmp;
            }
        }
    }
    return numArray;
}



/**
 * 3. Reverse String
 * Define function: reverseStr(someStr)
 * Reverse and return the String.
 */
function reverseStr(someStr) {
    for(let i = someStr.length-1; i >= 0; i--) {
        someStr += someStr[i];
    }
    return someStr.substring((someStr.length)/2);
}



/**
 * 4. Factorial
 * Define function: factorial(someNum)
 * Use recursion to compute and return the factorial of someNum.
 */
function factorial(someNum) {
    if(someNum === 0 || someNum === 1) {
        return 1;
    }

    else {
        return someNum * factorial(someNum - 1);
    }
}



/**
 * 5. Substring
 * Define function substring(someStr, length, offset)
 * Return the substring contained between offset and (offset + length) inclusively.
 * If incorrect input is entered, use the alert function and describe why the input was incorrect.
 */
function substring(someStr, length, offset) {
    // Check that offset is a number
    if(typeof(offset) !== typeof(1)) {
        alert("Offset is not a number!");
    }

    // Check that length is a number
    else if(typeof(length) !== typeof(1)) {
        alert("Length is not a number!");
    }

    // Else return subtring
    else {
        return someStr.substring(offset, (offset + length));
    }
}



/**
 * 6. Even Number
 * Define function: isEven(someNum)
 * Return true if even, false if odd.
 * Do not use % operator.
 */
function isEven(someNum) {
    if(typeof(someNum) !== typeof(1)) {
        alert("Input '" + someNum + "' is not a number!");
    }

    else {
        let someNumStr = someNum.toString();
        let pattern = /[02468]$/
        if(someNumStr.match(pattern)) {
            return true;
        }
        return false;
    }
}



/**
 * 7. Palindrome
 * Define function isPalindrome(someStr)
 * Return true if someStr is a palindrome, otherwise return false
 */
function isPalindrome(someStr) {

    // Remove commas, dots, and anything that is not a word
    someStr = someStr.replace(/[^\w]+/g, '');

    let part1 = someStr.substring(0, (someStr.length/2));

    // Use reverse string function from question 3
    let part2 = reverseStr(someStr.substring((someStr.length/2)+1, someStr.length));

    if(part1.toUpperCase() === part2.toUpperCase()) {
        return true;
    }

    return false;
}



/**
 * 8. Shapes
 * Define function: printShape(shape, height, character)
 * shape is a String and is either "Square", "Triangle", "Diamond".
 * height is a Number and is the height of the shape. Assume the number is odd.
 * character is a String that represents the contents of the shape. Assume this String contains just one character.
 * Use a switch statement to determine which shape was passed in.
 * Use the console.log function to print the desired shape.
 * Example for printShape("Square", 3, "%");
 * %%%
 * %%%
 * %%%
 * Example for printShape("Triangle", 3, "$");
 * $
 * $$
 * $$$
 * Example for printShape("Diamond", 5, "*");
 *   *
 *  ***
 * *****
 *  ***
 *   *
 */
function printShape(shape, height, character) {

    let char_tmp = "";
    
    switch(shape) {
        case 'Square':
            for(let i = 0; i < height; i++) {
                for(let j = 0; j < height; j++) {
                    char_tmp += character;
                }
                console.log(char_tmp + "\n");
                char_tmp = ""
            }
            break;

        case 'Triangle':
            for(let i = 0; i < height; i++) {
                for(let j = 0; j <= i; j++) {
                    char_tmp += character;
                }
                console.log(char_tmp + "\n");
                char_tmp = ""
            }
            break;

        case 'Diamond':
            for (let i = 1; i < height; i++) {
                for (let j = 0; j < i; j++) {
                    console.log("*");
                }
                console.log("");
            }
        
            for (let i = height; i > 0; i--) {
                for (let j = 0; j < i; j++) {
                    console.log("*");
                }        
                console.log("");
            }
            break;

        default: alert("Invalid shape! Available shapes: Square, Triangle, Diamond");
            break;
    }
}



/**
 * 9. Object literal
 * Define function traverseObject(someObj)
 * Print every property and it's value.
 */
function traverseObject(someObj) {
    /*for(let i = 0; i < someObj.length; i++) {
        console.log(someObj[i]);
    }*/
    
    for (let i in someObj){
        console.log(someObj[i]);
    }
    
}



/**
 * 10. Delete Element
 * Define function deleteElement(someArr)
 * Print length
 * Delete the third element in the array.
 * Print length
 * The lengths should be the same.
 */
function deleteElement(someArr) {
    console.log(someArr.length);

    delete someArr[2];

    console.log(someArr.length);
}



/**
 * 11. Splice Element
 * Define function spliceElement(someArr)
 * Print length
 * Splice the third element in the array.
 * Print length
 * The lengths should be one less than the original length.
 */
function spliceElement(someArr) {
    console.log(someArr.length);
    
    someArr.splice(2, 1);

    console.log(someArr.length);
}



/**
 * 12. Defining an object using a constructor
 * Define a function Person(name, age)
 * The following line should set a Person object to the variable john:
 *      var john = new Person("John", 30);
 */
function Person(name, age) {
    this.name = name;
    this.age = age;
}


/**
 * 13. Defining an object using an object literal
 * Define function getPerson(name, age)
 * The following line should set a Person object to the variable john:
 *      var john = getPerson("John", 30);
 */
function getPerson(name, age) {
    let person;
    return person = {"name": name, "age": age};
}