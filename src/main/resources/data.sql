INSERT INTO tb_cliente (cpf_cnpj, razao, nm_fantasia, proprietario, dt_vencimento, ativo) VALUES
    ('33074389000179','F F Nunes Comercio de Pecas e Servicos Mecanicos','Belauto Auto Center','Fábio Nunes Noranha', 0, false),
    ('37541733326','Ester Sabrina Sales','Oficina "Ô Sales"','Ester Sabrina Sales', 0, false);

INSERT INTO tb_cliente_contatos (cliente_id, contatos) VALUES
    ((SELECT id FROM tb_cliente WHERE cpf_cnpj = '33074389000179'), '+5586999928360'),
    ((SELECT id FROM tb_cliente WHERE cpf_cnpj = '33074389000179'), '+5586988819817');