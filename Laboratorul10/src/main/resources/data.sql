
Create table carti(
id INT  auto_increment,
Autorul varchar(255) not null,
Titlul varchar(255) not null,
primary key (id)
);

insert into carti(Autorul, Titlul) values('Ion Creanga', 'Amintiri din copilarie');
insert into carti(Autorul, Titlul) values('Liviu Rebreanu', 'Padurea spanzuratilor');
insert into carti(Autorul, Titlul) values('Mircea Eliade', 'Maitreyi');
insert into carti(Autorul, Titlul) values('Marin Preda', 'Cel mai iubit dintre pamanteni');
insert into carti(Autorul, Titlul) values('Camil Petrescu', 'Patul lui Procust');