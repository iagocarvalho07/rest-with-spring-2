CREATE TABLE IF NOT EXISTS public.books (
  id bigserial NOT NULL,
  author VARCHAR(255) NULL,
  launch_date TIMESTAMP NOT NULL,
  price DECIMAL(6, 2) NOT NULL,
  title TEXT
);
