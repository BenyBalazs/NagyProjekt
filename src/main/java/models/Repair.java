package models;

import lombok.*;
import org.hibernate.annotations.Check;

import javax.persistence.*;
import javax.swing.*;
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
public class Repair {

    public static enum RepairState{
        UNDER_REPAIR("Szerelés alatt."),
        FINISHED("Elkészült"),
        PAID("Fizetve");

        private final String value;

        RepairState(final String value){
            this.value = value;
        }

        @Override
        public String toString() {
            return "value";
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REPAIR_ID")
    @Setter(AccessLevel.PRIVATE)
    Integer repairId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAR_FK")
    Car carOnRepair;
    @Column(name = "START_OF_REPAIR")
    LocalDate startOfRepair;
    @Column(name = "END_OF_REPAIR")
    LocalDate endOfRepair;
    @Column(name = "PRICE")
    Integer price;
    @Column(name = "SHORT_DESCRIPTION")
    String shortDescription;
    @Column(name = "REPAIR_STATE")
    RepairState repairState;
    @Column(name = "DESCRIPTION")
    String description;
    @ManyToMany(mappedBy = "repairs")
    private List<Mechanic> mechanics = new ArrayList<Mechanic>();

    @Override
    public String toString() {
        return "Repair{" +
                "repairId=" + repairId +
                ", carOnRepair=" + carOnRepair.toString() +
                ", startOfRepair=" + startOfRepair +
                ", endOfRepair=" + endOfRepair +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", mechanics=" + mechanics +
                '}';
    }
}
