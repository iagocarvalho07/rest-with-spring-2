-- public.person definition

-- Drop table

-- DROP TABLE public.person;

CREATE TABLE IF NOT EXISTS public.person (
	id bigserial NOT NULL,
	address varchar(255) NULL,
	gender varchar(255) NULL,
	last_name varchar(255) NOT NULL,
	first_name varchar(255) NOT NULL,
	CONSTRAINT person_pkey PRIMARY KEY (id)
);

