CREATE SCHEMA IF NOT EXISTS trp;

COMMENT ON SCHEMA trp IS 'Schema for trips and bookings';

CREATE TABLE trp.trip_schedule (
  id             BIGSERIAL NOT NULL,
  bus_type       TEXT      NOT NULL,
  departure_time TIME      NOT NULL,
  origin         TEXT      NOT NULL,
  destination    TEXT      NOT NULL,
  amount         DECIMAL   NOT NULL
);