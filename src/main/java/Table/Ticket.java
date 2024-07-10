package Table;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Билеты")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Ticket;

    @Column(name = "Дата")
    private Date data;

    @Column (name = "Стоимость")
    private int Cost;

    @Column (name = "Количество")
    private int Col;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Zoo", referencedColumnName = "id_Zoo")
    private Zoo zoo;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Visitor", referencedColumnName = "id_Visitor")
    private Visitor visitor;

    public Ticket(Date data, int Cost){
        this.data = data;
        this.Cost = Cost;
        this.Col = Col;
        this.zoo = zoo;
    }

    public int getId_Ticket() {
        return id_Ticket;
    }

    public void setId_Ticket(int id_Ticket) {
        this.id_Ticket = id_Ticket;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getCost() {
        return Cost;
    }

    public void setCost(int cost) {
        Cost = cost;
    }

    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

    public int getCol() {
        return Col;
    }

    public void setCol(int col) {
        Col = col;
    }
}
