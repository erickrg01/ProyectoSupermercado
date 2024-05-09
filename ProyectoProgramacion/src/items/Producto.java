package items;

public abstract class Producto {
	private String nombre;
	private double precio;

	
	public Producto(String nombre, double precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public String getNombre() {
		return nombre;
	}

	public abstract double calcularPrecio();

	@Override
	public String toString() {
		return nombre + "   " + precio;
	}
	
	
}
