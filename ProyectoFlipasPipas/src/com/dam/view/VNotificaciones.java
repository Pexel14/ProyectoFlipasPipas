package com.dam.view;

import javax.swing.JButton;
import javax.swing.JDialog;
import com.dam.control.ProjectListener;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;

import javax.swing.JTextArea;


public class VNotificaciones extends JDialog {
	private static final long serialVersionUID = 1L;
	
	private static final int ALTO_TOTAL = 655;
	private static final int ANCHO = 430;
	private static final int ALTO = 600;
	private JButton btnSalir;

	private static VMenu vm;

	private JTextArea txtaNotif1;
	private JTextArea txtaNotif2;
	private JTextArea txtaNotif3;
	private JTextArea txtaNotif4;
	
	static String [] notificaciones = {"","","",""};
	private JScrollPane scrp;
	
	public VNotificaciones() {
		
		super(vm, "Notificaciones", true);
		configurarFrame();
		componentes();
		
	}

	private void componentes() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		scrp = new JScrollPane();
		scrp.setBounds(0, 0, ANCHO, ALTO);
		scrp.getVerticalScrollBar().setUnitIncrement(20);
		scrp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		getContentPane().add(scrp, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(ANCHO, ALTO_TOTAL));
		panel.setBackground(new Color(104, 100, 124));
		scrp.setViewportView(panel);
		panel.setLayout(null);
		
		
		JPanel pnlDecoracion1 = new JPanel();
		pnlDecoracion1.setBackground(new Color(50, 50, 75));
		pnlDecoracion1.setBounds(65, 175, 300, 10);
		panel.add(pnlDecoracion1);
		
		JPanel pnlDecoracion2 = new JPanel();
		pnlDecoracion2.setBackground(new Color(50, 50, 75));
		pnlDecoracion2.setBounds(65, 335, 300, 10);
		panel.add(pnlDecoracion2);
		
		JPanel pnlDecoracion3 = new JPanel();
		pnlDecoracion3.setBackground(new Color(50, 50, 75));
		pnlDecoracion3.setBounds(65, 495, 300, 10);
		panel.add(pnlDecoracion3);
		
		btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(VNotificaciones.class.getResource("/img/salir.png")));
		btnSalir.setBorderPainted(false);
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBounds(340, 10, 50, 50);

		btnSalir = new JButton("x");
		btnSalir.setBounds(341, 11, 48, 23);

		panel.add(btnSalir);
		
		txtaNotif1 = new JTextArea();
		txtaNotif1.setEditable(false);
		txtaNotif1.setForeground(Color.WHITE);
		txtaNotif1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtaNotif1.setBackground(new Color(79, 79, 117));
		txtaNotif1.setBounds(65, 33, 300, 118);
		txtaNotif1.setLineWrap(true);
		txtaNotif1.setWrapStyleWord(true);
		panel.add(txtaNotif1);
		
		txtaNotif2 = new JTextArea();
		txtaNotif2.setEditable(false);
		txtaNotif2.setForeground(Color.WHITE);
		txtaNotif2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtaNotif2.setBackground(new Color(79, 79, 117));
		txtaNotif2.setBounds(65, 195, 300, 118);
		txtaNotif2.setLineWrap(true);
		txtaNotif2.setLineWrap(true);
		txtaNotif2.setWrapStyleWord(true);
		panel.add(txtaNotif2);
		
		txtaNotif3 = new JTextArea();
		txtaNotif3.setEditable(false);
		txtaNotif3.setForeground(Color.WHITE);
		txtaNotif3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtaNotif3.setBackground(new Color(79, 79, 117));
		txtaNotif3.setBounds(65, 355, 300, 118);
		txtaNotif3.setLineWrap(true);
		txtaNotif3.setWrapStyleWord(true);
		panel.add(txtaNotif3);
		
		txtaNotif4 = new JTextArea();
		txtaNotif4.setEditable(false);
		txtaNotif4.setForeground(Color.WHITE);
		txtaNotif4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtaNotif4.setBackground(new Color(79, 79, 117));
		txtaNotif4.setBounds(65, 515, 300, 118);
		txtaNotif4.setLineWrap(true);
		txtaNotif4.setWrapStyleWord(true);
		panel.add(txtaNotif4);
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}
	
	private void configurarFrame() {
		setSize(ANCHO, ALTO);
		setLocationRelativeTo(null);
	}

	public void hacerVisible() {
		setVisible(true);
	}

	public void setListener(ProjectListener l) {
		btnSalir.addActionListener(l);
	}

	public void setNotificaciones(String notificacion) {
		
		for (int i = notificaciones.length - 1; i >= 0; i--) {
			
			if(i == 0) {
				notificaciones[i] = notificacion;
			
			} else {
				notificaciones[i] = notificaciones[i-1];
			}
			
		}
		
		txtaNotif1.setText(notificaciones[0]);
		txtaNotif2.setText(notificaciones[1]);
		txtaNotif3.setText(notificaciones[2]);
		txtaNotif4.setText(notificaciones[3]);
	}
	
	public void limpiar() {
		txtaNotif1.setText("");
		txtaNotif2.setText("");
		txtaNotif3.setText("");
		txtaNotif4.setText("");
	}
	
}
