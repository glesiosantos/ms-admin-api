insert into clientes (ativo, integrado, nr_usuario, vencimento, cpf_cnpj, razao, nm_fantasia, cep, logradouro, bairro, cidade, uf, complemento, latitude, longitude, modulo) values
	(false, false, 0, 0,'21344844000120','MAURICIO RODRIGUES SANTOS','AUTO GIRO','64009330','Rua Castelo do Piauí 3365 memorare','Buenos Aires','Teresina','PI',null, '-5.040072','-42.8138079', null),
	(false, false, 0, 0,'10584231000143','M DE SOUSA TRINDADE','G MOTOS','64008400','R. Eng. Alves Noronha, 5605','Buenos Aires','Teresina','PI',null, '-5.0356601','-42.8153797', null),
	(false, false, 0, 0,'14626628000101','C R MOTOS LTDA','ULTRAPOWER MOTOS','64078165','Rua Benedito Feitosa Cardoso, 2008 - Conj Dirceu Arcoverde II','Itarare','Teresina','PI',null, '-5.1081643','-42.7673233', null),
	(false, false, 0, 0,'10818016000160','CLEMILTON GOMES LOPES','CR MOTOS','64008400','R. Eng. Alves Noronha, 5605','Buenos Aires','Teresina','PI',null, '-5.0356601','-42.8153797', null);


insert into tb_cliente_contatos (cliente_id, contatos) values
	((select id from clientes c where c.cpf_cnpj = '21344844000120'), '+5586999095638'),
	((select id from clientes c where c.cpf_cnpj = '21344844000120'), '+5586988647628'),
	((select id from clientes c where c.cpf_cnpj = '10584231000143'), '+558632257154'),
	((select id from clientes c where c.cpf_cnpj = '10818016000160'), '+558632257154');