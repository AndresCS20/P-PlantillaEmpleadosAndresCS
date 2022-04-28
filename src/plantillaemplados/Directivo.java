package plantillaemplados;

public class Directivo  extends Empleado {

	//---------Atributos--------//

	private double sueldoBruto=4500;
	private boolean consejoAdmin=false;
	
	//---------Metodos----------//
	
	@Override
	public double sueldoNeto() {
		System.out.println("\n\t\tSueldo Empleado");
		double calcExtraPorAnio=0;
		calcExtraPorAnio=(this.sueldoBruto*12)/100;
		calcExtraPorAnio=calcExtraPorAnio/14;
		calcExtraPorAnio=Math.round(calcExtraPorAnio*100.00)/100.00;
		System.out.println("\t- Aumento del sueldo bruto por año trabajado: "+calcExtraPorAnio);
		System.out.println("\t- Sueldo Bruto Base: "+this.sueldoBruto);
		double brutoEmpleado=this.sueldoBruto+(calcExtraPorAnio*this.getAntiguedad());
		System.out.println("\t- Sueldo Bruto Final: "+brutoEmpleado);
		
		double calcSueldoNeto=(brutoEmpleado*73)/100;
		calcSueldoNeto=Math.round(calcSueldoNeto*100.00)/100.00;
		System.out.println("\t- Sueldo Neto Base: "+calcSueldoNeto);
		
	
		if (this.getAntiguedad()>0) {
			int comision=100*this.getAntiguedad();
			System.out.println("\t- Comision por antiguedad" + comision);
			calcSueldoNeto+=comision;
		}
		if (this.consejoAdmin==true) {
			System.out.println("\t- Extra: +200 por ser miembro del Consejo de Administracion.");
			calcSueldoNeto+=200;
		}
		calcSueldoNeto=Math.round(calcSueldoNeto*100.00)/100.00;
		return calcSueldoNeto;
	}
	@Override
	public double indemnizacion() {
		//SUELDO BRUTO MENSUAL CON LOS EXTRAS POR AÑO TRABAJADO
		double inmdenizacion=0;
		
		System.out.println("\n\t\tIndemnizacion Empleado");
		double calcExtraPorAnio=0;
		
		calcExtraPorAnio=(this.sueldoBruto*12)/100;
		calcExtraPorAnio=calcExtraPorAnio/14;
		calcExtraPorAnio=Math.round(calcExtraPorAnio*100.00)/100.00;
		System.out.println("\t- Aumento del sueldo bruto por año trabajado: "+calcExtraPorAnio);
		
		System.out.println("\t- Sueldo Bruto Base: "+this.sueldoBruto);
		double brutoEmpleado=this.sueldoBruto+(calcExtraPorAnio*this.getAntiguedad());
		System.out.println("\t- Sueldo Bruto Final: "+brutoEmpleado);
		

		//CALCULAR EL SUELDO BRUTO FINAL DE UN AÑO (14 MESES)
		double calcSueldoBrutoAnual=(brutoEmpleado*14)*2;
		calcSueldoBrutoAnual=Math.round(calcSueldoBrutoAnual*100.00)/100.00;
		
		double calcInmdenizacion=((brutoEmpleado*20)/30)*14;
		calcInmdenizacion=Math.round(calcInmdenizacion*100.00)/100.00;
		System.out.println("\t- Sueldo Bruto Anual (14 Pagas) "+ calcSueldoBrutoAnual);
		
		if (calcInmdenizacion>calcSueldoBrutoAnual) {
			
			inmdenizacion=calcSueldoBrutoAnual;
		}
		else inmdenizacion=calcInmdenizacion;
		
		return inmdenizacion;
	}
	
	//------Constructores-------//
	

	
	public Directivo(String nombre, String apellido1, String apellido2, String dni, int puesto, int antiguedad,
			int tiempototal, boolean consejoAdmin) {
		super(nombre, apellido1, apellido2, dni, puesto, antiguedad, tiempototal);
		this.consejoAdmin = consejoAdmin;
	}
	public Directivo(String nombre, String apellido1, String apellido2, String dni, int puesto,int tiempototal, boolean consejoAdmin) {
		super(nombre, apellido1, apellido2, dni, puesto,tiempototal);
		this.consejoAdmin = consejoAdmin;
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
