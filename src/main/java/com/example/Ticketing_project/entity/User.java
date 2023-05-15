package com.example.Ticketing_project.entity;
import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;
    private String password;

    @OneToMany(mappedBy = "user")
    private List<UserTicketAssignment> userTickets;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserTickets(List<UserTicketAssignment> userTickets) {
        this.userTickets = userTickets;
    }

    public List<UserTicketAssignment> getUserTickets() {
        return userTickets;
    }

    public User() {
    }
    public User(Long id, String firstName, String lastName, String email, String password, List<UserTicketAssignment> userTickets) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.userTickets = userTickets;
    }


}
