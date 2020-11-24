package intromethods;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
    private List<Todo> todos = new ArrayList<>();


    public void addTodo(String caption) {
        todos.add(new Todo(caption));
    }

    public void finishTodos(String caption) {
        for (Todo todo: todos) {
            if (caption.equals(todo.getCaption())) {
                todo.finish();
            }
        }
    }

    public void finishAllTodos(List<String> todosToFinish) {
        for (Todo todo: todos) {
            for (String todo1: todosToFinish) {
                if (todo1.equals(todo.getCaption())) {
                    todo.finish();
                }
            }
        }
    }

    public List<String> todosToFinish() {
        List<String> todosToFinish = new ArrayList<>();
        for (Todo todo: todos) {
            if (!todo.isFinished()) {
                todosToFinish.add(todo.getCaption());
            }
        }
        return todosToFinish;
    }

    public int numberOfFinishedTodos() {
        int count = 0;
        for (Todo todo: todos) {
            if (todo.isFinished()) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return todos.toString();
    }

}
