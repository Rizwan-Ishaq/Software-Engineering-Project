Feature: Resource login
	Description: Resource wants to login
	Actors: Resource

Scenario: Resource can login
	Given that the resource is not logged in
	And the resources initials are "RAI" and the password is "lyngby123"
	Then the resource login succeeds
	And the resource is logged in

Scenario: Resource has the wrong password
	Given that the resource is not logged in
	And the resources initials are "RAI" and the password is "lyngby321"
	Then the resource login fails
	And the resource is not logged in