package com.c19_21_m_java_react.LetsPet.controller;

import com.c19_21_m_java_react.LetsPet.domain.address.AddressData;
import com.c19_21_m_java_react.LetsPet.domain.caregiver.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/caregiver")
public class CargiverController {

    @Autowired
    private CaregiverRepository caregiverRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<CaregiverDataResponse> caregiverRegister(@RequestBody @Valid RegisterCargiverData registerCargiverData, UriComponentsBuilder uriComponentsBuilder){
        Caregiver caregiver = caregiverRepository.save(new Caregiver(registerCargiverData));
        CaregiverDataResponse caregiverDataResponse = new CaregiverDataResponse(caregiver.getId(),caregiver.getName(), caregiver.getEmail(), caregiver.getTelephone()
        ,caregiver.getDocument(), new AddressData(caregiver.getAddress().getStreet(), caregiver.getAddress().getCity(), caregiver.getAddress().getDistrict()));

        URI url = uriComponentsBuilder.path("/caregiver/{id}").buildAndExpand(caregiver.getId()).toUri();
        return ResponseEntity.created(url).body(caregiverDataResponse);
    }

    @GetMapping
    public ResponseEntity <List<Caregiver>> listCaregivers(){
        List<Caregiver> caregivers = caregiverRepository.findAll();
        return ResponseEntity.ok(caregivers);
    }
}
