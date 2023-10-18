package com.ayoub.resourciumoptima.interfaces;

 import com.ayoub.resourciumoptima.entities.Equipment;

import java.util.List;

public interface EquipmentRepository {
    void save(Equipment obj);

    void delete(Long id);

    void update(Equipment obj);

    Equipment findById(Long id);

    List<Equipment> getAll();

}
