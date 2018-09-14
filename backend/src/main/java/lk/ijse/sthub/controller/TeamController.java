package lk.ijse.sthub.controller;


import lk.ijse.sthub.dto.TeamDTO;
import lk.ijse.sthub.dto.TeamDTO2;
import lk.ijse.sthub.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/teams")
public class TeamController {


    @Autowired
    private TeamService teamService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveTeam(@RequestBody TeamDTO teamDTO) {

        return teamService.saveTeam(teamDTO);
    }

    @GetMapping(value = "/all/{username}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<TeamDTO> getAllTeams(@PathVariable("username")String username) {

        return teamService.getAllTeams(username);

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<TeamDTO> getAllTeams() {

        return teamService.getAll();

    }



    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public TeamDTO getTeam(@PathVariable("id")long teamId){
        return teamService.getTeam(teamId);
    }

    @DeleteMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public  boolean deleteTeacher(@PathVariable("id")long teamId){
        return teamService.deleteTeam(teamId);
    }

    @GetMapping(value = "/count",produces = MediaType.APPLICATION_JSON_VALUE)
    public long getTotalTeam(){
        return teamService.getTotalTeams();
    }


}
