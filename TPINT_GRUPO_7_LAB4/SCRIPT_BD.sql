create database TIF_LAB4;
use TIF_LAB4;
CREATE TABLE TipoDeCuentas (
 numeroTipoCuenta int primary key,  
 descripcionCuenta VARCHAR(32)
);
CREATE TABLE TipoDeClientes (
 numeroTipoCliente int primary key,  
 descripcionCliente VARCHAR(32)
);
 create table Clientes
  ( DNI_CL char(32) primary key,
  Nombre_CL char(32),
  Apellido_CL char(32),
  TipoUsuario_CL int,
  Sexo_CL char(1),
  CorreoElectronico_CL char(32),
  Nacionalidad_CL char(32),
  FechaNacimiento_CL date,
  Direccion_CL char(32),
  Localidad_CL char(32),
  Provincia_CL char(32),
  Telefono_CL char(32),
  nombreUsuario_CL char(32) unique,
  contrasenaUsuario_CL char(32),
  Estado_CL boolean,
  FOREIGN KEY (TipoUsuario_CL) REFERENCES tipodeclientes(numeroTipoCliente)
  );

CREATE TABLE Cuentas (
    numeroDeCuenta INT auto_increment primary key ,
    DNICliente_Cuenta VARCHAR(32),
    CBU VARCHAR(32) unique,
    tipoCuenta int,
    fechaDeCreacion DATE,
    saldo FLOAT,
    estado boolean,
    FOREIGN KEY (tipoCuenta) REFERENCES tipodecuentas(numeroTipoCuenta),
	FOREIGN KEY (DNICliente_Cuenta) REFERENCES Clientes(DNI_CL)
);

  CREATE TABLE MovimientosCuentas (
  numeroMovimiento INT auto_increment primary key ,
  numeroCuentaEmisor int ,
  numeroCuentaReceptor int ,
  montoEnviado float,
  FechaMovimiento DATE ,
  DetalleMovimiento VARCHAR(32),
  tipoMovimineto VARCHAR(32),
  FOREIGN KEY (numeroCuentaEmisor) REFERENCES Cuentas(numeroDeCuenta),
  FOREIGN KEY (numeroCuentaReceptor) REFERENCES Cuentas(numeroDeCuenta)
  );
    CREATE TABLE Prestamos (
  numeroPrestamo INT auto_increment primary key ,
  numeroCuentaSolocita int ,
  montoPedido float,
  montoConInteres float,
  FechaPrestamo DATE ,
  CuotasPrestamo int,
  EstadoPrestamo boolean,
  FOREIGN KEY (numeroCuentaSolocita) REFERENCES Cuentas(numeroDeCuenta)
  );
  
