import groovy.xml.MarkupBuilder

def grades = [ CS1: 'A', CS2: 'B', English: "C" ]

def builder = new MarkupBuilder()
builder.html {
	head {
		title "My First Website"
	}
	body {
		p style: "color:blue;", "Here are my grades:"
		ul {
			grades.each {k, v ->
				li "I got an $v in $k"
			}
		}
	}
}