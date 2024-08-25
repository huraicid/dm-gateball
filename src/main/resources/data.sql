INSERT INTO decks (id, name)
    VALUES
        ('DMC-36', 'ヘヴン・オブ・ドラゴン'),
        ('DMC-37', 'バイオレンス・エンジェル');

INSERT INTO battle_results (home_id, away_id, is_win)
    VALUES
        ('DMC-36', 'DMC-37', 1),
        ('DMC-36', 'DMC-37', 0),
        ('DMC-37', 'DMC-36', 1),
        ('DMC-37', 'DMC-36', 1);