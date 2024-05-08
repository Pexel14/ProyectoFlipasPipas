package com.dam.view;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import java.awt.Font;
import javax.swing.JLabel;

public class VLeciones extends JFrame {
	
	public static final String ACT_CMD_BTN_AJUSTES = "Ajustes";
	public static final String ACT_CMD_BTN_PERFIL = "Perfil";
	public static final String ACT_CMD_BTN_VIDAS = "Vidas";
	public static final String ACT_CMD_BTN_NOTIS = "Notis";
	public static final String ACT_CMD_BTN_TIENDA = "Tienda";
	public static final String ACT_CMD_BTN_TEMARIO = "Temario";
	public static final String ACT_CMD_BTN_RANKING = "Ranking";
	public static final String ACT_CMD_BTN_HOME = "Home";
	
	private static final int ANCHO = 1920;
	private static final int ALTO = 1080;
	
	private final ButtonGroup botonesMenu = new ButtonGroup();
	private JButton btnLec_1;
	private JButton btnLec_3;
	private JButton btnLec_4;
	private JButton btnTetx_1;
	private JButton btnTetx_2;
	private JButton btnHome;
	private JButton btnPerfil;
	private JButton btnRanking;
	private JButton btnTemario;
	private JButton btnTienda;
	private JButton btnAjustes;
	private JButton btnNotis;
	private JButton btnVidas;
	private JButton btnLec_2;

	public VLeciones() {
		super("Lecciones");
		configurarFrame();
		componentes();
	}


	private void componentes() {		
			
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(ANCHO, ALTO);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		btnHome = new JButton(ACT_CMD_BTN_HOME);
		botonesMenu.add(btnHome);
		btnHome.setBounds(1320, 109, 75, 75);
		getContentPane().add(btnHome);
		
		btnRanking = new JButton(ACT_CMD_BTN_RANKING);
		botonesMenu.add(btnRanking);
		btnRanking.setBounds(1320, 293, 75, 75);
		getContentPane().add(btnRanking);
		
		btnTemario = new JButton(ACT_CMD_BTN_TEMARIO);
		botonesMenu.add(btnTemario);
		btnTemario.setBounds(1320, 477, 75, 75);
		getContentPane().add(btnTemario);
		
		btnTienda = new JButton(ACT_CMD_BTN_TIENDA);
		botonesMenu.add(btnTienda);
		btnTienda.setBounds(1320, 661, 75, 75);
		getContentPane().add(btnTienda);
		
		btnNotis = new JButton(ACT_CMD_BTN_NOTIS);
		botonesMenu.add(btnNotis);
		btnNotis.setBounds(1445, 477, 75, 75);
		getContentPane().add(btnNotis);
		
		btnVidas = new JButton(ACT_CMD_BTN_VIDAS);
		botonesMenu.add(btnVidas);
		btnVidas.setBounds(1445, 293, 75, 75);
		getContentPane().add(btnVidas);
		
		btnPerfil = new JButton(ACT_CMD_BTN_PERFIL);
		botonesMenu.add(btnPerfil);
		btnPerfil.setBounds(1445, 109, 75, 75);
		getContentPane().add(btnPerfil);
		
		btnAjustes = new JButton(ACT_CMD_BTN_AJUSTES);
		botonesMenu.add(btnAjustes);
		btnAjustes.setBounds(1445, 661, 75, 75);
		getContentPane().add(btnAjustes);
		
		JPanel pnlDecoracionMenu = new JPanel();
		pnlDecoracionMenu.setBackground(new Color(100, 100, 125));
		pnlDecoracionMenu.setBounds(1415, 0, 10, 1000);
		getContentPane().add(pnlDecoracionMenu);
		
		JPanel pnlDecoracionMenu2 = new JPanel();
		pnlDecoracionMenu2.setBackground(new Color(100, 100, 125));
		pnlDecoracionMenu2.setBounds(1290, 0, 10, 1000);
		getContentPane().add(pnlDecoracionMenu2);
		
		btnLec_1 = new JButton("1");
		btnLec_1.setFont(new Font("Tahoma", Font.PLAIN, 75));
		btnLec_1.setBounds(44, 488, 111, 111);
		getContentPane().add(btnLec_1);
		
		btnLec_2 = new JButton("2");
		btnLec_2.setFont(new Font("Tahoma", Font.PLAIN, 75));
		btnLec_2.setBounds(252, 249, 111, 111);
		getContentPane().add(btnLec_2);
		
		btnLec_3 = new JButton("3");
		btnLec_3.setFont(new Font("Tahoma", Font.PLAIN, 75));
		btnLec_3.setBounds(640, 249, 111, 111);
		getContentPane().add(btnLec_3);
		
		btnLec_4 = new JButton("4");
		btnLec_4.setFont(new Font("Tahoma", Font.PLAIN, 75));
		btnLec_4.setBounds(867, 500, 111, 111);
		getContentPane().add(btnLec_4);
		
		btnTetx_1 = new JButton("Text");
		btnTetx_1.setFont(new Font("Tahoma", Font.PLAIN, 45));
		btnTetx_1.setBounds(439, 500, 147, 111);
		getContentPane().add(btnTetx_1);
		
		btnTetx_2 = new JButton("Text");
		btnTetx_2.setFont(new Font("Tahoma", Font.PLAIN, 45));
		btnTetx_2.setBounds(1048, 249, 147, 111);
		getContentPane().add(btnTetx_2);
		
		JButton dfn_1 = new JButton("?");
		dfn_1.setBounds(150, 418, 45, 38);
		getContentPane().add(dfn_1);
		
		JButton dfn_2 = new JButton("?");
		dfn_2.setBounds(374, 178, 45, 38);
		getContentPane().add(dfn_2);
		
		JButton dfn_3 = new JButton("?");
		dfn_3.setBounds(749, 178, 45, 38);
		getContentPane().add(dfn_3);
		
		JButton dfn_4 = new JButton("?");
		dfn_4.setBounds(975, 418, 45, 38);
		getContentPane().add(dfn_4);
		
		JLabel lblTitulo_1 = new JLabel("Titulo");
		lblTitulo_1.setForeground(Color.WHITE);
		lblTitulo_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTitulo_1.setBackground(Color.BLACK);
		lblTitulo_1.setBounds(59, 450, 96, 28);
		getContentPane().add(lblTitulo_1);
		
		JLabel lblTitulo_2 = new JLabel("Titulo");
		lblTitulo_2.setForeground(Color.WHITE);
		lblTitulo_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTitulo_2.setBackground(Color.BLACK);
		lblTitulo_2.setBounds(268, 211, 96, 28);
		getContentPane().add(lblTitulo_2);
		
		JLabel lblTitulo_3 = new JLabel("Titulo");
		lblTitulo_3.setForeground(Color.WHITE);
		lblTitulo_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTitulo_3.setBackground(Color.BLACK);
		lblTitulo_3.setBounds(656, 211, 96, 28);
		getContentPane().add(lblTitulo_3);
		
		JLabel lblTitulo_4 = new JLabel("Titulo");
		lblTitulo_4.setForeground(Color.WHITE);
		lblTitulo_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTitulo_4.setBackground(Color.BLACK);
		lblTitulo_4.setBounds(882, 462, 96, 28);
		getContentPane().add(lblTitulo_4);

	}

	private void configurarFrame() {
		
		setSize(ANCHO, ALTO);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(50, 50, 75));	
		
	}
	
	public void mostrarVentana() {
		setVisible(true);
	}
	
	public void ocultarVentana() {
		setVisible(false);
	}
	
}
