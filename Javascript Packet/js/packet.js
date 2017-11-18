 /*
 * SUPPORTING FUNCTIONS ARE LOCATED IN packet-functions.js
 * FOR ORGANIZATION
 */

 /*
    * 1. Fibonacci
    * Define function: fib(n) 
    * Return the nth number in the fibonacci sequence.
    */ {
      console.log("\nQuestion 1: Fibonacci Sequencer");
      console.log( "The 10th number in the Fibonacci sequence is: " + fib(10) );
    }

    /*
    * 2. Bubble Sort
    * Define function: bubbleSort(numArray)
    * Use the bubble sort algorithm to sort the array.
    * Return the sorted array.
    */ {
      console.log("\nQuestion 2: Bubble Sort");
      let numArray = [1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4];
      console.log("Before Sort: " + numArray );
      console.log("After Sort: " + bubbleSort(numArray) );
    }

    /* 
    * 3. Reverse String
    * Define function: reverseStr(someStr)
    * Reverse and return the String.
    */ {
      console.log("\nQuestion 3: Reverse String");
      let str = "aBcDeFgHiJkLmNoPqRsTuVwXyZ";
      console.log("String before reversal: " + str);
      console.log("String after reversal: " + reverseString(str) );
    }

    /*
    * 4. Factorial
    * Define function: factorial(someNum)
    * Use recursion to compute and return the factorial of someNum.
    */ {
      console.log("\nQuestion 4: Factorial");
      console.log("The factorial of number 8 is: " + factorial(8) );
    }

    /*
    * 5. Substring
    * Define function substring(someStr, length, offset)
    * Return the substring contained between offset and (offset + length) inclusively.
    * If incorrect input is entered, use the alert function and describe why the input was incorrect.
    */ {
      console.log("\nQuestion 5: Substring");
      let str = "happyplate";
      console.log("Original String is: " + str);
      console.log("When the function is run like 'substring(str, 8, 1)' you get: " + substring(str, 8, 1) );
      console.log("When the function is run like 'substring(str, 0, 1)' you get an alert." );
      // substring(str, 0, 1);
    }

    /*
    * 6. Even Number
    * Define function: isEven(someNum)
    * Return true if even, false if odd.
    * Do not use % operator.
    */ {
      console.log("\nQuestion 6: Even Number");
      console.log("The number 8 is even is: " + isEven(8) );
      console.log("The number 9 is even is: " + isEven(9) );
    }

    /*
    * 7. Palindrome
    * Define function isPalindrome(someStr)
    * Return true if someStr is a palindrome, otherwise return false
    */ {
      console.log("\nQuestion 7: Palindrome");
      console.log("The word 'Hannah' is a palindrome: " + isPalindrome("Hannah") );
      console.log("The word 'John' is a palindrome: " + isPalindrome("John") );
      console.log("The word 'Civic' is a palindrome: " + isPalindrome("Civic") );
    }

    /*
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
    */ {
      console.log("\nQuestion 8: Shapes");
      printShape("Square", 3, "%");
      printShape("Triangle", 3, "$");
      printShape("Diamond", 5, "*");
    }


    /*
    * 9. Object literal
    * Define function traverseObject(someObj)
    * Print every property and it's value.
    */ {
      console.log("\nQuestion 9: Object Literal");
      traverseObject( FibonacciSequence );
    }

    /*
    * 10. Delete Element
    * Define function deleteElement(someArr)
    * Print length
    * Delete the third element in the array.
    * Print length
    * The lengths should be the same.
    */ {
      console.log("\nQuestion 10: Delete Element");
      someArr = [ 1, 2, 3, 4, 5, 6 ,7, 8];
      
      console.log(`Length of someArr: ${someArr.length}`);
      console.log(`Array: ${ someArr }`);

      console.log(`Length after delete: ${ deleteElement(someArr).length }`);
      console.log(`Array: ${ someArr }`);
      
    } 

    /*
    * 11. Splice Element
    * Define function spliceElement(someArr)
    * Print length
    * Splice the third element in the array.
    * Print length
    * The lengths should be one less than the original length.    
    */ {
      console.log("\nQuestion 11: Splice Element");
       someArr = [ 1, 2, 3, 4, 5, 6 ,7, 8];
      
      console.log(`Length of someArr: ${someArr.length}`);
      console.log(`Array: ${ someArr }`);

      spliceElement(someArr).length;

      console.log(`Length after splice: ${ someArr.length }`);
      console.log(`Array: ${ someArr }`);
    }


    /*
    * 12. Defining an object using a constructor
    * Define a function Person(name, age)
    * The following line should set a Person object to the variable john:
    * var john = new Person("John", 30);
    */ {
      console.log("\nQuestion 12: Object Function Constructor");
      let john = new Person("John", 30);
      console.log( john );
    }


    /*
    * 13. Defining an object using an object literal
    * Define function getPerson(name, age)
    * The following line should set a Person object to the variable john:
    * var john = getPerson("John", 30);
    */ {
      console.log("\nQuestion 13: Object Literal");
      let john = getPerson("John", 30);
      console.log( john );
    }