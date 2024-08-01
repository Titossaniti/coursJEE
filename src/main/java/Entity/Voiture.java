package Entity;

import javax.persistence.*;

@Entity
@Table(name="voiture")
public class Voiture {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto incrémentation
    private Long id;
    private String marque;
    private String model;

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
