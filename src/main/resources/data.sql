-- To launch the H2 Database on Browser hit this link => http://localhost:8080(defaultPort)/h2-console
-- Spring Boot automatically picks up the "data.sql" file and run it against the "H2 database" during the application startup.

-- Copy & Paste this line in the H2 SQL Database editor & run it to insert Data.
INSERT INTO GARAGE_CATALOG VALUES (1, 'Need For Speed Most Wanted Garage');

-- Copy & Paste these lines in the H2 SQL Database editor & run it to insert Data.
INSERT INTO CAR VALUES (
    1, 'Honda', 'Civic LX', 2018, 10000, 'DIESEL', 4000, 'SEMI_AUTOMATIC', 'resources/static/images/1__2018-Honda-Civic-LX.jpg'
);
INSERT INTO CAR VALUES (
   2, 'Toyota', 'Land Cruiser', 2019, 5000, 'HYBRID', 7000, 'MANUAL', 'resources/static/images/2__2019-Toyota-Land-Cruiser.jpg'
);
INSERT INTO CAR VALUES (
   3, 'Golf', '#7', 2017, 17500, 'ELECTRIC', 7000, 'AUTOMATIC', 'resources/static/images/3__2017-Golf-7.jpg'
);