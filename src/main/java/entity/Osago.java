package entity;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "osago")
public class Osago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "osago_series")
    private String osagoSeries;

    @Column(name = "osago_number")
    private String osagoNumber;

    @Column(name = "start_insurance")
    private Date startInsurance;

    @Column(name = "end_insurance")
    private Date endInsurance;

    @Column(name = "date_of_issue")
    private Date dateOfIssue;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "agent_id")
    private Agent agent;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "driver_to_osago",
            joinColumns = {
                    @JoinColumn(name = "osago_id")
            },inverseJoinColumns = {
            @JoinColumn(name = "driver_id")
    })
    Set<Driver> drivers = new HashSet<>();

    public  void addDriver(Driver driver){
        drivers.add(driver);

    }

    public ObservableList<String> getName(){
        Iterator<Driver> iterator = getDrivers().iterator();
        ObservableList<String> name = FXCollections.observableArrayList();
        while (iterator.hasNext()){
            String FLP = iterator.next().getFlp();
            name.add(FLP);
        }
        return name;
    }

    public ObservableList<String> getModel(){
        Iterator<Pts> iterator = getDrivers().iterator().next().getPts().iterator();
        ObservableList<String> model = FXCollections.observableArrayList();
        while(iterator.hasNext()){
            String modelTC = iterator.next().getModelTC().getModel();
            model.add(modelTC);
        }
        return model;
    }

    public ObservableList<String> getVin(){
        Iterator<Pts> iterator = getDrivers().iterator().next().getPts().iterator();
        ObservableList<String> vin = FXCollections.observableArrayList();
        while (iterator.hasNext()){
            String VIN = iterator.next().getVin();
            vin.add(VIN);
        }
        return vin;
    }

    public ObservableList<String> getRegPlate(){
        Iterator<Certificate> iterator = getDrivers().iterator().next().getPts().iterator().next().getCertificateSet().iterator();
        ObservableList<String> regPlateList = FXCollections.observableArrayList();
        while (iterator.hasNext()){
            String RegPlate = iterator.next().getRegPlate();
            regPlateList.add(RegPlate);
        }
        return regPlateList;
    }

    public ObservableList<String> getCertificateSeries(){
        Iterator<Certificate> iterator = getDrivers().iterator().next().getPts().iterator().next().getCertificateSet().iterator();
        ObservableList<String> CertificateSeriesList = FXCollections.observableArrayList();
        while (iterator.hasNext()){
            String CertificateSeries = iterator.next().getCertificateSeries();
            CertificateSeriesList.add(CertificateSeries);
        }
        return CertificateSeriesList;
    }

    public ObservableList<String> getCertificateNumber(){
        Iterator<Certificate> iterator = getDrivers().iterator().next().getPts().iterator().next().getCertificateSet().iterator();
        ObservableList<String> CertificateNumberList = FXCollections.observableArrayList();
        while (iterator.hasNext()){
            String CertificateNumber = iterator.next().getCertificateNumber();
            CertificateNumberList.add(CertificateNumber);
        }
        return CertificateNumberList;
    }

    public ObservableList<String> getLicenseSeries(){
        Iterator<DrvLicense> iterator = getDrivers().iterator().next().getDrvLicense().iterator();
        ObservableList<String> LicenseSeriesList = FXCollections.observableArrayList();
        while (iterator.hasNext()){
            String LicenseSeries = iterator.next().getLicenseSeries();
            LicenseSeriesList.add(LicenseSeries);
        }
        return LicenseSeriesList;
    }

    public ObservableList<String> getLicenseNumber(){
        Iterator<DrvLicense> iterator = getDrivers().iterator().next().getDrvLicense().iterator();
        ObservableList<String> LicenseNumberList = FXCollections.observableArrayList();
        while (iterator.hasNext()){
            String LicenseNumber = iterator.next().getLicenseNumber();
            LicenseNumberList.add(LicenseNumber);
        }
        return LicenseNumberList;
    }
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "calculator_id")
    private Calculator calculator;

    @Override
    public String toString() {
        return "Osago{" +
                "id=" + id +
                ", osagoSeries='" + osagoSeries + '\'' +
                ", osagoNumber=" + osagoNumber +
                ", startInsurance=" + startInsurance +
                ", endInsurance=" + endInsurance +
                ", dateOfIssue=" + dateOfIssue +
                ", agent=" + agent +
                ", calculator=" + calculator +
                '}';
    }
}
