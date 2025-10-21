package dev.matheuslf.desafio.inscritos.service;

import dev.matheuslf.desafio.inscritos.model.Status;
import dev.matheuslf.desafio.inscritos.model.Task;
import dev.matheuslf.desafio.inscritos.repository.ProjectRepository;
import dev.matheuslf.desafio.inscritos.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;

    public TaskService(TaskRepository taskRepository, ProjectRepository projectRepository) {
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
    }

    public Task create(Task t, Long projectId){
        var project = projectRepository.findById(projectId).orElseThrow(() -> new RuntimeException("Project not found"));
        t.setProjectId(project);
        return taskRepository.save(t);
    }

    public List<Task> findAll(){
        return taskRepository.findAll();
    }

    public Task updateStatus(Long id, Status newStatus){
        var task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        task.setStatus(newStatus);
        return taskRepository.save(task);
    }

    public void delete(Long id){
        taskRepository.deleteById(id);
    }
}
