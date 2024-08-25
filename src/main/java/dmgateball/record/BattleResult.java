package dmgateball.record;

public record BattleResult(
        int battleId,
        java.sql.Date date,
        String homeId,
        String awayId,
        boolean isWin
) {
}
