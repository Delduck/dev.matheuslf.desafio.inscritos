package dev.matheuslf.desafio.inscritos.controller;

import dev.matheuslf.desafio.inscritos.dto.request.TaskRequestDTO;
import dev.matheuslf.desafio.inscritos.dto.response.TaskResponseDTO;
import dev.matheuslf.desafio.inscritos.mapper.TaskMapper;
import dev.matheuslf.desafio.inscritos.model.Priority;
import dev.matheuslf.desafio.inscritos.model.Status;
import dev.matheuslf.desafio.inscritos.model.Task;
import dev.matheuslf.desafio.inscritos.repository.ProjectRepository;
import dev.matheuslf.desafio.inscritos.repository.TaskRepository;
import dev.matheuslf.desafio.inscritos.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskController(TaskService taskService, ProjectRepository projectRepository, TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }


    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody TaskRequestDTO taskRequestDTO){

        if (!projectRepository.existsById(taskRequestDTO.projectId())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("ID do projeto inexistente");
        }

        Task newTask = taskMapper.toEntity(taskRequestDTO);
        Task savedTask = taskService.create(newTask, taskRequestDTO.projectId());

        TaskResponseDTO task = taskMapper.toDTO(savedTask);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> list(@RequestParam(required = false)Status status, @RequestParam(required = false) Priority priority,
                                                      @RequestParam(required = false)Long projectId, Pageable pageable){

        Page<Task> tasks = taskService.findByFilters(status, priority, projectId, pageable);
        List<TaskResponseDTO> dtos = tasks.stream()
                .map(taskMapper::toDTO)
                .toList();

        return ResponseEntity.ok(dtos);
    }

    @PutMapping("/{taskID}/status")
    public ResponseEntity<TaskResponseDTO> updateStatus(@PathVariable Long taskID, @RequestParam Status status){
        var updated = taskService.updateStatus(taskID, status);
        TaskResponseDTO response = taskMapper.toDTO(updated);
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
}