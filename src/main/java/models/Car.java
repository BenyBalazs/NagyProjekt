package models;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDate;

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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OWNER_FK")
    CarOwner owner;
    String licensePlate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MODEL_FK")
    CarModel model;
    LocalDate manufacturedDate;
}
