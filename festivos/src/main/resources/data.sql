INSERT INTO country (name) VALUES ('Colombia');

INSERT INTO holiday_type (id, name, mode) VALUES (1, 'Fijo', 1);
INSERT INTO holiday_type (id, name, mode) VALUES (2, 'Puente', 2);
INSERT INTO holiday_type (id, name, mode) VALUES (3, 'Pascua', 3);
INSERT INTO holiday_type (id, name, mode) VALUES (4, 'Pascua + Puente', 4);


INSERT INTO holiday (country_id, name, day, month, easter_offset, type_id)
VALUES (1, 'Día del Trabajo', 1, 5, NULL, 1);

INSERT INTO holiday (country_id, name, day, month, easter_offset, type_id)
VALUES (1, 'Domingo de Pascua', NULL, NULL, 0, 3);

INSERT INTO holiday (country_id, name, day, month, easter_offset, type_id)
VALUES (1, 'Corpus Christi', NULL, NULL, 61, 4);

INSERT INTO holiday (country_id, name, day, month, easter_offset, type_id)
VALUES (1, 'Sagrado Corazón', NULL, NULL, 68, 4);