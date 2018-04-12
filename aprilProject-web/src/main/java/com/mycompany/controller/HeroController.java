/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.model.DTO.HeroDto;
import com.mycompany.service.HeroService;
import java.util.List;
import javafx.scene.media.Media;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ramen
 */
@Path("/hero")
public class HeroController {
    
    @Inject
    HeroService heroService;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<HeroDto> getHeros(){
        return heroService.getHeros();
    }
}
