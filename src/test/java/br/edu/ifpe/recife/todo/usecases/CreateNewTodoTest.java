package br.edu.ifpe.recife.todo.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import br.edu.ifpe.recife.todo.domain.entities.Todo;
import br.edu.ifpe.recife.todo.domain.TodoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CreateNewTodoTest {
    @Mock
    TodoRepository todoRepository;

    @InjectMocks
    CreateNewTodo createNewTodo;

    @Test
    void shouldCreateNewTodoWithDueDate() {
        Todo expected = Todo.builder()
            .withText("Finish project")
            .withDueDate(LocalDate.of(2023, 12, 30))
            .build();

        createNewTodo.createTodo("Finish project", LocalDate.of(2023, 12, 30));

        ArgumentCaptor<Todo> todoCaptor = ArgumentCaptor.forClass(Todo.class);
        verify(todoRepository, times(1)).save(todoCaptor.capture());

        Todo actual = todoCaptor.getValue();
        assertEquals(expected.getText(), actual.getText());
        assertEquals(expected.getDueDate(), actual.getDueDate());
    }

    @Test
    void shouldCreateNewTodoWithDefaultDueDate() {
        LocalDate futureDate = LocalDate.now().plusMonths(1);
        Todo expected = Todo.builder()
                .withText("Finish project")
                .withDueDate(futureDate)
                .build();

        createNewTodo.createTodo("Finish project", null);

        ArgumentCaptor<Todo> todoCaptor = ArgumentCaptor.forClass(Todo.class);
        verify(todoRepository, times(1)).save(todoCaptor.capture());

        Todo actual = todoCaptor.getValue();
        assertEquals(expected.getText(), actual.getText());
        assertEquals(expected.getDueDate(), actual.getDueDate());
    }
}
