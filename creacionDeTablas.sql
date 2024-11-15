
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
    categoria_id VARCHAR(50) NOT NULL REFERENCES Categoria(id),
    aptoVegano BOOLEAN NOT NULL,
    vendedor_id INT NOT NULL REFERENCES Vendedor(id),
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
    cliente_id INT NOT NULL REFERENCES Cliente(id),
    vendedor_id INT NOT NULL REFERENCES Vendedor(id),
    estado ENUM('RECIBIDO', 'EN_PREPARACION', 'EN_ENVIO', 'ENTREGADO') NOT NULL,
    precio DOUBLE NOT NULL,
    activo BOOLEAN NOT NULL
);

CREATE TABLE ItemPedido (
    id INT PRIMARY KEY,
    cantidad INT NOT NULL,
    item_id INT NOT NULL REFERENCES ItemMenu(id),
    pedido_id INT NOT NULL REFERENCES Pedido(id)
);

CREATE TABLE Pago (
    id INT PRIMARY KEY,
    fecha DATE NOT NULL,
    montoFinal DOUBLE NOT NULL,
    pedido_id INT NOT NULL REFERENCES Pedido(id)
);

CREATE TABLE EstrategiaTransferencia (
    id INT PRIMARY KEY,
    CUIT VARCHAR(15) NOT NULL,
    cbu VARCHAR(25) NOT NULL,
    recargo DOUBLE NOT NULL,
    pago_id INT NOT NULL REFERENCES Pago(id)
);

CREATE TABLE EstrategiaMercadoPago (
    id INT PRIMARY KEY,
    alias VARCHAR(50) NOT NULL,
    recargo DOUBLE NOT NULL,
    pago_id INT NOT NULL REFERENCES Pago(id)
);