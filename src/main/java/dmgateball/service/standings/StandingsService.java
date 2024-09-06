package dmgateball.service.standings;

import dmgateball.domain.Standings;
import dmgateball.record.Deck;
import dmgateball.repository.standings.StandingsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StandingsService {
    private final StandingsRepository standingsRepository;

    public StandingsService(StandingsRepository standingsRepository) {
        this.standingsRepository = standingsRepository;
    }

    public Standings getStandings(List<Deck> decks) {
        // 勝敗表のベースデータ
        Standings standings = new Standings(decks);

        // 対戦結果を取得
        var logs = standingsRepository.getLogs();

        // 勝敗用データを集計
        for(var log : logs) {
            var homeCell = standings.getCell(log.homeId(), log.awayId());
            var awayCell = standings.getCell(log.awayId(), log.homeId());

            if(log.isWin()) {
                // HOMEプレイヤーが勝利した場合
                // HOMEプレイヤーの勝利数を追加
                homeCell.incrementWin();

                // AWAYプレイヤーの敗北数を追加
                awayCell.incrementLoss();
            } else {
                // HOMEプレイヤーが敗北した場合
                // HOMEプレイヤーの敗北数を追加
                homeCell.incrementLoss();

                // AWAYプレイヤーの勝利数を追加
                awayCell.incrementWin();
            }
        }

        return standings;
    }

}
