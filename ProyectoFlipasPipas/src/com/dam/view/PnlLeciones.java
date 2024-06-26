package com.dam.view;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPanel;

import com.dam.control.ProjectListener;
import com.dam.db.constants.FlipasPipasConst;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import java.awt.Component;

import javax.swing.SwingConstants;

public class PnlLeciones extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JButton btnLec_1;
	private JButton btnLec_3;
	private JButton btnLec_2;
	private JButton btnLec_4;
	private JButton btnRepaso;
	private JButton btnExamen;
	
	private JButton btnDfn_1;
	private JButton btnDfn_2;
	private JButton btnDfn_3;
	private JButton btnDfn_4;
	
	private JLabel lblTitulo;
	private JLabel lblTitulo_1;
	private JLabel lblTitulo_2;
	private JLabel lblTitulo_3;
	private JLabel lblCurso;
	private JButton btnAtrasLecciones;
	private JLabel lblTitulo_Rep1;
	private JLabel lblTitulo_Rep2;

	public PnlLeciones() {
		setSize(VMenu.ANCHO_PANEL, VMenu.ALTO_PANEL); //Para que no ocurran errores
		setBackground(new Color(50,50,75));
		componentes();
	}


	private void componentes() {
		setLayout(null);
		
		btnLec_1 = new JButton("1");
		btnLec_1.setFont(new Font("Tahoma", Font.PLAIN, 75));
		btnLec_1.setBounds(44, 500, 111, 111);
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
		
		btnRepaso = new JButton("Repaso");
		btnRepaso.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnRepaso.setBounds(439, 500, 147, 111);
		add(btnRepaso);
		
		btnExamen = new JButton("Examen");
		btnExamen.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnExamen.setBounds(1048, 249, 147, 111);
		add(btnExamen);
		
		btnDfn_1 = new JButton("?");
		btnDfn_1.setBounds(150, 418, 45, 38);
		add(btnDfn_1);
		
		btnDfn_2 = new JButton("?");
		btnDfn_2.setBounds(374, 178, 45, 38);
		add(btnDfn_2);
		
		btnDfn_3 = new JButton("?");
		btnDfn_3.setBounds(749, 178, 45, 38);
		add(btnDfn_3);
		
		btnDfn_4 = new JButton("?");
		btnDfn_4.setBounds(975, 418, 45, 38);
		add(btnDfn_4);
		
		lblTitulo = new JLabel("");
		lblTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTitulo.setBackground(Color.BLACK);
		lblTitulo.setBounds(30, 621, 300, 30);
		add(lblTitulo);
		
		lblTitulo_1 = new JLabel("");
		lblTitulo_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo_1.setForeground(Color.WHITE);
		lblTitulo_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTitulo_1.setBackground(Color.BLACK);
		lblTitulo_1.setBounds(110, 370, 400, 30);
		add(lblTitulo_1);
		
		lblTitulo_2 = new JLabel("");
		lblTitulo_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo_2.setForeground(Color.WHITE);
		lblTitulo_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTitulo_2.setBackground(Color.BLACK);
		lblTitulo_2.setBounds(545, 370, 300, 40);
		add(lblTitulo_2);
		
		lblTitulo_3 = new JLabel("");
		lblTitulo_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo_3.setForeground(Color.WHITE);
		lblTitulo_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTitulo_3.setBackground(Color.BLACK);
		lblTitulo_3.setBounds(725, 621, 400, 30);
		add(lblTitulo_3);
		
		lblTitulo_Rep1 = new JLabel("");
		lblTitulo_Rep1.setForeground(Color.WHITE);
		lblTitulo_Rep1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTitulo_Rep1.setBackground(Color.BLACK);
		lblTitulo_Rep1.setBounds(437, 461, 150, 28);
		add(lblTitulo_Rep1);
		
		lblTitulo_Rep2 = new JLabel("");
		lblTitulo_Rep2.setForeground(Color.WHITE);
		lblTitulo_Rep2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTitulo_Rep2.setBackground(Color.BLACK);
		lblTitulo_Rep2.setBounds(1046, 210, 150, 28);
		add(lblTitulo_Rep2);
		
		lblCurso = new JLabel("Curso\r\n");
		lblCurso.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurso.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		lblCurso = new JLabel("");
		lblCurso.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurso.setForeground(Color.WHITE);
		lblCurso.setFont(new Font("Tahoma", Font.BOLD, 70));
		lblCurso.setBackground(Color.BLACK);
		lblCurso.setBounds(396, 26, 500, 100);
		add(lblCurso);
		
		btnAtrasLecciones = new JButton("<-");
		btnAtrasLecciones.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnAtrasLecciones.setBounds(50, 50, 83, 83);
		add(btnAtrasLecciones);

	}
	

	public JButton getBtnDfn_1() {
		return btnDfn_1;
	}


	public JButton getBtnDfn_2() {
		return btnDfn_2;
	}


	public JButton getBtnDfn_3() {
		return btnDfn_3;
	}


	public JButton getBtnDfn_4() {
		return btnDfn_4;
	}


	public JButton getBtnLec_1() {
		return btnLec_1;
	}

	public JButton getBtnLec_2() {
		return btnLec_2;
	}

	public JButton getBtnLec_3() {
		return btnLec_3;
	}

	public JButton getBtnLec_4() {
		return btnLec_4;
	}

	public JButton getBtnRepaso() {
		return btnRepaso;
	}

	public JButton getBtnExamen() {
		return btnExamen;
	}

	public JButton getBtnAtrasLecciones() {
		return btnAtrasLecciones;
	}


	public void setListener(ProjectListener listener) {
		btnLec_1.addActionListener(listener);
		btnLec_2.addActionListener(listener);
		btnRepaso.addActionListener(listener);
		btnLec_3.addActionListener(listener);
		btnLec_4.addActionListener(listener);
		btnExamen.addActionListener(listener);
		
		btnDfn_1.addActionListener(listener);
		btnDfn_2.addActionListener(listener);
		btnDfn_3.addActionListener(listener);
		btnDfn_4.addActionListener(listener);
		btnAtrasLecciones.addActionListener(listener);
	}


	public void cargarLec(ArrayList<String> nomLec, int nomCur, ArrayList<Boolean> nvlsOK) {
		lblTitulo.setText(nomLec.get(0));
		lblTitulo_1.setText(nomLec.get(1));
		lblTitulo_2.setText(nomLec.get(3));
		lblTitulo_3.setText(nomLec.get(4));
		
		switch (nomCur) {
		case FlipasPipasConst.ID_CURSO_JAVA:
			lblCurso.setText("JAVA");
			break;
		case FlipasPipasConst.ID_CURSO_SQL:
			lblCurso.setText("SQL");
			break;
		case FlipasPipasConst.ID_CURSO_HTML:
			lblCurso.setText("HTML");
			break;
		case FlipasPipasConst.ID_CURSO_CSS:
			lblCurso.setText("CSS");
			break;
		default:
			break;
		}
		
		
		btnLec_1.setEnabled(nvlsOK.get(0));;
        btnLec_2.setEnabled(nvlsOK.get(1));;
        btnRepaso.setEnabled(nvlsOK.get(2));;
        btnLec_3.setEnabled(nvlsOK.get(3));;
        btnLec_4.setEnabled(nvlsOK.get(4));;
        btnExamen.setEnabled(nvlsOK.get(5));;
		
	}
}
