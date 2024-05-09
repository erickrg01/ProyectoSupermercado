package items;

public class ProductoFresco extends Producto{
	private double peso;
	
	

	public ProductoFresco(String nombre, double precio, double peso) {
		super(nombre, precio);
		this.peso = peso;
	}

	@Override
	public double calcularPrecio() {
		return peso*getPrecio();
	}

	@Override
	public String toString() {
		return super.toString()+"    " + peso + "   "+ calcularPrecio();
	}
	
}
