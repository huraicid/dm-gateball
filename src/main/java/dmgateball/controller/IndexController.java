package dmgateball.controller;

import dmgateball.service.deck.DeckService;
import dmgateball.service.result.BattleResultService;
import dmgateball.service.standings.StandingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/")
@RequiredArgsConstructor
public class IndexController {
    private final DeckService deckService;
    private final BattleResultService battleResultService;
    private final StandingsService standingsService;

    // http://localhost:8080/
    @GetMapping
    public String index(Model model) {
        // デッキ一覧を取得
        var deckList = deckService.find();
        model.addAttribute("deckList", deckList);

        // デッキの勝敗集計を取得
        var deckResults = battleResultService.getAggregatedBattleResults(deckList).getList();
        model.addAttribute("results", deckResults);

        // デッキの勝敗用データを取得
        var standings = standingsService.getStandings(deckList).toList();
        model.addAttribute("standings", standings);

        return "index";
    }
}
