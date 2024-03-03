CREATE
extension if NOT EXISTS "uuid-ossp";

CREATE TABLE Player (
                      PlayerID UUID primary key default uuid_generate_v4(),
                      USERNAME VARCHAR(100) NOT NULL,
                      AGE: INTEGER(2),
                      POINTS:INTEGER(10)
);