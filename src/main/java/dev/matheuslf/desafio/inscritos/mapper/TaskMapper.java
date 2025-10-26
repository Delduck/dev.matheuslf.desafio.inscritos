package dev.matheuslf.desafio.inscritos.mapper;

import dev.matheuslf.desafio.inscritos.dto.TaskRequestDTO;
import dev.matheuslf.desafio.inscritos.dto.TaskResponseDTO;
import dev.matheuslf.desafio.inscritos.model.Priority;
import dev.matheuslf.desafio.inscritos.model.Status;
import dev.matheuslf.desafio.inscritos.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    @Mapping(source = "projectId", target = "project")
    @Mapping(source = "status", target = "status", qualifiedByName = "enumToString")
    @Mapping(source = "priority", target = "priority", qualifiedByName = "enumToString")
    TaskResponseDTO toDTO(Task task);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "status", target = "status", qualifiedByName = "stringToStatusEnum")
    @Mapping(source = "priority", target = "priority", qualifiedByName = "stringToPriorityEnum")
    @Mapping(target = "projectId", ignore = true) // será setado no service via projectId
    Task toEntity(TaskRequestDTO dto);

    // Converters
    @Named("enumToString")
    static String enumToString(Enum<?> e) {
        return e != null ? e.name() : null;
    }

    @Named("stringToStatusEnum")
    static Status stringToStatusEnum(String value) {
        return value != null ? Status.valueOf(value.toUpperCase()) : null;
    }

    @Named("stringToPriorityEnum")
    static Priority stringToPriorityEnum(String value) {
        return value != null ? Priority.valueOf(value.toUpperCase()) : null;
    }
}
