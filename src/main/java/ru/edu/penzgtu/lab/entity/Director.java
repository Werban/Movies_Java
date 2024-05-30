package ru.edu.penzgtu.lab.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "directors")
public class Director {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name="date")
    private LocalDate date;

    @ManyToMany(mappedBy = "directors")
    private List<Film> films;
}