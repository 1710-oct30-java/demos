/*
12. Walk the DOM
Define function walkTheDOM(node, func)
This function should traverse every node in the DOM. Use recursion.
On each node, call func(node).
*/
let walkTheDOM = (node, func) => {
    func(node);
    node = node.firstChild;
    while (node) { 
        walkTheDOM(node, func);
        node = node.nextSibling;
    }
}
  walkTheDOM(document, function (node) {
  console.log("type-", node.nodeType, "name-", node.nodeName);
});