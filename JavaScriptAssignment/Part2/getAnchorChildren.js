/*
3. Click Here
Define function getAnchorChildren()
Find all anchor elements with a <span> child.
Print the contents of <span>
*/
let getAnchorChildren = () => {
    let anchor = document.getElementsByTagName("a");
    for (let j = 0; j<anchor.length; j++)
    {
      if (anchor[j].hasChildNodes)
      {
        //let numChildren = anchor[j].children.length;
        console.log(anchor[j].children);
      }
    }
  }