#StefanAndersen
Feature: Create WorkPlanned

  Scenario: WorkPlanned is Created
    Given a project with name "a"
    And an activity with projectId "18001" and actId "a" and budgethours "10" and startWeek "2" and endWeek "4"
    And a resource with fullName "Stefan" and initials "SSA" and password "cocacola"
    When I create newWorkPlanned with projectId "18001" and actId "a" and resource initials "SSA" and startWeek "1" and endWeek "2"
    Then workPlanned is created

	Scenario: Creating WorkPlanned with NonExisting Project
		Given a project with name "a"
		And an activity with projectId "18001" and actId "a" and budgethours "10" and startWeek "2" and endWeek "4"
    And a resource with fullName "Stefan" and initials "SSA" and password "cocacola"
    When I create newWorkPlanned with projectId "19001" and actId "a" and resource initials "SSA" and startWeek "1" and endWeek "2"
    Then we get project error "Error: Project does not exist"
    
   Scenario: Creating WorkPlanned with NonExisitng Activity
		Given a project with name "a"
		And an activity with projectId "18001" and actId "a" and budgethours "10" and startWeek "2" and endWeek "4"
    And a resource with fullName "Stefan" and initials "SSA" and password "cocacola"
    When I create newWorkPlanned with projectId "18001" and actId "b" and resource initials "SSA" and startWeek "1" and endWeek "2"
    Then we get activity error "Error: Activity does not exist or isn't assigned to project"
    
   Scenario: Creating WorkPlanned with NonExisitng Resource
		Given a project with name "a"
		And an activity with projectId "18001" and actId "a" and budgethours "10" and startWeek "2" and endWeek "4"
    And a resource with fullName "Stefan" and initials "SSA" and password "cocacola"
    When I create newWorkPlanned with projectId "18001" and actId "a" and resource initials "ASS" and startWeek "1" and endWeek "2"
    Then we get resource error "Error: Resource does not exist."
    
   Scenario: Creating WorkPlanned with StarWeek after EndWeek
		Given a project with name "a"
		And an activity with projectId "18001" and actId "a" and budgethours "10" and startWeek "2" and endWeek "4"
    And a resource with fullName "Stefan" and initials "SSA" and password "cocacola"
    When I create newWorkPlanned with projectId "18001" and actId "a" and resource initials "SSA" and startWeek "2" and endWeek "1"
    Then we get start end error "Error: Your project ends before it starts."
    
   Scenario: Creating WorkPlanned with existing Workplanned in list, but non matching initials
		Given a project with name "a" and a project with name "b" exists
		And an activity with projectId "18001" and actId "a" and budgethours "10" and startWeek "2" and endWeek "4"
		And an activity with projectId "18001" and actId "b" and budgethours "10" and startWeek "2" and endWeek "4"
    And a resource with fullName "Stefan" and initials "SSA" and password "cocacola"
    And a resource with fullName "Stefan" and initials "ASS" and password "cocacola"
    And I create newWorkPlanned with projectId "18001" and actId "a" and resource initials "SSA" and startWeek "1" and endWeek "2"
    And add newWorkPlanned to WorkPlannedList
    And I create newWorkPlannedtwo with projectId "18001" and actId "b" and resource initials "ASS" and startWeek "1" and endWeek "2"
    Then newworkPlannedtwo is created
    
   Scenario: Creating WorkPlanned with existing Workplanned in list, NonOverlapping times
		Given a project with name "a" and a project with name "b" exists
		And an activity with projectId "18001" and actId "a" and budgethours "10" and startWeek "2" and endWeek "4"
		And an activity with projectId "18001" and actId "b" and budgethours "10" and startWeek "2" and endWeek "4"
    And a resource with fullName "Stefan" and initials "SSA" and password "cocacola"
    And I create newWorkPlanned with projectId "18001" and actId "a" and resource initials "SSA" and startWeek "1" and endWeek "2"
    And add newWorkPlanned to WorkPlannedList
    And I create newWorkPlannedtwo with projectId "18001" and actId "b" and resource initials "SSA" and startWeek "3" and endWeek "4"
    Then newworkPlannedtwo is created
    
   Scenario: Creating WorkPlanned with existing Workplanned in list, Overlapping times
		Given a project with name "a" and a project with name "b" exists
		And an activity with projectId "18001" and actId "a" and budgethours "10" and startWeek "2" and endWeek "4"
		And an activity with projectId "18001" and actId "b" and budgethours "10" and startWeek "2" and endWeek "4"
    And a resource with fullName "Stefan" and initials "SSA" and password "cocacola"
    And I create newWorkPlanned with projectId "18001" and actId "a" and resource initials "SSA" and startWeek "1" and endWeek "2"
    And add newWorkPlanned to WorkPlannedList
    And I create newWorkPlannedtwo with projectId "18001" and actId "b" and resource initials "SSA" and startWeek "2" and endWeek "3"
    Then we get overlapping error "Error: Resource is not available in the given timeframe, end WorkPlanned will not be added"
    
   Scenario: Creating WorkPlanned with existing Workplanned in list, Overlapping times reverse
		Given a project with name "a" and a project with name "b" exists
		And an activity with projectId "18001" and actId "a" and budgethours "10" and startWeek "2" and endWeek "4"
		And an activity with projectId "18001" and actId "b" and budgethours "10" and startWeek "2" and endWeek "4"
    And a resource with fullName "Stefan" and initials "SSA" and password "cocacola"
    And I create newWorkPlanned with projectId "18001" and actId "a" and resource initials "SSA" and startWeek "2" and endWeek "3"
    And add newWorkPlanned to WorkPlannedList
    And I create newWorkPlannedtwo with projectId "18001" and actId "b" and resource initials "SSA" and startWeek "1" and endWeek "2"
    Then we get overlapping error "Error: Resource is not available in the given timeframe, end WorkPlanned will not be added"

#    Given a project with name "a"
 # And an activity with projectId "19001" and actId "b" and budgethours "10" and startWeek "2" and endWeek "4"
  #  And a resource with fullName "Stefan Siggaard Andersen" and initials "SSA" and password "cocacola"
   # And a resource with fullName "Stefan Siggaard Andersen" and initials "ASS" and password "cocacola"
    #Then I validate the outcomes
    #And check more outcomes