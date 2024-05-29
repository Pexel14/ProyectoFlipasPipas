package com.dam.view;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JSlider;
import javax.swing.RootPaneContainer;

import com.dam.control.ProjectListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class VAjustes extends JDialog {
	
	public static final String ACT_CMD_BTN_BORRAR_CUENTA = "Borrar cuenta";
	private JButton btnBorrarCuenta;
	private JLabel lbl2;
	private JButton btnSalir;
	
	private static final int ANCHO = 465;
	private static final int ALTO = 475;
	
	private static VMenu vm;
	
	public VAjustes() {
		
		super(vm, "Configuración", true); // ROBERTO : Lo he puesto aquí porque sino da error

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
		lblAjustes.setHorizontalAlignment(SwingConstants.CENTER);
		lblAjustes.setForeground(Color.WHITE);
		lblAjustes.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblAjustes.setBounds(148, 50, 155, 55);
		getContentPane().add(lblAjustes);
		
		btnBorrarCuenta = new JButton(ACT_CMD_BTN_BORRAR_CUENTA);
		btnBorrarCuenta.setForeground(Color.WHITE);
		btnBorrarCuenta.setBackground(Color.RED);
		btnBorrarCuenta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBorrarCuenta.setBounds(125, 155, 200, 75);
		getContentPane().add(btnBorrarCuenta);
		
		lbl2 = new JLabel("Siguenos en: ");
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setForeground(Color.WHITE);
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lbl2.setBounds(133, 260, 185, 40);
		getContentPane().add(lbl2);
		
		JLabel lblTwier = new JLabel("Twitter: @FlipaPipas");
		lblTwier.setHorizontalAlignment(SwingConstants.CENTER);
		lblTwier.setForeground(Color.WHITE);
		lblTwier.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTwier.setBounds(130, 320, 190, 30);
		getContentPane().add(lblTwier);
		
		JLabel lblInstagram = new JLabel("Instagram: @FlipaPipas");
		lblInstagram.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstagram.setForeground(Color.WHITE);
		lblInstagram.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInstagram.setBounds(115, 370, 220, 30);
		getContentPane().add(lblInstagram);
		
		btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(VAjustes.class.getResource("/img/salir.png")));
		btnSalir.setBorderPainted(false);
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBounds(394, 10, 50, 50);
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
