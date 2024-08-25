package dmgateball.service.deck;

import dmgateball.record.Deck;
import dmgateball.repository.deck.DeckRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeckService {
    private final DeckRepository deckRepository;

    public List<Deck> find() {
        return deckRepository.select();
    }
}
