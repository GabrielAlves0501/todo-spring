package br.edu.ifpe.recife.todo.domain.dtos;

import java.time.LocalDate;

public class CreateTodoDTO {
    private String text;
    private LocalDate dueDate;

    public CreateTodoDTO() {}

    public CreateTodoDTO(String text, LocalDate dueDate) {
        this.text = text;
        this.dueDate = dueDate;
    }

    public String getText() {
        return text;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setText(String text) {
        this.text = text;
    }

}
