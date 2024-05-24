package com.dam.view;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextArea;

import com.dam.control.ProjectListener;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

public class Vdefiniciones extends JDialog {
	
	public static final String[] DEFINICIONES ={
		"Java es un lenguaje de programación orientado a objetos que permite desarrollar aplicaciones que pueden ejecutarse en diferentes plataformas sin necesidad de modificaciones específicas",	
		"Html, es un lenguaje de marcado utilizado para estructurar y presentar contenidos en la web. Define la estructura de las páginas web mediante etiquetas",
		"SQL, es un lenguaje utilizado para gestionar y manipular bases de datos relacionales, permitiendo realizar consultas para recuperar o modificar información de manera eficiente",
		"Css es un lenguaje de diseño gráfico para definir la presentación de documentos escritos en un lenguaje de marcado, como HTML. Se utiliza principalmente para establecer el estilo visual de las páginas web",
	};
	private static final int ANCHO = 600;
	private static final int ALTO = 170;
	private JTextArea txtInfo;
	private static VMenu vm;
	
	private JButton btnSalirDef;
	public Vdefiniciones() {
		super(vm, "definición", true);
				
		configurarFrame();
		componentes();		
		
	}

	private void configurarFrame() {
		
		setSize(ANCHO, ALTO);
//		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(50, 50, 75));	
		
	}

	private void componentes() {
		getContentPane().setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 38, 564, 82);
		getContentPane().add(scrollPane);
		
		txtInfo = new JTextArea();
		
		txtInfo.setFont(new Font("Monospaced", Font.PLAIN, 15));
		scrollPane.setViewportView(txtInfo);
		txtInfo.setBackground(new Color(50, 50, 75));
		txtInfo.setForeground(new Color(255, 255, 255));
		txtInfo.setLineWrap(true);
		txtInfo.setWrapStyleWord(true); // Asegura que las líneas se corten entre palabras, no en medio
		txtInfo.setEditable(false);
		
		btnSalirDef = new JButton("X");
		btnSalirDef.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalirDef.setBounds(514, 0, 60, 34);
		getContentPane().add(btnSalirDef);
	} 
	
	public void hacerVisible() {
		setVisible(true);
	}
	
	public JButton getBtnSalirDef() {
		return btnSalirDef;
	}

	public void setListener(ProjectListener listener) {
		// TODO Auto-generated method stub
		btnSalirDef.addActionListener(listener);
		
	}
	
	public void mostrarDefinicion(int i) {
		txtInfo.setText("");
		txtInfo.setText(DEFINICIONES[i]);
		
	}
	
}
