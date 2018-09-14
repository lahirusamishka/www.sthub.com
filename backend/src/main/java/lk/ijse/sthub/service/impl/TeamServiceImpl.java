package lk.ijse.sthub.service.impl;


import lk.ijse.sthub.dto.TeacherDTO;
import lk.ijse.sthub.dto.TeamDTO;
import lk.ijse.sthub.dto.TeamDTO2;
import lk.ijse.sthub.entity.Teacher;
import lk.ijse.sthub.entity.Team;
import lk.ijse.sthub.entity.User;
import lk.ijse.sthub.repository.TeacherRepository;
import lk.ijse.sthub.repository.TeamRepository;
import lk.ijse.sthub.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TeamRepository teamRepository;


    @Override
    public ArrayList<TeamDTO> getAllTeams(String username) {


        ArrayList<Team> teamArrayList1 = teamRepository.getallTems();


        ArrayList<TeamDTO> teamDTOS = new ArrayList<>();

        for (Team team : teamArrayList1) {
            if (username.equals(team.getTeacher().getName())) {

                TeamDTO teamDTO = new TeamDTO(team.getTeamid(), team.getSubject(), team.getDiscription(), team.isVisibles(), team.getTeacher().getName());

                System.out.println(teamDTO);

                teamDTOS.add(teamDTO);
            }
        }

        return teamDTOS;

      /*  for (Team team : all) {

            String name = team.getTeacher().getName();
            System.out.println(username);

            if (username != "samishka") {
                System.out.println("aaaaaaaaaaaaaaaaa");
                TeamDTO teamDTO = new TeamDTO();
                teamDTO.setTeamid(team.getTeamid());
                teamDTO.setSubject(team.getSubject());
                teamDTO.setDiscription(team.getDiscription());
                teamDTO.setVisibles(team.isVisibles());

                teamArrayList.add(teamDTO);
            }
            System.out.println("end");

        }
        return teamArrayList;*/

     /*   boolean result = teacherRepository.existsById(username);
        if (!result){
            return null;
        }
*/


/*
        return user.getPassword().equals(password);


        List<Team> allTeams = teamRepository.findAll();


        ArrayList<TeamDTO> teamDTO2s = new ArrayList<>();

        for (Team team : allTeams) {

            TeamDTO teamDTO = new TeamDTO();

            teamDTO.setTeamid(team.getTeamid());
            teamDTO.setSubject(team.getSubject());
            teamDTO.setDiscription(team.getDiscription());
            teamDTO.setVisibles(team.isVisibles());

            Teacher asdT = team.getTeacher();

            teamDTO.setTeacherUserName(asdT.getName());


            teamDTO2s.add(teamDTO);

        }

        return teamDTO2s;*/
    }

    @Override
    public TeamDTO getTeam(long teamId) {
        return null;
    }

    @Override
    public boolean deleteTeam(long teamId) {
        return false;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveTeam(TeamDTO teamDTO) {


        String teacherUserName = teamDTO.getTeacherUserName();
        Teacher teacher1 = teacherRepository.findById(teacherUserName).get();


        Team team1 = new Team();

        team1.setSubject(teamDTO.getSubject());
        team1.setDiscription(teamDTO.getDiscription());
        team1.setVisibles(teamDTO.isVisibles());
        team1.setTeacher(teacher1);

        teamRepository.save(team1);
        return true;
    }

    @Override
    public long getTotalTeams() {
        return 0;
    }


}
