CREATE TABLE local_file(
    id UUID PRIMARY KEY,
    path VARCHAR NOT NULL,
    hash_hex VARCHAR NOT NULL,
    created_at TIMESTAMP NOT NULL,
    last_modified_at TIMESTAMP NOT NULL
);

CREATE TABLE local_file_aud(
    id UUID NOT NULL,
    rev INTEGER NOT NULL,
    revtype SMALLINT,
    path VARCHAR NOT NULL,
    hash_hex VARCHAR NOT NULL,
    created_at TIMESTAMP NOT NULL,
    last_modified_at TIMESTAMP NOT NULL,
    PRIMARY KEY (id, rev),
    CONSTRAINT fk_local_file_aud_rev FOREIGN KEY (rev) REFERENCES revinfo
);