/*  DELIMITER //
//REATE TRIGGER insertUsuario
AFTER INSERT ON clientes
FOR EACH ROW
BEGIN
    INSERT INTO Usuarios (data) VALUES (clientes.DNI_CL, clientes.DNI_CL, 1);
END;
//
DELIMITER ;*/
INSERT INTO tipodecuentas(numeroTipoCuenta,descripcionCuenta) VALUES(1, 'Caja de Ahorro'),(2,'Cuenta Corriente');
INSERT INTO tipodeclientes(numeroTipoCliente,descripcionCliente) VALUES(1, 'Banco'),(0,'Cliente');
  Insert into Clientes (DNI_CL,Nombre_CL,Apellido_CL,TipoUsuario_CL,Sexo_CL,CorreoElectronico_CL,Nacionalidad_CL,FechaNacimiento_CL,Direccion_CL,Localidad_Cl,Provincia_CL,Telefono_CL,nombreUsuario_CL,contrasenaUsuario_CL,Estado_CL) VALUES
  (1,'ADMIN','ADMIN',1,'M',1,1,'2023-10-29 ',1,1,1,1,'ADMIN','ADMIN',1),
  (2,'Carlos','Perez',0,'M','cp@gmail.com','Argentina','2002-10-29 ','Av Libertador 123','Tigre','BsAs','1122334455','carlos','carlos',1),
  (3,'Maria','Smith',0,'F','ms@hotmail.com','Argentina','2003-6-11 ','3 de febrero 678','Don Torcuato','BsAs','22113344','maria','maria',1),
 ('12345678', 'Juan', 'González', '0', 'M', 'juan.gonzalez@example.com', 'Español', '1990-06-15', 'Calle 123', 'Ciudad', 'Madrid', '123456789', 'juango', 'clave123', 1),
    ('98765432', 'María', 'López', '0', 'F', 'maria.lopez@example.com', 'Mexicana', '1988-08-22', 'Avenida 456', 'Pueblo', 'Ciudad de México', '987654321', 'marialo', 'contraseña456', 1),
    ('55556666', 'Pedro', 'Martínez', '0', 'M', 'pedro.martinez@example.com', 'Argentino', '1995-03-10', 'Carrera 789', 'Villa', 'Buenos Aires', '654321098', 'pedromtz', 'password789', 1),
    ('11112223', 'Laura', 'Gómez', '0', 'F', 'laura.gomez@example.com', 'Colombiana', '1992-11-05', 'Calle 456', 'Pueblo', 'Bogotá', '789012345', 'laurag', 'contraseña789', 1),
    ('33334444', 'Alejandro', 'Hernández', '0', 'M', 'alejandro.hernandez@example.com', 'Chileno', '1987-04-20', 'Avenida 789', 'Comuna', 'Santiago', '345678901', 'alejandroh', 'password123', 1),
    ('55557777', 'Carolina', 'Rodríguez', '0', 'F', 'carolina.rodriguez@example.com', 'Venezolana', '1994-09-15', 'Calle 789', 'Ciudad', 'Caracas', '567890123', 'carolr', 'contraseña234', 1),
    ('99998888', 'Roberto', 'Sánchez', '0', 'M', 'roberto.sanchez@example.com', 'Uruguayo', '1985-02-28', 'Avenida 123', 'Villa', 'Montevideo', '890123456', 'robertos', 'password567', 1),
    ('44445555', 'Ana', 'Pérez', '0', 'F', 'ana.perez@example.com', 'Paraguaya', '1991-07-10', 'Carrera 012', 'Pueblo', 'Asunción', '012345678', 'anap', 'contraseña890', 1),
    ('77776666', 'Javier', 'Fernández', '0', 'M', 'javier.fernandez@example.com', 'Ecuatoriano', '1989-12-03', 'Avenida 234', 'Ciudad', 'Quito', '234567890', 'javierf', 'password901', 1),
    ('22221112', 'Isabel', 'López', '0', 'F', 'isabel.lopez@example.com', 'Peruana', '1993-05-20', 'Calle 567', 'Villa', 'Lima', '456789012', 'isabell', 'contraseña234', 1),
    ('88887777', 'Miguel', 'García', '0', 'M', 'miguel.garcia@example.com', 'Boliviano', '1986-10-18', 'Carrera 789', 'Comuna', 'La Paz', '678901234', 'miguelg', 'password567', 1),
    ('12321', 'Elena', 'Díaz', '0', 'F', 'elena.diaz@example.com', 'Panameña', '1996-02-15', 'Avenida 345', 'Pueblo', 'Ciudad de Panamá', '789012345', 'elenad', 'contraseña890', 1),
    ('3213123', 'Ricardo', 'Herrera', '0', 'M', 'ricardo.herrera@example.com', 'Costarricense', '1984-08-22', 'Calle 678', 'Ciudad', 'San José', '012345678', 'ricardoh', 'password901', 1),
    ('22221111', 'Susana', 'Ramírez', '0', 'F', 'susana.ramirez@example.com', 'Dominicana', '1997-11-05', 'Avenida 901', 'Pueblo', 'Santo Domingo', '234567890', 'susanar', 'contraseña234', 1),
    ('88887778', 'Antonio', 'Moreno', '0', 'M', 'antonio.moreno@example.com', 'Cubano', '1983-04-20', 'Carrera 234', 'Ciudad', 'La Habana', '345678901', 'antoniom', 'password567', 1),
    ('66665555', 'Carmen', 'Jiménez', '0', 'F', 'carmen.jimenez@example.com', 'Puertorriqueña', '1998-09-15', 'Calle 567', 'Villa', 'San Juan', '456789012', 'carmenj', 'contraseña890', 1);
  
  INSERT INTO Cuentas (DNICliente_Cuenta, CBU, tipoCuenta,fechaDeCreacion, saldo, estado) VALUES 
	(1, '1',1, '2023-10-30', 9999999999.00, 1),
	('12345678', '234537890', 1, '2023-01-01', 5000.00, 1),
    ('98765432', '345678901', 2,'2023-01-02', 8000.00, 1),
    ('55556666', '456782012', 2,'2023-01-03', 3000.00, 1),
    ('11112223', '527890123', 1,'2023-01-04', 10000.00, 1),
    ('33334444', '278901234',2, '2023-01-05', 6000.00, 1),
    ('55557777', '389012345', 1,'2023-01-06', 7500.00, 1),
    ('99998888', '890323456', 2,'2023-01-07', 12000.00, 1),
    ('44445555', '901234567', 2,'2023-01-08', 4000.00, 1),
    ('77776666', '012345678', 2,'2023-01-09', 9000.00, 1),
    ('22221112', '123456789', 1,'2023-01-10', 11000.00, 1),
    ('88887777', '234567890', 1,'2023-01-11', 7000.00, 1),
    ('66665555', '335678901', 2,'2023-01-12', 9500.00, 1),
    ('12321', 	 '656789012', 1,'2023-01-13', 8300.00, 1),
    ('22221111', '867890123', 2,'2023-01-14', 6200.00, 1),
    ('88887777', '978901234', 1,'2023-01-15', 11500.00, 1),
    ('3213123',  '893223456', 2,'2023-01-16', 7700.00, 1),
     ('2', 		 '890123456', 2,'2023-01-16', 7700.00, 1),
      ('2', '890123452', 2,'2023-01-16', 7700.00, 1),
       ('2', '890123453', 2,'2023-01-16', 7700.00, 1);
  insert into movimientoscuentas (numeroCuentaEmisor,numeroCuentaReceptor,montoEnviado,FechaMovimiento,DetalleMovimiento,tipoMovimineto) values 
  (1,2,200,'2023-10-30','Sueldo', 'Trasnferencia'),
  (1,3,200,'2023-10-30','Sueldo', 'Trasnferencia'),
  (4,11,200,'2023-10-30','Sueldo', 'Trasnferencia'),
  (12,14,200,'2023-10-30','Sueldo', 'Trasnferencia'),
  (1,4,200,'2023-10-30','Sueldo', 'Trasnferencia'),
  (5,6,200,'2023-10-30','Sueldo', 'Trasnferencia'),
  (8,9,200,'2023-10-30','Sueldo', 'Trasnferencia'),
  (7,11,200,'2023-10-30','Sueldo', 'Trasnferencia'),
  (10,16,200,'2023-10-30','Sueldo', 'Trasnferencia'),
  (15,12,200,'2023-10-30','Sueldo', 'Trasnferencia'),
  (2,3,1200,'2023-10-30','Sueldo', 'Trasnferencia'),
  (4,5,1200,'2023-10-30','Sueldo', 'Trasnferencia'),
  (6,7,1200,'2023-10-30','Sueldo', 'Trasnferencia'),
  (8,9,1200,'2023-10-30','Sueldo', 'Trasnferencia'),
  (10,11,1200,'2023-10-30','Sueldo', 'Trasnferencia'),
  (12,13,1200,'2023-10-30','Sueldo', 'Trasnferencia'),
  (14,15,1200,'2023-10-30','Sueldo', 'Trasnferencia'),
  (16,17,1200,'2023-10-30','Sueldo', 'Trasnferencia'),
  (17,1,1200,'2023-10-30','Sueldo', 'Trasnferencia'),
  (12,1,1200,'2023-10-30','Sueldo', 'Trasnferencia');
  
 INSERT INTO Prestamos (numeroCuentaSolocita , montoPedido ,montoconinteres,FechaPrestamo , CuotasPrestamo , EstadoPrestamo ) VALUES 
 (1, 1000,1120, '2023-11-26', 1, 2),
 (2, 1000,1120, '2023-11-26', 1, 2),
 (2, 1000,1120, '2023-11-26', 6, 2),
 (3, 1000,1120, '2023-11-26', 12, 2),
 (4, 1000,1120, '2023-11-26', 6, 2),
 (5, 1000,1120, '2023-11-26', 12, 2),
 (6, 1000,1120, '2023-11-26', 6, 2),
 (7, 1000,1120, '2023-11-26', 12, 2),
 (8, 1000,1120, '2023-11-26', 6, 2),
 (9, 1000,1120, '2023-11-26', 12, 2),
 (18, 1000,1120, '2023-11-26', 6, 2),
 (19, 1000,1120, '2023-11-26', 12, 2),
 (20, 1000,1120, '2023-11-26', 6, 2),
 (10, 1000,1120, '2023-11-26', 12, 2),
 (11, 1000,1120, '2023-11-26', 6, 2);
 