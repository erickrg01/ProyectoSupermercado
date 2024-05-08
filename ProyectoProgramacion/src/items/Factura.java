package items;
import java.util.ArrayList;
import java.util.Iterator;
public class Factura {
	private ArrayList<Producto> listaCompra;

	public Factura() {
		super();
		listaCompra = new ArrayList<Producto>() ;
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
		String factura="";
		for (int i = 0; i < listaCompra.size(); i++) {
			factura += listaCompra.get(i)+"\n";
		}
		return factura;
	}
	public void calcularTotal () {
		double total = 0;
		for (int i = 0; i < listaCompra.size(); i++) {
			total +=listaCompra.get(i).calcularPrecio();
		}
		System.out.println("El precio total de la compra es: "+total);
	}
	
}