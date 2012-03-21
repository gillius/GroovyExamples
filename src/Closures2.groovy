//Memoization: remember results of prior calls
def download = { String url ->
  println "Downloading $url"
	new URL( url ).text }.memoizeAtMost( 5 ) //LRU cache of 5 pages

download "http://gillius.org/" //actually does it
download "http://gillius.org/" //uses cached version

//Curry, remove some closure parameters
class MailSender {
	void sendMail( String from, String to, String subject, String body ) {
		println "From $from, Subject $subject: Dear $to, $body"
	}
}

def sender = new MailSender()
sender.sendMail( "machine", "admin", "Error", "Oh No!" )

//If we call sendMail a lot with the same parameters, make a short version
def sendErrorReport = sender.&sendMail.curry("machine", "admin", "Error" )
//From machine, Subject Error: Dear admin, The web server is on fire!
sendErrorReport( "The web server is on fire!" )