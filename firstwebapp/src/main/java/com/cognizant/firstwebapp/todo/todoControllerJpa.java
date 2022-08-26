package com.cognizant.firstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class todoControllerJpa {

	private TodoRepository todoRepository;

	public todoControllerJpa(TodoRepository todoRepository) {
		super();
		this.todoRepository = todoRepository;
	}

	@RequestMapping("list-todos")
	public String listallTodos(ModelMap model) {
		String username = getLoggedUsername(model);
		List<ToDo> todos = todoRepository.findByUsername(username);
		model.addAttribute("todos", todos);

		return "listTodos";
	}


	@RequestMapping(value = "add-todos", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		ToDo todo = new ToDo(0, getLoggedUsername(model), "", LocalDate.now(), false);
		model.put("todo", todo);
		return "todo";
	}

	@RequestMapping(value = "add-todos", method = RequestMethod.POST)
	public String addNewTodo(ModelMap model, @ModelAttribute("todo") @Valid ToDo todo, BindingResult result) {

		if (result.hasErrors()) {
			model.addAttribute("todo", todo);
			return "todo";
		}
		
		String username = getLoggedUsername(model);
		todo.setUsername(username);
		todoRepository.save(todo);

		return "redirect:list-todos";
	}

	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		
		todoRepository.deleteById(id);
		return "redirect:list-todos";

	}

	@RequestMapping(value = "update-todo", method = RequestMethod.GET)
	public String showUpdateTodosPage(@RequestParam int id, ModelMap model) {

		ToDo todo = todoRepository.findById(id).get();
		model.addAttribute("todo", todo);
		return "todo";
	}

	@RequestMapping(value = "update-todo", method = RequestMethod.POST)
	public String updateTodos(@Valid ToDo todo, ModelMap model, BindingResult result) {

		// COUSING ERRORS!!!!!->
		if (result.hasErrors()) {
			System.out.println("updated");
			model.addAttribute("todo", todo);
			return "todo";
		}

		String username = getLoggedUsername(model);
		todo.setUsername(username);
		todoRepository.save(todo);
		return "redirect:list-todos";
	}
	private String getLoggedUsername(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); 
		return authentication.getName();
	}
}
