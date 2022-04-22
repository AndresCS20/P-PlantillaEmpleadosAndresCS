package plantillaemplados;

public class JefeSeccion  extends Empleado {

	//---------Atributos--------//

	private double sueldoBruto=1750;
	private int categoria=0; // Puede ser 1,2 o 3
	
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
	
	public JefeSeccion(String nombre, String apellido1, String apellido2, String dni, int puesto, int antiguedad,
			int tiempototal, int categoria) {
		super(nombre, apellido1, apellido2, dni, puesto, antiguedad, tiempototal);
		this.categoria = categoria;
	}
	
	public JefeSeccion(String nombre, String apellido1, String apellido2, String dni, int puesto, int tiempototal, int categoria) {
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
