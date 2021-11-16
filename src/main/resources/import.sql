-- Lozinke su hesovane pomocu BCrypt algoritma https://www.dailycred.com/article/bcrypt-calculator
-- Lozinka za oba user-a je 123

INSERT INTO USERS (username, password, first_name, last_name, email, enabled, last_password_reset_date) VALUES ('user', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Marko', 'Markovic', 'user@example.com', true, '2017-10-01 21:58:58.508-07');
INSERT INTO USERS (username, password, first_name, last_name, email, enabled, last_password_reset_date) VALUES ('cottageUser', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Simo', 'Simic', 'cottageUser@example.com', true, '2017-10-01 21:58:58.508-07');
INSERT INTO USERS (username, password, first_name, last_name, email, enabled, last_password_reset_date) VALUES ('boatUser', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Boto', 'Botic', 'boatUser@example.com', true, '2017-10-01 21:58:58.508-07');
INSERT INTO USERS (username, password, first_name, last_name, email, enabled, last_password_reset_date) VALUES ('admin', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Nikola', 'Nikolic', 'admin@example.com', true, '2017-10-01 18:57:58.508-07');

INSERT INTO AUTHORITY (name) VALUES ('ROLE_USER');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_BUSINESS');
INSERT INTO AUTHORITY (name) VALUES ('ROLE_ADMIN');

INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (1, 1);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (2, 2);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (3, 2);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (4, 3);

INSERT INTO COTTAGE_OWNER (id) VALUES (2);
INSERT INTO BOAT_OWNER (id) VALUES (3);


INSERT INTO BASE_ENTITY (id, type, name, description) VALUES (1, 0, 'ime', 'opis');
INSERT INTO BASE_ENTITY (id, type, name, description) VALUES (2, 1, 'boat', 'description');

INSERT INTO COTTAGE (id, address, owner_id) VALUES (1, 'adresa', 2);

INSERT INTO RESERVATION (duration, maximal_guests, price, entity_id, user_id) VALUES (235, 5, 35, 1, 1);

INSERT INTO BOAT_SPECIFICATION (id, boat_type, length, engine_id, engine_power, max_speed) VALUES (1, 'yacht', '15', '3A23FB', '400', '120');

INSERT INTO BOAT (id, boat_specification_id, owner_id) VALUES (2, 1, 3);


-- INSERT INTO BOAT (duration, maximal_guests, price, entity_id, user_id) VALUES (235, 5, 35, 1, 1);
