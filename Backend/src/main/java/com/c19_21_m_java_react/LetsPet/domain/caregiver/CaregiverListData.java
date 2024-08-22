package com.c19_21_m_java_react.LetsPet.domain.caregiver;

import com.c19_21_m_java_react.LetsPet.domain.address.Address;
import com.c19_21_m_java_react.LetsPet.domain.address.AddressData;

public record CaregiverListData(Long id,
                                String name,
                                String email,
                                String telephone,
                                String document) {
    public CaregiverListData (Caregiver caregiver){
        this(caregiver.getId(), caregiver.getName(), caregiver.getEmail(), caregiver.getTelephone(), caregiver.getDocument());
    }
}
