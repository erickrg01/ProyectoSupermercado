package items;

public class ProductoBebida extends Producto{
	private int numBotellas;

	public ProductoBebida(String nombre, double precio, int numBotellas) {
		super(nombre, precio);
		this.numBotellas = numBotellas;
	}

	@Override
	public double calcularPrecio() {
		return numBotellas*getPrecio();
	}
	
	@Override
	public String toString() {
		return super.toString()+", numBotellas= " + numBotellas + ", Precio Final= "+ calcularPrecio();
	}
	

}
