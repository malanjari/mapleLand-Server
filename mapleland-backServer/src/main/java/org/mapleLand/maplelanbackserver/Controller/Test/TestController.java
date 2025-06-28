package org.mapleLand.maplelanbackserver.Controller.Test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/login")
    public String loginPage() {
        return "loginPage"; // ✅ templates/loginPage.html로 매핑됨
    }
}
