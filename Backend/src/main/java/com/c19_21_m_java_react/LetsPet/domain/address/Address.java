package com.c19_21_m_java_react.LetsPet.domain.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String street;

    private String city;

    private String district;


    public Address(AddressData address){
        this.street = address.street();
        this.city = address.city();
        this.district = address.district();
    }
}
