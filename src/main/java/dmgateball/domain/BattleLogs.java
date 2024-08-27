package dmgateball.domain;

import java.util.ArrayList;
import java.util.List;

public class BattleLogs {
    /**
     * 対戦結果のリスト
     */
    private List<BattleLog> battleLogs = new ArrayList<>();

    /**
     * コンストラクタ
     * @param battleLogs 対戦結果のリスト
     */
    public BattleLogs(List<BattleLog> battleLogs) {
        this.battleLogs = battleLogs;
    }

    public List<BattleLog> getList() {
        return this.battleLogs;
    }
}
