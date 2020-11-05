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
    @Setter(AccessLevel.PRIVATE)
    Integer carModelId;
    String name;
    String address;
    LocalDate dateOfBirth;
    String email;
    String phoneNum;
    @OneToMany(mappedBy = "owner")
    List<Car> ownedCars = new ArrayList<>();

    @Override
    public String toString() {
        return "CarOwner{" +
                "carModelId=" + carModelId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", email='" + email + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }
}
