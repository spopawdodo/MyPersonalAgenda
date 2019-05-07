package ContactData;

public class ContactInformation {
    String cellphoneNumber;
    String homeNumber;
    String mailAdress;

    public ContactInformation(String cellphoneNumber, String homeNumber, String mailAdress) {
        this.cellphoneNumber = cellphoneNumber;
        this.homeNumber = homeNumber;
        this.mailAdress = mailAdress;
    }

    public String getCellphoneNumber() {
        return cellphoneNumber;
    }

    public void setCellphoneNumber(String cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getMailAdress() {
        return mailAdress;
    }

    public void setMailAdress(String mailAdress) {
        this.mailAdress = mailAdress;
    }

    @Override
    public String toString() {
        return "ContactInformation{" +
                "cellphoneNumber='" + cellphoneNumber + '\'' +
                ", homeNumber='" + homeNumber + '\'' +
                ", mailAdress='" + mailAdress + '\'' +
                '}';
    }

    public void setContactInformation(String cellphoneNumber, String homeNumber, String mailAdress){
        setCellphoneNumber(cellphoneNumber);
        setHomeNumber(homeNumber);
        setMailAdress(mailAdress);
    }
}
