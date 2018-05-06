Feature: Create project
	Description: A resource wants to create a project
	Actor: Resource
# Main scenario
Scenario: Create project
	Given that the resource is logged in
	And wants to create the project "Project DTU"
	When the project is created
	Then the project "Project DTU" is created
#And we get the message "Succesfully created new project, with id" and the id number of the project "Project DTU"
# Alternative scenarios
Scenario: Missing name for project
	Given that the resource is logged in
	And wants to create the project ""
	When the project is created
	Then we get the error message "Cannot create a project with an empty name, please try again"
#Scenario: Forkert information
#	Given medarbejderen indtaster informationer om projektet
#	When medarbejderen opretter projektet
#	Then systemet gør medarbejderen opmærksom på fejlen
#	And beder om rettelse af den forkerte information
#Scenario: Ulovligt input
#	Given medarbejderen indtaster informationer om projektet
#	When medarbejderen opretter projektet
#	Then systemet gør medarbejderen opmærksom på fejlen
#	And beder om korrekt input
