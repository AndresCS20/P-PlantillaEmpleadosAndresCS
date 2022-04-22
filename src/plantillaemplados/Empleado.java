package plantillaemplados;

public class Empleado implements Cobros {


	//---------Atributos--------//
	
	private String nombre="";
	private String apellido1="";
	private String apellido2="";
	private String dni="";
	private int puesto=0; // (1-Mozo de Almacen) (2-Jefe de Seccion) (3-Jefe de Planta) (4- Administracion) (5-Directivos)
	private int antiguedad=0;  //Este atributo seran anios (tiempo total : 365 dias) EJ: 1,2,3 Anios
	private int tiempototal=0; //Este atributo seran dias menor de un anio (cuando el atributo sea igual 365 se suma una anio de antiguedad y se restan los dias 

	
	//---------Metodos----------//
	
	@Override
	public String toString() {
		String nombrePuesto="";
		
		switch (puesto-1) {
		case 0:
			nombrePuesto="Mozo de Almacen";
			break;
		case 1:
			nombrePuesto="Jefe de Seccion";
			break;
		case 2:
			nombrePuesto="Jefe de Planta";
			break;
		case 3:
			nombrePuesto="Personal de administracion";
			break;
		case 4:
			nombrePuesto="Directivo";
			break;			

		}
		
		return "Nombre:" + nombre + ", Apellidos:" + apellido1 + " " + apellido2 + ", DNI:" + dni
				+ ", Puesto:" + nombrePuesto + ", Antiguedad:" + antiguedad + ", anios y " + tiempototal + " dias";
	}
	
	
	@Override
	public double sueldoNeto() {

		return 0;
	}
	@Override
	public double indemnizacion() {

		return 0;
	}	
	
	//------Constructores-------//
	
	public Empleado(String nombre, String apellido1, String apellido2, String dni, int puesto, int antiguedad,int tiempototal) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.puesto = puesto;
		this.antiguedad = antiguedad;
		this.tiempototal = tiempototal;
	}
	
	public Empleado(String nombre, String apellido1, String apellido2, String dni, int puesto,int tiempototal) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.puesto = puesto;
		this.tiempototal = tiempototal;
	}
	
	public Empleado () {

	}	

	//----Setters && Getters----//
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getPuesto() {
		return puesto;
	}
	public void setPuesto(int puesto) {
		this.puesto = puesto;
	}
	public int getAntiguedad() {
		return antiguedad;
	}
	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
	public int getTiempototal() {
		return tiempototal;
	}
	public void setTiempototal(int tiempototal) {
		this.tiempototal = tiempototal;
	}

}
