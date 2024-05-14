package items;

import java.text.DecimalFormat;

public class ProductoFresco extends Producto{
	private double peso;
	
	

	public ProductoFresco(String nombre, double precio, double peso) {
		super(nombre, precio);
		this.peso = peso;
	}

	@Override
	public double calcularPrecio() {
		double precioFinal = peso*getPrecio();
		
		return precioFinal;
	}

	@Override
	public String toString() {
		return super.toString()+"\t\t" + peso + "\t"+ calcularPrecio();
	}
	
}
