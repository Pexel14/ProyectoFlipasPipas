--Creacion de las tablas del proyecto

--TABLA USUARIOS(id_usuario, nick, email, fotoPerfil, monedas, contrase�a)
--id_usuario number (PK)
--nick varchar2 (UQ)
--email varchar2 (UQ)
--fotoPerfil varchar2
--monedas number
--contrase�a varchar2
CREATE TABLE USUARIOS(
    ID_USUARIO NUMBER(3) CONSTRAINT PK_USUARIOS_IDUSER PRIMARY KEY,
    NICK VARCHAR2(30) CONSTRAINT UQ_USUARIOS_NICK UNIQUE,
    EMAIL VARCHAR2(40) CONSTRAINT UQ_USUARIOS_EMAIL UNIQUE,
    FOTO_PERFIL VARCHAR2(50),
    MONEDAS NUMBER(6),
    CONTRASENIA VARCHAR2(20)
);

--TABLA CURSOS(id_curso, nombre)
--id_curso number (PK)
--nombre varchar2
CREATE TABLE CURSOS(
    ID_CURSO NUMBER(1) CONSTRAINT PK_USUARIOS_IDCURSO PRIMARY KEY,
    NOMBRE VARCHAR2(4)
);

--TABLA LECCIONES(id_leccion, id_curso, leccion, completada)
--id_leccion number (PK)
--id_curso number (FK)
--leccion varchar2
--completada boolean
CREATE TABLE LECCIONES(
    ID_LECCION NUMBER(2) CONSTRAINT PK_LECCIONES_IDLEC PRIMARY KEY,
    ID_CURSO NUMBER(1) CONSTRAINT FK_LECCIONES_IDCUR REFERENCES CURSOS(ID_CURSO),
    LECCION VARCHAR2(50),
    COMPLETADA BOOLEAN
);

--TABLA PREGUNTAS(id_preguta, id_leccion, pregunta, respuesta, esCorrecta)
--id_pregunta number (PK)
--id_leccion number (FK de Lecciones)
--pregunta varchar2
--respuesta varchar2
--esCorrecta boolean
CREATE TABLE PREGUNTAS(
    ID_PREGUNTA NUMBER(3) CONSTRAINT PK_PREGUNTAS_IDPREG PRIMARY KEY,
    ID_LECCION NUMBER(2) CONSTRAINT FK_PREGUNTAS_IDLEC REFERENCES PREGUNTAS(ID_LECCION),
    PREGUNTA VARCHAR2(100),
    RESP1 VARCHAR2(100),
    RESP2 VARCHAR2(100),
    RESP3 VARCHAR2(100),
    RESP4 VARCHAR2(100),
    CORRECTA VARCHAR2(5)
);

--TABLA USUARIOS_PREGUNTAS(id_usuario, id_pregunta, monedas, acertado)
--id_usuario number (PK (FK de Usuarios))
--id_pregunta number (PK (FK de Preguntas))
--monedas number
--acertado boolean
CREATE TABLE USUARIOS_PREGUNTAS(
    ID_USUARIO NUMBER(3),
    ID_PREGUNTA NUMBER(3),
    MONEDAS NUMBER(3),
    ACERTADO BOOLEAN,
    CONSTRAINT PK_USERPREG_IDUSERIDPREG PRIMARY KEY (ID_USUARIO, ID_PREGUNTA),
    CONSTRAINT FK_USERPREG_IDUSER FOREIGN KEY (ID_USUARIO) REFERENCES USUARIOS(ID_USUARIO),
    CONSTRAINT FK_USERPREG_IDPREG FOREIGN KEY (ID_PREGUNTA) REFERENCES USUARIOS(ID_PREGUNTA)
);

--TABLA NOTIFICACIONES(id_notificacion, id_usuario, notificacion)
--id_notificacion number (PK)
--id_usuario number (FK de Usuarios)
--notificacion varchar2
CREATE TABLE NOTIFICACIONES(
    ID_NOTIFICACION NUMBER(2) CONSTRAINT PK_NOTIFICACIONES_IDNOTIF PRIMARY KEY,
    ID_USUARIO NUMBER(3) CONSTRAINT FK_NOTIFICACIONES_IDUSER REFERENCES USUARIOS(ID_USUARIO),
    NOTIFICACION VARCHAR2(255)
);

--TABLA TIENDA(id_objeto, objeto, precio, icono)
--id_objeto number (PK)
--objeto varchar2
--precio number
--icono varchar2
CREATE TABLE TIENDA(
    ID_OBJETO NUMBER(2) CONSTRAINT PK_TIENDA_IDOBJ PRIMARY KEY,
    NOM_OBJETO VARCHAR2(20),
    PRECIO NUMBER(3),
    ICONO VARCHAR2(50)
);

--TABLA TEMARIO(id_temario, id_lecciones, temario)
--id_temario number (PK)
--id_lecciones number (FK de curso)
--temario varchar2 
CREATE TABLE TEMARIO(
    ID_TEMARIO NUMBER(2) CONSTRAINT PK_TEMARIO_IDTEM PRIMARY KEY,
    ID_LECCION NUMBER(2) CONSTRAINT FK_TEMARIO_IDLEC REFERENCES LECCIONES(ID_LECCION),
    TEAMRIO VARCHAR2(255)
);

--INSERTS

--Inser usuarios pruebas
INSERT INTO USUARIOS VALUES(1, 'prueba', 'usuario@prueba.com','',0,'usuarioprueba1');


--Insert cursos
INSERT INTO CURSOS VALUES(1,'JAVA');
INSERT INTO CURSOS VALUES(2,'SQL');
INSERT INTO CURSOS VALUES(3,'HTML');
INSERT INTO CURSOS VALUES(4,'CSS');



--Insert preguntas
--JAVA

--Insert lecciones de java
INSERT INTO LECCIONES VALUES(1,1,'Variables',false);
INSERT INTO LECCIONES VALUES(2,1,'Operadores Aritmeticos',false);
INSERT INTO LECCIONES VALUES(3,1,'Repaso',false);
INSERT INTO LECCIONES VALUES(4,1,'Operadores Logicos',false);
INSERT INTO LECCIONES VALUES(5,1,'Bucles',false);
INSERT INTO LECCIONES VALUES(6,1,'Examen',false);


--Insert preguntas leccion 1 java
INSERT INTO PREGUNTAS VALUES(1,1,'¿Cómo se declara una variable de tipo entero?','int num;','num int;','float num;','num = 12;','resp1');
INSERT INTO PREGUNTAS VALUES(2,1,'¿Cómo se declara una cadena de caracteres?','String cadena;','string cadena','char cadena;','Character cadena;','resp1');
INSERT INTO PREGUNTAS VALUES(3,1,'¿Cuál de estas variables son de referencia?','int num;','float num;','String cadena;','double num;','resp3');

--Insert preguntas leccion 2 java
INSERT INTO PREGUNTAS VALUES(4,2,'¿Cómo se suma un número?','num =+ 12;','num + 6;','num = num + 3','num == 21','resp3');
INSERT INTO PREGUNTAS VALUES(5,2,'¿Cómo se saca el resto de una división?','int num = 11/2;','int num /= 2;','int num =% 3;','int num = 4 % 0;','resp4');
INSERT INTO PREGUNTAS VALUES(6,2,'¿Cómo multiplicamos?','num = num * 1.24;','num *- 2;','num = num','num ^ 2;','resp1');

--Insert preguntas leccion 3 java
INSERT INTO PREGUNTAS VALUES(7,3,'¿Cómo se saca el resto de una división?','int num = 11/2;','int num /= 2;','int num =% 3;','int num = 4 % 0;','resp4');
INSERT INTO PREGUNTAS VALUES(8,3,'¿Cuál de estas variables son de referencia?','int num;','float num;','String cadena;','double num;','resp3');
INSERT INTO PREGUNTAS VALUES(9,3,'¿Cómo multiplicamos?','num = num * 1.24;','num *- 2;','num = num','num ^ 2;','resp1');

