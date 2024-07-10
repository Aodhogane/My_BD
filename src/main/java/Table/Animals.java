package Table;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Животные")
public class Animals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Animals;

    @Column(name = "Вид животного")
    private String type_ani;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Zoo", referencedColumnName = "id_Zoo")
    private Zoo zoo;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_clas", referencedColumnName = "id_clas")
    private Clas clas;

    @ManyToMany(mappedBy = "animals")
    private Set<Workers> workers;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cell", referencedColumnName = "id_cell")
    private Cell cell;

    public Animals(String type_ani, Clas clas){
        this.type_ani = type_ani;
        this.clas = clas;
    }

    public int getId_Animals() {
        return id_Animals;
    }

    public void setId_Animals(int id_Animals) {
        this.id_Animals = id_Animals;
    }

    public String getType_ani() {
        return type_ani;
    }

    public void setType_ani(String type_ani) {
        this.type_ani = type_ani;
    }


    public Set<Workers> workers() {
        return workers;
    }
    public void setWorkers(Set<Workers> workers) {
        this.workers = workers;
    }
}
