package com.project.Cafe_Management_System.Service.TokenService;

import com.project.Cafe_Management_System.Dto.TokenDto.TokenDto;
import com.project.Cafe_Management_System.Dto.TokenDto.TokenResponesDto;

public interface TokenService {
    TokenResponesDto Token_Post(TokenDto tokenDto);
}
