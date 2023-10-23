package com.ayoub.resourciumoptima.Services;

import com.ayoub.resourciumoptima.Repositories.DepartmentRepositoryImp;
import com.ayoub.resourciumoptima.Repositories.TaskRepositoryImp;
import com.ayoub.resourciumoptima.entities.Department;
import com.ayoub.resourciumoptima.entities.Task;
import com.ayoub.resourciumoptima.interfaces.DepartmentRepository;
import com.ayoub.resourciumoptima.interfaces.TaskRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class DepartmentService {

    //@Inject
    private DepartmentRepository departmentRepository;

    public DepartmentService(){
        departmentRepository=new DepartmentRepositoryImp();
    }


    public Department findDepartment(Long id) throws NullPointerException {
        return departmentRepository.findById(id);
    }

    public Department saveDepartment(Department department) {
        if (department != null){
            departmentRepository.save(department);
        }
        return department;

    }

    public void removeDepartment(Long id) throws Exception {
        if (id != null){
            Department department = findDepartment(id);
            if (department != null){
                departmentRepository.delete(department);
            }

        }

    }

    public void updateDepartment(Department department) throws Exception {
        if (department != null){
            departmentRepository.update(department);
        }
     }

    public Optional<List<Department>> getDepartments()  throws NullPointerException{
        if(departmentRepository.getAll().size() == 0){
            return Optional.empty();
        }
        return Optional.of(departmentRepository.getAll());
    }


}
