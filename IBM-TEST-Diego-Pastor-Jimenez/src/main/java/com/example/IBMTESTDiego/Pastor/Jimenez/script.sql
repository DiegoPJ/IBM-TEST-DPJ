CREATE DATABASE IF NOT EXISTS bd_ibm;

USE bd_ibm;

CREATE TABLE proveedores (
    id_proveedor INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    fecha_alta DATE NOT NULL,
    id_cliente INT NOT NULL
);

INSERT INTO proveedores (nombre, fecha_alta, id_cliente)
VALUES ('Coca-cola', '2022-01-01', 5),
       ('Pepsi', '2022-02-15', 5),
       ('Redbull', '2022-03-10', 6);
