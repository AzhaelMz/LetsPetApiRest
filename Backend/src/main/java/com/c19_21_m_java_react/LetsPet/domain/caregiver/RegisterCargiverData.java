package com.c19_21_m_java_react.LetsPet.domain.caregiver;

import com.c19_21_m_java_react.LetsPet.domain.address.AddressData;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record RegisterCargiverData(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Size(min = 0, max = 15)
        String telephone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String document,
        @NotNull
        @Valid
        AddressData address
) {
}
