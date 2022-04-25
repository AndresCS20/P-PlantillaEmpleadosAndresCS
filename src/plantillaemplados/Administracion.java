package plantillaemplados;

public class Administracion  extends Empleado {

	//---------Atributos--------//

	private double sueldoBruto=1635;

	
	//---------Metodos----------//
	
	@Override
	public double sueldoNeto() {
		
		double calcExtraPorAnio=0;
		calcExtraPorAnio=(this.getSueldoBruto()*6)/100;
		
		double brutoEmpleado=this.getSueldoBruto()+(calcExtraPorAnio*this.getAntiguedad());
		
		double calcSueldoNeto=(brutoEmpleado*84)/100;
		calcSueldoNeto=Math.round(calcSueldoNeto*100.00)/100.00;
		
		return calcSueldoNeto;
	}
	@Override
	public double indemnizacion() {

		return 0;
	}

	//------Constructores-------//
	
	public Administracion(String nombre, String apellido1, String apellido2, String dni, int puesto, int antiguedad,
			int tiempototal) {
		super(nombre, apellido1, apellido2, dni, puesto, antiguedad, tiempototal);
	}
	
	public Administracion(String nombre, String apellido1, String apellido2, String dni, int puesto,int tiempototal) {
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
