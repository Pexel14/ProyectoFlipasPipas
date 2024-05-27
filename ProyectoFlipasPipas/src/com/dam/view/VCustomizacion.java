package com.dam.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.dam.control.ProjectListener;
import com.dam.model.pojos.Tienda;

import javax.swing.ImageIcon;

public class VCustomizacion extends JDialog {
	
	private static final int ANCHO = 500;
	private static final int ALTO = 550;
	public static final String ACT_COM_BTN_FP1 = "imagen1";
	public static final String ACT_COM_BTN_FP2 = "imagen2";
	public static final String ACT_COM_BTN_FP3 = "imagen3";
	public static final String ACT_COM_BTN_FP4 = "imagen4";
	public static final String ACT_COM_BTN_FP5 = "imagen5";
	public static final String ACT_COM_BTN_FP6 = "imagen6";
	
	private JTextField txtNombre;
	private JButton btnFP2;
	private JButton btnFP1;
	private JButton btnFP3;
	private JButton btnFP4;
	private JButton btnFP6;
	private JButton btnFP5;
	private JButton btnGuardar;
	private JButton btnSalir;
	
	private static VMenu vm;
	
	public VCustomizacion() {
		super(vm, "Customizacion", true);
		configurarFrame();
		
		configurarComponentes();
	}

	private void configurarFrame() {
		getContentPane().setBackground(new Color(100, 100, 125));
		setSize(ANCHO, ALTO);
		
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();                
		setLocation((pantalla.width - this.getSize().width) / 2, (pantalla.height - this.getSize().height) / 2);
	}
	
	public void hacerVisible() {
		setVisible(true);
	}
	
	private void configurarComponentes() {
		getContentPane().setLayout(null);
		
		JLabel lblCustomizacion = new JLabel("Customización");
		lblCustomizacion.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblCustomizacion.setForeground(new Color(255, 255, 255));
		lblCustomizacion.setBounds(175, 20, 150, 30);
		getContentPane().add(lblCustomizacion);
		
		JButton btnA1 = new JButton("");
		btnA1.setBackground(new Color(64, 64, 81));
		btnA1.setForeground(new Color(64, 64, 81));
		btnA1.setEnabled(false);
		btnA1.setBounds(48, 61, 408, 15);
		getContentPane().add(btnA1);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario:");
		lblNombreDeUsuario.setForeground(Color.WHITE);
		lblNombreDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNombreDeUsuario.setBounds(58, 87, 212, 30);
		getContentPane().add(lblNombreDeUsuario);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombre.setBounds(58, 128, 334, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JButton btnA2 = new JButton("");
		btnA2.setForeground(new Color(64, 64, 81));
		btnA2.setEnabled(false);
		btnA2.setBackground(new Color(64, 64, 81));
		btnA2.setBounds(48, 179, 408, 15);
		getContentPane().add(btnA2);
		
		JLabel lblFotoDePerfil = new JLabel("Foto de Perfil:");
		lblFotoDePerfil.setForeground(Color.WHITE);
		lblFotoDePerfil.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblFotoDePerfil.setBounds(58, 209, 150, 30);
		getContentPane().add(lblFotoDePerfil);
		
		btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(VCustomizacion.class.getResource("/img/salir.png")));
		btnSalir.setBorderPainted(false);
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBounds(401, 11, 50, 50);
		getContentPane().add(btnSalir);
		
		btnFP1 = new JButton(ACT_COM_BTN_FP1);
		btnFP1.setIcon(new ImageIcon(VCustomizacion.class.getResource("/img/Imagen1CustomButton.png")));
		btnFP1.setBounds(54, 260, 89, 76);
		getContentPane().add(btnFP1);

		btnFP2 = new JButton(ACT_COM_BTN_FP2);
		btnFP2.setIcon(new ImageIcon(VCustomizacion.class.getResource("/img/Imagen2CustomButton.png")));
		btnFP2.setBounds(54, 355, 89, 76);
		getContentPane().add(btnFP2);
		
		btnFP3 = new JButton(ACT_COM_BTN_FP3);
		btnFP3.setIcon(new ImageIcon(VCustomizacion.class.getResource("/img/Imagen3CustomButton.png")));
		btnFP3.setBounds(202, 260, 89, 76);
		getContentPane().add(btnFP3);

		btnFP4 = new JButton(ACT_COM_BTN_FP4);
		btnFP4.setIcon(new ImageIcon(VCustomizacion.class.getResource("/img/Imagen4CustomButton.png")));
		btnFP4.setBounds(202, 355, 89, 76);
		getContentPane().add(btnFP4);
		
		btnFP5 = new JButton(ACT_COM_BTN_FP5);
		btnFP5.setIcon(new ImageIcon(VCustomizacion.class.getResource("/img/Imagen5CustomButton.png")));
		btnFP5.setBounds(350, 260, 89, 76);
		getContentPane().add(btnFP5);
		
		btnFP6 = new JButton(ACT_COM_BTN_FP6);
		btnFP6.setIcon(new ImageIcon(VCustomizacion.class.getResource("/img/Imagen6CustomButton.png")));
		btnFP6.setBounds(350, 355, 89, 76);
		getContentPane().add(btnFP6);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(351, 457, 105, 30);
		getContentPane().add(btnGuardar);
		
	}
	
	
	public JButton getBtnSalir() {
		return btnSalir;
	}
	
