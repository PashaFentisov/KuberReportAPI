package core.kuberreportapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaReportGeneratorService implements ReportGeneratorService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Override
    public String generateReport(UserInfoDto userInfoDto) {
        String userInfoJson;
        try {
            userInfoJson = objectMapper.writeValueAsString(userInfoDto);
        } catch (JsonProcessingException e) {
            log.error("Error while converting UserInfoDto to JSON", e);
            return "Error while generating report";
        }
        kafkaTemplate.send("report", userInfoJson);
        return "Report is generating and will be sent to your email";
    }
}
