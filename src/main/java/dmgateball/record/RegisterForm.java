package dmgateball.record;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

public record RegisterForm(
        @PastOrPresent
        LocalDate date,

        @NotBlank
        String homeDeckId,

        @PositiveOrZero
        int homeWin,

        @NotBlank
        String awayDeckId,

        @PositiveOrZero
        int awayWin
) {
}
