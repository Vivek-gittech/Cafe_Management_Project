package com.project.Cafe_Management_System.Service.TokenService.TokenServiceIml;

import com.project.Cafe_Management_System.Dto.TokenDto.TokenDto;
import com.project.Cafe_Management_System.Dto.TokenDto.TokenResponesDto;
import com.project.Cafe_Management_System.Entity.OrderEntity.Order;
import com.project.Cafe_Management_System.Entity.TokenEntity.Token;
import com.project.Cafe_Management_System.Mapper.TokenMapper.TokenMapper;
import com.project.Cafe_Management_System.Repository.OrderRepository.OrderRepository;
import com.project.Cafe_Management_System.Repository.TokenRepository.TokenRepository;
import com.project.Cafe_Management_System.Service.TokenService.TokenService;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceIml implements TokenService {
    private final TokenRepository tokenRepository;
    private final TokenMapper tokenMapper;
    private final OrderRepository orderRepository;

    public TokenServiceIml(TokenRepository tokenRepository, TokenMapper tokenMapper, OrderRepository orderRepository) {
        this.tokenRepository = tokenRepository;
        this.tokenMapper = tokenMapper;
        this.orderRepository = orderRepository;
    }

    @Override
    public TokenResponesDto Token_Post(TokenDto tokenDto){
        System.out.println("Order_id"+tokenDto.getOrder_id());
        Order order=orderRepository.findById(tokenDto.getOrder_id()).orElseThrow(()->new RuntimeException("Order Id Not Found"));
        TokenResponesDto tokenRes=new TokenResponesDto();
        Token token=TokenMapper.to_Entity(tokenDto,order);
        token=tokenRepository.save(token);
        return TokenMapper.toDto(token);
    }
}