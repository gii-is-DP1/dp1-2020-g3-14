-- One admin user, named admin1 with passwor 4dm1n and authority admin
INSERT INTO users(username,password,enabled) VALUES ('admin1','4dm1n', TRUE);
INSERT INTO users(username,password,enabled) VALUES ('enrmorvaz','administrador',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (1,'admin1','admin');
INSERT INTO authorities(id,username,authority) VALUES (8,'enrmorvaz','owner');

-- One owner user, named owner1 with passwor 0wn3r
INSERT INTO users(username,password,enabled) VALUES ('owner1','0wn3r',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (2,'owner1','owner');
-- One owner josregmej, named Jose with passwor usuario
INSERT INTO users(username,password,enabled) VALUES ('josregmej','usuario',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (4,'josregmej','owner');
-- One owner  Yiyons, named Alvaro with passwor usuario1
INSERT INTO users(username,password,enabled) VALUES ('Yiyons','usuario1',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (35,'Yiyons','owner');
-- One vet user, named vet1 with passwor v3t
INSERT INTO users(username,password,enabled) VALUES ('vet1','v3t',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (3,'vet1','veterinarian');

INSERT INTO users(username,password,enabled) VALUES ('pedcarmor','adm1n',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (10,'pedcarmor','owner');

INSERT INTO users(username,password,enabled) VALUES ('pedmuncif','administrador',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (20,'pedmuncif','owner');

INSERT INTO users(username,password,telefono,dni,enabled) VALUES ('javhidrod1','A6min','617736165','31023797V',TRUE);
INSERT INTO authorities(id,username,authority) VALUES (17,'javhidrod1','owner');


INSERT INTO owners VALUES (1, 'George', 'Franklin', '110 W. Liberty St.', 'Madison', '6085551023', 'owner1');
INSERT INTO owners VALUES (2, 'Betty', 'Davis', '638 Cardinal Ave.', 'Sun Prairie', '6085551749', 'owner1');
INSERT INTO owners VALUES (3, 'Eduardo', 'Rodriquez', '2693 Commerce St.', 'McFarland', '6085558763', 'owner1');
INSERT INTO owners VALUES (4, 'Harold', 'Davis', '563 Friendly St.', 'Windsor', '6085553198', 'owner1');
INSERT INTO owners VALUES (5, 'Peter', 'McTavish', '2387 S. Fair Way', 'Madison', '6085552765', 'owner1');
INSERT INTO owners VALUES (6, 'Jean', 'Coleman', '105 N. Lake St.', 'Monona', '6085552654', 'owner1');
INSERT INTO owners VALUES (7, 'Jeff', 'Black', '1450 Oak Blvd.', 'Monona', '6085555387', 'owner1');
INSERT INTO owners VALUES (8, 'Maria', 'Escobito', '345 Maple St.', 'Madison', '6085557683', 'owner1');
INSERT INTO owners VALUES (9, 'David', 'Schroeder', '2749 Blackhawk Trail', 'Madison', '6085559435', 'owner1');
INSERT INTO owners VALUES (10, 'Carlos', 'Estaban', '2335 Independence La.', 'Waunakee', '6085555487', 'owner1');

INSERT INTO owners VALUES (11, 'Jose', 'Francisco', '110 W. UNLiberty St.', 'Iowa', '6085661023', 'josregmej');

INSERT INTO owners VALUES (18, 'Enrique', 'Moreno', '111 W. Liberty St.', 'Madison', '6085533023', 'owner1');
INSERT INTO owners VALUES (25, 'Pedro Pablo', 'Carvajal', '18 Severo Ochoa', 'Sevilla', '6085555444', 'owner1');
INSERT INTO owners VALUES (20, 'Pedro', 'Jesus', 'Juan Ramon Jimenez', 'España', '633897505', 'owner1');
INSERT INTO owners VALUES (22, 'Javier', 'Hidalgo Rodriguez','17 Reina Mercedes', 'España', '617736165', 'owner1');
INSERT INTO owners VALUES (23, 'Alvaro', 'Sevilla Cabrera', '4 Castillo de Constantina', 'España', '608942375', 'owner1');


INSERT INTO agenacts VALUES (1,'AgenciaPrueba','Sevilla', '2333333');
INSERT INTO agenacts VALUES (2,'AgenciaPrueba2','Huelva', '21111111');
INSERT INTO agenacts VALUES (3,'Enrique','Gines', '21111111');

INSERT INTO hoteles(id,direccion,estrellas,nombre,provincia,telefono, valido) VALUES (2,'Calle Fran',5,'HOTEL 1','Sevilla','2333333', true);
INSERT INTO hoteles(id,direccion,estrellas,nombre,provincia,telefono, valido) VALUES (75,'Calle Funciona',5,'HOTEL Filtrado','Sevilla','2333383', true);
INSERT INTO hoteles(id,direccion,estrellas,nombre,provincia,telefono, valido) VALUES (3,'Calle Enrique2',3,'HOTEL 2','Cordoba','2333433', true);
INSERT INTO hoteles(id,direccion,estrellas,nombre,provincia,telefono, valido) VALUES (10,'Calle Enrique3',3,'HOTEL 9','Cordoba','233433', true);
INSERT INTO hoteles(id,direccion,estrellas,nombre,provincia,telefono, valido) VALUES (4,'Calle Fran2',4,'HOTEL 3','Cadiz','2333335', true);
INSERT INTO hoteles(id,direccion,estrellas,nombre,provincia,telefono, valido) VALUES (11,'Calle Fran10',4,'HOTEL 10','Cadiz','2334335', true);
INSERT INTO hoteles(id,direccion,estrellas,nombre,provincia,telefono, valido) VALUES (5,'Calle Fran3',4,'HOTEL 4','Huelva','2333335', true);
INSERT INTO hoteles(id,direccion,estrellas,nombre,provincia,telefono, valido) VALUES (12,'Calle Fran11',4,'HOTEL 11','Huelva','2333235', true);
INSERT INTO hoteles(id,direccion,estrellas,nombre,provincia,telefono, valido) VALUES (6,'Calle Fran4',3,'HOTEL 5','Malaga','2333345', true);
INSERT INTO hoteles(id,direccion,estrellas,nombre,provincia,telefono, valido) VALUES (13,'Calle Fran13',3,'HOTEL 12','Malaga','2333385', true);
INSERT INTO hoteles(id,direccion,estrellas,nombre,provincia,telefono, valido) VALUES (7,'Calle Fran6',4,'HOTEL 6','Jaen','2333335', true);
INSERT INTO hoteles(id,direccion,estrellas,nombre,provincia,telefono, valido) VALUES (14,'Calle Fran15',4,'HOTEL 14','Jaen','2331335', true);
INSERT INTO hoteles(id,direccion,estrellas,nombre,provincia,telefono, valido) VALUES (8,'Calle Fran7',4,'HOTEL 7','Granada','2333335', true);
INSERT INTO hoteles(id,direccion,estrellas,nombre,provincia,telefono, valido) VALUES (15,'Calle Fran16',4,'HOTEL 16','Granada','2333635', true);
INSERT INTO hoteles(id,direccion,estrellas,nombre,provincia,telefono, valido) VALUES (9,'Calle Fran8',3,'HOTEL 8','Almeria','2333345', true);
INSERT INTO hoteles(id,direccion,estrellas,nombre,provincia,telefono, valido) VALUES (16,'Calle Fran17',3,'HOTEL 17','Almeria','2343345', true);

INSERT INTO habitaciones(nhabitacion,ncamas,precio,disponible,hotel_id) VALUES (123,2,20,true,2);
INSERT INTO habitaciones(nhabitacion,ncamas,precio,disponible,hotel_id) VALUES (456,2,20,true,2);
INSERT INTO habitaciones(nhabitacion,ncamas,precio,disponible,hotel_id) VALUES (789,2,20,false,3);
INSERT INTO habitaciones(nhabitacion,ncamas,precio,disponible,hotel_id) VALUES (012,2,20,false,2);
INSERT INTO habitaciones(nhabitacion,ncamas,precio,disponible,hotel_id) VALUES (756,2,20,true,3);
INSERT INTO habitaciones(nhabitacion,ncamas,precio,disponible,hotel_id) VALUES (345,2,20,true,3);

INSERT INTO inscripcionhoteles(id,actividades,direccion,nombre,provincia) VALUES (2,'Calle Fran','elpe','INSCRIPCION1','Sevilla');
INSERT INTO inscripcionhoteles(id,actividades,direccion,nombre,provincia) VALUES (3,'Calle eooeo','elqpe','INSCRIPCION2','Sevilla');


INSERT INTO comentarioshotel(id,puntuacion,mensaje,hotel_id) VALUES (1,10,'HOTEL CHULO!',75);

INSERT INTO actividades(id,direccion,nombre,descripcion,precio,valoracion,fecha,agenact_id,provincia) VALUES (1, 'Playa de Cadiz','Surf Cadiz', 'El mejor Surf en Cadiz', '20', 3,'2021-12-17',1,'Cadiz');
INSERT INTO actividades(id,direccion,nombre,descripcion,precio,valoracion,fecha,agenact_id,provincia) VALUES (2, 'Sierra de Grazalema','Senderismo', 'Increible paisaje', '1' , 4,'2021-12-17',1,'Cadiz');
INSERT INTO actividades(id,direccion,nombre,descripcion,precio,valoracion,fecha,agenact_id,provincia) VALUES (3, 'Ayuntamiento de Sevilla', 'Visita guiada', 'Sevilla es preciosa', '5', 4,'2021-12-17',2,'Sevilla');

INSERT INTO comentariosactividad(id,puntuacion,mensaje,actividad_id) VALUES (1,10,'Bonitas vistas!',1);

INSERT INTO compvuelos VALUES (1, 'CompañiaPrueba', 'España', 'Sede1');
INSERT INTO compvuelos VALUES (2, 'CompañiaPrueba2', 'España', 'Sede2');
INSERT INTO compvuelos VALUES (3, 'CompañiaPrueba3', 'España', 'Sede3');

INSERT INTO users_actividades(username, actividades_id) VALUES ('enrmorvaz', 3);
INSERT INTO users_habitaciones(username, nhabitacion) VALUES ('enrmorvaz', 789);

INSERT INTO vuelos(id,billetes,destino,fecha_ida,fecha_vuelta,origen,precio,numero_plazas,compvuelo_id) VALUES (1, 2, 'Malaga', '2021-12-17', '2021-12-24', 'Sevilla', 70,1,1);
INSERT INTO vuelos(id,billetes,destino,fecha_ida,fecha_vuelta,origen,precio,numero_plazas,compvuelo_id) VALUES (2, 1, 'Almeria', '2021-12-16', '2021-12-25', 'Malaga', 40,50,2);
INSERT INTO vuelos(id,billetes,destino,fecha_ida,fecha_vuelta,origen,precio,numero_plazas,compvuelo_id) VALUES (3, 3, 'Cadiz', '2021-12-19', '2021-12-26','Cordoba', 120,32,2);
INSERT INTO vuelos(id,billetes,destino,fecha_ida,fecha_vuelta,origen,precio,numero_plazas,compvuelo_id) VALUES (4, 2, 'Jaen', '2021-12-18', '2021-12-23', 'Sevilla', 70,2,3);
INSERT INTO vuelos(id,billetes,destino,fecha_ida,fecha_vuelta,origen,precio,numero_plazas,compvuelo_id) VALUES (5, 1, 'Malaga', '2021-12-17', '2021-12-24', 'Sevilla', 69,3,3);

INSERT INTO users_vuelos(username, vuelos_id) VALUES ('enrmorvaz', 3);
