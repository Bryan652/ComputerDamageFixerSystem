
package computerdamagereportsystem;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bryan
 */

abstract class school {
    String[][] roomComputers = new String[7][21];
    
    void roomComponents() {
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 21; j++) {
                    roomComputers[i][j] = "computer" + j;
            }
        }
    }
    
    public abstract void students();
    
    public abstract void studentReports();
    
    void view() {
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 21; j++) {
                if(i > 0  && j > 0) {
                    System.out.println(roomComputers[i][j]);
                }
            }
        }
    }
    
    public abstract void fixDamageComputers();
}

class reports extends school{
    
    private boolean dayReset = true; // reset the day and report new damaged computers
    private int randomHour = 0; 
    private int randomSecond = 0;  // for the time where students will report the damaged computers
    private int randomMinute = 0;
    private int[][] reports = new int[5][3]; // this is where the time will be assign for the damaged computers
    private String[] studentReporter = new String[5];  // thsi is the students who will report the damaged computers
    private int hour = 0;
    private int minute = 0; // for the time of the day
    private int second = 0;
    private int studentClassCount = 6; // for the section count
    private int[][] fixDayTime = new int[5][3]; // this is where i assign when the computers will be fix
    private String[][] computers = new String[6][20]; // this is whhere to assign when a computer is damaged or in a good condition
    private int randomSection;
    private int[] sectionWithDamagedComputers = new int[6];
    String[][] sections;
    String[] studentRandomNames = {"Bryan", "Psalmuelle", "Jet", "Rafael", "Acob", "Kurt", "Alice", "Bob", "Charlie", "David", "Emma", "Frank", "Grace", "Henry", "Ivy", "Jack",
                                   "Kate", "Liam", "Mia", "Noah", "Olivia", "Peter", "Quinn", "Rachel", "Sam", "Taylor", "Ursula", "Victor", "Wendy", "Xander", "Yvonne", "Zack", "Anna", 
                                   "Ben", "Catherine", "Daniel", "Eva", "George", "Hannah", "Ian", "Jessica", "Kevin", "Lucy", "Michael", "Natalie", "Oscar", "Penelope", "Quentin", "Riley", 
                                   "Samantha", "Thomas", "Uma", "Violet", "William", "Xenia", "Yolanda", "Zoe"};
    
    public void students() {
        sections = new String[studentClassCount][];
        for (int i = 1; i < studentClassCount; i++) {
            int classRandomizer = (int)(Math.random() * 20);
            if(classRandomizer < 17) {
                i--;
            } else{
                sections[i] = new String[classRandomizer];
                for (int j = 0; j < classRandomizer; j++) {
                    int studentNameRandomizer = (int)(Math.random() * 57);
                    sections[i][j] = "section #"+i +": "+ studentRandomNames[studentNameRandomizer];
                }
            }
        }
        
        for (int i = 1; i < 6; i++) {
            for (int j = 0; j < 20; j++) {
                computers[i][j] = "Good"; //set the value of computers condition 
            }
        }
    }
    
