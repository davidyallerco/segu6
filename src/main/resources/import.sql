-- CREACIÓN DE CATEGORIAS
INSERT INTO categoria (nombre, estado) VALUES ('Electrónica', 'ENABLED');
INSERT INTO categoria (nombre, estado) VALUES ('Ropa', 'ENABLED');
INSERT INTO categoria (nombre, estado) VALUES ('Deportes', 'ENABLED');
INSERT INTO categoria (nombre, estado) VALUES ('Hogar', 'ENABLED');

-- CREACIÓN DE PRODUCTOS
INSERT INTO producto (nombre, precio, estado, categoria_id) VALUES ('Smartphone', 500.00, 'ENABLED', 1);
INSERT INTO producto (nombre, precio, estado, categoria_id) VALUES ('Auriculares Bluetooth', 50.00, 'DISABLED', 1);
INSERT INTO producto (nombre, precio, estado, categoria_id) VALUES ('Tablet', 300.00, 'ENABLED', 1);

INSERT INTO producto (nombre, precio, estado, categoria_id) VALUES ('Camiseta', 25.00, 'ENABLED', 2);
INSERT INTO producto (nombre, precio, estado, categoria_id) VALUES ('Pantalones', 35.00, 'ENABLED', 2);
INSERT INTO producto (nombre, precio, estado, categoria_id) VALUES ('Zapatos', 45.00, 'ENABLED', 2);

INSERT INTO producto (nombre, precio, estado, categoria_id) VALUES ('Balón de Fútbol', 20.00, 'ENABLED', 3);
INSERT INTO producto (nombre, precio, estado, categoria_id) VALUES ('Raqueta de Tenis', 80.00, 'DISABLED', 3);

INSERT INTO producto (nombre, precio, estado, categoria_id) VALUES ('Aspiradora', 120.00, 'ENABLED', 4);
INSERT INTO producto (nombre, precio, estado, categoria_id) VALUES ('Licuadora', 50.00, 'ENABLED', 4);