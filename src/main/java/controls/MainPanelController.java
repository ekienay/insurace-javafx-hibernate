package controls;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import dao.DAO;
import entity.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import org.dom4j.DocumentException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import service.*;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;



public class MainPanelController {

    private Stage stage;
    private Pts ptsItem;
    private Agent agentItem;
    private Calculator calcItem;
    private Category categoryItem;
    private Driver driverItem;
    private TypeTC typeTCitem;
    private TypeEngine engineItem;
    private EcoClass ecoClassItem;
    private ModelTC modelTCItem;
    private Osago osagoItem;

    private final SessionFactory factory = new Configuration().configure().buildSessionFactory();


    ObservableList<Agent> agentObservableList = FXCollections.observableArrayList();
    ObservableList<Calculator> calculatorObservableList = FXCollections.observableArrayList();
    ObservableList<Category> categoryObservableList = FXCollections.observableArrayList();
    ObservableList<Driver> driverObservableList = FXCollections.observableArrayList();
    ObservableList<TypeTC> typeTCObservableList = FXCollections.observableArrayList();
    ObservableList<TypeEngine> typeEngineObservableList = FXCollections.observableArrayList();
    ObservableList<EcoClass> ecoClassObservableList = FXCollections.observableArrayList();
    ObservableList<ModelTC> modelTCObservableList = FXCollections.observableArrayList();
    ObservableList<Pts> ptsObservableList = FXCollections.observableArrayList();
    ObservableList<Osago> osagoObservableList = FXCollections.observableArrayList();


    @FXML
    private TableView<Osago> OsagoTableView;

    @FXML
    private TableColumn<Osago,Integer> OsagoCount;

    @FXML
    private TableColumn<Osago, String> OsagoSeriesCell;

    @FXML
    private TableColumn<Osago, String> OsagoNumberCell;

    @FXML
    private TableColumn<Osago, Date> OsagoStartInsurance;

    @FXML
    private TableColumn<Osago, Date> OsagoEndInsurance;

    @FXML
    private TableColumn<Osago, String> OsagoInsurer;

    @FXML
    private TableColumn<Osago, String> OsagoOwner;

    @FXML
    private TableColumn<Osago, String> OsagoMarkAndModel;

    @FXML
    private TableColumn<Osago, String> OsagoVIN;

    @FXML
    private TableColumn<Osago, String> OsagoRegPlate;

    @FXML
    private TextField Search;

    @FXML
    private TableColumn<Osago, String> OsagoCertificateSeries;

    @FXML
    private TableColumn<Osago, String> OsagoCertificateNumber;

    @FXML
    private TableColumn<Osago, String> OsagoOtherDrivers;

    @FXML
    private TableColumn<Osago, String> OsagoLicenseSeries;

    @FXML
    private TableColumn<Osago, String> OsagoLicenseNumber;

    @FXML
    private TableColumn<Osago, Double> OsagoFinalCost;

    @FXML
    private TableColumn<Osago, Date> OsagoInsuranceIssueDate;

    @FXML
    private TextField pathStatus;

    @FXML
    private ComboBox<Driver> driver1;

    @FXML
    private ComboBox<Driver> driver2;

    @FXML
    private ComboBox<Driver> driver3;

    @FXML
    private ComboBox<Driver> driver4;

    @FXML
    private ComboBox<Driver> driver5;

    @FXML
    private TextField DriverFLP1;

    @FXML
    private TextField DriverGender1;

    @FXML
    private DatePicker DriverBirthday1;

    @FXML
    private TextField DriverAdress1;

    @FXML
    private TextField DriverPhone1;

    @FXML
    private TextField DriverSeries1;

    @FXML
    private TextField DriverNumber1;

    @FXML
    private DatePicker OsagoStartDate;

    @FXML
    private DatePicker OsagoEndDate;

    @FXML
    private DatePicker OsagoDateIssue;

    @FXML
    private TextField fileName;

    @FXML
    private TextField OsagoSeries;

    @FXML
    private TextField OsagoNumber;

    @FXML
    private ComboBox<Agent> AgentCombo;

    @FXML
    private ComboBox<Calculator> CalcCombo;

