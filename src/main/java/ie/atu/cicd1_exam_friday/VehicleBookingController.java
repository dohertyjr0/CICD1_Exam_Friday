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
    public ResponseEntity<List<VehicleBooking>>getVehicle(@PathVariable String regNumber){
        return ResponseEntity.ok(vehicleService.getVehicle(regNumber));
    }
    @PostMapping
    public ResponseEntity<VehicleBooking> saveVehicleBooking(@Valid @RequestBody VehicleBooking vehicleBooking){
        VehicleBooking saved = vehicleService.saveBooking(vehicleBooking);
        return ResponseEntity.ok(saved);
    }
    @PutMapping("/{regNumber")
    public ResponseEntity<VehicleBooking> updateBooking(@Valid @RequestBody VehicleBooking updatedVehicleBooking){
        return ResponseEntity.ok(vehicleService.updateBooking(updatedVehicleBooking));
    }
    @DeleteMapping("/{regNumber}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable String regNumber){
        vehicleService.deleteBooking(regNumber);
        return ResponseEntity.noContent().build();
    }
}
