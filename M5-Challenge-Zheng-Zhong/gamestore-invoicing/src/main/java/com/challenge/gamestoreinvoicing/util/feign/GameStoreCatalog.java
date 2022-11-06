package com.challenge.gamestoreinvoicing.util.feign;

import com.challenge.gamestoreinvoicing.viewModel.ConsoleViewModel;
import com.challenge.gamestoreinvoicing.viewModel.GameViewModel;
import com.challenge.gamestoreinvoicing.viewModel.TShirtViewModel;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "gamestore-catalog")
public interface GameStoreCatalog {
    //get console by Id
    @RequestMapping(value = "/console/{id}", method = RequestMethod.GET)
    public ConsoleViewModel getConsoleById(@PathVariable long id);
    //update console
    @RequestMapping(value = "/console", method = RequestMethod.PUT)
    public void updateConsole(@RequestBody ConsoleViewModel consoleViewModel);

    //get Game by Id
    @RequestMapping(value = "/game/{id}", method = RequestMethod.GET)
    public GameViewModel getGameById(@PathVariable long id);

    //update Game
    @RequestMapping(value = "/game", method = RequestMethod.PUT)
    public void updateGame(@RequestBody GameViewModel gameViewModel);

    //get TShirt by Id
    @RequestMapping(value = "/tshirt/{id}", method = RequestMethod.GET)
    public TShirtViewModel getTShirtById(@PathVariable long id);

    //update T-shirt
    @RequestMapping(value = "/tshirt", method = RequestMethod.PUT)
    public void updateTShirt(@RequestBody TShirtViewModel tShirtViewModel);


}
