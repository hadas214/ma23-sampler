package mil.matmon.configuration.database;

public class TheConstantSampler extends Database {

    public TheConstantSampler(String mdaCode, String idNum, String idType, String firstName, String lastName, String city,
                              String street, String buildingNumber, String barcode, String getDate, String takeDate, String resultDate) {
        super(mdaCode,idNum, idType, firstName,lastName, city,
                street, buildingNumber, barcode, getDate, takeDate, resultDate);
    }

    public String getMdaCode() {
        return MdaCode;
    }

    public void setMdaCode(String mdaCode) {
        MdaCode = mdaCode;
    }

    public String getIdNum() {
        return IdNum;
    }

    public void setIdNum(String idNum) {
        IdNum = idNum;
    }

    public String getIdType() {
        return IdType;
    }

    public void setIdType(String idType) {
        IdType = idType;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getBuildingNumber() {
        return BuildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        BuildingNumber = buildingNumber;
    }

    public String getBarcode() {
        return Barcode;
    }

    public void setBarcode(String barcode) {
        Barcode = barcode;
    }

    public String getTakeDate() {
        return TakeDate;
    }

    public void setTakeDate(String takeDate) {
        TakeDate = takeDate;
    }

    public String getResultDate() {
        return super.getResultDate();
    }

    public void setResultDate(String resultDate) {
        ResultDate = resultDate;
    }

    public String getGetDate() {
        return GetDate;
    }

    public void setGetDate(String getDate) {
        GetDate = getDate;
    }
}
