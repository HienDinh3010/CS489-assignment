CREATE TABLE Dentist
(
    dentist_id     SERIAL PRIMARY KEY,
    first_name     VARCHAR(50),
    last_name      VARCHAR(50),
    phone  VARCHAR(20),
    email          VARCHAR(100),
    specialization VARCHAR(100)
);

CREATE TABLE Patient
(
    patient_id      SERIAL PRIMARY KEY,
    first_name      VARCHAR(50),
    last_name       VARCHAR(50),
    phone   VARCHAR(20),
    email           VARCHAR(100),
    address VARCHAR(255),
    date_of_birth   DATE
);

CREATE TABLE Surgery
(
    surgery_id       SERIAL PRIMARY KEY,
    name             VARCHAR(100),
    address VARCHAR(255),
    telephone_number VARCHAR(20)
);

CREATE TABLE Appointment
(
    appointment_id   SERIAL PRIMARY KEY,
    dentist_id       INT REFERENCES Dentist (dentist_id),
    patient_id       INT REFERENCES Patient (patient_id),
    surgery_id       INT REFERENCES Surgery (surgery_id),
    appointment_date DATE,
    surgery_location VARCHAR(100)
);

-- Dummy data for Dentist table
INSERT INTO Dentist (first_name, last_name, phone, email, specialization)
VALUES
    ('John', 'Doe', '123-456-7890', 'john.doe@example.com', 'General Dentistry'),
    ('Alice', 'Smith', '987-654-3210', 'alice.smith@example.com', 'Orthodontics'),
    ('Michael', 'Johnson', '456-789-0123', 'michael.johnson@example.com', 'Endodontics');

-- Dummy data for Patient table
INSERT INTO Patient (first_name, last_name, phone, email, address, date_of_birth)
VALUES
    ('Jane', 'Doe', '555-123-4567', 'jane.doe@example.com', '123 Main St, Cityville', '1990-05-15'),
    ('Bob', 'Johnson', '777-888-9999', 'bob.johnson@example.com', '456 Elm St, Townsville', '1985-10-10'),
    ('Emily', 'Williams', '333-444-5555', 'emily.williams@example.com', '789 Oak St, Villageton', '1978-03-20');

-- Dummy data for Surgery table
INSERT INTO Surgery (name, address, telephone_number)
VALUES
    ('City Dental Clinic', '789 Broadway, Cityville', '111-222-3333'),
    ('Town Dental Center', '456 Maple Ave, Townsville', '444-555-6666'),
    ('Village Family Dentistry', '123 Oak St, Villageton', '777-888-9999');

-- Dummy data for Appointment table
INSERT INTO Appointment (dentist_id, patient_id, surgery_id, appointment_date, surgery_location)
VALUES
    (1, 1, 1, '2024-04-10', 'City Dental Clinic'),
    (2, 2, 2, '2024-04-12', 'Town Dental Center'),
    (3, 3, 3, '2024-04-15', 'Village Family Dentistry');

-- Display the list of ALL Dentists registered in the system, sorted in ascending order of their lastNames:
SELECT *
FROM Dentist
ORDER BY last_name ASC;
-- Display the list of ALL Appointments for a given Dentist by their dentist_Id number. Include in the result, the Patient information:
SELECT Appointment.*, Patient.first_name AS patient_first_name, Patient.last_name AS patient_last_name
FROM Appointment
         JOIN Dentist ON Appointment.dentist_id = Dentist.dentist_id
         JOIN Patient ON Appointment.patient_id = Patient.patient_id
WHERE Dentist.dentist_id = 1;

-- Display the list of ALL Appointments that have been scheduled at a Surgery Location:
SELECT Appointment.*, Surgery.name AS surgery_location
FROM Appointment
JOIN Surgery ON Appointment.surgery_id = Surgery.surgery_id;

-- Display the list of the Appointments booked for a given Patient on a given Date:
SELECT Appointment.*, Patient.first_name AS patient_first_name, Patient.last_name AS patient_last_name
FROM Appointment
         JOIN Patient ON Appointment.patient_id = Patient.patient_id
WHERE Patient.patient_id = 2 AND Appointment.appointment_date = '2024-04-12';

