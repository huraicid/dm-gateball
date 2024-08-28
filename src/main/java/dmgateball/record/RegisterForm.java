package dmgateball.record;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

public record RegisterForm(
        @NotBlank
        @PastOrPresent
        LocalDate date,

        @NotBlank
        String homeDeckName,

        @NotBlank
        @PositiveOrZero
        int homeWin,

        @NotBlank
        String awayDeckName,

        @NotBlank
        @PositiveOrZero
        int awayWin
) {
}
