CREATE TABLE breed(
    id UUID PRIMARY KEY,
    type VARCHAR NOT NULL,
    name VARCHAR NOT NULL,
    created_at TIMESTAMP NOT NULL,
    last_modified_at TIMESTAMP NOT NULL
);

CREATE TABLE breed_aud(
    id UUID NOT NULL,
    rev INTEGER NOT NULL,
    revtype SMALLINT,
    type VARCHAR,
    name VARCHAR,
    created_at TIMESTAMP,
    last_modified_at TIMESTAMP,
    PRIMARY KEY (id, rev)
);

ALTER TABLE breed_aud ADD CONSTRAINT breed_aud_rev_fk FOREIGN KEY (rev) REFERENCES revinfo;