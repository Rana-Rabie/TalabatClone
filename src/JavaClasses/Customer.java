package JavaClasses;

public class Customer extends Person {

    private String address;
    private String mobileNumber;

    public Customer() {
    }

    //setters
    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobNum(String mobNo) {
        this.mobileNumber = mobNo;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //getters
    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public String getMobNum() {
        return mobileNumber;
    }

    public String getAddress() {
        return address;
    }

}
