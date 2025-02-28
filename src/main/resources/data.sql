insert into clientes (ativo, integrado,  vencimento, cpf_cnpj, razao, nm_fantasia, modulo, cep, logradouro, bairro, cidade, uf, complemento, latitude, longitude) values
	(false, false,0,'21344844000120','MAURICIO RODRIGUES SANTOS','AUTO GIRO','GOM','64009330','Rua Castelo do Piauí 3365 memorare','Buenos Aires','Teresina','PI',null, '-5.040072','-42.8138079'),
	(false, false,0,'10584231000143','M DE SOUSA TRINDADE','G MOTOS','GOM','64008400','R. Eng. Alves Noronha, 5605','Buenos Aires','Teresina','PI',null, '-5.0356601','-42.8153797'),
	(false, false,0,'14626628000101','C R MOTOS LTDA','ULTRAPOWER MOTOS','GOM','64078165','Rua Benedito Feitosa Cardoso, 2008 - Conj Dirceu Arcoverde II','Itarare','Teresina','PI',null, '-5.1081643','-42.7673233'),
	(false, false,0,'10818016000160','CLEMILTON GOMES LOPES','CR MOTOS','GOM','64008400','R. Eng. Alves Noronha, 5605','Buenos Aires','Teresina','PI',null, '-5.0356601','-42.8153797');

insert into tb_cliente_contatos (cliente_id, contatos) values
	((select id from clientes c where c.cpf_cnpj = '21344844000120'), '+5586999095638'),
	((select id from clientes c where c.cpf_cnpj = '21344844000120'), '+5586988647628'),
	((select id from clientes c where c.cpf_cnpj = '10584231000143'), '+558632257154'),
	((select id from clientes c where c.cpf_cnpj = '14626628000101'), '+558632267160'),
	((select id from clientes c where c.cpf_cnpj = '10818016000160'), '+558632257190');

--insert into pedidos (cliente_id, qtd_usuario, usuario_responsavel_id, chave_compartilhamento, dt_expiracao, id_cob_asaas, modulo, qr_code,situacao) values
--    ((select id from clientes c where c.cpf_cnpj = '10584231000143'), 2, (select id from usuarios u where u.email = 'admin@ohgestor.com.br'), '00020101021226820014br.gov.bcb.pix2560pix-h.asaas.com/qr/cobv/d902715f-d473-4b5c-88dd-75348d3e28295204000053039865802BR5922Glesio Santos da Silva6008Teresina61086401053062070503***6304BBDF',
--    '2026-02-27 23:59:59','pay_5u98bitg2zwmdd85','OMG','iVBORw0KGgoAAAANSUhEUgAAAcIAAAHCAQAAAABUY/ToAAADHUlEQVR4Xu2TQZLbQAwDddP/f5Rn6eYYDczYu6mUUnsJXQXKHg1BNC+kjscP49fxXfnXKHkXJe+i5F2UvIuSd/HfyOsgzufl1P28zqdImuJTUU4VZ8nJpG7ST7y44yNNnpbxlxxMRg2BEJQlcAftyXKW/AByW9VClxynKOslP4jU1TO3N0FlFUp+Avmwik5Zy2A/WSrbWXI0uSd++8RZ8q/PAPI9LnTNmr8yIZQ4V5QcS17egxejzFPXF76+7teqlJxNatrKNHTsEWlH6rZ2lpxOHraECa/kirJES6AlJ5N2IOl4TVyv1NmN1b3kaFJ1ipo9XhNKIpOlV8nRJK51rBINdZomlqXkaPJ4MayAHa4sPy51SqOSY8kY9NbwKci+2FX+Yig5l8TmNUh2aOzO5Vs5vdyy5FjSNU/40qwpWQOKRTuxqyUnkx5z6svAzNN2M5FKziXFKTH2BlJwU4ngOkuOJnVV/cCR+1fCHVbfkqNJoaZXk3RQ4q1QHkWVkpNJJEV4Dz8KdmHokoyWHEtmzHTwzNPEDXU1iFJyPIm6DnEECVVa7LLVkmPJ5+1iylJ8zUtmUp1boV5yLGmDZk8bNcLzUrIZUUBLDiZPHqoMOq10RHEz/t6NknNJFQ5zaZQmwHCU3RJPybmk0o0BxiOzSCk8uZecTRrEmouKf4IpUS05l1S+ngettkjfvNe15HDS0OEyjDaC28NLwoa89ys5lxQsI2BuIoRk7lTys1ByLnmtYeNfbq8HjWLIvlAtOZcEECb18gGj4wWDgJWcTRq93ubtjVBlp2lO75KDyQtNQg73wiMM67oELDmXxBudaR/b5RK8d2RpJSeTTzEvHEpt1iG/w21KDicN2sjQ1+RpASEtgpal5GRyhTShHBhQhLMDUbwYJceS32aMa+0Dvr0W9MVQcjD5DfD4PXe96EhJitei5GTy6WDKelQUQciDvDV2oeRHkC6k5JcqpMu30JKfQOqzvTihdhdJbhGl5GTS0pVNOPLbqkRQnWlbci55EPglygcrMVuwKNwlR5M/ipJ3UfIuSt5FybsoeRcfRv4GZgkYI+pRDoMAAAAASUVORK5CYII='
--    ,'PENDENTE');