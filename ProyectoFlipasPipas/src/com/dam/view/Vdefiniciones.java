package com.dam.view;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JTextArea;

import com.dam.control.ProjectListener;
import com.dam.db.constants.FlipasPipasConst;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ScrollPaneConstants;

public class Vdefiniciones extends JDialog {
	private static final long serialVersionUID = 1L;
	
	
	
	private static final int ANCHO = 600;
	private static final int ALTO = 170;
	
	private JTextArea txtInfo;
	private static VMenu vm;
	
	private JButton btnSalirDef;
	public Vdefiniciones() {
		super(vm, "Definición", true);
				
		configurarFrame();
		componentes();		
		
	}

	private void configurarFrame() {
		
		setSize(ANCHO, ALTO);
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
		btnSalirDef.addActionListener(listener);
		
	}
	
	public void mostrarInterrogantes(int i) {
		txtInfo.setText("");
		txtInfo.setText(FlipasPipasConst.DEFINICIONES[i]);
		
	}

	public void mostrarDef(String def) {
		txtInfo.setText("");
		txtInfo.setText(def);
	}
	
}
