package dataaccess.DTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_pitch")
public class Pitch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdPitch;

    private String name;

    @ManyToOne
    @JoinColumn(name = "idLevel", nullable = false)
    private Level degree;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "T_pitch_track_association",
            joinColumns = @JoinColumn(name = "idPitch"),
            inverseJoinColumns = @JoinColumn(name = "idTrack"))
    private List<Track> tracks = new ArrayList<>();

    public Pitch() {
    }

    public Pitch(String name, Level degree) {
        this.name = name;
        this.degree = degree;
    }

    public int getIdPitch() {
        return IdPitch;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Level getDegree() {
        return degree;
    }

    public void setDegree(Level degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Pitch{" +
                "IdPitch=" + IdPitch +
                ", name='" + name + '\'' +
                ", degree=" + degree +
                '}';
    }
}
