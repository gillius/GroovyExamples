package Operators

class Person {
	Person parent
	int age
}

class Database {
	Person getPerson( String name ) {
		return new Person( parent: null, age: 0 )
	}

	Person getAt( String name ) {
		return getPerson( name )
	}
}

def database = new Database()

//"Java" method: Get the age of Bob's parent
int age = -1;
if ( database != null ) {
	Person bob = database.getPerson( "Bob" );
	if ( bob != null ) {
		Person parent = bob.getParent();
		if ( parent != null ) {
			age = parent.getAge();
		}
	}
}

//Groovy method using Safe Navigation and Elvis
age = database.getPerson( "Bob" )?.parent?.age ?: -1;
//If database had a getAt method:
age = database["Bob"]?.parent?.age ?: -1;

println age