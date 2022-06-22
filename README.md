
# Demo Java Spring project to send messages asynchronously using Artemis

This is a demo project I wrote to send and consume messages asynchronously using Artemis (ActiveMQ). This project contains a POST Rest endpoint to send JSON data for an Order, which will be converted and sent to an Artemis message queue. An active JMSListener will consume messages from this message queue and will output the consumed message content in the console.

Here are the steps required to get this project running.

---

## 1. Download and Install ActiveMQ Artemis

For the project to work, you need to have a running instance of an ActiveMQ Artemis broker.

ActiveMQ Artemis can be downloaded at the following URL: https://activemq.apache.org/components/artemis/download/

Then, follow the Installation procedure in the "Using the Server" section of the documentation's page: https://activemq.apache.org/components/artemis/documentation/

---

## 2. Configure the application

To configure the application, open the application.properties file under the src/main/java/resources/ folder.

Here are the important keys to configure:

**Port on which the application will run**

`server.port=8080`

**Address of the Artemis broker** (port 61616 is default)

`spring.artemis.broker-url=tcp://localhost:61616`

**Username to access the broker** (specified during Artemis installation)

`spring.artemis.user=admin`

**Password to access the broker** (specified during Artemis installation)

`spring.artemis.password=admin`

**Artemis Queue name** (This can be left as is, or renamed if needed)

`demo.queue.name=demo.order.queue`

---

## 3. Run the application

To run the application, open a command prompt, navigate to the root directory of the project and run the following command to start it using the Maven wrapper.

`mvnw spring-boot:run`

---

## 4. Sending a message to the broker

The application exposes a REST endpoint to post JSON data representing an Order. You can use Postman or CURL to send the JSON as a POST body to the following URL.

The 8080 port can be overridden by modifying the `server.port=8080` key in application.properties.

http://localhost:8080/api/orders

>{ "orderDate": "1655908367000", "invoiceNumber" : "A32zX44", "total": 31.80  }

Upon posting the JSON body to the exposed endpoint, a message will be sent to the Artemis message broker. 
You should then see the message body being output in the terminal window after the message is consumed from the queue.
