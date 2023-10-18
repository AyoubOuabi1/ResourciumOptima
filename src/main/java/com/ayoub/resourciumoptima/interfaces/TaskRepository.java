package com.ayoub.resourciumoptima.interfaces;

import com.ayoub.resourciumoptima.entities.Task;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface TaskRepository {
    void save(Task obj);

    void delete(Long id);

    void update(Task obj);

    Task findById(Long id);

    List<Task> getAll();
}
