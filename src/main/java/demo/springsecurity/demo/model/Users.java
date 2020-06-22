package demo.springsecurity.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "full_name")
    private String fullName;

    @Basic
    @Column(name = "username", nullable = false)
    private String username;

    @Basic
    @Column(name = "password", nullable = false)
    private String password;
}
