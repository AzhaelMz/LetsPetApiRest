package com.c19_21_m_java_react.LetsPet.domain.appointments;

public record AppointmentResponse(

        Long id,

        String service,

        String dateService,

        String careTime,

        String caregiver, //Caregiver caregiver

        String nameOfPet) {
}
