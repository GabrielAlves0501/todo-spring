package br.edu.ifpe.recife.todo.usecases;

import br.edu.ifpe.recife.todo.domain.entities.Todo;
import br.edu.ifpe.recife.todo.domain.TodoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CreateNewTodo {
    private final TodoRepository todoRepository;

    public CreateNewTodo(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo createTodo(String todoText, LocalDate dueDate) {
        LocalDate todoDueDate = dueDate == null ? LocalDate.now().plusMonths(1) : dueDate;

        Todo todo = Todo.builder()
            .withText(todoText)
            .withDueDate(todoDueDate)
            .build();

       return todoRepository.save(todo);
    }
}
