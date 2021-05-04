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
@Table(name = "model_TC")
public class ModelTC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "model")
    private String model;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mark_TC_id")
    private MarkTC markTC;

    @OneToMany(mappedBy = "modelTC")
    Set<Pts> pts = new HashSet<>();

    @Override
    public String toString() {
        return  markTC + " " + model;
    }
}
