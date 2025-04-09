CREATE TABLE IF NOT EXISTS usuarios (
    id VARCHAR(150) NOT NULL PRIMARY KEY DEFAULT REPLACE(uuid_generate_v4()::text, '-',''),
    avatar VARCHAR(150) NOT NULL,
    nome VARCHAR(150) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    senha VARCHAR(150) NOT NULL,
    ativo boolean NOT NULL DEFAULT 'false',
    perfil CHAR(5) NOT NULL DEFAULT 'COMUM',
    dt_criado_em DATE NOT NULL DEFAULT 'now()',
    dt_atualizado_em DATE
);