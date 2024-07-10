package Table;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Класс")
public class Clas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_clas;

    @Column(name = "Вид животного")
    private String view_ani;

    @OneToMany(mappedBy = "clas", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Animals> animals;

    public Clas() {
    }

    public Clas(String view_ani) {
        this.view_ani = view_ani;
    }

    public int getId_clas() {
        return id_clas;
    }

    public void setId_clas(int id_clas) {
        this.id_clas = id_clas;
    }

    public String getView_ani() {
        return view_ani;
    }

    public void setView_ani(String view_ani) {
        this.view_ani = view_ani;
    }

    public Set<Animals> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animals> animals) {
        this.animals = animals;
    }
}