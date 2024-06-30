-- Inserção de dados na tabela de Aplicativos
INSERT INTO Aplicativo (nome, custo_mensal) VALUES ('Spotgrid', 69.90);
INSERT INTO Aplicativo (nome, custo_mensal) VALUES ('Triolingo', 34.90);
INSERT INTO Aplicativo (nome, custo_mensal) VALUES ('Gustify', 19.90);
INSERT INTO Aplicativo (nome, custo_mensal) VALUES ('SpringBooks', 8.99);
INSERT INTO Aplicativo (nome, custo_mensal) VALUES ('Magoflixer', 59.90);

-- Script para inserir um cliente na tabela Cliente
INSERT INTO Cliente (nome, email) VALUES ('Gustavo Lopes', 'gustavo.lopes@emaildelicia.com');
INSERT INTO Cliente (nome, email) VALUES ('Matheus Silva', 'matheus.ss@emaildelicia.com');
INSERT INTO Cliente (nome, email) VALUES ('Maria Lima', 'maria.ll@emaildelicia.com');
INSERT INTO Cliente (nome, email) VALUES ('Brenda Meeks', 'meeks.brenda@emaildelicia.com');
INSERT INTO Cliente (nome, email) VALUES ('Fogell McLovin', 'mclovin@emaildelicia.com');
INSERT INTO Cliente (nome, email) VALUES ('Elle Woods', 'elle.ellewoods@emaildelicia.com');
INSERT INTO Cliente (nome, email) VALUES ('Jenna Rink', 'jenna.rink@emaildelicia.com');
INSERT INTO Cliente (nome, email) VALUES ('Lucas Machado', 'lucasmac@emaildelicia.com');
INSERT INTO Cliente (nome, email) VALUES ('Luiza Greets', 'luizagr@emaildelicia.com');
INSERT INTO Cliente (nome, email) VALUES ('Filipi Machado', 'filipi.machado@emaildelicia.com');

INSERT INTO Assinatura (codigo_aplicativo, codigo_cliente, status_atual, inicio_vigencia, fim_vigencia) VALUES (1, 1, 'ativo', '2024-06-30', '2024-07-30');
INSERT INTO Assinatura (codigo_aplicativo, codigo_cliente, status_atual, inicio_vigencia, fim_vigencia) VALUES (2, 2, 'ativo', '2024-07-01', '2024-08-01');
INSERT INTO Assinatura (codigo_aplicativo, codigo_cliente, status_atual, inicio_vigencia, fim_vigencia) VALUES (3, 3, 'inativo', '2024-05-05', '2024-06-05');
INSERT INTO Assinatura (codigo_aplicativo, codigo_cliente, status_atual, inicio_vigencia, fim_vigencia) VALUES (4, 4, 'inativo', '2024-03-03', '2024-04-03');
INSERT INTO Assinatura (codigo_aplicativo, codigo_cliente, status_atual, inicio_vigencia, fim_vigencia) VALUES (5, 5, 'ativo', '2024-07-04', '2024-08-04');
INSERT INTO Assinatura (codigo_aplicativo, codigo_cliente, status_atual, inicio_vigencia, fim_vigencia) VALUES (1, 6, 'ativo', '2024-07-05', '2024-08-05');
INSERT INTO Assinatura (codigo_aplicativo, codigo_cliente, status_atual, inicio_vigencia, fim_vigencia) VALUES (2, 7, 'ativo', '2024-07-06', '2024-08-06');