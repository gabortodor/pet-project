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
    featured_local_file_id UUID,
    created_at TIMESTAMP NOT NULL,
    last_modified_at TIMESTAMP NOT NULL,
    CONSTRAINT fk_breed FOREIGN KEY(breed_id) REFERENCES breed(id),
    CONSTRAINT fk_featured_local_file FOREIGN KEY(featured_local_file_id) REFERENCES local_file(id)
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
    featured_local_file_id UUID,
    created_at TIMESTAMP NOT NULL,
    last_modified_at TIMESTAMP NOT NULL,
    PRIMARY KEY (id, rev),
    CONSTRAINT fk_animal_aud_rev FOREIGN KEY (rev) REFERENCES revinfo
);

CREATE TABLE animal_local_file(
    animal_id UUID NOT NULL,
    local_file_id UUID NOT NULL,
    CONSTRAINT fk_animal FOREIGN KEY(animal_id) REFERENCES animal(id),
    CONSTRAINT fk_local_file FOREIGN KEY(local_file_id) REFERENCES local_file(id)
);

CREATE TABLE animal_local_file_aud(
    animal_id UUID NOT NULL,
    local_file_id UUID NOT NULL,
    rev INTEGER NOT NULL,
    revtype SMALLINT,
    PRIMARY KEY (animal_id, local_file_id, rev),
    CONSTRAINT fk_animal_local_file_aud_rev FOREIGN KEY (rev) REFERENCES revinfo
);