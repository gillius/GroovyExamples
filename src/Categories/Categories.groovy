package Categories

class Athlete {
	def name
	def jump() { "Jump!" }
}

class AthleteCategory {
	//Adds method to type of first parameter; traditionally named self
	static def debug( Object self ) {
		def normalProps = new HashMap( self.properties )
		normalProps.remove( "class" ); normalProps.remove( "metaClass" )
		return "<${self.class.simpleName}: $normalProps>"
	}

	static def leap( Athlete self ) { self.jump() }

	static Athlete plus( Athlete self, String name ) {
		self.name += name
		return self
	}
}

def athlete = new Athlete( name: "Bob" )

//use affects only the code in its scope
use ( AthleteCategory ) {
	assert "<Athlete: [name:Bob]>" == athlete.debug()
	athlete += "by"; //use our new plus operator
	assert "<Athlete: [name:Bobby]>" == athlete.debug()
	athlete.leap()
}
