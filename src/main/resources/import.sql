-- Lozinke su hesovane pomocu BCrypt algoritma https://www.dailycred.com/article/bcrypt-calculator
-- Lozinka za oba user-a je 123

INSERT INTO USERS (username, password, first_name, last_name, email, enabled, last_password_reset_date) VALUES ('user', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Marko', 'Markovic', 'user@example.com', true, '2017-10-01 21:58:58.508-07');
INSERT INTO USERS (username, password, first_name, last_name, email, enabled, last_password_reset_date) VALUES ('cottageUser', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Simo', 'Simic', 'cottageUser@example.com', true, '2017-10-01 21:58:58.508-07');
INSERT INTO USERS (username, password, first_name, last_name, email, enabled, last_password_reset_date) VALUES ('boatUser', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Boto', 'Botic', 'boatUser@example.com', true, '2017-10-01 21:58:58.508-07');
INSERT INTO USERS (username, password, first_name, last_name, email, enabled, last_password_reset_date) VALUES ('adventureUser', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Advo', 'Advic', 'adventureUser@example.com', true, '2017-10-01 21:58:58.508-07');
INSERT INTO USERS (username, password, first_name, last_name, email, enabled, last_password_reset_date) VALUES ('admin', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Nikola', 'Nikolic', 'admin@example.com', true, '2017-10-01 18:57:58.508-07');

INSERT INTO AUTHORITY (name) VALUES ('ROLE_CLIENT');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_COTTAGE_OWNER');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_BOAT_OWNER');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_ADVENTURE_OWNER');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_ADMIN');

INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (1, 1);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (2, 2);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (3, 3);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (4, 4);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (5, 5);

INSERT INTO CLIENT (id) VALUES (1);
INSERT INTO COTTAGE_OWNER (id) VALUES (2);
INSERT INTO BOAT_OWNER (id) VALUES (3);
INSERT INTO ADVENTURE_OWNER (id) VALUES (4);

INSERT INTO BASE_ENTITY (name, description) VALUES ('cottageName', 'Lorem ipsum dolor sit amet consectetur, adipisicing elit. Eos, cupiditate! Odio, aliquam soluta vel, eum illum corrupti incidunt nobis porro mollitia itaque reiciendis. Aut, minus dolore! Delectus pariatur praesentium dolorem? In at, quibusdam vero eligendi provident veritatis ipsam suscipit nisi similique nulla est magni harum. Cumque maiores eos alias, aperiam ea deleniti voluptatem culpa a perferendis accusantium, necessitatibus velit laborum');
INSERT INTO BASE_ENTITY (name, description) VALUES ('boat', 'boatDescription');
INSERT INTO BASE_ENTITY (name, description) VALUES ('adventure', 'adventureDescription');

INSERT INTO IMAGE (entity_id, url) VALUES (1, '/images/cottage1.jpg');

INSERT INTO COTTAGE (id, owner_id, address) VALUES (1, 2, 'adresa');

INSERT INTO RESERVATION (duration, maximal_guests, price, reservation_start, reservation_end) VALUES (235, 5, 35, '2022-04-06T03:45:42', '2022-04-09T03:45:42');

INSERT INTO COTTAGE_RESERVATION (id, client_id, cottage_id) VALUES (1, 1, 1);

INSERT INTO BOAT_SPECIFICATION (boat_type, length, engine_id, engine_power, max_speed) VALUES ('yacht', '15', '3A23FB', '400', '120');

INSERT INTO BOAT (id, owner_id, boat_specification_id) VALUES (2, 3, 1);

INSERT INTO ADVENTURE (id, owner_id, biography) VALUES (3, 4, 'biografija');
