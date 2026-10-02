package com.project.Cafe_Management_System.Service.Menu_itemService;

import com.project.Cafe_Management_System.Dto.Menu_itemDto.Menu_itemDto;
import com.project.Cafe_Management_System.Dto.Menu_itemDto.Menu_itemResponesDto;

import java.util.List;

public interface Menu_itemService {

    List<Menu_itemResponesDto> menu_Get();
    Menu_itemResponesDto menu_Post(Menu_itemDto menu_itemDto);
    String menu_Put(Integer id,Menu_itemDto menu_itemDto);
    String menu_Delete(Integer id);
}