const LinkedList = require("./LinkedList.js");
const Node = require("./Node.js");

LinkedList.prototype.isEmpty = function() {
    return (this.head === null);
}

let list = new LinkedList();
console.log(list.isEmpty());