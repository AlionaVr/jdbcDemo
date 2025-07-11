package org.jdbc.task.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotBlank(message = "Name cannot be blank")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Surname cannot be blank")
    @Column(name = "surname")
    private String surname;

    @Min(value = 1, message = "Age must be greater than 0")
    @Max(value = 109, message = "Age must be less than 110")
    @Column(name = "age")
    private int age;

    @NotBlank
    @Size(min = 10, max = 10, message = "Phone number must be exactly 10 digits")
    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;
}
