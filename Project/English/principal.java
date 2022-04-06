import java.util.Scanner;

public class principal {

	static Scanner scan = new Scanner(System.in);
	
	// ----------------------------------  M E N U  ---------------------------------- \\
	/////////////////////////////////////////////////////////////////////////////////////
	
	
	
	public static void main(String[] args) {

		
		menu();	
		
		
	}
	
		
	//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	// -------------------------------- / M E N U  ---------------------------------- //

	public static void menu() {
		
		menu_welcome();
		
		int choose = 0;
		
		System.out.print("\n\n");
		System.out.println("1. Perform simulation with default cars");
		System.out.println("2. Enter everything manually");
		
		System.out.println("\nWhat do you choose?");
		System.out.print(">> ");
		choose = scan.next().charAt(0);
		
		switch (choose) {
			
			case '1':
						
				new principal().menu_default();
				break;
						
			case '2':
						
				new principal().menu_manual();
				break;
				
		}
		
	}
	
	public static void menu_welcome() {
		
		System.out.println(""
				+ "	        _________\r\n"
				+ "	       |         |\r\n"
				+ "	 _o_  _| ___=___ |_  _o_\r\n"
				+ "	/`-'( )         ( ) /`-'\\\r\n"
				+ "	|   |-|  ___*___  |-|   |\r\n"
				+ "	|   | | (-+-+-+-) | |   |\r\n"
				+ "	|   |--\\__C A R__/--|   |\r\n"
				+ "	 ---                 ---\r\n"
				+ "");
		
	}
	
	
	// --------------------------  M A N U A L M E N T E  --------------------------- \\
	
	
	public car[] create_car(car[] cars, int position) {
		
		System.out.println("\n[Brand] What is the brand of car you want to create?");
		System.out.print(">> ");
		String new_brand = scan.next();
		
		System.out.println("\n[Model] What is the model of the car you want to create?");
		System.out.print(">> ");
		String new_model = scan.next();
		
		System.out.println("\n[Bodywork] What bodywork does the car you want to create have?");
		System.out.print(">> ");
		String new_bodywork = scan.next();
		
		System.out.println("\n[Color] What color is the car you want to create?");
		System.out.print(">> ");
		String new_color = scan.next();
		
		System.out.println("\n[Price] What is the price of the car you want to create?");
		System.out.print(">> ");
		double new_price = scan.nextDouble();
		
		System.out.println("\n[Number of doors] How many doors does the car you want to create have?");
		System.out.print(">> ");
		int new_number_doors = scan.nextInt();
		
		System.out.println("\n                                  Created car\n" + 
				"\n Brand of the car .............. 	" + new_brand + 
				"\n Model of the car .............. 	" + new_model +
				"\n Bodywork ...................... 	" + new_bodywork + 
				"\n Color of the car .............. 	" + new_color + 
				"\n Price of the car .............. 	" + new_price + " €" + 
				"\n Number of doors ............... 	" + new_number_doors + "\n");
		
		car myCar = new car(new_number_doors, new_price, new_color, new_model, new_brand, new_bodywork);
		
		cars[position] = myCar;
					
		return cars;
	} 
		
	public car[] modify_car (car[] cars, int position) {
		
		System.out.println("\n\n[Brand] What is the new brand of the car?");
		System.out.print(">> ");
		String new_brand = scan.next();
		
		System.out.println("\n[Model] What is the new model of the car?");
		System.out.print(">> ");
		String new_model = scan.next();
		
		System.out.println("\n[Bodywork] What is the new car bodywork?");
		System.out.print(">> ");
		String new_bodywork = scan.next();
		
		System.out.println("\n[Color] What is the new color of the car?");
		System.out.print(">> ");
		String new_color = scan.next();
		
		System.out.println("\n[Price] What is the new price of the car?");
		System.out.print(">> ");
		double new_price = scan.nextDouble();
		
		System.out.println("\n[Number of doors] What is the number of doors on the car you want to modify?");
		System.out.print(">> ");
		int new_number_doors = scan.nextInt();
		
		car myCar = cars[position];
		
		myCar.setBrand(new_brand);
		myCar.setColor(new_color);
		myCar.setModel(new_model);
		myCar.setBodywork(new_bodywork);
		myCar.setNumber_doors(new_number_doors);
		myCar.setPrice(new_price);
		
		cars[position] = myCar;
		
		return cars;
	}
	
