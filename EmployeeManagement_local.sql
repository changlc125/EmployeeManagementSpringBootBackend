DROP DATABASE IF EXISTS AuthenticationDB;
CREATE DATABASE AuthenticationDB;

DROP DATABASE IF EXISTS HousingDB;
CREATE DATABASE HousingDB;

DROP DATABASE IF EXISTS ApplicationDB;
CREATE DATABASE ApplicationDB;

-- CREATE TABLES
use AuthenticationDB;

CREATE TABLE IF NOT EXISTS User (
	user_id int AUTO_INCREMENT PRIMARY KEY,
    username varchar(50) UNIQUE,
    email varchar(320) UNIQUE,
    password varchar(60),
    create_date datetime,
    last_modification_date datetime,
    active_flag bool DEFAULT true
);

CREATE TABLE IF NOT EXISTS Role(
	role_id int AUTO_INCREMENT PRIMARY KEY,
    role_name varchar(50),
    role_description varchar(500),
    create_date datetime,
    last_modification_date datetime
);

CREATE TABLE IF NOT EXISTS UserRole(
	user_role_id int AUTO_INCREMENT PRIMARY KEY,
    user_id int,
    role_id int,
    active_flag bool,
    create_date datetime,
    last_modification_date datetime,
    FOREIGN KEY(user_id) REFERENCES User(user_id),
    FOREIGN KEY(role_id) REFERENCES Role(role_id)
);

CREATE TABLE IF NOT EXISTS RegistrationToken(
	registration_token_id int AUTO_INCREMENT PRIMARY KEY,
    token varchar(36),
    email varchar(320),
    expiration_date datetime,
    created_by int,
    FOREIGN KEY(created_by) REFERENCES User(user_id)
);

use ApplicationDB;

CREATE TABLE IF NOT EXISTS ApplicationWorkflow(
	application_workflow_id int AUTO_INCREMENT PRIMARY KEY,
    employee_id varchar(24),
    create_date datetime,
    last_modification_date datetime,
    status varchar(20),
    comment varchar(500)
);

CREATE TABLE IF NOT EXISTS DigitalDocument(
	digital_document_id int AUTO_INCREMENT PRIMARY KEY,
    type varchar(20),
    is_required bool,
    path varchar(500),
    description varchar(500),
    title varchar(50)
);

use HousingDB;

CREATE TABLE IF NOT EXISTS Landlord(
	landlord_id int AUTO_INCREMENT PRIMARY KEY,
    first_name varchar(50),
    last_name varchar(50),
    email varchar(320) UNIQUE,
    phone_number varchar(25)
);

CREATE TABLE IF NOT EXISTS House(
	house_id int AUTO_INCREMENT PRIMARY KEY,
    landlord_id int,
    address varchar(200),
    max_occupant int,
    FOREIGN KEY(landlord_id) REFERENCES Landlord(landlord_id)
);

CREATE TABLE IF NOT EXISTS Facility(
	facility_id int AUTO_INCREMENT PRIMARY KEY,
    house_id int,
    type varchar(20),
    description varchar(500),
    quantity int,
    FOREIGN KEY(house_id) REFERENCES House(house_id)
);

CREATE TABLE IF NOT EXISTS FacilityReport(
	facility_report_id int AUTO_INCREMENT PRIMARY KEY,
    facility_id int,
    employee_id varchar(24),
    title varchar(50),
    description varchar(500),
    create_date datetime,
    status varchar(20),
    FOREIGN KEY(facility_id) REFERENCES Facility(facility_id)
);

CREATE TABLE IF NOT EXISTS FacilityReportDetail(
	facility_report_detail_id int AUTO_INCREMENT PRIMARY KEY,
    facility_report_id int,
    employee_id varchar(24),
    comment varchar(500),
    create_date datetime,
    last_modification_date datetime,
    FOREIGN KEY(facility_report_id) REFERENCES FacilityReport(facility_report_id)
);