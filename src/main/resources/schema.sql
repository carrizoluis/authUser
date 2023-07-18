CREATE TABLE user_admin (
  userid INT AUTO_INCREMENT NOT NULL,
   name VARCHAR(255),
   email VARCHAR(255) NOT NULL,
   password VARCHAR(255) NOT NULL,
   created_at TIMESTAMP DEFAULT NOW() NOT NULL,
   is_active BOOLEAN DEFAULT TRUE NOT NULL,
   CONSTRAINT pk_user_admin PRIMARY KEY (userid)
);

CREATE TABLE phone (
  phoneid INT AUTO_INCREMENT NOT NULL,
   number BIGINT NOT NULL,
   city_code INT NOT NULL,
   country_code VARCHAR(255) NOT NULL,
   user_userid INT,
   CONSTRAINT pk_phone PRIMARY KEY (phoneid)
);

ALTER TABLE phone ADD CONSTRAINT FK_PHONE_ON_USER_USERID FOREIGN KEY (user_userid) REFERENCES user_admin (userid);