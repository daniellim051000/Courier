package courier;

import java.util.*;
import java.io.*;

public class Feedback {
    //define the data attribute in Feedback
    private String feedbackID;
    private String rating;
    private String description;
    //private String feedbackUser;
    private Users feedbackUser;
    private Users feedbackUsername;
  
    public Feedback() {};
    
    public Feedback(String FeedbackID, String Rating, String Description, Users FeedbackUser) {
        //bring the data attribute into the variable
        feedbackID = FeedbackID;
        rating = Rating;
        description = Description;   
        //feedbackUser = FeedbackUser;
        this.feedbackUser = FeedbackUser;
    }
    
    private String getFeedbackid() {
        return feedbackID;
    }
    
    private String getRating() {
        return rating;
    }
    
    private String getDescription() {
        return description;
    }
    
    public Users getFeedbackUser() {
        return feedbackUser;
    }
    
    public Users getFeedbackUsername() {
        return feedbackUsername;
    }
    
    public void setFeedbackid(String Feedbackid) {
        feedbackID = Feedbackid;
    }
    
    public void setRating(String Rating) {
        rating = Rating;
    }
    
    public void setDescription(String Description) {
        description = Description;
    }
    
    public void setFeedbackUser(Users FeedbackUser) {
        feedbackUser = FeedbackUser;
    }
    
    public void setFeedbackUsername(Users FeedbackUsername) {
        this.feedbackUsername = FeedbackUsername;
    }
    
    //cannot submit empty feedback
    public boolean EmptyFeedback() {
        return rating.equals("")||description.equals("");
    }
    
    public boolean UserNotFound() {
        return feedbackUser.equals("");
    }
    
    //save feedback into textfile
    public void SaveFeedback() {
        File Finput = new File("Feedback.txt");
        try{
            FileWriter fw = new FileWriter(Finput,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            
            //Store the data into data base
            String Line = feedbackID + "," + rating + "," + description + ","+ feedbackUser;
            //in the textfile, each data will have one row blank b4 next line
            //use pw to write data you want to write
            pw.write(Line);
            bw.newLine();
            pw.close();
            System.out.println("Data Written.txt");
        } catch (IOException ex) {
             ex.toString();
        }
    }
    
    public String LoadFeedback() {
        File file = new File("Feedback.txt");
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            Object[] feedbacks = br.lines().toArray();
            for (Object feedback : feedbacks) {
                String line = feedback.toString().trim();
                String[] row = line.split(",");
                
                feedbackID = row[0];
                rating = row[1];
                description = row[2];
                sb.append(feedbackID + "," + rating + "," + description + "\n");
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "got error in backend";
    }
}
