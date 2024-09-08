package dmgateball.repository.standings;

import dmgateball.record.SimpleBattleLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StandingsRepository {
    @Select("""
            SELECT
                dc.name AS deckName,
                br.home_id AS home_id,
                br.away_id AS away_id,
                br.is_win AS is_win
            FROM battle_results br
            JOIN decks dc on br.home_id = dc.id
            ORDER BY date DESC, battle_id DESC
            """)
    List<SimpleBattleLog> getLogs();
}