--Insert preguntas leccion 4 java
INSERT INTO PREGUNTAS VALUES(10,4,'¿Cómo indicamos que num es mayor que num2?','num > num2','num = num2','num <= num2','num != num2','resp1');
INSERT INTO PREGUNTAS VALUES(11,4,'¿Cómo comprobamos que num es igual a num2?','num = num2','num >= num2','num == num2','num += num2','resp3');
INSERT INTO PREGUNTAS VALUES(12,4,'¿Cómo se niega?','num == 0','num =! 0','num != 0','num = 0','resp3');

--Insert preguntas leccion 5 java
INSERT INTO PREGUNTAS VALUES(13,5,'¿Cómo escribimos un bucle while?','while(int i = 0; i < 10; i++)','while(x < 10)','while(x > 10; x--)','while(x =!= 10)','resp3');
INSERT INTO PREGUNTAS VALUES(14,5,'¿Deberíamos declarar variables en bucles?','Si, es lo correcto','No, no queremos llenar la memoria','Depende del caso','Todas son correctas','resp2');
INSERT INTO PREGUNTAS VALUES(15,5,'¿Cómo escribimos un bucle for?','for(int i = 0; 0 < 10; i++)','for(int i; i < 10; i++)','for(int i = 0; i < 10; i--)','for(int i = 0; i < 10; i++)','resp4');

--Insert preguntas leccion 6 java
INSERT INTO PREGUNTAS VALUES(16,6,'¿Cómo comprobamos que num es igual a num2?','num = num2','num >= num2','num == num2','num += num2','resp3');
INSERT INTO PREGUNTAS VALUES(17,6,'¿Cómo escribimos un bucle for?','for(int i = 0; 0 < 10; i++)','for(int i; i < 10; i++)','for(int i = 0; i < 10; i--)','for(int i = 0; i < 10; i++)','resp4');
INSERT INTO PREGUNTAS VALUES(18,6,'¿Cómo se niega?','num == 0','num =! 0','num != 0','num = 0','resp3');


--SQL
--Insert lecciones de sql
INSERT INTO LECCIONES VALUES(7,2,'Creacion tablas',false);
INSERT INTO LECCIONES VALUES(8,2,'Constraints',false);
INSERT INTO LECCIONES VALUES(9,2,'Repaso',false);
INSERT INTO LECCIONES VALUES(10,2,'Alter table/Insert into',false);
INSERT INTO LECCIONES VALUES(11,2,'Update/Delete',false);
INSERT INTO LECCIONES VALUES(12,2,'Examen',false);


--Insert preguntas leccion 1 sql
INSERT INTO PREGUNTAS VALUES(19,7,'¿Qué comando se utiliza para crear una nueva tabla en SQL?','INSERT INTO','UPDATE','CREATE TABLE','ALTER TABLE','resp3');
INSERT INTO PREGUNTAS VALUES(20,7,'¿Cuál de los siguientes tipos de datos se pueden utilizar al definir columnas en una tabla?','VARCHAR2','BOOLEAN','NUMBER','Todos son correctos','resp4');
INSERT INTO PREGUNTAS VALUES(21,7,'¿Con qué comando se elimina una tabla?','DROP TABLE','REMOVE TABLE','DELETE TABLE','TRUNCATE TABLE','resp1');

--Insert preguntas leccion 2 sql
INSERT INTO PREGUNTAS VALUES(22,8,'¿Cuál de los siguientes constraints garantiza que los valores en una columna sean diferentes entre sí?','NOT NULL','UNIQUE','CHECK','FOREIGN KEY','resp2');
INSERT INTO PREGUNTAS VALUES(23,8,'¿Qué constraint se utiliza para asegurar que una columna no pueda NO tener un valor?','CHECK','DEFAULT','NOT NULL','Todas son correctas','resp3');
INSERT INTO PREGUNTAS VALUES(24,8,'¿Cuál de las siguientes restricciones se aplica a toda la tabla, y no sólo a una columna específica?','NOT NULL','UNIQUE','PRIMARY KEY','CHECK','resp3');

--Insert preguntas leccion 3 sql
INSERT INTO PREGUNTAS VALUES(25,9,'¿Cuál de las siguientes restricciones se aplica a toda la tabla, y no sólo a una columna específica?','NOT NULL','UNIQUE','PRIMARY KEY','CHECK','resp3');
INSERT INTO PREGUNTAS VALUES(26,9,'¿Con qué comando se elimina una tabla?','DROP TABLE','REMOVE TABLE','DELETE TABLE','TRUNCATE TABLE','resp1');
INSERT INTO PREGUNTAS VALUES(27,9,'¿Cuál de los siguientes tipos de datos se pueden utilizar al definir columnas en una tabla?','VARCHAR2','BOOLEAN','NUMBER','Todos son correctos','resp4');

--Insert preguntas leccion 4 sql
INSERT INTO PREGUNTAS VALUES(28,10,'¿Qué hace el siguiente código? : ALTER TABLE Clientes ADD Email VARCHAR2(255);','Elimina la columna "Email" de la tabla "Clientes"','Agrega la columna "Clientes" a la tabla "Email"','Elimina la columna "Clientes" de la tabla "Email"','Agrega la columna "Email" a la tabla "Clientes"','resp4');
INSERT INTO PREGUNTAS VALUES(29,10,'¿Cómo insertamos el siguiente registro a la tabla "Orders"? : ID = 101, CustomerID = 5, OrderDate = "2024-04-15", TotalAmount = 150.50','INSERT INTO Orders (ID, CustomerID, OrderDate, TotalAmount) VALUES (101, 5, "2024-04-15", 150.50);','INSERT INTO Orders (CustomerID, OrderDate, TotalAmount) VALUES (5, "2024-04-15", 150.50);','INSERT INTO Orders (ID, CustomerID, OrderDate, TotalAmount) SELECT 101, 5, "2024-04-15", 150.50;','INSERT INTO Orders (CustomerID, ID, OrderDate, TotalAmount) VALUES (101, 5, "2024-04-15", 150.50);','resp1');
INSERT INTO PREGUNTAS VALUES(30,10,'¿Qué hace este código? : ALTER TABLE Paquete MODIFY Matricula VARCHAR2(7);','Crea una columna "Matrícula" de tipo VARCHAR2(7)','Cambia el nombre de la tabla a "Matrícula"','Modifica el tipo de datos de "Matrícula" a VARCHAR2(7)','No hace nada, el código es erróneo','resp3');


--Insert preguntas leccion 5 sql
INSERT INTO PREGUNTAS VALUES(31,11,'¿Cuál es la sintaxis correcta para actualizar la edad de un usuario llamado “Juan” en una tabla llamada “Usuarios”?','UPDATE Usuarios SET edad = 30 WHERE nombre = ”Juan”;','DELETE From Usuarios SET edad = 30 WHERE nombre = “Juan”;','UPDATE Usuarios SET edad = 30 IF nombre = “Juan”;','MODIFY Usuarios SET edad = 30 WHERE nombre = “Juan”;','resp1');
INSERT INTO PREGUNTAS VALUES(32,11,'¿Qué pasa si te olvidas el “WHERE” al poner una instrucción DELETE?','La instrucción fallará y no se eliminará ninguna fila','Solo se eliminará la primera fila de la tabla','Se eliminará la última fila de la tabla','Se eliminarán todas las filas de la tabla','resp1');
INSERT INTO PREGUNTAS VALUES(33,11,'¿Qué resultado obtendrás al ejecutar la siguiente instrucción DELETE? UPDATE Empleados SET salario = salario * 1.10 WHERE departamento_id = 3 AND salario < 3000;','Aumenta el salario de todos los empleados en un 10%.','Aumenta el salario en un 10% solo para los empleados del departamento con id 3 que ganen menos de 3000.','Aumenta el salario en un 10% a los empleados que ganen menos de 3000','Establece el salario de todos los empleados a 3000.','resp2');


