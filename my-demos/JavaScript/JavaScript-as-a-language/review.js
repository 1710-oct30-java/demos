"use strict";
// declaration of hoisted is brought here but assignment still hasn't happened
console.log(hoisted);

// ES6 arrow notation
let add = (first, second) => {
  return first + second;
}

function otherAdd(first, second) {
  return first + second;
}

// now hoisted is assigned a value don't use var
if(true) {
  var hoisted = 5;
}

let c = {
  inheritableField: 10
}

let d = {};
d.__proto__ = c;

console.log(`d inherits ${d.inheritableField} from c`);


function Dog(name, breed) {
  let dogsName = name;
  if(!this.__proto__.dogCount) {
    this.__proto__.dogCount = 0;
  }
  this.__proto__.dogCount++
  this.breed = breed;

  this.getName = function() {
    return dogsName;
  }
  this.setName = function(name) {
    dogsName = name;
  }
}

let sparky = new Dog('sparky', 'lab');
let spots = new Dog('spots', 'dalimation');
