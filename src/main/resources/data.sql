insert into clientes (ativo, integrado, vencimento, cpf_cnpj, razao, nm_fantasia, modulo, cep, logradouro, bairro, cidade, uf, complemento, latitude, longitude, plano, proprietario, cpf_propr, tipo) values
	(false, false,0,'21344844000120','MAURICIO RODRIGUES SANTOS','AUTO GIRO',null,'64009330','Rua Castelo do Piauí 3365 memorare','Buenos Aires','Teresina','PI',null, '-5.040072','-42.8138079', null,null, null, 'PJ'),
	(false, false,0,'10584231000143','M DE SOUSA TRINDADE','G MOTOS',null,'64008400','R. Eng. Alves Noronha, 5605','Buenos Aires','Teresina','PI',null, '-5.0356601','-42.8153797', null, null, null, 'PJ'),
	(false, false,0,'14626628000101','C R MOTOS LTDA','ULTRAPOWER MOTOS',null,'64078165','Rua Benedito Feitosa Cardoso, 2008 - Conj Dirceu Arcoverde II','Itarare','Teresina','PI',null, '-5.1081643','-42.7673233', null, null, null, 'PJ'),
	(false, false,0,'10179034090','CLEMILTON GOMES LOPES','CR MOTOS',null,'64008400','R. Eng. Alves Noronha, 5605','Buenos Aires','Teresina','PI',null, '-5.0356601','-42.8153797', null, null, null, 'PF')
on conflict do nothing;

insert into cliente_contatos (cliente_id, contatos) values
	((select id from clientes c where c.cpf_cnpj = '21344844000120'), '86999095638'),
	((select id from clientes c where c.cpf_cnpj = '21344844000120'), '86988647628'),
	((select id from clientes c where c.cpf_cnpj = '10584231000143'), '86998257154'),
	((select id from clientes c where c.cpf_cnpj = '14626628000101'), '86988267160'),
	((select id from clientes c where c.cpf_cnpj = '10179034090'),    '86999257190')
on conflict do nothing;
