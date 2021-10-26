package com.cs.dipocketback.pojo.pekao;

import java.util.List;

public class PekaoTodoList {
    
    private List<PekaoTodo> todoList;
    
    public PekaoTodoList() {
    }

    public PekaoTodoList(List<PekaoTodo> todoList) {
        this.todoList = todoList;
    }

    public void setTodoList(List<PekaoTodo> todoList) {
        this.todoList = todoList;
    }

    public List<PekaoTodo> getTodoList() {
        return todoList;
    }
}
