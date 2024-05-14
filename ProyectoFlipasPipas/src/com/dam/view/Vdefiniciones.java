package com.dam.view;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextArea;

import com.dam.control.ProjectListener;

public class Vdefiniciones extends JDialog {
	
	private static final int ANCHO = 265;
	private static final int ALTO = 270;
	private JTextArea txtInfo;
	private static VMenu vm;
	
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
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		txtInfo = new JTextArea();
		txtInfo.setBackground(new Color(50, 50, 75));
		txtInfo.setForeground(new Color(255, 255, 255));
		txtInfo.setEditable(false);
		scrollPane.setViewportView(txtInfo);
		
	}
	
	public void hacerVisible() {
		setVisible(true);
	}

	public void setListener(ProjectListener listener) {
		// TODO Auto-generated method stub
		
	}

}
