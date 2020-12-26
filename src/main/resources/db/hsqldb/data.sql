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


INSERT INTO vets VALUES (1, 'James', 'Carter');
INSERT INTO vets VALUES (2, 'Helen', 'Leary');
INSERT INTO vets VALUES (3, 'Linda', 'Douglas');
INSERT INTO vets VALUES (4, 'Rafael', 'Ortega');
INSERT INTO vets VALUES (5, 'Henry', 'Stevens');
INSERT INTO vets VALUES (6, 'Sharon', 'Jenkins');
INSERT INTO vets VALUES (7, 'Manolo', 'Egcarabajo');

INSERT INTO specialties VALUES (1, 'radiology');
INSERT INTO specialties VALUES (2, 'surgery');
INSERT INTO specialties VALUES (3, 'dentistry');

INSERT INTO vet_specialties VALUES (2, 1);
INSERT INTO vet_specialties VALUES (3, 2);
INSERT INTO vet_specialties VALUES (3, 3);
INSERT INTO vet_specialties VALUES (4, 2);
INSERT INTO vet_specialties VALUES (5, 1);

INSERT INTO types VALUES (1, 'cat');
INSERT INTO types VALUES (2, 'dog');
INSERT INTO types VALUES (3, 'lizard');
INSERT INTO types VALUES (4, 'snake');
INSERT INTO types VALUES (5, 'bird');
INSERT INTO types VALUES (6, 'hamster');

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

INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (1, 'Leo', '2010-09-07', 1, 1);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (2, 'Basil', '2012-08-06', 6, 2);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (3, 'Rosy', '2011-04-17', 2, 3);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (4, 'Jewel', '2010-03-07', 2, 3);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (5, 'Iggy', '2010-11-30', 3, 4);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (6, 'George', '2010-01-20', 4, 5);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (7, 'Samantha', '2012-09-04', 1, 6);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (8, 'Max', '2012-09-04', 1, 6);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (9, 'Lucky', '2011-08-06', 5, 7);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (10, 'Mulligan', '2007-02-24', 2, 8);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (11, 'Freddy', '2010-03-09', 5, 9);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (12, 'Lucky', '2010-06-24', 2, 10);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (13, 'Sly', '2012-06-08', 1, 10);

INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (14, 'Anubis', '2010-07-09', 2, 11);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (18, 'Perico', '2012-09-09', 2, 20);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (19, 'Fran', '2014-09-07', 2, 18);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (23, 'Jofrillos', '2011-03-17', 1, 25);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (24, 'Sech', '2018-10-17', 1, 22);
INSERT INTO pets(id,name,birth_date,type_id,owner_id) VALUES (20, 'Anacleto', '2009-07-09', 6, 23);

INSERT INTO visits(id,pet_id,visit_date,description) VALUES (1, 7, '2013-01-01', 'rabies shot');
INSERT INTO visits(id,pet_id,visit_date,description) VALUES (2, 8, '2013-01-02', 'rabies shot');
INSERT INTO visits(id,pet_id,visit_date,description) VALUES (3, 8, '2013-01-03', 'neutered');
INSERT INTO visits(id,pet_id,visit_date,description) VALUES (4, 7, '2013-01-04', 'spayed');

INSERT INTO agenacts VALUES (1,'AgenciaPrueba','Sevilla', '2333333');
INSERT INTO agenacts VALUES (2,'AgenciaPrueba2','Huelva', '21111111');
INSERT INTO agenacts VALUES (3,'Enrique','Gines', '21111111');


