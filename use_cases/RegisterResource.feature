#StefanAndersen
Feature: Create WorkPlanned

  Scenario: Register a Resource
    Given a Resource with name "Stefan" initials "SSA" and password "cocacola"
    Then I register resource
    
  Scenario: Register a Resource already existing
  	Given a Resource with name "Stefan" initials "SSA" and password "cocacola"
  	And a Resourcetwo with name "Stefan" initials "SSA" and password "cocacola"
  	And Resource is registered
  	When I register Resourcetwo
  	Then we get Resource exists error "User is already registered"



#    Given a project with name "a"
 # And an activity with projectId "19001" and actId "b" and budgethours "10" and startWeek "2" and endWeek "4"
  #  And a resource with fullName "Stefan Siggaard Andersen" and initials "SSA" and password "cocacola"
   # And a resource with fullName "Stefan Siggaard Andersen" and initials "ASS" and password "cocacola"
    #Then I validate the outcomes
    #And check more outcomes