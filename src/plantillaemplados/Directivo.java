package plantillaemplados;

public class Directivo  extends Empleado {

	//---------Atributos--------//

	private double sueldoBruto=4500;
	private boolean consejoAdmin=false;
	
	//---------Metodos----------//
	
	@Override
	public double sueldoNeto() {
		
		double calcExtraPorAnio=0;
		calcExtraPorAnio=(this.getSueldoBruto()*12)/100;
		
		double brutoEmpleado=this.getSueldoBruto()+(calcExtraPorAnio*this.getAntiguedad());
		
		double calcSueldoNeto=(brutoEmpleado*73)/100;
		calcSueldoNeto=Math.round(calcSueldoNeto*100.00)/100.00;
		//TERMINAR
		return calcSueldoNeto;
	}
	@Override
	public double indemnizacion() {

		return 0;
	}
	
	//------Constructores-------//
	
	public Directivo(String nombre, String apellido1, String apellido2, String dni, int puesto, int antiguedad,
			int tiempototal, boolean consejoAdmin) {
		super(nombre, apellido1, apellido2, dni, puesto, antiguedad, tiempototal);
	}
	
	public Directivo(String nombre, String apellido1, String apellido2, String dni, int puesto,int tiempototal, boolean consejoAdmin) {
		super(nombre, apellido1, apellido2, dni, puesto,tiempototal);
	}

	
	//----Setters && Getters----//

	public double getSueldoBruto() {
		return sueldoBruto;
	}
	public void setSueldoBruto(double sueldoBruto) {
		this.sueldoBruto = sueldoBruto;
	}
	public boolean isConsejoAdmin() {
		return consejoAdmin;
	}
	public void setConsejoAdmin(boolean consejoAdmin) {
		this.consejoAdmin = consejoAdmin;
	}	

}
