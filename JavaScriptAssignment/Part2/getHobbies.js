/*
4. Hobbies
Define function getHobbies()
Find all checked options in the 'skills' select element.
Print the value and the contents.
*/
let getHobbies = () => {
    let hobbies = document.getElementsByName("hobbies")[0];
    //use .options to return a collection of all <option> elements
    //in a drop down list and use .selectedIndex to find the options
    //that are selected and finally use .value to return the value of
    //that option 
    let hobbiesSelected = hobbies.options[hobbies.selectedIndex].value;
    let hobbiesContent = hobbies.options[hobbies.selectedIndex].textContent;
    alert(hobbiesContent + ":" + hobbiesSelected);
    //repeat code above for skills
    let skills = document.getElementsByName("skills")[0];
    let skillsSelected = skills.options[skills.selectedIndex].value;
    let skillsContent = skills.options[skills.selectedIndex].textContent;
    alert(skillsContent + ":" + skillsSelected);
}