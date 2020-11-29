package models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer carModelId;
    String brand;
    String type;
    @OneToMany(mappedBy = "model",fetch = FetchType.EAGER)
    List<Car> cars = new ArrayList<>();

    @Override
    public String toString() {
        return brand + " " + type;
    }
}
