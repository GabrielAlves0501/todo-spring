package br.edu.ifpe.recife.todo.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import br.edu.ifpe.recife.todo.domain.entities.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class TodoTest {

    @Test
    void shouldCreateUserWithBuilder() {
        LocalDate dueDate = LocalDate.of(2023, 1, 1);
        Todo todo = Todo.builder().withText("Text").withDueDate(dueDate).build();
        assertEquals("Text", todo.getText());
        assertNull(todo.getId());
        assertEquals(dueDate, todo.getDueDate());
    }
}
