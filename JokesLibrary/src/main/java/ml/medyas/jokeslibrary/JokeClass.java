package ml.medyas.jokeslibrary;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Serializable;

public class JokeClass implements Serializable {
    private int id;
    private String type, setup, punchline;

    public JokeClass() {
    }

    public JokeClass(int id, String type, String setup, String punchline) {
        this.id = id;
        this.type = type;
        this.setup = setup;
        this.punchline = punchline;
    }

    public String toJson() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSetup() {
        return setup;
    }

    public void setSetup(String setup) {
        this.setup = setup;
    }

    public String getPunchline() {
        return punchline;
    }

    public void setPunchline(String punchline) {
        this.punchline = punchline;
    }

}
