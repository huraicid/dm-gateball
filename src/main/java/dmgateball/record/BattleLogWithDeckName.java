package dmgateball.record;

public record BattleLogWithDeckName(
        java.sql.Date date,
        String homeDeckName,
        String awayDeckName,
        boolean isWin
) {
}
