package com.ztbd.sportsfacility.service;

import com.ztbd.sportsfacility.dao.StaticTextRepository;
import com.ztbd.sportsfacility.model.StaticText;
import com.ztbd.sportsfacility.model.StaticTextId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StaticTextServiceImpl implements StaticTextService {

    @Autowired
    private StaticTextRepository staticTextRepository;

    @Override
    public void deleteStaticText(StaticTextId id) {
        staticTextRepository.deleteById(id);
    }

    @Override
    public void saveStaticText(StaticText staticText) {
        staticTextRepository.save(staticText);
    }

    @Override
    public StaticText getStaticText(StaticTextId id) {
        return staticTextRepository.findById(id).orElse(null);
    }

    @Override
    public List<StaticText> getStaticTexts() {
        List<StaticText> staticTexts = new ArrayList<>();
        staticTextRepository.findAll().forEach(e -> staticTexts.add(e));
        return staticTexts;
    }
}
