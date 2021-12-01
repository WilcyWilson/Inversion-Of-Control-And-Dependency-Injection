package inversionofcontrol;

public class User {
//	MySQLDAL dal = new MySQLDAL(); // Creates object of Type MySQLDAL
	Idal dal; 	// Using interface dal here
	
	// Here the dal object references to different implementations
		// according to the integer value received in main class.
	// Here even if we modify our User class like this we can see
	// we are still doing everything in our user class.
	// The decision of which data access layer Type to use is where we begin to look at 
	// inversion of control
	// Our User class is tightly coupled to our data access layer
	// The User class is defining for itself, what type of DAL to use
	// Most of the time programmers don't get to choose the DAL, they are handed one
	// We are going to modify the constructor to achieve IOC through Dependency Injection.
//	public User(int IdalType) { 
//		if(IdalType == 1)
//		{
//			dal = new MySQLDAL();
//		}
//		else {;
//			dal = new SqlServerDAL();
//		}
//	}
	
	// DAL coming in through the constructor
	// By doing this we have inverted the control, the User class is no longer
	// controlling where its DAL is coming from.
	// It knows that there is a DAL that it needs but where that comes from is entirely irrelevant.
	// We have narrowed the focus of our User class.
	public User(Idal dalType) {
		dal = dalType;
	}
	public Boolean IsValid;

	public Boolean getIsValid() {
		return IsValid;
	}

	public void Add() { // This add method validates that the user is correct and use DAL to add the user to database
		if (IsValid) {
			dal.Add(this);
		}
	}
}
