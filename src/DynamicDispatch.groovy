//remember: return keyword is optional
String foo(String arg) { 'String version called' }
String foo(Object o) { 'Object version called' }

Object o = 'a String'
assert 'String version called' == foo( o )