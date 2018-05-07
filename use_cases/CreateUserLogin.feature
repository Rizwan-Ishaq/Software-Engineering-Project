#Author: Rizwan Ali Ishaq
Feature: Create user login 
	Description: Resource wants to create a user
	Actors: Resource
#Author: Rizwan Ali Ishaq
Scenario: Resource wants to create a user login
	Given that the resource is not logged in
	And there is a resource "Rizwan Ali Ishaq", with id "RAI" and password "lyngby"
	When the user is created
	Then the user for the resource "Rizwan Ali Ishaq", with id "RAI" and password "lyngby" is created

#Author: Rizwan Ali Ishaq
Scenario: Resource is already an existing user
	Given that the resource "Rizwan Ali Ishaq", with id "RAI" and password "lyngby" is already a user
	And that the resource is not logged in
	When the user is created again
	Then we get the error message "User is already registered"