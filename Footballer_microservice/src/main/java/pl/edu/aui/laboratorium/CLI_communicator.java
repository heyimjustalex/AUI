package pl.edu.aui.laboratorium;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.edu.aui.laboratorium.Entity.Coach;
import pl.edu.aui.laboratorium.Service.CoachService;
import pl.edu.aui.laboratorium.Entity.Footballer;
import pl.edu.aui.laboratorium.Service.FootballerService;
import java.util.*;


@Component
public class CLI_communicator implements CommandLineRunner {
    private final Scanner scanner = new Scanner(System.in);
    private CoachService coachService;
    private FootballerService footballerService;


    @Autowired
    public void CLI_communicator(CoachService coachService, FootballerService footballerService)
    {
        this.coachService = coachService;
        this.footballerService = footballerService;
    }

    @Override
    public void run(String... args) throws Exception {
        boolean foo = true;
        while (foo) {
            System.out.println("Write number to call API \n1. Print all Coaches\n2. Print all footballers \n3. Delete coach by id\n4. Delete footballer by id\n5. CreateAndSaveFootballer\n6. CreateAndSaveCoach");
            String number = scanner.nextLine();
            switch (number) {
                case "1" : printCoaches();
                break;
                case "2" : printFootballers();
                break;
              //  case "3" -> deleteCoachById();
              //  case "4" -> deleteFootballerById();
              //  case "5" -> createAndSaveFootbaler();
              //  case "6" -> createAndSaveCoach();

           }
        }

    }

    void printCoaches()
    {
        List <Coach> coaches = coachService.findAll();
        for (Coach coach:coaches) {
            System.out.println(coach.toString());
        }
    }

    void printFootballers()
    {
        List<Footballer> footballers = footballerService.findAll();

        for (Footballer footballer:footballers) {
            System.out.println(footballer.toString());
        }
    }

    void deleteCoachById()
    {
        System.out.println("\nWrite ID of object");
        String id = scanner.nextLine();

        try {
            int temp = Integer.parseInt(id);
            Optional<Coach> coach = coachService.find(temp);

            if (!coach.isEmpty()) {
                Coach tempCoach = coach.orElse(new Coach());
                coachService.delete(tempCoach);
                System.out.println("Deleted object:" + tempCoach.toString() + "\n");
            } else {
                System.out.println("Such entity does not exist\n");
            }
        }
        catch (Exception e)
        {
            System.out.println("Wrong ID format\n");
        }
        
    }

    void deleteFootballerById()
    {
        System.out.println("\nWrite ID of object");
        String id = scanner.nextLine();

        try{
            Integer temp = Integer.parseInt(id);
            Optional<Footballer> footballer = footballerService.find(temp);

            if(!footballer.isEmpty())
            {
                Footballer tempFootballer = footballer.orElse(new Footballer());
                footballerService.delete(tempFootballer);
                System.out.println("Deleted object:"+tempFootballer.toString()+"\n");
            }
            else
            {
                System.out.println("Such entity does not exist\n");
            }
        }
        catch (Exception e)
        {
            System.out.println("Wrong ID format\n");
        }
    }

    void createAndSaveFootbaler()
    {
        System.out.println("Name ");
        String name = scanner.nextLine();
        System.out.print("Surname: ");
        String surname = scanner.nextLine();
        System.out.print("Position: ");
        String position = scanner.nextLine();
        System.out.print("Coach ID: ");
        String coachId = scanner.nextLine();

        try{
            int temp = Integer.parseInt(coachId);
            Optional<Coach> coach = coachService.find(temp);

            if (!coach.isEmpty()) {
                Coach tempCoach = coach.orElse(new Coach());
                Footballer footballer = new Footballer(name,surname,position,tempCoach);
                footballerService.save(footballer);
            }
            else {
                System.out.println("Coach entity does not exist\n");
            }
        }
        catch (Exception e)
        {
            System.out.println("Bad ID format\n");
        }



    }

    void createAndSaveCoach()
    {
        System.out.println("Name ");
        String name = scanner.nextLine();
      //  System.out.print("Surname: ");
       // String surname = scanner.nextLine();

        try{
            Coach coachTemp = new Coach(name);
            coachService.save(coachTemp);

        }
        catch (Exception e)
        {
            System.out.println("Couldnt add Coach\n");
        }

    }
}

