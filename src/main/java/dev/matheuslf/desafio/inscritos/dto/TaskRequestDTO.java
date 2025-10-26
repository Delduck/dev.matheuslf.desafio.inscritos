package dev.matheuslf.desafio.inscritos.dto;

import dev.matheuslf.desafio.inscritos.model.Priority;
import dev.matheuslf.desafio.inscritos.model.Status;
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
