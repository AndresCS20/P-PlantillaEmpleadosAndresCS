package plantillaemplados;

public class JefePlanta  extends Empleado {

	//---------Atributos--------//

	private double sueldoBruto=1825.5;
	private int categoria=0; //Puede ser 1,2,3 o 4.
	
	//---------Metodos----------//
	
	@Override
	public double sueldoNeto() {
		
		double calcExtraPorAnio=0;
		calcExtraPorAnio=(this.getSueldoBruto()*9)/100;
		
		double brutoEmpleado=this.getSueldoBruto()+(calcExtraPorAnio*this.getAntiguedad());
		
		double calcSueldoNeto=(brutoEmpleado*81)/100;
		calcSueldoNeto=Math.round(calcSueldoNeto*100.00)/100.00;
		
		switch (this.categoria) {
		case 1:
			calcSueldoNeto+=50;
			break;
		case 2:
			calcSueldoNeto+=100;
			break;
		case 3:
			calcSueldoNeto+=150;
			break;			
		case 4:
			calcSueldoNeto+=200;
			break;	
		}
		
		return calcSueldoNeto;
	}
	@Override
	public double indemnizacion() {

		return 0;
	}

	//------Constructores-------//
	
	public JefePlanta(String nombre, String apellido1, String apellido2, String dni, int puesto, int antiguedad,
			int tiempototal, int categoria) {
		super(nombre, apellido1, apellido2, dni, puesto, antiguedad, tiempototal);
		this.categoria = categoria;
	}

	public JefePlanta(String nombre, String apellido1, String apellido2, String dni, int puesto, int tiempototal, int categoria) {
		super(nombre, apellido1, apellido2, dni, puesto, tiempototal);
		this.categoria = categoria;
	}
	//----Setters && Getters----//

	public double getSueldoBruto() {
		return sueldoBruto;
	}
	public void setSueldoBruto(double sueldoBruto) {
		this.sueldoBruto = sueldoBruto;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}	
	
}