--Insert preguntas leccion 6 sql
INSERT INTO PREGUNTAS VALUES(34,12,'¿Qué hace el siguiente código? : ALTER TABLE Clientes ADD Email VARCHAR2(255);','Elimina la columna "Email" de la tabla "Clientes"','Agrega la columna "Clientes" a la tabla "Email"','Elimina la columna "Clientes" de la tabla "Email"','Agrega la columna "Email" a la tabla "Clientes"','resp4');
INSERT INTO PREGUNTAS VALUES(35,12,'¿Qué resultado obtendrás al ejecutar la siguiente instrucción DELETE? UPDATE Empleados SET salario = salario * 1.10 WHERE departamento_id = 3 AND salario < 3000;','Aumenta el salario de todos los empleados en un 10%.','Aumenta el salario en un 10% solo para los empleados del departamento con id 3 que ganen menos de 3000.','Aumenta el salario en un 10% a los empleados que ganen menos de 3000','Establece el salario de todos los empleados a 3000.','resp2');
INSERT INTO PREGUNTAS VALUES(36,12,'¿Cómo insertamos el siguiente registro a la tabla "Orders"? : ID = 101, CustomerID = 5, OrderDate = "2024-04-15", TotalAmount = 150.50','INSERT INTO Orders (ID, CustomerID, OrderDate, TotalAmount) VALUES (101, 5, "2024-04-15", 150.50);','INSERT INTO Orders (CustomerID, OrderDate, TotalAmount) VALUES (5, "2024-04-15", 150.50);','INSERT INTO Orders (ID, CustomerID, OrderDate, TotalAmount) SELECT 101, 5, "2024-04-15", 150.50;','INSERT INTO Orders (CustomerID, ID, OrderDate, TotalAmount) VALUES (101, 5, "2024-04-15", 150.50);','resp1');



--HTML

--Insert lecciones de html
INSERT INTO LECCIONES VALUES(13,3,'Estructura basica',false);
INSERT INTO LECCIONES VALUES(14,3,'Listas',false);
INSERT INTO LECCIONES VALUES(15,3,'Repaso',false);
INSERT INTO LECCIONES VALUES(16,3,'Enlaces',false);
INSERT INTO LECCIONES VALUES(17,3,'Formularios',false);
INSERT INTO LECCIONES VALUES(18,3,'Examen',false);


--Insert preguntas leccion 1 html
INSERT INTO PREGUNTAS VALUES(37,13,'¿Cuál de estas etiquetas HTML no tiene cierre?','<body>','<a>','<br>','<strong>','resp3');
INSERT INTO PREGUNTAS VALUES(38,13,'¿Cuál de estas etiquetas sirve para insertar una imagen?','<a>','<Photo>','<png>','<img>','resp4');
INSERT INTO PREGUNTAS VALUES(39,13,'¿Html es considerado como?','Un lenguaje de programación','Lenguaje de marcado de hipertexto','Un framework','Una extensión de java Script','resp2');


--Insert preguntas leccion 2 html
INSERT INTO PREGUNTAS VALUES(40,14,'¿Cuál de estas etiquetas HTML se utiliza para crear una lista desordenada?','<ol>','<ul>','<li>','<dl>','resp2');
INSERT INTO PREGUNTAS VALUES(41,14,'¿Cuál de estas etiquetas HTML se utiliza para crear un elemento de lista?','<ul>','<ol>','<li>','<dl>','resp3');
INSERT INTO PREGUNTAS VALUES(42,14,'¿Cuál de estas etiquetas HTML se utiliza para crear una fila de tabla?','<table>','<tr>','<td>','<th>','resp2');



--Insert preguntas leccion 3 html
INSERT INTO PREGUNTAS VALUES(43,15,'¿Cuál de estas etiquetas HTML no tiene cierre?','<body>','<a>','<br>','<strong>','resp3');
INSERT INTO PREGUNTAS VALUES(44,15,'¿Cuál de estas etiquetas HTML se utiliza para crear una lista desordenada?','<ol>','<ul>','<li>','<dl>','resp2');
INSERT INTO PREGUNTAS VALUES(45,15,'¿Html es considerado como?','Un lenguaje de programación','Lenguaje de marcado de hipertexto','Un framework','Una extensión de java Script','resp2');


--Insert preguntas leccion 4 html
INSERT INTO PREGUNTAS VALUES(46,16,'¿Se puede abrir un enlace en una nueva pestaña del navegador en HTML?','Usando el atributo "new" en la etiqueta <a>','Usando el atributo "blank" en la etiqueta <a>','Usando el atributo "tab" en la etiqueta <a>','Usando el atributo "target" con el valor "_blank" en la etiqueta <a>','resp4');
INSERT INTO PREGUNTAS VALUES(47,16,'¿Cómo harías que un enlace descargue un archivo en lugar de abrirlo en el navegador en HTML?','Usando el atributo "download" en la etiqueta <a>','Usando el atributo "href" con el valor "download" en la etiqueta <a>','Usando el atributo "target" con el valor "_download" en la etiqueta <a>','Usando el atributo "rel" con el valor "download" en la etiqueta <a>','resp1');
INSERT INTO PREGUNTAS VALUES(48,16,'¿Sabes cómo se puede hacer que un enlace sea no seguido por los motores de búsqueda en HTML?','Usando el atributo "nofollow" en la etiqueta <a>','Usando el atributo "noindex" en la etiqueta <a>','Usando el atributo "rel" con el valor "nofollow" en la etiqueta <a>','Usando el atributo "rel" con el valor "noindex" en la etiqueta <a>','resp3');


--Insert preguntas leccion 5 html
INSERT INTO PREGUNTAS VALUES(49,17,'¿Qué atributo de la etiqueta <form> especifica dónde enviar los datos del formulario cuando se envía?','method','action','target','enctype','resp2');
INSERT INTO PREGUNTAS VALUES(50,17,'¿Qué valor del atributo "type" en la etiqueta <input> se usa para campos de entrada ocultos?','hidden','password','submit','reset','resp1');
INSERT INTO PREGUNTAS VALUES(51,17,'¿Qué etiqueta se usa para crear una lista desplegable en un formulario?','<input>','<select>','<option>','<list>','resp2');


--Insert preguntas leccion 6 html
INSERT INTO PREGUNTAS VALUES(52,18,'¿Qué valor del atributo "type" en la etiqueta <input> se usa para campos de entrada ocultos?','hidden','password','submit','reset','resp1');
INSERT INTO PREGUNTAS VALUES(53,18,'¿Cómo harías que un enlace descargue un archivo en lugar de abrirlo en el navegador en HTML?','Usando el atributo "download" en la etiqueta <a>','Usando el atributo "href" con el valor "download" en la etiqueta <a>','Usando el atributo "target" con el valor "_download" en la etiqueta <a>','Usando el atributo "rel" con el valor "download" en la etiqueta <a>','resp1');
INSERT INTO PREGUNTAS VALUES(54,18,'¿Qué etiqueta se usa para crear una lista desplegable en un formulario?','<input>','<select>','<option>','<list>','resp2');



--CSS

--Insert lecciones de css
INSERT INTO LECCIONES VALUES(19,4,'Inicio CSS',false);
INSERT INTO LECCIONES VALUES(20,4,'Estructura CSS',false);
INSERT INTO LECCIONES VALUES(21,4,'Repaso',false);
INSERT INTO LECCIONES VALUES(22,4,'Colores',false);
INSERT INTO LECCIONES VALUES(23,4,'Medidas Posicionamiento',false);
INSERT INTO LECCIONES VALUES(24,4,'Examen',false);


--Insert preguntas leccion 1 css
INSERT INTO PREGUNTAS VALUES(55,19,'¿Qué es CSS?','Un lenguaje de programación utilizado para crear páginas web interactivas.','Un protocolo de comunicación utilizado para transferir datos entre servidores y clientes.','Un conjunto de reglas y estilos utilizados para definir el aspecto y el diseño de páginas web','Un estándar de codificación utilizado para escribir aplicaciones móviles nativas','resp3');
INSERT INTO PREGUNTAS VALUES(56,19,'¿Cómo se llama lo que se encuentra dentro de “{}” ? h1 {color: #FF0000; background: #00FF00}','Propiedades','Selector','Valores','Declaración','resp4');
INSERT INTO PREGUNTAS VALUES(57,19,'¿Qué tipo de hoja de estilo es CSS?','Cascada ','XSL','LESS','SASS','resp1');


