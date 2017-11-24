/*
6. Sum Event
NOTE: Write unobtrusive Javascript
Regarding these elements:
	<input id="num1" class="nums" type="text"/>
	<input id="num2" class="nums" type="text"/>
    <h3>Sum: <span id="sum"></span></h3>
*/
let sum = (someElement) => {
    let a;
    let b; 
    let c;

    a = document.getElementById("num1").value;
    b = document.getElementById("num2").value;
    c = a + b;
    document.getElementById("sum").innerHTML = c;
}