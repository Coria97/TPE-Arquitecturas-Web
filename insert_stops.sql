-- Insert into scooter table
INSERT INTO stops.scooter (code, km, state, time_out, time_usage, stop_id)
VALUES
    ('SCT54321', 5.2, 'En Uso', 5, 60, 2),
    ('SCT98765', 30.8, 'En Mantenimiento', 25, 200, 2),
    ('SCT64321', 5.2, 'Disponible', 5, 60, 2);

-- Insert into stop table
INSERT INTO stops.stop (full, location, slots)
VALUES
    (false, '(48.8584,2.2945)', 10),
    (false, '(50.8584,2.2945)', 5);

