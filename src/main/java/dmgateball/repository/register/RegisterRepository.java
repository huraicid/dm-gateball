package dmgateball.repository.register;

import dmgateball.service.register.RegisterEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RegisterRepository {
    @Insert("""
                INSERT INTO battle_results (date, home_id, away_id, is_win)
                VALUES (#{form.date}, #{form.homeDeckId}, #{form.awayDeckId}, #{form.isWin})
                """)
    public void register(@Param("form") RegisterEntity entity);
}
