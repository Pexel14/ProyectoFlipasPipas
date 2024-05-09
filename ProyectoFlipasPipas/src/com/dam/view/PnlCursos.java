package com.dam.view;

import javax.swing.JPanel;

import com.dam.control.ProjectListener;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;

public class PnlCursos extends JPanel {
	private JButton btnJava;
	private JButton btnSql;
	private JButton btnHtml;
	private JButton btnCss;

	public PnlCursos() {
		setBackground(new Color(50, 50, 75));
		setSize(VMenu.ANCHO_PANEL, VMenu.ALTO_PANEL);
		configurarComponentes();
	}

	private void configurarComponentes() {
		setLayout(null);
		
		btnJava = new JButton("JAVA");
		btnJava.setFont(new Font("Tahoma", Font.PLAIN, 50));
		btnJava.setBounds(181, 115, 375, 250);
		btnJava.setBackground(Color.red);
		add(btnJava);
		
		btnSql = new JButton("SQL");
		btnSql.setFont(new Font("Tahoma", Font.PLAIN, 50));
		btnSql.setBounds(737, 115, 375, 250);
		btnSql.setBackground(Color.orange);
		add(btnSql);
		
		btnHtml = new JButton("HTML");
		btnHtml.setFont(new Font("Tahoma", Font.PLAIN, 50));
		btnHtml.setBackground(Color.green);
		btnHtml.setBounds(181, 480, 375, 250);
		add(btnHtml);
		
		btnCss = new JButton("CSS");
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
	
	// TODO
	public void setListener(ProjectListener listener) {
		btnCss.addActionListener(listener);
		btnHtml.addActionListener(listener);
		btnJava.addActionListener(listener);
		btnSql.addActionListener(listener);
	}
}
