package nl.rug.cs.pasd.team43.disruptivedelivery.model;

public class AddressInfo {
    private final String name;
    private final String streetAndNumber;
    private final String zipcode;
    private final String city;
    private final String country;


    public AddressInfo(String name,
                       String streetAndNumber,
                       String zipcode,
                       String city,
                       String country) {
        this.name = name;
        this.streetAndNumber = streetAndNumber;
        this.zipcode = zipcode;
        this.city = city;
        this.country = country;
    }


    public String getName() {
        return name;
    }

    public String getStreetAndNumber() {
        return streetAndNumber;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
