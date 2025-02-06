INSERT INTO tb_usuario (avatar, nome, email, senha, ativo, perfil) VALUES
    ('user.png', 'administrador', 'admin@ohgestor.com.br', '123456', true, 'ADMIN');


INSERT INTO tb_cliente (cpf_cnpj, razao, nm_fantasia, proprietario, dt_vencimento, ativo, integrado, cep, logradouro, bairro,cidade, uf, estabelecimento) VALUES
    ('33074389000179','F F Nunes Comercio de Pecas e Servicos Mecanicos','Belauto Auto Center','Fábio Nunes Noranha', 0, false, true, '64010025','Av  Prefeito Freitas Neto, 38, Quadrar Lote 38','Mocambinho', 'Teresina', 'PI', 'CAU'),
    ('37541733326','Ester Sabrina Sales','Oficina "Ô Sales"','Ester Sabrina Sales', 0, false, false, '64045200','Av Noronha Almeida,575','Noivos','Teresina','PI', 'OME');

INSERT INTO tb_cliente_contatos (cliente_id, contatos) VALUES
    ((SELECT id FROM tb_cliente WHERE cpf_cnpj = '33074389000179'), '+5586999928360'),
    ((SELECT id FROM tb_cliente WHERE cpf_cnpj = '33074389000179'), '+5586988819817'),
    ((SELECT id FROM tb_cliente WHERE cpf_cnpj = '37541733326'), '+5586992198688');