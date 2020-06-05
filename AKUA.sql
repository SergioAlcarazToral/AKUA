Create database AKUA;
use AKUA;
CREATE USER 'pruebaConexion'@'localhost' IDENTIFIED BY '12345678';
GRANT SELECT,INSERT,DELETE,UPDATE ON AKUA.* TO 'pruebaConexion'@'localhost';
flush privileges;
create table artista(
	id int auto_increment primary key,
    nombre varchar(100),
    foto varchar(255)
);
create table genero(
	id int auto_increment primary key,
    nombre varchar(100)
);
create table album(
	id int auto_increment primary key,
    nombre varchar(100),
    anyo int,
    idArtista int,
    foto varchar(255),
    foreign key(idArtista) references artista(id)
    on update restrict
    on delete cascade
);
create table cancion(
	id int auto_increment primary key,
    titulo varchar(100),
    idGenero int,
    idAlbum int,
    archivo varchar(255),
    foreign key(idGenero) references genero(id),
    foreign key(idAlbum) references album(id)
    on delete cascade
    on update restrict
);
create table usuario(
	id int auto_increment primary key,
    nombre varchar(100),
    correo varchar(100) unique,
    pass varchar(100),
    administrador int,
    foto varchar(255)
);
create table listaReproduccion(
	nombre varchar(100),
    idUsuario int,
    idCancion int,
    foreign key(idUsuario) references usuario(id),
    foreign key(idCancion) references cancion(id)
    on update restrict
    on delete cascade
);

INSERT INTO usuario(nombre,correo,pass,administrador,foto) values('admin','admin@admin.com','1234',0,'sinImagen.jpg');
select * from listareproduccion;


