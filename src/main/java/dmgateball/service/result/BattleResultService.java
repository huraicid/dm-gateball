package dmgateball.service.result;

import dmgateball.domain.DeckResults;
import dmgateball.record.BattleResult;
import dmgateball.record.Deck;
import dmgateball.repository.result.BattleResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BattleResultService {
    private final BattleResultRepository battleResultRepository;

    public DeckResults getAggregatedBattleResults(List<Deck> deckList) {
        // 集計データ用のクラスに変換する
        DeckResults deckResults = new DeckResults(deckList);

        // 対戦結果を取得する
        List<BattleResult> battleResults = battleResultRepository.selectBattleResults();

        // デッキごとの集計データに変換する
        for(var item : battleResults) {
            var homeId = item.homeId();
            var awayId = item.awayId();

            if(item.isWin()) {
                // HOME側が勝利した場合
                // HOMEに勝ち点、AWAYに負け点
                deckResults.getByDeckId(homeId).incrementWin();
                deckResults.getByDeckId(awayId).incrementLoss();
            } else {
                // AWAY側が勝利した場合
                // HOMEに負け点、AWAYに勝ち点
                deckResults.getByDeckId(homeId).incrementLoss();
                deckResults.getByDeckId(awayId).incrementWin();
            }
        }

        // 集計データを勝率でソートする
        deckResults.sortByWinrate();

        return deckResults;
    }
}
