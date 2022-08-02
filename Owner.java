import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Owner {
	static HashMap<String, Float> menu = new HashMap<String, Float>();

	Owner() {
		menu = new HashMap<String, Float>();
	}

public boolean authorize(String username, String password) {
		return username.equals("Varsha") && password.equals("Varsha@123");
	}

public boolean addItem(String food, float price) {
		
		if (menu.containsKey(food))
			return false;
		menu.put(food, price);
		return true;
	}

public	boolean deleteItem(String food) {
		
		if (menu.containsKey(food)) {
			menu.remove(food);
			return true;
		} else
			return false;
	}

public boolean update(String food, float price) {
		
		try {
			deleteItem(food);
			addItem(food, price);
		} catch (Exception e) {
			return false;
		}
		return true;

	}

public void displayMenu() {
		if (menu.isEmpty()) {
			System.out.println("Menu empty.");
			return;
		}
		Set<String> foodNames = new HashSet<String>();
		foodNames = menu.keySet();
		System.out.println("-------------------------------------");
		System.out.println("FOOD \t PRICE");
		System.out.println("-------------------------------------");
		for (String food : foodNames) {
			System.out.println(food + "\t" + menu.get(food));
		}
		System.out.println("-------------------------------------");
	}
public static void ownerOperations(Owner owner) {
	Scanner sc = new Scanner(System.in);
	boolean ownerLoggedIn = true;
	while (ownerLoggedIn) {
		System.out.println("\n----OPERATIONS----");
		System.out.println("Enter choice");
		System.out.println("1. Add Food Item.\n" + "2. Remove Food Item \n" + "3. Update Food Item \n"
				+ "4. Display Menu\n" + "5. Exit");
		byte choice = sc.nextByte();
		String foodItem = "";
		float price = 0F;
		switch (choice) {
		case 1:
			System.out.println("Enter number of food items to add in menu.");
			int noOfItems = sc.nextInt();
			for (int i = 0; i < noOfItems; i++) {
				System.out.println("Enter food item " + (i + 1));
				foodItem = sc.next();
				System.out.println("Enter its price.");
				price = sc.nextFloat();
				if (owner.addItem(foodItem, price))
					System.out.println(foodItem + " added in menu.");
				else
					System.out.println(foodItem + " already in menu.");
				owner.addItem(foodItem, price);
			}

			break;
		case 2:
			System.out.println("Enter food item to remove.");
			foodItem = sc.next();
			if (owner.deleteItem(foodItem))
				System.out.println(foodItem + " removed from menu.");
			else
				System.out.println(foodItem + " does not exist in menu.");
			break;
		case 3:
			System.out.println("Enter food item to update its price.");
			foodItem = sc.next();
			System.out.println("Enter its price.");
			price = sc.nextFloat();
			if (owner.update(foodItem, price))
				System.out.println("Menu updated.");
			else
				System.out.println("Failed to update menu.");
			break;
		case 4:
			owner.displayMenu();
			break;
		case 5:
			return;
		default:
			System.out.println("Exiting from Owner Module.");
			System.out.println("-------------------------------------");
			ownerLoggedIn = false;
		}
	}
	sc.close();
}
}