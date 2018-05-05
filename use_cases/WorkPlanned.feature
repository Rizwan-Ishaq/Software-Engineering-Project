Feature: Prooving that my framework workds
	Description: A feature to test that I can create something
	
	I want to test that my framework works
	by creating a project and activity
	and creating a Workplanned with a start and end time
	
Scenario: Adding Planned work
	Given a resource with fullName Stefan
	and initials SSA
	and password hello exists
	
	public Resource(String fullName, String initials, String password) {
		this.id = initials;
		this.fullName = fullName;
		this.password = password;
		this.available = true; 
	}



Scenario: User borrows book
	Given a book with signature "Beck99" is in the library
	And a user is registered with the library
	When the user borrows the book
	Then the book is borrowed by the user