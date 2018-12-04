package com.ztbd.sportsfacility.service;

import com.ztbd.sportsfacility.model.StaticText;
import com.ztbd.sportsfacility.model.StaticTextId;

import java.util.List;

public interface StaticTextService {
    void deleteStaticText(StaticTextId id);
    void saveStaticText(StaticText staticText);
    StaticText getStaticText(StaticTextId id);
    List<StaticText> getStaticTexts();
}
