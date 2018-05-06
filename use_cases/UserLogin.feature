Feature: Resource login
	Description: Resource wants to login
	Actors: Resource

Scenario: Resource can login
	Given that the resource is not logged in
	And the resources initials are "RAI" and the password is "lyngby123"
	Then the resource login succeeds
	And the resource is logged in

Scenario: Resource has the wrong password
	Given that the resource selected to login
	And that the resource "RAI" is not logged in
	And the password is "wrong password"
	Then the resource login fails
	And the resource is not logged in
	And we get the error message "Wrong Password"