	public void show_statistics(car[] cars) {
		
		double sum = 0;
		double average = 0;	
		double maximum_price = 0;
		double minimum_price = 999999999;
		
		for (int i = 0; i < cars.length; i++) {
			
			if (cars[i] != null) {
				
				double price = cars[i].getPrice();
				
				sum = sum + price;
			
				if (price > maximum_price) {
					
					maximum_price = price;
			    				
				}
			    		 
				if (price < minimum_price) {
			    	    
					minimum_price = price;
			    	    
				}
				
			} else {
				
				i = cars.length;
				
			}
				
					
		}
		
		average = sum / cars.length;		
		
		System.out.println("                                       Statistics\n");
		System.out.println(" The average of all prices is ....	" + Math.round(average) + " €");
		System.out.println(" The highest price is ............	" + Math.round(maximum_price) + " €");
		System.out.println(" The lowest price is .............	" + Math.round(minimum_price) + " €");
	
	}
	
	public void menu_manual() {
				
		int option = 0;
		
		car[] parking = new car[10];
		
		int counter = 0;
		int position = 0;
		boolean defined = false;
				
		do {
				System.out.println("\n==================================\n");
				System.out.println("1. Define a new car");
				
				if (defined == true) {
					
					System.out.println("2. Modify the attributes");
					System.out.println("3. Show information");
					System.out.println("4. Show Stats");
					System.out.println("5. Leave");
					
				}	
				
				System.out.print(">> ");
				option = scan.next().charAt(0);
				
				System.out.println("\n==================================\n");
				
				switch (option) {
			
					case '1': // ================================  O P T I O N  1  ================================
						
						System.out.println("_____________________________________________________________\n");
			    		System.out.println("You have selected the option 1: \"Define a new car\"\n");
			    		
			    		parking = create_car(parking, counter);
			    		
			    		if (counter < parking.length) {
			    			
			    			System.out.print("\nCar parked in the box [");
			    			
			    			sleep(40);
			    			System.err.print(counter);
			    			sleep(40);
			    			
			    			System.out.print("] ");
			    			System.out.print("\n");
			    			
			    			counter++;
			    			
			    		} else {
			    			
			    			System.out.println("The parking lot is already full");
			    			
			    		}
			    		
			    		defined = true;
			    		
						System.out.println("_____________________________________________________________\n");					
						
						break;
						
						
					case '2': // ================================  O P T I O N  2  ================================
					
						System.out.println("_____________________________________________________________\n");
			    		System.out.println("You have selected the option 2: \"Modify the attributes\"\n");
			    		
			    		System.out.println("\nCar catalog\n");
			    		
			    		for (int n = 0; n < parking.length; n++) {
			    			
			    			if (parking[n] != null) {
			    			
				    			if (parking.length == 0) {
				    				
				    				System.out.print(""); 
				    				
				    			} else {
				    				
				    				if (parking != null) {
				    					
				    					System.out.print(" [" + n + "] " + parking[n].getBrand() + " - ");
				    					sleep(40);
				    					System.err.print(parking[n].getModel());
				    					sleep(40);
				    					System.out.println("");
				    					
				    				}
				    				
				    			}
				    			
			    			}
			    			
			    		}
			    		
			    		System.out.println("\n[Position] What car do you want to modify?");
			    		System.out.print(">> ");
			    		position = scan.nextInt();
			    		
			    		System.out.println(parking[position]);
			    		
			    		parking = modify_car(parking, position);
			    		
			    		System.out.println(parking[position]);
			    				    		
						System.out.println("_____________________________________________________________\n");
						break;
						
					
					case '3': // ================================  O P T I O N  3  ================================
					
						System.out.println("_____________________________________________________________\n");
			    		System.out.println("You have selected the option 3: \"Show information\"\n");
			    				
			    		System.out.println("\nCar catalog\n");
			    		
			    		for (int n = 0; n < parking.length; n++) {
			    			
			    			if (parking[n] != null) {
			    			
				    			if (parking.length == 0) {
				    				
				    				System.out.print(""); 
				    				
				    			} else {
				    				
				    				if (parking != null) {
				    					
				    					System.out.print(" [" + n + "] " + parking[n].getBrand() + " - ");
				    					sleep(40);
				    					System.err.print(parking[n].getModel());
				    					sleep(40);
				    					System.out.println("");
				    					
				    				}
				    				
				    			}
				    			
			    			}
			    			
			    		}
			    		
			    		System.out.println("\n[Position] What car do you want to see?");
			    		System.out.print(">> ");
			    		position = scan.nextInt();	
			    		
			    		System.out.println(parking[position]);
			    		
						System.out.println("_____________________________________________________________\n");
						break;
						
						
					case '4': // ================================  O P T I O N  4  ================================
						
						System.out.println("_____________________________________________________________\n");
			    		System.out.println("You have selected the option 4: \"Show Stats\"\n");
			    					    		
			    		show_statistics(parking);
			    					    		
						System.out.println("_____________________________________________________________\n");
						break;
				
					
					case '5': // ================================  O P T I O N  5  ================================
						System.out.println("_____________________________________________________________\n");
			    		System.out.println("You have selected the option 5: \"Leave\"\n");
			    					    		
			    		System.out.print(" Leaving the simulation");
						
			    		for (int i = 0; i < 3; i++) {
							
			    			sleep(1000);
							System.out.print(".");
						
			    		}
			    		
						System.out.println("");
			    		
			    		System.out.println("\n_____________________________________________________________\n");
						break;
						
						
					default:
						System.out.println("Enter numbers between 1 and 5");
					}
			
			
		} while (option != '5');
			
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
		System.out.println("==================== Simulation finished ====================");
			
		scan.close();
				
	}
	
	
	
