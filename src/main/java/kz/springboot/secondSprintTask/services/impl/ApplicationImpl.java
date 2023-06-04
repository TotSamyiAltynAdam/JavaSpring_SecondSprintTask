package kz.springboot.secondSprintTask.services.impl;

import kz.springboot.secondSprintTask.entities.ApplicationRequest;
import kz.springboot.secondSprintTask.repositories.ApplicationRepository;
import kz.springboot.secondSprintTask.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationImpl implements ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public ApplicationRequest addApplication(ApplicationRequest application) {
        return applicationRepository.save(application);
    }

    @Override
    public List<ApplicationRequest> getAllApplications() {
        return applicationRepository.findAll();
    }

    @Override
    public List<ApplicationRequest> getAllApplicationsByHandledIsTrue() {
        return applicationRepository.findAllByHandledIsTrue();
    }

    @Override
    public List<ApplicationRequest> getAllApplicationsByHandledIsFalse() {
        return applicationRepository.findAllByHandledIsFalse();
    }

    @Override
    public ApplicationRequest getApplication(Long id) {
        return applicationRepository.getOne(id);
    }

    @Override
    public void deleteApplication(ApplicationRequest application) {
        applicationRepository.delete(application);
    }

    @Override
    public ApplicationRequest saveApplication(ApplicationRequest application) {
        return applicationRepository.save(application);
    }
}
