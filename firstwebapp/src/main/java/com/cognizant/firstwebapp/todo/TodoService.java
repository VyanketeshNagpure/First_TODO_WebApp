package com.cognizant.firstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	private static List<ToDo> todos = new ArrayList<ToDo>();
	private int todoCount = 3;

	static {
		todos.add(new ToDo(1, "udemy", "learn microservices", LocalDate.now(), false));
		todos.add(new ToDo(2, "udemy", "learn CSS", LocalDate.now().plusYears(1), false));
		todos.add(new ToDo(3, "udemy", "learn VIM", LocalDate.now().plusYears(3), false));
	}

	public List<ToDo> findByUsername(String username) {
		Predicate<? super ToDo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}

	public void addTodo(String name, String description, LocalDate localdate, Boolean isdone) {
		ToDo todo = new ToDo(++todoCount, name, description, localdate, isdone);
		todos.add(todo);
	}

	public void deleteTodo(int id) {

		Predicate<? super ToDo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public ToDo findByid(int id) {
		Predicate<? super ToDo> predicate = todo -> todo.getId() == id;
		ToDo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid ToDo todo) {
		deleteTodo(todo.getId());
		todos.add(todo);
	}

}
