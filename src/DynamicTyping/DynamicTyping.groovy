package DynamicTyping

class File implements Closeable {
	void open() { println "File open" }
	void close() { println "File close" }
	void setText( String text ) { println "File $text" }
}

class DialogBox {
	void open() { println "DialogBox open" }
	void close() { println "DialogBox close" }
	void setText( String text ) { println "DialogBox $text" }
}

//showText works with File or DialogBox, even though they don't
//share an interface or base class
void showText( def destination, String text ) {
	destination.open()
	destination.text = text
	destination.close()
}

showText( new File(), "Text" )
showText( new DialogBox(), "Text" )