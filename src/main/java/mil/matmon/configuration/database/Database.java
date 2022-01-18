package mil.matmon.configuration.database;

public abstract class Database {
    protected String MdaCode;
    protected String IdNum;
    protected String IdType;
    protected String FirstName;
    protected String LastName;
    protected String City;
    protected String Street;
    protected String BuildingNumber;
    protected String Barcode;
    protected String GetDate;
    protected String TakeDate;
    protected String ResultDate;


    public Database(String mdaCode, String idNum, String idType, String firstName, String lastName, String city,
                              String street, String buildingNumber, String barcode, String getDate, String takeDate, String resultDate) {
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
        this.ResultDate = resultDate;
    }
    public String getMdaCode() {
        return MdaCode;
    }

    public String getIdNum() {
        return IdNum;
    }

    public String getIdType() {
        return IdType;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getCity() {
        return City;
    }

    public String getStreet() {
        return Street;
    }

    public String getBuildingNumber() {
        return BuildingNumber;
    }

    public String getBarcode() {
        return Barcode;
    }

    public String getTakeDate() {
        return TakeDate;
    }

    public String getResultDate() {
        return ResultDate;
    }

    public String getGetDate() {
        return GetDate;
    }
}
