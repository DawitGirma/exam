package com.exam.etdm.model;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Entity
@Table(name = "Athletes")
public class Athlete
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long athleteId;



    @NotBlank(message = "* ssn is required")
    @Column(name = "ssn", nullable = false, unique = true)
    private String ssn;


    @NotBlank(message = "* full name is required")
    @Column(name = "fullName", nullable = false)
    private String fullName;

    private String phoneNumber;

    @NotNull(message = "* date of Birth is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "dateofbirth")
    private LocalDate dateOfBirth;



    @NotNull(message = "* date of registration is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "dateOfregisteration")
    private LocalDate dateOfregisteration;


    @NotNull(message = "* number of medal won is required")
    @Column(name = "medalswon", nullable = false)
    private Integer totalNumberOfMedalsWon;

    @NotNull(message = "* salary amount is required")
    @Digits(integer = 9, fraction = 2, message = "* Balance must be a numeric/monetary amount in decimal (money) format such as 'x,xxx.xx'")
    @NumberFormat(pattern = "#,###.##")
    private Double monthlySalary;

    @Column(name = "email")
    private String emailAddress;


    public Athlete()
    {
    }

    public Athlete(@NotBlank(message = "* full name is required") String fullName, String phoneNumber, @NotBlank(message = "* dateofbirth is required") LocalDate dateOfBirth, @NotBlank(message = "* number of medal won is required") Integer totalNumberOfMedalsWon, @NotNull(message = "* salary amount is required") @Digits(integer = 9, fraction = 2, message = "* Balance must be a numeric/monetary amount in decimal (money) format such as 'x,xxx.xx'") Double monthlySalary, String emailAddress) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.totalNumberOfMedalsWon = totalNumberOfMedalsWon;
        this.monthlySalary = monthlySalary;
        this.emailAddress = emailAddress;
    }


    public Long getAthleteId() {
        return athleteId;
    }

    public void setAthleteId(Long athleteId) {
        this.athleteId = athleteId;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public LocalDate getDateOfregisteration() {
        return dateOfregisteration;
    }

    public void setDateOfregisteration(LocalDate dateOfregisteration) {
        this.dateOfregisteration = dateOfregisteration;
    }

    public Integer getTotalNumberOfMedalsWon() {
        return totalNumberOfMedalsWon;
    }

    public void setTotalNumberOfMedalsWon(Integer totalNumberOfMedalsWon) {
        this.totalNumberOfMedalsWon = totalNumberOfMedalsWon;
    }

    public Double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(Double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
