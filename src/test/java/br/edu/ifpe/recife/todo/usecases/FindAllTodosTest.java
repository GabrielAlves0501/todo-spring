package br.edu.ifpe.recife.todo.usecases;

import br.edu.ifpe.recife.todo.domain.dtos.TodoDTO;
import br.edu.ifpe.recife.todo.domain.entities.Todo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class FindAllTodosTest {
    @InjectMocks
    FindAllTodos findAllTodos;

    @Test
    void shouldReturnFalseIfDueDateIsNull() {
        assertFalse(FindAllTodos.isTodoDueDateActive(null));
    }


    @Test
    void shouldReturnTrueIfDueDateIsToday() {
        LocalDate today = LocalDate.now();

        assertTrue(FindAllTodos.isTodoDueDateActive(today));
    }

    @Test
    void shouldReturnTrueIfDueDateIsBeforeToday() {
        LocalDate today = LocalDate.now();
        LocalDate dueDate = today.minusDays(1);

        assertFalse(FindAllTodos.isTodoDueDateActive(dueDate));
    }

    @Test
    void shouldReturnFalseIfDueDateIsAfterToday() {
        LocalDate today = LocalDate.now();
        LocalDate dueDate = today.plusDays(2);

        assertTrue(FindAllTodos.isTodoDueDateActive(dueDate));
    }

    @Test
    void shouldFormatTodo() {
        Todo todo = Todo
            .builder()
            .withText("Test text")
            .withDueDate(LocalDate.now().plusDays(10))
            .build();

        TodoDTO todoDTO = FindAllTodos.formatTodo(todo);

        assertEquals(todoDTO.getText(), todo.getText());
        assertEquals(todoDTO.getDueDate(), todo.getDueDate());
        assertTrue(todoDTO.isActive());
    }

}
