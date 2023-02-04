INSERT INTO `USER_AUTH` (username, password, enabled) VALUES ('christian', '$2a$10$Dd5shK8tcRqKtVb4tJe4he6b/oAMRD.2ne/nqdGd58JcPQG9BYkcK', 1);
INSERT INTO `USER_AUTH` (username, password, enabled) VALUES ('admin', '$2a$10$Zf7wlD7uC0sqGmSNRhlHT.vNRxPvguPOzsi/5X7eC4WecvOA/otvK', 1);

INSERT INTO `AUTHORITIES` (id_role, authority) VALUES (1,'ROLE_ADMIN');
INSERT INTO `AUTHORITIES` (id_role, authority) VALUES (2,'ROLE_USER');
INSERT INTO `AUTHORITIES` (id_role, authority) VALUES (2,'ROLE_ADMIN');