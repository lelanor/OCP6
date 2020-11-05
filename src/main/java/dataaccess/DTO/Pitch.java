package dataaccess.DTO;

import javax.persistence.*;

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

    public Pitch() {
    }

    public Pitch(String name, Level degree) {
        this.name = name;
        this.degree = degree;
    }

    public int getIdPitch() {
        return IdPitch;
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
