CREATE TABLE FESTIVAL (
    id INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    ubicacion VARCHAR(150) NOT NULL,
    anio INT NOT NULL,
    fecha DATE NOT NULL,
    n_asistentes INT,
    precio_g DECIMAL(6,2) NOT NULL,
    precio_vip DECIMAL(6,2) NOT NULL,
    descripcion TEXT
);

CREATE TABLE ENTRADA (
    id_festival INT,
    tipo VARCHAR(20) NOT NULL,
    precio DECIMAL(6,2) NOT NULL,
    detalles TEXT,
    FOREIGN KEY (id_festival) REFERENCES FESTIVAL(id)
);

CREATE TABLE USUARIO (
    id INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL,
    contrasena VARCHAR(100) NOT NULL
);

CREATE TABLE INICIO_SESION (
    id INT PRIMARY KEY,
    id_usuario INT NOT NULL,
    f_horainicio DATETIME NOT NULL,
    f_horafin DATETIME,
    FOREIGN KEY (id_usuario) REFERENCES USUARIO(id)
);

CREATE TABLE ARTISTA (
    id INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    genero VARCHAR(50) NOT NULL,
    descripcion TEXT
);

CREATE TABLE CANCIONES (
    id INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    duracion TIME NOT NULL,
    id_artista INT NOT NULL,
    FOREIGN KEY (id_artista) REFERENCES ARTISTA(id)
);

CREATE TABLE ACTUACIONES (
    id INT PRIMARY KEY,
    duracion TIME NOT NULL
);

CREATE TABLE REDES (
    id_artista INT NOT NULL,
    facebook VARCHAR(255),
    instagram VARCHAR(255),
    tiktok VARCHAR(255),
    x VARCHAR(255),
    FOREIGN KEY (id_artista) REFERENCES ARTISTA(id)
);