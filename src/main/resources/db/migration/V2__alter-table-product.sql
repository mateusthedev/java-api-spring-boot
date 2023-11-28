ALTER TABLE product ADD stock INT NOT NULL DEFAULT 0;
UPDATE product SET stock = 0;

