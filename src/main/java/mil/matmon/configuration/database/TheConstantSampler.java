package mil.matmon.configuration.database;

public class TheConstantSampler extends Database {
    private String MdaCode;
    private String IdNum;
    private String IdType;
    private String FirstName;
    private String LastName;
    private String City;
    private String Street;
    private String BuildingNumber;
    private String Barcode;
    private String GetDate;
    private String TakeDate;

    public TheConstantSampler(String name, String mdaCode, String idNum, String idType, String firstName, String lastName, String city, String street, String buildingNumber, String barcode, String getDate, String takeDate) {
        super(name);
        this.MdaCode = mdaCode;
        this.IdNum = idNum;
        this.IdType = idType;
        this.FirstName = firstName;
        this.LastName = lastName;
        this.City = city;
        this.Street = street;
        this.BuildingNumber = buildingNumber;
        this.Barcode = barcode;
        this.GetDate = getDate;
        this.TakeDate = takeDate;
    }
}
