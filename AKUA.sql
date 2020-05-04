Create database AKUA;
#drop database AKUA;
use AKUA;
#CREATE USER 'pruebaConexion'@'localhost' IDENTIFIED BY '12345678';
#GRANT SELECT,INSERT,DELETE,UPDATE ON AKUA.* TO 'pruebaConexion'@'localhost';
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
select *from listareproduccion where idUsuario = 1;
select * from cancion;

select distinct titulo, genero.nombre as genero, album.nombre as album
from listareproduccion, cancion, genero,album
 where listareproduccion.idUsuario = 1 
 and idCancion is not null 
 and cancion.idAlbum = album.id
 and cancion.idGenero = genero.id;
		SELECT * FROM listaReproduccion where idUsuario = 1 and nombre = 'cosa';
select * from cancion;
select distinct * from listareproduccion;
		SELECT * FROM listaReproduccion where idUsuario = 2 and nombre ="Prueba" limit 1;


		SELECT * FROM listaReproduccion;

select distinct cancion.id as id,
		titulo, genero.nombre as genero, album.nombre as album
		from listareproduccion, cancion, genero,album
		where listareproduccion.idUsuario = 1
		and idCancion is not null
		and cancion.idAlbum = album.id
		and cancion.idGenero = genero.id;
 
 	SELECT * FROM listaReproduccion where idUsuario = 5 group by nombre;

#select cancion.id,titulo,idGenero,idAlbum,archivo from cancion,genero,album,artista  where idGenero = genero.id and idAlbum = album.id and album.idArtista = artista.id and genero.nombre = #{nombre} order by rand() limit 20;