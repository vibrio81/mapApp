package com.tts.mapApp.controller;


import com.tts.mapApp.model.Location;
import com.tts.mapApp.service.MapService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class MapController {

    private MapService mapService;
    private Logger logger = LoggerFactory.getLogger(MapController.class);

    public MapController(MapService mapService){
        this.mapService = mapService;
    }

    @GetMapping("/home")
    public String getDefaultMap(Model model){
//        Location location = new Location();
//        location.setCity("Dallas");
//        location.setState("Texas");
//        mapService.addCoordinates(location);
//        System.out.println(location);
//        logger.debug("This is my location: {}", location);
        model.addAttribute(new Location());

        return "index.html";
    }
    @PostMapping("/home")
    public String getMapForLocation(Location location, Model model){
        mapService.addCoordinates(location);
        model.addAttribute(location);
        return "index.html";
    }
}