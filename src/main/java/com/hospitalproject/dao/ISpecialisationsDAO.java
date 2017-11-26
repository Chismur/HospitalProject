package com.hospitalproject.dao;

import java.util.List;

/**
 * Created by kingm on 27.11.2017.
 */
public interface ISpecialisationsDAO {
    List<String> getAllSpecialisations();

    int getSpecialisationIdByName(String item);
}
