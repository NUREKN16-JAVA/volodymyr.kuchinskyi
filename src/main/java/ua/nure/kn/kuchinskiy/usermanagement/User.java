package ua.nure.kn.kuchinskiy.usermanagement;

import javax.persistence.*;
import java.time.Period;
import java.time.LocalDate;

@Entity
@Table(name="USERS")
public class User {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="birthday")
    private LocalDate dateOfBirth;

    public User() {}

    public User(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getFullName() {
        return getLastName() + " " + getFirstName();
    }

    public Object getAge() {
        LocalDate todayDate = LocalDate.now();
        return Period.between(getDateOfBirth(), todayDate).getYears();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public void clone(User user) {
        firstName = user.firstName;
        lastName = user.lastName;
        dateOfBirth = user.dateOfBirth;
    }
}

