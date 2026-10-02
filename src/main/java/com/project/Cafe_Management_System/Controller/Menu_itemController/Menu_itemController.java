package com.project.Cafe_Management_System.Controller.Menu_itemController;

import com.project.Cafe_Management_System.Dto.Menu_itemDto.Menu_itemDto;
import com.project.Cafe_Management_System.Dto.Menu_itemDto.Menu_itemResponesDto;
import com.project.Cafe_Management_System.Service.Menu_itemService.Menu_itemService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/Menu")
@PreAuthorize("hasAnyRole('Chef', 'Admin')")
public class Menu_itemController {
    private final Menu_itemService menuitemService;

    public Menu_itemController(Menu_itemService menuitemService) {
        this.menuitemService = menuitemService;
    }

    @GetMapping("/Get")
    public List<Menu_itemResponesDto> menu_Get(){
        return menuitemService.menu_Get();
    }
    @PostMapping("/Post")
    public Menu_itemResponesDto menu_Add(@RequestBody Menu_itemDto menu_itemDto){
        return menuitemService.menu_Post(menu_itemDto);
    }

    @PutMapping("/Update/{id}")
    public String menu_Put(@PathVariable Integer id,@RequestBody Menu_itemDto menu_itemDto){
        return menuitemService.menu_Put(id,menu_itemDto);
    }

    @DeleteMapping("/Delete/{id}")
    public String menu_Delete(@PathVariable Integer id){
        return menuitemService.menu_Delete(id);
    }
}