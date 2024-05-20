package main;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import org.apache.commons.codec.digest.DigestUtils;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import items.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JLayeredPane;
import java.awt.Font;


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
	private JPanel pUsuarios;
	private JTextField txUsuario;
	private JTextField txPassword;
	private JButton btnAgregarUsuario;
	private JButton btnBorrarUsuario;
	private JButton btnUsuarios;
	private JTextPane txPUsers;
	private JCheckBox chckbxDescuentoFamilia;
	private JCheckBox chckbxDescuentoTarjeta;
	private JButton btnPavo;
	private JButton btnEmperador;
	private JButton btnSalmon;
	private JButton btnMerluza;
	private JButton btnSandia;
	private JButton btnCoca;
	private JButton btnBrocoli;
	private JButton btnZanahorias;
	private JButton btnPimientos;
	private JButton btnPlatano;
	private JButton btnMandarinas;
	private JButton btnZumo;
	private JTextField txKilogramosPescado;
	private JTextField txKilogramosVerdura;
	private JTextField txKilogramosFruta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		String fileName = "fichero/contraseñas.txt";

		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			String[][] usuariosYContraseñas = new String[4][2]; 

			int index = 0;
			while ((line = bufferedReader.readLine()) != null) {

				String[] parts = line.split(","); 
				usuariosYContraseñas[index][0] = parts[0]; 
				usuariosYContraseñas[index][1] = parts[1]; 
				index++;
			}

			bufferedReader.close();

			String usuarioIngresado = JOptionPane.showInputDialog(null, "Ingrese su usuario:");


			JPasswordField passwordField = new JPasswordField();
			passwordField.setEchoChar('*');


			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(2, 2));
			panel.add(new JLabel("Ingrese su contraseña:"));
			panel.add(passwordField);


			int option = JOptionPane.showConfirmDialog(null, panel, "Autenticación", JOptionPane.OK_CANCEL_OPTION);

			if (option == JOptionPane.OK_OPTION) {
				char[] passwordChars = passwordField.getPassword();
				String contraseñaIngresada = new String(passwordChars);
				contraseñaIngresada = DigestUtils.sha256Hex(contraseñaIngresada);

				boolean credencialesCorrectas = false;

				for (String[] usuarioYContraseña : usuariosYContraseñas) {
					String usuarioGuardado = usuarioYContraseña[0];
					String contraseñaGuardada = usuarioYContraseña[1];
					if (usuarioIngresado != null && contraseñaIngresada != null &&
							usuarioIngresado.equals(usuarioGuardado) && contraseñaIngresada.equals(contraseñaGuardada)) {
						credencialesCorrectas = true;
						break;
					}
				}

				if (credencialesCorrectas) {
					EventQueue.invokeLater(() -> {
						try {
							Supermercado frame = new Supermercado();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					});
				} else {
					JOptionPane.showMessageDialog(null, "Credenciales incorrectas. El programa se cerrará.");
					System.exit(0);
				}
			} else {
				System.exit(0);
			}

		} catch (IOException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
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
		setBounds(200, 30, 1000, 960);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		tabbedPane.setEnabled(false);
		tabbedPane.setBounds(0, 0, 1000, 960);
		contentPane.add(tabbedPane);

		JPanel Inicio = new JPanel();
		tabbedPane.addTab("Inicio", null, Inicio, null);
		Inicio.setLayout(null);

		btnCarne = new JButton("");
		btnCarne.setIcon(new ImageIcon("imagenes_supermercado/FILETE.jpg"));
		btnCarne.setBounds(118, 125, 130, 100);
		Inicio.add(btnCarne);

		btnPescado = new JButton("");
		btnPescado.setIcon(new ImageIcon("imagenes_supermercado/pez.jpg"));
		btnPescado.setBounds(260, 125, 130, 100);
		Inicio.add(btnPescado);

		btnVerdura = new JButton("");
		btnVerdura.setIcon(new ImageIcon("imagenes_supermercado/multiverdura.jpg"));
		btnVerdura.setBounds(402, 125, 130, 100);
		Inicio.add(btnVerdura);

		btnFruta = new JButton("");
		btnFruta.setIcon(new ImageIcon("imagenes_supermercado/multifruta.jpg"));
		btnFruta.setBounds(544, 125, 130, 100);
		Inicio.add(btnFruta);

		btnBebidas = new JButton("");
		btnBebidas.setIcon(new ImageIcon("imagenes_supermercado/multibebida.jpg"));
		btnBebidas.setBounds(686, 125, 130, 100);
		Inicio.add(btnBebidas);

		btnVerFactura = new JButton("Ver factura");
		btnVerFactura.setBounds(273, 332, 117, 25);
		Inicio.add(btnVerFactura);
		
		JLabel lblCarne = new JLabel("Carne");
		lblCarne.setBounds(169, 236, 38, 25);
		Inicio.add(lblCarne);
		
		JLabel lblPescado = new JLabel("Pescado");
		lblPescado.setBounds(305, 242, 54, 15);
		Inicio.add(lblPescado);
		
		JLabel lblFruta = new JLabel("Fruta");
		lblFruta.setBounds(455, 242, 38, 15);
		Inicio.add(lblFruta);
		
		JLabel lblVerdura = new JLabel("Verdura");
		lblVerdura.setBounds(591, 242, 54, 15);
		Inicio.add(lblVerdura);
		
		JLabel lblBebida = new JLabel("Bebida");
		lblBebida.setBounds(740, 242, 54, 15);
		Inicio.add(lblBebida);
		
		btnUsuarios = new JButton("Usuarios");
		btnUsuarios.setBounds(544, 332, 117, 25);
		Inicio.add(btnUsuarios);

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
		
		pBebidas = new JPanel();
		tabbedPane.addTab("Bebidas", null, pBebidas, null);
		pBebidas.setLayout(null);

		txKilogramos = new JTextField();
		txKilogramos.setBounds(846, 373, 70, 19);
		pCarne.add(txKilogramos);
		txKilogramos.setColumns(10);
		
		txKilogramosPescado = new JTextField();
		txKilogramosPescado.setBounds(846, 373, 70, 19);
		pPescado.add(txKilogramosPescado);
		txKilogramosPescado.setColumns(10);
		
		txKilogramosVerdura = new JTextField();
		txKilogramosVerdura.setBounds(846, 373, 70, 19);
		pVerdura.add(txKilogramosVerdura);
		txKilogramosVerdura.setColumns(10);
		
		txKilogramosFruta = new JTextField();
		txKilogramosFruta.setBounds(846, 373, 70, 19);
		pFruta.add(txKilogramosFruta);
		txKilogramosFruta.setColumns(10);

		JLabel lblKg = new JLabel("Kg");
		lblKg.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblKg.setBounds(926, 375, 29, 17);
		pCarne.add(lblKg);
		JLabel lblKg2 = new JLabel("Kg");
		lblKg2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblKg2.setBounds(926, 375, 29, 17);
		pPescado.add(lblKg2);
		JLabel lblKg3 = new JLabel("Kg");
		lblKg3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblKg3.setBounds(926, 375, 29, 17);
		pVerdura.add(lblKg3);
		JLabel lblKg4 = new JLabel("Kg");
		lblKg4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblKg4.setBounds(926, 375, 29, 17);
		pFruta.add(lblKg4);
		

		btnTernera= new JButton("");
		btnTernera.setIcon(new ImageIcon("imagenes_supermercado/ternera.jpg"));
		btnTernera.setBounds(284, 184, 130, 100);
		pCarne.add(btnTernera);

		btnPollo = new JButton("");
		btnPollo.setIcon(new ImageIcon("imagenes_supermercado/pollobt.jpg"));
		btnPollo.setBounds(284, 425, 130, 100);
		pCarne.add(btnPollo);
		
		btnPavo = new JButton("");
		btnPavo.setIcon(new ImageIcon("imagenes_supermercado/pavo.jpeg"));
		btnPavo.setBounds(284, 647, 130, 100);
		pCarne.add(btnPavo);
		
		btnEmperador = new JButton("");
		btnEmperador.setIcon(new ImageIcon("imagenes_supermercado/emperador.jpg"));
		btnEmperador.setBounds(284, 184, 130, 100);
		pPescado.add(btnEmperador);

		
		btnSalmon = new JButton("");
		btnSalmon.setIcon(new ImageIcon("imagenes_supermercado/salmon.jpg"));
		btnSalmon.setBounds(284, 425, 130, 100);
		pPescado.add(btnSalmon);
		
		btnMerluza = new JButton("");
		btnMerluza.setIcon(new ImageIcon("imagenes_supermercado/merluza.jpg"));
		btnMerluza.setBounds(284, 647, 130, 100);
		pPescado.add(btnMerluza);
		
		btnSandia = new JButton("");
		btnSandia.setIcon(new ImageIcon("imagenes_supermercado/sandia.jpg"));
		btnSandia.setBounds(284, 184, 130, 100);
		pFruta.add(btnSandia);
		
		btnPlatano = new JButton("");
		btnPlatano.setIcon(new ImageIcon("imagenes_supermercado/platanos.jpg"));
		btnPlatano.setBounds(284, 425, 130, 100);
		pFruta.add(btnPlatano);
		
		btnMandarinas = new JButton("");
		btnMandarinas.setIcon(new ImageIcon("imagenes_supermercado/mandarinas.jpg"));
		btnMandarinas.setBounds(284, 647, 130, 100);
		pFruta.add(btnMandarinas);
		
		btnZanahorias = new JButton("");
		btnZanahorias.setIcon(new ImageIcon("imagenes_supermercado/zanahorias.png"));
		btnZanahorias.setBounds(284, 184, 130, 100);
		pVerdura.add(btnZanahorias);
		
		btnPimientos = new JButton("");
		btnPimientos.setIcon(new ImageIcon("imagenes_supermercado/pimientos.jpg"));
		btnPimientos.setBounds(284, 425, 130, 100);
		pVerdura.add(btnPimientos);
		
		btnBrocoli = new JButton("");
		btnBrocoli.setIcon(new ImageIcon("imagenes_supermercado/brocoli.jpeg"));
		btnBrocoli.setBounds(284, 647, 130, 100);
		pVerdura.add(btnBrocoli);
		
		
		btnAgua = new JButton("");
		btnAgua.setIcon(new ImageIcon("imagenes_supermercado/agua.jpg"));
		btnAgua.setBounds(284, 184, 130, 100);
		pBebidas.add(btnAgua);
		
		btnCoca = new JButton("");
		btnCoca.setIcon(new ImageIcon("imagenes_supermercado/cocacola.jpg"));
		btnCoca.setBounds(284, 425, 130, 100);
		pBebidas.add(btnCoca);
		
		btnZumo = new JButton("");
		btnZumo.setIcon(new ImageIcon("imagenes_supermercado/zumo.jpg"));
		btnZumo.setBounds(284, 647, 130, 100);
		pBebidas.add(btnZumo);
		
		btnVolver1 = new JButton("Volver");
		btnVolver1.setBounds(846, 425, 100, 25);
		pCarne.add(btnVolver1);

		btnVolverPescado = new JButton("Volver");
		btnVolverPescado.setBounds(846, 425, 100, 25);
		pPescado.add(btnVolverPescado);

		btnVolverVerdura = new JButton("Volver");
		btnVolverVerdura.setBounds(846, 425, 100, 25);
		pVerdura.add(btnVolverVerdura);

		btnVolverFruta = new JButton("Volver");
		btnVolverFruta.setBounds(846, 425, 100, 25);
		pFruta.add(btnVolverFruta);

		btnVolver2 = new JButton("Volver");
		btnVolver2.setBounds(846, 425, 100, 25);
		pBebidas.add(btnVolver2);

		txNumBotellas = new JTextField();
		txNumBotellas.setBounds(846, 395, 67, 19);
		pBebidas.add(txNumBotellas);
		txNumBotellas.setColumns(10);

		lblNumeroDeBotellas = new JLabel("Número de botellas");
		lblNumeroDeBotellas.setBounds(837, 365, 114, 19);
		pBebidas.add(lblNumeroDeBotellas);

		//FOTOS
		tabbedPane.addTab("Carne", null, pCarne, null);
		pCarne.setLayout(null);

		JLabel lblFondoCarne = new JLabel();
		lblFondoCarne.setBounds(12, 12, 948, 1000);
		lblFondoCarne.setIcon(new ImageIcon("imagenes_supermercado/estanteria.jpg")); 
		pCarne.add(lblFondoCarne);

		tabbedPane.addTab("Pescado", null, pPescado, null);
		pPescado.setLayout(null);

		JLabel lblFondoPescado = new JLabel();
		lblFondoPescado.setBounds(12, 12, 948, 1000);
		lblFondoPescado.setIcon(new ImageIcon("imagenes_supermercado/estanteria.jpg")); 
		pPescado.add(lblFondoPescado);

		tabbedPane.addTab("Verdura", null, pVerdura, null);
		pVerdura.setLayout(null);

		JLabel lblFondoVerdura = new JLabel();
		lblFondoVerdura.setBounds(12, 12, 948, 1000);
		lblFondoVerdura.setIcon(new ImageIcon("imagenes_supermercado/estanteria.jpg")); 
		pVerdura.add(lblFondoVerdura);

		tabbedPane.addTab("Fruta", null, pFruta, null);
		pFruta.setLayout(null);

		JLabel lblFondoFruta = new JLabel();
		lblFondoFruta.setBounds(12, 12, 948, 1000);
		lblFondoFruta.setIcon(new ImageIcon("imagenes_supermercado/estanteria.jpg")); 
		pFruta.add(lblFondoFruta);

		tabbedPane.addTab("Bebidas", null, pBebidas, null);
		pBebidas.setLayout(null);

		JLabel lblFondoBebidas = new JLabel();
		lblFondoBebidas.setBounds(12, 12, 948, 1000);
		lblFondoBebidas.setIcon(new ImageIcon("imagenes_supermercado/estanteria.jpg")); 
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
		
		pUsuarios = new JPanel();
		tabbedPane.addTab("Usuarios", null, pUsuarios, null);
		tabbedPane.setEnabledAt(7, false);
		pUsuarios.setLayout(null);
		
		btnAgregarUsuario = new JButton("Agregar usuario");
		btnAgregarUsuario.setBounds(652, 99, 149, 25);
		pUsuarios.add(btnAgregarUsuario);
		
		btnBorrarUsuario = new JButton("Borrar usuario");
		btnBorrarUsuario.setBounds(652, 201, 149, 25);
		pUsuarios.add(btnBorrarUsuario);
		
		txUsuario = new JTextField();
		txUsuario.setBounds(471, 102, 114, 19);
		pUsuarios.add(txUsuario);
		txUsuario.setColumns(10);
		
		txPassword = new JTextField();
		txPassword.setBounds(471, 176, 114, 19);
		pUsuarios.add(txPassword);
		txPassword.setColumns(10);
		
		txPUsers = new JTextPane();
		txPUsers.setEditable(false);
		txPUsers.setBounds(44, 38, 312, 375);
		pUsuarios.add(txPUsers);
		
		chckbxDescuentoFamilia = new JCheckBox("Familia numerosa");
		chckbxDescuentoFamilia.setBounds(591, 304, 164, 23);
		pFactura.add(chckbxDescuentoFamilia);
		
		chckbxDescuentoTarjeta = new JCheckBox("Tarjeta Super");
		chckbxDescuentoTarjeta.setBounds(781, 304, 129, 23);
		pFactura.add(chckbxDescuentoTarjeta);

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
		btnFruta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		btnVerdura.addActionListener(new ActionListener() {
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
				String fileName = "data/salida.txt";
				try {
					BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
					String input = nuevaFactura.mostrarListaCompra();
					bufferedWriter.write(input);
					bufferedWriter.close();

					System.out.println("Las cadenas han sido escritas en el archivo '" + fileName + "'.");
				} catch (IOException excp) {
					System.out.println("Error al escribir en el archivo: " + excp.getMessage());
				}
			}
		});
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileName = "fichero/contraseñas.txt";
				String listaUsuarios="";

		        try {
		            FileReader fileReader = new FileReader(fileName);
		            BufferedReader bufferedReader = new BufferedReader(fileReader);
		            String linea = bufferedReader.readLine();
		            while (linea != null) {
		            	String[] parts = linea.split(",");
		                listaUsuarios+=parts[0]+"\n";
		                linea = bufferedReader.readLine();
		            }

		            bufferedReader.close();
		        } catch (IOException excp) {
		            System.out.println("Error al leer el archivo: " + excp.getMessage());
		        }
		        txPUsers.setText(listaUsuarios);
				tabbedPane.setSelectedIndex(7);
			}
		});
		btnAgregarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileName = "fichero/contraseñas.txt";
				try {
					BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true));
					bufferedWriter.newLine();
					String contraseña = DigestUtils.sha256Hex(txPassword.getText());
					String input = txUsuario.getText()+","+contraseña;
					bufferedWriter.write(input);
					bufferedWriter.close();

					System.out.println("Las cadenas han sido escritas en el archivo '" + fileName + "'.");
				} catch (IOException excp) {
					System.out.println("Error al escribir en el archivo: " + excp.getMessage());
				}
				JOptionPane.showMessageDialog(null, "Usuario añadido");
				txUsuario.setText("");
				txPassword.setText("");
				btnUsuarios.doClick();
			}
		});
		btnBorrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileName = "fichero/contraseñas.txt";
				String listaUsuarios="";
				String usuarioB =txUsuario.getText();
				int contador = 0;

		        try {
		            FileReader fileReader = new FileReader(fileName);
		            BufferedReader bufferedReader = new BufferedReader(fileReader);
		            String linea = bufferedReader.readLine();
		            while (linea != null) {
		            	String[] parts = linea.split(",");
		            	if(!parts[0].equals(usuarioB)) {
		            		if(contador==0) {
		            			listaUsuarios+=linea;
		            			contador++;
		            		}else {
		            			listaUsuarios+="\n"+linea;
		            		}
		            		
		            	}
		            	linea = bufferedReader.readLine();
		            }
		            bufferedReader.close();
		        } catch (IOException excp) {
		            System.out.println("Error al leer el archivo: " + excp.getMessage());
		        }
		        try {
					BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
					String input = listaUsuarios;
					bufferedWriter.write(input);
					bufferedWriter.close();

					System.out.println("Las cadenas han sido escritas en el archivo '" + fileName + "'.");
				} catch (IOException excp) {
					System.out.println("Error al escribir en el archivo: " + excp.getMessage());
				}
		        JOptionPane.showMessageDialog(null, "Usuario borrado");
				txUsuario.setText("");
		        btnUsuarios.doClick();
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
		
		btnFinalizarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Gracias por su compra");
				System.exit(0);
			}
		});

		btnTernera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double precio = 10.49;
				double peso = Double.parseDouble(txKilogramos.getText());
				ProductoFresco pf = new ProductoFresco("Ternera",precio,peso);
				nuevaFactura.añadirProducto(pf);
				JOptionPane.showMessageDialog(null, "Producto añadido");
				txKilogramos.setText("");
			}
		});
		btnPollo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double precio = 8.75;
				double peso = Double.parseDouble(txKilogramos.getText());
				ProductoFresco pf = new ProductoFresco("Pollo",precio,peso);
				nuevaFactura.añadirProducto(pf);
				JOptionPane.showMessageDialog(null, "Producto añadido");
				txKilogramos.setText("");
			}
		});
		
		btnPavo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double precio = 6.5;
				double peso = Double.parseDouble(txKilogramos.getText());
				ProductoFresco pf = new ProductoFresco("Pavo",precio,peso);
				nuevaFactura.añadirProducto(pf);
				JOptionPane.showMessageDialog(null, "Producto añadido");
				txKilogramos.setText("");
			}
		});
		
		btnEmperador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double precio = 14.49;
				double peso = Double.parseDouble(txKilogramosPescado.getText());
				ProductoFresco pf = new ProductoFresco("Emperador",precio,peso);
				nuevaFactura.añadirProducto(pf);
				JOptionPane.showMessageDialog(null, "Producto añadido");
				txKilogramosPescado.setText("");
			}
		});
		
		btnSalmon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double precio = 12.33;
				double peso = Double.parseDouble(txKilogramosPescado.getText());
				ProductoFresco pf = new ProductoFresco("Salmón",precio,peso);
				nuevaFactura.añadirProducto(pf);
				JOptionPane.showMessageDialog(null, "Producto añadido");
				txKilogramosPescado.setText("");
			}
		});
		
		btnMerluza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double precio = 8.78;
				double peso = Double.parseDouble(txKilogramosPescado.getText());
				ProductoFresco pf = new ProductoFresco("Merluza",precio,peso);
				nuevaFactura.añadirProducto(pf);
				JOptionPane.showMessageDialog(null, "Producto añadido");
				txKilogramosPescado.setText("");
			}
		});
		
		btnBrocoli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double precio = 2.78;
				double peso = Double.parseDouble(txKilogramosVerdura.getText());
				ProductoFresco pf = new ProductoFresco("Brocoli",precio,peso);
				nuevaFactura.añadirProducto(pf);
				JOptionPane.showMessageDialog(null, "Producto añadido");
				txKilogramosVerdura.setText("");
			}
		});
		
		btnPimientos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double precio = 1.56;
				double peso = Double.parseDouble(txKilogramosVerdura.getText());
				ProductoFresco pf = new ProductoFresco("Pimientos",precio,peso);
				nuevaFactura.añadirProducto(pf);
				JOptionPane.showMessageDialog(null, "Producto añadido");
				txKilogramosVerdura.setText("");
			}
		});
		
		btnZanahorias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double precio = 2.1;
				double peso = Double.parseDouble(txKilogramosVerdura.getText());
				ProductoFresco pf = new ProductoFresco("Zanahorias",precio,peso);
				nuevaFactura.añadirProducto(pf);
				JOptionPane.showMessageDialog(null, "Producto añadido");
				txKilogramosVerdura.setText("");
			}
		});
		
		btnMandarinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double precio = 3.25;
				double peso = Double.parseDouble(txKilogramosFruta.getText());
				ProductoFresco pf = new ProductoFresco("Mandarinas",precio,peso);
				nuevaFactura.añadirProducto(pf);
				JOptionPane.showMessageDialog(null, "Producto añadido");
				txKilogramosFruta.setText("");
			}
		});
		
		btnSandia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double precio = 4.3;
				double peso = Double.parseDouble(txKilogramosFruta.getText());
				ProductoFresco pf = new ProductoFresco("Sandía",precio,peso);
				nuevaFactura.añadirProducto(pf);
				JOptionPane.showMessageDialog(null, "Producto añadido");
				txKilogramosFruta.setText("");
			}
		});
		
		btnPlatano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double precio = 2.2;
				double peso = Double.parseDouble(txKilogramosFruta.getText());
				ProductoFresco pf = new ProductoFresco("Plátanos",precio,peso);
				nuevaFactura.añadirProducto(pf);
				JOptionPane.showMessageDialog(null, "Producto añadido");
				txKilogramosFruta.setText("");
			}
		});
		
		btnAgua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double precio = 0.65;
				int numBotellas = Integer.parseInt(txNumBotellas.getText());
				ProductoBebida pf = new ProductoBebida("Agua",precio,numBotellas);
				nuevaFactura.añadirProducto(pf);
				JOptionPane.showMessageDialog(null, "Producto añadido");
				txNumBotellas.setText("");
			}
		});
		
		btnCoca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double precio = 0.8;
				int numBotellas = Integer.parseInt(txNumBotellas.getText());
				ProductoBebida pf = new ProductoBebida("Coca-Cola",precio,numBotellas);
				nuevaFactura.añadirProducto(pf);
				JOptionPane.showMessageDialog(null, "Producto añadido");
				txNumBotellas.setText("");
			}
		});
		
		btnZumo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double precio = 0.75;
				int numBotellas = Integer.parseInt(txNumBotellas.getText());
				ProductoBebida pf = new ProductoBebida("Zumo",precio,numBotellas);
				nuevaFactura.añadirProducto(pf);
				JOptionPane.showMessageDialog(null, "Producto añadido");
				txNumBotellas.setText("");
			}
		});
		btnQuitarProducto.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				nuevaFactura.quitarProducto(txNombreProducto.getText());
				txFactura.setText(nuevaFactura.mostrarListaCompra());
			}
		});
		
		chckbxDescuentoFamilia.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	boolean seleccionado = chckbxDescuentoFamilia.isSelected();
	        	nuevaFactura.setDescuentoFamilia(seleccionado);
	        	btnVerFactura.doClick();
	        }
	    });

		chckbxDescuentoTarjeta.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	boolean seleccionado = chckbxDescuentoTarjeta.isSelected();
	        	nuevaFactura.setDescuentoTarjeta(seleccionado);
	        	btnVerFactura.doClick();
	        }
	    });

	}
}
