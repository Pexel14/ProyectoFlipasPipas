package com.dam.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import com.dam.control.ProjectListener;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JTextArea;

public class VNotis extends JFrame {
	
	private static final int ALTO_TOTAL = 655;
	private static final int ANCHO = 400;
	private static final int ALTO = 600;
	private JButton btnSalir;
	private JTextArea textArea;
	private JTextArea textArea_1;
	private JTextArea textArea_2;
	private JTextArea textArea_3;
	
	public VNotis() {
		
		super("Notificaciones");
		configurarFrame();
		componentes();
		
	}

	private void componentes() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrp = new JScrollPane();
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
		pnlDecoracion1.setBounds(35, 175, 300, 10);
		panel.add(pnlDecoracion1);
		
		JPanel pnlDecoracion2 = new JPanel();
		pnlDecoracion2.setBackground(new Color(50, 50, 75));
		pnlDecoracion2.setBounds(35, 335, 300, 10);
		panel.add(pnlDecoracion2);
		
		JPanel pnlDecoracion3 = new JPanel();
		pnlDecoracion3.setBackground(new Color(50, 50, 75));
		pnlDecoracion3.setBounds(35, 495, 300, 10);
		panel.add(pnlDecoracion3);
		
		btnSalir = new JButton("x");
		btnSalir.setBounds(306, 11, 48, 23);
		panel.add(btnSalir);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setForeground(Color.WHITE);
		textArea.setFont(new Font("Monospaced", Font.BOLD, 13));
		textArea.setBackground(new Color(79, 79, 117));
		textArea.setBounds(35, 33, 300, 118);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		panel.add(textArea);
		
		textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setForeground(Color.WHITE);
		textArea_1.setFont(new Font("Monospaced", Font.BOLD, 13));
		textArea_1.setBackground(new Color(79, 79, 117));
		textArea_1.setBounds(35, 195, 300, 118);
		textArea_1.setLineWrap(true);
		textArea_1.setLineWrap(true);
		textArea_1.setWrapStyleWord(true);
		panel.add(textArea_1);
		
		textArea_2 = new JTextArea();
		textArea_2.setEditable(false);
		textArea_2.setForeground(Color.WHITE);
		textArea_2.setFont(new Font("Monospaced", Font.BOLD, 13));
		textArea_2.setBackground(new Color(79, 79, 117));
		textArea_2.setBounds(35, 355, 300, 118);
		textArea_2.setLineWrap(true);
		textArea_2.setWrapStyleWord(true);
		panel.add(textArea_2);
		
		textArea_3 = new JTextArea();
		textArea_3.setEditable(false);
		textArea_3.setForeground(Color.WHITE);
		textArea_3.setFont(new Font("Monospaced", Font.BOLD, 13));
		textArea_3.setBackground(new Color(79, 79, 117));
		textArea_3.setBounds(35, 515, 300, 118);
		textArea_3.setLineWrap(true);
		textArea_3.setWrapStyleWord(true);
		panel.add(textArea_3);
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}
	
	private void configurarFrame() {
		setSize(ANCHO, ALTO);
//		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public void hacerVisible() {
		setVisible(true);
	}

	public void setListener(ProjectListener l) {
		btnSalir.addActionListener(l);
	}

	public void setNotis(ArrayList<String> listNotis) {
		
		// TODO inserta las notificaciones del array en los lbls correspondientes
		textArea.setText(listNotis.get(0));
		textArea_1.setText(listNotis.get(1));
		textArea_2.setText(listNotis.get(2));
		textArea_3.setText(listNotis.get(3));
	}
}
