interface IHandler {
	public void handle( String item )
}

class Tokenizer {
	public static tokenize( String str, IHandler handler ) {
		str.split(" ").each { handler.handle(it) }
	}
}

Tokenizer.tokenize( "Hello World", {
	println it
} as IHandler )