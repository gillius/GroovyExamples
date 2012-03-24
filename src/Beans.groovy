import groovy.transform.Canonical

@Canonical //add equals, hashCode, and toString
class Person {
  String name
  int age
  def extraInfo //same as Object
}

def alice = new Person( name: "Alice", age: 25, extraInfo: "A girl" )

assert alice.name == "Alice"
assert "Person(Alice, 25, A girl)" == alice.toString() //uses Canonical

def bob = new Person( name: "Bob", age: 40, extraInfo: alice )

//Cast map to bean?!?!
def map = [name: "Jason", age: 30]
def jason = map as Person

//slicing a collection of beans into a collection of fields
alice.age -= 10 //now alice is 15
assert [15, 40, 30] == [alice, bob, jason].age