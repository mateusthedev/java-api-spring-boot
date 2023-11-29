ALTER TABLE product ADD situation BOOLEAN NOT NULL;
UPDATE product SET situation = TRUE;