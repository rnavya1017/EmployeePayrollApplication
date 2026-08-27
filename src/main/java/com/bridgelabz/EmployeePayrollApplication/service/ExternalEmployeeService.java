package com.bridgelabz.EmployeePayrollApplication.service;


import com.bridgelabz.EmployeePayrollApplication.exception.ExternalServiceException;
import com.bridgelabz.EmployeePayrollApplication.responsedto.ExternalEmployeeDTO;
import com.bridgelabz.EmployeePayrollApplication.responsedto.ExternalUserResponseDTO;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ExternalEmployeeService {

    private final WebClient webClient;

    public ExternalEmployeeService(WebClient webClient) {
        this.webClient = webClient;
    }

    public ExternalEmployeeDTO getExternalEmployee(Long employeeId) {

        try {

            ExternalUserResponseDTO externalUser =
                    webClient
                            .get()
                            .uri("/users/{id}", employeeId)
                            .retrieve()
                            .onStatus(
                                    HttpStatusCode::isError,
                                    response ->
                                            response.createException()
                            )
                            .bodyToMono(
                                    ExternalUserResponseDTO.class
                            )
                            .block();

            if (externalUser == null) {

                throw new ExternalServiceException(
                        "No employee data received from external service"
                );
            }

            return convertToExternalEmployeeDTO(externalUser);

        } catch (ExternalServiceException exception) {

            throw exception;

        } catch (Exception exception) {

            throw new ExternalServiceException(
                    "Failed to communicate with external employee service",
                    exception
            );
        }
    }

    private ExternalEmployeeDTO convertToExternalEmployeeDTO(
            ExternalUserResponseDTO externalUser) {

        String fullName =
                externalUser.getFirstName()
                        + " "
                        + externalUser.getLastName();

        String department = null;
        String designation = null;

        if (externalUser.getCompany() != null) {

            department =
                    externalUser
                            .getCompany()
                            .getDepartment();

            designation =
                    externalUser
                            .getCompany()
                            .getTitle();
        }

        String city = null;
        String state = null;
        String country = null;

        if (externalUser.getAddress() != null) {

            city =
                    externalUser
                            .getAddress()
                            .getCity();

            state =
                    externalUser
                            .getAddress()
                            .getState();

            country =
                    externalUser
                            .getAddress()
                            .getCountry();
        }

        return new ExternalEmployeeDTO(
                externalUser.getId(),
                fullName,
                externalUser.getEmail(),
                externalUser.getPhone(),
                department,
                designation,
                city,
                state,
                country
        );
    }
}