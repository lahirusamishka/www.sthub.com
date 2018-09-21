package lk.ijse.sthub.dto;

public class TeamMemberCountDTO {

    private String teamTame;
    private int teamMemberCount;

    public TeamMemberCountDTO() {
    }

    public TeamMemberCountDTO(String teamTame, int teamMemberCount) {
        this.teamTame = teamTame;
        this.teamMemberCount = teamMemberCount;
    }

    public String getTeamTame() {
        return teamTame;
    }

    public void setTeamTame(String teamTame) {
        this.teamTame = teamTame;
    }

    public int getTeamMemberCount() {
        return teamMemberCount;
    }

    public void setTeamMemberCount(int teamMemberCount) {
        this.teamMemberCount = teamMemberCount;
    }

    @Override
    public String toString() {
        return "TeamMemberCountDTO{" +
                "teamTame='" + teamTame + '\'' +
                ", teamMemberCount=" + teamMemberCount +
                '}';
    }
}