	public JButton getBtnFP2() {
		return btnFP2;
	}

	public JButton getBtnFP1() {
		return btnFP1;
	}
	
	public JButton getBtnFP3() {
		return btnFP3;
	}

	public JButton getBtnFP4() {
		return btnFP4;
	}

	public JButton getBtnFP6() {
		return btnFP6;
	}

	public JButton getBtnFP5() {
		return btnFP5;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}
	
	public JTextField getTxtNombre() {
		return txtNombre;
	}
	
	public String getTxtFP1() {
		return "/img/Imagen1FotoPerfil.jpeg";
	}
	
	public String getTxtFP2() {
		return "/img/Imagen2FotoPerfil.jpeg";
	}
	
	public String getTxtFP3() {
		return "/img/Imagen3FotoPerfil.jpeg";
	}
	
	public String getTxtFP4() {
		return "/img/Imagen4FotoPerfil.jpeg";
	}
	
	public String getTxtFP5() {
		return "/img/Imagen5FotoPerfil.jpeg";
	}
	
	public String getTxtFP6() {
		return "/img/Imagen6FotoPerfil.jpeg";
	}
	
	public void setListener(ProjectListener listener) {
		btnSalir.addActionListener(listener);
		btnGuardar.addActionListener(listener);
		btnFP1.addActionListener(listener);
		btnFP2.addActionListener(listener);
		btnFP3.addActionListener(listener);
		btnFP4.addActionListener(listener);
		btnFP5.addActionListener(listener);
		btnFP6.addActionListener(listener);
		
	}

	public void cargarObjetos(ArrayList<Tienda> cargarBotones) {
		if(cargarBotones.get(0).isComprada()) {
			btnFP1.setEnabled(true);
			
		} else {
			btnFP1.setEnabled(false);
		}
		
		if(cargarBotones.get(1).isComprada()) {
			btnFP2.setEnabled(true);
			
		} else {
			btnFP2.setEnabled(false);
		}
		
		if(cargarBotones.get(2).isComprada()) {
			btnFP3.setEnabled(true);
			
		} else {
			btnFP3.setEnabled(false);
		}
		
		if(cargarBotones.get(3).isComprada()) {
			btnFP4.setEnabled(true);
			
		} else {
			btnFP4.setEnabled(false);
		}
		
		if(cargarBotones.get(4).isComprada()) {
			btnFP5.setEnabled(true);
			
		} else {
			btnFP5.setEnabled(false);
		}
		
		if(cargarBotones.get(5).isComprada()) {
			btnFP6.setEnabled(true);
			
		} else {
			btnFP6.setEnabled(false);
		}
	}
	
}
