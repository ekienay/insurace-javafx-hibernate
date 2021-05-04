package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "certificate_dimmatriculation")
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "reg_plate")
    private String regPlate;

    @Column(name = "certificate_series")
    private String certificateSeries;

    @Column(name = "certificate_number")
    private String certificateNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PTS_id")
    private Pts pts;
}
