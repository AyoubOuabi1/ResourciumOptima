package com.ayoub.resourciumoptima.Services;

import com.ayoub.resourciumoptima.Repositories.DepartmentRepositoryImp;
import com.ayoub.resourciumoptima.Repositories.EquipmentRepositoryImp;
import com.ayoub.resourciumoptima.entities.Department;
import com.ayoub.resourciumoptima.entities.Equipment;
import com.ayoub.resourciumoptima.interfaces.DepartmentRepository;
import com.ayoub.resourciumoptima.interfaces.EquipmentRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class EquipmentService {

    //@Inject
    private EquipmentRepository equipmentRepository;

    public EquipmentService(){
        equipmentRepository=new EquipmentRepositoryImp() {
        };
    }


    public Equipment findEquipment(Long id) throws NullPointerException {
        return equipmentRepository.findById(id);
    }

    public void saveEquipment(Equipment equipment) {
        if (equipment != null){
            equipmentRepository.save(equipment);
        }

    }

    public void removeEquipment(Long id) throws Exception {
        if (id != null){
            equipmentRepository.delete(id);
        }

    }

    public void updateEquipment(Equipment equipment) throws Exception {
        if (equipment != null){
            equipmentRepository.update(equipment);
        }
     }

    public List<Equipment> getTasks()  throws NullPointerException{
        return equipmentRepository.getAll();
    }


}
