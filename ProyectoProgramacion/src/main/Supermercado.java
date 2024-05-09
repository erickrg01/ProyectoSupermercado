package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import items.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


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
	private JButton btnVolver1;
	private JButton btnPollo;
	private JButton btnTernera;
	private JTextField txKilogramos;
	
	
	
	private Factura nuevaFactura = new Factura();
	private JPanel pBebidas;
	private JLabel lblNumeroDeBotellas;
	private JButton btnAgua;
	private JButton btnVolver2;
	private JTextField txNumBotellas;
	private JPanel pPescado;
	private JPanel pVerdura;
	private JPanel pFruta;
	private AbstractButton btnVolverPescado;
	private AbstractButton btnVolverVerdura;
	private AbstractButton btnVolverFruta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	    String usuarioGuardado = "Yo";
        String contraseñaGuardada = "12345";

        String usuarioIngresado = JOptionPane.showInputDialog(null, "Ingrese su usuario:");
        String contraseñaIngresada = JOptionPane.showInputDialog(null, "Ingrese su contraseña:");

      
        if (usuarioIngresado != null && contraseñaIngresada != null &&
                usuarioIngresado.equals(usuarioGuardado) && contraseñaIngresada.equals(contraseñaGuardada)) {
           
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
        } else {
            
            JOptionPane.showMessageDialog(null, "Credenciales incorrectas. El programa se cerrará.");
            System.exit(0);
        }
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
		
		pPescado = new JPanel();
		tabbedPane.addTab("Pescado", null, pPescado, null);
		pPescado.setLayout(null);

		pVerdura = new JPanel();
		tabbedPane.addTab("Verdura", null, pVerdura, null);
		pVerdura.setLayout(null);

		pFruta = new JPanel();
		tabbedPane.addTab("Fruta", null, pFruta, null);
		pFruta.setLayout(null);
		
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
		
		btnVolver1 = new JButton("Volver");
		btnVolver1.setBounds(388, 219, 117, 25);
		pCarne.add(btnVolver1);
		
		btnVolverPescado = new JButton("Volver");
		btnVolverPescado.setBounds(388, 219, 117, 25);
		pPescado.add(btnVolverPescado);
		
		btnVolverVerdura = new JButton("Volver");
		btnVolverVerdura.setBounds(388, 219, 117, 25);
		pVerdura.add(btnVolverVerdura);
		
		btnVolverFruta = new JButton("Volver");
		btnVolverFruta.setBounds(388, 219, 117, 25);
		pFruta.add(btnVolverFruta);
		
		pBebidas = new JPanel();
		tabbedPane.addTab("Bebidas", null, pBebidas, null);
		pBebidas.setLayout(null);
		
		btnAgua = new JButton("Agua");
		btnAgua.setBounds(282, 102, 117, 25);
		pBebidas.add(btnAgua);
		
		btnVolver2 = new JButton("Volver 2");
		btnVolver2.setBounds(402, 232, 117, 25);
		pBebidas.add(btnVolver2);
		
		txNumBotellas = new JTextField();
		txNumBotellas.setBounds(384, 172, 114, 19);
		pBebidas.add(txNumBotellas);
		txNumBotellas.setColumns(10);
		
		lblNumeroDeBotellas = new JLabel("Numero de Botellas");
		lblNumeroDeBotellas.setBounds(202, 174, 149, 15);
		pBebidas.add(lblNumeroDeBotellas);
		
		//FOTOS
		tabbedPane.addTab("Carne", null, pCarne, null);
		pCarne.setLayout(null);

		JLabel lblFondoCarne = new JLabel();
		lblFondoCarne.setBounds(0, 0, 1100, 650);
		lblFondoCarne.setIcon(new ImageIcon("imagenes_supermercado/carne.jpg")); 
		pCarne.add(lblFondoCarne);

		tabbedPane.addTab("Pescado", null, pPescado, null);
		pPescado.setLayout(null);

		JLabel lblFondoPescado = new JLabel();
		lblFondoPescado.setBounds(100, 0, 1100, 830);
		lblFondoPescado.setIcon(new ImageIcon("imagenes_supermercado/pescado.jpg")); 
		pPescado.add(lblFondoPescado);

		tabbedPane.addTab("Verdura", null, pVerdura, null);
		pVerdura.setLayout(null);

		JLabel lblFondoVerdura = new JLabel();
		lblFondoVerdura.setBounds(0, 0, 1100, 650);
		lblFondoVerdura.setIcon(new ImageIcon("imagenes_supermercado/verdura.jpg")); 
		pVerdura.add(lblFondoVerdura);

		tabbedPane.addTab("Fruta", null, pFruta, null);
		pFruta.setLayout(null);

		JLabel lblFondoFruta = new JLabel();
		lblFondoFruta.setBounds(0, 0, 1100, 600);
		lblFondoFruta.setIcon(new ImageIcon("imagenes_supermercado/fruta.jpg")); 
		pFruta.add(lblFondoFruta);

		tabbedPane.addTab("Bebidas", null, pBebidas, null);
		pBebidas.setLayout(null);

		JLabel lblFondoBebidas = new JLabel();
		lblFondoBebidas.setBounds(0, 0, 1100, 650);
		lblFondoBebidas.setIcon(new ImageIcon("imagenes_supermercado/bebidas.jpg")); 
		pBebidas.add(lblFondoBebidas);
		
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
		txFactura.setBounds(42, 31, 492, 529);
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
		
		btnPescado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		btnVerdura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		btnFruta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(4);
			}
		});
		btnBebidas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedIndex(5);
            }
        });
		btnVerFactura.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	txFactura.setText(nuevaFactura.mostrarListaCompra());
                tabbedPane.setSelectedIndex(6);
            }
        });
		btnVolverAInicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedIndex(0);
            }
        });
		btnVolver1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedIndex(0);
            }
        });
		
		btnVolver2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		
		btnVolverPescado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnVolverVerdura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnVolverFruta.addActionListener(new ActionListener() {
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
		btnAgua.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	double precio = 0.65;
                int numBotellas = Integer.parseInt(txKilogramos.getText());
                ProductoBebida pf = new ProductoBebida("Agua",precio,numBotellas);
                nuevaFactura.añadirProducto(pf);
            }
        });
		btnQuitarProducto.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				nuevaFactura.quitarProducto(txNombreProducto.getText());
				txFactura.setText(nuevaFactura.mostrarListaCompra());
			}
		});
		
	}
}
