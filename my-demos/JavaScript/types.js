
// numbers have type number
// NaN is of type number
typeof(5);

// strings are of type string
// strings can be declared with single quote ('), double quotes ("), or back ticks (`), also known as template literals
// template literals can be multiple lines and can have expressions
let a = 5;
console.log(`hello
world
a+10 = ${a + 10}
`);


// functions are their own type
function myFun() {

}

// very similar to the above
// let myFun = function() {

// }

typeof(myFun);


// objects are a type
// null is of type object
// arrays are of type object
let blake = {
	name:'hello',
  password: 'pass',
  getName: function() {
    return this.name;
  }
}
typeof(blake);


// undefined is a type
typeof(undefined);



