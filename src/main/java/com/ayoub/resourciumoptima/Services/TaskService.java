package com.ayoub.resourciumoptima.Services;

import com.ayoub.resourciumoptima.Repositories.EmployeeRepositoryImp;
import com.ayoub.resourciumoptima.Repositories.TaskRepositoryImp;
import com.ayoub.resourciumoptima.entities.Employee;
import com.ayoub.resourciumoptima.entities.Task;
import com.ayoub.resourciumoptima.interfaces.EmployeeRepository;
import com.ayoub.resourciumoptima.interfaces.TaskRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class TaskService {

    //@Inject
    private TaskRepository taskRepository;

    public TaskService(){
        taskRepository=new TaskRepositoryImp();
    }


    public Task findTask(Long id) throws NullPointerException {
        return taskRepository.findById(id);
    }

    public void saveTask(Task task) {
        if (task != null){
            taskRepository.save(task);
        }

    }

    public void removeTask(Long id) throws Exception {
        if (id != null){
            taskRepository.delete(id);
        }

    }

    public void updateTask(Task task) throws Exception {
        if (task != null){
            taskRepository.update(task);
        }
     }

    public Optional<List<Task>> getTasks()  throws NullPointerException{
        if(taskRepository.getAll().size()>0){
            return Optional.of(taskRepository.getAll());
        }
        return Optional.of(taskRepository.getAll());
    }


}
