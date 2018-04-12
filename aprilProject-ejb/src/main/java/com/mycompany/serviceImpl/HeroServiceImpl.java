/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.serviceImpl;

import com.mycompany.model.DTO.HeroDto;
import com.mycompany.service.HeroService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ramen
 */
public class HeroServiceImpl implements HeroService{

    @Override
    public List<HeroDto> getHeros() {
         List<HeroDto> heroList = new ArrayList<>();

        heroList.add(new HeroDto(11, "Mr. Nice"));
        heroList.add(new HeroDto(12, "Narco"));
        heroList.add(new HeroDto(13, "Bombasto"));
        heroList.add(new HeroDto(14, "Celeritas"));
        heroList.add(new HeroDto(15, "Magneta"));
        heroList.add(new HeroDto(16, "RubberMan"));
        heroList.add(new HeroDto(17, "Tornado"));
        return heroList;
    }
    
    
}
