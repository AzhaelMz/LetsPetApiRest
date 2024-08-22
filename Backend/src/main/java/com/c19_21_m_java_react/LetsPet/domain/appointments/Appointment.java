package com.c19_21_m_java_react.LetsPet.domain.appointments;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table (name = "appointments")
@Entity (name = "Appointment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="service")
    private String service;

    @Column(name ="date_service")
    private String dateService;

    @Column(name ="care_time")
    private String careTime;

    @Column(name ="caregiver")
    private String caregiver;
    //private Caregiver caregiver;
    @Column(name ="name_of_pet")
    private String nameOfPet;

    public Appointment(AppointmentRegistry appointmentRegistry) {
        this.service = appointmentRegistry.service();
        this.dateService = appointmentRegistry.dateService();
        this.careTime = appointmentRegistry.careTime();
        this.caregiver = appointmentRegistry.caregiver();
        this.nameOfPet = appointmentRegistry.nameOfPet();
    }
}
