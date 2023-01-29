/*
 * ┌───────────────────────────────────────────────────────────────────┐
 * │ Copyright (c) 2023년 1월 30일 송민우 All rights reserved.          │
 * └───────────────────────────────────────────────────────────────────┘
 */

/*
Date Created : 2023-01-30
Code Author : 송민우
Creation Time : 오전 5:39
Purpose : Main Web Page Request Client Handling
*/

package com.eden.euphoria.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value = "/")
    public String homePage() {
        return "main/main";
    }

    @GetMapping(value = "main/main")
    public String mainPage() {
        return "main/main";
    }

    @GetMapping("/error/404")
    public String error_404_page() {
        return "error/error_404_page";
    }

    @GetMapping("/error/500")
    public String error_500_page() {
        return "error/error_500_page";
    }
}
