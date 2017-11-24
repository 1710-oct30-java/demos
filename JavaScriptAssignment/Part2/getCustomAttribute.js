/*
5. Custom Attribute
Define function getCustomAttribute()
Find all elements with "data-customAttr" attribute
Print the value of the attribute.
Print the element that has the attribute.
*/
let getCustomAttribute = () => {
    //use .querySelectorAll to return the first element that matches
    //the specified CSS selector in the document
    let elements = document.querySelectorAll('[data-customAttr]');
    //iterate through the elements and print them out
    for (let i = 0; i <elements.length;i++){
    alert(elements[i].dataset.customattr);
    }
}