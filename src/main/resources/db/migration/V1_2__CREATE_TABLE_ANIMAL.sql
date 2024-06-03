CREATE TABLE animal(
    id UUID PRIMARY KEY,
    type VARCHAR NOT NULL,
    gender VARCHAR NOT NULL,
    name VARCHAR NOT NULL,
    birth_date TIMESTAMP,
    brought_in_at TIMESTAMP,
    breed_id UUID NOT NULL,
    color VARCHAR,
    fur_type VARCHAR,
    body_size VARCHAR,
    is_chipped BOOL,
    description TEXT,
    created_at TIMESTAMP NOT NULL,
    last_modified_at TIMESTAMP NOT NULL,
    CONSTRAINT fk_breed FOREIGN KEY(breed_id) REFERENCES breed(id)
);

CREATE TABLE animal_aud(
    id UUID NOT NULL,
    rev INTEGER NOT NULL,
    revtype SMALLINT,
    type VARCHAR NOT NULL,
    gender VARCHAR NOT NULL,
    name VARCHAR NOT NULL,
    birth_date TIMESTAMP,
    brought_in_at TIMESTAMP,
    breed_id UUID NOT NULL,
    color VARCHAR,
    fur_type VARCHAR,
    body_size VARCHAR,
    is_chipped BOOL,
    description TEXT,
    created_at TIMESTAMP NOT NULL,
    last_modified_at TIMESTAMP NOT NULL,
    PRIMARY KEY (id, rev),
    CONSTRAINT fk_animal_aud_rev FOREIGN KEY (rev) REFERENCES revinfo
);