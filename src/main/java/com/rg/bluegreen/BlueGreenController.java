package com.rg.bluegreen;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlueGreenController {

    @GetMapping("/bluegreen")
    public String bluegreen(Model model) {
        String color = Color.getSystemColor();
        model.addAttribute("color", color);
        String hostname = "Unknown";
        try
        {
            InetAddress addr;
            addr = InetAddress.getLocalHost();
            hostname = addr.getHostName();
        }
        catch (UnknownHostException ex)
        {
            System.out.println("Hostname can not be resolved");
        }
        model.addAttribute("hostname", hostname);
        return "bluegreen";
    }
}