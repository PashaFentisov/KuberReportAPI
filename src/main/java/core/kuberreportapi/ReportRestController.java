package core.kuberreportapi;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/report")
@RequiredArgsConstructor
public class ReportRestController {
    private final ReportGeneratorService reportGeneratorService;

    @GetMapping
    public String generateReport(@RequestBody UserInfoDto userInfoDto) {
        return reportGeneratorService.generateReport(userInfoDto);
    }
}
