package com.Kunal.Cards.Controller;

import com.Kunal.Cards.Dto.CardDto;
import com.Kunal.Cards.Dto.ErrorResponseDto;
import com.Kunal.Cards.Model.Cards;
import com.Kunal.Cards.Service.iCardsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@AllArgsConstructor
@Validated
@RequestMapping("/cards")
@Tag(
        name = "Crud rest api for cards",
        description = "Crud rest api for cards to create,fetch,update and delete cards"
)
public class CardsController {
    private iCardsService cardsService;

    @Operation(
            summary = "Create a new card",
            description = "Create a new card with given mobile number"
    )
    @ApiResponses(
            {
                    @ApiResponse(
                            responseCode = "201",
                            description = "HttpStatus CREATED "
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "HttpStatus BAD_REQUEST ",
                            content=@Content(
                                 schema =   @Schema(implementation = ErrorResponseDto.class)
                            )
                    )
            }
    )
    @PostMapping("create")
    public ResponseEntity<String> createCard(@RequestParam @Pattern(regexp = "^$|[0-9]{10}",message = "Mobile Number must contains 10 digits!") String mobileNo) {
        cardsService.createCard(mobileNo);
        return new ResponseEntity<>("card created successfully", HttpStatus.CREATED);
    }

    @Operation(
            summary = "Fetch card details",
            description = "Rest api for fetching card details using mobile number"
    )
    @ApiResponses({
            @ApiResponse(),
            @ApiResponse(
                    responseCode = "302",
                    description = "HttpStatus FOUND"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "HttpStatus BAD_REQUEST",

                    content=@Content(
                            schema =   @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
   @GetMapping("fetchCard/{mobileNo}")
    public ResponseEntity<CardDto> fetchCard(@PathVariable @Pattern(regexp = "^$|[0-9]{10}",message = "Mobile number must contains 10 digits") String mobileNo){
        CardDto card=cardsService.fetchCard(mobileNo);
        return new ResponseEntity<>(card,HttpStatus.FOUND);
   }


    @Operation(
            summary = "Fetch card details",
            description = "Rest api for fetching card details using mobile number"
    )
    @ApiResponses({
            @ApiResponse(),
            @ApiResponse(
                    responseCode = "202",
                    description = "HttpStatus ACCEPTED"
            ),
            @ApiResponse(
                    responseCode = "406",
                    description = "HttpStatus NOT_ACCEPTABLE",

                    content=@Content(
                            schema =   @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
   @PostMapping("updateCard")
   public ResponseEntity<String> updateCard(@RequestBody @Valid CardDto cardDto){
        boolean isUpdated=cardsService.updateCard(cardDto);
        if(isUpdated) {
            return new ResponseEntity<>("updated", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("failed",HttpStatus.NOT_ACCEPTABLE);
   }


    @Operation(
            summary = "Delete card ",
            description = "Rest api for deleting card details using mobile number"
    )
    @ApiResponses({
            @ApiResponse(),
            @ApiResponse(
                    responseCode = "202",
                    description = "HttpStatus ACCEPTED"
            ),
            @ApiResponse(
                    responseCode = "406",
                    description = "HttpStatus NOT_ACCEPTABLE",

                    content=@Content(
                            schema =   @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
   @DeleteMapping("delete/{mobileNo}")
    public  ResponseEntity<String> deleteCard(@PathVariable @Pattern(regexp = "^$|[0-9]{10}",message = "Mobile number must contains 10 digits!") String mobileNo){
        boolean isDeleted=cardsService.delete(mobileNo);
        if(isDeleted){
            return new ResponseEntity<>("Deletion succesfull for card registerd with mobileNo - "+mobileNo,HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("failed",HttpStatus.NOT_ACCEPTABLE);
   }
}
