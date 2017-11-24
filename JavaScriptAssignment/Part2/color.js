/*
8. Favorite Color Event
NOTE: Write unobtrusive Javascript
NOTE: This is regarding the favoriteColor radio buttons.
When a user selects a color, create an alert with a message similar to:
	"So you like green more than blue now?"
In this example, green is the new value and blue is the old value.
Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
*/
let color = (select) => {
    let bColor = document.body.style.backgroundColor;
    alert("So you like "+select.value+" more than "+bColor+ " now?");
    switch(select.value){

      case 'blue':
        bColor = "blue";
        break;
      case 'red':
        bColor = "red";
        break;
      case 'green':
        bColor = "green";
        break;
      case 'orange':
        bColor = "orange";
        break;
    }
    document.body.style.backgroundColor = bColor;
}