package com.example.Practical_04_Task_03.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegistrationController {

    @GetMapping("/registration")
    public String registrationForm() {
        return "registration";
    }

    @PostMapping("/registration")
    @ResponseBody
    public String processRegistration(@RequestParam("firstName") String firstName,
                                      @RequestParam("lastName") String lastName,
                                      @RequestParam("email") String email) {
        // Обработка отправленных данных
        return "Данные успешно отправлены: " + firstName + " " + lastName + ", email: " + email;
    }
}