--Insert preguntas leccion 2 css
INSERT INTO PREGUNTAS VALUES(58,20,'¿Para qué sirve este código: <head> <link rel="stylesheet" type="text/css" href="estilos.css" /> </head>?','Para insertar un script JavaScript en el encabezado de la página.','Para agregar una imagen de fondo a la página web.','Para vincular una hoja de estilos externa a la página HTML','Para cargar una fuente personalizada en la página web','resp3');
INSERT INTO PREGUNTAS VALUES(59,20,'¿A qué referencio poniendo “.” antes que un selector?','A un elemento HTML',' A una clase CSS','A un identificador único','A un selector de atributo','resp2');
INSERT INTO PREGUNTAS VALUES(60,20,'¿A qué referencio poniendo “#” antes que un selector?','A un elemento HTML','A una clase CSS','A un id','A un selector de atributo','resp3');


--Insert preguntas leccion 3 css
INSERT INTO PREGUNTAS VALUES(61,21,'¿A qué referencio poniendo “#” antes que un selector?','A un elemento HTML','A una clase CSS','A un id','A un selector de atributo','resp3');
INSERT INTO PREGUNTAS VALUES(62,21,'¿Cómo se llama lo que se encuentra dentro de “{}” ? h1 {color: #FF0000; background: #00FF00}','Propiedades','Selector','Valores','Declaración','resp4');
INSERT INTO PREGUNTAS VALUES(63,21,'¿Qué tipo de hoja de estilo es CSS?','Cascada ','XSL','LESS','SASS','resp1');


--Insert preguntas leccion 4 css
INSERT INTO PREGUNTAS VALUES(64,22,'¿Para qué sirve esta propiedad “color”?','Saber qué color tiene el fondo','Establece un color seleccionado a la fuente','Para cambiar el color del fondo','Te colorea la página web','resp2');
INSERT INTO PREGUNTAS VALUES(65,22,'¿En qué formato se expresa un color en CSS?','Hexadecimal','RGB','Todas son correctas','Nombre del color','resp3');
INSERT INTO PREGUNTAS VALUES(66,22,'¿Cuál de las siguientes propiedades CSS se utiliza para establecer el color de fondo de un elemento HTML?','color','font-family','background-color','text-decoration','resp3');


--Insert preguntas leccion 5 css
INSERT INTO PREGUNTAS VALUES(67,23,'¿Cual NO es una medida absoluta de longitud en CSS?','cm','qx','pt','px','resp1');
INSERT INTO PREGUNTAS VALUES(68,23,'¿Cual NO es una propiedad de dimensión?','min-size','max-high','width','height','resp1');
INSERT INTO PREGUNTAS VALUES(69,23,'¿Dónde se puede usar width y height?','En un botón','En una imagen','En un div','Todas son correctas','resp4');


--Insert preguntas leccion 6 css
INSERT INTO PREGUNTAS VALUES(70,24,'¿Cual NO es una medida absoluta de longitud en CSS?','cm','qx','pt','px','resp1');
INSERT INTO PREGUNTAS VALUES(71,24,'¿En qué formato se expresa un color en CSS?','Hexadecimal','RGB','Todas son correctas','Nombre del color','resp3');
INSERT INTO PREGUNTAS VALUES(72,24,'¿Para qué sirve esta propiedad “color”?','Saber qué color tiene el fondo','Establece un color seleccionado a la fuente','Para cambiar el color del fondo','Te colorea la página web','resp2');


--ARREGLOS BBDD
UPDATE PREGUNTAS SET CORRECTA = 'resp2' WHERE id_pregunta = 67;

DROP TABLE USUARIOS;

CREATE TABLE USUARIOS(
    ID_USUARIO INTEGER PRIMARY KEY AUTOINCREMENT,
    NICK VARCHAR2(30) CONSTRAINT UQ_USUARIOS_NICK UNIQUE,
    EMAIL VARCHAR2(40) CONSTRAINT UQ_USUARIOS_EMAIL UNIQUE,
    FOTO_PERFIL VARCHAR2(50),
    MONEDAS INT(6),
    CONTRASENIA VARCHAR2(20)
);

DROP TABLE USUARIOS;

CREATE TABLE USUARIOS(
    ID_USUARIO INTEGER PRIMARY KEY AUTOINCREMENT,
    NICK VARCHAR2(30),
    EMAIL VARCHAR2(40) CONSTRAINT UQ_USUARIOS_EMAIL UNIQUE,
    FOTO_PERFIL VARCHAR2(50),
    MONEDAS INT(6),
    CONTRASENIA VARCHAR2(20)
);

DROP TABLE TIENDA;

CREATE TABLE TIENDA(
    ID_OBJETO NUMBER(2) CONSTRAINT PK_TIENDA_IDOBJ PRIMARY KEY,
    NOM_OBJETO VARCHAR2(20),
    PRECIO NUMBER(3),
    ICONO VARCHAR2(50),
    COMPRADA BOOLEAN
);

-- --Insert tienda
INSERT INTO TIENDA VALUES(1,'Objeto1',500,'', false);
INSERT INTO TIENDA VALUES(2,'Objeto2',600,'', false);
INSERT INTO TIENDA VALUES(3,'Objeto3',500,'', false);
INSERT INTO TIENDA VALUES(4,'Objeto4',500,'', false);
INSERT INTO TIENDA VALUES(5,'Objeto5',1000,'', false);
INSERT INTO TIENDA VALUES(6,'Objeto6',700,'', false);

DROP TABLE USUARIOS_PREGUNTAS;

CREATE TABLE USUARIOS_PREGUNTAS(
    ID_USUARIO NUMBER(3),
    ID_PREGUNTA NUMBER(3),
    PUNTOS NUMBER(3),
    ACERTADO BOOLEAN,
    CONSTRAINT PK_USERPREG_IDUSERIDPREG PRIMARY KEY (ID_USUARIO, ID_PREGUNTA),
    CONSTRAINT FK_USERPREG_IDUSER FOREIGN KEY (ID_USUARIO) REFERENCES USUARIOS(ID_USUARIO),
    CONSTRAINT FK_USERPREG_IDPREG FOREIGN KEY (ID_PREGUNTA) REFERENCES USUARIOS(ID_PREGUNTA)
);

DROP TABLE USUARIOS_PREGUNTAS;

CREATE TABLE USUARIOS_PREGUNTAS(
    ID_USUARIO INTEGER,
    ID_PREGUNTA NUMBER(3),
    PUNTOS NUMBER(3),
    ACERTADO BOOLEAN,
    CONSTRAINT PK_USERPREG_IDUSERIDPREG PRIMARY KEY (ID_USUARIO, ID_PREGUNTA),
    CONSTRAINT FK_USERPREG_IDUSER FOREIGN KEY (ID_USUARIO) REFERENCES USUARIOS(ID_USUARIO),
    CONSTRAINT FK_USERPREG_IDPREG FOREIGN KEY (ID_PREGUNTA) REFERENCES USUARIOS(ID_PREGUNTA)
);

INSERT INTO USUARIOS(NICK, EMAIL, FOTO_PERFIL, MONEDAS, CONTRASENIA) VALUES('Fernando', 'usuario1@prueba.com','img/Imagen5CustomButton.png',100,'usuarioprueba1');
INSERT INTO USUARIOS(NICK, EMAIL, FOTO_PERFIL, MONEDAS, CONTRASENIA) VALUES('Pepe', 'usuario2@prueba.com','img/Imagen5CustomButton.png',200,'usuarioprueba2');
INSERT INTO USUARIOS(NICK, EMAIL, FOTO_PERFIL, MONEDAS, CONTRASENIA) VALUES('Sara', 'usuario3@prueba.com','img/Imagen5CustomButton.png',300,'usuarioprueba2');

DROP TABLE USUARIOS_PREGUNTAS;

CREATE TABLE USUARIOS_PREGUNTAS(
    ID_USUARIO INTEGER,
    ID_PREGUNTA NUMBER(3),
    PUNTOS NUMBER(3),
    NUM_INTENTOS INTEGER,
    TIPO_TEST TEXT,
    CONSTRAINT PK_USERPREG_IDUSERIDPREG PRIMARY KEY (ID_USUARIO, ID_PREGUNTA),
    CONSTRAINT FK_USERPREG_IDUSER FOREIGN KEY (ID_USUARIO) REFERENCES USUARIOS(ID_USUARIO),
    CONSTRAINT FK_USERPREG_IDPREG FOREIGN KEY (ID_PREGUNTA) REFERENCES PREGUNTAS(ID_PREGUNTA)
);

