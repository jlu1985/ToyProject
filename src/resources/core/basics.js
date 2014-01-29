// Comment

// variable declaration
var x;

// values of a variable
x = 0;
x //A variable evaluates to its value

// Different types of values
x = 1;
x = 0.01;
x = "hello world";
x = 'JavaScript';
x = true;
x = false;
x = null;
x = undefined;

// Objects
var book = {                //Objects are enclosed in curly braces.
    topic: "JavaScript",    //The property "topic" has value "JavaScript"
    fat:true;               //The property "fat" has value true.
};                          //The curly brace marks the end of the object

//Access the properties of an object with . or[]:
book.topic                  // => "JavaScript"
book.["fat"]                // => true
book.author = "Flanagan"    // Create a new properties by assignment
book.contents = {};         // {} is an empty object with no properties.

//Arrays
var primes = [2,3,5,7];     //An array of four values
primes[0]                   // => 2: the first element (index 0) of the array
primes.length               // => 4: how many element in the array
primes.[primes.length-1]    // => 7: the last element of the array.
primes.[4] = 9;             //Add a new element by assignment
primes.[4] = 11;            //Or alter an existing element by assignment
var empty = [];             //[] is an empty array with no elements
empty.length                // => 0

//Array of objects
var points = [              //An array with 2 elements.
    {x:0, y:0},             //Each element is an object.
    {x:1, y:1}
];
var data = [                //An object with 2 proerties
    trail1: [[1,2],[3,4]],  //The value of each property is an array.
    trail2: [[2,3],[4,5]]   //The elements of the arrays are arrays
];

//Arithmatics
3 + 2                       // => 5: addition
3 - 2                       // => 1: subtraction
3 * 2                       // => 6: multiplication
3 / 2                       // => 1.5: division
points[1].x - points[0].x   // => 1: more complicated operands work, too
"3" + "2"                   // => "32": + adds numbers, concatenates strings

//Shorthand arithmetic operators
var count = 0               // Define a variable
count++;                    // Increment the variable
count--;                    // Decrement the variable
count += 2;                 // Add 2: same as count = count + 2;
count *= 3;                 // Multiply by 3: same as count = count * 3;
count                       // => 6: variable names are expressions, too

//Equality and relational operators
var x = 2, y = 3;           // These = signs are assignment, not equality tests
x == y                      // => false: equality
x != y                      // => true: inequality
x < y                       // => true: less-than
x <= y                      // => true: less-than or equal
x > y                       // => false: greater-than
x >= y                      // => false: greater-than or equal
"two" == "three"            // => false: the two strings are differnt
x === "2"                   // => false: exact match, type and value
"two" > "three"             // => true: "tw" is alphabetically greater than "th"
false == (x > y)            // => true: false is equal to false

//Logical operators
(x == 2) && (y == 3)        // => true: both comparisons are true. && is AND
(x > 3) || (y < 3)          // => false: neither comparison is true. || is OR
!(x == y)                   // => true: ! inverts a boolean value

//Functions
function plug1(x) {         //Define a function named "plus1" with parameter "x"
    return x+1;             //Return a value one larger than the value passed in
};                          //Functions are enclosed in curly braces
plus1(y)                    // => 4: y is 3, so this invocation returns 3+1
var square = function(x){   //Functions are values and can be assigned to vars
    return x*x;             //Compute the function's value
};                          //Semicolon marks the end of the assignment
square(plugs1(y))           // => 16: invoke two functions in one expression

//When we combine functions with objects we get methods;
var a = [];                 // Create an empty array
a.push(1,2,3);              // The push() method adds elements to an array
a.reverse();                // Another method: reverse the order of elements
//Define our own method. The "this" keyword refers to the this object
points.dist = function(){   // Define a method to compute distance between points
    var p1 = this[0];       // First element of array we're invoke on
    var p2 = this[1];       // Second element of the "this" object
    var a = p2.x-p1.x       // Difference in X coordinates
    var b = p2.y-p1.y       // Difference in Y coordinates
    return Math.sqrt(a*a +  // The Pythagorean theorem
                       b*b);// Math.sqrt() computes the square root
};
points.dist()               // => 1.414: distance between our 2 points

//Object Oriented
//Define a constructor function to initialize a new Point object
function Point(x,y) {       //By convention, constructors start with capitals
    this.x = x;             //this keyword is the new object
    this.y = y;             //Store function arguments as object properties
}                           //No return is necessary
var p = new Point(1,1);     //The geometric point (1,1)
//Define methods for Point objects by assigning them to the prototype
//object associated with the constructor function
Point.prototype.r = function(){
    return Math.sqrt(       //Return the square root of x^2 + y^2
        this.x * this.x +   //This is the Point object on which the method...
        this.y * this.y     //...is invoked.
    };
};
// Now the Point object p (and all future Point objects) inherits the method r()
p.r()                       // => 1.414...