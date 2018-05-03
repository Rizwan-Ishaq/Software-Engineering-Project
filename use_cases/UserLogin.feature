Feature: User login 
	Description: Resource wants to login
	Actors: Resource

Scenario: Resource can login
	Given that the resource selected to login
	And that the resource "RAI" is not logged in
	And the password is "lyngby"
	Then the "RAI" login succeeds
	And the user is logged in

Scenario: Resource has the wrong password
	Given that the resource selected to login
	And that the resource "RAI" is not logged in
	And the password is "wrong password"
	Then the resource login fails
	And the resource is not logged in
	And we get the error message "Wrong Password"