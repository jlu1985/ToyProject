//Defining Functions
function printprop(o){
    ...
}

function distance(x1,y1,x2,y2){
    ...
}

//recursive function
function factorial(x){
    if (x<=1) return 1;
    return x * factorial(x-1);
}

//This function expression defines a function that squares its argument
//Note that we assign it to a varriable
var square = function(x) { return x*x };

//Function expressions can unclude names, which is useful for recursion.
var f = function fact(x) {if (x<=1) return 1; else return x*fact(x-1)};

//Function expressions can also be used as arguments to other functions:
data.sor(function(a,b) {return a-b;});

//Function expressions are sometimes defined and immediately invoked:
var tensquared = (function(x) {return x*x;}(10));

//Nested Functions
function hypotenuse(a,b) {
    function square(x) {return x*x}
    return Math.sqrt(square(a) + square(b));
}

//Invoking Functions
// as functions, as methods, as constructors and indirectly through their
// call() and apply() methods
printprops({x:1});
var total = distance(0,0,2,1);
var probability = factorial(5)/factorial(13);

//Method Invocation
//assign a function to method
o.m = printprops;
//invoking a method
o.m();

//Constructor Invocation
var o = new Object();

//Function Arguments and Paraments
//Optional argument
function a(b, /* Optional */ c) { ... }

//Variable length Argument
function max (/* ... */) { ... }
var largest = max (1,3,2,3,55,123);

//Functions as Values
function square(x) { return x*x; }
var s = square;         // Now s refers to the same function that square does
square(4);              // => 16
s(4);                   // => 16

//Functions can also be assigned to object properties rather than variables
var o = [function(x) {return x*x; },20];    // An array literal
var y = o.square(16)                        // => 400

//Functions don't even require names at all, as when they're assigned to array
// elements
var a = [function(x) {return x*x;},20];     // An array literal
a[0](a[1]);                                 // => 400