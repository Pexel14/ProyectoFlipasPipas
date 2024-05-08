package com.dam.view;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import java.awt.Font;
import javax.swing.JLabel;

public class PnlLeciones extends JPanel {
	
	private JButton btnLec_1;
	private JButton btnLec_3;
	private JButton btnLec_2;
	private JButton btnLec_4;
	private JButton btnTetx_1;
	private JButton btnTetx_2;


	public PnlLeciones() {
		setSize(VPrincipal.ANCHO_PANEL, VPrincipal.ALTO_PANEL); //Para que no ocurran errores
		setBackground(new Color(50,50,75));
		componentes();
	}


	private void componentes() {
		setLayout(null);
		
		btnLec_1 = new JButton("1");
		btnLec_1.setFont(new Font("Tahoma", Font.PLAIN, 75));
		btnLec_1.setBounds(44, 488, 111, 111);
		add(btnLec_1);
		
		btnLec_2 = new JButton("2");
		btnLec_2.setFont(new Font("Tahoma", Font.PLAIN, 75));
		btnLec_2.setBounds(252, 249, 111, 111);
		add(btnLec_2);
		
		btnLec_3 = new JButton("3");
		btnLec_3.setFont(new Font("Tahoma", Font.PLAIN, 75));
		btnLec_3.setBounds(640, 249, 111, 111);
		add(btnLec_3);
		
		btnLec_4 = new JButton("4");
		btnLec_4.setFont(new Font("Tahoma", Font.PLAIN, 75));
		btnLec_4.setBounds(867, 500, 111, 111);
		add(btnLec_4);
		
		btnTetx_1 = new JButton("Text");
		btnTetx_1.setFont(new Font("Tahoma", Font.PLAIN, 45));
		btnTetx_1.setBounds(439, 500, 147, 111);
		add(btnTetx_1);
		
		btnTetx_2 = new JButton("Text");
		btnTetx_2.setFont(new Font("Tahoma", Font.PLAIN, 45));
		btnTetx_2.setBounds(1048, 249, 147, 111);
		add(btnTetx_2);
		
		JButton dfn_1 = new JButton("?");
		dfn_1.setBounds(150, 418, 45, 38);
		add(dfn_1);
		
		JButton dfn_2 = new JButton("?");
		dfn_2.setBounds(374, 178, 45, 38);
		add(dfn_2);
		
		JButton dfn_3 = new JButton("?");
		dfn_3.setBounds(749, 178, 45, 38);
		add(dfn_3);
		
		JButton dfn_4 = new JButton("?");
		dfn_4.setBounds(975, 418, 45, 38);
		add(dfn_4);
		
		JLabel lblTitulo_1 = new JLabel("Titulo");
		lblTitulo_1.setForeground(Color.WHITE);
		lblTitulo_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTitulo_1.setBackground(Color.BLACK);
		lblTitulo_1.setBounds(59, 450, 96, 28);
		add(lblTitulo_1);
		
		JLabel lblTitulo_2 = new JLabel("Titulo");
		lblTitulo_2.setForeground(Color.WHITE);
		lblTitulo_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTitulo_2.setBackground(Color.BLACK);
		lblTitulo_2.setBounds(268, 211, 96, 28);
		add(lblTitulo_2);
		
		JLabel lblTitulo_3 = new JLabel("Titulo");
		lblTitulo_3.setForeground(Color.WHITE);
		lblTitulo_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTitulo_3.setBackground(Color.BLACK);
		lblTitulo_3.setBounds(656, 211, 96, 28);
		add(lblTitulo_3);
		
		JLabel lblTitulo_4 = new JLabel("Titulo");
		lblTitulo_4.setForeground(Color.WHITE);
		lblTitulo_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTitulo_4.setBackground(Color.BLACK);
		lblTitulo_4.setBounds(882, 462, 96, 28);
		add(lblTitulo_4);

	}
	
	public JButton getBtnLec_1() {
		return btnLec_1;
	}

	public JButton getBtnLec_3() {
		return btnLec_3;
	}

	public JButton getBtnLec_4() {
		return btnLec_4;
	}

	public JButton getBtnTetx_1() {
		return btnTetx_1;
	}

	public JButton getBtnTetx_2() {
		return btnTetx_2;
	}

	public JButton getBtnLec_2() {
		return btnLec_2;
	}
	
}
