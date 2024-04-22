package pisith.xyz.todo_list.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepo;

    public List<Todo> todoList() {
        return todoRepo.findAll();
    }

    public Todo saveTodo(Todo todo) {
        todo.setCreatedAt(LocalDateTime.now());
        todo.setUpdatedAt(LocalDateTime.now());

        return todoRepo.save(todo);
    }
}
