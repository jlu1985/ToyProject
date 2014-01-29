//Object Literals
var empty = {};                         // An object with no properties
var point = { x:0,y:0}                  // Two properties
var point2 = {x:point.x, y:point.y};    // More complex values
var book = {
    "main title": "JavaScript",         // Property names include spaces,
    "sub-title": "The Definitive Guide",// and hyphens, so use string literals
    "for": "All audiences",             // for is a reserved word, so quote
    author: {                           // The value of this property is
        firstname: "David",             // itself an object. Note that
        surname: "Flanagan"             // these property names are unquoted
    }
};

//Creating Objects with new
var o = new Object();       // Create an empty object: same as {}.
var a = new Array();        // Create an empty array: same as [].
var d = new Date();         // Create a Date object representing current time
var r = new RegExp("js");   // Create a RegExp object for pattern matching

//Prototypes
// Every object is associated with prototype, the first object inherits 
// properties from prototype
// e.g. Date.prototype inherits from Object.prototype

//Querying and Setting Properties
var author = book.author        // Get the "author" property of the book
var name = author.surname       // Get the "surname" property of the author
var title = book["main title"]  // Get the "main title" property of the book
book.edition = 6;               // Create an "edition" property of book
book["main title"]="ECMAScript" // Set the "main title" property

//Inheritance
var o = {}              // o inherits object method from Object.prototype
o.x = 1;                // and has an own property x.
var p = inherit(o)      // p inherits properties from o and Object.prototype
p.y = 2;                // and has an own property y.
var q = inherit(p);     // q inherits properties from p, o, and Object.prototype
q.z = 3;                // and has an own property z.
var s = q.toString();   // toString is inherited from Object.prototype
q.x + q.y               // 3: x and y are inherited from o and p

//Override inheritance
var unitcircle = { r:1 };       // An object to inherit from
var c = inherit(unitcircle);    // c inherits the property r
c.x = 1; c.y = 1;               // c defines two properties of its own
c.r = 2;                        // c overrides its inherited property
unitcircle.r;                   // => 1: the prototype object is not affected