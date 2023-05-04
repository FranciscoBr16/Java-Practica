package ejercicio5;

public class Empleado {

private int dni;
private String nombre;
private String apellido;
private String email;
private float sueldoBase;
private float sueldo;

public int getDni() {
	return dni;
}
public void setDni(int dni) {
	this.dni = dni;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public float getSueldoBase() {
	return sueldoBase;
}
public void setSueldoBase(float sueldoBase) {
	this.sueldoBase = sueldoBase;
}
public float getSueldo() {
	return sueldo;
}
public void setSueldo(float sueldo) {
	this.sueldo = sueldo;
}

public String mostrarDatos() {
	return ("[Nombre]: " + this.getNombre() + " [Apellido]: " + this.getApellido());
}

}
