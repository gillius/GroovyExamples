//Lists
def intList = [1, 2]
def emptyList = []
def emptyArrayList = [] as ArrayList

//modify in place
intList << 3
assert [1,2,3] == intList
assert 3 in intList //calls contains method
assert ( intList[0] == 1 ) && ( intList[-1] == 3 )

assert [1,2,3,4] == intList + 4       //add method
assert [1,2,3,4,5] == intList + [4,5] //addAll method
assert [1,3] == intList - 2           //remove method

//Maps, with 3 ways to access
def ages = [Alice: 20, Bob: 25, Sally: 12]
assert [ages.get("Alice"), ages["Alice"], ages.Alice].every { it == 20 }
ages.Alice += 2
assert ages["Alice"] == 22

ages += [John: 60]
assert ages.John

for ( a in ages ) {
	println a
}