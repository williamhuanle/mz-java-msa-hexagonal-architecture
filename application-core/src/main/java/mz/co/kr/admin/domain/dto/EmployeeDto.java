package mz.co.kr.admin.domain.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private String mongoId;
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String title;
    private Long departmentId;
    private LocalDateTime startingDate;
    private LocalDateTime leavingDate;
}
