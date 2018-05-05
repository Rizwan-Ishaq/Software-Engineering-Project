Feature: User login
	Description: Resource wants to login
	Actors: Resource

Scenario: Resource can login
	And that the resource "RAI" is not logged in
	And the password is "lyngby"
	Then the "RAI" login succeeds
	And the user is logged in

Scenario: Resource has the wrong password
	And that the resource "RAI" is not logged in
	And the password is "wrong password"
	And the resource is not logged in
	And we get the error message "Wrong Password"