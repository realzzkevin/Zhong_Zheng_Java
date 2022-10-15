package com.company.M2ChallengeZhengZhong.controller;

import com.company.M2ChallengeZhengZhong.model.Month;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Random;

@RestController
public class MonthController {

    @RequestMapping(value = "/month/{monthNumber}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Month convertNumberToMonth(@PathVariable @Valid int monthNumber) {
        if(monthNumber < 1 || monthNumber > 12 ) {
            throw new IllegalArgumentException("The input number is not in the range of 1 to 12.");
        }
        return new Month(monthNumber);
    }

    @RequestMapping(value = "/randomMonth", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Month getRandomMonth() {
        return new Month(new Random().nextInt(11) + 1);
    }
}
