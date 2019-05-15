package at.nacs.encoder.logic;

import at.nacs.encoder.communication.EncoderClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
@RequiredArgsConstructor
public class EncoderService {

private final EncoderClient encoderClient;
    @Value("${encoderclient.server.url}")
    private String url;

    public String getEncodedMessage(String message) {
        return Stream.of(message)
                .map(e -> e.split(""))
                .flatMap(Stream::of)
                .filter(e -> !e.equals(" "))
                .map(String::toUpperCase)
                .map(encoderClient::getEncodedLetter)
                .filter(Objects::nonNull)
                .collect(Collectors.joining());
    }
    }