    @FXML
    private TextField Series;

    @FXML
    private TextField Number;

    @FXML
    private DatePicker LicenseIssueDate;

    @FXML
    private DatePicker LicenseDateEnd;

    @FXML
    private TextField NameOrg;

    @FXML
    private ComboBox<Driver> DriverCombo;

    @FXML
    private ComboBox<Category> CategoryCombo;

    @FXML
    private ComboBox<Category> CategoryCombo5;

    @FXML
    private ComboBox<Category> CategoryCombo1;

    @FXML
    private ComboBox<Category> CategoryCombo6;

    @FXML
    private ComboBox<Category> CategoryCombo2;

    @FXML
    private ComboBox<Category> CategoryCombo7;

    @FXML
    private ComboBox<Category> CategoryCombo3;

    @FXML
    private ComboBox<Category> CategoryCombo8;

    @FXML
    private ComboBox<Category> CategoryCombo4;

    @FXML
    private ComboBox<Category> CategoryCombo9;

    @FXML
    private ComboBox<Category> CategoryCombo10;

    @FXML
    private ComboBox<Category> CategoryCombo13;

    @FXML
    private ComboBox<Category> CategoryCombo11;

    @FXML
    private ComboBox<Category> CategoryCombo14;

    @FXML
    private ComboBox<Category> CategoryCombo12;

    @FXML
    private ComboBox<Category> CategoryCombo15;

    @FXML
    private TextField BaseCost;

    @FXML
    private TextField FinalCost;

    @FXML
    private TextField KBMconf;

    @FXML
    private TextField KTCof;

    @FXML
    private TextField KBSconf;

    @FXML
    private TextField KOconf;

    @FXML
    private TextField KSconf;

    @FXML
    private TextField KMconf;

    @FXML
    private TextField KNconf;

    @FXML
    private TextField KPconf;

    @FXML
    private TextField Mark;

    @FXML
    private TextField Model;


    @FXML
    private TextField PTSVIN;

    @FXML
    private TextField PTSyear;

    @FXML
    private TextField PTSTrailer;

    @FXML
    private TextField PTSColor;

    @FXML
    private TextField PTSvolume;

    @FXML
    private TextField PTSmaxWeight;

    @FXML
    private TextField PTSmanufacturer;

    @FXML
    private TextField PTScountry;

    @FXML
    private TextField PTSpower;

    @FXML
    private TextField PTSorg;

    @FXML
    private TextField PTSaddress;

    @FXML
    private TextField PTScustomers;

    @FXML
    private TextField PTSTDTPO;

    @FXML
    private TextField PTSweight;

    @FXML
    private TextField PTSSeries;

    @FXML
    private TextField PTSNumber;

    @FXML
    private ComboBox<TypeEngine> EngineCombo;

    @FXML
    private ComboBox<EcoClass> ECOcombo;

    @FXML
    private ComboBox<TypeTC> TCcombo;

    @FXML
    private ComboBox<ModelTC> MarkAndModelCombo;

    @FXML
    private DatePicker PTSIssue;

    @FXML
    private ComboBox<Driver> PTSDriverCombo;

    @FXML
    private ComboBox<Category> CatCombo;

    @FXML
    private TextField CertificateSeries;

    @FXML
    private TextField CertificateRegPlate;

    @FXML
    private TextField CertificateNumber;

    @FXML
    private ComboBox<Pts> CertificatePTScombo;


    @FXML
    void addCertificate(ActionEvent event) {
        DAO<Certificate,Integer> certificateIntegerDAO = new CertificateService(factory);
        Certificate certificate = new Certificate();
        certificate.setCertificateSeries(CertificateSeries.getText());
        certificate.setCertificateNumber(CertificateNumber.getText());
        certificate.setRegPlate(CertificateRegPlate.getText());
        certificate.setPts(CertificatePTScombo.getValue());
        certificateIntegerDAO.create(certificate);
        clearScreen();
    }


