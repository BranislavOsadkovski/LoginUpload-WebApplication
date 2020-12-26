# UserManagerAPI-WebApplication 
## (currently being updated...under construction)
# UPDATE 
                Persistence re-design
                - switch from File-based to relational database MySQL
                
                App re-model
                - 1. Improve Object model
                - 2. Update persistence layer to JPA and implement Hibernate, 
                - 3. Improve web-service and data layer structure,
                - 4. Improve Security
                - 5. add email based AUTH
                - 6. Improve front-end UI

## **Description**
Java EE web application - providing Jersey (JAX-RS) RESTful API implementation for managing users data and upload of business files to the server, using .jsp pages as front-end

 **API**
- AdminUser must login to go to the welcome page, 
- AdminUser can upload files and business logs to the server,
- File is uploaded with a form, and user gets notified if the file is uploaded succesfully, or if the file with the same name already exists on the server.
- File upload is managed by the FileUploadServlet that also contains the configuration for performance and size of the files

**AdminUser can use the UserService API to :**
- READ all the users in the database
- CREATE User
- EDIT User
- DELETE User

## **Security** 

Application security is handled by the Filters, if the user is not logged in, or is not authorized to access the page user automaticaly gets redirected to the login.html page.
Any exceptions,errors or HTTP error codes are being handled by the AppExceptHandler class. ExceptionHandler works as a Filter catching all error and exception from interupting the
user experience on the website and showing a custom html message with a redirect link if any are thrown.

## **Logging**

Application startup,performance,activity is being logged through Web Filters and Listener and documented in ApacheTomcat log file using log4j logger. 
Log4j properties are defined in log4j.properties file
