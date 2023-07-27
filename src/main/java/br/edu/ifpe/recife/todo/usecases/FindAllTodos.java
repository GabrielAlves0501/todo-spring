package br.edu.ifpe.recife.todo.usecases;

import br.edu.ifpe.recife.todo.domain.TodoRepository;
import br.edu.ifpe.recife.todo.domain.dtos.TodoDTO;
import br.edu.ifpe.recife.todo.domain.entities.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class FindAllTodos {

    private final TodoRepository todoRepository;

    public FindAllTodos(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Page<TodoDTO> findAllTodos(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        return todoRepository.findAll(pageable).map(FindAllTodos::formatTodo);
    }

    static boolean isTodoDueDateActive(LocalDate localDate) {
        if (localDate == null) {
            return false;
        }

        LocalDate now = LocalDate.now();

        boolean isEqualToday = localDate.isEqual(now);
        boolean isAfterToday = localDate.isAfter(now);

        return isEqualToday || isAfterToday;
    }

    static TodoDTO formatTodo(Todo todo) {
        TodoDTO todoDTO = new TodoDTO();

        todoDTO.setText(todo.getText());
        todoDTO.setDueDate(todo.getDueDate());
        todoDTO.setId(todo.getId());
        todoDTO.setActive(isTodoDueDateActive(todo.getDueDate()));

        return todoDTO;
    }
}
