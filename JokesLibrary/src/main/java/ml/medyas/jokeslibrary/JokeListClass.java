package ml.medyas.jokeslibrary;

import java.util.ArrayList;
import java.util.List;

public class JokeListClass {
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




    /*
    ** -------------------------------------------------------------------------------------------------- **
     */

    public class JokeClass {
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
}
