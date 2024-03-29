--DROP DATABASE db_users;
/* 
DROP TABLE logins;
DROP TABLE users_roles;
DROP TABLE users;
DROP TABLE roles;
DROP TABLE person;
DROP TABLE users_aud;
DROP TABLE revinfo;
*/
--CREATE DATABASE db_users WITH OWNER = postgres ENCODING = 'UTF8' template=template0;

CREATE TABLE person
(
    id serial NOT NULL,
    address character varying(255),
    country character varying(255),
    dateofbirth timestamp without time zone,
    dateofinsert timestamp without time zone,
    lastupdate timestamp without time zone,
    name character varying(255),
    phone character varying(255),
    status integer,
    surname character varying(255),
    town character varying(255),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

CREATE TABLE users
(
  id serial NOT NULL,
  person_id integer, 	
  username character varying(50) NOT NULL,
  password character varying(50) NOT NULL,
  dateofinsert timestamp without time zone,
  lastupdate timestamp without time zone,
  status integer,
  CONSTRAINT users_pkey PRIMARY KEY (id),
    CONSTRAINT users_person_id FOREIGN KEY (person_id)
        REFERENCES person (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE roles
(
  id serial NOT NULL,
  title character varying(50),
  description character varying(150),
  status integer,
  CONSTRAINT roles_pkey PRIMARY KEY (id)
);

CREATE TABLE users_roles
(
  id serial NOT NULL,
  users_id integer, 
  roles_id integer,		
  description character varying,
  status integer,
  CONSTRAINT users_roles_pkey PRIMARY KEY (id),
  CONSTRAINT users_roles_users_id_fkey FOREIGN KEY (users_id)
      REFERENCES users (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION, 
  CONSTRAINT users_roles_roles_id_fkey FOREIGN KEY (roles_id)
      REFERENCES roles (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION  
);

CREATE TABLE logins
(
    id bigserial NOT NULL,
    browser character varying(255),
    dateofinsert timestamp without time zone,
    ip character varying(255),
    success integer,
    users_id integer,
    CONSTRAINT logins_pkey PRIMARY KEY (id),
    CONSTRAINT logins_users_id FOREIGN KEY (users_id)
        REFERENCES users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE revinfo
(
    rev integer NOT NULL,
    revtstmp bigint,
    CONSTRAINT revinfo_pkey PRIMARY KEY (rev)
);

CREATE TABLE users_aud
(
    id serial NOT NULL,
    rev integer NOT NULL,
    revtype integer,
    dateofinsert timestamp without time zone,
    password character varying(255),
    status integer,
    username character varying(255),
    person_id integer,
    CONSTRAINT users_aud_pkey PRIMARY KEY (id, rev),
    CONSTRAINT users_aud_revinfo_rev FOREIGN KEY (rev)
        REFERENCES public.revinfo (rev) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