INSERT INTO hoteles(id,direccion,estrellas,nombre,provincia,telefono,precio) VALUES (2,'Calle Fran',5,'HOTEL 1','Sevilla','2333333','150');
INSERT INTO hoteles(id,direccion,estrellas,nombre,provincia,telefono,precio) VALUES (75,'Calle Funciona',5,'HOTEL Filtrado','Sevilla','2333383','159');
INSERT INTO hoteles(id,direccion,estrellas,nombre,provincia,telefono,precio) VALUES (3,'Calle Enrique2',3,'HOTEL 2','Cordoba','2333433','250');
INSERT INTO hoteles(id,direccion,estrellas,nombre,provincia,telefono,precio) VALUES (10,'Calle Enrique3',3,'HOTEL 9','Cordoba','233433','340');
INSERT INTO hoteles(id,direccion,estrellas,nombre,provincia,telefono,precio) VALUES (4,'Calle Fran2',4,'HOTEL 3','Cadiz','2333335','100');
INSERT INTO hoteles(id,direccion,estrellas,nombre,provincia,telefono,precio) VALUES (11,'Calle Fran10',4,'HOTEL 10','Cadiz','2334335','435');
INSERT INTO hoteles(id,direccion,estrellas,nombre,provincia,telefono,precio) VALUES (5,'Calle Fran3',4,'HOTEL 4','Huelva','2333335','75');
INSERT INTO hoteles(id,direccion,estrellas,nombre,provincia,telefono,precio) VALUES (12,'Calle Fran11',4,'HOTEL 11','Huelva','2333235','65');
INSERT INTO hoteles(id,direccion,estrellas,nombre,provincia,telefono,precio) VALUES (6,'Calle Fran4',3,'HOTEL 5','Malaga','2333345','90');
INSERT INTO hoteles(id,direccion,estrellas,nombre,provincia,telefono,precio) VALUES (13,'Calle Fran13',3,'HOTEL 12','Malaga','2333385','54');
INSERT INTO hoteles(id,direccion,estrellas,nombre,provincia,telefono,precio) VALUES (7,'Calle Fran6',4,'HOTEL 6','Jaen','2333335','102');
INSERT INTO hoteles(id,direccion,estrellas,nombre,provincia,telefono,precio) VALUES (14,'Calle Fran15',4,'HOTEL 14','Jaen','2331335','345');
INSERT INTO hoteles(id,direccion,estrellas,nombre,provincia,telefono,precio) VALUES (8,'Calle Fran7',4,'HOTEL 7','Granada','2333335','348');
INSERT INTO hoteles(id,direccion,estrellas,nombre,provincia,telefono,precio) VALUES (15,'Calle Fran16',4,'HOTEL 16','Granada','2333635','76');
INSERT INTO hoteles(id,direccion,estrellas,nombre,provincia,telefono,precio) VALUES (9,'Calle Fran8',3,'HOTEL 8','Almeria','2333345','145');
INSERT INTO hoteles(id,direccion,estrellas,nombre,provincia,telefono,precio) VALUES (16,'Calle Fran17',3,'HOTEL 17','Almeria','2343345','245');

INSERT INTO habitaciones(nhabitacion,ncamas,precio,disponible,hotel_id) VALUES (123,2,20,true,2);
INSERT INTO habitaciones(nhabitacion,ncamas,precio,disponible,hotel_id) VALUES (456,2,20,true,2);
INSERT INTO habitaciones(nhabitacion,ncamas,precio,disponible,hotel_id) VALUES (789,2,20,false,3);
INSERT INTO habitaciones(nhabitacion,ncamas,precio,disponible,hotel_id) VALUES (012,2,20,false,2);
INSERT INTO habitaciones(nhabitacion,ncamas,precio,disponible,hotel_id) VALUES (756,2,20,true,3);
INSERT INTO habitaciones(nhabitacion,ncamas,precio,disponible,hotel_id) VALUES (345,2,20,true,3);

INSERT INTO comentarios(id,puntuacion,mensaje,hotel_id) VALUES (1,10,'HOTEL CHULO!',75);

INSERT INTO actividades(id,direccion,nombre,opinion,precio,valoracion,agenact_id) VALUES (1, 'Playa de Cadiz','Surf Cadiz', 'El mejor Surf en Cadiz', '20', 3,1);
INSERT INTO actividades(id,direccion,nombre,opinion,precio,valoracion,agenact_id) VALUES (2, 'Sierra de Grazalema','Senderismo', 'Increible paisaje', '1' , 4,1);
INSERT INTO actividades(id,direccion,nombre,opinion,precio,valoracion,agenact_id) VALUES (3, 'Ayuntamiento de Sevilla', 'Visita guiada', 'Sevilla es preciosa', '5', 4,2);

INSERT INTO compvuelos VALUES (1, 'CompañiaPrueba', 'España', 'Sede1');
INSERT INTO compvuelos VALUES (2, 'CompañiaPrueba2', 'España', 'Sede2');
INSERT INTO compvuelos VALUES (3, 'CompañiaPrueba3', 'España', 'Sede3');

INSERT INTO users_actividades(username, actividades_id) VALUES ('enrmorvaz', 3);
INSERT INTO users_habitaciones(username, nhabitacion) VALUES ('enrmorvaz', 789);

INSERT INTO vuelos(id,billetes,destino,fecha_ida,fecha_vuelta,origen,precio,compvuelo_id) VALUES (1, 2, 'Malaga', '2020-12-17', '2020-12-24', 'Sevilla', 70,1);
INSERT INTO vuelos(id,billetes,destino,fecha_ida,fecha_vuelta,origen,precio,compvuelo_id) VALUES (2, 1, 'Almeria', '2020-12-16', '2020-12-25', 'Malaga', 40,2);
INSERT INTO vuelos(id,billetes,destino,fecha_ida,fecha_vuelta,origen,precio,compvuelo_id) VALUES (3, 3, 'Cadiz', '2020-12-19', '2020-12-26','Cordoba', 120,2);
INSERT INTO vuelos(id,billetes,destino,fecha_ida,fecha_vuelta,origen,precio,compvuelo_id) VALUES (4, 2, 'Jaen', '2020-12-18', '2020-12-23', 'Sevilla', 70,3);

INSERT INTO users_vuelos(username, vuelos_id) VALUES ('enrmorvaz', 3);