package com.builder;

import java.time.LocalDate;

public class Main {
    public static void main(String args[]) {

        Address address = new Address();
        address.setCity("New York");
        address.setHouseNumber("22");
        address.setStreet("11th Avenue");
        address.setZipcode("33100");

        LocalDate birthday = LocalDate.of(1980,3,20);

        User user1 = new User();
        user1.setFirstName("John");
        user1.setLastName("Cage");
        user1.setAddress(address);
        user1.setBirthday(birthday);

        buildUserDTO(new UserFileDTOBuilder(), user1);
    }

    public static UserDTO buildUserDTO(UserDTOBuilder builder, User user) {
        //for given user a create com.builder.UserDTO aUserDto
        //problem: complex com.builder.UserDTO object constructor
        //method chaining
        return builder.withFirstName(user.getFirstName())
                .withLastName(user.getLastName())
                .withAddress(user.getAddress())
                .withBirthday(user.getBirthday())
                .build();
    }
}
