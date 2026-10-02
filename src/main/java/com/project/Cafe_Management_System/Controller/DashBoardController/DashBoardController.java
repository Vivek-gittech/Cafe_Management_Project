package com.project.Cafe_Management_System.Controller.DashBoardController;

import com.project.Cafe_Management_System.Dto.UserDto.DetailsResponesDto;
import com.project.Cafe_Management_System.Service.DashBoardService.DashBoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/DashBoard")
@PreAuthorize("hasRole('Admin')")
public class DashBoardController {
    private final DashBoardService dashBoardService;

    public DashBoardController(DashBoardService dashBoardService) {
        this.dashBoardService = dashBoardService;
    }

    @GetMapping("/GetDetails")
    public ResponseEntity<DetailsResponesDto> getDashBoardDetails(){
        DetailsResponesDto details=dashBoardService.getDashboardDetails();
        return ResponseEntity.ok(details);
    }
}
