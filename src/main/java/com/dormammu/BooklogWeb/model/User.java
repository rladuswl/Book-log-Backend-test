package com.dormammu.BooklogWeb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "portfolios")
@Table(name = "user")
public class User {

    @Id  // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "userInfo", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Portfolio> portfolios;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String nickname;

    //@Column(nullable = false)
    private String email;

    private String imgHome;
    private String imgPath;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthday;

    @Column(nullable = true)
    private String job;

    //@Column(nullable = false)
    private String area;

    //@Column(nullable = false)
    private boolean active;

    private String roles;  // ROLE_USER, ROLE_ADMIN

    @CreationTimestamp
    private Timestamp createDate;
}