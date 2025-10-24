package dev.matheuslf.desafio.inscritos.controller;

import dev.matheuslf.desafio.inscritos.dto.ProjectRequestDTO;
import dev.matheuslf.desafio.inscritos.dto.ProjectResponseDTO;
import dev.matheuslf.desafio.inscritos.mapper.ProjectMapper;
import dev.matheuslf.desafio.inscritos.model.Project;
import dev.matheuslf.desafio.inscritos.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;
    private final ProjectMapper projectMapper;

    public ProjectController(ProjectService projectService, ProjectMapper projectMapper) {
        this.projectService = projectService;
        this.projectMapper = projectMapper;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectResponseDTO create(@RequestBody @Valid ProjectRequestDTO projectRequest){
        Project newProject = projectMapper.toEntity(projectRequest);
        Project savedProject = projectService.create(newProject);

        return projectMapper.toDTO(savedProject);
    }

    @GetMapping
    public ResponseEntity<List<ProjectResponseDTO>> list(Pageable pageable){
        List<Project> projects = projectService.listAll(pageable);
        List<ProjectResponseDTO> dtos = projects.stream()
                .map(projectMapper::toDTO)
                .toList();

        return ResponseEntity.ok(dtos);
    }
}
