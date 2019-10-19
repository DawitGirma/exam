package com.exam.etdm.service;

import com.exam.etdm.model.Athlete;

import java.util.List;

public interface AthleteService
{
    public abstract List<Athlete> getAllAthletesPaged();
    public abstract Athlete saveAthlete(Athlete athlete);
    public abstract List<Athlete> getEliteAthletesList();

}
