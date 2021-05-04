package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "driver")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "FLP")
    private String flp;

    @Column(name = "gender")
    private String gender;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "passport_series")
    private String passportSeries;

    @Column(name = "passport_number")
    private String passportNumber;

    @OneToMany(mappedBy = "driver", fetch = FetchType.EAGER)
    Set<DrvLicense> drvLicense = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "driver_to_osago",
            joinColumns = {
                    @JoinColumn(name = "driver_id")
            },inverseJoinColumns = {
            @JoinColumn(name = "osago_id")
    })
    Set<Osago> osagos = new HashSet<>();

    @OneToMany(mappedBy = "drivers", fetch = FetchType.EAGER)
    Set<Pts> pts;

    @Override
    public String toString() {
        return  flp;
    }
}
