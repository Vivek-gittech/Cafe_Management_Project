package com.project.Cafe_Management_System.Controller.TokenController;

import com.project.Cafe_Management_System.Dto.TokenDto.TokenDto;
import com.project.Cafe_Management_System.Dto.TokenDto.TokenResponesDto;
import com.project.Cafe_Management_System.Service.TokenService.TokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Token")
public class TokenController {
    private final TokenService tokenService;

    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/Post")
    public ResponseEntity<TokenResponesDto> Token_Insert(@RequestBody TokenDto tokenDto){
        TokenResponesDto tokenRes=tokenService.Token_Post(tokenDto);
        return ResponseEntity.ok(tokenRes);
    }
}
