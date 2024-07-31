use db_NICKS;

go

create table TableTipoConta(
	idTipoConta bigint  primary key identity,
	tipo varchar(30) null
);

create table TableAgencia(
	idAgencia bigint primary key identity,
	codigo int null
);

create table TableReserva(
	idReserva bigint primary key identity,
	valor decimal(10,2) null
);

create table TableEndereco(
	idEndereco bigint primary key identity,
	logradouro varchar(45) null,
	bairro varchar(45) null,
	numero int null,
	cep int null,
	cidade varchar(45) null,
	estado varchar(45) null
);

create table TableCliente(
	idCliente bigint primary key identity,
	nome varchar(45) not null,
	email varchar(45) not null,
	cpf char(20) null,
	telefone char(20) null,
	senha varchar(45) not null
);


create table TableCliente_tem_TableEndereco(
	Fk_endereco_idEndereco bigint foreign key references TableEndereco,
	Fk_cliente_idCliente bigint foreign key references TableCliente
); 



create table TableTransacao(
	idTransacao bigint primary key identity,
	dataTime datetime,
	tipo varchar(30) not null,
	valor decimal(10,2) not null
);

create table TableExtrato(
	idExtrato bigint primary key identity,	
	dataTime datetime,
	tipo varchar(30),
	valor decimal(10,2) not null,
);

create table TableConta(
	idConta bigint primary key identity,
	codigo int,
	saldo decimal(10,2),
	Fk_tipoConta_idTipoConta bigint foreign key references TableTipoConta,
	Fk_agencia_idAgencia bigint foreign key references TableAgencia,
	Fk_reserva_idReserva bigint foreign key references TableReserva,
	Fk_cliente_idCliente bigint foreign key references TableCliente
);

create table TablePix(
	idPix bigint primary key identity,
	chave int,
	Fk_conta_idConta bigint foreign key references TableConta,
	Fk_conta_tipoConta_idTipoConta bigint foreign key references TableConta,
	Fk_conta_agencia_idAgencia bigint foreign key references TableConta,
	Fk_conta_reserva_idReserva bigint foreign key references TableConta
);

create table TableConta_tem_TableTransacao(
	Fk_conta_idConta bigint foreign key references TableConta,
	Fk_conta_tipoConta_idTipoConta bigint foreign key references TableConta,
	Fk_conta_agencia_idAgencia bigint foreign key references TableConta,
	Fk_conta_reserva_idReserva bigint foreign key references TableConta,
	Fk_conta_cliente_idCliente bigint foreign key references TableConta,
	Fk_transacao_idTransacao bigint foreign key references TableTransacao
);

create table TableExtrato_tem_TableTransacao(	
	Fk_extrato_idExtrato bigint foreign key references TableExtrato,
	Fk_transacao_idTransacao bigint foreign key references TableTransacao,
);


