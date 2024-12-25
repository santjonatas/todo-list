package jonatas_santos.todo_list.service;

import jonatas_santos.todo_list.entity.TodoEntity;
import jonatas_santos.todo_list.repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public long create(TodoEntity todo) {
        TodoEntity todoEntity = todoRepository.save(todo);

        return todoEntity.getId();
    }

    public List<TodoEntity> getAll(){
        Sort sort = Sort.by(Sort.Order.desc("prioridade"))
                .and(Sort.by(Sort.Order.asc("nome")));
        return todoRepository.findAll(sort);
    }

    public Optional<TodoEntity> get(long id){
        var todoEntity = todoRepository.findById(id);

        return todoEntity;
    }

    public long update(TodoEntity todo){
        var todoEntity = todoRepository.findById(todo.getId());

        todoRepository.save(todo);
        return todo.getId();
    }

    public long delete(long id){
        var todoEntity = todoRepository.findById(id);

        todoRepository.deleteById(id);
        return id;
    }
}
