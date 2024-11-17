CREATE DATABASE desotest;

USE desotest;

CREATE TABLE Cliente (
    id INT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    CUIT VARCHAR(15) UNIQUE NOT NULL,
    email VARCHAR(50) NOT NULL,
    direccion VARCHAR(50) NOT NULL,
    lat DOUBLE NOT NULL,
    lng DOUBLE NOT NULL,
    activo BOOLEAN NOT NULL
);

CREATE TABLE Vendedor (
    id INT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    direccion VARCHAR(50) NOT NULL,
    lat DOUBLE NOT NULL,
    lng DOUBLE NOT NULL,
    activo BOOLEAN NOT NULL
);

CREATE TABLE ItemMenu (
    id INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255) NOT NULL,
    precio FLOAT NOT NULL,
    categoriaId VARCHAR(50) NOT NULL REFERENCES Categoria(id),
    aptoVegano BOOLEAN NOT NULL,
    vendedorId INT NOT NULL REFERENCES Vendedor(id),
    activo BOOLEAN NOT NULL
);

CREATE TABLE Plato (
    id INT PRIMARY KEY REFERENCES ItemMenu(id),
    calorias INT NOT NULL,
    aptoCeliaco BOOLEAN NOT NULL,
    peso FLOAT NOT NULL
);

CREATE TABLE Bebida (
    id INT PRIMARY KEY REFERENCES ItemMenu(id),
    graduacionAlcoholica FLOAT NOT NULL,
    tamaño INT NOT NULL
);

CREATE TABLE Categoria (
    id INT PRIMARY KEY,
    descripcion VARCHAR(255) NOT NULL,
    tipoItem ENUM('PLATO', 'BEBIDA') NOT NULL
);

CREATE TABLE Pedido (
    id INT PRIMARY KEY,
    clienteId INT NOT NULL REFERENCES Cliente(id),
    vendedorId INT NOT NULL REFERENCES Vendedor(id),
    estado ENUM('RECIBIDO', 'EN_PREPARACION', 'EN_ENVIO', 'ENTREGADO') NOT NULL,
    precio DOUBLE NOT NULL,
    activo BOOLEAN NOT NULL
);

CREATE TABLE ItemPedido (
    id INT PRIMARY KEY,
    cantidad INT NOT NULL,
    itemId INT NOT NULL REFERENCES ItemMenu(id),
    pedidoId INT NOT NULL REFERENCES Pedido(id)
);

CREATE TABLE Pago (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE NOT NULL,
    montoFinal DOUBLE NOT NULL,
    pedidoId INT NOT NULL REFERENCES Pedido(id)
);

CREATE TABLE EstrategiaTransferencia (
    id INT AUTO_INCREMENT PRIMARY KEY,
    CUIT VARCHAR(15) NOT NULL,
    cbu VARCHAR(25) NOT NULL,
    pagoId INT NOT NULL REFERENCES Pago(id)
);

CREATE TABLE EstrategiaMercadoPago (
    id INT AUTO_INCREMENT PRIMARY KEY,
    alias VARCHAR(50) NOT NULL,
    pagoId INT NOT NULL REFERENCES Pago(id)
);

INSERT INTO Cliente (id, nombre, CUIT, email, direccion, lat, lng, activo) VALUES
(1, 'Juan Perez', '20-12345678-9', 'juan.perez@example.com', 'Calle Falsa 123', -34.603722, -58.381592, TRUE),
(2, 'Maria Gomez', '27-98765432-1', 'maria.gomez@example.com', 'Avenida Siempre Viva 742', -34.615852, -58.433298, TRUE),
(3, 'Pedro Sanchez', '23-45678901-2', 'pedro.sanchez@example.com', 'Calle Nueva 456', -34.603000, -58.381000, TRUE),
(4, 'Laura Fernandez', '24-65432109-8', 'laura.fernandez@example.com', 'Avenida Antartida 123', -34.615000, -58.433000, TRUE),
(5, 'Luis Rodriguez', '21-23456789-0', 'luis.rodriguez@example.com', 'Calle Falsa 456', -34.603800, -58.381800, TRUE),
(6, 'Carla Suarez', '22-34567890-1', 'carla.suarez@example.com', 'Avenida Siempre Viva 123', -34.615900, -58.433400, TRUE);

INSERT INTO Vendedor (id, nombre, direccion, lat, lng, activo) VALUES
(1, 'La Milanesa Feliz', 'Calle Verdadera 456', -34.608722, -58.370592, TRUE),
(2, 'Cervezas Artesanales', 'Avenida Real 789', -34.620852, -58.400298, TRUE),
(3, 'Ensaladas Verdes', 'Calle Antigua 789', -34.608000, -58.370000, TRUE),
(4, 'Jugos Naturales', 'Avenida Libertador 456', -34.620000, -58.400000, TRUE),
(5, 'Pizzas Deliciosas', 'Calle Verdadera 789', -34.608800, -58.370800, TRUE),
(6, 'Postres y Más', 'Avenida Real 123', -34.620900, -58.400400, TRUE);

