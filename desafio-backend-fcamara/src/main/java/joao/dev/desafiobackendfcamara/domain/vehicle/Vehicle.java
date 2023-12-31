package joao.dev.desafiobackendfcamara.domain.vehicle;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import joao.dev.desafiobackendfcamara.domain.dtos.VehicleDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "vehicles")
@Table(name = "vehicles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String model;
    @NotBlank
    private String color;
    @Column(unique = true)
    @NotBlank
    private String plate;
    @NotBlank
    @Enumerated(EnumType.STRING)
    private VehicleType type;

    public Vehicle(VehicleDTO data) {
        this.model = data.model();
        this.color = data.color();
        this.plate = data.plate();
        this.type = data.type();
    }
}