UPDATE TIENDA SET ICONO = '/img/Imagen1Tienda.jpeg' WHERE ID_OBJETO = 1;
UPDATE TIENDA SET ICONO = '/img/Imagen2Tienda.jpeg' WHERE ID_OBJETO = 2;
UPDATE TIENDA SET ICONO = '/img/Imagen3Tienda.jpeg' WHERE ID_OBJETO = 3;
UPDATE TIENDA SET ICONO = '/img/Imagen4Tienda.jpeg' WHERE ID_OBJETO = 4;
UPDATE TIENDA SET ICONO = '/img/Imagen5Tienda.jpeg' WHERE ID_OBJETO = 5;
UPDATE TIENDA SET ICONO = '/img/Imagen6Tienda.jpeg' WHERE ID_OBJETO = 6;

DROP TABLE PREGUNTAS;

CREATE TABLE PREGUNTAS(
    ID_PREGUNTA NUMBER(3) CONSTRAINT PK_PREGUNTAS_IDPREG PRIMARY KEY,
    ID_LECCION NUMBER(2) CONSTRAINT FK_PREGUNTAS_IDLEC REFERENCES PREGUNTAS(ID_LECCION),
    PREGUNTA VARCHAR2(200),
    RESP1 VARCHAR2(100),
    RESP2 VARCHAR2(100),
    RESP3 VARCHAR2(100),
    RESP4 VARCHAR2(100),
    CORRECTA VARCHAR2(100)
);


--Insert preguntas leccion 1 java
INSERT INTO PREGUNTAS VALUES(1,1,'¿Cómo se declara una variable de tipo entero?','int num;','num int;','float num;','num = 12;','int num;'); 
INSERT INTO PREGUNTAS VALUES(2,1,'¿Cómo se declara una cadena de caracteres?','String cadena;','string cadena','char cadena;','Character cadena;','String cadena;');
INSERT INTO PREGUNTAS VALUES(3,1,'¿Cuál de estas variables son de referencia?','int num;','float num;','String cadena;','double num;','String cadena;');

--Insert preguntas leccion 2 java
INSERT INTO PREGUNTAS VALUES(4,2,'¿Cómo se suma un número?','num =+ 12;','num + 6;','num = num + 3','num == 21','num = num + 3');
INSERT INTO PREGUNTAS VALUES(5,2,'¿Cómo se saca el resto de una división?','int num = 11/2;','int num /= 2;','int num =% 3;','int num = 4 % 0;','int num = 4 % 0;');
INSERT INTO PREGUNTAS VALUES(6,2,'¿Cómo multiplicamos?','num = num * 1.24;','num *- 2;','num = num','num ^ 2;','num = num * 1.24;');

--Insert preguntas leccion 3 java
INSERT INTO PREGUNTAS VALUES(7,3,'¿Cómo se saca el resto de una división?','int num = 11/2;','int num /= 2;','int num =% 3;','int num = 4 % 0;','int num = 4 % 0;');
INSERT INTO PREGUNTAS VALUES(8,3,'¿Cuál de estas variables son de referencia?','int num;','float num;','String cadena;','double num;','String cadena;');
INSERT INTO PREGUNTAS VALUES(9,3,'¿Cómo multiplicamos?','num = num * 1.24;','num *- 2;','num = num','num ^ 2;','num = num * 1.24;');

--Insert preguntas leccion 4 java
INSERT INTO PREGUNTAS VALUES(10,4,'¿Cómo indicamos que num es mayor que num2?','num > num2','num = num2','num <= num2','num != num2','num > num2');
INSERT INTO PREGUNTAS VALUES(11,4,'¿Cómo comprobamos que num es igual a num2?','num = num2','num >= num2','num == num2','num += num2','num == num2');
INSERT INTO PREGUNTAS VALUES(12,4,'¿Cómo se niega?','num == 0','num =! 0','num != 0','num = 0','num != 0');

--Insert preguntas leccion 5 java
INSERT INTO PREGUNTAS VALUES(13,5,'¿Cómo escribimos un bucle while?','while(int i = 0; i < 10; i++)','while(x < 10)','while(x > 10; x--)','while(x =!= 10)','while(x > 10; x--)');
INSERT INTO PREGUNTAS VALUES(14,5,'¿Deberíamos declarar variables en bucles?','Si, es lo correcto','No, no queremos llenar la memoria','Depende del caso','Todas son correctas','No, no queremos llenar la memoria');
INSERT INTO PREGUNTAS VALUES(15,5,'¿Cómo escribimos un bucle for?','for(int i = 0; 0 < 10; i++)','for(int i; i < 10; i++)','for(int i = 0; i < 10; i--)','for(int i = 0; i < 10; i++)','for(int i = 0; i < 10; i++)');

--Insert preguntas leccion 6 java
INSERT INTO PREGUNTAS VALUES(16,6,'¿Cómo comprobamos que num es igual a num2?','num = num2','num >= num2','num == num2','num += num2','num == num2');
INSERT INTO PREGUNTAS VALUES(17,6,'¿Cómo escribimos un bucle for?','for(int i = 0; 0 < 10; i++)','for(int i; i < 10; i++)','for(int i = 0; i < 10; i--)','for(int i = 0; i < 10; i++)','for(int i = 0; i < 10; i++)');
INSERT INTO PREGUNTAS VALUES(18,6,'¿Cómo se niega?','num == 0','num =! 0','num != 0','num = 0','num != 0');






--Insert preguntas leccion 1 sql
INSERT INTO PREGUNTAS VALUES(19,7,'¿Qué comando se utiliza para crear una nueva tabla en SQL?','INSERT INTO','UPDATE','CREATE TABLE','ALTER TABLE','CREATE TABLE');
INSERT INTO PREGUNTAS VALUES(20,7,'¿Cuál de los siguientes tipos de datos se pueden utilizar al definir columnas en una tabla?','VARCHAR2','BOOLEAN','NUMBER','Todos son correctos','Todos son correctos');
INSERT INTO PREGUNTAS VALUES(21,7,'¿Con qué comando se elimina una tabla?','DROP TABLE','REMOVE TABLE','DELETE TABLE','TRUNCATE TABLE','DROP TABLE');

--Insert preguntas leccion 2 sql
INSERT INTO PREGUNTAS VALUES(22,8,'¿Cuál de los siguientes constraints garantiza que los valores en una columna sean diferentes entre sí?','NOT NULL','UNIQUE','CHECK','FOREIGN KEY','UNIQUE');
INSERT INTO PREGUNTAS VALUES(23,8,'¿Qué constraint se utiliza para asegurar que una columna no pueda NO tener un valor?','CHECK','DEFAULT','NOT NULL','Todas son correctas','NOT NULL');
INSERT INTO PREGUNTAS VALUES(24,8,'¿Cuál de las siguientes restricciones se aplica a toda la tabla, y no sólo a una columna específica?','NOT NULL','UNIQUE','PRIMARY KEY','CHECK','PRIMARY KEY');

--Insert preguntas leccion 3 sql
INSERT INTO PREGUNTAS VALUES(25,9,'¿Cuál de las siguientes restricciones se aplica a toda la tabla, y no sólo a una columna específica?','NOT NULL','UNIQUE','PRIMARY KEY','CHECK','PRIMARY KEY');
INSERT INTO PREGUNTAS VALUES(26,9,'¿Con qué comando se elimina una tabla?','DROP TABLE','REMOVE TABLE','DELETE TABLE','TRUNCATE TABLE','DROP TABLE');
INSERT INTO PREGUNTAS VALUES(27,9,'¿Cuál de los siguientes tipos de datos se pueden utilizar al definir columnas en una tabla?','VARCHAR2','BOOLEAN','NUMBER','Todos son correctos','Todos son correctos');

