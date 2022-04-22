package plantillaemplados;

public class Directivo  extends Empleado {

	//---------Atributos--------//

	private double sueldoBruto=4500;
	
	//---------Metodos----------//
	
	@Override
	public double sueldoNeto() {

		return 0;
	}
	@Override
	public double indemnizacion() {

		return 0;
	}
	
	//------Constructores-------//
	
	public Directivo(String nombre, String apellido1, String apellido2, String dni, int puesto, int antiguedad,
			int tiempototal) {
		super(nombre, apellido1, apellido2, dni, puesto, antiguedad, tiempototal);
	}
	
	public Directivo(String nombre, String apellido1, String apellido2, String dni, int puesto,int tiempototal) {
		super(nombre, apellido1, apellido2, dni, puesto,tiempototal);
	}

	
	//----Setters && Getters----//

	public double getSueldoBruto() {
		return sueldoBruto;
	}
	public void setSueldoBruto(double sueldoBruto) {
		this.sueldoBruto = sueldoBruto;
	}	

}
