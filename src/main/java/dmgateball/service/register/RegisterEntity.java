package dmgateball.service.register;

import dmgateball.record.RegisterForm;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class RegisterEntity {
    LocalDate date;

    String homeDeckId;

    String awayDeckId;

    int isWin;

    RegisterEntity(RegisterForm form) {
        this.date = form.date();
        this.homeDeckId = form.homeDeckId();
        this.awayDeckId = form.awayDeckId();
        this.isWin = (form.homeWin() > form.awayWin()) ? 1 : 0;
    }
}
