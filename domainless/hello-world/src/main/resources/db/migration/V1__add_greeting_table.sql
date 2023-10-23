CREATE TABLE greeting
(
    `id`       VARCHAR(255) NOT NULL,
    `language` VARCHAR(255) NOT NULL,
    `message`  VARCHAR(255) NOT NULL,
    CONSTRAINT pk_greeting PRIMARY KEY (id)
);
