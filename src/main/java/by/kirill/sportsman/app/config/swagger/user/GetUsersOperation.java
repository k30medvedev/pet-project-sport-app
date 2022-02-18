package by.kirill.sportsman.app.config.swagger.user;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Documented
@Retention(RUNTIME)
@Target(ElementType.METHOD)
@Operation(summary = "Get All Runs", description = "Get all runs based on the given input")
@ApiResponse(content = @Content(mediaType = "application/json"))
@ApiResponse(responseCode = "200", description = "User successfully returned")
@ApiResponse(responseCode = "400", description = "Bad request")
@ApiResponse(responseCode = "404", description = "User not found")
@ApiResponse(responseCode = "500", description = "Remote server error")
public @interface GetUsersOperation {
}