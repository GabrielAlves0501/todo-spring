package br.edu.ifpe.recife.todo.resources;

import br.edu.ifpe.recife.todo.domain.dtos.TodoDTO;
import br.edu.ifpe.recife.todo.domain.entities.Todo;
import br.edu.ifpe.recife.todo.domain.dtos.CreateTodoDTO;
import br.edu.ifpe.recife.todo.usecases.CreateNewTodo;
import br.edu.ifpe.recife.todo.usecases.FindAllTodos;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "todo")
public class TodoController {
    private final CreateNewTodo createNewTodo;
    private final FindAllTodos findAllTodos;

    public TodoController(
        CreateNewTodo createNewTodo,
        FindAllTodos findAllTodos
    ) {
        this.createNewTodo = createNewTodo;
        this.findAllTodos = findAllTodos;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Todo createTodo(@RequestBody CreateTodoDTO todo) {
        return createNewTodo.createTodo(todo.getText(), todo.getDueDate());
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<TodoDTO> createTodo(
        @RequestParam(name = "size", defaultValue = "10") int size,
        @RequestParam(name = "page", defaultValue = "0") int page
    ) {
        return findAllTodos.findAllTodos(page, size);
    }
}
