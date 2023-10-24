package com.ayoub.resourciumoptima.Services;

import com.ayoub.resourciumoptima.Repositories.DepartmentRepositoryImp;
import com.ayoub.resourciumoptima.Repositories.EquipmentRepositoryImp;
import com.ayoub.resourciumoptima.entities.Department;
import com.ayoub.resourciumoptima.entities.Equipment;
import com.ayoub.resourciumoptima.entities.Task;
import com.ayoub.resourciumoptima.interfaces.DepartmentRepository;
import com.ayoub.resourciumoptima.interfaces.EquipmentRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

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
            Equipment equipment=findEquipment(id);
            if (equipment != null){
                equipmentRepository.delete(equipment);
            }

        }

    }

    public void updateEquipment(Equipment equipment) throws Exception {
        if (equipment != null){
            equipmentRepository.update(equipment);
        }
     }

    public Optional<List<Equipment>> getEquipments()  throws NullPointerException{
        if(equipmentRepository.getAll().size() == 0){
            return Optional.empty();
        }

       /* List<Equipment> equipments = equipmentRepository.getAll();
        List<Task>  tasks = new ArrayList<>();
        equipments.forEach(new Consumer<Equipment>() {
            @Override
            public void accept(Equipment equipment) {
                for (Task task : equipment.getTasks()) {
                    if(equipment.getType().equals("jetable")&& task.getEndDate().after(task.getDueDate())){
                       tasks.add(task);
                    }
                }
            }
        });*/

        return Optional.of(equipmentRepository.getAll());
    }


}
