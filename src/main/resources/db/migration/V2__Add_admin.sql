INSERT INTO usr(id, username, password)
VALUES (nextval('hibernate_sequence'), 'admin', '$2a$12$XASe2mlm28Fsr.aTmcUYUu.lmleftIp4iFfE2m6OIGksHI.yLFUmO');

INSERT INTO user_role (user_id, roles)
VALUES (currval('hibernate_sequence'), 'ADMIN');
