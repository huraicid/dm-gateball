package dmgateball.domain;

import dmgateball.record.Deck;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * デッキごとの集計データテーブル用クラス
 */
public class DeckResults {
    /**
     * デッキごとの集計データまとめ
     */
    private final List<DeckResult> deckResults = new ArrayList<>();

    /**
     * コンストラクタ（デッキのListから）
     * @param decks デッキデータのList
     */
    public DeckResults(List<Deck> decks) {
        for(var item : decks) {
            var deckResult = new DeckResult(item);
            this.deckResults.add(deckResult);
        }
    }

    /**
     * デッキIDからそのデッキを検索する
     * @param deckId デッキID
     * @return デッキ
     */
    public DeckResult getByDeckId(String deckId) {
        return this.deckResults
                .stream()
                .filter(v -> v.getDeckId().equals(deckId))
                .findFirst()
                .orElse(null);
    }

    public List<DeckResult> getList() {
        return this.deckResults;
    }

    /**
     * 集計データを勝率でソートする
     */
    public void sortByWinrate() {
        this.deckResults.sort(Comparator.comparing(DeckResult::getWinrate));
    }
}
