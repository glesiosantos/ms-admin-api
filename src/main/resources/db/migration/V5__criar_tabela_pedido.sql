CREATE TABLE IF NOT EXISTS pedidos (
    id VARCHAR(150) NOT NULL PRIMARY KEY DEFAULT REPLACE(uuid_generate_v4()::text, '-',''),
    cliente_id VARCHAR(150) NOT NULL,
    plano CHAR(5),
    situacao VARCHAR(15) NOT NULL DEFAULT 'PENDENTE',
    usuario_responsavel_id VARCHAR(150) NOT NULL,
    qr_code TEXT,
    chave_compartilhamento VARCHAR(250),
    id_cob_asaas VARCHAR(150),
    dt_expiracao VARCHAR(50),
    dt_criado_em DATE NOT NULL DEFAULT 'now()',
    dt_atualizado_em DATE,
    CONSTRAINT fk_cliente_pedido FOREIGN KEY (cliente_id) REFERENCES clientes(id) ON DELETE CASCADE ON UPDATE NO ACTION,
    CONSTRAINT fk_responsavel_pedido FOREIGN KEY (usuario_responsavel_id) REFERENCES usuarios(id) ON DELETE NO ACTION ON UPDATE NO ACTION
);