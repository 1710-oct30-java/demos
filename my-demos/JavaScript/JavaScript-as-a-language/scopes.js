
// var is function scoped and let is block scoped
function myFun() {
  
  // the declaration of a is hoisted to the top but it is not assigned until later
  // so here it will have a value of undefined
  console.log("a = " + a);

  if(true) {
    var a = 5;
    let b = 10;
    console.log('a is declared with var and a = ' + a);
    console.log('b is declared with let and b = ' + b);
  }

  console.log('outside of the block a = ' + a);
  console.log('outside of the block b = ' + b);
}

myFun();