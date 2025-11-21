package ie.atu.cicd1_exam_friday;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleBooking {
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
