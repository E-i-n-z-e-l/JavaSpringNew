package com.example.Seminar_03_Task_01.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/* @Controller - это специальная аннотация в Spring Framework, которая помечает класс как контроллер.
Контроллер отвечает за обработку HTTP-запросов и возвращает данные или отображает шаблоны представлений. */
@Controller
public class MainController {

    /* @RequestMapping("/home") - это аннотация, которая указывает, какому URL-адресу должен быть
    сопоставлен метод home(). В данном случае, метод home() будет вызван при обращении по URL "/home". */
    @RequestMapping("/home")
    public String home() {
        return "home.html";
    }
    /* public String home() - это сам метод home(). Он возвращает строку "home.html".
    В этом случае, возвращаемая строка представляет имя файла шаблона представления, который
    будет отображен.

    Когда пользователь обращается к URL "/home", Spring Framework вызывает метод home() в
    экземпляре класса MainController, который в свою очередь возвращает строку "home.html".
    Далее, Spring Framework найдет и отобразит шаблон представления с именем home.html пользователю. */
}
