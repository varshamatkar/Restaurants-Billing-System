import java.util.Scanner;

public class RestaurantBillingSystem {

	public static void main(String[] args) {
			
			Owner owner = new Owner();
			Customer customer = new Customer();
			Scanner scanner = new Scanner(System.in);
			boolean wantToContinue = true;
			
			while (wantToContinue) {
				System.out.println("\n------WELCOME TO RESTAURANT------\n");
				System.out.println("Login as,(Enter 1 for Owner and 2 for Customer ) ");
				System.out.println("1. Owner");
				System.out.println("2. Customer");
                 try {
				byte loginAs = scanner.nextByte();
				switch (loginAs) {
				case 1:
					System.out.println("------AUTHENTICATION-------");
					System.out.println("Enter username.");
					String userName = scanner.next();
					System.out.println("Enter password.");
					String password =scanner.next();
					if (owner.authorize( userName, password)) {
						Owner.ownerOperations(owner);
					} 
					else {
						System.out.println("Invalid credentials.");
					}
					break;
				case 2:
					Customer.customerOpeartions(customer);
					break;
				default:
					System.out.println("Invalid Choice!! " + "Terminating program.");
					wantToContinue = false;
					
				}
				

			}
       catch(Exception e) {
    	   System.out.println("Enter valid input");
       }
	


			scanner.close();
		
			}
	}

}
