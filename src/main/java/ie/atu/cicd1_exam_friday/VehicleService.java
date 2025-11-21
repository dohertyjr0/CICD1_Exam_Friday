package ie.atu.cicd1_exam_friday;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService {
    private final List<VehicleBooking> vehicles = new ArrayList<>();
    public List <VehicleBooking> getVehicles() {
        return new ArrayList<>(vehicles);
    }

    public VehicleBooking getVehicle(String regNumber) {
        return vehicles.stream()
                .filter(v->v.getRegNumber().equals(regNumber))
                .findFirst()
                .orElseThrow(()-> new DuplicateRegNumberException ("Vehicle with reg" + regNumber + " already exists"));
    }

    public VehicleBooking saveBooking(VehicleBooking vehicleBooking) {
        boolean exists = vehicles.stream().anyMatch(v->v.getRegNumber().equals(vehicleBooking));
        if (exists){
            throw new IllegalArgumentException("Vehicle booking already exists");
        }
        vehicles.add(vehicleBooking);
        return vehicleBooking;
    }

    public VehicleBooking updateBooking(VehicleBooking updatedVehicleBooking) {
        VehicleBooking existing = getVehicle(updatedVehicleBooking.getRegNumber());
        existing.setDriverName(updatedVehicleBooking.getDriverName());
        existing.setEmail(updatedVehicleBooking.getEmail());
        existing.setPassengers(updatedVehicleBooking.getPassengers());
        return existing;
    }

    public void deleteBooking(String regNumber) {
        VehicleBooking vehicle = getVehicle(VehicleBooking.getRegNumber());
        vehicles.remove(vehicle);
    }
}
