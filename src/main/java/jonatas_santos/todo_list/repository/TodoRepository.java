package jonatas_santos.todo_list.repository;

import jonatas_santos.todo_list.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

}
