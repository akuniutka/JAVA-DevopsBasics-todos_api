CREATE SEQUENCE IF NOT EXISTS to_do_item_seq;

CREATE TABLE IF NOT EXISTS to_do_item
(
    id BIGINT DEFAULT nextval('to_do_item_seq'::regclass) NOT NULL
        CONSTRAINT tags_pkey PRIMARY KEY,
    description VARCHAR NOT NULL,
    done BOOLEAN DEFAULT FAlSE NOT NULL
);