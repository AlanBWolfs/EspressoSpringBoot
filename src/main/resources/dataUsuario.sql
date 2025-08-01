-- Base de datos
DROP DATABASE IF EXISTS espressoCafe;
CREATE DATABASE espressoCafe;
USE espressoCafe;

-- =========================
-- TABLA ROLES
-- =========================
CREATE TABLE roles_descripcion (
    id_rol BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre_rol VARCHAR(50) NOT NULL UNIQUE
);

INSERT INTO roles_descripcion (nombre_rol) VALUES
('admin'),
('cliente');

-- =========================
-- TABLA USUARIOS
-- =========================
CREATE TABLE usuarios (
    id_usuario BIGINT AUTO_INCREMENT PRIMARY KEY,
    correo_electronico VARCHAR(100) NOT NULL UNIQUE,
    nombre_usuario VARCHAR(50) NOT NULL,
    numero_telefonico VARCHAR(10),
    contrasena VARCHAR(60) NOT NULL,
    id_rol BIGINT,
    CONSTRAINT fk_usuario_rol FOREIGN KEY (id_rol) REFERENCES roles_descripcion(id_rol)
);

-- =========================
-- TABLA TRANSACCIONES (simplificada)
-- =========================
CREATE TABLE transacciones (
    id_transaccion BIGINT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(255),
    monto DECIMAL(10,2),
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    id_usuario BIGINT,
    CONSTRAINT fk_transaccion_usuario FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

-- =========================
-- TABLA DIRECTIONS (simplificada)
-- =========================
CREATE TABLE directions (
    id_direccion BIGINT AUTO_INCREMENT PRIMARY KEY,
    calle VARCHAR(255),
    ciudad VARCHAR(100),
    codigo_postal VARCHAR(10),
    id_usuario BIGINT,
    CONSTRAINT fk_direccion_usuario FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

-- =========================
-- USUARIOS DE PRUEBA
-- (Las contraseñas están encriptadas con BCrypt para '123456')
-- =========================
INSERT INTO usuarios (correo_electronico, nombre_usuario, numero_telefonico, contrasena, id_rol) VALUES
('admin@espresso.com', 'Administrador', '5551234567', '$2a$10$7Q7Ete49XytP9GqAZkRHOunM/hP8SCN/I2dkTJDtF/wROFZ4MyeUO', 1),
('cliente@mail.com', 'Cliente Demo', '5559876543', '$2a$10$Cjqlmjp9Zm3Md/DzqNwE.e3LSKBQb7RNV8veZhCyHoBYtnPlUif62', 2);
