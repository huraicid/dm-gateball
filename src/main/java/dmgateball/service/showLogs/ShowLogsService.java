package dmgateball.service.showLogs;

import dmgateball.domain.BattleLog;
import dmgateball.domain.BattleLogs;
import dmgateball.domain.BattleResult;
import dmgateball.record.BattleLogWithDeckName;
import dmgateball.repository.showLogs.ShowLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowLogsService {
    private final ShowLogRepository showLogRepository;

    /**
     * 画面表示用の全勝敗結果を取得する
     * @return 画面表示用の全勝敗結果
     */
    public BattleLogs getLogs() {
        // DBから対戦結果を取得する
        List<BattleLogWithDeckName> battleLogWithDeckNames = showLogRepository.getLogs();

        // 画面表示用のデータに変換する
        List<BattleLog> battleLogs = new ArrayList<>();
        for(var row : battleLogWithDeckNames) {
            var listItem = new BattleLog();
            // 勝敗に影響しない部分
            listItem.setDate(row.date().toLocalDate());
            listItem.setHomeName(row.homeDeckName());
            listItem.setAwayName(row.awayDeckName());
            listItem.setHomeWin(row.isWin());

            // 勝敗に影響する部分
            if(row.isWin()) {
                listItem.setHomeResult(BattleResult.WIN);
                listItem.setAwayResult(BattleResult.LOSE);
            } else {
                listItem.setHomeResult(BattleResult.LOSE);
                listItem.setAwayResult(BattleResult.WIN);
            }
            battleLogs.add(listItem);
        }

        return new BattleLogs(battleLogs);
    }
}
