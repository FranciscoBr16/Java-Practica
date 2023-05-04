package ejercicio5;

public class Vendedor extends Empleado {

	private float porcentajeComision;
	private float totalVentas;
	public float getPorcentajeComision() {
		return porcentajeComision;
	}
	public void setPorcentajeComision(float porcentajeComision) {
		this.porcentajeComision = porcentajeComision;
	}
	public float getTotalVentas() {
		return totalVentas;
	}
	public void setTotalVentas(float totalVentas) {
		this.totalVentas = totalVentas;
	}
	public void setValores(int dni, String nom, String ape, String email, float sueldo, float porcentaje, float ventas) {
		this.setDni(dni);
		this.setNombre(nom);
		this.setApellido(ape);
		this.setEmail(email);
		this.setSueldoBase(sueldo);
		this.setPorcentajeComision(porcentaje);
		this.setTotalVentas(ventas);
		
	}
	
	public float getSueldo() {
		return (float) (this.getSueldoBase() + (this.getPorcentajeComision()*this.getTotalVentas()/100));
		
	}
	
	public String mostrarDatos() {
		return (super.mostrarDatos()+ " [Sueldo]: "+ this.getSueldo());
	}
}
