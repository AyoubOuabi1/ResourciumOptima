ResourciumOptima
Installation and Setup
Follow these steps to install and run the project on your local machine.

Prerequisites
Before you begin, make sure you have the following software installed on your system:

Java Development Kit (JDK) 11 or later
Apache Tomcat 10.1
MySQL
Apache Maven
Clone the Repository

`
git clone https://github.com/your-username/your-repo.git .
`

cd your-repo

` Database Configuration Create a new MySQL database for your project`.


Update the database connection configuration in src/main/resources/META-INF/persistence.xml with your database details. For example: `

Build and Deploy Build the project using Maven.

`mvn clean install`

Deploy the generated WAR file to your Tomcat server. You can do this by copying the WAR file (usually located in the target directory) to Tomcat's webapps directory.

`cp target/your-project.war /path/to/tomcat/webapps/`

Run the Application Start your Tomcat server.

`/path/to/tomcat/bin/startup.sh`
