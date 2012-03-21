//Download xmlrpc library and dependencies from Maven Central
@Grab("org.codehaus.groovy:groovy-xmlrpc:0.8")
import groovy.net.xmlrpc.*

//Create Server
def server = new XMLRPCServer()
server.add = {a,b -> a+b} //define functionality

def serverSocket = new ServerSocket(0) //pick any port
server.startServer(serverSocket)

//CLIENT
def serverProxy = new XMLRPCServerProxy(
		"http://localhost:${serverSocket.localPort}" )
assert 11 == serverProxy.add( 5, 6 )

server.stopServer()