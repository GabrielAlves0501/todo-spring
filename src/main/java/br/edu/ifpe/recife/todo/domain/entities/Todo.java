package br.edu.ifpe.recife.todo.domain.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private LocalDate dueDate;

    private Todo(String text, LocalDate dueDate) {
        this.text = text;
        this.dueDate = dueDate;
    }

    public Todo() {}

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public static TodoBuilder builder() {
        return new TodoBuilder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Todo todo = (Todo) o;

        return Objects.equals(id, todo.id);
    }

    public static class TodoBuilder {
        private String text;
        private LocalDate dueDate;

        public TodoBuilder withText(String text) {
            this.text = text;
            return this;
        }
        public TodoBuilder withDueDate(LocalDate dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public Todo build() {
            return new Todo(text,  dueDate);
        }
    }
}
