package com.hospitalproject.dao;

import java.util.List;

/**
 * Created by kingm on 27.11.2017.
 */
public interface IQualificationsDAO {
    List<String> getAllQualifications();

    int getQualificationIdByName(String item);
}
