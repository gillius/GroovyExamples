package ClosuresInUse

class File implements Closeable {
	void open() { println "File open" }
	void close() { println "File close" }
	void setText( String text ) { println "File $text" }
}

void withResource( def closeable, Closure action ) {
	try {
		closeable.open()
		//Set delegate to place closeable's symbols in closure's scope
		action.setDelegate( closeable )
		action() //same as action.call()
	} finally {
		closeable.close()
	}
}

//Use our previous File class with open, close, and setText
withResource( new File() ) {
	//First try X (local variable), X (enclosing scope variable),
	//then this.X, then delegate.X, then owner.X; owner is enclosing class ref
	text = "Calls setText on the File"
	delegate.text = "Calls setText on the File" //equivalent
}