package com.ayoub.resourciumoptima.Services;

import com.ayoub.resourciumoptima.Repositories.DepartmentRepositoryImp;
import com.ayoub.resourciumoptima.Repositories.TaskRepositoryImp;
import com.ayoub.resourciumoptima.entities.Department;
import com.ayoub.resourciumoptima.entities.Task;
import com.ayoub.resourciumoptima.interfaces.DepartmentRepository;
import com.ayoub.resourciumoptima.interfaces.TaskRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

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
            departmentRepository.delete(id);
        }

    }

    public void updateDepartment(Department department) throws Exception {
        if (department != null){
            departmentRepository.update(department);
        }
     }

    public List<Department> getDepartments()  throws NullPointerException{
        return departmentRepository.getAll();
    }


}
