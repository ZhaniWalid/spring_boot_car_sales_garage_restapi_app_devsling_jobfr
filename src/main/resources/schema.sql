-- To launch the H2 Database on Browser hit this link => http://localhost:8080(defaultPort)/h2-console
-- Copy & Paste this in the H2 SQL Database editor & run it to create the table
DROP TABLE IF EXISTS GARAGE_CATALOG;
CREATE TABLE GARAGE_CATALOG (
    id_catalog INT AUTO_INCREMENT PRIMARY KEY,
    garage_name VARCHAR(50) NOT NULL
);

-- Copy & Paste this in the H2 SQL Database editor & run it to create the table
DROP TABLE IF EXISTS CAR;
CREATE TABLE CAR (
    id_car INT AUTO_INCREMENT PRIMARY KEY,
    make VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    registration_date INT NOT NULL,
    price INT NOT NULL,
    fuel_type VARCHAR(10) NOT NULL,
    mileage INT NOT NULL,
    transmission VARCHAR(20) NOT NULL,
    picture VARCHAR(100) NOT NULL
);