package net.odk.volunteerdesk_api.controllers;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppController {


    @RestController
    @RequestMapping("/dashboard")
    public class DashboardController {

        @GetMapping
        public String getDashboard() {
            return "Bienvenue sur le Dashboard"; // Accessible par ADMIN et SENIOR
        }
    }

    @RestController
    @RequestMapping("/mobile")
    public class MobileController {

        @GetMapping
        public String getMobileApp() {
            return "Bienvenue sur l'application mobile"; // Accessible à tous, y compris les jeunes
        }
    }
}
