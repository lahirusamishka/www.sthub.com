package lk.ijse.sthub.service;

import lk.ijse.sthub.dto.ParentDTO;

import java.util.ArrayList;

public interface ParentService {
    public ArrayList<ParentDTO> getAllParent();

    public ParentDTO getParent(String parentEmail);

    public boolean deleteParent(String parentEmail);

    public boolean saveParent(ParentDTO parentDTO);

    public boolean parentValid(String username,String password);

    public long getTotalParent();
}
