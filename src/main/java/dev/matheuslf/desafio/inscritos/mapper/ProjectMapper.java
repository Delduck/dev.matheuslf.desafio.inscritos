package dev.matheuslf.desafio.inscritos.mapper;

import dev.matheuslf.desafio.inscritos.dto.request.ProjectRequestDTO;
import dev.matheuslf.desafio.inscritos.dto.response.ProjectResponseDTO;
import dev.matheuslf.desafio.inscritos.model.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    ProjectResponseDTO toDTO(Project project);

    @Mapping(target = "id", ignore = true) // id é gerado pelo banco
    Project toEntity(ProjectRequestDTO dto);
}