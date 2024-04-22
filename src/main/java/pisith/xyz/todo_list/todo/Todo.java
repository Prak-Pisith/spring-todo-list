package pisith.xyz.todo_list.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "todos")
public class Todo {

    @Id
    private Integer id;
    private String description;
    private boolean status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
