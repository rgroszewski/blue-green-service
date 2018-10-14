package com.rg.bluegreen;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlueGreenRestController {

    @GetMapping("/bluegreenrest")
    public Object bluegreen() {
        return new Color(Color.getSystemColor());
    }
}