package dmgateball.repository.showLogs;

import dmgateball.record.BattleLogWithDeckName;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ShowLogRepository {

    @Select("""
            SELECT
                br.date AS date,
                dc_home.name AS home_deck_name,
                dc_away.name AS away_deck_name,
                br.is_win AS is_win
            FROM battle_results br
            JOIN decks dc_home on br.home_id = dc_home.id
            JOIN decks dc_away on br.away_id = dc_away.id
            ORDER BY br.date DESC, br.battle_id DESC
            """)
    List<BattleLogWithDeckName> getLogs();
}
