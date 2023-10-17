package Group3.demo.vehicles;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Vehicles")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "veh_make")
  private String vehicleMake;

  @Column(name = "veh_model")
  private String vehicleModel;

  @Column(name = "veh_year")
  private int vehicleYear;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getVehicleMake() {
    return vehicleMake;
  }

  public void setVehicleMake(String vehicleMake) {
    this.vehicleMake = vehicleMake;
  }

  public String getVehicleModel() {
    return vehicleModel;
  }

  public void setVehicleModel(String vehicleModel) {
    this.vehicleModel = vehicleModel;
  }

  public int getVehicleYear() {
    return vehicleYear;
  }

  public void setVehicleYear(int veh_year) {
    this.vehicleYear = veh_year;
  }


  public String toString() {
    return "Vehicle [id=" + id + ", vehicleMake=" + vehicleMake + ", vehicleModel=" + vehicleModel + ", vehicleYear="
        + vehicleYear + "]";
  }
  
}
