create table if not exists socio
(
    nif text,
    nombre text,
    fecha_nacimiento date,
	poblacion text,

	primary key(nif)
);

create table if not exists pelicula
(
    titulo text,
    autor text,
    format text,
    anio integer,
    duracion integer,
    actor_principal text,
    actriz_principal text,

    primary key(titulo, autor)
);

create table if not exists videojuego
(
    titulo text,
    autor text,
    format text,
    anio integer,
    plataforma text,

    primary key(titulo, autor)
);

create table if not exists alquiler
(

)