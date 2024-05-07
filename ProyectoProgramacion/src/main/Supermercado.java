package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import items.*;
import javax.swing.JLabel;


public class Supermercado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JButton btnCarne;
	private JButton btnPescado;
	private JButton btnVerdura;
	private JButton btnFruta;
	private JButton btnBebidas;
	private JButton btnVerFactura;
	private JButton btnQuitarProducto;
	private JButton btnFinalizarCompra;
	private JTextField txNombreProducto;
	private JTextPane txFactura;
	private JButton btnVolverAInicio;
	private JPanel pCarne;
	private JButton btnVolver;
	private JButton btnPollo;
	private JButton btnTernera;
	private JTextField txKilogramos;
	
	
	
	private Factura nuevaFactura = new Factura();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Supermercado frame = new Supermercado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public Supermercado() {
		crearGUI();
		crearEventos();

	}
	public void crearGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		tabbedPane.setBounds(12, 0, 1100, 650);
		contentPane.add(tabbedPane);
		
		JPanel Inicio = new JPanel();
		tabbedPane.addTab("Inicio", null, Inicio, null);
		Inicio.setLayout(null);
		
		btnCarne = new JButton("Carne");
		btnCarne.setBounds(83, 109, 117, 25);
		Inicio.add(btnCarne);
		
		btnPescado = new JButton("Pescado");
		btnPescado.setBounds(212, 109, 117, 25);
		Inicio.add(btnPescado);
		
		btnVerdura = new JButton("Verdura");
		btnVerdura.setBounds(341, 109, 117, 25);
		Inicio.add(btnVerdura);
		
		btnFruta = new JButton("Fruta");
		btnFruta.setBounds(470, 109, 117, 25);
		Inicio.add(btnFruta);
		
		btnBebidas = new JButton("Bebidas");
		btnBebidas.setBounds(599, 109, 117, 25);
		Inicio.add(btnBebidas);
		
		btnVerFactura = new JButton("Ver factura");
		btnVerFactura.setBounds(341, 242, 117, 25);
		Inicio.add(btnVerFactura);
		
		pCarne = new JPanel();
		tabbedPane.addTab("Carne", null, pCarne, null);
		pCarne.setLayout(null);
		
		btnTernera = new JButton("Ternera");
		btnTernera.setBounds(281, 86, 117, 25);
		pCarne.add(btnTernera);
		
		txKilogramos = new JTextField();
		txKilogramos.setBounds(391, 148, 114, 19);
		pCarne.add(txKilogramos);
		txKilogramos.setColumns(10);
		
		JLabel lblKg = new JLabel("Kg");
		lblKg.setBounds(344, 149, 29, 17);
		pCarne.add(lblKg);
		
		btnPollo = new JButton("Pollo");
		btnPollo.setBounds(501, 86, 117, 25);
		pCarne.add(btnPollo);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(388, 219, 117, 25);
		pCarne.add(btnVolver);
		
		JPanel pFactura = new JPanel();
		tabbedPane.addTab("Factura", null, pFactura, null);
		pFactura.setLayout(null);
		
		btnQuitarProducto = new JButton("Quitar producto");
		btnQuitarProducto.setBounds(714, 90, 146, 25);
		pFactura.add(btnQuitarProducto);
		
		txNombreProducto = new JTextField();
		txNombreProducto.setBounds(546, 93, 114, 19);
		pFactura.add(txNombreProducto);
		txNombreProducto.setColumns(10);
		
		btnFinalizarCompra = new JButton("Finalizar compra");
		btnFinalizarCompra.setBounds(701, 230, 159, 25);
		pFactura.add(btnFinalizarCompra);
		
		txFactura = new JTextPane();
		txFactura.setEditable(false);
		txFactura.setBounds(42, 31, 371, 529);
		pFactura.add(txFactura);
		
		btnVolverAInicio = new JButton("Volver a inicio");
		btnVolverAInicio.setBounds(701, 158, 159, 25);
		pFactura.add(btnVolverAInicio);
		
	}
	public void crearEventos() {
		btnCarne.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedIndex(1);
            }
        });
		btnVerFactura.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	txFactura.setText(nuevaFactura.mostrarListaCompra());
                tabbedPane.setSelectedIndex(2);
            }
        });
		btnVolverAInicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedIndex(0);
            }
        });
		btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedIndex(0);
            }
        });
		btnTernera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	double precio = 10.49;
                double peso = Double.parseDouble(txKilogramos.getText());
                ProductoFresco pf = new ProductoFresco("Ternera",precio,peso);
                nuevaFactura.añadirProducto(pf);
            }
        });
		btnPollo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	double precio = 8.75;
                double peso = Double.parseDouble(txKilogramos.getText());
                ProductoFresco pf = new ProductoFresco("Pollo",precio,peso);
                nuevaFactura.añadirProducto(pf);
            }
        });
		
		
	}
}
