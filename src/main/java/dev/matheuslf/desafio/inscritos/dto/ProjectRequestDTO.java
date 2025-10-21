package dev.matheuslf.desafio.inscritos.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public record ProjectRequestDTO(
        @NotBlank @Size(min = 3, max = 100) String name,
        String description,
        LocalDate startDate,
        LocalDate endDate
) {}
