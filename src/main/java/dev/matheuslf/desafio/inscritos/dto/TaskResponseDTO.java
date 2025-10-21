package dev.matheuslf.desafio.inscritos.dto;

import dev.matheuslf.desafio.inscritos.model.Project;

import java.time.LocalDate;

public record TaskResponseDTO(Long id, String title, String description, String status, String priority, LocalDate dueDate, Project projectId) {}
