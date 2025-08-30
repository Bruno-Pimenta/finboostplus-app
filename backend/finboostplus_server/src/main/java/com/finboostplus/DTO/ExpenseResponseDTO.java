package com.finboostplus.DTO;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

public record ExpenseResponseDTO(
                                 Long id,

                                 String title,

                                 String description,

                                 BigDecimal value,

                                 Instant deadlineDate,

                                 Instant createAt) {


}
