INSERT INTO clientes (cpf_cnpj, razao, nm_fantasia, proprietario, dt_vencimento, ativo, integrado, cep, logradouro, bairro,cidade, uf, estabelecimento) VALUES
    ('37620840000167','GLESIO SANTOS DA SILVA 96548517334','SANTOS AUTO CENTER',NULL, 0, false, false, '64010530','Rua Des. Caio Oliveira, 8115','Mocambinho', 'Teresina', 'PI', 'OMC');

INSERT INTO tb_cliente_contatos (cliente_id, contatos) VALUES
    ((SELECT id FROM clientes WHERE cpf_cnpj = '37620840000167'), '8698490423');