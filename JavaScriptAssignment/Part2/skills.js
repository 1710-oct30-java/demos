/*
7. Skills Event
NOTE: Write unobtrusive Javascript
When user selects a skill, create an alert with a message similar to:
	"Are you sure CSS is one of your skills?"
NOTE: no alert should appear when user deselects a skill.
*/
let skills = (select) => {
    alert("Are you certain "+ select.options[select.selectedIndex].text + " is one of your skills?");
}