package lk.ijse.sthub.service.impl;


import lk.ijse.sthub.dto.TeacherDTO;
import lk.ijse.sthub.dto.TeamDTO;
import lk.ijse.sthub.dto.TeamDTO2;
import lk.ijse.sthub.entity.Teacher;
import lk.ijse.sthub.entity.Team;
import lk.ijse.sthub.repository.TeacherRepository;
import lk.ijse.sthub.repository.TeamRepository;
import lk.ijse.sthub.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TeamRepository teamRepository;


    @Override
    public boolean saveTeam(TeamDTO teamDTO) {

        TeamDTO teamDTO1= teamDTO;
        TeacherDTO teacherDTO= teamDTO.getTeacherDTO();

        Teacher teacher= new Teacher();


        teacher.setName(teacherDTO.getName());



        Team team1= new Team();
        team1.setTeamName(teamDTO1.getTeamName());
        team1.setDescription(teamDTO1.getDescription());
        team1.setVisible(teamDTO1.getVisible());
        team1.setTeacher(teacher);

        teamRepository.save(team1);
        return true;

    }

    @Override
    public List<TeamDTO2> getAllTeams() {
        List<Team> allTeams = teamRepository.findAll();




        List<TeamDTO2> teamDTO2s= new ArrayList<>();

        for (Team team:allTeams) {
            TeamDTO2  teamDTO2= new TeamDTO2();

            teamDTO2.setTeamId(team.getId());
            teamDTO2.setTeamName(team.getTeamName());
            teamDTO2.setDescription(team.getDescription());
            teamDTO2.setVisible(team.getVisible());
            Teacher teacher=team.getTeacher();
            teamDTO2.setTeacherEmail(teacher.getEmail());

            teamDTO2s.add(teamDTO2);

        }

        return teamDTO2s;

    }
}
