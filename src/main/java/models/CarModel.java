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
    @Setter(AccessLevel.PRIVATE)
    Integer carModelId;
    String brand;
    String type;
    @OneToMany(mappedBy = "model")
    List<Car> cars = new ArrayList<>();
}
