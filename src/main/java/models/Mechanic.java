package models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Mechanic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PRIVATE)
    @Column(name = "MECHANIC_ID")
    Integer mechanicId;
    String name;
    String email;
    String phoneNum;
    LocalDate dateOfBirth;
    @ManyToMany
    @JoinTable(name = "REPAIRS",
            joinColumns = @JoinColumn(name = "REPAIR_ID"),
            inverseJoinColumns = @JoinColumn(name = "MECHANIC_ID"))
    private List<Repair> repairs = new ArrayList<Repair>();

    @Override
    public String toString() {
        return "Mechanic{" +
                "mechanicId=" + mechanicId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", repairs="  +
                '}';
    }
}
