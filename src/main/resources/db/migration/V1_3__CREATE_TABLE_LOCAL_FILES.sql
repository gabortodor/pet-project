CREATE TABLE local_file(
    id UUID PRIMARY KEY,
    path VARCHAR NOT NULL,
    created_at TIMESTAMP NOT NULL,
    last_modified_at TIMESTAMP NOT NULL
);

CREATE TABLE local_file_aud(
    id UUID NOT NULL,
    rev INTEGER NOT NULL,
    revtype SMALLINT,
    path VARCHAR NOT NULL,
    created_at TIMESTAMP NOT NULL,
    last_modified_at TIMESTAMP NOT NULL,
    PRIMARY KEY (id, rev),
    CONSTRAINT fk_local_file_aud_rev FOREIGN KEY (rev) REFERENCES revinfo
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