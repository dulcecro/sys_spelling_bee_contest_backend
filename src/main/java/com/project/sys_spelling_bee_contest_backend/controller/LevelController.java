package com.project.sys_spelling_bee_contest_backend.controller;

import com.project.sys_spelling_bee_contest_backend.model.Level;
import com.project.sys_spelling_bee_contest_backend.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sbee")
public class LevelController {
    @Autowired
    private LevelService levelService;

    @GetMapping("/level")
    public List<Level> listLevels(){
        return levelService.listLevels();
    }

}
