-- Insert into user table
INSERT INTO users.user (email, first_name, last_name, phone_number, rol, username, password)
VALUES
    ('juanperez@example.com', 'Juan', 'Pérez', 123456789, 'CLIENT', 'juanperez123', '$2a$10$6r.kbL2RUiVFxVsPAOtoGODu1LiI41M5KfpThu.JR8ymhTf79ngZu'),
    ('anagomez@example.com', 'Ana', 'Gómez', 987654321, 'ADMIN', 'anagomez456', '$2a$10$6r.kbL2RUiVFxVsPAOtoGODu1LiI41M5KfpThu.JR8ymhTf79ngZu'),
    ('carlosmartinez@example.com', 'Carlos', 'Martínez', 555555555, 'REPAIR_MAN', 'carlosmartinez789', '$2a$10$6r.kbL2RUiVFxVsPAOtoGODu1LiI41M5KfpThu.JR8ymhTf79ngZu'),
    ('laurasanchez@example.com', 'Laura', 'Sánchez', 112233445, 'CLIENT', 'laurasanchez234', '$2a$10$6r.kbL2RUiVFxVsPAOtoGODu1LiI41M5KfpThu.JR8ymhTf79ngZu');

-- Insert into account table
INSERT INTO users.account (active, balance, mp_account)
VALUES
    (false, 1000.5, 'mp_account_001'),
    (false, 1500.75, 'mp_account_002'),
    (false, 500.25, 'mp_account_003'),
    (true, 300, 'mp_account_004'),
    (true, 1200, 'mp_account_005');
