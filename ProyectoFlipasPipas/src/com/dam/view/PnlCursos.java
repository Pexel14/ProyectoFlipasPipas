package com.dam.view;

import javax.swing.JPanel;

import com.dam.control.ProjectListener;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;

public class PnlCursos extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public static final String ACT_COM_BTN_CSS = "CSS";
	public static final String ACT_COM_BTN_HTML = "HTML";
	public static final String ACT_COM_BTN_SQL = "SQL";
	public static final String ACT_COM_BTN_JAVA = "JAVA";
	private JButton btnJava;
	private JButton btnSql;
	private JButton btnHtml;
	private JButton btnCss;
	private JButton btnInterrogante1;
	private JButton btnInterrogante2;
	private JButton btnInterrogante3;
	private JButton btnInterrogante4;

	public PnlCursos() {
		setBackground(new Color(50, 50, 75));
		setSize(VMenu.ANCHO_PANEL, VMenu.ALTO_PANEL);
		configurarComponentes();
	}

	private void configurarComponentes() {
		setLayout(null);
		
		btnInterrogante4 = new JButton("?");
		btnInterrogante4.setBackground(new Color(0, 0, 191));
		btnInterrogante4.setBounds(1114, 432, 45, 38);
		add(btnInterrogante4);
		
		btnInterrogante3 = new JButton("?");
		btnInterrogante3.setBackground(new Color(248, 194, 97));
		btnInterrogante3.setBounds(1114, 70, 45, 38);
		add(btnInterrogante3);
		
		btnInterrogante2 = new JButton("?");
		btnInterrogante2.setBackground(new Color(0, 132, 0));
		btnInterrogante2.setBounds(557, 432, 45, 38);
		add(btnInterrogante2);
		
		btnInterrogante1 = new JButton("?");
		btnInterrogante1.setBackground(new Color(138, 0, 0));
		btnInterrogante1.setBounds(557, 70, 45, 38);
		add(btnInterrogante1);
		
		btnJava = new JButton(ACT_COM_BTN_JAVA);
		btnJava.setFont(new Font("Tahoma", Font.PLAIN, 50));
		btnJava.setBounds(181, 115, 375, 250);
		btnJava.setBackground(Color.red);
		add(btnJava);
		
		btnSql = new JButton(ACT_COM_BTN_SQL);
		btnSql.setFont(new Font("Tahoma", Font.PLAIN, 50));
		btnSql.setBounds(737, 115, 375, 250);
		btnSql.setBackground(Color.orange);
		add(btnSql);
		
		btnHtml = new JButton(ACT_COM_BTN_HTML);
		btnHtml.setFont(new Font("Tahoma", Font.PLAIN, 50));
		btnHtml.setBackground(Color.green);
		btnHtml.setBounds(181, 480, 375, 250);
		add(btnHtml);
		
		btnCss = new JButton(ACT_COM_BTN_CSS);
		btnCss.setFont(new Font("Tahoma", Font.PLAIN, 50));
		btnCss.setBackground(Color.blue);
		btnCss.setBounds(737, 480, 375, 250);
		add(btnCss);
	}

	public JButton getBtnCss() {
		return btnCss;
	}
	
	public JButton getBtnHtml() {
		return btnHtml;
	}
	
	public JButton getBtnJava() {
		return btnJava;
	}
	
	public JButton getBtnSql() {
		return btnSql;
	}
	
	public JButton getBtnInterrogante1() {
		return btnInterrogante1;
	}

	public JButton getBtnInterrogante2() {
		return btnInterrogante2;
	}

	public JButton getBtnInterrogante3() {
		return btnInterrogante3;
	}

	public JButton getBtnInterrogante4() {
		return btnInterrogante4;
	}

	public void setListener(ProjectListener listener) {
		btnCss.addActionListener(listener);
		btnHtml.addActionListener(listener);
		btnJava.addActionListener(listener);
		btnSql.addActionListener(listener);
		btnInterrogante1.addActionListener(listener);
		btnInterrogante2.addActionListener(listener);
		btnInterrogante3.addActionListener(listener);
		btnInterrogante4.addActionListener(listener);
	}
}
