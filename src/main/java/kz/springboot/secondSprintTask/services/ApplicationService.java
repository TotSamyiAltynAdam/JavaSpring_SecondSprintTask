package kz.springboot.secondSprintTask.services;

import kz.springboot.secondSprintTask.entities.ApplicationRequest;

import java.util.List;

public interface ApplicationService {
    ApplicationRequest addApplication(ApplicationRequest application);
    List<ApplicationRequest> getAllApplications();
    List<ApplicationRequest> getAllApplicationsByHandledIsTrue();
    List<ApplicationRequest> getAllApplicationsByHandledIsFalse();
    ApplicationRequest getApplication(Long id);
    void deleteApplication(ApplicationRequest application);
    ApplicationRequest saveApplication(ApplicationRequest application);
}