--Insert preguntas leccion 4 sql
INSERT INTO PREGUNTAS VALUES(28,10,'¿Qué hace el siguiente código? : ALTER TABLE Clientes ADD Email VARCHAR2(255);','Elimina la columna "Email" de la tabla "Clientes"','Agrega la columna "Clientes" a la tabla "Email"','Elimina la columna "Clientes" de la tabla "Email"','Agrega la columna "Email" a la tabla "Clientes"','Agrega la columna "Email" a la tabla "Clientes"');
INSERT INTO PREGUNTAS VALUES(29,10,'¿Cómo insertamos el siguiente registro a la tabla "Orders"? : ID = 101, CustomerID = 5, OrderDate = "2024-04-15", TotalAmount = 150.50','INSERT INTO Orders (ID, CustomerID, OrderDate, TotalAmount) VALUES (101, 5, "2024-04-15", 150.50);','INSERT INTO Orders (CustomerID, OrderDate, TotalAmount) VALUES (5, "2024-04-15", 150.50);','INSERT INTO Orders (ID, CustomerID, OrderDate, TotalAmount) SELECT 101, 5, "2024-04-15", 150.50;','INSERT INTO Orders (CustomerID, ID, OrderDate, TotalAmount) VALUES (101, 5, "2024-04-15", 150.50);','INSERT INTO Orders (ID, CustomerID, OrderDate, TotalAmount) VALUES (101, 5, "2024-04-15", 150.50);');
INSERT INTO PREGUNTAS VALUES(30,10,'¿Qué hace este código? : ALTER TABLE Paquete MODIFY Matricula VARCHAR2(7);','Crea una columna "Matrícula" de tipo VARCHAR2(7)','Cambia el nombre de la tabla a "Matrícula"','Modifica el tipo de datos de "Matrícula" a VARCHAR2(7)','No hace nada, el código es erróneo','Modifica el tipo de datos de "Matrícula" a VARCHAR2(7)');


--Insert preguntas leccion 5 sql
INSERT INTO PREGUNTAS VALUES(31,11,'¿Cuál es la sintaxis correcta para actualizar la edad de un usuario llamado “Juan” en una tabla llamada “Usuarios”?','UPDATE Usuarios SET edad = 30 WHERE nombre = ”Juan”;','DELETE From Usuarios SET edad = 30 WHERE nombre = “Juan”;','UPDATE Usuarios SET edad = 30 IF nombre = “Juan”;','MODIFY Usuarios SET edad = 30 WHERE nombre = “Juan”;','UPDATE Usuarios SET edad = 30 WHERE nombre = ”Juan”;');
INSERT INTO PREGUNTAS VALUES(32,11,'¿Qué pasa si te olvidas el “WHERE” al poner una instrucción DELETE?','La instrucción fallará y no se eliminará ninguna fila','Solo se eliminará la primera fila de la tabla','Se eliminará la última fila de la tabla','Se eliminarán todas las filas de la tabla','La instrucción fallará y no se eliminará ninguna fila');
INSERT INTO PREGUNTAS VALUES(33,11,'¿Qué resultado obtendrás al ejecutar la siguiente instrucción DELETE? UPDATE Empleados SET salario = salario * 1.10 WHERE departamento_id = 3 AND salario < 3000;','Aumenta el salario de todos los empleados en un 10%.','Aumenta el salario en un 10% solo para los empleados del departamento con id 3 que ganen menos de 3000.','Aumenta el salario en un 10% a los empleados que ganen menos de 3000','Establece el salario de todos los empleados a 3000.','Aumenta el salario en un 10% solo para los empleados del departamento con id 3 que ganen menos de 3000.');


--Insert preguntas leccion 6 sql
INSERT INTO PREGUNTAS VALUES(34,12,'¿Qué hace el siguiente código? : ALTER TABLE Clientes ADD Email VARCHAR2(255);','Elimina la columna "Email" de la tabla "Clientes"','Agrega la columna "Clientes" a la tabla "Email"','Elimina la columna "Clientes" de la tabla "Email"','Agrega la columna "Email" a la tabla "Clientes"','Agrega la columna "Email" a la tabla "Clientes"');
INSERT INTO PREGUNTAS VALUES(35,12,'¿Qué resultado obtendrás al ejecutar la siguiente instrucción DELETE? UPDATE Empleados SET salario = salario * 1.10 WHERE departamento_id = 3 AND salario < 3000;','Aumenta el salario de todos los empleados en un 10%.','Aumenta el salario en un 10% solo para los empleados del departamento con id 3 que ganen menos de 3000.','Aumenta el salario en un 10% a los empleados que ganen menos de 3000','Establece el salario de todos los empleados a 3000.','Aumenta el salario en un 10% solo para los empleados del departamento con id 3 que ganen menos de 3000.');
INSERT INTO PREGUNTAS VALUES(36,12,'¿Cómo insertamos el siguiente registro a la tabla "Orders"? : ID = 101, CustomerID = 5, OrderDate = "2024-04-15", TotalAmount = 150.50','INSERT INTO Orders (ID, CustomerID, OrderDate, TotalAmount) VALUES (101, 5, "2024-04-15", 150.50);','INSERT INTO Orders (CustomerID, OrderDate, TotalAmount) VALUES (5, "2024-04-15", 150.50);','INSERT INTO Orders (ID, CustomerID, OrderDate, TotalAmount) SELECT 101, 5, "2024-04-15", 150.50;','INSERT INTO Orders (CustomerID, ID, OrderDate, TotalAmount) VALUES (101, 5, "2024-04-15", 150.50);','INSERT INTO Orders (ID, CustomerID, OrderDate, TotalAmount) VALUES (101, 5, "2024-04-15", 150.50);');






--Insert preguntas leccion 1 html
INSERT INTO PREGUNTAS VALUES(37,13,'¿Cuál de estas etiquetas HTML no tiene cierre?','<body>','<a>','<br>','<strong>','<br>');
INSERT INTO PREGUNTAS VALUES(38,13,'¿Cuál de estas etiquetas sirve para insertar una imagen?','<a>','<Photo>','<png>','<img>','<img>');
INSERT INTO PREGUNTAS VALUES(39,13,'¿Html es considerado como?','Un lenguaje de programación','Lenguaje de marcado de hipertexto','Un framework','Una extensión de java Script','Lenguaje de marcado de hipertexto');


--Insert preguntas leccion 2 html
INSERT INTO PREGUNTAS VALUES(40,14,'¿Cuál de estas etiquetas HTML se utiliza para crear una lista desordenada?','<ol>','<ul>','<li>','<dl>','<ul>');
INSERT INTO PREGUNTAS VALUES(41,14,'¿Cuál de estas etiquetas HTML se utiliza para crear un elemento de lista?','<ul>','<ol>','<li>','<dl>','<li>');
INSERT INTO PREGUNTAS VALUES(42,14,'¿Cuál de estas etiquetas HTML se utiliza para crear una fila de tabla?','<table>','<tr>','<td>','<th>','<tr>');


--Insert preguntas leccion 3 html
INSERT INTO PREGUNTAS VALUES(43,15,'¿Cuál de estas etiquetas HTML no tiene cierre?','<body>','<a>','<br>','<strong>','<br>');
INSERT INTO PREGUNTAS VALUES(44,15,'¿Cuál de estas etiquetas HTML se utiliza para crear una lista desordenada?','<ol>','<ul>','<li>','<dl>','<ul>');
INSERT INTO PREGUNTAS VALUES(45,15,'¿Html es considerado como?','Un lenguaje de programación','Lenguaje de marcado de hipertexto','Un framework','Una extensión de java Script','Lenguaje de marcado de hipertexto');


--Insert preguntas leccion 4 html
INSERT INTO PREGUNTAS VALUES(46,16,'¿Se puede abrir un enlace en una nueva pestaña del navegador en HTML?','Usando el atributo "new" en la etiqueta <a>','Usando el atributo "blank" en la etiqueta <a>','Usando el atributo "tab" en la etiqueta <a>','Usando el atributo "target" con el valor "_blank" en la etiqueta <a>','Usando el atributo "target" con el valor "_blank" en la etiqueta <a>');
INSERT INTO PREGUNTAS VALUES(47,16,'¿Cómo harías que un enlace descargue un archivo en lugar de abrirlo en el navegador en HTML?','Usando el atributo "download" en la etiqueta <a>','Usando el atributo "href" con el valor "download" en la etiqueta <a>','Usando el atributo "target" con el valor "_download" en la etiqueta <a>','Usando el atributo "rel" con el valor "download" en la etiqueta <a>','Usando el atributo "download" en la etiqueta <a>');
INSERT INTO PREGUNTAS VALUES(48,16,'¿Sabes cómo se puede hacer que un enlace sea no seguido por los motores de búsqueda en HTML?','Usando el atributo "nofollow" en la etiqueta <a>','Usando el atributo "noindex" en la etiqueta <a>','Usando el atributo "rel" con el valor "nofollow" en la etiqueta <a>','Usando el atributo "rel" con el valor "noindex" en la etiqueta <a>','Usando el atributo "rel" con el valor "nofollow" en la etiqueta <a>');


