package by.kirill.sportsman.app.config.swagger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Retention(RUNTIME)
@Target(ElementType.METHOD)
@Operation(summary = "Get Run", description = "Get run based on the given input id")
@ApiResponse(content = @Content(mediaType = "application/json"))
@ApiResponse(responseCode = "200", description = "Run successfully returned")
@ApiResponse(responseCode = "400", description = "Bad request")
@ApiResponse(responseCode = "404", description = "Run not found")
@ApiResponse(responseCode = "500", description = "Remote server error")
public @interface GetRunOperationOperation {
}