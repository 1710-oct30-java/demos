function truthyCheck(test) {
    if (test) {
        console.log("value passed in is truthy");
    }

    else {
        console.log("value passed in is falsy");
    }

    
}

function equalsCheck(one, two) {
    if (one == two) {
        console.log("== returned true");
    }

    else {
        console.log("== returned false");
    }

    if (one === two) {
        console.log("=== returned true");
    }

    else {
        console.log("=== returned false");
    }
}

function Person(name, gender) {

}

function factorial(someNum) {
    let product = 1;
    product = product * someNum;

    if (someNum > 1) {
        return product * factorial(someNum-1);
    }
}