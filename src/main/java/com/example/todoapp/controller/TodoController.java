package com.example.todoapp.controller;

import com.example.todoapp.domain.ToDo;
import com.example.todoapp.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TodoController {
    private final ToDoRepository toDoRepository;

    @GetMapping("/")
    public String index(Model model){
        List<ToDo> todos = toDoRepository.findAll(); //DB에서 가지고 오기
        model.addAttribute("todos",todos); //todos라는 이름에 담겨서 todos.html에 전달
        return "todos";
    }

    @PostMapping("/addTodo")
    public String addTodo(@RequestParam("todo") String todo){
        //System.out.println(todo);
        //데이터베이스에 저장합시다!
        ToDo toDo = new ToDo();
        toDo.setTodo(todo);
        toDoRepository.save(toDo);
        return "redirect:/"; // 웹페이지를 /로 자동 이동해라 (위에 해당)
    }

    @PostMapping("/deleteTodo/{id}")
    public String deleteTodo(@PathVariable Long id){
        toDoRepository.deleteById(id);
        return "redirect:/";
    }
}
