SELECT id                                               as "NAME",
       EXTRACT(YEAR FROM age(finish_date, start_date)) * 12 +
       EXTRACT(MONTH FROM age(finish_date, start_date)) AS "MONTH_COUNT"
FROM project
WHERE EXTRACT(YEAR FROM age(finish_date, start_date)) * 12 +
      EXTRACT(MONTH FROM age(finish_date, start_date)) =
      (SELECT MAX(EXTRACT(YEAR FROM age(finish_date, start_date)) * 12 +
                  EXTRACT(MONTH FROM age(finish_date, start_date)))
       FROM project)