    @FXML
    void PTSAdd(ActionEvent event) throws ParseException {
        DAO<Pts,Integer> ptsIntegerDAO = new PtsService(factory);
        Pts pts = new Pts();
        pts.setPtsSeries(PTSSeries.getText());
        pts.setPtsNumber(PTSNumber.getText());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        LocalDate issue = PTSIssue.getValue();
        pts.setDateOfIssue(dateFormat.parse(String.valueOf(issue)));
        pts.setVin(PTSVIN.getText());
        pts.setTrailer(PTSTrailer.getText());
        pts.setColorTrailer(PTSColor.getText());
        pts.setPowerEngineLSKvT(PTSpower.getText());
        pts.setEngineVolume(PTSvolume.getText());
        pts.setManufacturer(PTSmanufacturer.getText());
        pts.setCountryImpTC(PTScountry.getText());
        String year = PTSyear.getText();
        pts.setYearOfManufacture(dateFormat.parse(year));
        pts.setUnladenWeight(PTSweight.getText());
        pts.setMaxWeight(PTSmaxWeight.getText());
        pts.setCustomsRestrictions(PTScustomers.getText());
        pts.setRegNameOrganization(PTSorg.getText());
        pts.setAddress(PTSaddress.getText());
        pts.setSeriesNumberTDTPO(PTSTDTPO.getText());
        pts.setTypeEngine(EngineCombo.getValue());
        pts.setEcoClass(ECOcombo.getValue());
        pts.setTypeTC(TCcombo.getValue());
        pts.setDrivers(PTSDriverCombo.getValue());
        pts.setCategory(CatCombo.getValue());
        pts.setModelTC(MarkAndModelCombo.getValue());
        ptsIntegerDAO.create(pts);
        clearScreen();
    }


    @FXML
    void AddModel(ActionEvent event) {
        DAO<ModelTC, Integer> modelTCIntegerDAO = new ModelTCService(factory);
        DAO<MarkTC,Integer> markTCIntegerDAO = new MarkTCService(factory);

        MarkTC markTC = new MarkTC();
        markTC.setTCMark(Mark.getText());
        markTCIntegerDAO.create(markTC);

        ModelTC modelTC = new ModelTC();
        modelTC.setModel(Model.getText());
        modelTC.setMarkTC(markTC);
        modelTCIntegerDAO.create(modelTC);
        clearScreen();

    }

    @FXML
    void addDrivers(ActionEvent event) throws ParseException {
        DAO<Driver,Integer> driverIntegerDAO = new DriverService(factory);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Driver driver = new Driver();
        driver.setFlp(DriverFLP1.getText());
        driver.setGender((DriverGender1.getText()));
        LocalDate str = DriverBirthday1.getValue();
        driver.setBirthDate(df.parse(String.valueOf(str)));
        driver.setAddress(DriverAdress1.getText());
        driver.setPhone(DriverPhone1.getText());
        driver.setPassportSeries(DriverSeries1.getText());
        driver.setPassportNumber(DriverNumber1.getText());
        driverIntegerDAO.create(driver);
        clearScreen();
    }

    @FXML
    void addOsago(ActionEvent event) throws ParseException {

        DAO<Osago, Integer> osagoIntegerDAO = new OsagoService(factory);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        Osago osago = new Osago();
        LocalDate start = OsagoStartDate.getValue();
        osago.setStartInsurance(df.parse(String.valueOf(start)));
        LocalDate end = OsagoEndDate.getValue();
        osago.setEndInsurance(df.parse(String.valueOf(end)));
        LocalDate issue = OsagoDateIssue.getValue();
        osago.setDateOfIssue(df.parse(String.valueOf(issue)));
        osago.setOsagoSeries(OsagoSeries.getText());
        osago.setOsagoNumber(OsagoNumber.getText());
        osago.setAgent(AgentCombo.getValue());
        osago.setCalculator(CalcCombo.getValue());
        if (driver1 == null){
            System.out.println("empty");
        }else {
            osago.addDriver(driver1.getValue());
        }
        if (driver2 == null){
            System.out.println("empty");
        }else {
            osago.addDriver(driver2.getValue());
        }
        if (driver3 == null){
            System.out.println("empty");
        }else {
            osago.addDriver(driver3.getValue());
        }
        if (driver4 == null){
            System.out.println("empty");
        }else {
            osago.addDriver(driver4.getValue());
        }if (driver5 == null){
            System.out.println("empty");
        }else {
            osago.addDriver(driver5.getValue());
        }

        osagoIntegerDAO.create(osago);
        clearScreen();
    }

