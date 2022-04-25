package plantillaemplados;
import java.util.Scanner;
import java.util.ArrayList;

public class Principal {

	public static Scanner scString=new Scanner(System.in);
	public static int dia=0;
	public static ArrayList <Empleado> empleados=new ArrayList();

	public static MozoAlmacen mozoalmacen0=new MozoAlmacen("Pepe","Phone","House","5124535a",1,1,120);
	public static MozoAlmacen mozoalmacen1=new MozoAlmacen("Aurelio","Martinez","Sancho","5445535c",1,1,60);
	public static JefeSeccion jefeseccion0=new JefeSeccion("Paquito","El","Chocolatero","99994535a",2,2,4,250);
	public static JefeSeccion jefeseccion1=new JefeSeccion("Ramonchu","Cadiz","Sevilla","34545434z",2,1,3,160);
	public static JefePlanta jefeplanta0=new JefePlanta("Alejandra","Mira","Cuenca","123456790c",3,1,5,230);
	public static Administracion administracion0=new Administracion("Luisito","Comunica","Mucho","5445535c",4,8,1);
	public static Directivo directivo0=new Directivo("Lola","Mentos","Perez","905535f",5,12,360);
	
	
	public static void main(String[] args) {
		empleados.add(mozoalmacen0);
		empleados.add(mozoalmacen1);
		empleados.add(jefeseccion0);
		empleados.add(jefeseccion1);
		empleados.add(jefeplanta0);
		empleados.add(administracion0);
		empleados.add(directivo0);
		
		int opcion=0;
		while (true) {
		do {
			System.out.println("\t\t     Dia "+dia);
			System.out.println("\t|&| --- Menu Empleados --- |&|");
			System.out.println("\t   1.-Introducir trabajador");
			System.out.println("\t   2.-Eliminar trabajador");
			System.out.println("\t   3.-Listado trabajadores");
			System.out.println("\t   4.-Listado trabajadores por puesto");
			System.out.println("\t   5.-Avance temporal");
			System.out.println("\t   6.-Mostrar matriz dias trabajados");
			System.out.println("\t   7.-Terminar programa");
			
			System.out.println("\n[>>] Introduce un numero 1-7 para elegir una opcion del Menu");
			opcion = introducirNumeroEntero(opcion);
	
			
			switch (opcion-1) {
			case 0:
				introducirEmpleado(opcion);
			break;
			
			case 1:
				eliminarEmpleado();
			break;
			
			case 2:
				System.out.println("[3] - Listrado trabajadores");
				if (empleados.size()>0) {
					for (int i=0; i<empleados.size(); i++) {
						System.out.println("ID: "+(i+1)+", "+empleados.get(i));
					}
				}
				
				else System.err.println("ERROR: No hay empleados para poder mostrar");
				mozoalmacen0.sueldoNeto();
				//Modulo no terminado falta hacer que eliga un empleado y calcule el sueldo y la indemnizacion
				//SI EL EMPLEADO NO TRABAJA 1 AÑO EXACTO NO COBRA POR PRINGADO

			break;
			
			case 3:
				verListadoPorPuesto(opcion);	
			break;
			
			case 4:
				avanceTemporal(opcion);
			break;
			case 5:
				System.out.println("[6] - Mostrar matriz dias trabajados");
			break;
			}
		
		} while (opcion < 0 || opcion > 7);
		
		// Opcion extra  para terminar el programa
		if (opcion == 7) {
			System.out.println("\n[7] - Terminar el Programa tras "+dia+" dias en activo.");
			System.exit(0);
			}
		
		}
	}

	private static void avanceTemporal(int opcion) {
		System.out.println("[5] - Avance temporal");
		int numdias = 0;
		do {
			System.out.println("Cuantos dias quieres que avance?");
			numdias = introducirNumeroEntero(opcion);
		} while (numdias < 0);
		dia += numdias;

		for (int i = 0; i < empleados.size(); i++) {

			empleados.get(i).tiempoTotal(numdias);

		}
	}

	private static void verListadoPorPuesto(int opcion) {
		int opcionsubmenu=0;
		System.out.println("[4] - Listado trabajadores por puesto");
		if (empleados.size()>0) {
		
			System.out.println("\t(1) Mozos de Almacen");
			System.out.println("\t(2) Jefes de Seccion");
			System.out.println("\t(3) Jefes de Planta");
			System.out.println("\t(4) Personal de Administracion");
			System.out.println("\t(5) Directivos");
			System.out.println(">> Introduce un numero (1-5) para elegir un tipo de empleado para poder observar el listado");
			do {
				opcionsubmenu=introducirNumeroEntero(opcion);
			}while (opcionsubmenu<0 || opcionsubmenu>5);
			
				switch (opcionsubmenu) {
				case 1:
					for (int i=0;i<empleados.size(); i++) {
						if (empleados.get(i) instanceof MozoAlmacen) {
							System.out.println(empleados.get(i));
						}
					}
					break;
				case 2:
					for (int i=0;i<empleados.size(); i++) {
						if (empleados.get(i) instanceof JefeSeccion) {
							System.out.println(empleados.get(i));
						}
					}
					break;
				case 3:
					for (int i=0;i<empleados.size(); i++) {
						if (empleados.get(i) instanceof JefePlanta) {
							System.out.println(empleados.get(i));
						}
					}
					break;
				case 4:
					for (int i=0;i<empleados.size(); i++) {
						if (empleados.get(i) instanceof Administracion) {
							System.out.println(empleados.get(i));
						}
					}
					break;
				case 5:
					for (int i=0;i<empleados.size(); i++) {
						if (empleados.get(i) instanceof Directivo) {
							System.out.println(empleados.get(i));
						}
					}
					break;						
					
				}
			}

		else System.err.println("ERROR: No hay empleados para poder mostrar");
	}

