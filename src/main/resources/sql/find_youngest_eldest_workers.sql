SELECT CASE
           WHEN birthday = (SELECT MIN(birthday) FROM worker) THEN 'YOUNGEST'
           WHEN birthday = (SELECT MAX(birthday) FROM worker) THEN 'ELDEST'
        END AS "TYPE",
        name AS "NAME",
        birthday AS "BIRTHDAY"
FROM worker
WHERE birthday IN (
                       (SELECT MIN(birthday) FROM worker),
                       (SELECT MAX(birthday) FROM worker)
    );
