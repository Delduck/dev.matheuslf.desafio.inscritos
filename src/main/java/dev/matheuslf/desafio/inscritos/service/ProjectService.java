package dev.matheuslf.desafio.inscritos.service;

import dev.matheuslf.desafio.inscritos.model.Project;
import dev.matheuslf.desafio.inscritos.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project create(Project p){
        return projectRepository.save(p);
    }

    public List<Project> listAll(){
        return projectRepository.findAll();
    }

    public Project findById(Long id){
        return projectRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Project not found")
        );
    }

}
