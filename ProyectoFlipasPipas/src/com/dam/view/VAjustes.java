package com.dam.view;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JSlider;

import com.dam.control.ProjectListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;

public class VAjustes extends JFrame {
	
	public static final String ACT_CMD_BTN_BORRAR_CUENTA = "Borrar cuenta";
	
	private JSlider sldVolumen;
	private JButton btnBorrarCuenta;
	private JLabel lbl2;
	private JButton btnSalir;
	
	private static final int ANCHO = 465;
	private static final int ALTO = 475;
	
	public VAjustes() {
		
		frame();
		
		componentes();
	}

	private void frame() {
		getContentPane().setBackground(new Color(84, 84, 126));
		getContentPane().setLayout(null);
		setSize(ANCHO,ALTO);
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();                
		setLocation((pantalla.width - this.getSize().width) / 2, (pantalla.height - this.getSize().height) / 2);
	}

	public void hacerVisible() {
		setVisible(true);
	}
	
	private void componentes() {
		JLabel lblAjustes = new JLabel("Ajustes");
		lblAjustes.setForeground(Color.WHITE);
		lblAjustes.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblAjustes.setBounds(187, 50, 89, 43);
		getContentPane().add(lblAjustes);
		
		sldVolumen = new JSlider();
		sldVolumen.setBounds(132, 120, 200, 26);
		getContentPane().add(sldVolumen);
		
		btnBorrarCuenta = new JButton(ACT_CMD_BTN_BORRAR_CUENTA);
		btnBorrarCuenta.setForeground(Color.WHITE);
		btnBorrarCuenta.setBackground(Color.RED);
		btnBorrarCuenta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBorrarCuenta.setBounds(150, 204, 164, 35);
		getContentPane().add(btnBorrarCuenta);
		
		lbl2 = new JLabel("siguenos en: ");
		lbl2.setForeground(Color.WHITE);
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lbl2.setBounds(161, 273, 142, 43);
		getContentPane().add(lbl2);
		
		JLabel lblTwier = new JLabel("twiter: @FlipaPipas");
		lblTwier.setForeground(Color.WHITE);
		lblTwier.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTwier.setBounds(117, 334, 229, 43);
		getContentPane().add(lblTwier);
		
		JLabel lblInstagram = new JLabel("instagram: @FlipaPipas");
		lblInstagram.setForeground(Color.WHITE);
		lblInstagram.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblInstagram.setBounds(106, 382, 251, 43);
		getContentPane().add(lblInstagram);
		
		btnSalir = new JButton("x");
		btnSalir.setBounds(394, 10, 46, 43);
		getContentPane().add(btnSalir);
	}
	
	public JButton getBtnBorrarCuenta() {
		return btnBorrarCuenta;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setListener(ProjectListener listener) {
		btnSalir.addActionListener(listener);
		btnBorrarCuenta.addActionListener(listener);
	}
	
	public void setLisener(ProjectListener lissener) {
		btnBorrarCuenta.addActionListener(lissener);
		btnSalir.addActionListener(lissener);//TODO
	}
	
}
