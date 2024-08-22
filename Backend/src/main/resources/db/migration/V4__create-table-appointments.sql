CREATE TABLE appointments (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    service VARCHAR(150) NOT NULL,
    date_service VARCHAR(30) NOT NULL,
    care_time VARCHAR(30) NOT NULL,
    caregiver VARCHAR(100) NOT NULL,
    name_of_pet VARCHAR(50) NOT NULL
);
