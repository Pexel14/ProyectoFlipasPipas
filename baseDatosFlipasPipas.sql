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
    PREGUNTA VARCHAR2(50),
    RESPUESTA VARCHAR2(70),
    ES_CORRECTA BOOLEAN
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