--Insert preguntas leccion 5 html
INSERT INTO PREGUNTAS VALUES(49,17,'¿Qué atributo de la etiqueta <form> especifica dónde enviar los datos del formulario cuando se envía?','method','action','target','enctype','action');
INSERT INTO PREGUNTAS VALUES(50,17,'¿Qué valor del atributo "type" en la etiqueta <input> se usa para campos de entrada ocultos?','hidden','password','submit','reset','hidden');
INSERT INTO PREGUNTAS VALUES(51,17,'¿Qué etiqueta se usa para crear una lista desplegable en un formulario?','<input>','<select>','<option>','<list>','<select>');


--Insert preguntas leccion 6 html
INSERT INTO PREGUNTAS VALUES(52,18,'¿Qué valor del atributo "type" en la etiqueta <input> se usa para campos de entrada ocultos?','hidden','password','submit','reset','hidden');
INSERT INTO PREGUNTAS VALUES(53,18,'¿Cómo harías que un enlace descargue un archivo en lugar de abrirlo en el navegador en HTML?','Usando el atributo "download" en la etiqueta <a>','Usando el atributo "href" con el valor "download" en la etiqueta <a>','Usando el atributo "target" con el valor "_download" en la etiqueta <a>','Usando el atributo "rel" con el valor "download" en la etiqueta <a>','Usando el atributo "download" en la etiqueta <a>');
INSERT INTO PREGUNTAS VALUES(54,18,'¿Qué etiqueta se usa para crear una lista desplegable en un formulario?','<input>','<select>','<option>','<list>','<select>');






--Insert preguntas leccion 1 css
INSERT INTO PREGUNTAS VALUES(55,19,'¿Qué es CSS?','Un lenguaje de programación utilizado para crear páginas web interactivas.','Un protocolo de comunicación utilizado para transferir datos entre servidores y clientes.','Un conjunto de reglas y estilos utilizados para definir el aspecto y el diseño de páginas web','Un estándar de codificación utilizado para escribir aplicaciones móviles nativas','Un conjunto de reglas y estilos utilizados para definir el aspecto y el diseño de páginas web');
INSERT INTO PREGUNTAS VALUES(56,19,'¿Cómo se llama lo que se encuentra dentro de “{}” ? h1 {color: #FF0000; background: #00FF00}','Propiedades','Selector','Valores','Declaración','Declaración');
INSERT INTO PREGUNTAS VALUES(57,19,'¿Qué tipo de hoja de estilo es CSS?','Cascada ','XSL','LESS','SASS','Cascada');


--Insert preguntas leccion 2 css
INSERT INTO PREGUNTAS VALUES(58,20,'¿Para qué sirve este código: <head> <link rel="stylesheet" type="text/css" href="estilos.css" /> </head>?','Para insertar un script JavaScript en el encabezado de la página.','Para agregar una imagen de fondo a la página web.','Para vincular una hoja de estilos externa a la página HTML','Para cargar una fuente personalizada en la página web','Para vincular una hoja de estilos externa a la página HTML');
INSERT INTO PREGUNTAS VALUES(59,20,'¿A qué referencio poniendo “.” antes que un selector?','A un elemento HTML',' A una clase CSS','A un identificador único','A un selector de atributo',' A una clase CSS');
INSERT INTO PREGUNTAS VALUES(60,20,'¿A qué referencio poniendo “#” antes que un selector?','A un elemento HTML','A una clase CSS','A un id','A un selector de atributo','A un id');


--Insert preguntas leccion 3 css
INSERT INTO PREGUNTAS VALUES(61,21,'¿A qué referencio poniendo “#” antes que un selector?','A un elemento HTML','A una clase CSS','A un id','A un selector de atributo','A un id');
INSERT INTO PREGUNTAS VALUES(62,21,'¿Cómo se llama lo que se encuentra dentro de “{}” ? h1 {color: #FF0000; background: #00FF00}','Propiedades','Selector','Valores','Declaración','Declaración');
INSERT INTO PREGUNTAS VALUES(63,21,'¿Qué tipo de hoja de estilo es CSS?','Cascada ','XSL','LESS','SASS','Cascada');


--Insert preguntas leccion 4 css
INSERT INTO PREGUNTAS VALUES(64,22,'¿Para qué sirve esta propiedad “color”?','Saber qué color tiene el fondo','Establece un color seleccionado a la fuente','Para cambiar el color del fondo','Te colorea la página web','Establece un color seleccionado a la fuente');
INSERT INTO PREGUNTAS VALUES(65,22,'¿En qué formato se expresa un color en CSS?','Hexadecimal','RGB','Todas son correctas','Nombre del color','Todas son correctas');
INSERT INTO PREGUNTAS VALUES(66,22,'¿Cuál de las siguientes propiedades CSS se utiliza para establecer el color de fondo de un elemento HTML?','color','font-family','background-color','text-decoration','background-color');


--Insert preguntas leccion 5 css
INSERT INTO PREGUNTAS VALUES(67,23,'¿Cual NO es una medida absoluta de longitud en CSS?','cm','qx','pt','px','cm');
INSERT INTO PREGUNTAS VALUES(68,23,'¿Cual NO es una propiedad de dimensión?','min-size','max-high','width','height','min-size');
INSERT INTO PREGUNTAS VALUES(69,23,'¿Dónde se puede usar width y height?','En un botón','En una imagen','En un div','Todas son correctas','Todas son correctas');


--Insert preguntas leccion 6 css
INSERT INTO PREGUNTAS VALUES(70,24,'¿Cual NO es una medida absoluta de longitud en CSS?','cm','qx','pt','px','cm');
INSERT INTO PREGUNTAS VALUES(71,24,'¿En qué formato se expresa un color en CSS?','Hexadecimal','RGB','Todas son correctas','Nombre del color','Todas son correctas');
INSERT INTO PREGUNTAS VALUES(72,24,'¿Para qué sirve esta propiedad “color”?','Saber qué color tiene el fondo','Establece un color seleccionado a la fuente','Para cambiar el color del fondo','Te colorea la página web','Establece un color seleccionado a la fuente');


INSERT INTO NOTIFICACIONES VALUES();

INSERT INTO USUARIOS(NICK, EMAIL, FOTO_PERFIL, MONEDAS, CONTRASENIA) VALUES('Paco', 'paco@prueba.com','img/Imagen5CustomButton.png',1000,'pacopaco');

UPDATE USUARIOS SET MONEDAS = 700 WHERE EMAIL = 'paco@prueba.com';

DELETE FROM USUARIOS WHERE EMAIL = 'paco@prueba.com';

DROP TABLE TIENDA;

CREATE TABLE TIENDA(
    ID_OBJETO NUMBER(2) CONSTRAINT PK_TIENDA_IDOBJ PRIMARY KEY,
    NOM_OBJETO VARCHAR2(20),
    ICONO VARCHAR2(50)
);


INSERT INTO TIENDA VALUES(1,'Objeto1','/img/Imagen1Tienda.jpeg');
INSERT INTO TIENDA VALUES(2,'Objeto2','/img/Imagen2Tienda.jpeg');
INSERT INTO TIENDA VALUES(3,'Objeto3','/img/Imagen3Tienda.jpeg');
INSERT INTO TIENDA VALUES(4,'Objeto4','/img/Imagen4Tienda.jpeg');
INSERT INTO TIENDA VALUES(5,'Objeto5','/img/Imagen5Tienda.jpeg');
INSERT INTO TIENDA VALUES(6,'Objeto6','/img/Imagen6Tienda.jpeg');


CREATE TABLE USUARIOS_TIENDA(
    ID_OBJETO NUMBER(2) CONSTRAINT FK_USERTIENDA_IDOBJ REFERENCES TIENDA(ID_OBJETO),
    ID_USUARIO NUMBER(2) CONSTRAINT FK_USERTIENDA_IDUSER REFERENCES USUARIOS(ID_USUARIO),
    PRECIO NUMBER(3),
    COMPRADA BOOLEAN,
    CONSTRAINT PK_USERTIENDA_IDOBJIDUSER PRIMARY KEY (ID_OBJETO, ID_USUARIO)
);

