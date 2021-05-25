package JavaClasses;

public class Person {

    protected String username;
    protected String password;
    protected String email;
    protected char type;

    public Person() {
    }

    //setters
    
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setType(char type) {
        this.type = type;
    }
    
    
    //getters
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public char getType() {
        return type;
    }

   

}
