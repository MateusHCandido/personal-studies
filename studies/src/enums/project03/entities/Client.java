package enums.project03.entities;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Client {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private String name;
    private String email;
    private Date birthDate;


    public Client(){}

    public Client(String name, String email, Date birthDate){
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }


    @Override
    public String toString() {
        return getName()
                + String.format("(%s)", sdf.format(getBirthDate()))
                + " - "
                + getEmail();
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public Date getBirthDate() {
        return birthDate;
    }


    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}