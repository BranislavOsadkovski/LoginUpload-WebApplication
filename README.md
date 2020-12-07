# UserManagerAPI-WebApplication 



## **Description**

Java Web application-UserManagerAPI can be used to manage users and upload business files to the server, 
- AdminUserManager must login to go to the welcome page, 
- AdminUserManager can upload and business logs and files to the server,
- File is uploaded with a form, and user gets notified if the file is uploaded succesfully, or if the file with the same name already exists on the server.
- File upload is managed by the FileUploadServlet that also contains the configuration for performance and size of the files
- **AdminUserManager can use the UserService API to**
- Admin can READ all the users in the database
- Admin can CREATE User
- Admin can EDIT User
- Admin can DELETE User

## **Security** 

Application security is handled by the Filters, if the user is not logged in, or is not authorized to access the page user automaticaly gets redirected to the login.html page.
Any exceptions,errors or HTTP error codes are being handled by the AppExceptHandler class. ExceptionHandler works as a Filter catching all error and exception from interupting the
user experience on the website and showing a custom html message with a redirect link if any are thrown.

## **Logging**

Application startup,performance,activity is being logged through Web Filters and Listener and documented in ApacheTomcat log file using log4j logger. 
Log4j properties are defined in log4j.properties file.


## Next UPDATE ( 1. Update persistence layer to JPA and implement Hibernate, 2. improve web-service and data layer structure )



