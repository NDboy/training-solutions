package intromethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TodoListMain {
    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        todoList.addTodo("reggeli");
        todoList.addTodo("munka");
        todoList.addTodo("ebéd");
        todoList.addTodo("értekezlet");
        todoList.addTodo("bevásárlás");
        todoList.addTodo("vacsora");

        System.out.println(todoList);
        todoList.finishTodos("reggeli");
        todoList.finishTodos("munka");
        System.out.println(todoList);

        todoList.finishAllTodos(Arrays.asList("ebéd", "értekezlet"));
        System.out.println(todoList);

        System.out.println(todoList.todosToFinish());
        System.out.println(todoList.numberOfFinishedTodos());

    }
}
