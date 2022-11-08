package com.dao;

import com.domain.*;
import com.memorydao.MemoryInitializer;

import java.text.ParseException;
import java.util.ArrayList;

public class Initializer {

    public static Initializer initializer;

    public static void init(){
        initializer = new MemoryInitializer();
    }

    public void prepareData() throws WrongValueException, IllegalArgumentException, ParseException {

        // Subteams
        Subteam photography = new Subteam("Photograph", new ArrayList<>());
        Subteam kitchen = new Subteam("Kitchen", new ArrayList<>());

        // Users
        UserDAO userDAO = getUserDAO();

        // SM
        ArrayList<Subteam> smSubteams = new ArrayList<Subteam>();
        smSubteams.add(kitchen);
        PSManager sManager = new PSManager("Natalie", new char[]{'1', '2', '3'}, UserRole.SM, smSubteams);
        userDAO.save(sManager);
        kitchen.setPsManager(sManager);

        // PM
        ArrayList<Subteam> pmSubteams = new ArrayList<Subteam>();
        pmSubteams.add(photography);
        PSManager pManager = new PSManager("Jack", new char[]{'1', '2', '3'}, UserRole.PM, pmSubteams);
        userDAO.save(pManager);
        photography.setPsManager(pManager);

        // Subteam member 1
        SubteamMember subteamMember1 = new SubteamMember("Tobias", new char[]{'1', '2', '3'}, UserRole.SubteamP, photography);
        photography.addMember(subteamMember1);

        SubteamMember subteamMember12 = new SubteamMember("Magdalena", new char[]{'1', '2', '3'}, UserRole.SubteamP, photography);
        photography.addMember(subteamMember12);
        //Subteam member 2
        SubteamMember subteamMember2 = new SubteamMember("Helen", new char[]{'1', '2', '3'}, UserRole.SubteamS, kitchen);
        kitchen.addMember(subteamMember2);

        // Subteams
        userDAO.save(subteamMember1); // Tobias the photographer
        userDAO.save(subteamMember2); // Helen the Chef

        // Customer Service
        userDAO.save(new Manager("Sarah", new char[]{'1', '2', '3'}, UserRole.CS));
        // Senior Customer Service
        userDAO.save(new Manager("Janet", new char[]{'1', '2', '3'}, UserRole.SCS));
        // Financial Manager
        userDAO.save(new Manager("Alice", new char[]{'1', '2', '3'}, UserRole.FM));
        //Administration Manager
        userDAO.save(new Manager("Mike", new char[]{'1', '2', '3'}, UserRole.Adm));

        //  HR
        userDAO.save(new Manager("Simon",  new char[]{'1', '2', '3'}, UserRole.HR));

        // Customers
        Customer customer1 = new Customer("Anna", "1234567", "King 12");
        Customer customer2 = new Customer("Tomas", "1234567", "King 11");

        getCustomerDAO().save(customer1);
        getCustomerDAO().save(customer2);
        getCustomerDAO().save(new Customer("Olivia", "1234567", "King 11"));

        String date1 = "10/10/2023";
        String date2 = "14/10/2023";

        EventRequest eventRequest1 = new EventRequest(1, customer1, "Party", date1, date2, "100", new ArrayList<>(), "1000");

        EventRequest eventRequest2 = new EventRequest(2, customer2, "Wedding", date1, date2, "500", new ArrayList<>(), "5000");
        getEventRequestDAO().save(eventRequest1);
        getEventRequestDAO().save(eventRequest2);


        EventRequest eventRequestSCS = new EventRequest(3, customer1, "Small Birthday Party", date1, date2, "100", new ArrayList<>(), "1000");
        eventRequestSCS.setState(States.SCS_REJECTED);
        getEventRequestDAO().save(eventRequestSCS);

        // FM state
        EventRequest eventRequestFM = new EventRequest(4, customer1, "Birthday Party", date1, date2, "100", new ArrayList<>(), "1000");
        eventRequestFM.setState(States.FM);
        eventRequestFM.setFinancialComments("The expected budget is ok");
        getEventRequestDAO().save(eventRequestFM);


        // Approved
        EventRequest eventRequestAdmin = new EventRequest(5, customer1, "Home Party", date1, date2, "100", new ArrayList<>(), "1000");
        eventRequestAdmin.setFinancialComments("The expected budget is ok");
        eventRequestAdmin.setState(States.ADMIN);
        getEventRequestDAO().save(eventRequestAdmin);

        // Rejected
        EventRequest eventRequestAdmin2 = new EventRequest(6, customer1, "Small Party", date1, date2, "100", new ArrayList<>(), "1000");
        eventRequestAdmin2.setFinancialComments("The expected budget is too low");
        eventRequestAdmin2.setState(States.ADMIN_REJECTED);
        getEventRequestDAO().save(eventRequestAdmin2);

        // SCS
        EventRequest eventRequestSCSEndRejected = new EventRequest(7, customer1, "Small Wedding", date1, date2, "100", new ArrayList<>(), "1000");
        eventRequestSCSEndRejected.setFinancialComments("The expected budget is very low");
        eventRequestSCSEndRejected.setState(States.FM_REJECTED);
        getEventRequestDAO().save(eventRequestSCSEndRejected);

        EventRequest eventRequestSCSEndBack = new EventRequest(8, customer1, "Panigiri", date1, date2, "100", new ArrayList<>(), "10000");
        eventRequestSCSEndBack.setFinancialComments("Good !");
        eventRequestSCSEndBack.setState(States.SCS_BACK);
        getEventRequestDAO().save(eventRequestSCSEndBack);

        EventRequest eventRequestSCSEnd = new EventRequest(9, customer1, "Super Wedding", date1, date2, "100", new ArrayList<>(), "10000");
        eventRequestSCSEnd.setFinancialComments("The expected budget is good");
        eventRequestSCSEnd.setState(States.SCS_END);
        getEventRequestDAO().save(eventRequestSCSEnd);

        EventRequest eventRequestSCSEnd2 = new EventRequest(10, customer2, "Super party", date1, date2, "100", new ArrayList<>(), "1000");
        eventRequestSCSEnd2.setFinancialComments("The expected budget is very good");
        eventRequestSCSEnd2.setState(States.SCS_END);
        getEventRequestDAO().save(eventRequestSCSEnd2);


        // Events:
        Event event1 = new Event(eventRequestSCSEnd, "A super wedding near the beach", 99999, "Pink flowers inside the church", "Red wine, fruits and chocolate", "Filming the whole wedding day", "jaz", "-", "-", "-", 99999);
        Event event2 = new Event(eventRequestSCSEnd2, "A super party at a park", 1000, "many balloons!", "Cakes and chips", "Photos", "Dance", "-", "-", "-", 1000);
        eventRequestSCSEnd.setEvent(event1);
        eventRequestSCSEnd2.setEvent(event2);

        // Tobias' tasks
        Task tobiasTask1 = new Task(event1, "prepare cameras", subteamMember1, "High");
        subteamMember1.addTask(tobiasTask1);

        Task tobiasTask2 = new Task(event2, "prepare videos", subteamMember1, "High");
        subteamMember1.addTask(tobiasTask2);


        RecruitmentRequest recruitmentRequest1 = new RecruitmentRequest("Full time", "Administration", 14, "Marketing Officer", "Managing company's campains");
        RecruitmentRequest recruitmentRequest2 = new RecruitmentRequest("Part time", "Services", 33, "Sushi Master", "Charges with preparing rare and poisonous fish for eccentric customers");

        RecruitmentRequestDAO recruitmentRequestDAO = getRecruitmentRequestDAO();
        recruitmentRequestDAO.save(recruitmentRequest1);
        recruitmentRequestDAO.save(recruitmentRequest2);

        FinancialRequestDAO financialRequestDAO = getFinancialRequestDAO();
/*        financialRequestDAO.save(new FinancialRequest(tobiasTask1, 100, "more cameras"));
        financialRequestDAO.save(new FinancialRequest(tobiasTask2, 200, "more videos"));*/
        financialRequestDAO.save(new FinancialRequest( 100, "more cameras"));
        financialRequestDAO.save(new FinancialRequest( 200, "more videos"));
    }

    public UserDAO getUserDAO() {
        return initializer.getUserDAO();
    }

    public EventRequestDAO getEventRequestDAO() {
        return initializer.getEventRequestDAO();
    }

    public CustomerDAO getCustomerDAO() {
        return initializer.getCustomerDAO();
    }

    public SubteamDAO getSubteamDAO() {
        return initializer.getSubteamDAO();
    }

    public RecruitmentRequestDAO getRecruitmentRequestDAO() {
        return initializer.getRecruitmentRequestDAO();
    }

    public FinancialRequestDAO getFinancialRequestDAO() {
        return initializer.getFinancialRequestDAO();
    }
}
