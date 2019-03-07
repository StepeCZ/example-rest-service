package com.stepanek.examplerestservice.controller;

import com.stepanek.examplerestservice.service.NumericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pavel Stepanek
 *
 * Simple method implemented as GET HTTP request where input is passed as path variable.
 *
 */

@RestController
@RequestMapping("ns-rest")
public class SimpleRestController {

    @Autowired
    private NumericService numericService;

    @GetMapping(value = "/{numCode}", produces = "application/json")
    public String convertNumericCode(@PathVariable String numCode) {
        return numericService.transformValue(numCode);
    }

}
