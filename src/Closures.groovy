int count = 0;

//Unlike Java, closures can access non-final variables and modify
def counter = { if (it > 10) ++count }

counter( 5 ); counter( 12 ); counter( 15 );
assert 2 == count

//default is single parameter "it", but you can define parameters
def flexCounter = { val, test -> if ( val > test ) ++count }
flexCounter( 10, 0 )
assert 3 == count

//Optionally, parameters can have types:
flexCounter = { int val, int test -> if ( val > test ) ++count }
flexCounter( 10, 0 )
assert 4 == count

//If closure is last parameter to a method, it can be outside the ()
[1,2,3].each { count += it }
assert 10 == count;

def tostr = count.&toString //acts like { count.toString() }
assert "10" == tostr()