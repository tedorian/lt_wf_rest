ALTER TABLE role add column code VARCHAR(10);
ALTER TABLE workflow add column submodule_id BIGINT references submodule;
