
Create table evenimente
(
    id        INT auto_increment,
    denumire varchar(255) not null,
    locatie   varchar(255) not null,
    data      DATE         not null,
    timp       TIME         not null,
    pret      float        not null,
    primary key (id)
);

insert into evenimente(denumire, locatie, data, timp, pret) values('FESTIVAL', 'PADUREA VERDE', '2025-09-12', '22:00', 300);
insert into evenimente(denumire, locatie, data, timp, pret) values('DANS', 'PARC', '2023-11-03', '13:00', 35);
insert into evenimente(denumire, locatie, data, timp, pret) values('NUNTA', 'VENUE', '2021-05-06', '20:00', 100);
insert into evenimente(denumire, locatie, data, timp, pret) values('BOTEZ', 'BISERICA', '2008-11-19', '10:00', 50);
insert into evenimente(denumire, locatie, data, timp, pret) values('CUNUNIE', 'PRIMARIE', '2012-07-04', '14:00', 80);

