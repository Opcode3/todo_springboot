package com.giembs.todo;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReadJson {

    private String jsonFileURL = "state.json";

    @Data
    private class States{
        private String name;
        private String alias_name;
        private String[] lgas;
    }

    public ReadJson(){
        System.out.println("HIM GO SOON RUN!");
        JSONParser jsonParser = new JSONParser();


        {
            try {
                Object object = jsonParser.parse(new FileReader(jsonFileURL));
                JSONArray states = (JSONArray) object;

                for(Object state : states){
                    Map<?,?> itState = (Map<?, ?>) state;
//                    System.out.println(itState);
                    System.out.println(itState.get("state"));
                    System.out.println(itState.get("lgas"));

                    List<String>  lgas = (ArrayList) itState.get("lgas");
                    System.out.println(lgas.get(0));
                }
            } catch (ParseException e) {
                throw new RuntimeException(e);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
