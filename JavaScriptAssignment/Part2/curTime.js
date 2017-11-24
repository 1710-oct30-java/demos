/*
10. Current Time
Regarding this element:
	<h5 id="currentTime"></h5>
Show the current time in this element in this format: 9:05:23 AM
The time should be accurate to the second without having to reload the page.
*/
let curTime = () => {
    let dt = new Date();
    document.getElementById("currentTime").innerHTML = dt.toLocaleTimeString();
    window.setTimeout("curTime()", 1000);
}
  curTime();