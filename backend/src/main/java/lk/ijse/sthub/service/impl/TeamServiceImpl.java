package lk.ijse.sthub.service.impl;


import lk.ijse.sthub.dto.*;
import lk.ijse.sthub.entity.Student;
import lk.ijse.sthub.entity.Teacher;
import lk.ijse.sthub.entity.Team;
import lk.ijse.sthub.entity.User;
import lk.ijse.sthub.repository.StudentRepository;
import lk.ijse.sthub.repository.TeacherRepository;
import lk.ijse.sthub.repository.TeamRepository;
import lk.ijse.sthub.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TeamServiceImpl implements TeamService {

    @Autowired
    private StudentRepository studentRepository;

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
                teamDTOS.add(teamDTO);
            }
        }
        return teamDTOS;

    }

    @Override
    public ArrayList<TeamMemberCountDTO> getAllStudentCountOnTeam(String username) {
        ArrayList<TeamDTO> allTeams = getAllTeams(username);

        ArrayList<TeamMemberCountDTO> teamMemberCountDTOS =  new ArrayList<>();

        for (TeamDTO teamDTO : allTeams) {
            Long teamid = teamDTO.getTeamid();

            int ourTeam = getOurTeam(teamid);

            TeamMemberCountDTO teamMemberCountDTO= new TeamMemberCountDTO();
            teamMemberCountDTO.setTeamTame(teamDTO.getSubject());
            teamMemberCountDTO.setTeamMemberCount(ourTeam);


            teamMemberCountDTOS.add(teamMemberCountDTO);

        }
        return  teamMemberCountDTOS;


    }

    private int getOurTeam(Long teamid) {

        ArrayList<Student> students22 = studentRepository.getallTems2();
        int numbesr=0;

        for (Student student : students22) {

            if (teamid.equals(student.getTeam().getTeamid())) {
                if (!"delete".equals(student.getStatus())) {
                    numbesr+=1;
                }
            }
        }

        return numbesr;

    }

    @Override
    public ArrayList<TeamDTO> getAll() {
        ArrayList<Team> teamArrayListNormal = teamRepository.getallTems();

        ArrayList<TeamDTO> teamDTOS = new ArrayList<>();

        for (Team team : teamArrayListNormal) {
            TeamDTO teamDTO = new TeamDTO();

            teamDTO.setTeamid(team.getTeamid());
            teamDTO.setSubject(team.getSubject());
            teamDTO.setDiscription(team.getDiscription());
            teamDTO.setVisibles(team.isVisibles());
            teamDTO.setTeacherUserName(team.getTeacher().getName());

            teamDTOS.add(teamDTO);
        }

        return teamDTOS;
    }

    @Override
    public TeamDTO getTeam(long teamId) {
        Team team = teamRepository.findById(teamId).get();

        return new TeamDTO(team.getTeamid(), team.getSubject(), team.getDiscription(), team.isVisibles(), team.getTeacher().getName());

    }

    @Override
    public boolean deleteTeam(long teamId) {
        teamRepository.deleteById(teamId);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveTeam(TeamDTO teamDTO) {

        if (saveTeams(teamDTO)) {
            return true;
        } else {
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

    }

    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveTeams(TeamDTO teamDTO) {

        String teacherUserName = teamDTO.getTeacherUserName();
        Teacher teacher1 = teacherRepository.findById(teacherUserName).get();

        Team team = new Team();
        team.setTeamid(teamDTO.getTeamid());
        team.setSubject(teamDTO.getSubject());
        team.setDiscription(teamDTO.getDiscription());
        team.setVisibles(teamDTO.isVisibles());
        team.setTeacher(teacher1);

        teamRepository.save(team);
        return true;
    }


    @Override
    public long getTotalTeams() {
        return teamRepository.getTotalTeams();
    }


}
