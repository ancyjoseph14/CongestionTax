******CongestionTaxCalculatorGothenburg******

CongestionTaxCalculatorGothenburg is a Springboot REST Api application to calculate the congestion tax  in Gothenburg  City.

* This application's calculation implemented with different date inputs over HTTP. 
* In this application,the tax is not charged for vehicles on weekends, public holidays, days before a public holiday and during the month of July.
* The hourly rate for tax congestion is also considered here.
* A single charge rule also applies here.That is, a vehicle that passes several tolling stations within 60 minutes is only taxed once. The amount that must be paid is the highest one.

**Technologies Stack used**

  >Java 18
  >Maven
  >REST APIs
  >Spring Boot
  >Intellij
  >Postman

  **Build and Run**

* The project requires a Maven installation and a JDK 8+ (I have used jdk 18).
* It can be built running the following command in the root folder of the project:
  mvn clean install
* Run the application
* java -jar target/CongestionTaxCalculatorGothenburg-1.0-SNAPSHOT.jar 
* Run application with external application.yml "location=src/main/resources/application.yml"

  **Test cases**

REST Endpoint:

API URL: http://localhost:8080/congestionTax/calculatedTax

API method: POST

API Content Type: application/json

Input Json:

{
    "vehicle_type": "Car",
    "dates": [
    
        "2013-01-14 21:00:00","2013-01-15 21:00:00",
        "2013-02-07 06:23:27","2013-02-07 15:27:00",
        "2013-02-08 06:27:00","2013-02-08 06:20:27",
        "2013-02-08 14:35:00","2013-02-08 15:29:00",
        "2013-02-08 15:47:00","2013-02-08 16:01:00",
        "2013-02-08 16:48:00","2013-02-08 17:49:00",
        "2013-02-08 18:29:00","2013-02-08 18:35:00",
        "2013-03-26 14:25:00","2013-03-28 14:07:27"
	
    ]
}

Output:

{
"error": null,
"tax": 50,
"message": "Tax calculated successfully, Vehicle :Car Amount : 50",
"timestamp": 1700398625139
}

  **Output**
The screenshot postman page which shows the output is added to below location.

Location=src/main/resources/Output1.png

 **Unit testing is pending**
