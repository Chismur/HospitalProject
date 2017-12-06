package com.hospitalproject.dao.interfaces;

import java.util.List;

/**
 * Created by kingm on 27.11.2017.
 */
public interface IPositionsDAO {
    List<String> getAllPositions();

    int getPositionIdByName(String item);
}
