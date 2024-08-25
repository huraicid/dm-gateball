package dmgateball.repository.deck;

import dmgateball.record.Deck;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeckRepository {

    @Select("SELECT id, name FROM decks")
    List<Deck> select();
}
