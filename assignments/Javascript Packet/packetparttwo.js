

// 1. USA
// Define function getUSA()
// Find the html element that contains "USA".
// Print that element's contents.

function getUSA() {
    let usa = $("span:contains('USA')");

    return usa.text();
}

// 2. Sales
// Define function getPeopleInSales()
// Print the names of all the people in the sales department.
function getPeopleInSales() {
    // return $('tr:has(td:contains("Sales"))');
    let employees = $('td:contains("Sales")').prev($('td'))

    return employees.text();

}

// 3. Click Here
// Define function getAnchorChildren()
// Find all anchor elements with a <span> child.
// Print the contents of <span>

function getAnchorChildren() {
    return $('a').children('span').text();
}

// 4. Hobbies
// Define function getHobbies()
// Find all checked options in the 'skills' select element.
// Print the value and the contents.
function getHobbies() {
    return $('select[name|="skills"]').find(':selected').text();
}

// 5. Custom Attribute
// Define function getCustomAttribute()
// Find all elements with "data-customAttr" attribute
// Print the value of the attribute.
// Print the element that has the attribute.
function getCustomAttribute() {
    return $('*[data-customAttr]').text();
}

// 6. Sum Event
// NOTE: Write unobtrusive Javascript
// Regarding these elements:
//     <input id="num1" class="nums" type="text"/>
//     <input id="num2" class="nums" type="text"/>
//     <h3>Sum: <span id="sum"></span></h3>
// Define onchange event handler.
// Add <input> element values.
// Put the sum in the <span> element.
// If values cannot be added, put "Cannot add" in the <span> element
function sumEvent() {
    let sum = parseInt($('#num1').val()) + parseInt($('#num2').val());
    if (isNaN(sum)) {
        changeSum('Cannot add');
    }
    else {
        changeSum(sum);
    }
}

function changeSum(textval) {
    $('#sum').text(textval);
}

// 7. Skills Event
// NOTE: Write unobtrusive Javascript
// When user selects a skill, create an alert with a message similar to:
//     "Are you sure CSS is one of your skills?"
// NOTE: no alert should appear when user deselects a skill.    

function skillsEvent() {
    let skills = $('select')
    $('select[name|="skills"]').bind('change', function () {
        let skill = $('select[name|="skills"]').find(':selected').text();
        skillsAlert(skill);
    })
}

function skillsAlert(skill) {
    alert('Are you sure ' + skill + ' is one of your skills?');
}

// 8. Favorite Color Event
// NOTE: Write unobtrusive Javascript
// NOTE: This is regarding the favoriteColor radio buttons.
// When a user selects a color, create an alert with a message similar to:
// 	"So you like green more than blue now?"
// In this example, green is the new value and blue is the old value.
// Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor

function favColor() {
    let oldColor = $('input[name|="favoriteColor"]:checked').val();
    $('input[name|="favoriteColor"]').bind('change', function () {
        let newColor = $('input[name|="favoriteColor"]:checked').val();
        alert('So you like ' + newColor + ' more than ' + oldColor + ' now?');
        oldColor = newColor;
        changeBackground(newColor);
    })
}

function changeBackground(color) {
    $('input[name|="favoriteColor"]').css("background-color", color);
}

// 9. Show/Hide Event
// NOTE: Write unobtrusive Javascript
// When user hovers over an employees name:
// 	Hide the name if shown.
// 	Show the name if hidden.
function showHide() {
    $('.empName').mouseenter(function () {
        if ($(this).css('opacity') == 1) {
            $(this).css('opacity', 0);
        }
        else {
            $(this).css('opacity', 1);
        }
    })
};

// 10. Current Time
// Regarding this element:
// 	<h5 id="currentTime"></h5>
// Show the current time in this element in this format: 9:05:23 AM
// The time should be accurate to the second without having to reload the page.
function curTime() {
    let newDate = new Date();
    let time = newDate.getHours() + ":" + newDate.getMinutes() + ":" + newDate.getSeconds();
    $('#currentTime').text(time);
    setTimeout(curTime, 500);
}

// 11. Delay
// Regarding this element:
// 	<p id="helloWorld">Hello, World!</p>
// Three seconds after a user clicks on this element, change the text to a random color.

function delay() {
    $('#helloWorld').click(() => {
        setTimeout(
            () => {
                $('#helloWorld').css('color', getRandomColor());
            },
            3000)
    })
}

function getRandomColor() {
    let hexOptions = '0123456789ABCDEF';
    let color = '#';
    for (let i = 0; i < 6; i++) {
        color += hexOptions[Math.floor(Math.random() * 16)];
    }
    return color;
}

//   12. Walk the DOM
//   Define function walkTheDOM(node, func)
//   This function should traverse every node in the DOM. Use recursion.
//   On each node, call func(node).

function walkTheDOM(node, func){
    func(node);
    node = node.firstChild;
    while (node) {
        walkTheDOM(node, func);
        node = node.nextSibling;
    }
}



