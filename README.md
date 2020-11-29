# LoginUpload-WebApplication

* **Description**

Java Web application, user can login to see the welcome page, and move on to the page to upload a file. 
File is uploaded with a form, and user gets notified if the file is uploaded succesfully, or if the file with the same name already exists on the server

* **Security** 

Application security is handled by the Filters, if the user is not logged in, or is not authorized to access the page user automaticaly gets redirected to the login.html page.
Any exceptions,errors or HTTP error codes are being handled by the AppExceptHandler class. ExceptionHandler works as a Filter catching all error and exception from interupting the
user experience on the website and showing a custom html message with a redirect link if any are thrown.

* **Logging**

Application startup,performance,activity is being logged through Web Filters and Listener and documented in ApacheTomcat log file using log4j logger. 
Log4j properties are defined in log4j.properties file.




