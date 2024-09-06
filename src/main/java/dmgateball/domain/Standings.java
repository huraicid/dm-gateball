package dmgateball.domain;

import dmgateball.record.Deck;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Standings {
    /**
     * 勝敗表の行の要素
     */
    private final List<StandingsRow> standingsRows = new ArrayList<>();

    /**
     * コンストラクタ
     * @param decks デッキのリスト
     */
    public Standings(List<Deck> decks) {
        for(var deck : decks) {
            standingsRows.add(new StandingsRow(deck.id(), decks));
        }

    }

    /**
     * Playerの行の、Opponentと対戦結果を表す勝敗表のセルを取得する
     * @param playerId PlayerのデッキID
     * @param opponentId OpponentのデッキID
     * @return 勝敗表のセル
     */
    public StandingsCell getCell(String playerId, String opponentId) {
        return getRow(playerId).getCell(opponentId);
    }

    /**
     * Playerの行を取得する
     * @param id 取得対象の行
     * @return Playerの行
     */
    private StandingsRow getRow(String id) {
        return this.standingsRows.stream()
                .filter(row -> row.getDeckId().equals(id))
                .toList()
                .get(0);
    }

    /**
     * List型に変換する
     * @return List型のStandings要素
     */
    public List<List<StandingsCell>> toList() {
        var rtnList = new ArrayList<List<StandingsCell>>();
        for(var row : standingsRows) {
            rtnList.add(row.toList());
        }

        return rtnList;
    }

}
