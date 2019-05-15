package at.nacs.encoder.communication;

import at.nacs.encoder.logic.EncoderService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/encode")
@RequiredArgsConstructor
@RefreshScope
public class EncoderEndPoint {

    private final EncoderService encoderService;

    @PostMapping
    public String post(@RequestBody String message) {
        return encoderService.getEncodedMessage(message);
    }

}
