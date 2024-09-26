DO $$
BEGIN
    IF NOT EXISTS(
        SELECT schema_name
        FROM information_schema.schemata
        WHERE schema_name = 'shift_schema'
    ) THEN
        EXECUTE 'CREATE SCHEMA shift_schema';
    END IF;
END
$$;
