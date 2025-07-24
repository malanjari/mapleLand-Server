package org.mapleland.maplelanbackserver.handler;

import lombok.extern.slf4j.Slf4j;
import org.mapleland.maplelanbackserver.exception.badrequest.BadRequestException;
import org.mapleland.maplelanbackserver.exception.coflict.ConflictException;
import org.mapleland.maplelanbackserver.exception.forbidden.ForbiddenException;
import org.mapleland.maplelanbackserver.exception.notfound.NotFoundException;
import org.mapleland.maplelanbackserver.exception.unauthorization.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 클라이언트의 요청이 잘못되었을 때 (예: 유효하지 않은 입력 값, 잘못된 요청 형식 등) 사용합니다.
     * HTTP 상태 코드 400 Bad Request를 반환합니다.
     */
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handleBadRequestException(BadRequestException e) {
        log.error(e.getMessage());

        HttpStatus status = HttpStatus.BAD_REQUEST; // 400 Bad Request

        return ResponseEntity.status(status).body(e.getMessage());
    }

    /**
     * 인증되지 않은 사용자가 보호된 리소스에 접근하려고 할 때 사용합니다.
     * (예: 로그인이 필요한 기능에 로그인 없이 접근)
     * HTTP 상태 코드 401 Unauthorized를 반환합니다.
     */
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<Object> handleAuthenticationException(UnauthorizedException e) {
        log.error(e.getMessage());

        HttpStatus status = HttpStatus.UNAUTHORIZED; // 401 Unauthorized

        return ResponseEntity.status(status).body(e.getMessage());
    }

    /**
     * 인증은 되었지만 해당 자원에 대한 접근 권한이 없는 사용자가 접근하려고 할 때 사용합니다.
     * (예: 관리자 권한이 필요한 기능에 일반 사용자가 접근)
     * HTTP 상태 코드 403 Forbidden을 반환합니다.
     */
    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<Object> handleForbiddenException(ForbiddenException e) {
        log.error(e.getMessage());

        HttpStatus status = HttpStatus.FORBIDDEN; // 403 Forbidden

        return ResponseEntity.status(status).body(e.getMessage());
    }

    /**
     * 요청한 리소스(데이터, 페이지 등)를 서버에서 찾을 수 없을 때 사용합니다.
     * (예: 존재하지 않는 게시글 ID로 조회)
     * HTTP 상태 코드 404 Not Found를 반환합니다.
     */
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException e) {
        log.error(e.getMessage());

        HttpStatus status = HttpStatus.NOT_FOUND; // 404 Not Found

        return ResponseEntity.status(status).body(e.getMessage());
    }

    /**
     * 요청이 서버의 현재 상태와 충돌될 때 사용합니다.
     * (예: 중복된 데이터를 생성하려고 할 때)
     * HTTP 상태 코드 409 Conflict를 반환합니다.
     */
    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<Object> handleConflictException(ConflictException e) {
        log.error(e.getMessage());

        HttpStatus status = HttpStatus.CONFLICT; // 409 Conflict

        return ResponseEntity.status(status).body(e.getMessage());
    }

    /**
     * 위에 정의된 특정 예외 외의 모든 예상치 못한 서버 오류가 발생했을 때 사용합니다.
     * (예: 데이터베이스 연결 오류, NullPointerException 등)
     * HTTP 상태 코드 500 Internal Server Error를 반환합니다.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception e) {
        log.error("Unhandled exception", e);

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; // 500 Internal Server Error

        return ResponseEntity.status(status).body(e.getMessage());
    }

    /**
     * `@Valid` 또는 `@Validated` 어노테이션을 사용하여 요청 본문(request body)의 유효성 검사(validation)에 실패했을 때 사용합니다.
     * HTTP 상태 코드 400 Bad Request를 반환하며, 어떤 필드에서 어떤 유효성 오류가 발생했는지 상세 정보를 포함합니다.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException e) {
        log.error(e.getMessage());

        BindingResult bindingResult = e.getBindingResult();

        HttpStatus status = HttpStatus.BAD_REQUEST; // 400 Bad Request

        String errorMessage = "유효성 검사 오류가 발생했습니다."; // 기본 메시지

        if (bindingResult.hasErrors() && !bindingResult.getFieldErrors().isEmpty()) {
            FieldError firstError = bindingResult.getFieldErrors().get(0);
            errorMessage = String.format("%s: %s (입력된 값: %s)",
                    firstError.getField(),
                    firstError.getDefaultMessage(),
                    firstError.getRejectedValue());
        }
        // 첫 번째 유효성 검사 오류 메시지만 한 줄로 반환
        return ResponseEntity.status(status).body(errorMessage);
    }



    /**
     * HTTP 요청에 필수 파라미터(예: `@RequestParam`으로 선언된 파라미터)가 누락되었을 때 사용합니다.
     * HTTP 상태 코드 400 Bad Request를 반환하며, 어떤 파라미터가 누락되었는지에 대한 정보를 포함합니다.
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<Object> handleMissingParam(MissingServletRequestParameterException e) {
        log.error(e.getMessage());

        HttpStatus status = HttpStatus.BAD_REQUEST; // 400 Bad Request

        List<String> errorMessages = List.of(e.getMessage());

        return ResponseEntity.status(status).body(errorMessages);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleParseException(HttpMessageNotReadableException e) {
        String errorMessage = "잘못된 요청 데이터입니다.";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }
}
