package com.project.Cafe_Management_System.Controller.PaymentsController;

import com.project.Cafe_Management_System.Dto.PaymentsDto.PaymentsDto;
import com.project.Cafe_Management_System.Dto.PaymentsDto.PaymentsResponesDto;
import com.project.Cafe_Management_System.Service.PaymentsService.PaymentsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Payments")
public class PaymentsController {
    private final PaymentsService paymentsService;

    public PaymentsController(PaymentsService paymentsService) {
        this.paymentsService = paymentsService;
    }

//    Get All Payments
    @GetMapping("/Get")
    public List<PaymentsResponesDto> payments_Get(){
        return paymentsService.payments_All_Get();
    }

//    Insert New Payments
    @PostMapping("/Post")
    public PaymentsResponesDto payments_Insert(@RequestBody PaymentsDto paymentsDto){
        return paymentsService.payments_Post(paymentsDto);
    }

//    Update Payments Using id
    @PutMapping("/Update/{id}")
    public PaymentsResponesDto payments_Update(@PathVariable Integer id,@RequestBody PaymentsDto paymentsDto){
        return paymentsService.payments_Put(id,paymentsDto);
    }

//    Delete Payments Using id
    @DeleteMapping("/Delete/{id}")
    public String payments_Delete(@PathVariable Integer id){
        return paymentsService.payments_Delete(id);
    }
}