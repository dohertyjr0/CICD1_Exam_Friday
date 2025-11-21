package ie.atu.cicd1_exam_friday;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class Vehicle {
    @NotBlank(message = "Name cannot be blank")
    private String driverName;

    @NotBlank(message = "Registration number cannot be blank")
    @Pattern(regexp = "[0-9{2,3}-[A-Z]{1,2}-[0-9]{1,6}")
    private String regNumber;

    @Email
    private String email;

    @Min(1)
    @Max(8)
    private int passengers;
}
