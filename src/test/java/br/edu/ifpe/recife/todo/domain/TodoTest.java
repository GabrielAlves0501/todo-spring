package br.edu.ifpe.recife.todo.domain;


import static org.junit.jupiter.api.Assertions.assertEquals;

import br.edu.ifpe.recife.todo.domain.entities.Status;
import br.edu.ifpe.recife.todo.domain.entities.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TodoTest {

    @Test
    void shouldCreateUserWithBuilder() {
        Todo todo = Todo.builder().withText("Text").build();
        assertEquals("Text", todo.getText());
    }
}
