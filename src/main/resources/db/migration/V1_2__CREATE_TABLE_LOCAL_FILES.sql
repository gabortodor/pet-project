CREATE TABLE local_file(
    id UUID PRIMARY KEY,
    path VARCHAR NOT NULL,
    hash_hex VARCHAR NOT NULL,
    created_at TIMESTAMP NOT NULL,
    created_by UUID NOT NULL,
    last_modified_at TIMESTAMP NOT NULL,
    last_modified_by UUID NOT NULL
);

CREATE TABLE local_file_aud(
    id UUID NOT NULL,
    rev INTEGER NOT NULL,
    revtype SMALLINT,
    path VARCHAR,
    hash_hex VARCHAR,
    created_at TIMESTAMP,
    created_by UUID,
    last_modified_at TIMESTAMP,
    last_modified_by UUID,
    PRIMARY KEY (id, rev),
    CONSTRAINT fk_local_file_aud_rev FOREIGN KEY (rev) REFERENCES revinfo
);