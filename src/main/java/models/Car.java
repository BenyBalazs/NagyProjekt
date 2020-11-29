package models;

import lombok.*;
import org.checkerframework.checker.units.qual.C;
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
    Integer carId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "OWNER_FK")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    CarOwner owner;
    String licensePlate;
    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    @JoinColumn(name = "MODEL_FK")
    CarModel model;
    LocalDate manufacturedDate;
    @OneToMany(mappedBy = "carOnRepair",fetch = FetchType.EAGER,orphanRemoval = true)
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    List<Repair> repairs = new ArrayList<>();

    @Override
    public String toString() {
        return carId + " " + licensePlate + " " + model.toString() + " " + (manufacturedDate == null ? " " : manufacturedDate.toString());
    }
    public String toStringWithOwner(){
        return carId + " " + owner.getName() + " " + licensePlate + " " + model.toString() + " " + (manufacturedDate == null ? " " : manufacturedDate.toString() );
    }
}
