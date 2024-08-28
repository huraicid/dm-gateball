package dmgateball.controller;

import dmgateball.record.RegisterForm;
import dmgateball.service.register.RegisterService;
import dmgateball.service.deck.DeckService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegisterController {
    private final DeckService deckService;
    private final RegisterService registerService;

    @GetMapping("/form")
    public String index(Model model) {
        // デッキ一覧を取得
        var deckList = deckService.find();
        model.addAttribute("deckList", deckList);

        // 初期化用データ
        if(model.getAttribute("form") == null) {
            var initFormData = new RegisterForm(LocalDate.now(), null, 0, null, 0);
            model.addAttribute("form", initFormData);
        }

        return "register";
    }

    @PostMapping
    public String register(@Validated RegisterForm form, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            // これで入力フォームの値が保持されて画面が戻る
            model.addAttribute("form", form);
            return "register";
        }

        // 勝敗数の合計が1でなければ返す
        if(form.homeWin() + form.awayWin() != 1) {
            model.addAttribute("form", form);
            return index(model);
        }

        // 登録処理
        registerService.register(form);

        return "redirect:/showLogs";
    }
}
