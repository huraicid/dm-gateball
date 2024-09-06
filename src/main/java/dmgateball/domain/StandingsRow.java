package dmgateball.domain;

import dmgateball.record.Deck;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class StandingsRow {
    /**
     * デッキID
     */
    @Setter
    private String deckId;

    /**
     * デッキ名
     */
    @Setter
    @Getter
    private String deckName;

    /**
     * 勝敗表1つ1つのセルのデータ
     */
    private final List<StandingsCell> standingsCells = new ArrayList<>();

    /**
     * コンストラクタ
     * @param deckId デッキID
     * @param deckList 対戦対手のデッキ
     */
    public StandingsRow(String deckId, List<Deck> deckList) {
        // この行のデッキIDを初期化
        this.deckId = deckId;

        // デッキ名を初期化
        this.deckName = this.updateDeckName(deckList);

        // 対戦対手のデッキ分セルを追加
        for(var deck : deckList) {
            standingsCells.add(new StandingsCell(deck));
        }
    }

    /**
     * 対戦相手との勝敗表のセルを取得する
     * @param opponentId 対戦相手のデッキID
     * @return 勝敗表のセル
     */
    public StandingsCell getCell(String opponentId) {
        return this.standingsCells.stream()
                .filter(cell -> cell.getOpponentDeckId().equals(opponentId))
                .toList()
                .get(0);
    }

    public List<StandingsCell> toList() {
        return standingsCells;
    }


    private String updateDeckName(List<Deck> deckList) {
        return deckList.stream()
                .filter(deck -> deck.id().equals(this.deckId))
                .toList()
                .get(0)
                .name();
    }

}
