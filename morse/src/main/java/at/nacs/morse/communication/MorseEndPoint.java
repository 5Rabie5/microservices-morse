package at.nacs.morse.communication;

import at.nacs.morse.logic.Encoder;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/morse")
@RequiredArgsConstructor
@RefreshScope
public class MorseEndPoint {

    private final Encoder encoder;

    @PostMapping
    String post(@RequestBody String letter) {
        return encoder.encode(letter);
    }
}
