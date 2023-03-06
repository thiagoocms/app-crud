create table tb_cliente (
    id int8 not null, 
    data_de_nascimento varchar(255), 
    email varchar(255), 
    telefone varchar(11), 
    profissao varchar(50), 
    nome varchar(255), 
    primary key (id)
)