package pl.edu.aui.laboratorium;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.edu.aui.laboratorium.Entity.Coach;
import pl.edu.aui.laboratorium.Service.CoachService;

import java.util.*;


@Component
public class CLI_communicator implements CommandLineRunner {
    private final Scanner scanner = new Scanner(System.in);
    private CoachService coachService;



    @Autowired
    public void CLI_communicator(CoachService coachService)
    {
        this.coachService = coachService;

    }

    @Override
    public void run(String... args) throws Exception {
        boolean foo = true;
        while (foo) {
            System.out.println("Write number to call API \n1. Print all Coaches\n2. Delete coach by id\n3. CreateAndSaveCoach");
            String number = scanner.nextLine();
            switch (number) {
                case "1" -> printCoaches();
                case "2" -> deleteCoachById();
                case "3" -> createAndSaveCoach();

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




    void createAndSaveCoach()
    {
        System.out.println("Name ");
        String name = scanner.nextLine();
        System.out.print("Surname: ");
        String surname = scanner.nextLine();

        try{
            Coach coachTemp = new Coach(name,surname);
            coachService.save(coachTemp,false);

        }
        catch (Exception e)
        {
            System.out.println("Couldnt add Coach\n");
        }

    }
}

