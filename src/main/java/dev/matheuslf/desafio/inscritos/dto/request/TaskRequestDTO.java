package dev.matheuslf.desafio.inscritos.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record TaskRequestDTO(
        @NotBlank @Size(min = 5, max = 150) String title,
        String description,
        String status,
        String priority,
        LocalDate dueDate,
        @NotNull Long projectId
) {}