INSERT INTO Categoria (id, descripcion, tipoItem) VALUES
(1, 'Platos Principales', 'PLATO'),
(2, 'Bebidas Alcoholicas', 'BEBIDA'),
(3, 'Postres', 'PLATO'),
(4, 'Bebidas Sin Alcohol', 'BEBIDA'),
(5, 'Gaseosas', 'BEBIDA'),
(6, 'Hamburguesas', 'PLATO'),
(7, 'Helados', 'PLATO'),
(8, 'Vinos', 'BEBIDA'),
(9, 'Pastas', 'PLATO'),
(10, 'Carnes', 'PLATO'),
(11, 'Verduras', 'PLATO'),
(12, 'Harinas', 'PLATO'),
(13, 'Cervezas', 'BEBIDA');

INSERT INTO ItemMenu (id, nombre, descripcion, precio, categoriaId, aptoVegano, vendedorId, activo) VALUES
(1, 'Milanesa con Papas', 'Milanesa de carne con papas fritas', 500.00, 1, FALSE, 1, TRUE),
(2, 'Cerveza Artesanal', 'Cerveza artesanal rubia', 150.00, 2, FALSE, 2, TRUE),
(3, 'Ensalada Caesar', 'Ensalada con pollo, lechuga y aderezo Caesar', 300.00, 1, TRUE, 3, TRUE),
(4, 'Jugo de Naranja', 'Jugo de naranja natural', 100.00, 4, TRUE, 4, TRUE),
(5, 'Hamburguesa Completa', 'Hamburguesa con queso, lechuga, tomate y papas fritas', 600.00, 6, FALSE, 1, TRUE),
(6, 'Helado de Chocolate', 'Helado de chocolate artesanal', 200.00, 7, TRUE, 2, TRUE),
(7, 'Vino Tinto', 'Vino tinto Malbec', 700.00, 8, FALSE, 3, TRUE),
(8, 'Spaghetti Bolognese', 'Spaghetti con salsa bolognese', 450.00, 9, FALSE, 4, TRUE),
(9, 'Bife de Chorizo', 'Bife de chorizo con ensalada', 800.00, 1, TRUE, 5, TRUE),
(10, 'Ensalada de Verduras', 'Ensalada de verduras frescas', 300.00, 11, TRUE, 2, TRUE),
(11, 'Pizza Margarita', 'Pizza con tomate, mozzarella y albahaca', 500.00, 12, TRUE, 3, TRUE),
(12, 'Cerveza Negra', 'Cerveza negra artesanal', 180.00, 13, FALSE, 4, TRUE);

INSERT INTO Plato (id, calorias, aptoCeliaco, peso) VALUES
(1, 800, FALSE, 300.00),
(3, 200, TRUE, 150.00),
(5, 900, FALSE, 350.00),
(6, 250, TRUE, 200.00),
(8, 600, FALSE, 400.00),
(9, 1200, FALSE, 500.00),
(10, 150, TRUE, 250.00),
(11, 800, TRUE, 450.00);

INSERT INTO Bebida (id, graduacionAlcoholica, tamaño) VALUES
(2, 5.0, 500),
(4, 0.0, 300),
(7, 13.5, 750),
(12, 6.0, 500);

INSERT INTO Pedido (id, clienteId, vendedorId, estado, precio, activo) VALUES
(1, 1, 1, 'RECIBIDO', 650.00, TRUE),
(2, 2, 2, 'EN_PREPARACION', 150.00, TRUE),
(3, 3, 3, 'EN_ENVIO', 300.00, TRUE),
(4, 4, 4, 'ENTREGADO', 100.00, TRUE),
(5, 1, 2, 'RECIBIDO', 600.00, TRUE),
(6, 2, 3, 'EN_PREPARACION', 200.00, TRUE),
(7, 3, 4, 'EN_ENVIO', 700.00, TRUE),
(8, 4, 1, 'ENTREGADO', 450.00, TRUE);

INSERT INTO ItemPedido (id, cantidad, itemId, pedidoId) VALUES
(1, 2, 1, 1),
(2, 3, 2, 2),
(3, 1, 3, 3),
(4, 2, 4, 4),
(5, 1, 5, 5),
(6, 2, 6, 6),
(7, 1, 7, 7),
(8, 3, 8, 8);

INSERT INTO Pago (id, fecha, montoFinal, pedidoId) VALUES
(1, '2023-10-01', 650.00, 1),
(2, '2023-10-02', 150.00, 2),
(3, '2023-10-03', 300.00, 3),
(4, '2023-10-04', 100.00, 4),
(5, '2023-10-05', 600.00, 5),
(6, '2023-10-06', 200.00, 6),
(7, '2023-10-07', 700.00, 7),
(8, '2023-10-08', 450.00, 8);

INSERT INTO EstrategiaTransferencia (id, CUIT, cbu, pagoId) VALUES
(1, '20-12345678-9', '1234567890123456789012', 1),
(2, '23-45678901-2', '2345678901234567890123', 3),
(3, '27-98765432-1', '3456789012345678901234', 5),
(4, '24-65432109-8', '4567890123456789012345', 7);

INSERT INTO EstrategiaMercadoPago (id, alias, pagoId) VALUES
(1, 'alias.mercadopago', 2),
(2, 'alias.mercadopago2', 4),
(3, 'alias.mercadopago3', 6),
(4, 'alias.mercadopago4', 8);
