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


###Versioning
 - Media type versioning (a.k.a \u201Ccontent negotiation\u201D or \u201Caccept header\u201D)
 	- GitHub
 - (Custom) headers versioning
 	- Microsoft
 - URI Versioning
	- Twitter
 - Request Parameter versioning
	- Amazon
 - Factors
	- URI Pollution
	- Misuse of HTTP Headers
	- Caching
	- Can we execute the request on the browser?
	- API Documentation
- No Perfect Solution


####Table Structure
#http://localhost:8080/h2-console

create table user (
	id integer not null, 
	birth_date timestamp, 
	name varchar(255), 
	primary key (id)
);

create table post (
	id integer not null, 
	description varchar(255), 
	user_id integer, 
	primary key (id)
);

alter table post 
add constraint post_to_user_foreign_key
foreign key (user_id) references user;