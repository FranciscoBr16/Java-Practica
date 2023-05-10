package ejercicio5a;

public class Administrativo extends Empleado{

	private int hsExtra;
	private int hsMes;
	public int getHsExtra() {
		return hsExtra;
	}
	public void setHsExtra(int hsExtra) {
		this.hsExtra = hsExtra;
	}
	public int getHsMes() {
		return hsMes;
	}
	public void setHsMes(int hsMes) {
		this.hsMes = hsMes;
	}
	
	public void setValores(int dni, String nom, String ape, String email, float sueldo, int hsExtra, int hsMes) {
		this.setDni(dni);
		this.setNombre(nom);
		this.setApellido(ape);
		this.setEmail(email);
		this.setSueldoBase(sueldo);
		this.setHsExtra(hsExtra);
		this.setHsMes(hsMes);
		
	}
	
	public float getSueldo() {
		return (float) (this.getSueldoBase() * ((this.getHsExtra() * 1.5)+this.getHsMes()) / this.getHsMes());
		
	}
	
	
	public String mostrarDatos() {
		return (super.mostrarDatos()+ " [Sueldo]: "+ this.getSueldo());
	}
}
