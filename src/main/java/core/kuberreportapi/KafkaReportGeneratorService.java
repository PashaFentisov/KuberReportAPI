package core.kuberreportapi;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaReportGeneratorService implements ReportGeneratorService {
    private final KafkaTemplate<String, UserInfoDto> kafkaTemplate;

    @Override
    public String generateReport(UserInfoDto userInfoDto) {
        kafkaTemplate.send("report", userInfoDto);
        return "Report is generating and will be sent to your email";
    }
}
