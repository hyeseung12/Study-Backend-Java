package io.whatap.order.global.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalClientExceptionHandler {
    private final ObjectMapper objectMapper;   //🔥🔥

    /**
     * FeignClient에서 발생한 예외 그대로 전달🔥🔥
     */
    @ExceptionHandler(FeignException.class)
    public ResponseEntity feignExceptionHandler(FeignException feignException) throws JsonProcessingException {

        String responseJson = feignException.contentUTF8();
        Map<String, String> responseMap = objectMapper.readValue(responseJson, Map.class);

        return ResponseEntity
                .status(feignException.status())
                .body(responseMap);
    }
}
