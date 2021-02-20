# UserManagerAPI-WebApplication 
## (currently being updated....)
# UPDATE! 
                Persistence re-design
                - switch from file-based to relational database MySQL
                
                App re-model
                - 1. Improve Object model
                - 2. Update persistence layer to JPA and implement Hibernate provider, 
                - 3. Improve web-service and data layer structure,
                - 4. Improve Security
                - 5. add email based AUTH
                - 6. Improve front-end UI
                - 7. Improve logical structure design

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

