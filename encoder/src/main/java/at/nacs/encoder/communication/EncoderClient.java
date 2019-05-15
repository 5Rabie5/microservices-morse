package at.nacs.encoder.communication;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;



@FeignClient("morse")
public interface EncoderClient {

    @PostMapping("/morse")
     String getEncodedLetter(String letter);
}
