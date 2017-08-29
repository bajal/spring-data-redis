package com.mohbajal.demo.controllers;

import com.mohbajal.demo.dao.DictionaryDao;
import com.mohbajal.demo.model.DictionaryEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Bajal on 8/27/2017.
 */
@RestController
@RequestMapping("/redis")
public class DataController {

    @Autowired
    DictionaryDao dictionaryDao;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public void addWord(@RequestBody DictionaryEntry dictionaryEntry) {
        dictionaryDao.addWordWithItsMeaningToDictionary( dictionaryEntry.getWord() , dictionaryEntry.getMeaning());
    }

    @RequestMapping(value = "lookup", method = RequestMethod.POST)
    @ResponseBody
    public Map<Object, Object> getMeanings(@RequestBody String word) {
        return dictionaryDao.getAllTheMeaningsForAWord(word);
    }
}
