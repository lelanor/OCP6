package dataaccess.DTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TRACK")
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTrack;

    private String name;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable( name = "TRACK_PITCH",
            joinColumns = @JoinColumn( name = "idTrack" ),
            inverseJoinColumns = @JoinColumn( name = "idPitch" ) )
    private List<Pitch> pitches = new ArrayList<>();

    public Track() {
    }

    public Track(String name, List<Pitch> pitches) {
        this.name = name;
        this.pitches = pitches;
    }

    public int getIdTrack() {
        return idTrack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pitch> getPitches() {
        return pitches;
    }

    public void setPitches(List<Pitch> pitches) {
        this.pitches = pitches;
    }

    @Override
    public String toString() {
        return "Track{" +
                "Id=" + idTrack +
                ", name='" + name + '\'' +
                ", roles=" + pitches +
                '}';
    }
}
