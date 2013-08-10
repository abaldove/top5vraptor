
    create table Movie (
        id_movie bigint not null,
        imdbId varchar(255),
        name varchar(255),
        posterName varchar(255),
        releaseDate date,
        sinopse varchar(255),
        primary key (id_movie)
    );

    create table T_ID (
         key varchar(255),
         valor integer 
    ) ;
