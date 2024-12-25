package jonatas_santos.todo_list.controller;

import jonatas_santos.todo_list.entity.TodoEntity;
import jonatas_santos.todo_list.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/create")
    public long create(@RequestBody TodoEntity todo) {
        return todoService.create(todo);
    }

    @GetMapping("/getAll")
    public List<TodoEntity> getAll(){
        return  todoService.getAll();
    }

    @GetMapping("/get")
    public Optional<TodoEntity> get(long id) throws Exception {
        return todoService.get(id);
    }

    @PutMapping("/update")
    public long update(@RequestBody TodoEntity todo) throws Exception {
        return todoService.update(todo);
    }

    @DeleteMapping("{id}")
    public long delete(@PathVariable("id") long id) throws Exception {
        return todoService.delete(id);
    }
}
