package dataaccess.DTO;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "SPOT")
public class Spot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSpot;
    private String name;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "SPOT_SECTOR",
            joinColumns = @JoinColumn(name = "idspot"),
            inverseJoinColumns = @JoinColumn(name = "idsector"))
    private List<Sector> sectors = new ArrayList<>();
}
