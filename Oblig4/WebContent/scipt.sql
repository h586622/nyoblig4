DROP SCHEMA IF EXISTS oblig4 CASCADE;
CREATE SCHEMA oblig4;
SET search_path = oblig4;

CREATE TABLE deltager 
(
   fornavn CHARACTER VARYING (20),
   etternavn CHARACTER VARYING (20),
   mobilnummer INTEGER NOT NULL CHECK (mobilnummer BETWEEN 0 AND 99999999),
   pwd_hash CHARACTER (64),
   pwd_salt CHARACTER (32),
   kjonn CHARACTER VARYING (6),
   PRIMARY KEY (mobilnummer)
);

INSERT INTO deltager VALUES 
    ('Per', 'Hansen', '12345678','DF32FB5C3D132F276CA0E9B582ADA7E7B72CA1E5DE58C35D86C378A9446EE005','38943AF5CA14AE5C1B9438FBB20233CA','MANN'),
    ('Kari','Normann','98765432', '2C8700BDBD964E483E98BF371D8810D47F10C539B508D0ACCCC4416282873F49','A8EEEB37FAAC34B399D8E4CE4C1DC72B','KVINNE')