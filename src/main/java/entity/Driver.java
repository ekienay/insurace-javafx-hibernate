package entity;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
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

    @OneToMany(mappedBy = "driver", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Set<DrvLicense> drvLicense = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "driver_to_osago",
            joinColumns = {
                    @JoinColumn(name = "driver_id")
            },inverseJoinColumns = {
            @JoinColumn(name = "osago_id")
    })
    Set<Osago> osagos = new HashSet<>();

    @OneToMany(mappedBy = "drivers", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Set<Pts> pts;

    public ObservableList<String> getInsurance(){
        Iterator<Osago> iterator = getOsagos().iterator();
        ObservableList<String> model = FXCollections.observableArrayList();
        while(iterator.hasNext()){
            String modelTC = iterator.next().getOsagoNumber();
            model.add(modelTC);
        }
        return model;
    }

    @Override
    public String toString() {
        return  flp;
    }
}
