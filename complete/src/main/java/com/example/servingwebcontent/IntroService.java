package com.example.servingwebcontent;
import com.sun.xml.internal.fastinfoset.util.StringArray;
import org.springframework.stereotype.Service;
import java.util.Random;

//this is a bean that we want to use in other classes
@Service
public class IntroService {
    String[] headlineGreeting = new String[4];
    //String[] names = new String[5];
    //String[] url_ppl_image = new String[5];

    public IntroService(){
        populateHeadlineGreeting();
      //  populateNames();
      //  populateUrlPplImage();
    }

    private void populateHeadlineGreeting() {
        headlineGreeting[0] = "Good Morning";
        headlineGreeting[1] = "Good Afternoon";
        headlineGreeting[2] = "Good Evening";
        headlineGreeting[3] = "Honestly? I think you should go to bed. Good Night";
    }

//    private void populateUrlPplImage() {
//        url_ppl_image[0] = "https://www.wikihow.com/images/thumb/d/d5/Be-Random-Step-8.jpg/v4-460px-Be-Random-Step-8.jpg.webp";
//        url_ppl_image[1] = "https://picsum.photos/id/237/200/300";
//        url_ppl_image[2] = "https://picsum.photos/seed/picsum/200/300";
//        url_ppl_image[3] = "https://picsum.photos/200/300?grayscale";
//        url_ppl_image[4] = "https://picsum.photos/200/300/?blur";
//    }

//    private void populateNames() {
//        names[0] = "Panos";
//        names[1] = "Ryan";
//        names[2] = "Mary";
//        names[3] = "Jack";
//        names[4] = "Steven";
//
//    }

    public getTime() {
        DateTime dt = new DateTime();  // current time
        int month = dt.getMonth();     // gets the current month
        int hours = dt.getHourOfDay(); // gets hour of day
    }

    public String getRandomHeadline(){
        Random r = new Random();
        int i = r.nextInt(5);
        return headlines[i];
    }

    public String getPeople() {
        Random r = new Random();
        int i = r.nextInt(5);
        return names[i];
    }

    public String getImageUrl() {
        return  url_ppl_image[getRandomNum(5)];
    }

    public int getRandomNum(int num){
        Random r = new Random();
        int i = r.nextInt(num);
        return i;
    }
}