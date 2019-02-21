# RESTFul Web Services

## Social Media Application

### User -> Posts

- Retrieve all Users 			- GET  		/users
- Create a User					- POST 		/users
- Retrieve one User 			- GET  		/users/{id} -> /users/1
- Delete a User					- DELETE	/users/{id} -> /users/1

- Retrieve all posts for a User - GET  /users/{id}/posts
- Create a posts for a User 	- POST /users/{id}/posts
- Retrieve details of a post	- GET  /users/{id}/posts/{post_id}


#### Internationalization

##### Configuration
- LocaleResolver
	- Default Locale - Locale.US
- ResourceBundleMessageSource

##### Usage
- Autowire MessageSource
- @RequestHeader(value="Accept-Language", required=false) Locale locale
- messageSource.getMessage("helloWorld.message", null, Locale)


#Swagger
- http://localhost:8080/v2/api-docs
- http://localhost:8080/swagger-ui.html
#ha_browser
-http://stateless.co/hal_specification.html
