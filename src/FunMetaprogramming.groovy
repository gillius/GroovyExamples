class Athlete { def name
	              def jump() { "Jump!" } }

//dynamically add methods to classes, all instances:
Object.metaClass.debug = {
	def normalProps = new HashMap( delegate.properties )
	normalProps.remove( "class" ); normalProps.remove( "metaClass" )
	"<${delegate.class.simpleName}: $normalProps>"
}

def athlete = new Athlete( name: "Bob" )
assert "<Athlete: [name:Bob]>" == athlete.debug()

//Call method by string
def methodName = "jump"
assert "Jump!" == athlete."$methodName"()

//What if you needed to call a method that wanted "leap"?
//Dynamically add method to INSTANCE:
athlete.metaClass.leap = { jump() }

assert "Jump!" == athlete.leap()
