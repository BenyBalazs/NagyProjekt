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
    @Column(name = "MECHANIC_ID")
    Integer mechanicId;
    String name;
    String email;
    String phoneNum;
    LocalDate dateOfBirth;

    @ManyToMany(mappedBy = "mechanics",fetch = FetchType.EAGER,cascade = {CascadeType.REFRESH,CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST})
    private List<Repair> repairs = new ArrayList<Repair>();

    @Override
    public String toString() {
        return name + " " + (dateOfBirth == null ? " " : dateOfBirth.toString()) + " " + phoneNum;
    }
}
