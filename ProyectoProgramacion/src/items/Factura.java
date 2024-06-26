package items;
import java.util.ArrayList;
public class Factura {
	private ArrayList<Producto> listaCompra;
	private boolean descuentoFamilia;
	private boolean descuentoTarjeta;

	public Factura() {
		super();
		listaCompra = new ArrayList<Producto>() ;
	}
	
	public void setDescuentoFamilia(boolean descuentoFamilia) {
		this.descuentoFamilia = descuentoFamilia;
	}

	public void setDescuentoTarjeta(boolean descuentoTarjeta) {
		this.descuentoTarjeta = descuentoTarjeta;
	}
	
	public void añadirProducto(Producto p) {
		listaCompra.add(p);
	}
	public void quitarProducto(String nombre) {
		for (int i = 0; i < listaCompra.size(); i++) {
			if(listaCompra.get(i).getNombre().equals(nombre)) {
				listaCompra.remove(i);
			}
		}
	}
	public String mostrarListaCompra() {
		String factura="Producto\tPrecio Producto\tPeso\tPrecio Final\n";
		for (int i = 0; i < listaCompra.size(); i++) {
			if(listaCompra.get(i) instanceof ProductoFresco) {
				factura += listaCompra.get(i)+"\n";
			}
		}
		factura+="Producto\tPrecio Producto\tNumero de Botellas\tPrecio Final\n";
		for (int i = 0; i < listaCompra.size(); i++) {
			if(listaCompra.get(i) instanceof ProductoBebida) {
				factura += listaCompra.get(i)+"\n";
			}
		}
		factura+="El precio total de la compra es: " + calcularTotal();
		return factura;
	}
	public double calcularTotal() {
	    double total = 0;
	    for (int i = 0; i < listaCompra.size(); i++) {
	        total += listaCompra.get(i).calcularPrecio();
	    }
	    if (descuentoFamilia) {
	        total -= total * 0.2;
	    }
	    if (descuentoTarjeta) {
	        total -= total * 0.15;
	    }
	    // Redondear a dos decimales
	    total = (double) Math.round(total * 100) / 100;
	    return total;
	}
}
