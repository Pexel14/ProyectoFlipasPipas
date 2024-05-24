package com.dam.view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import com.dam.control.ProjectListener;
import com.dam.model.pojos.Tienda;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class PnlTienda extends JPanel {
	
	public static final String ACT_COM_BTN_OBJ1 = "Objeto1";
	public static final String ACT_COM_BTN_OBJ2 = "Objeto2";
	public static final String ACT_COM_BTN_OBJ3 = "Objeto3";
	public static final String ACT_COM_BTN_OBJ4 = "Objeto4";
	public static final String ACT_COM_BTN_OBJ5 = "Objeto5";
	public static final String ACT_COM_BTN_OBJ6 = "Objeto6";
	private JButton btnObj1;
	private JButton btnObj2;
	private JButton btnObj3;
	private JButton btnObj4;
	private JButton btnObj5;
	private JButton btnObj6;
	private JLabel lblCantPipas;
	private JButton btnImgPipa;
	private JLabel lblPrecioObj1;
	private JLabel lblPrecioObj2;
	private JLabel lblPrecioObj3;
	private JLabel lblPrecioObj4;
	private JLabel lblPrecioObj5;
	private JLabel lblPrecioObj6;
	
	public PnlTienda() {
		configurarComponentes();
		configurarFrame();
	}

	private void configurarComponentes() {
		setLayout(null);
		
		JLabel lblPipaCoins = new JLabel("Pipa Coins");
		lblPipaCoins.setForeground(new Color(240, 240, 240));
		lblPipaCoins.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblPipaCoins.setBounds(116, 111, 175, 50);
		add(lblPipaCoins);
		
		btnImgPipa = new JButton("");
		btnImgPipa.setEnabled(false);
		btnImgPipa.setBounds(410, 111, 50, 50);
		add(btnImgPipa);
		
		btnObj1 = new JButton(ACT_COM_BTN_OBJ1);
		btnObj1.setIcon(new ImageIcon(PnlTienda.class.getResource("/img/Imagen1Tienda.jpeg")));
		btnObj1.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnObj1.setBounds(116, 272, 267, 169);
		add(btnObj1);
		
		btnObj2 = new JButton(ACT_COM_BTN_OBJ2);
		btnObj2.setIcon(new ImageIcon(PnlTienda.class.getResource("/img/Imagen2Tienda.jpeg")));
		btnObj2.setVerticalAlignment(SwingConstants.BOTTOM);
		btnObj2.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnObj2.setBounds(507, 272, 267, 169);
		add(btnObj2);
		
		btnObj3 = new JButton(ACT_COM_BTN_OBJ3);
		btnObj3.setIcon(new ImageIcon(PnlTienda.class.getResource("/img/Imagen3Tienda.jpeg")));
		btnObj3.setVerticalAlignment(SwingConstants.BOTTOM);
		btnObj3.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnObj3.setBounds(898, 272, 267, 169);
		add(btnObj3);
		
		btnObj4 = new JButton(ACT_COM_BTN_OBJ4);
		btnObj4.setIcon(new ImageIcon(PnlTienda.class.getResource("/img/Imagen4Tienda.jpeg")));
		btnObj4.setVerticalAlignment(SwingConstants.BOTTOM);
		btnObj4.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnObj4.setBounds(116, 558, 267, 169);
		add(btnObj4);
		
		btnObj5 = new JButton(ACT_COM_BTN_OBJ5);
		btnObj5.setIcon(new ImageIcon(PnlTienda.class.getResource("/img/Imagen5Tienda.jpeg")));
		btnObj5.setVerticalAlignment(SwingConstants.BOTTOM);
		btnObj5.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnObj5.setBounds(507, 558, 267, 169);
		add(btnObj5);
		
		btnObj6 = new JButton(ACT_COM_BTN_OBJ6);
		btnObj6.setIcon(new ImageIcon(PnlTienda.class.getResource("/img/Imagen6Tienda.jpeg")));
		btnObj6.setVerticalAlignment(SwingConstants.BOTTOM);
		btnObj6.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnObj6.setBounds(898, 558, 267, 169);
		add(btnObj6);
		
		lblCantPipas = new JLabel("0");
		lblCantPipas.setForeground(UIManager.getColor("Button.background"));
		lblCantPipas.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblCantPipas.setBounds(285, 111, 115, 50);
		add(lblCantPipas);
		
		lblPrecioObj1 = new JLabel("");
		lblPrecioObj1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPrecioObj1.setForeground(new Color(255, 255, 255));
		lblPrecioObj1.setBounds(148, 458, 211, 23);
		add(lblPrecioObj1);
		
		lblPrecioObj2 = new JLabel("");
		lblPrecioObj2.setForeground(Color.WHITE);
		lblPrecioObj2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPrecioObj2.setBounds(539, 458, 211, 23);
		add(lblPrecioObj2);
		
		lblPrecioObj3 = new JLabel("");
		lblPrecioObj3.setForeground(Color.WHITE);
		lblPrecioObj3.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPrecioObj3.setBounds(930, 458, 211, 23);
		add(lblPrecioObj3);
		
		lblPrecioObj4 = new JLabel("");
		lblPrecioObj4.setForeground(Color.WHITE);
		lblPrecioObj4.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPrecioObj4.setBounds(148, 744, 211, 23);
		add(lblPrecioObj4);
		
		lblPrecioObj5 = new JLabel("");
		lblPrecioObj5.setForeground(Color.WHITE);
		lblPrecioObj5.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPrecioObj5.setBounds(539, 744, 211, 23);
		add(lblPrecioObj5);
		
		lblPrecioObj6 = new JLabel("");
		lblPrecioObj6.setForeground(Color.WHITE);
		lblPrecioObj6.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPrecioObj6.setBounds(930, 744, 211, 23);
		add(lblPrecioObj6);
	}
	
	public JButton getBtnObj1() {
		return btnObj1;
	}

	public JButton getBtnObj2() {
		return btnObj2;
	}

	public JButton getBtnObj3() {
		return btnObj3;
	}

	public JButton getBtnObj4() {
		return btnObj4;
	}

	public JButton getBtnObj5() {
		return btnObj5;
	}

	public JButton getBtnObj6() {
		return btnObj6;
	}

	private void configurarFrame() {
		setBackground(new Color(50, 50, 75));
		setSize(VMenu.ANCHO_PANEL, VMenu.ALTO_PANEL);
	}

	public void setListener(ProjectListener listener) {
		btnObj1.addActionListener(listener);
		btnObj2.addActionListener(listener);
		btnObj3.addActionListener(listener);
		btnObj4.addActionListener(listener);
		btnObj5.addActionListener(listener);
		btnObj6.addActionListener(listener);
	}

	public void cargarSaldo(int saldo) {
		lblCantPipas.setText(String.valueOf(saldo));
	}

	public void cargarObjetos(ArrayList<Tienda> cargarBotones) {
		btnObj1.setIcon(new ImageIcon(PnlTienda.class.getResource(cargarBotones.get(0).getImagen())));
		btnObj2.setIcon(new ImageIcon(PnlTienda.class.getResource(cargarBotones.get(1).getImagen())));
		btnObj3.setIcon(new ImageIcon(PnlTienda.class.getResource(cargarBotones.get(2).getImagen())));
		btnObj4.setIcon(new ImageIcon(PnlTienda.class.getResource(cargarBotones.get(3).getImagen())));
		btnObj5.setIcon(new ImageIcon(PnlTienda.class.getResource(cargarBotones.get(4).getImagen())));
		btnObj6.setIcon(new ImageIcon(PnlTienda.class.getResource(cargarBotones.get(5).getImagen())));
		
		if(cargarBotones.get(0).isComprada()) {
			btnObj1.setEnabled(false);
			lblPrecioObj1.setText("COMPRADO");
			
		} else {
			lblPrecioObj1.setText(cargarBotones.get(0).getPrecio() + " Pipa Coins");
		}
		
		if(cargarBotones.get(1).isComprada()) {
			btnObj2.setEnabled(false);
			lblPrecioObj2.setText("COMPRADO");
			
		} else {
			lblPrecioObj2.setText(cargarBotones.get(1).getPrecio() + " Pipa Coins");
		}
		
		if(cargarBotones.get(2).isComprada()) {
			btnObj3.setEnabled(false);
			lblPrecioObj3.setText("COMPRADO");
			
		} else {
			lblPrecioObj3.setText(cargarBotones.get(2).getPrecio() + " Pipa Coins");
		}
		
		if(cargarBotones.get(3).isComprada()) {
			btnObj4.setEnabled(false);
			lblPrecioObj4.setText("COMPRADO");
			
		} else {
			lblPrecioObj4.setText(cargarBotones.get(3).getPrecio() + " Pipa Coins");
		}
		
		if(cargarBotones.get(4).isComprada()) {
			btnObj5.setEnabled(false);
			lblPrecioObj5.setText("COMPRADO");
			
		} else {
			lblPrecioObj5.setText(cargarBotones.get(4).getPrecio() + " Pipa Coins");
		}
		
		if(cargarBotones.get(5).isComprada()) {
			btnObj6.setEnabled(false);
			lblPrecioObj6.setText("COMPRADO");
			
		} else {
			lblPrecioObj6.setText(cargarBotones.get(5).getPrecio() + " Pipa Coins");
		}
	}

	public int getSaldo() {
		return Integer.parseInt(lblCantPipas.getText());
	}
}
