import java.util.Scanner;

/* 
Author:		green-vibes-coding
URL:		-
Version:	1.0
*/

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
		
		menu_bienvenida();
		
		int escoger = 0;
		
		System.out.print("\n\n");
		System.out.println("1. Realizar simulación con los coches predeterminados");
		System.out.println("2. Introducir todo manualmente");
		
		System.out.println("\n¿Qué quieres hacer?");
		System.out.print(">> ");
		escoger = scan.next().charAt(0);
		
		switch (escoger) {
			
			case '1':
						
				new principal().menu_predeterminado();
				break;
						
			case '2':
						
				new principal().menu_manual();
				break;
				
		}
		
	}
	
	public static void menu_bienvenida() {
		
		System.out.println(""
				+ "	        _________\r\n"
				+ "	       |         |\r\n"
				+ "	 _o_  _| ___=___ |_  _o_\r\n"
				+ "	/`-'( )         ( ) /`-'\\\r\n"
				+ "	|   |-|  ___*___  |-|   |\r\n"
				+ "	|   | | (-+-+-+-) | |   |\r\n"
				+ "	|   |--\\__COCHE__/--|   |\r\n"
				+ "	 ---                 ---\r\n"
				+ "");
		
	}
	
	
	// --------------------------  M A N U A L M E N T E  --------------------------- \\
	
	
	public coche[] crear_coche(coche[] coches, int posicion) {
		
		System.out.println("\n[Marca] ¿Cuál es la marca del coche que quieres crear?");
		System.out.print(">> ");
		String nuevo_marca = scan.next();
		
		System.out.println("\n[Modelo] ¿Cuál es el modelo del coche que quieres crear?");
		System.out.print(">> ");
		String nuevo_modelo = scan.next();
		
		System.out.println("\n[Carroceria] ¿Qué carrocería tiene el coche que quieres crear?");
		System.out.print(">> ");
		String nuevo_carroceria = scan.next();
		
		System.out.println("\n[Color] ¿De que color es el coche que quieres crear?");
		System.out.print(">> ");
		String nuevo_color = scan.next();
		
		System.out.println("\n[Precio] ¿Qué precio tiene el coche que quieres crear?");
		System.out.print(">> ");
		double nuevo_precio = scan.nextDouble();
		
		System.out.println("\n[Número de puertas] ¿Cuántas puertas tiene el coche que quieres crear?");
		System.out.print(">> ");
		int nuevo_numero_puertas = scan.nextInt();
		
		System.out.println("\n                                  Coche creado\n" + 
				"\n Marca del coche ............... 	" + nuevo_marca + 
				"\n Modelo del coche .............. 	" + nuevo_modelo +
				"\n Carrocería .................... 	" + nuevo_carroceria + 
				"\n Color del coche ............... 	" + nuevo_color + 
				"\n Precio del coche .............. 	" + nuevo_precio + " €" + 
				"\n Numero de puertas del coche ... 	" + nuevo_numero_puertas + "\n");
		
		coche miCoche = new coche(nuevo_numero_puertas, nuevo_precio, nuevo_color, nuevo_modelo, nuevo_marca, nuevo_carroceria);
		
		coches[posicion] = miCoche;
					
		return coches;
	} 
		
	public coche[] modificar_coche (coche[] coches, int posicion) {
		
		System.out.println("\n\n[Marca] ¿Cuál es la nueva marca del coche?");
		System.out.print(">> ");
		String nuevo_marca = scan.next();
		
		System.out.println("\n[Modelo] ¿Cuál es el nuevo modelo del coche?");
		System.out.print(">> ");
		String nuevo_modelo = scan.next();
		
		System.out.println("\n[Carroceria] ¿Cuál es la nueva carrocería del coche?");
		System.out.print(">> ");
		String nuevo_carroceria = scan.next();
		
		System.out.println("\n[Color] ¿Cuál es el nuevo color del coche?");
		System.out.print(">> ");
		String nuevo_color = scan.next();
		
		System.out.println("\n[Precio] ¿Cuál es el nuevo precio del coche?");
		System.out.print(">> ");
		double nuevo_precio = scan.nextDouble();
		
		System.out.println("\n[Número de puertas] ¿Cuál es el número de puertas que tiene el coche que quieres modificar?");
		System.out.print(">> ");
		int nuevo_numero_puertas = scan.nextInt();
		
		coche miCoche = coches[posicion];
		
		miCoche.setMarca(nuevo_marca);
		miCoche.setColor(nuevo_color);
		miCoche.setModelo(nuevo_modelo);
		miCoche.setCarroceria(nuevo_carroceria);
		miCoche.setNumero_puertas(nuevo_numero_puertas);
		miCoche.setPrecio(nuevo_precio);
		
		coches[posicion] = miCoche;
		
		return coches;
	}
	
	public void mostrar_estadisticas(coche[] coches) {
		
		double suma = 0;
		double mediana = 0;	
		double precio_maximo = 0;
		double precio_minimo = 999999999;
		
		for (int i = 0; i < coches.length; i++) {
			
			if (coches[i] != null) {
				
				double precio = coches[i].getPrecio();
				
				suma = suma + precio;
			
				if (precio > precio_maximo) {
					
					precio_maximo = precio;
			    				
				}
			    		 
				if (precio < precio_minimo) {
			    	    
					precio_minimo = precio;
			    	    
				}
				
			} else {
				
				i = coches.length;
				
			}
				
					
		}
		
		mediana = suma / coches.length;		
		
		System.out.println("                                            Estadísticas\n");
		System.out.println(" La mediana de todos los precios es ....	" + Math.round(mediana) + " €");
		System.out.println(" El precio mas elevado es ..............	" + Math.round(precio_maximo) + " €");
		System.out.println(" El precio menos elevado es ............	" + Math.round(precio_minimo) + " €");
	
	}
	
	public void menu_manual() {
				
		int opcion = 0;
		
		coche[] parking = new coche[10];
		
		int contador = 0;
		int posicion = 0;
		boolean definido = false;
				
		do {			
			System.out.println("\n==================================\n");
			System.out.println("1. Definir un nuevo coche");
				
			if (definido == true) {
				
				System.out.println("2. Modificar los atributos");
				System.out.println("3. Mostrar información");
				System.out.println("4. Mostrar estadísticas");
				System.out.println("5. Salir");
			}	
						
			System.out.print(">> ");
			opcion = scan.next().charAt(0);
				
			System.out.println("\n==================================\n");
				
			switch (opcion) {
			
				case '1': // ================================  O P C I Ó N  1  ================================
									
					System.out.println("_____________________________________________________________\n");
			    		System.out.println("Has seleccionado la opción 1: \"Definir un nuevo coche\"\n");
			    		
			    		parking = crear_coche(parking, contador);
			    		
			    		if (contador < parking.length) {
			    			
			    			System.out.print("\nCoche aparcado en la plaza [");
			    			
			    			sleep(40);
			    			System.err.print(contador);
			    			sleep(40);
			    			
			    			System.out.print("] ");
			    			System.out.print("\n");
			    			
			    			contador++;
			    			
			    		} else {
			    			
			    			System.out.println("El parking ya está lleno");
			    			
			    		}
			    		
			    		definido = true;
			    							
					System.out.println("_____________________________________________________________\n");					
					break;
						
							
				case '2': // ================================  O P C I Ó N  2  ================================
										
					System.out.println("_____________________________________________________________\n");
			    		System.out.println("Has seleccionado la opción 2: \"Modificar los atributos\"\n");
			    		
			    		System.out.println("\nCatálogo de coches\n");
			    		
			    		for (int n = 0; n < parking.length; n++) {
			    			
			    			if (parking[n] != null) {
			    			
				    			if (parking.length == 0) {
				    				
				    				System.out.print(""); 
				    				
				    			} else {
				    				
				    				if (parking != null) {
				    					
				    					System.out.print(" [" + n + "] " + parking[n].getMarca() + " - ");
				    					sleep(40);
				    					System.err.print(parking[n].getModelo());
				    					sleep(40);
				    					System.out.println("");
				    					
				    				}
				    				
				    			}
				    			
			    			}
			    			
			    		}
			    		
			    		System.out.println("\n[Posicion] ¿Qué coche quieres modificar?");
			    		System.out.print(">> ");
			    		posicion = scan.nextInt();
			    		
			    		System.out.println(parking[posicion]);
			    		
			    		parking = modificar_coche(parking, posicion);
			    		
			    		System.out.println(parking[posicion]);
			    						
					System.out.println("_____________________________________________________________\n");
					break;
						
							
				case '3': // ================================  O P C I Ó N  3  ================================
									
					System.out.println("_____________________________________________________________\n");
					System.out.println("Has seleccionado la opción 3: \"Mostrar información\"\n");

					System.out.println("\nCatálogo de coches\n");

					for (int n = 0; n < parking.length; n++) {

						if (parking[n] != null) {

							if (parking.length == 0) {

								System.out.print(""); 

							} else {

								if (parking != null) {

									System.out.print(" [" + n + "] " + parking[n].getMarca() + " - ");
					
									sleep(40);
									System.err.print(parking[n].getModelo());
									sleep(40);
									
									System.out.println("");

								}

							}
							
						}

					}

					System.out.println("\n[Posicion] ¿Que coche quieres visualizar?");
					System.out.print(">> ");
					posicion = scan.nextInt();	

					System.out.println(parking[posicion]);

					System.out.println("_____________________________________________________________\n");
					break;

					
				case '4': // ================================  O P C I Ó N  4  ================================

					System.out.println("_____________________________________________________________\n");
					System.out.println("Has seleccionado la opción 4: \"Mostrar estadísticas\"\n");

					mostrar_estadisticas(parking);
			    							
					System.out.println("_____________________________________________________________\n");
					break;
				
					
				case '5': // ================================  O P C I Ó N  5  ================================
						
					System.out.println("_____________________________________________________________\n");
					System.out.println("Has seleccionado la opción 5: \"Salir\"\n");

					System.out.print(" Saliendo de la simulación");

					for (int i = 0; i < 3; i++) {

						sleep(1000);
						System.out.print(".");

					}

					System.out.println("");

					System.out.println("\n_____________________________________________________________\n");
					break;
						
								
				default:
					System.out.println("Introduce números entre el 1 y el 5");
				}
			
			
		} while (opcion != '5');
			
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
		System.out.println("=================== Simulación finalizada ===================");
			
		scan.close();
				
	}
	
	
	
	// -----------------------  P R E D E T E R M I N A D O  ------------------------- //
	
	public coche[] coches_predeterminados(coche[] coches_predeterminados) { 
		
		coches_predeterminados[0] = new coche(4, 52572.1, "Negro", "Mustang", "Ford", "Coupé");               //
		coches_predeterminados[1] = new coche(2, 179106, "Rojo", "R8", "Audi", "Coupé");                      //
		coches_predeterminados[2] = new coche(2, 172000, "Blanco", "Roadster", "Tesla", "-");                 //
		coches_predeterminados[3] = new coche(2, 300000, "Rojo", "296 GTB", "Ferrari", "Coupé");              //
		coches_predeterminados[4] = new coche(2, 3000000, "Azul", "Chiron Pur Sport", "Bugatti", "Coupé");    //
		coches_predeterminados[5] = new coche(2, 4300000, "Gris", "CCXR Trevita", "Koenigsegg", "Coupé");     //
		coches_predeterminados[6] = new coche(4, 13000000, "Negro Mate", "Sweptail", "Rolls-Royce", "Coupé"); //
		coches_predeterminados[7] = new coche(2, 102648, "Blanco", "GT-R NISMO", "Nissan", "Coupé");          //
		coches_predeterminados[8] = new coche(2, 214120, "Cian", "DB11", "Aston Martin", "Coupé");            //
		coches_predeterminados[9] = new coche(2, 260329, "Mate", "911 Turbo S", "Porsche", "Coupé");          //
		
		return coches_predeterminados;
	}
	
	public coche[] modificar_coche_predeterminado (coche[] coches_predeterminados, int posicion) {
		
		System.out.println("\n\n[Marca] ¿Cuál es la nueva marca del coche?");
		System.out.print(">> ");
		String nuevo_marca = scan.next();
		
		System.out.println("\n[Modelo] ¿Cuál es el nuevo modelo del coche?");
		System.out.print(">> ");
		String nuevo_modelo = scan.next();
		
		System.out.println("\n[Carroceria] ¿Cuál es la nueva carrocería del coche?");
		System.out.print(">> ");
		String nuevo_carroceria = scan.next();
		
		System.out.println("\n[Color] ¿Cuál es el nuevo color del coche?");
		System.out.print(">> ");
		String nuevo_color = scan.next();
		
		System.out.println("\n[Precio] ¿Cuál es el nuevo precio del coche?");
		System.out.print(">> ");
		double nuevo_precio = scan.nextDouble();
		
		System.out.println("\n[Número de puertas] ¿Cuántas puertas que tiene el nuevo coche?");
		System.out.print(">> ");
		int nuevo_numero_puertas = scan.nextInt();
		
		coche unCoche = coches_predeterminados[posicion];
		
		unCoche.setMarca(nuevo_marca);
		unCoche.setColor(nuevo_color);
		unCoche.setModelo(nuevo_modelo);
		unCoche.setCarroceria(nuevo_carroceria);
		unCoche.setNumero_puertas(nuevo_numero_puertas);
		unCoche.setPrecio(nuevo_precio);
		
		coches_predeterminados[posicion] = unCoche;
		
		return coches_predeterminados;
	}
	
	public void mostrar_estadisticas_predeterminadas(coche[] coches_predeterminados) {
		
		double suma = 0;
		double mediana = 0;	
		double precio_maximo = 0;
		double precio_minimo = 999999999;
		
		for (int i = 0; i < coches_predeterminados.length; i++) {
			
			if (coches_predeterminados[i] != null) {
				
				double precio = coches_predeterminados[i].getPrecio();
				
				suma = suma + precio;
			
				if (precio > precio_maximo) {
					
					precio_maximo = precio;
			    				
				}
			    		 
				if (precio < precio_minimo) {
			    	    
					precio_minimo = precio;
			    	    
				}
				
			} else {
				
				i = coches_predeterminados.length;
				
			}
				
					
		}
		
		mediana = suma / coches_predeterminados.length;		
		
		System.out.println("                                            Estadísticas\n");
		System.out.println(" La mediana de todos los precios es ....	" + Math.round(mediana) + " €");
		System.out.println(" El precio más elevado es ..............	" + Math.round(precio_maximo) + " €");
		System.out.println(" El precio menos elevado es ............	" + Math.round(precio_minimo) + " €");
	
	}
	
	public void menu_predeterminado() {
		
		int opcion = 0;
		
		coche[] parking = new coche[10];
		
		int posicion = 0;
		
		parking = coches_predeterminados(parking);
				
		do {
			System.out.println("\n==================================\n");
			System.out.println("1. Modificar los atributos");
			System.out.println("2. Mostrar información");
			System.out.println("3. Mostrar estadísticas");
			System.out.println("4. Salir");
				
			System.out.print(">> ");
			opcion = scan.next().charAt(0);
				
			System.out.println("\n==================================\n");
				
			switch (opcion) {
			
				case '1': // ================================  O P C I Ó N  1  ================================
					
					System.out.println("_____________________________________________________________\n");
					System.out.println("Has seleccionado la opción 1: \"Modificar los atributos\"\n");

					System.out.println("\nCatálogo de coches\n");

					for (int n = 0; n < parking.length; n++) {

						if (parking[n] != null) {

							if (parking.length == 0) {

								System.out.print(""); 

							} else {

								if (parking != null) {

									System.out.print(" [" + n + "] " + parking[n].getMarca() + " - ");
									
									sleep(40);
									System.err.print(parking[n].getModelo());
									sleep(40);
					
									System.out.println("");

								}

							}

						}

					}

					System.out.println("\n[Posicion] ¿Que coche quieres modificar?");
					System.out.print(">> ");
					posicion = scan.nextInt();

					System.out.println(parking[posicion]);

					parking = modificar_coche_predeterminado(parking, posicion);

					System.out.println(parking[posicion]);
			    				    		
					System.out.println("_____________________________________________________________\n");
					break;
						
									
				case '2': // ================================  O P C I Ó N  2  ================================
									
					System.out.println("_____________________________________________________________\n");
					System.out.println("Has seleccionado la opción 2: \"Mostrar información\"\n");

					System.out.println("\nCatálogo de coches\n");

					for (int n = 0; n < parking.length; n++) {

						if (parking[n] != null) {

							if (parking.length == 0) {

								System.out.print(""); 

							} else {

								if (parking != null) {

									System.out.print(" [" + n + "] " + parking[n].getMarca() + " - ");
					
									sleep(40);
									System.err.print(parking[n].getModelo());
									sleep(40);
									
									System.out.println("");

								}

							}

						}

					}			    		

					System.out.println("\n[Posicion] ¿Que coche quieres visualizar?");
					System.out.print(">> ");
					posicion = scan.nextInt();	

					System.out.println(parking[posicion]);
			    		
					System.out.println("_____________________________________________________________\n");
					break;
						
									
				case '3': // ================================  O P C I Ó N  3  ================================
						
					System.out.println("_____________________________________________________________\n");
					System.out.println("Has seleccionado la opción 3: \"Mostrar estadísticas\"\n");

					mostrar_estadisticas_predeterminadas(parking);
			    					    		
					System.out.println("_____________________________________________________________\n");
					break;
				
								
				case '4': // ================================  O P C I Ó N  4  ================================
						
					System.out.println("_____________________________________________________________\n");
					System.out.println("Has seleccionado la opción 4: \"Salir\"\n");

					System.out.print(" Saliendo de la simulación");
						
					for (int i = 0; i < 3; i++) {

						sleep(1000);
						System.out.print(".");
					}
			    		
					System.out.println("");
			    		
		    			System.out.println("\n_____________________________________________________________\n");
					break;
				
					
				default:
				
					System.out.println("Introduce números entre el 1 y el 4");
			}
			
		} while (opcion != '4');
			
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
		System.out.println("=================== Simulacion finalizada ===================");
			
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
