-- Lozinke su hesovane pomocu BCrypt algoritma https://www.dailycred.com/article/bcrypt-calculator
-- Lozinka za oba user-a je 123

INSERT INTO USERS (username, password, first_name, last_name, email, enabled, last_password_reset_date)
VALUES ('user', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Marko', 'Markovic', 'user@example.com',
        true, '2017-10-01 21:58:58.508-07');
INSERT INTO USERS (username, password, first_name, last_name, email, enabled, last_password_reset_date)
VALUES ('cottageUser', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Simo', 'Simic',
        'cottageUser@example.com', true, '2017-10-01 21:58:58.508-07');
INSERT INTO USERS (username, password, first_name, last_name, email, enabled, last_password_reset_date)
VALUES ('boatUser', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Boto', 'Botic',
        'boatUser@example.com', true, '2017-10-01 21:58:58.508-07');
INSERT INTO USERS (username, password, first_name, last_name, email, enabled, last_password_reset_date)
VALUES ('fishingUser', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Fiso', 'Fisic',
        'fishingUser@example.com', true, '2017-10-01 21:58:58.508-07');
INSERT INTO USERS (username, password, first_name, last_name, email, enabled, last_password_reset_date)
VALUES ('admin', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Nikola', 'Nikolic',
        'admin@example.com', true, '2017-10-01 18:57:58.508-07');

INSERT INTO AUTHORITY (name)
VALUES ('ROLE_USER');
INSERT INTO AUTHORITY (name)
VALUES ('ROLE_BUSINESS');
INSERT INTO AUTHORITY (name)
VALUES ('ROLE_ADMIN');

INSERT INTO USER_AUTHORITY (user_id, authority_id)
VALUES (1, 1);
INSERT INTO USER_AUTHORITY (user_id, authority_id)
VALUES (2, 2);
INSERT INTO USER_AUTHORITY (user_id, authority_id)
VALUES (3, 2);
INSERT INTO USER_AUTHORITY (user_id, authority_id)
VALUES (4, 2);
INSERT INTO USER_AUTHORITY (user_id, authority_id)
VALUES (5, 3);

INSERT INTO BUSINESS_OWNER (id)
VALUES (2);
INSERT INTO BUSINESS_OWNER (id)
VALUES (3);
INSERT INTO BUSINESS_OWNER (id)
VALUES (4);

INSERT INTO BASE_ENTITY (type, name, description, owner_id)
VALUES (0, 'cottageName',
        'Lorem ipsum dolor sit amet consectetur, adipisicing elit. Eos, cupiditate! Odio, aliquam soluta vel, eum illum corrupti incidunt nobis porro mollitia itaque reiciendis. Aut, minus dolore! Delectus pariatur praesentium dolorem? In at, quibusdam vero eligendi provident veritatis ipsam suscipit nisi similique nulla est magni harum. Cumque maiores eos alias, aperiam ea deleniti voluptatem culpa a perferendis accusantium, necessitatibus velit laborum',
        2);
INSERT INTO BASE_ENTITY (type, name, description, owner_id)
VALUES (1, 'boat', 'boatDescription', 3);
INSERT INTO BASE_ENTITY (type, name, description, owner_id)
VALUES (2, 'fishing', 'fishingDescription', 4);

INSERT INTO IMAGE (url, entity_id)
VALUES ('/images/cottage1.jpg', 1);

INSERT INTO COTTAGE (id, address)
VALUES (1, 'adresa');

INSERT INTO RESERVATION (duration, maximal_guests, price, entity_id, user_id)
VALUES (235, 5, 35, 1, 1);

INSERT INTO BOAT_SPECIFICATION (boat_type, length, engine_id, engine_power, max_speed)
VALUES ('yacht', '15', '3A23FB', '400', '120');

INSERT INTO BOAT (id, boat_specification_id)
VALUES (2, 1);

INSERT INTO FISHING (id, biography)
VALUES (3, 'biografija');

-- INSERT INTO BOAT (duration, maximal_guests, price, entity_id, user_id) VALUES (235, 5, 35, 1, 1);
