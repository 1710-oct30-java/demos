
//------------------------------------------------------------//
//                          PART I                            //
//------------------------------------------------------------//

// 1. Fibonacci
function fib(n) {
    if(n < 1) {
        return 0;
    }
    
    else if(n <= 2) {
        return 1;
    }
    
    else {
        return fib(n-1) + fib(n-2);
    }
}

// 2. Bubble Sort
function bubbleSort(numArray) {
    for(let i = 0; i < numArray.length-1; i++) {
        for(let j = 0; j < numArray.length-i-1; j++) {
            if(numArray[j] > numArray[j+1]) {
                
                let tmp = numArray[j];
                numArray[j] = numArray[j+1];
                numArray[j+1] = tmp;
            }
        }
    }
}

// 3. Reverse String
function reverseStr(str) {
    let tmp = '';
    for(let i = str.length-1; i >= 0; i--) {
        tmp = tmp + str.charAt(i);
    }
    return tmp;
}

// 4. Factorial
function factorial(num) {
    return (num < 2) ? 1 : num * factorial(num-1);
}

// 5. Substring
function substring(str, length, offset) {
    if(offset + length > str.length) {
        alert('invalid substring operation: length and offset must fit within the given string.');
    }
    else {
        let newString = '';

        for(let i = offset; i < offset+length; i++) {
            newString = newString + str.charAt(i);
        }
        return newString;
    }
}

// 6. Even Number
// I feel dirty using the same method twice but it should be fine.
// The only requirement was we can't use mod.
function isEven(num) {
    return trunc(num/2)*2 == num;

    function trunc(n) {
        return (n > 0) ? Math.floor(n) : Math.ciel(n);
    }
}

// 7. Palindrom
function isPalindrome(str) {
    for(let i = 0; i < str.length/2; i++) {
        if(str.charAt(i) !== str.charAt(str.length-i-1)) {
            return false;
        }
    }

    return true;
}

// 8. Shapes
function printShape(shape, height, char) {
    shape = shape.toLowerCase();

    switch(shape) {
        case 'square':
            for(let i = 0; i < height; i++) {
                let strLine = '';
                for(let j = 0; j < height; j++) {
                    strLine = strLine + char;
                }
                console.log(strLine);
            }
            break;
        case 'triangle':
            for(let i = 0; i < height; i++) {
                let strLine = '';
                for(let j = 0; j <= i; j++) {
                    strLine = strLine + char;
                }
                console.log(strLine);
            }
            break;
        case 'diamond':
            for(let i = 0; i < height; i++) {
                let strLine = '';
                let intSpaces = abs(height-1-i*2)/2;
                let intChars = height-intSpaces*2;
                
                for(let j = 0; j < intSpaces; j++) {
                    strLine = strLine + ' ';
                }
                for(let j = 0; j < intChars; j++) {
                    strLine = strLine + char;
                }
                for(let j = 0; j < intSpaces; j++) {
                    strLine = strLine + ' ';
                }
                console.log(strLine);
            }
            break;
    }

    function abs(num) {
        return (num < 0) ? -num : num;
    }
}

// 9. Object Literal
function traverseObject(obj) {
    for(let prop in obj) {
        console.log(prop + ':' + obj[prop]);
    }
}

// 10. Delete Element
function deleteElement(arry) {
    console.log('Length before deletion: ' + arry.length);
    delete arry[2];
    console.log('Length after deletion: ' + arry.length);
}

// 11. Splice Element
function spliceElement(arry) {
    console.log('Length before splice: ' + arry.length);
    arry.splice(2, 1);
    console.log('Length after splice: ' + arry.length);
}

// 12. Defining an object using a constructor
function Person(name, age) {
    this.name = name;
    this.age = age;
}

// 13. Defining an object using an object literal
function getPerson(name, age) {
    let person = {"name":name, "age":age};
    return person;
}

//------------------------------------------------------------//
//                          PART II                           //
//------------------------------------------------------------//

// 1. USA
function getUSA() {
    let elements = document.getElementsByTagName('*');

    for(let i = 0; i < elements.length; i++) {

        if(elements[i].innerText === 'USA') {
            console.log(elements[i].innerText);
        }
    }
}

// 2. Sales
function getPeopleInSales() {
    let table = document.getElementsByTagName('table');
    let elements = table[0].children[0].children;

    for(let i = 0; i < elements.length; i++) {

        if(elements[i].innerHTML.includes('Sales')) {
            console.log(elements[i].getElementsByTagName('td')[0].innerText);
        }
    }
}

