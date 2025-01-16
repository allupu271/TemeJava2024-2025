
 Create table masini
 (
     NrInm varchar(255) not null,
     Marca varchar(255) not null,
     AnFabr int not null,
     Culoare varchar(255) not null,
     NrKm int not null,
     primary key (NrInm)
 );

    INSERT INTO masini (NrInm, Marca, AnFabr, Culoare, NrKm)
    VALUES
        ('DJ09MNM', 'TOYOTA', 2013, 'NEGRU', 150000),
        ('MH23LLL', 'NISSAN', 2015, 'ROSU', 125000),
        ('TM56PUU', 'VOLSWAGEN', 2005, 'ALBASTRU', 230000),
        ('AB74BAY', 'LEXUS', 2024, 'NEGRU', 20000),
        ('TM89HHH', 'TESLA', 2023, 'ALB', 60000);