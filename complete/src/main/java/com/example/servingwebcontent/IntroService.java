package com.example.servingwebcontent;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

//this is a bean that we want to use in other classes
@Service
public class IntroService {
    String[] headlineGreeting = new String[4];
    Calendar rightNow = Calendar.getInstance();
    String[] titles = new String[6];
    String[] stories = new String[6];

    //String[] names = new String[5];
    //String[] url_ppl_image = new String[5];

    public IntroService(){
        populateHeadlineGreeting();
        populateTitle();
        populateStory();
    }

    private void populateTitle() {
        titles[0] = "“Chapter V,” Ernest Hemingway";
        titles[1] = "“Give It Up!” Franz Kafka";
        titles[2] = "“Sticks,” George Saunders";
        titles[3] = "“Taylor Swift,” Hugh Behm-Steinberg";
        titles[4] = "“Untitled,” Adhiraj Singh";
        titles[5] = "“Gator Butchering for Beginners,” Kristen Arnett";
    }

    private void populateHeadlineGreeting() {
        headlineGreeting[0] = "Good Morning";
        headlineGreeting[1] = "Good Afternoon";
        headlineGreeting[2] = "Good Evening";
        headlineGreeting[3] = "Honestly? I think you should go to bed. Good Night";
    }


    public int getHour(){
        return rightNow.get(Calendar.HOUR_OF_DAY);
    }

    public int getMinute(){
        return rightNow.get(Calendar.MINUTE);
    }

    // Date formating:
    public String getTimeString() {
        String pattern = "HH:mm";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(new Date());
    }

    public String getDay() {
         int dayNum = rightNow.get(Calendar.DAY_OF_WEEK);
         switch (dayNum) {
             case 1:
                 return "Sunday";
             case 2:
                 return "Monday";
             case 3:
                 return "Tuesday";
             case 4:
                 return "Wednesday";
             case 5:
                 return "Thursday";
             case 6:
                 return "Friday";
             case 7:
                 return "Saturday";
             default:
                 return "Something's wrong!";
         }
    }

    public String getHeadlineGreeting() {
        int hour = getHour();
        int index;

        //select greeting depending on the hour of the day
        if (hour > 5 && hour < 12) {
            index = 0;
        } else if (hour < 18) {
            index = 1;
        } else if (hour < 23) {
            index = 2;
        }
        else {
            index =3;
        }

        return headlineGreeting[index];
    }

//    public String getRandomHeadline(){
//        Random r = new Random();
//        int i = r.nextInt(5);
//        return headlines[i];
//    }
//
//    public String getPeople() {
//        Random r = new Random();
//        int i = r.nextInt(5);
//        return names[i];
//    }
//
//    public String getImageUrl() {
//        return  url_ppl_image[getRandomNum(5)];
//    }

    public int getRandomNum(int num){
        Random r = new Random();
        int i = r.nextInt(num);
        return i;
    }

    private void populateStory() {
        stories[0] = ("They shot the six cabinet ministers " +
                "at half-past six in the morning against the wall of a hospital. " +
                "There were pools of water in the courtyard. There were wet dead " +
                "leaves on the paving of the courtyard. It rained hard. All the " +
                "shutters of the hospital were nailed shut. One of the ministers was " +
                "sick with typhoid. Two soldiers carried him downstairs and out into the rain. " +
                "They tried to hold him up against the wall but he sat down in a puddle of water. " +
                "The other five stood very quietly against the wall. Finally the officer told " +
                "the soldiers it was no good trying to make him stand up. When they fired the " +
                "first volley he was sitting down in the water with his head on his knees.");

        stories[1] = ("It was very early in the morning, the streets clean and deserted, " +
                "I was walking to the station. As I compared the tower clock with my watch " +
                "I realized that it was already much later than I had thought, I had to hurry, " +
                "the shock of this discovery made me unsure of the way, I did not yet " +
                "know my way very well in this town; luckily, a policeman was nearby, " +
                "I ran up to him and breathlessly asked him the way. He smiled and said: " +
                "“From me you want to know the way?” “Yes,” I said, “since I cannot find it myself.”" +
                " “Give it up! Give it up,” he said, and turned away with a sudden jerk, " +
                "like people who want to be alone with their laughter.");

        stories[2] = ("Every year Thanksgiving night we flocked out behind Dad as he dragged " +
                "the Santa suit to the road and draped it over a kind of crucifix he’d built " +
                "out of metal pole in the yard. […] The pole was Dad’s only concession to glee. " +
                "We were allowed a single Crayola from the box at a time. One Christmas Eve " +
                "he shrieked at Kimmie for wasting an apple slice. He hovered over us as we poured " +
                "ketchup saying: good enough good enough good enough. Birthday parties consisted of cupcakes," +
                " no ice cream. The first time I brought a date over she said: what’s with your dad and that pole?" +
                " and I sat there blinking…");

        stories[3] = ("You’re in love; it’s great, you swipe on your phone and order: " +
                "the next day a Taylor Swift clone shows up at your house. " +
                "It’s not awkward, it’s everything you want. She knows all her songs, " +
                "and she sings them just for you. When you put your Taylor Swift to bed " +
                "(early, you got a big day tomorrow) you peek over the fence into " +
                "the Rosenblatt’s yard, and the lights are blazing. Your best friend " +
                "Tina has three Taylor Swifts swimming in her pool. She has a miniature Taylor Swift" +
                " she keeps on a perch, a Taylor Swift with wings. You’re so jealous. " +
                "She’s not even paying attention to them, she’s too busy having sex with " +
                "her other Taylor Swifts, they’re so fucking loud it’s disgusting. You hate Taylor Swift…");

        stories[4] = ("“im sorry, its a girl” said the doctor to the father.\n" +
                "“no, im sorry, youre a sexist” said the girl child to the world.\n");

        stories[5] = ("It’s easy enough to slip the skin. Wedge your knife below the bumpy ridge of spine to " +
                "separate cartilage from fat; loosen tendon from pink, sticky meat. Flay everything open. " +
                "Pry free the heart. It takes some nerve. What I mean is, it’ll hurt, " +
                "but you can get at what you crave if you want it badly enough.\n" +
                "Start with the head…\n");
    }

    public String getTitle(int i) {
        return titles[i];
    }

    public String getStory(int i) {
        return stories[i];
    }

    public ArrayList<Story> getStories() {
        ArrayList<Story> storyList = new ArrayList<>();
        for (int i = 0; i < stories.length; i++) {
            Story story = new Story();
            story.setTitle(titles[i]);
            story.setStory(stories[i]);
            story.setLink("/intro?value=" + i);
            storyList.add(story);
        }
        return storyList;
    }
}