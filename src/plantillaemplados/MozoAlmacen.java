package plantillaemplados;

public class MozoAlmacen extends Empleado {

	//---------Atributos--------//

	private double sueldoBruto=1545.5;
	
	//---------Metodos----------//
	
	@Override
	public double sueldoNeto() {
		
		double calcExtraPorAnio=0;
		calcExtraPorAnio=(this.getSueldoBruto()*5)/100;
		
		double brutoEmpleado=this.getSueldoBruto()+(calcExtraPorAnio*this.getAntiguedad());
		
		double calcSueldoNeto=(brutoEmpleado*85)/100;
		calcSueldoNeto=Math.round(calcSueldoNeto*100.00)/100.00;
		
		return calcSueldoNeto;
	}
	@Override
	public double indemnizacion() {

		return 0;
	}

	//------Constructores-------//
	
	public MozoAlmacen(String nombre, String apellido1, String apellido2, String dni, int puesto, int antiguedad,
			int tiempototal) {
		super(nombre, apellido1, apellido2, dni, puesto, antiguedad, tiempototal);
	}
	
	public MozoAlmacen(String nombre, String apellido1, String apellido2, String dni, int puesto,int tiempototal) {
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
