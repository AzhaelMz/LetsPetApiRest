package com.c19_21_m_java_react.LetsPet.domain.caregiver;

import com.c19_21_m_java_react.LetsPet.domain.address.AddressData;

public record CaregiverDataResponse(Long id,
                                    String name,
                                    String email,
                                    String telephone,
                                    String document,
                                    AddressData address) {
}