    @FXML
    void savePDF(ActionEvent event) throws DocumentException, com.itextpdf.text.DocumentException, IOException {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pathStatus.getText().trim()+"\\"+fileName.getText().trim()+".pdf"));

        document.open();
        if(osagoItem == null){
            System.out.println("selected item is empty");
        }else {
            PlaceObject(writer, String.valueOf(osagoItem.getOsagoSeries()),50,300);
            PlaceObject(writer, String.valueOf(osagoItem.getOsagoNumber()),50,350);
            PlaceObject(writer, String.valueOf(osagoItem.getStartInsurance()),150,250);
            PlaceObject(writer, String.valueOf(osagoItem.getEndInsurance()),300,200);
            PlaceObject(writer,osagoItem.getName().toString().replace("[","").replace("]",""),300,150);
            PlaceObject(writer,osagoItem.getName().toString().replace("[","").replace("]",""),300,100);
            PlaceObject(writer,osagoItem.getModel().toString().replace("[","").replace("]",""),300,100);
            PlaceObject(writer,osagoItem.getVin().toString().replace("[","").replace("]",""),300,50);
            PlaceObject(writer,osagoItem.getRegPlate().toString().replace("[","").replace("]",""),450,100);
            PlaceObject(writer,osagoItem.getCertificateSeries().toString().replace("[","").replace("]",""),400,100);
            PlaceObject(writer,osagoItem.getCertificateNumber().toString().replace("[","").replace("]",""),250,100);
            PlaceObject(writer,osagoItem.getLicenseSeries().toString().replace("[","").replace("]",""),200,100);
            PlaceObject(writer,osagoItem.getLicenseNumber().toString().replace("[","").replace("]",""),150,100);
            PlaceObject(writer,String.valueOf(osagoItem.getCalculator().getFinalCost()),100,600);
            PlaceObject(writer,String.valueOf(osagoItem.getDateOfIssue()),50,100);

        }
        document.close();
    }

    @FXML
    void DirectoryChoice(ActionEvent event) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File dir = directoryChooser.showDialog(stage);
        if (dir == null){
            pathStatus.setText("Directory path is empty");
        }else {
            String path = dir.getAbsolutePath();
            pathStatus.setText(path);
        }
    }
    public void PlaceObject(PdfWriter writer, String object, int x, int y) throws IOException, DocumentException, com.itextpdf.text.DocumentException {
        BaseFont bf = BaseFont.createFont("C:\\Windows\\Fonts/Calibri.ttf",BaseFont.IDENTITY_H,BaseFont.EMBEDDED);
        Font font = new Font(bf);

        PdfContentByte cb = writer.getDirectContent();
        cb.saveState();
        cb.beginText();
        cb.setFontAndSize(bf,11);
        cb.moveText(x,y);
        cb.showText(object);
        cb.endText();
        cb.restoreState();
    }


    @FXML
    void Delete(ActionEvent event) {
            Osago osago = OsagoTableView.getSelectionModel().getSelectedItem();
            DAO<Osago,Integer> osagoIntegerDAO = new OsagoService(factory);
            if (osago == null){
                System.out.println("is empty");
            }
            else {
                OsagoTableView.getItems().remove(osago);
                osagoIntegerDAO.delete(osago);

            }
    }
    @FXML
    void refresh(ActionEvent event) {
            clearScreen();
    }

    @FXML
    void addLicense(ActionEvent event) throws ParseException {
        DAO<DrvLicense, Integer> drvLicenseIntegerDAO = new DrvLicenseService(factory);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DrvLicense drvLicense = new DrvLicense();
        LocalDate issue = LicenseIssueDate.getValue();
        drvLicense.setDateOfIssue(dateFormat.parse(String.valueOf(issue)));
        LocalDate end = LicenseDateEnd.getValue();
        drvLicense.setDateOfExpiration(dateFormat.parse(String.valueOf(end)));
        drvLicense.setLicenseSeries(Series.getText());
        drvLicense.setLicenseNumber(Number.getText());
        drvLicense.setDepartStateInspection(NameOrg.getText());
        drvLicense.setDriver(DriverCombo.getValue());

        if (CategoryCombo.getValue() == null){
            System.out.println("null");
        }else{
            drvLicense.addCategory(CategoryCombo.getValue());
        }
        if (CategoryCombo1.getValue() == null){
            System.out.println("null");
        }else{
            drvLicense.addCategory(CategoryCombo1.getValue());
        }
        if (CategoryCombo2.getValue() == null){
            System.out.println("null");
        }else{
            drvLicense.addCategory(CategoryCombo2.getValue());
        }
        if (CategoryCombo3.getValue() == null){
            System.out.println("null");
        }else{
            drvLicense.addCategory(CategoryCombo3.getValue());
        }
        if (CategoryCombo4.getValue() == null){
            System.out.println("null");
        }else{
            drvLicense.addCategory(CategoryCombo4.getValue());
        }
        if (CategoryCombo5.getValue() == null){
            System.out.println("null");
        }else{
            drvLicense.addCategory(CategoryCombo5.getValue());
        }
        if (CategoryCombo6.getValue() == null){
            System.out.println("null");
        }else{
            drvLicense.addCategory(CategoryCombo6.getValue());
        }
        if (CategoryCombo7.getValue() == null){
            System.out.println("null");
        }else{
            drvLicense.addCategory(CategoryCombo7.getValue());
        }
        if (CategoryCombo8.getValue() == null){
            System.out.println("null");
        }else{
            drvLicense.addCategory(CategoryCombo8.getValue());
        }
        if (CategoryCombo9.getValue() == null){
            System.out.println("null");
        }else{
            drvLicense.addCategory(CategoryCombo9.getValue());
        }
        if (CategoryCombo10.getValue() == null){
            System.out.println("null");
        }else{
            drvLicense.addCategory(CategoryCombo10.getValue());
        }
        if (CategoryCombo11.getValue() == null){
            System.out.println("null");
        }else{
            drvLicense.addCategory(CategoryCombo11.getValue());
        }
        if (CategoryCombo12.getValue() == null){
            System.out.println("null");
        }else{
            drvLicense.addCategory(CategoryCombo12.getValue());
        }
        if (CategoryCombo13.getValue() == null){
            System.out.println("null");
        }else{
            drvLicense.addCategory(CategoryCombo13.getValue());
        }
        if (CategoryCombo14.getValue() == null){
            System.out.println("null");
        }else{
            drvLicense.addCategory(CategoryCombo14.getValue());
        }
        if (CategoryCombo15.getValue() == null){
            System.out.println("null");
        }else{
            drvLicense.addCategory(CategoryCombo15.getValue());
        }

        drvLicenseIntegerDAO.create(drvLicense);
        clearScreen();
    }

    @FXML
    void addCalc(ActionEvent event) {
        DAO<Calculator, Integer> calculatorIntegerDAO = new CalculatorService(factory);

        if (KTCof.getText().isEmpty()){
            KTCof.setText((String.valueOf(1.0)));
        }
        if (KBMconf.getText().isEmpty()){
            KBMconf.setText(String.valueOf(1.0));
        }
        if (KBSconf.getText().isEmpty()){
            KBSconf.setText(String.valueOf(1.0));
        }
        if (KOconf.getText().isEmpty()){
            KOconf.setText(String.valueOf(1.0));
        }
        if (KSconf.getText().isEmpty()){
            KSconf.setText(String.valueOf(1.0));
        }
        if (KMconf.getText().isEmpty()){
            KMconf.setText(String.valueOf(1.0));
        }
        if (KNconf.getText().isEmpty()){
            KNconf.setText(String.valueOf(1.0));
        }
        if (KPconf.getText().isEmpty()){
            KPconf.setText(String.valueOf(1.0));
        }

        FinalCost.setText(String.valueOf(Double.parseDouble(BaseCost.getText())*Double.parseDouble(KTCof.getText())*
                Double.parseDouble(KBMconf.getText())*Double.parseDouble(KBSconf.getText())*
                Double.parseDouble(KOconf.getText())*Double.parseDouble(KSconf.getText())*
                Double.parseDouble(KMconf.getText())*Double.parseDouble(KNconf.getText())*
                Double.parseDouble(KPconf.getText())));
        Calculator calculator = new Calculator();
        calculator.setBaseCost(Integer.parseInt(BaseCost.getText()));
        calculator.setKT(Double.parseDouble(KTCof.getText()));
        calculator.setKBM(Double.parseDouble(KBMconf.getText()));
        calculator.setKVS(Double.parseDouble(KBSconf.getText()));
        calculator.setKO(Double.parseDouble(KOconf.getText()));
        calculator.setKS(Double.parseDouble(KSconf.getText()));
        calculator.setKM(Double.parseDouble(KMconf.getText()));
        calculator.setKN(Double.parseDouble(KNconf.getText()));
        calculator.setKP(Double.parseDouble(KPconf.getText()));
        calculator.setFinalCost(Double.parseDouble(FinalCost.getText()));
        calculatorIntegerDAO.create(calculator);
        clearScreen();
    }

    public void initDatabase(){
        DAO<Agent, Integer> agentIntegerDAO = new AgentService(factory);
        agentObservableList.addAll(agentIntegerDAO.generateContract());
        DAO<Calculator, Integer> calculatorIntegerDAO = new CalculatorService(factory);
        calculatorObservableList.addAll(calculatorIntegerDAO.generateContract());
        DAO<ModelTC,Integer> modelTCIntegerDAO = new ModelTCService(factory);
        modelTCObservableList.addAll(modelTCIntegerDAO.generateContract());
        DAO<TypeTC,Integer> typeTCIntegerDAO = new TypeTCService(factory);
        typeTCObservableList.addAll(typeTCIntegerDAO.generateContract());
        DAO<EcoClass,Integer> ecoClassIntegerDAO = new EcoClassService(factory);
        ecoClassObservableList.addAll(ecoClassIntegerDAO.generateContract());
        DAO<TypeEngine,Integer> typeEngineIntegerDAO = new TypeEngineService(factory);
        typeEngineObservableList.addAll(typeEngineIntegerDAO.generateContract());
        DAO<Driver, Integer> driverIntegerDAO = new DriverService(factory);
        driverObservableList.addAll(driverIntegerDAO.generateContract());
        DAO<Category, Integer> categoryIntegerDAO = new CategoryService(factory);
        categoryObservableList.addAll(categoryIntegerDAO.generateContract());
        DAO<Pts,Integer> ptsIntegerDAO = new PtsService(factory);
        ptsObservableList.addAll(ptsIntegerDAO.generateContract());
        DAO<Osago,Integer> osagoIntegerDAO = new OsagoService(factory);
        osagoObservableList.addAll(osagoIntegerDAO.generateContract());
}

    public void initComboBox(){
    AgentCombo.setItems(agentObservableList);
    AgentCombo.getSelectionModel().selectedItemProperty().addListener((obj, oldValue, newValue) -> {
        agentItem = newValue; });

    CalcCombo.setItems(calculatorObservableList);
    CalcCombo.getSelectionModel().selectedItemProperty().addListener((obj, oldValue, newValue) -> {
        calcItem = newValue; });

    CategoryCombo.setItems(categoryObservableList);
    CategoryCombo.getSelectionModel().selectedItemProperty().addListener((obj, oldValue, newValue) -> {
        categoryItem = newValue; });

    CategoryCombo1.setItems(categoryObservableList);
    CategoryCombo1.getSelectionModel().selectedItemProperty().addListener((obj, oldValue, newValue) -> {
        categoryItem = newValue; });

    CategoryCombo2.setItems(categoryObservableList);
    CategoryCombo2.getSelectionModel().selectedItemProperty().addListener((obj, oldValue, newValue) -> {
        categoryItem = newValue; });

    CategoryCombo3.setItems(categoryObservableList);
    CategoryCombo3.getSelectionModel().selectedItemProperty().addListener((obj, oldValue, newValue) -> {
        categoryItem = newValue; });

    CategoryCombo4.setItems(categoryObservableList);
    CategoryCombo4.getSelectionModel().selectedItemProperty().addListener((obj, oldValue, newValue) -> {
        categoryItem = newValue; });

    CategoryCombo5.setItems(categoryObservableList);
    CategoryCombo5.getSelectionModel().selectedItemProperty().addListener((obj, oldValue, newValue) -> {
        categoryItem = newValue; });

    CategoryCombo6.setItems(categoryObservableList);
    CategoryCombo6.getSelectionModel().selectedItemProperty().addListener((obj, oldValue, newValue) -> {
        categoryItem = newValue; });

    CategoryCombo7.setItems(categoryObservableList);
    CategoryCombo7.getSelectionModel().selectedItemProperty().addListener((obj, oldValue, newValue) -> {
        categoryItem = newValue; });

    CategoryCombo8.setItems(categoryObservableList);
    CategoryCombo8.getSelectionModel().selectedItemProperty().addListener((obj, oldValue, newValue) -> {
        categoryItem = newValue; });

    CategoryCombo9.setItems(categoryObservableList);
    CategoryCombo9.getSelectionModel().selectedItemProperty().addListener((obj, oldValue, newValue) -> {
        categoryItem = newValue; });

    CategoryCombo10.setItems(categoryObservableList);
    CategoryCombo10.getSelectionModel().selectedItemProperty().addListener((obj, oldValue, newValue) -> {
        categoryItem = newValue; });

    CategoryCombo11.setItems(categoryObservableList);
    CategoryCombo11.getSelectionModel().selectedItemProperty().addListener((obj, oldValue, newValue) -> {
        categoryItem = newValue; });

    CategoryCombo12.setItems(categoryObservableList);
    CategoryCombo12.getSelectionModel().selectedItemProperty().addListener((obj, oldValue, newValue) -> {
        categoryItem = newValue; });

    CategoryCombo13.setItems(categoryObservableList);
    CategoryCombo13.getSelectionModel().selectedItemProperty().addListener((obj, oldValue, newValue) -> {
        categoryItem = newValue; });

    CategoryCombo14.setItems(categoryObservableList);
    CategoryCombo14.getSelectionModel().selectedItemProperty().addListener((obj, oldValue, newValue) -> {
        categoryItem = newValue; });

    CategoryCombo15.setItems(categoryObservableList);
    CategoryCombo15.getSelectionModel().selectedItemProperty().addListener((obj, oldValue, newValue) -> {
        categoryItem = newValue; });

    DriverCombo.setItems(driverObservableList);
    DriverCombo.getSelectionModel().selectedItemProperty().addListener((obj, oldValue, newValue) -> {
        driverItem = newValue; });

    CatCombo.setItems(categoryObservableList);
    CatCombo.getSelectionModel().selectedItemProperty().addListener((obj, oldValue, newValue) -> {
        categoryItem = newValue; });

    PTSDriverCombo.setItems(driverObservableList);
    PTSDriverCombo.getSelectionModel().selectedItemProperty().addListener((obj, oldValue, newValue) -> {
        driverItem = newValue; });

    MarkAndModelCombo.setItems(modelTCObservableList);
    MarkAndModelCombo.getSelectionModel().selectedItemProperty().addListener((obj, oldValue, newValue) -> {
        modelTCItem = newValue; });

    TCcombo.setItems(typeTCObservableList);
    TCcombo.getSelectionModel().selectedItemProperty().addListener((obj, oldValue, newValue) -> {
        typeTCitem = newValue; });

    EngineCombo.setItems(typeEngineObservableList);
    EngineCombo.getSelectionModel().selectedItemProperty().addListener((obj, oldValue, newValue) -> {
        engineItem= newValue; });

    ECOcombo.setItems(ecoClassObservableList);
    ECOcombo.getSelectionModel().selectedItemProperty().addListener((obj, oldValue, newValue) -> {
        ecoClassItem= newValue; });

    CertificatePTScombo.setItems(ptsObservableList);
    CertificatePTScombo.getSelectionModel().selectedItemProperty().addListener((obj,oldValue,newValue) ->{
        ptsItem = newValue;
    });

    driver1.setItems(driverObservableList);
    driver1.getSelectionModel().selectedItemProperty().addListener((obj,oldValue,newValue) ->{
        driverItem = newValue;
    });

    driver2.setItems(driverObservableList);
    driver2.getSelectionModel().selectedItemProperty().addListener((obj,oldValue,newValue) ->{
        driverItem = newValue;
    });

    driver3.setItems(driverObservableList);
    driver3.getSelectionModel().selectedItemProperty().addListener((obj,oldValue,newValue) ->{
        driverItem = newValue;
    });

    driver4.setItems(driverObservableList);
    driver4.getSelectionModel().selectedItemProperty().addListener((obj,oldValue,newValue) ->{
        driverItem = newValue;
    });

    driver5.setItems(driverObservableList);
    driver5.getSelectionModel().selectedItemProperty().addListener((obj,oldValue,newValue) ->{
        driverItem = newValue;
    });
}

    public void initTableView(){
        OsagoSeriesCell.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getOsagoSeries()));
        OsagoNumberCell.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getOsagoNumber()));
        OsagoStartInsurance.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getStartInsurance()));
        OsagoEndInsurance.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getEndInsurance()));
        OsagoCount.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getId()));
        OsagoInsurer.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getName().toString().replace("["," ").replace("]","")));
        OsagoOwner.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getName().toString().replace("["," ").replace("]","")));
        OsagoMarkAndModel.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getModel().toString().replace("["," ").replace("]","")));
        OsagoVIN.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getVin().toString().replace("["," ").replace("]","")));
        OsagoRegPlate.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getRegPlate().toString().replace("["," ").replace("]","")));
        OsagoFinalCost.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getCalculator().getFinalCost()));
        OsagoInsuranceIssueDate.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getDateOfIssue()));
        OsagoCertificateSeries.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getCertificateSeries().toString().replace("["," ").replace("]","")));
        OsagoCertificateNumber.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getCertificateNumber().toString().replace("["," ").replace("]","")));
        OsagoLicenseSeries.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getLicenseSeries().toString().replace("["," ").replace("]","")));
        OsagoLicenseNumber.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getLicenseNumber().toString().replace("["," ").replace("]","")));
        OsagoTableView.setItems(osagoObservableList);
        OsagoInsurer.setUserData(driverObservableList);
        OsagoTableView.setEditable(true);
        OsagoTableView.getSelectionModel().selectedItemProperty().addListener((obj,oldValue,newValue) -> osagoItem = newValue);
    }

    public void clearScreen(){
        agentObservableList.clear();
        osagoObservableList.clear();
        driverObservableList.clear();
        calculatorObservableList.clear();
        ptsObservableList.clear();
        categoryObservableList.clear();
        typeEngineObservableList.clear();
        typeTCObservableList.clear();
        modelTCObservableList.clear();
        ecoClassObservableList.clear();
        initialize();
    }


    @FXML
    void initialize() {
        initDatabase();
        initTableView();
        initComboBox();

        // Search
        FilteredList<Osago> filteredList = new FilteredList<>(osagoObservableList, b -> true);
        Search.textProperty().addListener((observable,oldValue,newValue) ->{
            filteredList.setPredicate(osago -> {
                if (newValue == null || newValue.isEmpty()){
                    return true;
                }
                String lowerCase = newValue.toLowerCase();
                if (osago.getDrivers().iterator().next().getFlp().toLowerCase().contains(lowerCase)){
                    return true;
                }else if (osago.getOsagoNumber().toLowerCase().contains(lowerCase)){
                    return true;
                }else if (osago.getOsagoSeries().toLowerCase().contains(lowerCase)){
                    return true;
                }else if (osago.getDrivers().iterator().next().getPts().iterator().next().getModelTC().getModel().toLowerCase().contains(lowerCase)){
                    return true;
                }
                else{
                    return false;
                }
            });
        });
        SortedList<Osago> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(OsagoTableView.comparatorProperty());
        OsagoTableView.setItems(sortedList);
    }
}