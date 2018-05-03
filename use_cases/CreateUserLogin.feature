Feature: Create user login
	Description: Resource wants to create a user
	Actors: Resource

Scenario: Resource wants to create a user login
	Given that the resource selected to create a user
	And there is a resource "Rizwan Ali Ishaq", with id "RAI" and password "lyngby"
	When the user is created 
	Then the user for the resource "Rizwan Ali Ishaq", with id "RAI" and password "lyngby" is created

Scenario: Resource is already an existing user  
	Given that the resource selected to create a user
	And the resource "Rizwan Ali Ishaq", with id "RAI" and password "lyngby" is already a user
	When the user is created
	Then we get the error message "User already exists"
	