package lk.ijse.sthub.service;


import lk.ijse.sthub.dto.TeamDTO;
import lk.ijse.sthub.dto.TeamDTO2;
import lk.ijse.sthub.dto.TeamMemberCountDTO;

import java.util.ArrayList;
import java.util.List;

public interface TeamService {

    public ArrayList<TeamDTO> getAllTeams(String username);


    public ArrayList<TeamDTO> getAll();

    public TeamDTO getTeam(long teamId);



    public boolean deleteTeam(long teamId);

    public boolean saveTeam(TeamDTO teamDTO);

    public long getTotalTeams();

    public ArrayList<TeamMemberCountDTO> getAllStudentCountOnTeam(String username);
}
