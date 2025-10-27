package dev.matheuslf.desafio.inscritos.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public record ProjectRequestDTO(
        @NotBlank(message = "Name is required") @Size(min = 3, max = 100) String name,
        String description,
        LocalDate startDate,
        LocalDate endDate
) {}
