package com.c19_21_m_java_react.LetsPet.controller;

import com.c19_21_m_java_react.LetsPet.domain.appointments.Appointment;
import com.c19_21_m_java_react.LetsPet.domain.appointments.AppointmentRegistry;
import com.c19_21_m_java_react.LetsPet.domain.appointments.AppointmentRepository;
import com.c19_21_m_java_react.LetsPet.domain.appointments.AppointmentResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments") //pendiente a cambio
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @PostMapping("new-appointment")
    public ResponseEntity <AppointmentResponse> newAppointment(@RequestBody @Valid AppointmentRegistry appointmentRegistry) {
        Appointment appointment = appointmentRepository.save(new Appointment(appointmentRegistry));
        AppointmentResponse appointmentResponse = new AppointmentResponse( //Agregar despues ID de usuario, se removió para pruebas
                appointment.getId(),
                appointment.getService(),
                appointment.getDateService(),
                appointment.getCareTime(),
                appointment.getCaregiver(),
                appointment.getNameOfPet()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentResponse);
    }

    @GetMapping ("appointments-history")
    public ResponseEntity <List<Appointment>> getAppointments(){
        List<Appointment> appointments = appointmentRepository.findAll();
        return ResponseEntity.ok(appointments);
    }



}
