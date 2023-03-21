/* メニューマスタ　初期データ投入 */
INSERT INTO cuisine_master(cuisine_name) VALUES('カレーライス'),('パエリア'),('アクアパッツァ'),('ドリア'),('豚肉の生姜焼き'),('ブリの照り焼き');
/* ユーザーマスタ　初期データ投入 */
INSERT INTO user_master(user_name, password, role) VALUES('user', 'user_password', 'general'),('system', 'system_password', 'admin');