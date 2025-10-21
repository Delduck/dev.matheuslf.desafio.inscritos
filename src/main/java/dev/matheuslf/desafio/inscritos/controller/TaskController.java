package dev.matheuslf.desafio.inscritos.controller;

import dev.matheuslf.desafio.inscritos.dto.TaskRequestDTO;
import dev.matheuslf.desafio.inscritos.dto.TaskResponseDTO;
import dev.matheuslf.desafio.inscritos.model.Status;
import dev.matheuslf.desafio.inscritos.model.Task;
import dev.matheuslf.desafio.inscritos.repository.ProjectRepository;
import dev.matheuslf.desafio.inscritos.repository.TaskRepository;
import dev.matheuslf.desafio.inscritos.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;

    public TaskController(TaskService taskService, ProjectRepository projectRepository, TaskRepository taskRepository) {
        this.taskService = taskService;
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
    }

    /*
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody TaskRequestDTO taskRequestDTO){

        if (!projectRepository.existsById(taskRequestDTO.projectId())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("ID do projeto inexistente");
        }

        Task newTask = taskAssembler.toEntity(taskRequestDTO);
        Task savedTask = taskService.create(newTask, taskRequestDTO.projectId());

        TaskResponseDTO task = taskAssembler.toModel(savedTask);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }


    @PutMapping("/{taskID}/status")
    public ResponseEntity<TaskResponseDTO> updateStatus(@PathVariable Long taskID, @RequestParam String status){
        var updated = taskService.updateStatus(taskID, Status.valueOf(status));
        TaskResponseDTO response = taskAssembler.toModel(updated);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{taskID}")
    public ResponseEntity<Void> delete(@PathVariable Long taskID){

        if (!taskRepository.existsById(taskID)) {
            return ResponseEntity.notFound().build();
        }

        taskService.delete(taskID);
        return ResponseEntity.noContent().build();

    }

     */
}