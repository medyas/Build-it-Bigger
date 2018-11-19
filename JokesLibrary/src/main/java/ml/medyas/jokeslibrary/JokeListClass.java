package ml.medyas.jokeslibrary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class JokeListClass implements Serializable{
    private List<JokeClass> jokesList = new ArrayList<>();

    public JokeListClass() {
    }

    public JokeListClass(List<JokeClass> jokesList) {
        this.jokesList = jokesList;
    }

    public List<JokeClass> getJokesList() {
        return jokesList;
    }

    public void setJokesList(List<JokeClass> jokesList) {
        this.jokesList = jokesList;
    }

}
