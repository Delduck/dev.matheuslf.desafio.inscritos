package dev.matheuslf.desafio.inscritos.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProjectResponseDTO(Long id, String name, String description, LocalDate startDate, LocalDate endDate) {}
