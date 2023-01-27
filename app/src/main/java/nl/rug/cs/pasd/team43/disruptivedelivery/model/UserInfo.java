package nl.rug.cs.pasd.team43.disruptivedelivery.model;

public class UserInfo {
    private AddressInfo addressInfo;
    private String email;
    private String phoneNumber;


    public UserInfo(AddressInfo addressInfo, String email, String phoneNumber) {
        this.addressInfo = addressInfo;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }


    public UserInfo(String firstName,
                    String lastName,
                    String streetAndNumber,
                    String zipcode,
                    String city,
                    String country,
                    String email,
                    String phoneNumber) {
        this.addressInfo = new AddressInfo(firstName + " " + lastName, streetAndNumber, zipcode, city, country);
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

}
