package inversionofcontrol;

public class Program {

	public static void main(String[] args) {
		 // This int 1 creates a MySQLDAL
//		User user = new User(1);
		
		// Here now we can see that our DAL is inverted. Originally, we 
		// were creating in the user now, its been switched so that something else is 
		// going to tell the User what DAL its going to use, this is inversion of control.
		// The User class no longer creates the data access layer instead it relies on something
		// else to tell it what data access layer to use.
		User user = new User(new MySQLDAL());
		user.Add();
	}
}




