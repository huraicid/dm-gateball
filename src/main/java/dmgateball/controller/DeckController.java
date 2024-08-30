package dmgateball.controller;

import dmgateball.service.deck.DeckService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/deckList")
public class DeckController {
    private final DeckService deckService;

    @GetMapping
    public String index(Model model) {
        // デッキ一覧を取得
        var deckList = deckService.find();
        model.addAttribute("deckList", deckList);

        return "deckList";
    }
}
