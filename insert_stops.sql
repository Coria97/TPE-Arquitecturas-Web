-- Insert into stop table
INSERT INTO stops.stop (is_empty, location, slots)
VALUES
    (false, '(48.8584,2.2945)', 10),
    (false, '(50.8584,2.2945)', 5),
    (false, '(55.8584,2.2945)', 6),
    (false, '(53.8584,2.2945)', 7),
    (false, '(51.8584,2.2945)', 8),
    (false, '(60.8584,2.2945)', 5),
    (true, '(50.4940,2.2945)', 3),
    (false, '(59.8584,2.2945)', 6);

-- Insert into scooter table
INSERT INTO stops.scooter (code, km, state, time_usage, stop_id)
VALUES
    ('SCT54321', 23.2509, 'InUse', 102, 2),
    ('SCT98765', 30.8, 'InMaintenance', 200, 2),
    ('SCT64321', 5.2, 'Available', 60, 2),
    ('SCT64322', 5.2, 'Available', 0, 3),
    ('SCT64323', 5.2, 'Available', 0, 4),
    ('SCT64324', 5.2, 'Available', 0, 5),
    ('SCT64325', 5.2, 'Available', 0, 6),
    ('SCT64326', 5.2, 'InMaintenance', 10, 1),
    ('SCT64327', 5.2, 'Available', 0, 8);
