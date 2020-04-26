public class UserFileDTO implements UserDTO{

    protected String name;

    protected String address;

    protected String age;

    public UserFileDTO(String name, String address, String age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getAge() {
        return age;
    }
}
