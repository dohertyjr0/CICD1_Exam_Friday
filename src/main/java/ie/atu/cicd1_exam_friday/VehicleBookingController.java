package ie.atu.cicd1_exam_friday;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class VehicleBookingController {
    private final VehicleService vehicleService;
    public VehicleBookingController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }
    @GetMapping("/{regNumber}")
    public ResponseEntity<List<VehicleBooking>>getVehicles(@PathVariable String regNumber){
        return ResponseEntity.ok(VehicleService.getVehicle(regNumber));
    }
    @PostMapping
    public ResponseEntity<VehicleBooking> saveVehicle(@Valid @RequestBody VehicleBooking vehicleBooking){
        VehicleBooking saved = VehicleService.saveVehicleBooking(VehicleBooking);
    }
    @PutMapping("/{regNumber")
    public ResponseEntity<VehicleBooking> updateBooking(@PathVariable String regNumber, @Valid @RequestBody VehicleBooking vehicleBooking){
        return ResponseEntity.ok(VehicleService.updateVehicleBooking(regNumber, vehicle));
    }
    @DeleteMapping("/{regNumber}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable String regNumber){
        VehicleService.deleteBooking(regNumber);
        return ResponseEntity.noContent().build();
    }
}