DROP TABLE TIENDA;

CREATE TABLE TIENDA(
    ID_OBJETO NUMBER(2) CONSTRAINT PK_TIENDA_IDOBJ PRIMARY KEY,
    NOM_OBJETO VARCHAR2(20),
    PRECIO NUMBER(4),
    ICONO VARCHAR2(50)
);


INSERT INTO TIENDA VALUES(1,'Objeto1',500,'/img/Imagen1Tienda.jpeg');
INSERT INTO TIENDA VALUES(2,'Objeto2',600,'/img/Imagen2Tienda.jpeg');
INSERT INTO TIENDA VALUES(3,'Objeto3',500,'/img/Imagen3Tienda.jpeg');
INSERT INTO TIENDA VALUES(4,'Objeto4',500,'/img/Imagen4Tienda.jpeg');
INSERT INTO TIENDA VALUES(5,'Objeto5',1000,'/img/Imagen5Tienda.jpeg');
INSERT INTO TIENDA VALUES(6,'Objeto6',700,'/img/Imagen6Tienda.jpeg');

DROP TABLE USUARIOS_TIENDA;

CREATE TABLE USUARIOS_TIENDA(
    ID_OBJETO NUMBER(2) CONSTRAINT FK_USERTIENDA_IDOBJ REFERENCES TIENDA(ID_OBJETO),
    ID_USUARIO NUMBER(2) CONSTRAINT FK_USERTIENDA_IDUSER REFERENCES USUARIOS(ID_USUARIO),
    COMPRADA BOOLEAN,
    CONSTRAINT PK_USERTIENDA_IDOBJIDUSER PRIMARY KEY (ID_OBJETO, ID_USUARIO)
);

UPDATE USUARIOS SET MONEDAS = 1000 WHERE EMAIL = 'mango@pruebas.com';

DROP TABLE USUARIOS;

CREATE TABLE USUARIOS(
    ID_USUARIO INTEGER PRIMARY KEY AUTOINCREMENT,
    NICK VARCHAR2(30),
    EMAIL VARCHAR2(40) CONSTRAINT UQ_USUARIOS_EMAIL UNIQUE,
    FOTO_PERFIL VARCHAR2(50) DEFAULT '/img/usuario.png',
    MONEDAS INTEGER,
    PUNTOS INTEGER,
    CONTRASENIA VARCHAR2(20)
);

UPDATE LECCIONES SET COMPLETADA = true WHERE ID_LECCION IN(1,7,13,19);

INSERT INTO USUARIOS(NICK, EMAIL, FOTO_PERFIL, MONEDAS, CONTRASENIA) VALUES('Fernando', 'usuario1@prueba.com','/img/usuario.png',100,'usuarioprueba1');
INSERT INTO USUARIOS(NICK, EMAIL, FOTO_PERFIL, MONEDAS, CONTRASENIA) VALUES('Pepe', 'usuario2@prueba.com','/img/usuario.png',200,'usuarioprueba2');
INSERT INTO USUARIOS(NICK, EMAIL, FOTO_PERFIL, MONEDAS, CONTRASENIA) VALUES('Sara', 'usuario3@prueba.com','/img/usuario.png',300,'usuarioprueba2');


DELETE FROM USUARIOS WHERE ID_USUARIO = 4 CASCADE;

DROP TABLE TEMARIO;

CREATE TABLE TEMARIO(
    ID_TEMARIO NUMBER(2) CONSTRAINT PK_TEMARIO_IDTEM PRIMARY KEY,
    ID_CURSO NUMBER(2) CONSTRAINT FK_TEMARIO_IDCUR REFERENCES CURSOS(ID_CURSO),
    ID_LECCION NUMBER(2) CONSTRAINT FK_TEMARIO_IDLEC REFERENCES LECCIONES(ID_LECCION),
    TEAMRIO VARCHAR2(255)
);

UPDATE PREGUNTAS SET RESP1 = '<HTML>' || RESP1 || '</HTML>' WHERE ID_LECCION NOT BETWEEN 13 AND 18;
UPDATE PREGUNTAS SET RESP2 = '<HTML>' || RESP2 || '</HTML>' WHERE ID_LECCION NOT BETWEEN 13 AND 18;
UPDATE PREGUNTAS SET RESP3 = '<HTML>' || RESP3 || '</HTML>' WHERE ID_LECCION NOT BETWEEN 13 AND 18;
UPDATE PREGUNTAS SET RESP4 = '<HTML>' || RESP4 || '</HTML>' WHERE ID_LECCION NOT BETWEEN 13 AND 18;
UPDATE PREGUNTAS SET CORRECTA = '<HTML>' || CORRECTA || '</HTML>' WHERE ID_LECCION NOT BETWEEN 13 AND 18;


INSERT INTO TEMARIO VALUES(1, 1, 1, 'Variables  Una variable es una zona de memoria donde se puede almacenar información del tipo que se desee con un nombre que la identifica. Existen dos tipos de variables, las variables primitivas y las de referencia. Se distinguen por la declaración del tipo de dato, en las de referencia la primera letra será en mayúscula.');
INSERT INTO TEMARIO VALUES(2, 1, 2, 'Los operadores aritméticos son herramientas que nos permiten realizar operaciones matemáticas básicas.');
INSERT INTO TEMARIO VALUES(3, 1, 4, 'En Java, los operadores lógicos son herramientas que nos ayudan a tomar decisiones en nuestro código. ¡Vamos a descubrir más sobre ellos!');
INSERT INTO TEMARIO VALUES(4, 1, 5, 'En Java, los bucles son estructuras que nos permiten repetir un bloque de código varias veces. ¡Vamos a aprender más sobre ellos!');
INSERT INTO TEMARIO VALUES(5, 2, 7, 'En SQL, la creación de tablas es un proceso fundamental que nos permite estructurar y almacenar nuestros datos.');
INSERT INTO TEMARIO VALUES(6, 2, 8, 'En SQL, los constraints son reglas que nos ayudan a mantener la integridad y la precisión de los datos en nuestras tablas. ¡Vamos a aprender más sobre ellos!');
INSERT INTO TEMARIO VALUES(7, 2, 10, 'alter table nos permite cambiar la estructura de una tabla existente, como añadir o eliminar columnas. insert into se usa para añadir nuevos registros a una tabla.');
INSERT INTO TEMARIO VALUES(8, 2, 11, 'En el manejo de bases de datos, las operaciones de actualización y eliminación son fundamentales. La sentencia UPDATE permite modificar los valores existentes, mientras que DELETE elimina registros innecesarios.');

INSERT INTO TEMARIO VALUES(9, 3, 13, 'Una página HTML sigue una estructura básica compuesta por tres partes principales el head el body y sus elementos.');
INSERT INTO TEMARIO VALUES(10, 3, 14, 'Las listas son una parte esencial de HTML y se utilizan para presentar información de manera ordenada y estructurada.');
INSERT INTO TEMARIO VALUES(11, 3, 16, 'la etiqueta de enlace, también conocida como la etiqueta <a> se utiliza para enlazar a diferentes partes de la misma página, a otras páginas en el mismo sitio web, o a páginas en otros sitios web. ');
INSERT INTO TEMARIO VALUES(12, 3, 17, 'Los formularios son esenciales para interactuar con los usuarios, ya que permiten recoger información de ellos.');
INSERT INTO TEMARIO VALUES(13, 4, 19, 'CSS es un lenguaje de hojas de estilo que se utiliza para describir la apariencia o la presentación de un documento escrito en HTML.');
INSERT INTO TEMARIO VALUES(14, 4, 20, 'Un documento CSS se compone de varios selectores y reglas que trabajan juntos para formar la apariencia completa de una página web.');
INSERT INTO TEMARIO VALUES(15, 4, 22, 'Los colores en CSS pueden ser especificados de varias maneras para el texto el fondo sus elementos y tienen multiples variaciones.');
INSERT INTO TEMARIO VALUES(16, 4, 23, 'El posicionamiento en CSS es una característica poderosa que permite controlar exactamente dónde se colocan los elementos HTML en una página web.');