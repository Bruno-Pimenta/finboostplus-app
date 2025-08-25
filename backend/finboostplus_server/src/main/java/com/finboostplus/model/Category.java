package com.finboostplus.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import java.util.Set;

@Data
@Entity
@Table(name = "categories")
@SequenceGenerator(name = "seq_category", sequenceName = "seq_category", allocationSize = 1, initialValue = 1)
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_category")
    private Long id;
    @Column(unique = true)
    private String name;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Expense> expenses;

}
