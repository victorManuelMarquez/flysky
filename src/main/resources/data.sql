-- Insertar más datos para Aerolíneas
INSERT INTO aerolineas (nombre) VALUES
    ('LATAM Airlines'),
    ('Avianca'),
    ('Aerolíneas Argentinas'),
    ('Copa Airlines'),
    ('Azul Linhas Aéreas'),
    ('GOL Linhas Aéreas'),
    ('Sky Airlines'),
    ('TAM Airlines'),
    ('Aeroméxico'),
    ('Viva Air');

-- Insertar más datos para Aeropuertos
INSERT INTO aeropuertos (nombre, ciudad) VALUES
    ('Aeropuerto Internacional de São Paulo-Guarulhos', 'São Paulo'),
    ('Aeropuerto Internacional El Dorado', 'Bogotá'),
    ('Aeropuerto Internacional Ministro Pistarini', 'Buenos Aires'),
    ('Aeropuerto Internacional de Tocumen', 'Ciudad de Panamá'),
    ('Aeropuerto Internacional de Brasilia', 'Brasilia'),
    ('Aeropuerto Internacional de Lima', 'Lima'),
    ('Aeropuerto Internacional Comodoro Arturo Merino Benítez', 'Santiago'),
    ('Aeropuerto Internacional Jorge Chávez', 'Lima'),
    ('Aeropuerto Internacional Benito Juárez', 'Ciudad de México'),
    ('Aeropuerto Internacional José Joaquín de Olmedo', 'Guayaquil');

-- Insertar más datos para Aviones
INSERT INTO aviones (modelo, total_asientos) VALUES
    ('Boeing 737', 150),
    ('Airbus A320', 180),
    ('Boeing 787 Dreamliner', 240),
    ('Embraer E190', 100),
    ('Airbus A350', 300),
    ('Boeing 777', 200),
    ('Airbus A330', 250),
    ('Bombardier CRJ-900', 90),
    ('Boeing 747', 400),
    ('Embraer E195', 110);

-- Insertar más datos para Clases
INSERT INTO clases (nombre) VALUES
    ('Económica'),
    ('Primera Clase'),
    ('Clase Ejecutiva'),
    ('Económica Premium'),
    ('Premium Business'),
    ('Clase Turista'),
    ('Premium Economy'),
    ('Premium Plus'),
    ('Ultra Business'),
    ('Ultra Economy');

-- Insertar más datos para Pasajeros
INSERT INTO pasajeros (dni, nombres, apellidos, telefono, email) VALUES
    ('11111111', 'Juan', 'Gómez', '123456789', 'juan.gomez@example.com'),
    ('22222222', 'Ana', 'Martínez', '987654321', 'ana.martinez@example.com'),
    ('33333333', 'Carlos', 'Rodríguez', '555555555', 'carlos.rodriguez@example.com'),
    ('44444444', 'Laura', 'Hernández', '777777777', 'laura.hernandez@example.com'),
    ('55555555', 'Diego', 'López', '111111111', 'diego.lopez@example.com'),
    ('66666666', 'Valeria', 'González', '999999999', 'valeria.gonzalez@example.com'),
    ('77777777', 'Javier', 'Ramírez', '444444444', 'javier.ramirez@example.com'),
    ('88888888', 'Camila', 'Pérez', '333333333', 'camila.perez@example.com'),
    ('99999999', 'Mateo', 'Díaz', '666666666', 'mateo.diaz@example.com'),
    ('10101010', 'Isabella', 'Fernández', '888888888', 'isabella.fernandez@example.com');

-- Insertar más datos para Usuarios
INSERT INTO usuarios (email, clave) VALUES
    ('usuario3@example.com', 'clave3'),
    ('usuario4@example.com', 'clave4'),
    ('usuario5@example.com', 'clave5'),
    ('usuario6@example.com', 'clave6'),
    ('usuario7@example.com', 'clave7'),
    ('usuario8@example.com', 'clave8'),
    ('usuario9@example.com', 'clave9'),
    ('usuario10@example.com', 'clave10'),
    ('usuario11@example.com', 'clave11'),
    ('usuario12@example.com', 'clave12');

