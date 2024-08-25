package dmgateball.domain;

import dmgateball.record.Deck;
import lombok.Getter;

@Getter
public class DeckResult {
    private static final double WINRATE_ERROR_VALUE = -1.0;

    /**
     * デッキID
     */
    private String deckId;

    /**
     * デッキ名
     */
    private String name;

    /**
     * 勝ち数
     */
    private int winCount = 0;

    /**
     * 負け数
     */
    private int lossCount = 0;

    /**
     * 勝率（表示用）
     */
    private String winrate = "-";

    /**
     * コンストラクタ（デッキクラスから）
     * @param deck デッキ
     */
    public DeckResult(Deck deck) {
        this.deckId = deck.id();
        this.name = deck.name();
    }

    /**
     * 勝ち数を加算する
     */
    public void incrementWin() {
        this.winCount++;
        updateWinrate();
    }

    /**
     * 負け数を加算する
     */
    public void incrementLoss() {
        this.lossCount++;
        updateWinrate();
    }

    /**
     * 勝率を取得する。計算不能の場合は既定のNULL値を返す
     * @return 勝率（小数点表示）
     */
    public double getWinrate() {
        if(this.winCount <= 0 && this.lossCount <= 0) return WINRATE_ERROR_VALUE;
        if(this.winCount + this.lossCount <= 0) return WINRATE_ERROR_VALUE;

        return  ((double) this.winCount / (this.winCount + this.lossCount));
    }

    /**
     * 勝率（表記用）を更新する。
     * 勝率は小数第2位までの％表記とする
     */
    private void updateWinrate() {
        double updateWinrate = getWinrate();
        if(updateWinrate == WINRATE_ERROR_VALUE) return;

        this.winrate = String.format("%.2f", getWinrate() * 100);
    }
}
