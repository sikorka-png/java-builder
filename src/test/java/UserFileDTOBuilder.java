import java.time.LocalDate;
import java.time.Period;

public class UserFileDTOBuilder implements UserDTOBuilder {

    private String firstName;

    private String lastName;

    private String age;

    private String address;

    public UserFileDTOBuilder withFirstName(String fname) {
        this.firstName = fname;
        return this;
    }

    public UserFileDTOBuilder withLastName(String lname) {
        this.lastName = lname;
        return this;
    }

    public UserFileDTOBuilder withBirthday(LocalDate date) {
        Period age = Period.between(date, LocalDate.now());
        this.age = Integer.toString(age.getYears());
        return this;
    }

    public UserFileDTOBuilder withAddress(String address) {
        this.address = address;
        return this;
    }

    public UserFileDTOBuilder withAddress(Address address) {
        StringBuilder sb = new StringBuilder();
        sb.append(address.getStreet()).append(" " + address.getHouseNumber())
                .append("\n" + address.getZipcode()).append(" " + address.getCity());
        this.address = sb.toString();
        return this;
    }

    public UserDTO build() {
        return new UserWebDTO(firstName + " " + lastName, address, age);
    }
}