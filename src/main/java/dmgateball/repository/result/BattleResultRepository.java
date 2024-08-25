package dmgateball.repository.result;

import dmgateball.record.BattleResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BattleResultRepository {
    @Select("SELECT battle_id, date, home_id, away_id, is_win FROM battle_results")
    List<BattleResult> selectBattleResults();
}
