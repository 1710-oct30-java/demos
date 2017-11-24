// 1. USA
// Define function getUSA()
// Find the html element that contains "USA".
// Print that element's contents.
function getUSA(){
    let a = document.getElementsByTagName('h1');
    for(let i = 0; i < a.length; i++){
        let b = a[i].children;
        for(let i = 0; i < b.length; i++){
            if(b[i].innerText.includes('USA')){
                console.log(b[i].innerText);
            }
        }
    }
}
  
// 2. Sales
// Define function getPeopleInSales()
// Print the names of all the people in the sales department.
function getPeopleInSales(){
    let myTable = document.getElementsByTagName('table');
    let items = myTable[0].children[0].children;
    for(let i = 1; i < items.length; i++){
        if(items[i].textContent.includes('Sales')){
            console.log(items[i].cells[0].innerText);
        } 
    }
}
    
// 3. Click Here
// Define function getAnchorChildren()
// Find all anchor elements with a <span> child.
// Print the contents of <span>
function getAnchorChildren(){
    let anchors = document.getElementsByTagName('a');
    for(let i = 0; i < anchors.length; i++){
        let spanChild = anchors[i].children;
        for(let j = 0; j < spanChild.length; j++){
            console.log(spanChild[j].innerText);
        }
    }
}
  
// 4. Hobbies
// Define function getHobbies()
// Find all checked options in the 'skills' select element.
// Print the value and the contents.
function getHobbies(){
    let skills = document.getElementsByName('skills');
    //console.log(skills);
    let selected = skills[0].children;
    for( let i = 0; i < selected.length; i++){
        //console.log(selected[i].attributes.getNamedItem('selected')).innerText;
        if(selected[i].getAttribute('selected') == 'selected'){
            console.log(selected[i].innerText);
        }
    }
}

// 5. Custom Attribute
// Define function getCustomAttribute()
// Find all elements with "data-customAttr" attribute
// Print the value of the attribute.
// Print the element that has the attribute.
function getCustomAttribute(){
    let elements = document.querySelectorAll('[data-customAttr]');
    for(let i = 0; i < elements.length; i++){
        console.log(`value of attribute: ${elements[i].getAttribute('data-customAttr')}, 
        element that has attribute: ${elements[i].tagName}`);
    }
}

// 6. Sum Event
// NOTE: Write unobtrusive Javascript
// Regarding these elements:
// 	<input id="num1" class="nums" type="text"/>
// 	<input id="num2" class="nums" type="text"/>
// 	<h3>Sum: <span id="sum"></span></h3>


// Define onchange event handler.
// Add <input> element values.
// Put the sum in the <span> element.
// If values cannot be added, put "Cannot add" in the <span> element
function onChange(){
    let n1 = document.getElementById('num1').value;
    let n2 = document.getElementById('num2').value;
    let n3;
    //n3 = n1 + n2;
    if(!isNaN(n1) && !isNaN(n2)){
        n3 = Number(n1) + Number(n2);
        document.getElementById('sum').innerText = n3;
    }else{
        document.getElementById('sum').innerText = "Cannot add";
    }
}
// 7. Skills Event
// NOTE: Write unobtrusive Javascript
// When user selects a skill, create an alert with a message similar to:
// 	"Are you sure CSS is one of your skills?"
// NOTE: no alert should appear when user deselects a skill.
function skillsEvent(){
    let select = document.getElementsByName('skills');
    let e = select[0];
    let value = e.options[e.selectedIndex].value;
    let t = e.options[e.selectedIndex].text;
    alert(`are you sure ${t} is one of your skills`);
    
}

// 8. Favorite Color Event
// NOTE: Write unobtrusive Javascript
// NOTE: This is regarding the favoriteColor radio buttons.
// When a user selects a color, create an alert with a message similar to:
// 	"So you like green more than blue now?"
// In this example, green is the new value and blue is the old value.
// Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
let prevColor = 0;
function favColor(){
    let colors = document.getElementsByName('favoriteColor');
    let faColor;
    if(prevColor === 0){
        for(let i = 0; i < colors.length; i++){
            if(colors[i].checked){
                faColor = colors[i].value;
                let c =document.getElementById('fav-color');//colors[i].style.backgroundColor = "blue";                            
                c.style.backgroundColor = faColor;
                prevColor = faColor;                
            }
        }    
    }else {
        for(let i = 0; i < colors.length; i++){
            if(colors[i].checked){
                faColor = colors[i].value;
                let c =document.getElementById('fav-color');//colors[i].style.backgroundColor = "blue";            
                c.style.backgroundColor = faColor;
                console.log(faColor);
                alert(`So you like ${faColor} more than ${prevColor} now?`);
                prevColor = faColor;          
            }
        }
    }
}
// 9. Show/Hide Event
// NOTE: Write unobtrusive Javascript
// When user hovers over an employees name:
// 	Hide the name if shown.
// 	Show the name if hidden.
function showHide(id){
   let name = document.getElementById(id); 
   if(name.style.visibility === "hidden"){
        name.style.visibility = "visible";
   }else{
        name.style.visibility = "hidden";
   }
   
}


// 10. Current Time
// Regarding this element:
// 	<h5 id="currentTime"></h5>
// Show the current time in this element in this format: 9:05:23 AM
// The time should be accurate to the second without having to reload the page.
function currentTime(){
    let dt = new Date();
    let h = document.getElementById('currentTime').
    innerText = dt.toLocaleTimeString();
}

// 11. Delay
// Regarding this element:
// 	<p id="helloWorld">Hello, World!</p>
// Three seconds after a user clicks on this element, change the text to a random color.
function changeRandomColor(){
    let hex = '#' + Math.floor(Math.random() * 16777215).toString(16);
    setTimeout(function(){
    document.getElementById('helloWorld').style.color = hex},3000) ;
}
// 12. Walk the DOM
// Define function walkTheDOM(node, func)
// This function should traverse every node in the DOM. Use recursion.
// On each node, call func(node)
function walkTheDOM(node, func){
    func(node);
    node = node.firstChild;
    while(node){
        walkTheDOM(node, func);
        node = node.nextSibling;
    }
};
