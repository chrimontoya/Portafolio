INSERT INTO USER_AUTH (username, password, enabled) VALUES ('christian', '$2a$10$Dd5shK8tcRqKtVb4tJe4he6b/oAMRD.2ne/nqdGd58JcPQG9BYkcK', 1);
INSERT INTO USER_AUTH (username, password, enabled) VALUES ('admin', '$2a$10$Zf7wlD7uC0sqGmSNRhlHT.vNRxPvguPOzsi/5X7eC4WecvOA/otvK', 1);

INSERT INTO AUTHORITIES (authority, id_user_auth) VALUES ('ROLE_ADMIN',1);
INSERT INTO AUTHORITIES (authority, id_user_auth) VALUES ('ROLE_USER',1);
INSERT INTO AUTHORITIES (authority, id_user_auth) VALUES ('ROLE_DEVELOPER',1);
INSERT INTO AUTHORITIES (authority, id_user_auth) VALUES ('ROLE_ADMIN',2);
