# CN-assignment
UDP Server and Client (Computer Networking assignment)

Computer Networking assignment 2017 - Bickbeck University of London

Server:
The server creates an UDP socket, specifying a listening port. Then it creates some variables and arrays of bytes where to store the UDP packets received from the client.
From the received packets, the server obtains the data. In this program, it receives 2 packets, get the data from both, prints a message showing the content of packet1 and packet2.
Then it retrieves the sender’s IP address and port, included in the UDP packet(s) received. The two strings received are now merged and showed on the console.
The next step it does is to reverse the string merged, print the newly string on screen and make a new datagram packet to be sent to the client.
After sending the packet, the server will remain on “listening” because the socket is not closed and all the steps above are inside a while loop with a condition true (while (true) {sequence of steps} ). There are no statements inside this loop to change the given condition, therefore the server will listen forever.



Client:
The first step of the client is to prompt the user to input a string to be sent to the server. This string is split in two. If the length of the string is even, two strings of the same length will be sent, otherwise it will send the first string with length/2 + 1 and the second part of length/2 -1.
Then the client creates a socket using the IP address (localhost) hardcoded in the source file, creates two packets to be sent through the port 9876 specified in each datagram packet, sends them and await a reply from the server.
Only when a packet is received from the server, the client extracts from it the message contained and prints it on the screen. At this point it will close its socket, interrupting the connection with the server.
