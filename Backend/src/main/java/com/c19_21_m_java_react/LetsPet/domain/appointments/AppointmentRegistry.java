package com.c19_21_m_java_react.LetsPet.domain.appointments;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public record AppointmentRegistry(


        @JsonProperty("servicio")String service,

        @JsonProperty("fecha_servicio")String dateService,

        @JsonProperty("tiempo_cuidado")String careTime,

        @JsonProperty("cuidador")String caregiver, //Caregiver caregiver

        @JsonProperty("nombre_mascota")String nameOfPet
) {
}
