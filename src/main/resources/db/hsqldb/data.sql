-- One admin user, named admin1 with passwor 4dm1n and authority admin
INSERT INTO users(username,password,enabled) VALUES ('admin1','4dm1n',TRUE);
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

INSERT INTO users(username,password,enabled) VALUES ('javhidrod1','A6min',TRUE);
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

INSERT INTO hoteles VALUES (1,'Calle Enrique',5,'HOTEL 0','Sevilla','2333333');
INSERT INTO hoteles VALUES (2,'Calle Fran',5,'HOTEL 1','Sevilla','2333333');

