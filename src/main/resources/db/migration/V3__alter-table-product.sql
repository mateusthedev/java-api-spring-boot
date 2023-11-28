ALTER TABLE product ADD situation INT NOT NULL DEFAULT 1;
UPDATE product SET situation = 1;