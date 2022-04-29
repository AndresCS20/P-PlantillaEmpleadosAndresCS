package plantillaemplados;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Principal {

	public static Scanner scString=new Scanner(System.in);
	public static int dia=0;
	public static ArrayList <Empleado> empleados=new ArrayList();
	//Creacion de varios empleados de diferentes tipos
	public static MozoAlmacen mozoalmacen0=new MozoAlmacen("Pepe","Phone","House","5124535a",1,2,120);
	public static MozoAlmacen mozoalmacen1=new MozoAlmacen("Aurelio","Martinez","Sancho","5445535c",1,1,60);
	public static JefeSeccion jefeseccion0=new JefeSeccion("Paquito","El","Chocolatero","99994535a",2,2,250,2);
	public static JefeSeccion jefeseccion1=new JefeSeccion("Ramonchu","Cadiz","Sevilla","34545434z",2,1,160,1);
	public static JefePlanta jefeplanta0=new JefePlanta("Alejandra","Mira","Cuenca","123456790c",3,1,5,230);
	public static Administracion administracion0=new Administracion("Luisito","Comunica","Mucho","5445535c",4,8,1);
	public static Directivo directivo0=new Directivo("Lola","Mentos","Perez","905535f",5,50,360,true);
	public static Directivo directivo1=new Directivo("Pepe","Ramon","Perez","54545",5,3,120,true);

	
	public static void main(String[] args) {
		empleados.add(mozoalmacen0);
		empleados.add(mozoalmacen1);
		empleados.add(jefeseccion0);
		empleados.add(jefeseccion1);
		empleados.add(jefeplanta0);
		empleados.add(administracion0);
		empleados.add(directivo0);
		empleados.add(directivo1);

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
				listadoTrabajadores(opcion);
			break;
			
			case 3:
				verListadoPorPuesto(opcion);	
			break;
			
			case 4:
				avanceTemporal(opcion);
			break;
			case 5:
				mostrarMatriz();
			break;
			}
		
		} while (opcion < 0 || opcion > 7);
		
		//[7] Opcion extra  para terminar el programa
		if (opcion == 7) {
			System.out.println("\n[7] - Terminar el Programa tras "+dia+" dias en activo.");
			System.exit(0);
			}
		}
	}
	
	
	//[1] Introducir Empleados
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
			Directivo directivo =new Directivo(nombre, apellido1, apellido2, dni, puesto, aniosantiguedad,  diasantiguedad,true);
			empleados.add(directivo);
			break;	
			
		}
	}

	//[2] Eliminar empleados
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

	//[3] Listado de Trabajadores 
	
	private static void listadoTrabajadores(int opcion) {
		int opcionempleado=0;
		System.out.println("[3] - Listrado trabajadores");
		if (empleados.size()>0) {
			for (int i=0; i<empleados.size(); i++) {
				System.out.println("ID: "+(i+1)+", "+empleados.get(i));
			}
		}
		else System.err.println("ERROR: No hay empleados para poder mostrar");
		
		do {
		System.out.println("Elige un empleado utilizando su ID para ver su sueldo neto y inmdenizacion");					
		opcionempleado=introducirNumeroEntero(opcion)-1;
		}while(opcionempleado<0 || opcionempleado>empleados.size());
		
		System.out.println("\t\tDatos Empleado");
		System.out.println("\t- "+empleados.get(opcionempleado));
		System.out.println("\t- Sueldo Neto Final: "+empleados.get(opcionempleado).sueldoNeto()+"\n");
		System.out.println("\t- Inmdenizacion Final: "+empleados.get(opcionempleado).indemnizacion()+"\n");
	}

	//[4] Listado empleados por puesto
	private static void verListadoPorPuesto(int opcion) {
		int opcionsubmenu=0;
		System.out.println("[4] - Listado trabajadores por puesto");
		if (empleados.size()>0) {
		do {
			System.out.println("\t(1) Mozos de Almacen");
			System.out.println("\t(2) Jefes de Seccion");
			System.out.println("\t(3) Jefes de Planta");
			System.out.println("\t(4) Personal de Administracion");
			System.out.println("\t(5) Directivos");
			System.out.println(">> Introduce un numero (1-5) para elegir un tipo de empleado para poder observar el listado");
			
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
	
	//[5] Avance Temporal
	
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
	
	//[6] Mostrar matriz con cada tipo de empleado que tenga el num menor de dia,
	//num mayor de dias y num medio de dias trabajados
	
	private static void mostrarMatriz() {
		System.out.println("[6] - Mostrar matriz dias trabajados");
		int matriz[][]=new int[5][4];

		//Comprobacion del num de empleados de cada tipo.
		int empleadosMozo=0;
		int empleadosSeccion=0;
		int empleadosPlanta=0;
		int empleadosAdmin=0;
		int empleadosDirectiva=0;
		
		
		for (int i=0; i<empleados.size(); i++) {
			
			if (empleados.get(i) instanceof MozoAlmacen) {		
			empleadosMozo++;
			}
			if (empleados.get(i) instanceof JefeSeccion) {		
			empleadosSeccion++;
			}
			if (empleados.get(i) instanceof JefePlanta) {		
			empleadosPlanta++;
			}
			if (empleados.get(i) instanceof Administracion) {		
			empleadosAdmin++;
			}
			if (empleados.get(i) instanceof Directivo) {		
			empleadosDirectiva++;
			}
		}
		
		//Creacion de los Arrays por cada tipo de empleado del tamanio del tipo de empleado (EJ: 2 Mozos, 3 Personal de Seleccion etc)
		int diasCadaMozo[]=new int [empleadosMozo];
		int diasCadaSeccion[]=new int [empleadosSeccion];
		int diasCadaPlanta[]=new int [empleadosPlanta];
		int diasCadaAdmin[]=new int [empleadosAdmin];
		int diasCadaDirectivo[]=new int [empleadosDirectiva];
		int contador=0;	
		int diasTotalesMozos=0; 
		int diasTotalesSeccion=0;
		int diasTotalesPlanta=0;
		int diasTotalesAdmin=0;
		int diasTotalesDirectivo=0;

		for (int i=0; i<empleados.size(); i++) {
			if (empleados.get(i) instanceof MozoAlmacen) {
				
				int diasCalculado=empleados.get(i).getTiempototal()+(empleados.get(i).getAntiguedad()*365);
				diasCadaMozo[contador]=diasCalculado;
				diasTotalesMozos+=diasCalculado;
				contador++;
			}
		}
		contador=0;
		for (int i=0; i<empleados.size(); i++) {
			if (empleados.get(i) instanceof JefeSeccion) {
				
				int diasCalculado=empleados.get(i).getTiempototal()+(empleados.get(i).getAntiguedad()*365);
				diasCadaSeccion[contador]=diasCalculado;
				diasTotalesSeccion+=diasCalculado;
				contador++;
			}
		}
		contador=0;
		for (int i=0; i<empleados.size(); i++) {
			if (empleados.get(i) instanceof JefePlanta) {
				
				int diasCalculado=empleados.get(i).getTiempototal()+(empleados.get(i).getAntiguedad()*365);
				diasCadaPlanta[contador]=diasCalculado;
				diasTotalesPlanta+=diasCalculado;
				contador++;
			}
		}
		contador=0;
		for (int i=0; i<empleados.size(); i++) {
			if (empleados.get(i) instanceof Administracion) {
				
				int diasCalculado=empleados.get(i).getTiempototal()+(empleados.get(i).getAntiguedad()*365);
				diasCadaAdmin[contador]=diasCalculado;
				diasTotalesAdmin+=diasCalculado;
				contador++;
			}
		}
		contador=0;
		for (int i=0; i<empleados.size(); i++) {
			if (empleados.get(i) instanceof Directivo) {
				
				int diasCalculado=empleados.get(i).getTiempototal()+(empleados.get(i).getAntiguedad()*365);
				diasCadaDirectivo[contador]=diasCalculado;
				diasTotalesDirectivo+=diasCalculado;
				contador++;
			}
		}
		
		//Ordenar los dias de los empleados de menor a mayoor
		Arrays.sort(diasCadaMozo);
		Arrays.sort(diasCadaSeccion);
		Arrays.sort(diasCadaPlanta);
		Arrays.sort(diasCadaAdmin);
		Arrays.sort(diasCadaDirectivo);

		//Meter datos a la matriz

		matriz[0][0]=1;
		matriz[1][0]=2;
		matriz[2][0]=3;
		matriz[3][0]=4;
		matriz[4][0]=5;
		matriz[0][1]=diasCadaMozo[0];
		matriz[0][2]=diasCadaMozo[diasCadaMozo.length-1];
		matriz[0][3]=diasTotalesMozos/empleadosMozo;
		
		matriz[1][1]=diasCadaSeccion[0];
		matriz[1][2]=diasCadaSeccion[diasCadaSeccion.length-1];
		matriz[1][3]=diasTotalesSeccion/empleadosSeccion;
		
		matriz[2][1]=diasCadaPlanta[0];
		matriz[2][2]=diasCadaPlanta[diasCadaPlanta.length-1];
		matriz[2][3]=diasTotalesPlanta/empleadosPlanta;
		
		
		matriz[3][1]=diasCadaAdmin[0];
		matriz[3][2]=diasCadaAdmin[diasCadaAdmin.length-1];
		matriz[3][3]=diasTotalesAdmin/empleadosAdmin;
		
		matriz[4][1]=diasCadaDirectivo[0];
		matriz[4][2]=diasCadaDirectivo[diasCadaDirectivo.length-1];
		matriz[4][3]=diasTotalesDirectivo/empleadosDirectiva;
		
		//Mostrar Matriz
		System.out.println("\tTipo Empleados\t   Menos Dias \t\t   Mas Dias\t\t   Media Dias");
		
		for (int i=0; i<matriz.length; i++) {
			
			for (int j=0; j<matriz[i].length; j++) {
				
				System.out.print("\t"+matriz[i][j]+"\t\t");
				
			}
			System.out.println();
		}
	}
		
	//[Extra] Try-Catch para Int
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
	
	//[Extra] Try-Catch para Double
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
