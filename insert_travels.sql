-- Insertar en billing_method
INSERT INTO travels.billing_method (perdiod_start, perdiod_end, price, type)
VALUES
    ('2024-11-01 21:00:00.000000', '2024-11-30 21:00:00.000000', 99.99, 'normal'),
    ('2024-11-01 21:00:00.000000', '2024-11-30 21:00:00.000000', 110, 'extra'),
    ('2024-12-01 21:00:00.000000', '2024-12-31 21:00:00.000000', 102, 'normal'),
    ('2024-12-01 21:00:00.000000', '2024-12-31 21:00:00.000000', 115, 'extra');

-- Insertar en travel
INSERT INTO travels.travel (distance, start_date, end_date, scooter_id, state, stop_destiny_id, stop_start_id, user_id)
VALUES
    (10, '2024-11-14 05:00:00.000000', '2024-11-14 07:00:00.000000', 1, 'Finished', 2, 1, 1),
    (6, '2024-11-15 05:00:00.000000', '2024-11-15 07:00:00.000000', 1, 'Finished', 2, 1, 1),
    (5, '2024-11-16 05:00:00.000000', '2024-11-16 07:00:00.000000', 1, 'Finished', 2, 1, 1),
    (7, '2024-11-17 05:00:00.000000', '2024-11-17 07:00:00.000000', 1, 'Finished', 2, 1, 1);

-- Insertar en billing
INSERT INTO travels.billing (account_id, amount, amount_debt, billing_date, state, billing_method_id, travel_id)
VALUES
    (1, 1500, 1500, '2024-09-13 21:00:00.000000', 'Finish', 1, 1),
    (2, 1200, 1200, '2024-08-13 21:00:00.000000', 'Finish', 1, 2),
    (1, 100, 100, '2024-10-13 21:00:00.000000', 'Finish', 2, 3),
    (1, 500, 400, '2024-11-13 21:00:00.000000', 'Pending', 2, 4);
