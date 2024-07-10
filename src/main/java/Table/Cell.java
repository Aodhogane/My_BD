package Table;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Клетки")
public class Cell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cell;

    @Column(name = "Вид клетки")
    private String view_cell;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Zoo", referencedColumnName = "id_Zoo")
    private Zoo zoo;

    @OneToMany(mappedBy = "cell", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Animals> animals;

    public Cell(String view_cell){
        this.view_cell = view_cell;
    }

    public int getId_cell() {
        return id_cell;
    }

    public void setId_cell(int id_cell) {
        this.id_cell = id_cell;
    }

    public String getView_cell() {
        return view_cell;
    }

    public void setView_cell(String view_cell) {
        this.view_cell = view_cell;
    }
}
