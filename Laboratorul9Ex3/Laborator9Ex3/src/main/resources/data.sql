Create table masini_DataJPA
(
    nrinmatriculare varchar(255) not null,
    marca varchar(255) not null,
    anulfabricatiei int not null,
    culoare varchar(255) not null,
    nrkm int not null,
    primary key (nrinmatriculare)
);

INSERT INTO masini_DataJPA (nrinmatriculare, marca, anulfabricatiei, culoare, nrkm)
VALUES
    ('1', 'TOYOTA', 2014, 'NEGRU', 195000),
    ('2', 'BMW', 2009, 'NEGRU', 230000),
    ('3', 'NISSAN', 2013, 'ROSU', 200000),
    ('4', 'LEXUS', 2018, 'GRI', 170000),
    ('5', 'TESLA', 2020, 'ALB', 150000);