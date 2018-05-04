Feature: Add WorkPlanned
	Description: Should be able to add WorkPlanned to the list over Planned work
	
	In order to pair up a activity
	to a project
	With a set start
	and end time
	I want to be able to
	add id of project
	add id of activity
	and timeframe
	and it's added to a list over planned work
	
Scenario: PlannedWork object with legal input
	Given I have a plannedWork object
	And parameters are legal
	Then it should be added to plannedWork list

Scenario: plannedWork object with illegal input
	Given I have a plannedWork object
	and parameters are illegal
	then exception should be thrown