package com.builder;

import java.time.LocalDate;
import java.time.Period;

public class UserWebDTOBuilder implements UserDTOBuilder {

    private String firstName;

    private String lastName;

    private String age;

    private String address;

    public UserWebDTOBuilder withFirstName(String fname) {
        this.firstName = fname;
        return this;
    }

    public UserWebDTOBuilder withLastName(String lname) {
        this.lastName = lname;
        return this;
    }

    public UserWebDTOBuilder withBirthday(LocalDate date) {
        Period age = Period.between(date, LocalDate.now());
        this.age = Integer.toString(age.getYears());
        return this;
    }

    public UserWebDTOBuilder withAddress(String address) {
        this.address = address;
        return this;
    }

    public UserWebDTOBuilder withAddress(Address address) {
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