package com.c19_21_m_java_react.LetsPet.domain.caregiver;

import com.c19_21_m_java_react.LetsPet.domain.address.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "caregivers")
@Entity(name = "Caregiver")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Caregiver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String telephone;

    private String document;

    @Embedded
    private Address address;

    public Caregiver(RegisterCargiverData registerCargiverData){
        this.name = registerCargiverData.name();
        this.email = registerCargiverData.email();
        this.telephone = registerCargiverData.telephone();
        this.document = registerCargiverData.document();
        this.address = new Address(registerCargiverData.address());
    }
}
