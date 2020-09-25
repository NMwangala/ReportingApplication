#Report Module Application

What does it do?
=================
1.The application launches a graphical user interface on a browser.
2.A can select a .csv file and upload.
3.The system reads the uploaded file and save it to a database.
4.The saved data is then displayed in a tabular dashboard.

Other functionalities include :-
1.User queries for the top 5 profitable item type and total profit for that date range.

Technologies Used
===================
1.Springboot
2.Spring data JPA
3.Thymeleaf
4.Maven
5.BootStrap
6.Mysql Database

How to launch it.
==================
1.Clone the project
 Source : https://github.com/NMwangala/ReportingApplication.git
2.Create a local MySQL database with the below credentials
  DB Name     : REPORTS
  DB Username : root
  DB Password : th3@0fw@r
3.Navigate into the downloaded clone and run the below command to build a runnable jar file of the project.
  mvn clean install
4.A jar file will be generated in the target directory.
5.Run the below command to start it.
  java -jar 'generated jar file name'&
  NB: Exclude the single quotes 
6.The application will launch on application port 4200.
7.From the browser, you can access the application from your localhost as below :-
   http://localhost:4200/
8.Once the application launches, you can the do all the activities listed under "What does it do?".
9.Attached are screens of how the system looks like when launched.
