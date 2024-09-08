package dmgateball.record;

public record SimpleBattleLog(
        String deckName,
        String homeId,
        String awayId,
        boolean isWin
) {
}
