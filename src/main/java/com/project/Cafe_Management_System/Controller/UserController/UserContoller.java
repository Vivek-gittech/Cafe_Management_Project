package com.project.Cafe_Management_System.Controller.UserController;

import com.project.Cafe_Management_System.Dto.UserDto.DetailsResponesDto;
import com.project.Cafe_Management_System.Dto.UserDto.UserDto;
import com.project.Cafe_Management_System.Dto.UserDto.UserResponesDto;
import com.project.Cafe_Management_System.Service.UserService.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserContoller {
    private final UserService userService;

    public UserContoller(UserService userService) {
        this.userService = userService;
    }
    //Get The All User With role
    @GetMapping("/Get")
    public ResponseEntity<List<UserResponesDto>> Get_Data(){
        return ResponseEntity.ok(userService.get_Data());
    }

    //Post The Data In New User
    @PostMapping("/Post")
    public ResponseEntity<UserResponesDto> create_user(@RequestBody UserDto userDto){
        UserResponesDto usersaved=userService.user_Post_Data(userDto);
        return ResponseEntity.ok(usersaved);
    }

    //Update The User in User_id
    @PutMapping("/Update/{id}")
    public ResponseEntity<UserResponesDto> put_Data(@PathVariable Integer id,@RequestBody UserDto userDto){
        UserResponesDto userSaved=userService.put_Data(id,userDto);
        return ResponseEntity.ok(userSaved);
    }

    //Delete The User In User_id
    @DeleteMapping("/Delete/{id}")
    public String Delete_User(@PathVariable Integer id){
        return userService.user_Delete(id);

    }

    @GetMapping("/GetDetails")
    public ResponseEntity<DetailsResponesDto> getDashBoardDetails(){
        DetailsResponesDto details=userService.getDashboardDetails();
        return ResponseEntity.ok(details);
    }
}
