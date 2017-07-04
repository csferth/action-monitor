This project is an experiment of using new technologies(at least for me) to create an action monitor application,
that monitors updates and inserts on a lightweight database and sends notifications tho all the clients connected.

Newly used technologies:
-SockJs
-STOMP
-Spring Boot
-WebService
-JMS
-ActiveMQ

To start the application download and extract ActiveMQ from:

cd into /bin in ActiveMQ folder and type activemq start in command line

ActiveMQ Tool is available at http://localhost:8161
Admin tool at http://localhost:8161
user: admin
passw: admin

To start the Spring Boot app navigate to target folder and start websocket-example-0.0.1-SNAPSHOT.jar

The application is available at http://localhost:8080


First i've created a webservice then i implemented the communication between the clients.
This worked out pretty good by using SockJS and STOMP.
Next i implemented the messaging.
I used Apache ActiveMQ to acomplish this goal.
Messages are passed to a queue and received from it by a receiver.
After it i've created a mysql database a wired it up with hibernate.
This time i was thinking about i should create stored procedures that calls a java method and fired by a trigger after
an insert or an update.
The java method the stored procedure calls should send a message to the message queue so it can be received by my receiver.
This wasn't implemented because i've decided to use a lightweight database for example sqlite because of triggers are not
a good choice for this.
In sqlite there were no triggers to solve this issue so i started figuring out how should i make my database events
provide messages to the messagequeue.

The application could not be finished, but at least it was a good experiment for me to learn something new.
Right now the app can read messages from the client and pass it through ActiveMQ and receive that message with a receiver.
The message is then sent to all the clients.


