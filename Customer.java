import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class Customer extends Owner {
		
		
		HashMap<String, Integer> order;
		

		Customer() {
			order = new HashMap<String, Integer>();
			
		}

	public void displayMenu() {
			super.displayMenu();
		}

	public	void displayOrder() {
			

			if (order.isEmpty()) {
				System.out.println("No items in order.");
				return;
			}

			Set<String> foodNames = new HashSet<String>();
			foodNames = order.keySet();
			System.out.println("-------------------------------------");
			System.out.println("FOOD QUANTITY PRICE  TOTAL AMOUNT");
			System.out.println("-------------------------------------");
			for (String food : foodNames) {
				System.out.println(food + "\t" + order.get(food) + "\t" + menu.get(food) + "\t"
						+ menu.get(food) * order.get(food));
			}
			System.out.println("-------------------------------------\n");
		}

	public	boolean orderFood(String food, int quantity) {
			
			if (!super.menu.containsKey(food))
				return false;
			order.put(food, quantity);
			return true;

		}

	public	boolean removeFood(String food) {
			
			if (!order.containsKey(food))
				return false;
			else
				order.remove(food);
			return true;
		}

	public	boolean update(String food, int quantity) {
			
			try {
				removeFood(food);
				order.put(food, quantity);
			} catch (Exception e) {
				return false;
			}
			return true;
		}

	public	double totalBill() {
			
			double amount = 0;
			Set<String> foodNames = new HashSet<String>();
			foodNames = order.keySet();
			for (String food : foodNames) {
				amount += (super.menu.get(food) * order.get(food));
			}
			
			return amount ;
		}
	
	public static void customerOpeartions(Customer customer) {
		Scanner scanner = new Scanner(System.in);
		boolean customerLoggedIn = true;
		while (customerLoggedIn) {
			System.out.println("----Please select your choice----");
			System.out.println("1) Display Menu \n" + "2) Order Food Item \n" + "3) Cancel Food Item \n"
					+ "4) Update Food Item Quantity \n" + "5) Display Order\n" + "6) Pay Bill\n" + "7) Exit\n");
			String foodItem = "";
			int quantity = 0;
			byte choice = scanner.nextByte();
			switch (choice) {
			case 1:
				System.out.println("----MENU----");
				customer.displayMenu();
				break;
			case 2:
				System.out.println("Add food item name for order.");
				foodItem = scanner.next();
				System.out.println("Enter " + foodItem + "\'s quantity.");
				quantity = scanner.nextInt();
				if (customer.orderFood(foodItem, quantity))
					System.out.println(quantity + " " + foodItem + " added in order.");
				else
					System.out.println(foodItem + " does not exist in menu.");
				break;
			case 3:
				System.out.println("Enter food item to remove.");
				foodItem = scanner.next();
				if (customer.removeFood(foodItem))
					System.out.println(foodItem + " removed from order");
				else
					System.out.println("Failed to remove " + foodItem);
				break;
			case 4:
				System.out.println("Enter food to update quantity.");
				foodItem = scanner.next();
				if (customer.update(foodItem, quantity))
					System.out.println(quantity + " " + foodItem + " added in order.");
				else
					System.out.println("Failed to update quantity for " + foodItem);
				break;
			case 5:
				System.out.println("Your order is ");
				customer.displayOrder();
				break;
			case 6:
				System.out.println("Your total amount for following order ");
				customer.displayOrder();
				System.out.println("Total Amount = " + customer.totalBill());
				System.out.println("-------------------------------------\n");
				break;
			case 7:
				return;
			default:
				System.out.println("Exiting from Customer Module.");
				System.out.println("-------------------------------------");
				customerLoggedIn = false;
			}
		}
		scanner.close();
	}
	}

	



