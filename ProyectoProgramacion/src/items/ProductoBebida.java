package items;

import java.text.DecimalFormat;

public class ProductoBebida extends Producto{
	private int numBotellas;

	public ProductoBebida(String nombre, double precio, int numBotellas) {
		super(nombre, precio);
		this.numBotellas = numBotellas;
	}

	@Override
	public double calcularPrecio() {
		double precioFinal = numBotellas*getPrecio();
		precioFinal = (double) Math.round(precioFinal * 100) / 100;
		return precioFinal;
	}
	
	@Override
	public String toString() {
		return super.toString()+"\t\t" + numBotellas + "\t\t"+ calcularPrecio();
	}
	

}
