package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "calculator")
public class Calculator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "base_cost")
    private int baseCost;
    @Column(name = "KT")
    private double KT;
    @Column(name = "KBM")
    private double KBM;
    @Column(name = "KVS")
    private double KVS;
    @Column(name = "KO")
    private double KO;
    @Column(name = "KM")
    private double KM;
    @Column(name = "KS")
    private double KS;
    @Column(name = "KN")
    private double KN;
    @Column(name = "KP")
    private double KP;
    @Column(name = "final_cost")
    private double finalCost;

    @OneToMany(mappedBy = "calculator")
    Set<Osago> osago = new HashSet<>();

    @Override
    public String toString() {
        return String.valueOf(finalCost);
    }
}
