package com.steve.bankdatabase.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private LocalDate dob;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String account_type;
    @Column(nullable = false)
    private String account_number;


    @ManyToMany(cascade ={CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "customer_branch",
            joinColumns =
                    { @JoinColumn(name = "customer_id", referencedColumnName = "id") },
            inverseJoinColumns =
                    { @JoinColumn(name = "branch_id", referencedColumnName = "id") })

    private Set<Branch> branches;


}