	private static void eliminarEmpleado() {
		int opcionempleado=0;
		System.out.println("[2] - Eliminar trabajador");
		if (empleados.size()>0) {
			
			for (int i=0; i<empleados.size(); i++) {
				System.out.println("ID: "+(i+1)+", "+empleados.get(i));
			}
			
			do {				
			System.out.println("Introduce la ID del Empleado que quieras eliminar");
			opcionempleado=introducirNumeroEntero(opcionempleado);
			}while (opcionempleado<0 || opcionempleado>empleados.size());
			
			System.out.println("El empleado " + empleados.get(opcionempleado).getNombre() +" ha sido eliminado.");
			empleados.remove(opcionempleado);
		}
			
		else System.err.println("ERROR: No hay trabajadores para poder eliminar");
	}

	private static void introducirEmpleado(int opcion) {
		String nombre="";
		String apellido1="";
		String apellido2="";
		String dni="";
		int puesto=0;
		int categoria=0;
		int diasantiguedad=0;
		int aniosantiguedad=0;
		boolean verificacionCategoria=false;
		
		System.out.println("[1] - Introducir trabajador");
		
		do {
		System.out.println("Introduce el nombre");
		nombre=scString.nextLine();
		}while (nombre=="");
		
		do{
		System.out.println("Introduce el apellido 1");
		apellido1=scString.nextLine();
		}while (apellido1=="");
		
		do {
		System.out.println("Introduce el apellido 2");
		apellido2=scString.nextLine();
		}while (apellido2=="");
		
		do {
		System.out.println("Introduce el dni");
		dni=scString.nextLine();
		}while (dni=="");
		
		do {
		System.out.println("Introduce el puesto");
		puesto=introducirNumeroEntero(opcion);
		}while (puesto<1 || puesto>5);
		if (puesto==2 || puesto==3) {
			do {
				System.out.println("Introduce la categoria");
				categoria=introducirNumeroEntero(opcion);
		
				if (puesto==2 && (categoria>0  && categoria <4)) {
					verificacionCategoria=true;
				
				}
			
				if (puesto==3 && (categoria>0  && categoria <5)) {
					verificacionCategoria=true;
				}
			}while (!verificacionCategoria);
		}
		
		do{			
		System.out.println("Introduce la antiguedad en anios");
		aniosantiguedad=introducirNumeroEntero(opcion);
		}while (aniosantiguedad<1);
		
		do{			
		System.out.println("Introduce la antiguedad en dias");
		diasantiguedad=introducirNumeroEntero(opcion);
		}while (diasantiguedad<1 || diasantiguedad>364);

		switch (puesto) {
		case 1:
			MozoAlmacen mozoAlmacen =new MozoAlmacen(nombre, apellido1, apellido2, dni, puesto, aniosantiguedad, diasantiguedad);
			empleados.add(mozoAlmacen);
			break;

		case 2:
			JefeSeccion jefeSeccion =new JefeSeccion(nombre, apellido1, apellido2, dni, puesto, aniosantiguedad, diasantiguedad,categoria);
			empleados.add(jefeSeccion);
			break;
		case 3:
			JefePlanta jefePlanta =new JefePlanta(nombre, apellido1, apellido2, dni, puesto, aniosantiguedad, diasantiguedad,categoria);
			empleados.add(jefePlanta);
			break;
		case 4:
			Administracion administracion =new Administracion(nombre, apellido1, apellido2, dni, puesto, aniosantiguedad,  diasantiguedad);
			empleados.add(administracion);
			break;
		case 5:
			Directivo directivo =new Directivo(nombre, apellido1, apellido2, dni, puesto, aniosantiguedad,  diasantiguedad);
			empleados.add(directivo);
			break;	
			
		}
	}
	
	//Try-Catch para Double y para Int
	private static int introducirNumeroEntero(int opcion) {
		String texto;
		boolean correcto=false;
		
		do {
		try {
			texto = scString.nextLine();
			opcion = Integer.valueOf(texto);
			correcto=true;
		} catch (NumberFormatException e) {
			System.err.println("ERROR: No has introducido un numero");
		}
		}
		while (!correcto);
		return opcion;
	}
	
	private static double introducirNumeroDecimal(double decimal) {
		String texto;
		boolean correcto=false;
		do {
		try {
			texto = scString.nextLine();
			decimal = Double.valueOf(texto);
			correcto=true;
		} catch (NumberFormatException e) {
			System.err.println("ERROR: No has introducido un numero");
		}
		}
		while (!correcto);
		return decimal;
	}

}
