CREATE DATABASE liga_hexagonal;
USE liga_hexagonal;

CREATE TABLE Personas(
    id_persona INT(11) AUTO_INCREMENT NOT NULL,
    id_equipo INT(11),
    nombre_persona VARCHAR(50),
    apellido_persona VARCHAR(50),
    edad_persona INT,
    id_ciudad INT(11),
    PRIMARY KEY(id_persona)
);

CREATE TABLE Equipos(
    id_equipo INT(11) AUTO_INCREMENT NOT NULL,
    id_partido INT(11) NOT NULL,
    nombre_equipo VARCHAR(50),
    p_jugados INT,
    p_ganados INT,
    p_perdidos INT,
    p_empates INT,
    g_favor INT,
    g_contra INT,
    t_puntos INT,
    PRIMARY KEY(id_equipo)
);

CREATE TABLE Ciudades(
    id_ciudad INT(11) AUTO_INCREMENT NOT NULL,
    nombre_ciudad VARCHAR(100),
    id_region  INT(11),
    PRIMARY KEY(id_ciudad)
);

CREATE TABLE Regiones(
    id_region INT(11) AUTO_INCREMENT NOT NULL,
    nombre_region VARCHAR(50),
    id_pais INT(11),
    PRIMARY KEY(id_region)
);

CREATE TABLE Paises(
    id_pais INT(11) AUTO_INCREMENT NOT NULL,
    nombre_pais VARCHAR(50),
    PRIMARY KEY(id_pais)
);

CREATE TABLE Tecnicos(
    id_tecnico INT(11)AUTO_INCREMENT NOT NULL,
    id_persona INT(11),
    anyos_experiencia INT,
    rol VARCHAR(50),
    PRIMARY KEY(id_tecnico)
);

CREATE TABLE Medicos(
    id_medico INT(11) AUTO_INCREMENT NOT NULL,
    id_persona INT(11),
    cargo VARCHAR(50),
    afilia_eps VARCHAR(25),
    PRIMARY KEY(id_medico)
);

CREATE TABLE Jugadores(
    id_jugador INT(11) AUTO_INCREMENT NOT NULL,
    id_persona INT(11),
    rojas INT,
    amarillas INT,
    g_anotados INT,
    numero_c INT,
    posicion VARCHAR(50),
    PRIMARY KEY(id_jugador)
);

CREATE TABLE Partidos(
    id_partido INT(11)AUTO_INCREMENT NOT NULL,
    marc_Local INT,
    marc_Visitante INT,
    fecha DATE,
    e_visitante VARCHAR(50),
    e_local VARCHAR(50),
    PRIMARY KEY(id_partido)
);


ALTER TABLE Personas
ADD CONSTRAINT FK_PersonasEquipos
FOREIGN KEY(id_equipo) REFERENCES Equipos(id_equipo);

ALTER TABLE Personas 
ADD CONSTRAINT FK_PersonasCiudades FOREIGN KEY (id_ciudad) 
REFERENCES Ciudades(id_ciudad) ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE Tecnicos
ADD CONSTRAINT FK_TecnicosPersonas
FOREIGN KEY(id_persona) REFERENCES Personas(id_persona);

ALTER TABLE Medicos
ADD CONSTRAINT FK_MedicosPersonas
FOREIGN KEY(id_persona) REFERENCES Personas(id_persona);

ALTER TABLE Jugadores
ADD CONSTRAINT FK_JugadoresPersonas
FOREIGN KEY(id_persona) REFERENCES Personas(id_persona);

ALTER TABLE Equipos
ADD CONSTRAINT FK_EquiposPartidos
FOREIGN KEY (id_partido) REFERENCES Partidos(id_partido);

ALTER TABLE Ciudades 
ADD CONSTRAINT FK_CiudadesRegiones FOREIGN KEY (id_region)
REFERENCES Regiones(id_region) ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE Regiones 
ADD CONSTRAINT FK_RegionesPaises FOREIGN KEY (id_pais) 
REFERENCES Paises(id_pais) ON DELETE RESTRICT ON UPDATE CASCADE;