	// -----------------------  P R E D E T E R M I N A D O  ------------------------- //
	
	public car[] default_cars(car[] default_cars) { 
		
		default_cars[0] = new car(4, 52572.1, "Black", "Mustang", "Ford", "Coupe"); //
		default_cars[1] = new car(2, 179106, "Red", "R8", "Audi", "Coupe"); //
		default_cars[2] = new car(2, 172000, "White", "Roadster", "Tesla", "-"); //
		default_cars[3] = new car(2, 300000, "Red", "296 GTB", "Ferrari", "Coupe"); //
		default_cars[4] = new car(2, 3000000, "Blue", "Chiron Pur Sport", "Bugatti", "Coupe"); //
		default_cars[5] = new car(2, 4300000, "Grey", "CCXR Trevita", "Koenigsegg", "Coupe"); //
		default_cars[6] = new car(4, 13000000, "Black Mate", "Sweptail", "Rolls-Royce", "Coupe"); //
		default_cars[7] = new car(2, 102648, "White", "GT-R NISMO", "Nissan", "Coupe"); //
		default_cars[8] = new car(2, 214120, "Cian", "DB11", "Aston Martin", "Coupe");
		default_cars[9] = new car(2, 260329, "Mate", "911 Turbo S", "Porsche", "Coupe");
		
		return default_cars;
	}
	
	public car[] modify_default_car (car[] default_cars, int position) {
		
		System.out.println("\n[Brand] What is the brand of car you want to change?");
		System.out.print(">> ");
		String new_brand = scan.next();
		
		System.out.println("\n[Model] What is the model of the car you want to change?");
		System.out.print(">> ");
		String new_model = scan.next();
		
		System.out.println("\n[Bodywork] What bodywork does the car you want to change have?");
		System.out.print(">> ");
		String new_bodywork = scan.next();
		
		System.out.println("\n[Color] What color is the car you want to change?");
		System.out.print(">> ");
		String new_color = scan.next();
		
		System.out.println("\n[Price] What is the price of the car you want to change?");
		System.out.print(">> ");
		double new_price = scan.nextDouble();
		
		System.out.println("\n[Number of doors] How many doors does the car you want to change have?");
		System.out.print(">> ");
		int new_number_doors = scan.nextInt();
		
		car myCar = new car(new_number_doors, new_price, new_color, new_model, new_brand, new_bodywork);
		
		default_cars[position] = myCar;
		
		return default_cars;
	}
	
	public void show_default_stats(car[] default_cars) {
		
		double sum = 0;
		double average = 0;	
		double maximum_price = 0;
		double minimum_price = 999999999;
		
		for (int i = 0; i < default_cars.length; i++) {
			
			if (default_cars[i] != null) {
				
				double price = default_cars[i].getPrice();
				
				sum = sum + price;
			
				if (price > maximum_price) {
					
					maximum_price = price;
			    				
				}
			    		 
				if (price < minimum_price) {
			    	    
					minimum_price = price;
			    	    
				}
				
			} else {
				
				i = default_cars.length;
				
			}
				
					
		}
		
		average = sum / default_cars.length;		
		
		System.out.println("                                       Statistics\n");
		System.out.println(" The average of all prices is ....	" + Math.round(average) + " €");
		System.out.println(" The highest price is ............	" + Math.round(maximum_price) + " €");
		System.out.println(" The lowest price is .............	" + Math.round(minimum_price) + " €");
	
	}
	
