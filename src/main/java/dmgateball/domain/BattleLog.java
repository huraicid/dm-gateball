package dmgateball.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BattleLog {
    /**
     * 対戦日
     */
    private LocalDate date;

    /**
     * HOME側のデッキ名
     */
    private String homeName;

    /**
     * HOME側の勝敗
     */
    private BattleResult homeResult;

    /**
     * AWAY側のデッキ名
     */
    private String awayName;

    /**
     * AWAY側の勝敗
     */
    private BattleResult awayResult;

    /**
     * HOMEが勝ったかどうか
     */
    private boolean isHomeWin;
}
