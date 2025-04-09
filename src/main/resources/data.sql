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

--insert into pedidos (cliente_id, usuario_responsavel_id, chave_compartilhamento, dt_expiracao, id_cob_asaas, plano, qr_code,situacao, dt_criado_em) values
--    ((select id from clientes c where c.cpf_cnpj = '21344844000120'), (select id from usuarios u where u.email = 'glesioss@gmail.com'), '00020101021226820014br.gov.bcb.pix2560pix-h.asaas.com/qr/cobv/b82bd7e7-1ab8-4f99-b3e9-7fbb778d997e5204000053039865802BR5922Glesio Santos da Silva6008Teresina61086401053062070503***630497E5',
--    '2025-03-01 23:59:59','pay_ntea5c1a3ea3c7u3','BASIC','iVBORw0KGgoAAAANSUhEUgAAAcIAAAHCAQAAAABUY/ToAAADDUlEQVR4Xu2UQY7bUAxDvfP9b9RjZecOHyXFU6BwMZsqAOXY/p/iYxZfyXH9sH4dfyr/WiGfKuRThXyqkE8V8qn+G/k6qPN6nboufY7zdRO+lvKd4wy5mSy9b/WhyqRs4YdS2h9yMVlqnT/CoO4aH2fIDyBpycCN9RLsohfyo0hbaX1HOivkR5CXnx6FsuGvwz+c+naG3EzOiT9e5Qz512sBOTVj4KmQwCzcPV0h15I2aRSAdNx96krwhmZ5Q64mcYt5jwIzIEg7MsixChtyOen+Ca8HvF3tKYn8kGtJJHeq76j2sTMOTIVcTOI9O6IFuaweTrLmmJCLSclXrfRqpLwuKeQjhNxLsvfftNtHAfXsAehEiSEXk+Ksy2rDzW1FFmmWQq4ly1+wKa31vFFwdEOuJ6cvN5uag4KIxEE35GJSbQkGuIgomwMJ0ho55G4SrwEY9RoicTgnhFxNCsaO6g1BUhzXCQghN5NCwaXxJqoGQadvkcQak5CLSVksGVBQKcPcOPVDLiflLp+38HI7rBPrDrmXxHzSFHTYXuc/PWdUdsjFZMF2HGW9yLHPAaMIDLmXLMIjIIvt/lum7b/oVkBD7iUl2iM/vTr1FieImJC7STvUIcFd8ibTnL8k5HJyPJ4AR8EP6dGotb4o5FrSEi2xBMhzy1FyfwXLkHvJl7HpmIMk8Y29o0JuJ8X4lGUABiSJvG94yMUkPlfH+K4U+/vCF3IzWb6vtWfhDqFqBa+VpJBrybGj6lPuhqfrcJ4h15LqjuEN8a6XtooRY0/ItSSo2HOaFlsue3VtCbmZvHzqdo4d92RIrpEIuZs86rShz/pFE0MGOSQ6JeRq0iBGe2/lRBolEBNyMdkF251L582NXVoprEPuJdVzmzGg1ynajfR2hNxMcrRS3xu50EzNCDgh5G7S515+PT0bPnNFvjXnh/wE0lCv1PGeBCl9h/wIkoa9zeG6E6WE3Exaes1P2XzB83t+VRDPkHtJ9dSVWY+XN0oYSnKNQ8jd5I8q5FOFfKqQTxXyqUI+1YeRvwG2FTAL6xNDfQAAAABJRU5ErkJggg=='
--    ,'PENDENTE', '2025-02-25')
--on conflict do nothing;