package pisith.xyz.todo_list.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo/v1")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/")
    public ResponseEntity<List<Todo>> getTodoList() {
        return ResponseEntity.ok().body(todoService.todoList());
    }

    @PostMapping("/")
    public ResponseEntity<Todo> saveTodo (@RequestBody Todo todo) {
        return ResponseEntity.ok().body(todoService.saveTodo(todo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(todoService.getTodoById(id));
    }
}
