package com.project.Cafe_Management_System.Mapper.TokenMapper;

import com.project.Cafe_Management_System.Dto.TokenDto.TokenDto;
import com.project.Cafe_Management_System.Dto.TokenDto.TokenResponesDto;
import com.project.Cafe_Management_System.Entity.OrderEntity.Order;
import com.project.Cafe_Management_System.Entity.TokenEntity.Token;
import org.springframework.stereotype.Component;

@Component
public class TokenMapper {

    public static Token to_Entity(TokenDto tokenDto, Order order){
        Token token=new Token();
        token.setOrder(order);
        token.setToken_number(tokenDto.getToken_number());
        token.setIs_called(tokenDto.isIs_called());
        return token;
    }
    public static TokenResponesDto toDto(Token token){
        TokenResponesDto tokenRes=new TokenResponesDto();
        tokenRes.setToken_number(token.getToken_number());
        tokenRes.setOrder_id(token.getOrder().getOrder_id());
        tokenRes.setIs_called(token.isIs_called());
        return tokenRes;
    }
}
