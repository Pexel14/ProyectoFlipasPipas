package com.dam.db.constants;

public class FlipasPipasConst {
	
	//Clase reservada para las constantes generales del proyecto
	
	public static final int TAM_NOMBRE = 15;
	public static final int TAM_CONTRASENIA = 20;
	
	public static final int ID_CURSO_JAVA = 1;
	public static final int ID_CURSO_SQL = 2;
	public static final int ID_CURSO_HTML = 3;
	public static final int ID_CURSO_CSS = 4;
	
	public static final int [] NOTIFICACIONES = {1, 2, 3, 4}; //---> Las IDs de las notificaciones
	
	//Constantes con las IDs de los bots
	public static final int ID_BOT1 = 1; 
	public static final int ID_BOT2 = 2; 
	public static final int ID_BOT3 = 3; 
	
	public static final int CANT_LECCIONES = 24;
	public static final int CANT_NOTIFICACIONES = 4;
	
	public static final double PIPAS_MAX_BOT = 1.5; //---> Porcentaje máximo de monedas que puede llegar a obtener un bot
	public static final double PIPAS_MIN_BOT = 0.5; //---> Porcentaje mínimo de monedas que puede llegar a obtener un bot
	public static final int CANT_PIPAS_LECCION = 200; //---> Cantidad de monedas que ganas al completar un nivel
	public static final int CANT_PIPAS_PENALIZACION = 20; //---> Cantidad de monedas que pierde el usuario al fallar una pregunta
	
	//Constante con las definiciones de los cursos
	public static final String[] DEFINICIONES ={
			"Java es un lenguaje de programación orientado a objetos que permite desarrollar aplicaciones que pueden ejecutarse en diferentes plataformas sin necesidad de modificaciones específicas.",	
			"HTML, es un lenguaje de marcado utilizado para estructurar y presentar contenidos en la web. Define la estructura de las páginas web mediante etiquetas.",
			"SQL, es un lenguaje utilizado para gestionar y manipular bases de datos relacionales, permitiendo realizar consultas para recuperar o modificar información de manera eficiente.",
			"CSS es un lenguaje de diseño gráfico para definir la presentación de documentos escritos en un lenguaje de marcado."
			+ ", como HTML. Se utiliza principalmente para establecer el estilo visual de las páginas web.",
	};
	
}
