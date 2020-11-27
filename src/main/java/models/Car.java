package models;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PRIVATE)
    Integer carId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "OWNER_FK")
    CarOwner owner;
    String licensePlate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MODEL_FK")
    CarModel model;
    LocalDate manufacturedDate;
    @OneToMany(mappedBy = "carOnRepair")
    List<Repair> repairs = new ArrayList<>();

    @Override
    public String toString() {
        return carId + " " + licensePlate + " " + model.toString() + " " + manufacturedDate.toString();
    }
    public String toStringWithOwner(){
        return carId + " " + owner.getName() + " " + licensePlate + " " + model.toString() + " " + manufacturedDate.toString();
    }
}
