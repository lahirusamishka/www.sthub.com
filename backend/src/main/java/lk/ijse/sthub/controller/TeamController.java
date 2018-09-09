package lk.ijse.sthub.controller;


import lk.ijse.sthub.dto.TeamDTO;
import lk.ijse.sthub.dto.TeamDTO2;
import lk.ijse.sthub.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/teams")
public class TeamController {


    @Autowired
    private TeamService teamService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveTeam(@RequestBody TeamDTO teamDTO){
        return teamService.saveTeam(teamDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TeamDTO2>  getAllTeams(){
       return teamService.getAllTeams();
    }

}
