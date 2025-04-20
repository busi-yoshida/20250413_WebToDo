-- 1件目のデータ登録
INSERT INTO todos (todo, detail, created_at, updated_at) 
VALUES 
('買い物', 'スーパーで食材を購入する', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
-- 2件目のデータ登録
INSERT INTO todos (todo, detail, created_at, updated_at) 
VALUES 
('図書館に行く', '本を借りる', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
-- 3件目のデータ登録
INSERT INTO todos (todo, detail, created_at, updated_at) 
VALUES 
('ジムに行く', '運動する', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 4件目のデータ登録（自分で追加）
INSERT INTO todos (todo, detail, created_at, updated_at) 
VALUES 
('TestToDo', 'TestDetail', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 認証テーブルへのダミーデータの追加
INSERT INTO authentications (username, password) VALUES 
('admin', '$2a$10$ZgIrF5dYtZCRhwtSE.X8e.L6Oz1yxXFpVCLZvyHi8DS13xBYQlSiS');