-- Insertar más datos para Vuelos
INSERT INTO vuelos (id_aerolinea, salida, llegada, id_origen, id_destino) VALUES
    (1, '2023-01-03 08:00:00', '2023-01-03 12:00:00', 3, 4),
    (2, '2023-01-04 14:00:00', '2023-01-04 18:00:00', 4, 3),
    (3, '2023-01-05 10:00:00', '2023-01-05 14:00:00', 5, 6),
    (4, '2023-01-06 12:00:00', '2023-01-06 16:00:00', 6, 5),
    (5, '2023-01-07 15:00:00', '2023-01-07 19:00:00', 7, 8),
    (6, '2023-01-08 18:00:00', '2023-01-08 22:00:00', 8, 7),
    (7, '2023-01-09 16:00:00', '2023-01-09 20:00:00', 9, 10),
    (8, '2023-01-10 20:00:00', '2023-01-10 00:00:00', 10, 9),
    (9, '2023-01-11 22:00:00', '2023-01-12 02:00:00', 1, 2),
    (10, '2023-01-13 14:00:00', '2023-01-13 18:00:00', 2, 1);

-- Insertar más datos para Reservas
INSERT INTO reservas (id_usuario, id_vuelo, id_pasajero, fecha_reserva, comprobante, cancelada) VALUES
    (5, 5, 5, '2023-01-07 14:00:00', 'MNO345', false),
    (6, 6, 6, '2023-01-08 16:00:00', 'PQR678', false),
    (7, 7, 7, '2023-01-09 18:00:00', 'STU901', false),
    (8, 8, 8, '2023-01-10 22:00:00', 'VWX234', false),
    (9, 9, 9, '2023-01-11 20:00:00', 'YZA567', false),
    (10, 10, 10, '2023-01-12 12:00:00', 'BCD890', false),
    (1, 1, 1, '2023-01-13 10:00:00', 'EFG123', false),
    (2, 2, 2, '2023-01-14 08:00:00', 'HIJ456', false),
    (3, 3, 3, '2023-01-15 06:00:00', 'KLM789', false),
    (4, 4, 4, '2023-01-16 04:00:00', 'NOP012', false);

-- Insertar más datos para Flotas
INSERT INTO flotas (id_aerolinea, id_avion) VALUES
    (5, 5),
    (6, 6),
    (7, 7),
    (8, 8),
    (9, 9),
    (10, 10),
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4);


-- Insertar más datos para Asientos
INSERT INTO asientos (id_clase, precio, cantidad) VALUES
    (3, 120.00, 150),
    (1, 500.00, 30),
    (2, 200.00, 50),
    (4, 250.00, 40),
    (5, 300.00, 20),
    (1, 150.00, 60),
    (2, 400.00, 25),
    (3, 180.00, 35),
    (4, 220.00, 45),
    (5, 280.00, 15);

-- Insertar más datos para ClasesPorAviones
INSERT INTO clases_por_aviones (id_avion, id_asiento) VALUES
    (5, 5),
    (6, 6),
    (7, 7),
    (8, 8),
    (9, 9),
    (10, 10),
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4);
    -- Insertar más datos para Pagos

    INSERT INTO pagos (id_reserva, tipo_pago, fecha_pago) VALUES
        (1, 'Tarjeta de Crédito', '2023-01-07 15:30:00'),
        (2, 'Transferencia Bancaria', '2023-01-08 17:45:00'),
        (3, 'Tarjeta de Débito', '2023-01-09 19:20:00'),
        (4, 'Tarjeta de Crédito', '2023-01-10 23:05:00'),
        (5, 'Transferencia Bancaria', '2023-01-11 21:15:00'),
        (6, 'Tarjeta de Débito', '2023-01-12 13:40:00'),
        (7, 'Tarjeta de Crédito', '2023-01-13 11:55:00'),
        (8, 'Transferencia Bancaria', '2023-01-14 09:10:00'),
        (9, 'Tarjeta de Débito', '2023-01-15 07:25:00');


