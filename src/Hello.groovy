def name = "Groovy"                 //semicolon optional
def greeting = "Hello, $name!"      //String interpolation
assert "Hello, Groovy!" == greeting //== does .equals, handling null
assert !("Hello, Groovy!".is(greeting)) //identity check

//optional typing, def is like Object
String typed = "Hello"
def untyped = typed
assert untyped instanceof String

//defining methods is same as Java; def maps to "Object"
void sayHello( def greeting ) {
  //dynamic call checked at runtime
  greeting = greeting.replace( "Hello", "Bonjour" )
  //methods added to Object, include println
  this.println( greeting )
  println greeting //"this" optional as in Java, also () optional
}

sayHello(greeting)
