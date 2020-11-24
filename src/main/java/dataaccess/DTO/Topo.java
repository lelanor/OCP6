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
@Table(name = "TOPO")
public class Topo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSpot;
    private String name;

    @ManyToOne
    @JoinColumn(name = "iduser", nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "idlocation", nullable = false)
    private Location location;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "TOPO_SPOT",
            joinColumns = @JoinColumn(name = "idtopo"),
            inverseJoinColumns = @JoinColumn(name = "idspot"))
    private List<Sector> sectors = new ArrayList<>();
}
