package com.exam.etdm.service.impl;

import com.exam.etdm.model.Athlete;
import com.exam.etdm.repository.AthleteRepository;
import com.exam.etdm.service.AthleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AthleteServiceImpl implements AthleteService
{
    @Autowired
    AthleteRepository athleteRepository;

    @Override
    public List<Athlete> getAllAthletesPaged() {
        return athleteRepository.findAll(Sort.by("fullName"));
    }

    @Override
    public Athlete saveAthlete(Athlete athlete) {
        return athleteRepository.save(athlete);
    }

    @Override
    public List<Athlete> getEliteAthletesList()
    {



        List<Athlete> athletes = athleteRepository.findAll().stream().filter(ath -> ath.getTotalNumberOfMedalsWon() >= 3).filter(ath -> (ath.getDateOfregisteration().getYear() <= LocalDate.now().getYear() - 5) ).collect(Collectors.toList());


        List <Athlete> refined = new ArrayList<Athlete>(athletes);

        for(Athlete a : refined)
        {
            if(a.getDateOfregisteration().getYear() == LocalDate.now().getYear() - 5)
            {
                if(a.getDateOfregisteration().getMonth().getValue() >= LocalDate.now().getMonth().getValue())
                {
                    refined.remove(a);
                }

            }

        }


        return refined;





    }
}