	public void menu_default() {
		
		int option = 0;
		
		car[] parking = new car[10];
		
		int position = 0;
		
		parking = default_cars(parking);
				
		do {
				System.out.println("\n==================================\n");
				System.out.println("1. Modify the attributes");
				System.out.println("2. Show information");
				System.out.println("3. Show Stats");
				System.out.println("4. Leave");
				
				System.out.print(">> ");
				option = scan.next().charAt(0);
				
				System.out.println("\n==================================\n");
				
				switch (option) {
			
					case '1': // ================================  O P T I O N  1  ================================
					
						System.out.println("_____________________________________________________________\n");
			    		System.out.println("You have selected the option 1: \"Modify the attributes\"\n");
			    		
			    		
			    		System.out.println("\nCar catalog\n");
			    		
			    		for (int n = 0; n < parking.length; n++) {
			    			
			    			if (parking[n] != null) {
			    			
				    			if (parking.length == 0) {
				    				
				    				System.out.print(""); 
				    				
				    			} else {
				    				
				    				if (parking != null) {
				    					
				    					System.out.print(" [" + n + "] " + parking[n].getBrand() + " - ");
				    					sleep(40);
				    					System.err.print(parking[n].getModel());
				    					sleep(40);
				    					System.out.println("");
				    					
				    				}
				    				
				    			}
				    			
			    			}
			    			
			    		}
			    					    		
			    		System.out.println("\n[Position] What car do you want to modify?");
			    		System.out.print(">> ");
			    		position = scan.nextInt();
			    		
			    		System.out.println(parking[position]);
			    		
			    		parking = modify_default_car(parking, position);
			    		
			    		System.out.println(parking[position]);
			    				    		
						System.out.println("_____________________________________________________________\n");
					
						
						break;
						
					
					case '2': // ================================  O P T I O N  2  ================================
					
						System.out.println("_____________________________________________________________\n");
			    		System.out.println("You have selected the option 2: \"Show information\"\n");
			    		
			    		System.out.println("\nCar catalog\n");
			    		
			    		for (int n = 0; n < parking.length; n++) {
			    			
			    			if (parking[n] != null) {
			    			
				    			if (parking.length == 0) {
				    				
				    				System.out.print(""); 
				    				
				    			} else {
				    				
				    				if (parking != null) {
				    					
				    					System.out.print(" [" + n + "] " + parking[n].getBrand() + " - ");
				    					sleep(40);
				    					System.err.print(parking[n].getModel());
				    					sleep(40);
				    					System.out.println("");
				    					
				    				}
				    				
				    			}
				    			
			    			}
			    			
			    		}			    		
			    		
			    		System.out.println("\n[Position] What car do you want to see?");
			    		System.out.print(">> ");
			    		position = scan.nextInt();	
			    		
			    		System.out.println(parking[position]);
			    		
						System.out.println("_____________________________________________________________\n");
						break;
						
						
					case '3': // ================================  O P T I O N  3  ================================
						
						System.out.println("_____________________________________________________________\n");
			    		System.out.println("You have selected the option 3: \"Show Stats\"\n");
			    					    		
			    		show_default_stats(parking);
			    					    		
						System.out.println("_____________________________________________________________\n");
						break;
				
					
					case '4': // ================================  O P T I O N  4  ================================
						System.out.println("_____________________________________________________________\n");
			    		System.out.println("You have selected the option 4: \"Leave\"\n");
			    					    		
			    		System.out.print(" Leaving the simulation");
						
			    		for (int i = 0; i < 3; i++) {
							
			    			sleep(1000);
							System.out.print(".");
						
			    		}
			    		
						System.out.println("");
			    		
			    		System.out.println("\n_____________________________________________________________\n");
						break;
						
						
					default:
						System.out.println("Enter numbers between 1 and 4!");
					}
			
			
		} while (option != '4');
			
		System.out.println(""
				+ "	   ---------------------------.\r\n"
				+ "	 `/\"\"\"\"/\"\"\"\"/|\"\"|'|\"\"||\"\"|   ' \\.\r\n"
				+ "	 /    /    / |__| |__||__|      |\r\n"
				+ "	/----------=====================|\r\n"
				+ "	| \\  /V\\  /    _.               |\r\n"
				+ "	|()\\ \\W/ /()   _            _   |\r\n"
				+ "	|   \\   /     / \\          / \\  |-( )\r\n"
				+ "	=C========C==_| ) |--------| ) _/==] _-{_}_)\r\n"
				+ "	 \\_\\_/__..  \\_\\_/_ \\_\\_/ \\_\\_/__.__.\r\n");
		System.out.println("=================== Simulation finished ===================");
			
		scan.close();	
				
	}
	
	
	
	// ------------------------------ A E S T H E T I C ------------------------------ //
	

	public void sleep(int time) {
		
		try {
			
			Thread.sleep(time);
			
		} catch (InterruptedException e) {
				
		}
		
	}		
	
}
