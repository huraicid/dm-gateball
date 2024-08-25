package dmgateball.controller;

import dmgateball.service.deck.DeckService;
import dmgateball.service.result.BattleResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/")
@RequiredArgsConstructor
public class IndexController {
    private final DeckService deckService;
    private final BattleResultService battleResultService;

    // http://localhost:8080/
    @GetMapping
    public String index(Model model) {
        // デッキ一覧を取得
        var deckList = deckService.find();
        model.addAttribute("deckList", deckList);

        // デッキの勝敗集計を取得
        var deckResults = battleResultService.getAggregatedBattleResults(deckList).getList();
        model.addAttribute("results", deckResults);

        return "index";
    }
}
