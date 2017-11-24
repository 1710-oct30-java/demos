/*
2. Sales
Define function getPeopleInSales()
Print the names of all the people in the sales department.
*/
let getPeopleInSales = () => { 
   let table = document.getElementsByTagName("table")[0];
   //iterate through the rows of the table
   for (let i = 0; i <table.rows.length;i++){
    //get cells of each row 
    let cells = table.rows[i].cells;
        //2nd element of cells will be department
        //check if department equals Sales
        //if so print name of sales employee
        if(cells[1].textContent === "Sales"){
          alert(cells[0].textContent);
       }
   }
  
}