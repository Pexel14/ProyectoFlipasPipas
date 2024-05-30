package com.dam.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import com.dam.control.ProjectListener;
import com.dam.model.pojos.Preguntas;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*
 * @author alejandro
 * */

public class VPreguntas extends JFrame {
	
	public static final String ACT_CMD_BTN_SALIRPREG = "X";
	public static final String ACT_CMD_BTN_A = "A";
	public static final String ACT_CMD_BTN_B = "B";
	public static final String ACT_CMD_BTN_C = "C";
	public static final String ACT_CMD_BTN_D = "D";
	
	private static final int ANCHO = 1575;
	private static final int ALTO = 1021;
	private JButton btnA;
	private JButton btnB;
	private JButton btnC;
	private JButton btnD;
	private JButton btnSalir;
	private JTextArea txtaPregunta;

	public VPreguntas() {
		
		super("Nivel");
		
		ConfigurarFrame();

		componentes();
		
	}

	public void hacerVisible() {
		setVisible(true);
	}

	private void componentes() {

		getContentPane().setBackground(new Color(50, 50, 75));
		
		JScrollPane scrpTitulo = new JScrollPane();
		scrpTitulo.setBorder(null);
		scrpTitulo.setBackground(new Color(50, 50, 75));
		scrpTitulo.setBounds(296, 125, 892, 200);
		
		txtaPregunta = new JTextArea();
		txtaPregunta.setEditable(false);
		txtaPregunta.setText("Esto es la pregunta");
		txtaPregunta.setLineWrap(true);
		txtaPregunta.setWrapStyleWord(true);
		txtaPregunta.setFont(new Font("Tahoma", Font.PLAIN, 35));
		txtaPregunta.setBackground(new Color(50, 50, 75));
		txtaPregunta.setForeground(new Color(240, 240, 240));
		scrpTitulo.setViewportView(txtaPregunta);
		
		getContentPane().add(scrpTitulo);
		
		btnA = new JButton(ACT_CMD_BTN_A);
		btnA.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnA.setBounds(296, 382, 348, 128);
		getContentPane().add(btnA);
		
		btnB = new JButton(ACT_CMD_BTN_B);
		btnB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnB.setBounds(840, 382, 348, 128);
		getContentPane().add(btnB);
		
		btnC = new JButton(ACT_CMD_BTN_C);
		btnC.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnC.setBounds(296, 591, 348, 128);
		getContentPane().add(btnC);
		
		btnD = new JButton(ACT_CMD_BTN_D);
		btnD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnD.setBounds(840, 591, 348, 128);
		getContentPane().add(btnD);
		
		btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(VPreguntas.class.getResource("/img/salir.png")));
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBounds(1350, 105, 50, 50);
		getContentPane().add(btnSalir);
		
		
		
	}

	
	
	public JButton getBtnA() {
		return btnA;
	}

	public JButton getBtnB() {
		return btnB;
	}

	public JButton getBtnC() {
		return btnC;
	}

	public JButton getBtnD() {
		return btnD;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	private void ConfigurarFrame() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(ANCHO, ALTO);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
	}
	
	public void setListener(ProjectListener pl) {
		btnA.addActionListener(pl);
		btnB.addActionListener(pl);
		btnC.addActionListener(pl);
		btnD.addActionListener(pl);
		btnSalir.addActionListener(pl);
//		txtaHola.addac
	}

	public void setPregunta(Preguntas pregunta) {
		
		txtaPregunta.setText(pregunta.getPregunta());
		btnA.setText(pregunta.getResp1());
		btnB.setText(pregunta.getResp2());
		btnC.setText(pregunta.getResp3());
		btnD.setText(pregunta.getResp4());
		
		//System.out.println(pregunta.getIdPregunta());
		
	}
}
