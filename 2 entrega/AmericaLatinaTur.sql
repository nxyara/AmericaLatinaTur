create database americalatinatur;
use americalatinatur;

create table Usuario(
	idUsuario int auto_increment primary key, 
    nomeUsuario varchar(255) not null,
    cpfUsuario varchar(11) unique not null,
    enderecoUsuario text not null,
    telefoneUsuario varchar(15)
);

create table Destino(
	idDestino int auto_increment primary key,
    nomeDestino varchar(255) not null,
    datasDestino datetime,
    precoDestino decimal(10,2),
    idUsuario int not null
    );

create table Promocao(
	idPromocao int auto_increment primary key,
    destinoPromocao varchar(255) not null,
    dataPromocao datetime,
    condicoesPromocao varchar(255) not null,
    idUsuario int not null,
    foreign key (idUsuario) references Usuario (idUsuario)
);

insert into Usuario(nomeUsuario, cpfUsuario, enderecoUsuario, telefoneUsuario)
values ('Milena','06678954645','Rua xx São Paulo','5534856473987');

insert into Usuario(nomeUsuario, cpfUsuario, enderecoUsuario, telefoneUsuario)
values ('Jose','09823465345','Rua xx Rio de Janeiro','55999456789');

insert into Usuario(nomeUsuario, cpfUsuario, enderecoUsuario, telefoneUsuario)
values ('Maria','7892346429','Rua xx Belo Horizonte','55898453750');

insert into Usuario(nomeUsuario, cpfUsuario, enderecoUsuario, telefoneUsuario)
values ('João','5783904876','Rua xx Vitória','5556739204672');

insert into Usuario(nomeUsuario, cpfUsuario, enderecoUsuario, telefoneUsuario)
values ('Ana','0782310919','Rua xx Campo Grande','55999230948');

insert into Destino(nomeDestino, datasDestino, precoDestino, idUsuario)
values	('Machu Pichu','2023-12-15','2000.00', 8);

insert into Destino(nomeDestino, datasDestino, precoDestino, idUsuario)
values ('Cartagena, Colômbia', '2023-12-01', 4300.00, 10);

insert into Destino(nomeDestino, datasDestino, precoDestino, idUsuario)
values ('Torres del Paine, Chile', '2024-01-12', 3600.00, 11);

insert into Destino(nomeDestino, datasDestino, precoDestino, idUsuario)
values ('Laguna Colorada, Bolívia', '2023-12-04', 2300.00, 12);

insert into Promocao(dataPromocao, condicoesPromocao, idUsuario)
values ('2024-03-02', '20% de desconto em todos os destinos', 18);

select * from Usuario;

select * from Destino;

select * from Promocao;

show tables;
