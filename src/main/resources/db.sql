--DROP DATABASE db_users;
/*
DROP TABLE users;
DROP TABLE role;
DROP TABLE users_role;
*/
--CREATE DATABASE db_users WITH OWNER = postgres ENCODING = 'UTF8' template=template0;

CREATE TABLE users
(
  id serial NOT NULL,
  username character varying(50) NOT NULL,
  password character varying(50) NOT NULL,
  dateofinsert timestamp without time zone,
  lastupdate timestamp without time zone,
  status integer,
  CONSTRAINT users_pkey PRIMARY KEY (id)
);

CREATE TABLE role
(
  id serial NOT NULL,
  title character varying(50),
  description character varying(150),
  status integer,
  CONSTRAINT role_pkey PRIMARY KEY (id)
);

CREATE TABLE users_role
(
  id serial NOT NULL,
  users_id integer, 
  role_id integer,		
  description character varying,
  status integer,
  CONSTRAINT users_role_pkey PRIMARY KEY (id),
  CONSTRAINT users_role_users_id_fkey FOREIGN KEY (users_id)
      REFERENCES users (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION, 
  CONSTRAINT users_role_role_id_fkey FOREIGN KEY (role_id)
      REFERENCES role (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION  
);
