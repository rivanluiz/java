create table produto(
	idProduto 	integer 		auto_increment,
	nome 	  	varchar(50)		not null,
	preco		double			not null,
	quantidade	integer			not null,
	dataCompra	date			not null,
	primary key(idProduto)
);

desc produto;