package plantillaemplados;
import java.util.Scanner;
import java.util.ArrayList;

public class Principal {

	public static Scanner scString=new Scanner(System.in);
	public static int dia=0;
	public static ArrayList <Empleado> empleado=new ArrayList();

	public static MozoAlmacen mozoalmacen0=new MozoAlmacen("Pepe","Phone","House","5124535a",1,1,120);
	public static MozoAlmacen mozoalmacen1=new MozoAlmacen("Aurelio","Martinez","Sancho","5445535c",1,1,60);
	public static JefeSeccion jefeseccion0=new JefeSeccion("Paquito","El","Chocolatero","99994535a",2,2,4,250);
	public static JefeSeccion jefeseccion1=new JefeSeccion("Ramonchu","Cadiz","Sevilla","34545434z",2,1,3,160);
	public static JefePlanta jefeplanta0=new JefePlanta("Alejandra","Mira","Cuenca","123456790c",3,1,5,230);
	public static Administracion administraccion0=new Administracion("Luisito","Comunica","Mucho","5445535c",4,8,1);
	public static Directivo directivo0=new Directivo("Lola","Mentos","Perez","905535f",5,12,360);
	

	
	public static void main(String[] args) {
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
				System.out.println("[1] - Introducir trabajador");
			break;
			
			case 1:
				System.out.println("[2] - Eliminar trabajador");
			break;
			
			case 2:
				System.out.println("[3] - Listrado trabajadores");
			break;
			
			case 3:
				System.out.println("[4] - Listado trabajadores por puesto");
			break;
			
			case 4:
				System.out.println("[5] - Avance temporal");
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
