CREATE SCHEMA usr;

COMMENT ON SCHEMA usr IS 'User schema';

DO
$$
  BEGIN
    CREATE TYPE usr.USER_ROLE AS ENUM (
      'ADMIN',
      'CUSTOMER'
      );
  EXCEPTION
    WHEN duplicate_object THEN NULL;
  END
$$;

CREATE TABLE usr.user (
  id          BIGSERIAL     NOT NULL,
  auth_id     TEXT          NOT NULL,
  username    TEXT          NOT NULL,
  first_name  TEXT          NOT NULL,
  middle_name TEXT          NULL,
  last_name   TEXT          NOT NULL,
  role        usr.USER_ROLE NOT NULL,

  PRIMARY KEY (id)
);

CREATE UNIQUE INDEX user_uq_auth_id
  ON usr.user(auth_id);

CREATE UNIQUE INDEX user_uq_username_role
  ON usr.user(username, role);