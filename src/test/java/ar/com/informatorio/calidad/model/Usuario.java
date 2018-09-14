package ar.com.informatorio.calidad.model;

public class Usuario {
	
	private int dni;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	private String password;


	public Usuario(int dni, String nombre, String apellido, String email, String telefono, String password) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.password = password;
	}

	public Usuario(int dni, String nombre, String apellido) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Usuario(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public Usuario() {
	}

	public int getDni(){
		return dni;
	}
	
	public void setDni(int dni){
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}