package lk.ijse.sthub.service;




import lk.ijse.sthub.dto.TeamDTO;
import lk.ijse.sthub.dto.TeamDTO2;

import java.util.List;

public interface TeamService {

    public boolean saveTeam(TeamDTO teamDTO);
    public List<TeamDTO2> getAllTeams();

}
