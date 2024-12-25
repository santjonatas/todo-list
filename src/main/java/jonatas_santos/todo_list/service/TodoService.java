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

    public Optional<TodoEntity> get(long id) throws Exception {
        var todoEntity = todoRepository.findById(id);

        if(todoEntity == null){
            throw new Exception("Tarefa Inexistente");
        }

        return todoEntity;
    }

    public long update(TodoEntity todo) throws Exception {
        var todoEntity = todoRepository.findById(todo.getId());

        if(todoEntity == null){
            throw new Exception("Tarefa Inexistente");
        }

        todoRepository.save(todo);
        return todo.getId();
    }

    public long delete(long id) throws Exception {
        var todoEntity = todoRepository.findById(id);

        if(todoEntity == null){
            throw new Exception("Tarefa Inexistente");
        }

        todoRepository.deleteById(id);
        return id;
    }
}
