#Author: Rizwan Ali Ishaq
Feature: Resource login
	Description: Resource wants to login
	Actors: Resource
#Author: Rizwan Ali Ishaq
Scenario: Resource can login
	Given the resource "Rizwan Ali Ishaq", with id "RAI" and password "lyngby123" wants to login
	And that the resource is not logged in
	And the resources initials are "RAI" and the password is "lyngby123"
	Then the resource login succeeds
	And the resource is logged in

#Author: Rizwan Ali Ishaq
Scenario: Resource has the wrong password
	Given the resource "Rizwan Ali Ishaq", with id "RAI" and password "lyngby123" wants to login
	And that the resource is not logged in
	And the resources initials are "RAI" and the password is "lyngby321"
	Then the resource login fails
	And the resource is not logged in