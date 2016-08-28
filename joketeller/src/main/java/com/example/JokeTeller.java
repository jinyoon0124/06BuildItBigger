package com.example;

public class JokeTeller {

    private String[] jokeStrings = {
            "Joe asked God, \"How much is a penny worth in heaven?\"\n" +
            "God replied, \"$1 million.\"\n" +
            "Joe asked, \"How long is a minute in heaven?\"\n" +
            "God said, \"One million years.\"\n" +
            "Joe asked for a penny.\n" +
            "God said, \"Sure, in a minute.\"",

            "You're so stupid that you had to call 411 to get the number for 911.",

            "Q: What has 18 legs and catches flies?\n" +
                    "A: A baseball team.",

            "Q: What did the DNA say to the other DNA?\n" +
                    "A: Do these genes make my butt look fat.",

            "What do you call an honest lawyer?\n" +
                    "An oxymoron."
    };

    public JokeTeller() {
    }

    public String tellJoke(int i){

        return jokeStrings[i];
    }


//
//    public String setJoke(){
//         "CREATED Joke from Java";
//    }
}
