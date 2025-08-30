package com.finboostplus.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "user_expense_divisions")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserExpenseDivision {

    @EmbeddedId
    private UserExpenseDivisionId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("expenseId")
    @JoinColumn(name = "expense_id")
    private Expense expense;

    @Column(name = "partial_value")
    private BigDecimal parcialValue;

    @Column(name = "is_paid")
    private boolean isPaid;

}
