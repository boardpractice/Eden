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

import com.eden.euphoria.commons.annotation.LogException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value = "/")
    @LogException
    public String homePage() {
        return "main/main";
    }

    @GetMapping(value = "main/main")
    @LogException
    public String mainPage() {
        return "main/main";
    }

    @GetMapping(value = "/error/404")
    @LogException
    public String error_404_page() {
        return "error/error_404_page";
    }

    @GetMapping(value = "/error/500")
    @LogException
    public String error_500_page() {
        return "error/error_500_page";
    }
}
