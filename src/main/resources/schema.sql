-- Tabla de Vendedores (Para JPA)
CREATE TABLE vendedor (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    codigo_empleado VARCHAR(20) UNIQUE
);

-- Tabla de Productos (Para JPA)
CREATE TABLE producto (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio DOUBLE NOT NULL
);

-- Tabla de Ventas (Para Queries Manuales/Joins)
CREATE TABLE venta (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    vendedor_id BIGINT,
    producto_id BIGINT,
    cantidad INT,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (vendedor_id) REFERENCES vendedor(id),
    FOREIGN KEY (producto_id) REFERENCES producto(id)
);
