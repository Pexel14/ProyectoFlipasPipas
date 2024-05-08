package com.dam.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class PnlTemario extends JPanel {
	
	private static final int ANCHO_TOTAL = 1292;
	private static final int ANCHO = 1274;
	private static final int ALTO_PANEL = 811;
	private static final int ALTO_TOTAL = 5275;

	public PnlTemario() {
		
		configurarPanel();
		componentes();
		
	}

	private void configurarPanel() {
		setBackground(new Color(50, 50, 75));
		//setSize(ANCHO_TOTAL, ALTO_TOTAL); // PARA EL DESIGN
		setSize(ANCHO_TOTAL, ALTO_PANEL); //PARA EL FINAL
		setLayout(null);
	}

	private void componentes() {
		JPanel pnlPantalla = new JPanel();
		pnlPantalla.setPreferredSize(new Dimension(ANCHO_TOTAL, ALTO_TOTAL));
		pnlPantalla.setBackground(new Color(50, 50, 75));
		pnlPantalla.setLayout(null);
		
		JPanel pnlIndice = new JPanel();
		pnlIndice.setBackground(new Color(104, 100, 124));
		pnlIndice.setBounds(50, 50, 1174, 800);
		pnlPantalla.add(pnlIndice);
		pnlIndice.setLayout(null);
		
		JLabel lblIndiceTitulo = new JLabel("ÍNDICE");
		lblIndiceTitulo.setForeground(new Color(240, 240, 240));
		lblIndiceTitulo.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblIndiceTitulo.setBounds(492, 10, 190, 65);
		pnlIndice.add(lblIndiceTitulo);
		
		JLabel lblIndice = new JLabel("<HTML>\r\n1. JAVA <br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;1.1 Variables <br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;1.2 Operadores Aritméticos <br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;1.3 Operadores Lógicos <br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;1.4 Bucles <br> <br>\r\n\r\n2. SQL <br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;2.1 Creación de Tablas <br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;2.2 Constraints <br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;2.3 Alter table/Insert into <br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;2.4 Update/Delete <br> <br>\r\n\r\n3. HTML <br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;3.1 Estructura básica <br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;3.2 Listas <br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;3.3 Enlaces <br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;3.4 Formularios <br> <br>\r\n\r\n4. CSS <br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;4.1 Inicio CSS <br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;4.2 Estructura CSS <br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;4.3 Colores <br>\r\n&nbsp;&nbsp;&nbsp;&nbsp;4.4 Medidas de posicionamiento <br> <br>\r\n</HTML>");
		lblIndice.setForeground(new Color(240, 240, 240));
		lblIndice.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblIndice.setBounds(412, 100, 350, 650);
		pnlIndice.add(lblIndice);
		
		JScrollPane scrp = new JScrollPane(pnlPantalla);
		scrp.getVerticalScrollBar().setUnitIncrement(20); // Para que la barra lateral se desplace más rápido
		pnlPantalla.setLayout(null);
		//scrp.setBounds(0, 0, ANCHO_TOTAL, ALTO_TOTAL); // PARA EL DESIGN
		scrp.setBounds(0, 0, ANCHO_TOTAL, ALTO_PANEL); //PARA EL FINAL
		add(scrp);
		
		JPanel pnlJava = new JPanel();
		pnlJava.setLayout(null);
		pnlJava.setBackground(new Color(104, 100, 124));
		pnlJava.setBounds(50, 900, 1174, 875);
		pnlPantalla.add(pnlJava);
		
		JLabel lblJavaTitulo = new JLabel("JAVA");
		lblJavaTitulo.setForeground(UIManager.getColor("Button.background"));
		lblJavaTitulo.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblJavaTitulo.setBounds(522, 10, 130, 65);
		pnlJava.add(lblJavaTitulo);
		
		JLabel lblJava = new JLabel("<HTML>\r\n<b>1. Variables</b> <br>\r\nUna variable es una zona de memoria donde se puede almacenar información del tipo que se desee con un nombre que la identifica. Existen dos tipos de variables, las variables primitivas y las de referencia. Se distinguen por la declaración del tipo de dato, en las de referencia la primera letra será en mayúscula. <br> <br>\r\n\r\n*insertar/escribir imagen tipos* <br> <br>\r\n\r\nPrimitivos  <br>\r\nint --> enteros 2^32 <br>\r\nshort --> enteros 2^16 <br> <br>\r\n\r\nDECLARACIÓN DE VARIABLE: <br>\r\ntipoDato nombreVariable; <br>  <br>\r\n\r\n<b>2. Operadores Aritméticos</b> <br>\r\nEn java existen distintos operadores para llevar a cabo operaciones o asignaciones: <br>\r\n= --> A = B | asignar valor B a A <br>\r\n+= --> A += B | añadir el valor de B a A <br> <br>\r\n\r\n<b>3. Operadores Lógicos</b> <br>\r\nEn java existen operadores que te permiten realizar operaciones lógicas, siempre devuelve un boolean <br>\r\n> --> A > B | Si el valor de A es mayor que B <br>\r\n>= --> A >= B | Si el valor de A es mayor igual que B <br> <br>\r\n\r\n<b>4. Bucles</b> <br>\r\nEn java podemos repetir un bloque de código con bucles, hay diferentes tipos de bucles <br> <br>\r\n*insertar sintaxis de cada uno y su uso*\r\n\r\n</HTML>");
		lblJava.setForeground(UIManager.getColor("Button.background"));
		lblJava.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblJava.setBounds(50, 100, 1074, 725);
		pnlJava.add(lblJava);
		
		JPanel pnlSql = new JPanel();
		pnlSql.setLayout(null);
		pnlSql.setBackground(new Color(104, 100, 124));
		pnlSql.setBounds(50, 1825, 1174, 1125);
		pnlPantalla.add(pnlSql);
		
		JLabel lblSqlTitulo = new JLabel("SQL");
		lblSqlTitulo.setForeground(UIManager.getColor("Button.background"));
		lblSqlTitulo.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblSqlTitulo.setBounds(537, 10, 100, 65);
		pnlSql.add(lblSqlTitulo);
		
		JLabel lblSql = new JLabel("<HTML>\r\n<b>1. Creación de tablas</b> <br>\r\nEn SQL se crean tablas con columnas de información. Para poder crear una tabla, debes rellenarla con columnas <br> <br>\r\n\r\nCREATE TABLE <nombreTabla>(\r\n\t<nombreColumna1>NUMBER(3),\r\n\t<nombreColumna2>VARCHAR2(20)\r\n); <br> <br>\r\n\r\nCada columna puede tener un tipo de dato distinto : <br> <br>\r\n\r\nVARCHAR2 → Cadena <br>\r\nNUMBER → número <br> <br>\r\n\r\nPara eliminar una tabla se utiliza DROP TABLE <nombreTabla> <br> <br>\r\n\r\n<b>2. Constraints</b> <br>\r\nPara evitar que en SQL un dato no valido entre en la tabla utilizamos las Constraints :<br> <br>\r\n\r\nNOT NULL → no puede ser nulo <br>\r\nPRIMARY KEY → clave primaria <br> <br>\r\n\r\n<b>3. Alter table/Insert into</b> <br>\r\nPuedes modificar la tabla utilizando ALTER TABLE :<br> <br>\r\n\r\nALTER TABLE nombreTabla alteración <br>\r\nADD <br>\r\nDROP  <br>\r\nMODIFY <br>\r\n\r\nPara insertar datos en la base de datos :<br> <br>\r\n\r\nINSERT INTO <nombreTabla> (<columnas>) VALUES(<valores>) <br> <br>\r\n\r\nEl orden de la inserción de datos se especifica en \"columnas\" y tiene que seguirlo \"valores\". <br> <br>\r\n\r\n<b>4. Update/Delete</b> <br>\r\nPara actualizar los datos en la base de datos :<br>\r\nUPDATE nombreTabla SET columna1 = actualización <br> <br>\r\n\r\nPara indicar en qué tipo de datos se quiere actualizar se utiliza la sentencia WHERE :<br>\r\nWHERE columna1 = “Pato” <br>\r\n\r\nPara borrar datos de la base de datos : <br>\r\nDELETE FROM nombreTabla WHERE columna1 = “Jose”\r\n</HTML>");
		lblSql.setForeground(UIManager.getColor("Button.background"));
		lblSql.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSql.setBounds(50, 100, 1074, 975);
		pnlSql.add(lblSql);
		
		JPanel pnlHtml = new JPanel();
		pnlHtml.setLayout(null);
		pnlHtml.setBackground(new Color(104, 100, 124));
		pnlHtml.setBounds(50, 3000, 1174, 1125);
		pnlPantalla.add(pnlHtml);
		
		JLabel lblHtmlTitulo = new JLabel("HTML");
		lblHtmlTitulo.setForeground(UIManager.getColor("Button.background"));
		lblHtmlTitulo.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblHtmlTitulo.setBounds(514, 10, 145, 65);
		pnlHtml.add(lblHtmlTitulo);
		
		JLabel lblHtml = new JLabel("<HTML>\r\n<b>1. Creación de tablas</b> <br>\r\nEn SQL se crean tablas con columnas de información. Para poder crear una tabla, debes rellenarla con columnas <br> <br>\r\n\r\nCREATE TABLE <nombreTabla>(\r\n\t<nombreColumna1>NUMBER(3),\r\n\t<nombreColumna2>VARCHAR2(20)\r\n); <br> <br>\r\n\r\nCada columna puede tener un tipo de dato distinto : <br> <br>\r\n\r\nVARCHAR2 → Cadena <br>\r\nNUMBER → número <br> <br>\r\n\r\nPara eliminar una tabla se utiliza DROP TABLE <nombreTabla> <br> <br>\r\n\r\n<b>2. Constraints</b> <br>\r\nPara evitar que en SQL un dato no valido entre en la tabla utilizamos las Constraints :<br> <br>\r\n\r\nNOT NULL → no puede ser nulo <br>\r\nPRIMARY KEY → clave primaria <br> <br>\r\n\r\n<b>3. Alter table/Insert into</b> <br>\r\nPuedes modificar la tabla utilizando ALTER TABLE :<br> <br>\r\n\r\nALTER TABLE nombreTabla alteración <br>\r\nADD <br>\r\nDROP  <br>\r\nMODIFY <br>\r\n\r\nPara insertar datos en la base de datos :<br> <br>\r\n\r\nINSERT INTO <nombreTabla> (<columnas>) VALUES(<valores>) <br> <br>\r\n\r\nEl orden de la inserción de datos se especifica en \"columnas\" y tiene que seguirlo \"valores\". <br> <br>\r\n\r\n<b>4. Update/Delete</b> <br>\r\nPara actualizar los datos en la base de datos :<br>\r\nUPDATE nombreTabla SET columna1 = actualización <br> <br>\r\n\r\nPara indicar en qué tipo de datos se quiere actualizar se utiliza la sentencia WHERE :<br>\r\nWHERE columna1 = “Pato” <br>\r\n\r\nPara borrar datos de la base de datos : <br>\r\nDELETE FROM nombreTabla WHERE columna1 = “Jose”\r\n</HTML>");
		lblHtml.setForeground(UIManager.getColor("Button.background"));
		lblHtml.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHtml.setBounds(50, 100, 1074, 975);
		pnlHtml.add(lblHtml);
		
		JPanel pnlCss = new JPanel();
		pnlCss.setLayout(null);
		pnlCss.setBackground(new Color(104, 100, 124));
		pnlCss.setBounds(50, 4175, 1174, 1050);
		pnlPantalla.add(pnlCss);
		
		JLabel lblCssTitulo = new JLabel("CSS");
		lblCssTitulo.setForeground(UIManager.getColor("Button.background"));
		lblCssTitulo.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblCssTitulo.setBounds(537, 10, 100, 65);
		pnlCss.add(lblCssTitulo);
		
		JLabel lblCss = new JLabel("<HTML>\r\n<b>1. INICIO</b><br>\r\nCSS es una hoja de estilo en cascada que complementa a las etiquetas HTML, mejora la presentación y aspecto de las páginas web.<br><br>\r\n\r\n<b>2. Sintaxis</b><br>\r\n'selector { declaración  }'<br><br>\r\n\r\n<b>3. Estructura</b><br>\r\nPara enlazar una hoja de estilos con HTML se usara \"link rel=\"stylesheet\" type=\"text/css\" href=\"estilos.css\" /\"<br>\r\nPara referenciar a las clases de HTML se usará ‘.’ antes del selector :<br><br>\r\n\r\n. selector {}<br><br>\r\n\r\nPara referenciar a las IDs se usará ‘#’ antes del selector<br><br>\r\n\r\n#selector {}<br><br>\r\n\r\n<b>4. Colores</b><br>\r\nPara añadir color a una fuente de HTML se usará la propiedad ‘color: color’<br><br>\r\n\r\nHay distintos formatos para expresar los colores en CSS<br><br>\r\n\r\nUsando hexadecimal: ‘color : ‘#FF00FF’<br>\r\nUsando RGB: ‘color : 203, 17, 128’<br>\r\nUsando colores preestablecidos: ‘color : ‘red’’<br>\r\n\r\nPara añadir color al fondo utilizamos la propiedad ‘background-color : color’<br><br>\r\n\r\n<b>5. Medidas Posicionamiento</b><br>\r\n\r\nSe pueden modificar las dimensiones de los elementos utilizando ‘width’ y ‘height’, tambien puedes especificar el minimo y maximo ‘min-width’ y ‘max-height’<br><br>\r\n\r\nExisten varias maneras para expresar una medida absoluta, entre ellas están<br><br>\r\n\r\npx → pixeles<br>\r\npt → points<br>\r\ncm → centímetros<br>\r\n</HTML>");
		lblCss.setForeground(UIManager.getColor("Button.background"));
		lblCss.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCss.setBounds(50, 100, 1074, 900);
		pnlCss.add(lblCss);
		
	}
}