    public void studentReports() {
        
        while(true) {
            
            while (true) {
                
                if(dayReset) { // day reset is a new day starting at 00|00|00
                System.out.println("Future reports of students\nThis will reset after 24 hours\n");
                for (int i = 0; i < 5; i++) {
                        randomHour = (int)(Math.random() * 8 + 9);
                        randomSecond = (int)(Math.random() * 60 + 1); // for report time
                        randomMinute = (int)(Math.random() * 60 + 1);
                        
                        randomSection = (int)(Math.random() * 5 + 1);
                        int randomStudent = (int)(Math.random() * 16);
                        
                        studentReporter[i] = sections[randomSection][randomStudent] + " computer damaged report";
                        sectionWithDamagedComputers[i] = randomSection;
                        
                        reports[i][2] = randomSecond;
                        reports[i][1] = randomMinute;  // set random time for when to report a damaged computer
                        reports[i][0] = randomHour;
                }
                
                for (int i = 1; i < 6; i++) {
                    int randomCountDamagedComputers = (int)(Math.random() * 5); // create a random value to 5
                    for (int j = 0; j < randomCountDamagedComputers; j++) { // assign it into a loop
                        int randomDamagedComputers = (int)(Math.random() * 20); // create a randomizer for computers that will be damaged
                        computers[i][randomDamagedComputers] = "Damaged"; // assign that value of randomizer that will be damaged
                    }
                }
                
                for (int i = 0; i < studentReporter.length; i++) {
                    System.out.print(studentReporter[i] + " Timed of report : ");
                    System.out.print(reports[i][0] + ":" + reports[i][1] + ":" + reports[i][2]);
                    int damagedComputers = 0;
                    for (int j = 0; j < 20; j++) {
                        if(computers[i+1][j].contains("Damaged")) {
                            damagedComputers++;
                        }
                    }
                    System.out.print("\nDamaged computerds: " + damagedComputers);
                    System.out.println("\n");
                }
                System.out.println("///\nWhen the timer hits the time they are assign they will be displayed\nFor our future project we will implement this simulation\n"
                                   + "to make a Damage/Fixing Computer Simulation for our school\n///\n");
                
                fixDamageComputers(); // call the method of when the computer will be fixed
                
                dayReset = false; // reset it to false so it wont go back to 00|00|00
                }
                
                
                for (int i = 0; i < 5; i++) {
                    if(reports[i][0] == second && reports[i][1] == minute && reports[i][2] == hour) {
                        System.out.print(studentReporter[i] + " Timed of report : ");
                        System.out.print(reports[i][0] + ":" + reports[i][1] + ":" + reports[i][2]); // this is just for the confirmation that the informations are assign
                        System.out.println("\n\n\n");
                    }  
                }
                
                try {
                    Thread.sleep(1000); // Sleep for 1 second
                } catch (InterruptedException ex) {
                    Logger.getLogger(reports.class.getName()).log(Level.SEVERE, null, ex);
                }
                second++;
                if (second == 60) { 
                    second = 0;
                    minute++;
                    if (minute == 60) {
                        minute = 0;
                        hour++;
                        if (hour == 24) {
                        hour = 0; // Reset hour to 0 for 24-hour format
                        dayReset = true; // if this goes to 24|00|00 the day will go back to 00|00|00
                        }
                    }
                }
            
            if(second == 1) {
                System.out.println("HH/mm/ss"); // for indication of the time
            }
            System.out.printf("%02d:%02d:%02d%n", hour, minute, second); // Print time in HH:mm:ss format
            } 
        }
    }
    
    public void fixDamageComputers() {
        for (int i = 0; i < 5; i++) {
                // make a random time of when to fix a computer and then have a 10 min of time to fix that computer
                // chance of failing
                fixDayTime[i][2] = reports[i][2] + 20; 
                if(fixDayTime[i][2] > 60) { // this will ensure the it doesnt go over 60
                    fixDayTime[i][2] = 0;
                    fixDayTime[i][1]++; // adds minute if it goes over 60
                }
                fixDayTime[i][1] = reports[i][1] + 10;
                if(fixDayTime[i][1] > 60) { // this will ensure the it doesnt go over 60
                    fixDayTime[i][1] = 0;
                    fixDayTime[i][0]++; // adds hour if it goes over 60
                }
                fixDayTime[i][0] = reports[i][0];
        }
        
        System.out.println("Report of when the damage computers will be fix");
        for (int i = 0; i < 5; i++) {
            System.out.println("Damaged computers will be fix at : " + fixDayTime[i][0] + ":" + fixDayTime[i][1] + ":"+ fixDayTime[i][2]); // just for viewing
        }
        System.out.println("\n\n");
    }
}

public class allComponents {
    reports reports1 = new reports();
    Login login1 = new Login();
    AmiggasFiles amiggasF = new AmiggasFiles();
    {
        try {
            amiggasF.confidential();
        } catch (Exception e) {
            
        }
        
        login1.signIn();
        reports1.roomComponents();
        reports1.students();
        reports1.studentReports();
        reports1.view();
    }
}
