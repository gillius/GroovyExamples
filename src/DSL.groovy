//Example from Groovy 1.8 Release Notes:
show = { println it }
square_root = { Math.sqrt(it) }

def please(action) {
	[the: { what ->
		[of: { n -> action(what(n)) }]
	}]
}

please show the square_root of 100
//a b c d maps to a(b).c(d):
please(show).the(square_root).of(100)