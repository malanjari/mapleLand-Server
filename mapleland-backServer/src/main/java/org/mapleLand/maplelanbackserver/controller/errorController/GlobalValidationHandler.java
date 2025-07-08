package org.mapleLand.maplelanbackserver.controller.errorController;

import com.fasterxml.jackson.core.exc.InputCoercionException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.extern.slf4j.Slf4j;
import org.mapleLand.maplelanbackserver.enumType.Region;
import org.mapleLand.maplelanbackserver.enumType.TradeType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class GlobalValidationHandler {

    /**
     * 1. 유효성 검증 실패 처리 (ex. @Size, @NotNull 등)
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.toMap(
                        FieldError::getField,
                        FieldError::getDefaultMessage,
                        (existing, replacement) -> existing // 중복 필드는 첫 메시지 유지
                ));

        return ResponseEntity.badRequest().body(Map.of(
                "status", "FAIL",
                "errors", errors
        ));
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, Object>> handleJsonParseError(HttpMessageNotReadableException ex) {
        Throwable cause = ex.getCause();
        log.error("HttpMessageNotReadableException 발생", ex);
        log.error("cause type = {}", cause != null ? cause.getClass().getName() : "null");

        if (cause instanceof JsonMappingException jme) {
            Throwable rootCause = jme.getCause();
            if (rootCause instanceof InputCoercionException) {
                String field = jme.getPath().isEmpty() ? "입력값" : jme.getPath().get(0).getFieldName();
                return ResponseEntity.badRequest().body(Map.of(
                        "status", "FAIL",
                        "errors", Map.of(field, "입력한 숫자가 너무 큽니다. 최대 20억 이하로 입력해주세요.")
                ));
            }
        }

        // 2. InvalidFormatException (예: Enum 값이 잘못되었을 때 등)
        if (cause instanceof InvalidFormatException ife) {
            String field = ife.getPath().isEmpty() ? "입력값" : ife.getPath().get(0).getFieldName();
            String badValue = String.valueOf(ife.getValue());
            String typeName = ife.getTargetType().getSimpleName();

            if ("Integer".equals(typeName) && "price".equals(field)) {
                return ResponseEntity.badRequest().body(Map.of(
                        "status", "FAIL",
                        "errors", Map.of("price", "가격은 최대 20억까지 입력 가능합니다.")
                ));
            }

            String message = switch (typeName) {
                case "Region" -> String.format("필드 '%s'에 잘못된 지역 값 '%s'이 들어왔습니다.", field, badValue);
                case "TradeType" -> String.format("필드 '%s'에 잘못된 거래 유형 값 '%s'이 들어왔습니다.", field, badValue);
                default -> String.format("필드 '%s'에 잘못된 값 '%s'이 들어왔습니다.", field, badValue);
            };

            return ResponseEntity.badRequest().body(Map.of(
                    "status", "FAIL",
                    "errors", Map.of(field, message)
            ));
        }

        // 3. 나머지 JSON 파싱 실패
        return ResponseEntity.badRequest().body(Map.of(
                "status", "FAIL",
                "error", "잘못된 요청 형식입니다. JSON 구조나 필드 값을 다시 확인해주세요."
        ));
    }
    @ExceptionHandler(MapNameMismatchException.class)
    public ResponseEntity<Map<String, Object>> handleMapNameMismatch(MapNameMismatchException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST) // 400으로 명시적으로 지정
                .body(Map.of(
                        "status", "FAIL",
                        "errors", Map.of("mapName", ex.getMessage())
                ));
    }

    @ExceptionHandler(UserBanGlobalException.class)
    public ResponseEntity<Map<String, Object>> handleUserBan(UserBanGlobalException ex) {
        String message = String.format("%s (사유: %s)", ex.getMessage(), ex.getReason());

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Map.of(
                "status", "FAIL",
                "errors", Map.of("user", message)
        ));
    }

    @ExceptionHandler(NotFoundUserException.class)
    public ResponseEntity<Map<String, Object>> handleNotFoundUser(NotFoundUserException ex) {
        return ResponseEntity.badRequest().body(Map.of(
                "status", "FAIL",
                "errors", Map.of("mapName", ex.getMessage())
        ));
    }
}
