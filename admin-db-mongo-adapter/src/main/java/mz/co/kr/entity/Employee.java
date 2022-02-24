package mz.co.kr.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    private String mongoId;

    private String firstName;
    private String lastName;
    private String title;
    private Long departmentId;
    private LocalDateTime startingDate;
    private LocalDateTime leavingDate;
}
