
function myFun() {
  console.log("called myFun!");
}

let otherFun = (param1) => {
  console.log("called otherFun!!!");
  console.log(param1);
}

myFun();
otherFun(10);