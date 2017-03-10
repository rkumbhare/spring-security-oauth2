# spring-security-oauth2
Spring Rest API with Spring Security and Oauth2 

Securing Restful Web Services with Spring Security and OAuth2 (Spring Security + OAuth2 + Spring Rest)
Rakesh kumbhare [OAUTH, SPRING-MVC, SPRING-SECURITY, WEB-SERVICES]

OAuth (Open Authentication) is an open standard or kind of protocol that lets one site to share its content with some other site without sharing credentials.

This Sample Application shows how to secure Restful Web Services using Spring security and OAuth2, we will use Spring Security to validate a user on server and OAuth to manage authentication tokens to be used in communication. After applying this implementation only authenticated users and applications will get a valid access token from OAuth and using that token the user can access authorized API’s on server.


# The flow of application will go something like this:

1) User sends a GET request to server with some parameters: grant_type, client_id, username, password 
something like this: 
http://localhost:8080/spring-security-oauth2/oauth/token?grant_type=password&client_id=client1&username=user&password=password

==> Server validates the user with help of spring security, and if the user is authenticated, OAuth generates a access token and send it back to user in following format.

{
	"access_token": "22cb0d50-5bb9-463d-8c4a-8ddd680f553f",
	"token_type": "bearer",
	"refresh_token": "7ac7940a-d29d-4a4c-9a47-25a2167c8c49",
	"expires_in": 119
}

Here we got access_token for further communication with server or to get some protected resourses(API’s), it mentioned a expires_in time that indicates the validation time of the access_token.
And once the access_token is expired, refresh_token that is being used to get a new access_token.


2) We access protected resources by passing this access token as a parameter, the request goes something like this:
http://localhost:8080/spring-security-oauth2/user/?access_token=8c191a0f-ebe8-42cb-bc18-8e80f2c4238e 

Here http://localhost:8080/spring-security-oauth2 is the server path, and /user/ Is an API URL that returns a list of users and is being protected to be accessed.
If the access_token is not expired and is a valid token, the requested resources will be returned.

3) In case the access_token is expired, user needs to get a new access_token using its refreshing token that was accepted in step(1). A new access token request after expiration looks something like this:
http://localhost:8080/spring-security-oauth2/oauth/token?grant_type=refresh_token&client_id=client&refresh_token=7ac7940a-d29d-4a4c-9a47-25a2167c8c49 
And you will get a new access_token. 
