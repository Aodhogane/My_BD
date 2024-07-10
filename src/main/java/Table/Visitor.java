package Table;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Посетитель")
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Visitor;

    @Column(name = "ФИО")
    private String FIO;

    @Column(name = "Возраст")
    private String Age;

    @OneToMany(mappedBy = "visitor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Ticket> tickets;

    public Visitor(String FIO, String Age){
        this.FIO = FIO;
        this.Age = Age;
    }

    public int getId_Visitor() {
        return id_Visitor;
    }

    public void setId_Visitor(int id_Visitor) {
        this.id_Visitor = id_Visitor;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        this.Age = age;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }
}