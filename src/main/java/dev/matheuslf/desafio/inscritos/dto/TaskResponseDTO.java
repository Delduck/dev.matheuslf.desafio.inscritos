package dev.matheuslf.desafio.inscritos.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dev.matheuslf.desafio.inscritos.model.Project;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record TaskResponseDTO(Long id, String title, String description, String status, String priority, LocalDate dueDate, Project project) {}
