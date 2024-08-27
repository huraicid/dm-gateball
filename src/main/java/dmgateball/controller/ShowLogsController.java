package dmgateball.controller;

import dmgateball.service.showLogs.ShowLogsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/showLogs")
public class ShowLogsController {
    private final ShowLogsService showLogsService;

    @GetMapping
    public String getLogs(Model model) {
        var logs = showLogsService.getLogs().getList();
        model.addAttribute("resultList", logs);

        return "showLogs";
    }
}
