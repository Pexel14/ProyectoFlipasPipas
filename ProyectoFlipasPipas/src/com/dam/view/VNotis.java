package com.dam.view;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.dam.control.ProjectListener;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class VNotis extends JDialog {
	
	private static final int ALTO_TOTAL = 655;
	private static final int ANCHO = 400;
	private static final int ALTO = 600;
	private JLabel lblNoti1;
	private JButton btnSalir;
	private static VMenu vm;
	
	public VNotis() {
		
		super(vm, "Notificaciones", true);
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
		
		lblNoti1 = new JLabel("<HTML>\r\nNoti 1 Noti 1 Noti 1 Noti 1 Noti 1 Noti 1 Noti 1 Noti 1 Noti 1 Noti 1 Noti 1 Noti 1 Noti 1 Noti 1 \r\nNoti 1 Noti 1 Noti 1 Noti 1 Noti 1 Noti 1 Noti 1 Noti 1 Noti 1 Noti 1 Noti 1 \r\n</HTML>");
		lblNoti1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNoti1.setBounds(30, 50, 300, 100);
		panel.add(lblNoti1);
		
		
		JPanel pnlDecoracion1 = new JPanel();
		pnlDecoracion1.setBackground(new Color(50, 50, 75));
		pnlDecoracion1.setBounds(35, 175, 300, 10);
		panel.add(pnlDecoracion1);
		
		JLabel lblNoti2 = new JLabel("<HTML>\r\nNoti 2 Noti 2 Noti 2 Noti 2 Noti 2 Noti 2 Noti 2 Noti 2 Noti 2 Noti 2 Noti 2 Noti 2 Noti 2 Noti 2 Noti 2 Noti 2 Noti 2 Noti 2 Noti 2 Noti 2 Noti 2 Noti 2 Noti 2 Noti 2 Noti 2\r\n</HTML>");
		lblNoti2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNoti2.setBounds(35, 210, 300, 100);
		panel.add(lblNoti2);
		
		JPanel pnlDecoracion2 = new JPanel();
		pnlDecoracion2.setBackground(new Color(50, 50, 75));
		pnlDecoracion2.setBounds(35, 335, 300, 10);
		panel.add(pnlDecoracion2);
		
		JLabel lblNoti3 = new JLabel("<HTML>\r\nNoti 3 Noti 3 Noti 3 Noti 3 Noti 3 Noti 3 Noti 3 Noti 3 Noti 3 Noti 3 Noti 3 Noti 3 Noti 3 Noti 3 Noti 3 Noti 3 Noti 3 Noti 3 Noti 3 Noti 3 Noti 3 Noti 3 Noti 3 Noti 3 Noti 3 \r\n</HTML>");
		lblNoti3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNoti3.setBounds(35, 370, 300, 100);
		panel.add(lblNoti3);
		
		JPanel pnlDecoracion3 = new JPanel();
		pnlDecoracion3.setBackground(new Color(50, 50, 75));
		pnlDecoracion3.setBounds(35, 495, 300, 10);
		panel.add(pnlDecoracion3);
		
		JLabel lblNoti4 = new JLabel("<HTML>\r\nNoti 4 Noti 4 Noti 4 Noti 4 Noti 4 Noti 4 Noti 4 Noti 4 Noti 4 Noti 4 Noti 4 Noti 4 Noti 4 Noti 4 Noti 4 Noti 4 Noti 4 Noti 4 Noti 4 Noti 4 Noti 4 Noti 4 Noti 4 Noti 4 Noti 4 \r\n</HTML>");
		lblNoti4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNoti4.setBounds(35, 530, 300, 100);
		panel.add(lblNoti4);
		
		btnSalir = new JButton("x");
		btnSalir.setBounds(306, 11, 48, 23);
		panel.add(btnSalir);
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}
	
	private void configurarFrame() {
		setSize(ANCHO, ALTO);
//		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public void hacerVisible() {
		setVisible(true);
	}

	public void setListener(ProjectListener l) {
		btnSalir.addActionListener(l);
	}
}
