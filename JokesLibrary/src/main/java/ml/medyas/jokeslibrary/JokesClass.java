package ml.medyas.jokeslibrary;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Random;

public class JokesClass implements Serializable {
    private JokeListClass jokes;
    private Random rand;



    public JokesClass() {
        rand = new Random();
        jokes = new JokeListClass();
        Type listType = new TypeToken<List<JokeClass>>() {
        }.getType();
        Gson gson = new GsonBuilder().create();
        List<JokeClass> l = gson.fromJson(jokesJson, listType);
        jokes.setJokesList(l);
    }

    public JokeClass getRandomJoke() {
        return jokes.getJokesList().get(rand.nextInt(jokes.getJokesList().size()));
    }

    public String getRandomJokeAsString() {
        JokeClass joke = getRandomJoke();
        return joke.getSetup()+" \n"+joke.getPunchline();
    }

    private static final String jokesJson = "[\n" +
            "  {\n" +
            "    \"id\": 1,\n" +
            "    \"type\": \"general\",\n" +
            "    \"setup\": \"What did the fish say when it hit the wall?\",\n" +
            "    \"punchline\": \"Damn.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 2,\n" +
            "    \"type\": \"general\",\n" +
            "    \"setup\": \"How do you make a tissue dance?\",\n" +
            "    \"punchline\": \"You put a little boogie on it.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 3,\n" +
            "    \"type\": \"general\",\n" +
            "    \"setup\": \"What's Forrest Gump's password?\",\n" +
            "    \"punchline\": \"1Forrest1\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 4,\n" +
            "    \"type\": \"general\",\n" +
            "    \"setup\": \"What do you call a belt made out of watches?\",\n" +
            "    \"punchline\": \"A waist of time.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 5,\n" +
            "    \"type\": \"general\",\n" +
            "    \"setup\": \"Why can't bicycles stand on their own?\",\n" +
            "    \"punchline\": \"They are two tired\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 6,\n" +
            "    \"type\": \"general\",\n" +
            "    \"setup\": \"How does a train eat?\",\n" +
            "    \"punchline\": \"It goes chew, chew\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 7,\n" +
            "    \"type\": \"general\",\n" +
            "    \"setup\": \"What do you call a singling Laptop\",\n" +
            "    \"punchline\": \"A Dell\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 8,\n" +
            "    \"type\": \"general\",\n" +
            "    \"setup\": \"How many lips does a flower have?\",\n" +
            "    \"punchline\": \"Tulips\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 8,\n" +
            "    \"type\": \"general\",\n" +
            "    \"setup\": \"How do you organize an outer space party?\",\n" +
            "    \"punchline\": \"You planet\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 9,\n" +
            "    \"type\": \"general\",\n" +
            "    \"setup\": \"What kind of shoes does a thief wear?\",\n" +
            "    \"punchline\": \"Sneakers\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 10,\n" +
            "    \"type\": \"general\",\n" +
            "    \"setup\": \"What's the best time to go to the dentist?\",\n" +
            "    \"punchline\": \"Tooth hurty.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 11,\n" +
            "    \"type\": \"knock-knock\",\n" +
            "    \"setup\": \"Knock knock. \\n Who's there? \\n A broken pencil. \\n A broken pencil who?\",\n" +
            "    \"punchline\": \"Never mind. It's pointless.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 12,\n" +
            "    \"type\": \"knock-knock\",\n" +
            "    \"setup\": \"Knock knock. \\n Who's there? \\n Cows go. \\n Cows go who?\",\n" +
            "    \"punchline\": \"No, cows go moo.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 13,\n" +
            "    \"type\": \"knock-knock\",\n" +
            "    \"setup\": \"Knock knock. \\n Who's there? \\n Little old lady. \\n Little old lady who?\",\n" +
            "    \"punchline\": \"I didn't know you could yodel!\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 14,\n" +
            "    \"type\": \"knock-knock\",\n" +
            "    \"setup\": \"Knock knock. \\n Who's there? \\n Cereal \\n Cereal who?\",\n" +
            "    \"punchline\": \"Cereal pleasure to meet you\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 15,\n" +
            "    \"type\": \"knock-knock\",\n" +
            "    \"setup\": \"Knock knock. \\n Who's there? \\n Harry! \\n Harry who?\",\n" +
            "    \"punchline\": \"Harry up and answer the door!\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 16,\n" +
            "    \"type\": \"knock-knock\",\n" +
            "    \"setup\": \"Knock knock. \\n Who's there? \\n Bless! \\n Bless who?\",\n" +
            "    \"punchline\": \"I didn't sneeze, but thank you.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 17,\n" +
            "    \"type\": \"knock-knock\",\n" +
            "    \"setup\": \"Knock knock. \\n Who's there? \\n Tank \\n Tank who?\",\n" +
            "    \"punchline\": \"You're welcome!\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 18,\n" +
            "    \"type\": \"knock-knock\",\n" +
            "    \"setup\": \"Knock knock. \\n Who's there? \\n Opportunity\",\n" +
            "    \"punchline\": \"... Opportunity doesn't knock twice.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 19,\n" +
            "    \"type\": \"knock-knock\",\n" +
            "    \"setup\": \"Knock knock. \\n Who's there? \\n Alex. \\n Alex who?\",\n" +
            "    \"punchline\": \"ALex the questions around here!\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 20,\n" +
            "    \"type\": \"knock-knock\",\n" +
            "    \"setup\": \"Knock knock. \\n Who's there? \\n Hawaii. \\n Hawaii who?\",\n" +
            "    \"punchline\": \"I'm fine, Hawaii you?\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 21,\n" +
            "    \"type\": \"programming\",\n" +
            "    \"setup\": \"What's the best thing about a Boolean?\",\n" +
            "    \"punchline\": \"Even if you're wrong, you're only off by a bit.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 22,\n" +
            "    \"type\": \"programming\",\n" +
            "    \"setup\": \"What's the object-oriented way to become wealthy?\",\n" +
            "    \"punchline\": \"Inheritance\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 23,\n" +
            "    \"type\": \"programming\",\n" +
            "    \"setup\": \"Where do programmers like to hangout?\",\n" +
            "    \"punchline\": \"The Foo Bar.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 24,\n" +
            "    \"type\": \"programming\",\n" +
            "    \"setup\": \"Why did the programmer quit his job?\",\n" +
            "    \"punchline\": \"Because he didn't get arrays.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 25,\n" +
            "    \"type\": \"programming\",\n" +
            "    \"setup\": \"What do you call a programmer from Finland?\",\n" +
            "    \"punchline\": \"nerdic\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 26,\n" +
            "    \"type\": \"programming\",\n" +
            "    \"setup\": \"A SQL query goes into a bar, walks up to two tables and ask...\",\n" +
            "    \"punchline\": \"Can I join you?\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 27,\n" +
            "    \"type\": \"programming\",\n" +
            "    \"setup\": \"How many programmers does it take to change a light bulb?\",\n" +
            "    \"punchline\": \"None, that's a hardware problem.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 28,\n" +
            "    \"type\": \"programming\",\n" +
            "    \"setup\": \"To understand what recursion is...\",\n" +
            "    \"punchline\": \"... you must first understand recursion.\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 29,\n" +
            "    \"type\": \"programming\",\n" +
            "    \"setup\": \"A foo walks into a bar, takes a look around and says...\",\n" +
            "    \"punchline\": \"Hello, World!\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": 30,\n" +
            "    \"type\": \"programming\",\n" +
            "    \"setup\": \"Two bytes meet. The first byte asks, \\\"Are you ill?\\\"\",\n" +
            "    \"punchline\": \"The second byte replies, \\\"No, just feeling a bit off.\\\"\"\n" +
            "  }\n" +
            "]\n";
}
