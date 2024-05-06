package com.dam.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.Color;

public class PAjustes extends JPanel {
	
	public static final String ACT_CMD_BTN_BORRAR_CUENTA = "Borrar cuenta";
	
	private JSlider sldVolumen;
	private JButton btnBorrarCuenta;
	private JLabel lbl2;
	private JButton btnSalir;
	
	private static final int ANCHO = 465;
	private static final int ALTO = 475;
	
	public PAjustes() {
		
		setBackground(new Color(84, 84, 126));
		setLayout(null);
		setSize(ANCHO,ALTO);
		
		componentes();
		
		
		
	}

	private void componentes() {
		JLabel lblAjustes = new JLabel("Ajustes");
		lblAjustes.setForeground(Color.WHITE);
		lblAjustes.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblAjustes.setBounds(187, 50, 89, 43);
		add(lblAjustes);
		
		sldVolumen = new JSlider();
		sldVolumen.setBounds(132, 120, 200, 26);
		add(sldVolumen);
		
		btnBorrarCuenta = new JButton(ACT_CMD_BTN_BORRAR_CUENTA);
		btnBorrarCuenta.setForeground(Color.WHITE);
		btnBorrarCuenta.setBackground(Color.RED);
		btnBorrarCuenta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBorrarCuenta.setBounds(150, 204, 164, 35);
		add(btnBorrarCuenta);
		
		lbl2 = new JLabel("siguenos en: ");
		lbl2.setForeground(Color.WHITE);
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lbl2.setBounds(161, 273, 142, 43);
		add(lbl2);
		
		JLabel lblTwier = new JLabel("twiter: @FlipaPipas");
		lblTwier.setForeground(Color.WHITE);
		lblTwier.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTwier.setBounds(117, 334, 229, 43);
		add(lblTwier);
		
		JLabel lblInstagram = new JLabel("instagram: @FlipaPipas");
		lblInstagram.setForeground(Color.WHITE);
		lblInstagram.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblInstagram.setBounds(106, 382, 251, 43);
		add(lblInstagram);
		
		btnSalir = new JButton("x");
		btnSalir.setBounds(394, 10, 46, 43);
		add(btnSalir);
	}
	
//	public void setLisener(Lissener l) {
		// TODO
//		btnBorrarCuenta.addActionListener(l);
//	}
	
}
