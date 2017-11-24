/************ 
Part II
************/
/*
1. USA
Define function getUSA()
Find the html element that contains "USA".
Print that element's contents.
*/
let getUSA = () => {
    let find = "USA";
    let anchTag = document.body.getElementsByTagName("*");
    console.log(anchTag);
     for (let i = 0; i < anchTag.length; i++) {
        let j = anchTag[i].textContent.search(find);
        //if no match is the search method returns -1
        if(j != -1){
           //prints the element's content 
           alert(anchTag[i].textContent);
           break;
        }
      
     }
}