package com.cs.dipocketback.pojo.dashboard;

import java.util.List;

public class StatementRequestTodoList {
    
    private List<StatementRequestTodo> list;
    
    public StatementRequestTodoList() {
    }

    public StatementRequestTodoList(List<StatementRequestTodo> list) {
        this.list = list;
    }

    public void setList(List<StatementRequestTodo> list) {
        this.list = list;
    }

    public List<StatementRequestTodo> getList() {
        return list;
    }
    
}
