package models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer carOwnerId;
    String name;
    String address;
    LocalDate dateOfBirth;
    String email;
    String phoneNum;
    @OneToMany(mappedBy = "owner",fetch = FetchType.EAGER)
    List<Car> ownedCars = new ArrayList<>();

    @Override
    public String toString() {
        return carOwnerId + " " + name + " " + (dateOfBirth == null ? " " : dateOfBirth.toString());
    }
}
