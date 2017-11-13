CREATE TABLE module (
  id BIGSERIAL PRIMARY KEY,
  uri VARCHAR(200) NOT NULL,
  name varchar(100) NOT NULL
);

CREATE TABLE submodule (
  id BIGSERIAL PRIMARY KEY,
  uri VARCHAR(200) NOT NULL,
  module_id BIGINT REFERENCES module,
  name VARCHAR(100) NOT NULL
);

CREATE TABLE lentl_type (
  id BIGSERIAL PRIMARY KEY,
  submodule_id BIGINT REFERENCES submodule,
  uri VARCHAR(200) NOT NULL,
  name varchar(100) NOT NULL
);


CREATE TABLE role (
  id BIGSERIAL PRIMARY KEY,
  module_id BIGINT REFERENCES module,
  name varchar(100)
);

CREATE TABLE workflow (
  id BIGSERIAL PRIMARY KEY,
  uri VARCHAR(200),
  name VARCHAR(100)
);

CREATE TABLE state_definition (
  id BIGSERIAL PRIMARY KEY,
  workflow_id BIGINT REFERENCES workflow,
  name VARCHAR(100) NOT NULL,
  display_name VARCHAR(100) NOT NULL
);

CREATE TABLE action (
  id BIGSERIAL PRIMARY KEY,
  workflow_id BIGINT REFERENCES workflow,
  uri VARCHAR(200) NOT NULL,
  name VARCHAR(100) NOT NULL,
  increment_cycle_id BOOLEAN NOT NULL,
  cycle_bound BOOLEAN
);

CREATE TABLE action_state (
  action_id BIGINT REFERENCES action,
  state_definition_id BIGINT REFERENCES state_definition,
  fired BOOLEAN
);



CREATE TABLE action_permission (
  id BIGSERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  action_id BIGINT REFERENCES action,
  state_id BIGINT REFERENCES state_definition,
  assignment_proximity VARCHAR(50),
  ownership_proximity VARCHAR(50)
);

CREATE TABLE content_type (
  id BIGSERIAL PRIMARY KEY,
  uri VARCHAR(200) NOT NULL,
  name varchar(100) NOT NULL
);

CREATE TABLE content_lentl_type (
  id BIGSERIAL PRIMARY KEY,
  lentl_type_id BIGINT REFERENCES lentl_type,
  content_type_id BIGINT REFERENCES content_type
);

CREATE TABLE content_permission (
  id BIGSERIAL PRIMARY KEY,
  content_lentl_type BIGINT REFERENCES content_lentl_type,
  uri VARCHAR(200) NOT NULL,
  name varchar(100) NOT NULL,
  action_id BIGINT REFERENCES action,
  state_id BIGINT REFERENCES state_definition,
  assignment_proximity VARCHAR(50),
  ownership_proximity VARCHAR(50),
  permission_code VARCHAR(10) /*REL for read edit list where list means show it in the view*/
);

CREATE TABLE field (
  id BIGSERIAL PRIMARY KEY,
  uri VARCHAR(200) NOT NULL,
  name VARCHAR(100) NOT NULL
);
