#StefanAndersen
Feature: Create WorkPlanned

  Scenario: WorkPlanned is Created
    Given a project with name "a"
    And an activity with projectId "18001" and actId "a" and budgethours "10" and startWeek "2" and endWeek "4"
    And a resource with fullName "Stefan" and initials "SSA" and password "cocacola"
    When I create newWorkPlanned with projectId "18001" and actId "a" and resource initials "SSA" and startWeek "1" and endWeek "2"
    Then workPlanned is created



#    Given a project with name "a"
 # And an activity with projectId "19001" and actId "b" and budgethours "10" and startWeek "2" and endWeek "4"
  #  And a resource with fullName "Stefan Siggaard Andersen" and initials "SSA" and password "cocacola"
   # And a resource with fullName "Stefan Siggaard Andersen" and initials "ASS" and password "cocacola"
    #Then I validate the outcomes
    #And check more outcomes