// 3. Click Here
function getAnchorChildren() {
    let anchors = document.getElementsByTagName('a');

    for(let i = 0; i < anchors.length; i++) {
        let spans = anchors[i].getElementsByTagName('span');

        for(let j = 0; j < spans.length; j++) {
            console.log(spans[j].innerText);
        }
    }
}

// 4. Hobbies
function getHobbies() {
    let elements = document.getElementsByName('skills');
    let skills = elements[0];

    let options = skills.children;

    for(let i = 0; i < options.length; i++) {
        console.log('value: ' + options[i].value + '; contents: ' + options[i].innerText);
    }
}

// 5. Custom Attribute
function getCustomAttribute() {
    let elements = document.getElementsByTagName('*');

    for(let i = 0; i < elements.length; i++) {
        if(elements[i].hasAttribute('data-customAttr')) {
            console.log('element ' + elements[i].tagName + ' has data-customAttr of ' + elements[i].getAttribute('data-customAttr'));
        }
    }
}

// 6. Sum Event
function sumNums() {
    let num1 = document.getElementById('num1').value;
    let num2 = document.getElementById('num2').value;
    let sum = Number.parseInt(num1) + Number.parseInt(num2);

    let sumElement = document.getElementById('sum');

    if(Number.isNaN(sum)) {
        sumElement.innerText = 'Cannot add';
    }
    else {
        sumElement.innerText = sum;
    }
}

document.getElementById('num1').onchange = sumNums;
document.getElementById('num2').onchange = sumNums;

// 7. Skills Event
function setEventToSkills() {
    let elements = document.getElementsByName('skills');
    let skills = elements[0];

    skills.onchange = () => {

        let x = skills.children;
        let str = '';
        for(let i = 0; i < x.length && str === ''; i++) {
            if(x[i].value === skills.value) {
                str = x[i].innerText;
            }
        }
        alert('Are you sure ' + str + ' is one of your skills?');
    }
}

setEventToSkills();

// 8. Favorite Color Event
let oldColorIndex;

function onChangeColor() {
    let radios = document.getElementsByName('favoriteColor');
    let index;

    for(let i = 0; i < radios.length; i++) {
        if(radios[i].checked) {
            index = i;
            break;
        }
    }

    if(oldColorIndex === undefined) {
        alert('So you like ' + radios[index].value + '?');
    }
    else {
        alert(`So you like ${radios[index].value} more than ${radios[oldColorIndex].value} now?`);
    }

    for(let i = 0; i < radios.length; i++) {
        // This has no visible effect in the browser, but it does manipulate
        // the property. The console.log is to show that.
        radios[i].style.backgroundColor = `${radios[index].value}`;
        console.log(`${radios[i].value}'s background color is ${radios[i].style.background}`);

        // Changing the parentElement's background impact's the radio button's
        //radios[i].parentElement.style.backgroundColor = `${radios[index].value}`;
    }

    oldColorIndex = index;
}

function setChangeColor() {
    let radios = document.getElementsByName('favoriteColor');

    for(let i = 0; i < radios.length; i++) {

        radios[i].onchange = onChangeColor;
    }
}

setChangeColor();

// 9. Show/Hide Event
function setEmployeeHover() {
    let elements = document.getElementsByClassName('empName');  

    for(let i = 0; i < elements.length; i++) {
        elements[i].onmouseover = showHide;
    }

    console.log(elements);
}

setEmployeeHover();

function showHide() {

    // There are several takes on showing/hiding
    // I originally changed the display property, but
    // that removes the ability to mouse over the text
    // I decided to use an invisible color instead
    if(this.style.color === 'rgba(0, 0, 0, 0)') {
        this.style.color = 'black';
    }
    else {
        this.style.color = 'rgba(0, 0, 0, 0)';
    }
}

// 10. Current Time

setInterval(function() {
    let pTime = document.getElementById('currentTime');
    let currentDate = new Date();
    pTime.innerText = `${currentDate.getHours()}:${currentDate.getMinutes()}:${currentDate.getSeconds()}`;

}, 1000);

// 11. Delay

document.getElementById('helloWorld').onclick = () => {
    setTimeout(colorChange, 3000);
}

function colorChange() { // I couldn't think of a better name.
    let r = Math.floor(Math.random()*255);
    let g = Math.floor(Math.random()*255);
    let b = Math.floor(Math.random()*255);
    let result = `rgb(${r}, ${g}, ${b})`;

    document.getElementById('helloWorld').style.color = result;
}