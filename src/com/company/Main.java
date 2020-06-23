package com.company;

import com.company.database.*;
import com.company.entities.*;
import com.company.enums.JobTitle;
import com.company.enums.Levels;
import com.company.enums.Types;
import javafx.util.Pair;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Hello dear user, this is the app for creating and configuring your company");
        mainMenu();
    }

    public static void mainMenu() {
        Scanner sc = new Scanner(System.in);
        int ans = 0;
        while (true) {
            System.out.println("Here is the main commands of this app:");
            System.out.println("* Type 1 if you want to create a new company");
            System.out.println("* Type 2 if you want to get data from database");
            System.out.println("* Type 3 if you want to quit the app");
            ans = sc.nextInt();
            sc.nextLine();
            if (ans == 1) {
                companyCreation();
            } else if (ans == 2) {
                getData();
            } else if (ans == 3) {
                return;
            } else {
                System.out.println("You've entered the wrong input. Please try again");
            }
        }
    }

    public static void getData() {
        Scanner sc = new Scanner(System.in);
        Company c;
        Project p;
        Employee emp;
        int ans = 0;
        while(true) {
            System.out.println("You have been moved to the section 'Get Data'");
            System.out.println("* Type -1 if you want to move back to the main menu");
            System.out.println("* Type 1 if you want to get full information about the company");
            System.out.println("* Type 2 if you want to get information about the specific project");
            System.out.println("* Type 3 if you want to get information about the specific employee");
            ans = sc.nextInt();
            sc.nextLine();
            if (ans == -1) {
                return;
            } else if (ans == 1) {
                System.out.println("Enter the company name");
                c = DBGetCompany.getCompany(sc.nextLine());
                if (c != null) {
                    System.out.println("We've found this company, processing the data ...");
                    System.out.println("*************************************************");
                    c.work();
                    System.out.println("*************************************************");
                } else {
                    System.out.println("We can not found this company.");
                }
            } else if (ans == 2) {
                System.out.println("Enter the project name");
                p = DBGetProject.getProjectInfo(sc.nextLine());
                if (p != null) {
                    System.out.println("We've found this project, processing the data ...");
                    System.out.println("*************************************************");
                    p.work();
                    System.out.println("*************************************************");
                } else {
                    System.out.println("We can not found this project.");
                }
            } else if (ans == 3) {
                System.out.println("Enter the employee name");
                Pair<Employee, String> val = DBGetEmployee.getEmployee(sc.nextLine());
                if (val != null) {
                    System.out.println("We've found this employee, processing the data ...");
                    String proj_name = val.getValue();
                    emp = val.getKey();
                    System.out.println("*************************************************");
                    System.out.print(emp.getName() + ": salary = " + emp.getSalary() + ", " + "project = " + proj_name + ", ");
                    emp.work();
                    System.out.println("*************************************************");
                } else {
                    System.out.println("We can not found this employee.");
                }
            } else {
                System.out.println("You've entered the wrong input. Please try again");
            }
        }
    }

    public static void companyCreation() {
        Scanner sc = new Scanner(System.in);
        Company c = null;
        Project p = null;
        Employee emp = null;
        int ans = 0;
        while(true) {
            System.out.println("You have been moved to the company creation!");
            System.out.println("* Type -1 if you want to move back to the main menu.");
            System.out.println("* Type 1 if you want to choose the name of your new company.");
            System.out.println("* Type 2 if you want to add new project to the existing company");
            System.out.println("* Type 3 if you want to add new employee to the existing project");
            ans = sc.nextInt();
            sc.nextLine();
            if (ans == -1) {
                return;
            } else if (ans == 1) {
                while (true) {
                    System.out.println("Enter the company name");
                    c = new Company(sc.nextLine());
                    if (DBAddCompany.addCompany(c) == 1){
                        System.out.println("You have been successfully created the company.");
                        System.out.println();
                        break;
                    }
                    else {
                        System.out.println("Sorry, there have been some errors with database. Please, try again.");
                    }
                }
            }
            else if (ans == 2) {
                while (true) {
                    System.out.println("Enter the company name in which the project will be created");
                    c = new Company(sc.nextLine());
                    System.out.println("Now please enter the project name");
                    String proj_name = sc.nextLine();
                    System.out.println("Now enter the project cost (in Tenge). Please, also mention that the salary of employees will be added to the project cost");
                    int proj_cost = sc.nextInt();
                    sc.nextLine();
                    p = new Project(proj_name, proj_cost);
                    if (DBAddProject.addProject(c, p) == 1) {
                        System.out.println("You have been successfully added the project to the company");
                        System.out.println();
                        break;
                    } else {
                        System.out.println("Sorry, there have been some errors with database. Please, try again.");
                    }
                }
            } else if (ans == 3) {
                while(true) {
                    System.out.println("Enter the company name in which the employee will work");
                    c = new Company(sc.nextLine());
                    System.out.println("Enter the project name in which the employee will take participation");
                    p = new Project(sc.nextLine(), 0);
                    System.out.println("Now enter the name of the employee");
                    String name = sc.nextLine();
                    System.out.println("If this employee is MANAGER - Type 1; if he is DEVELOPER - Type 2");
                    int ans2 = sc.nextInt();
                    sc.nextLine();
                    if (ans2 == 1) {
                        emp = new ProjectManager(name, JobTitle.MANAGER);
                    } else if (ans2 == 2) {
                        while(true) {
                            Types type = null;
                            Levels level = null;
                            System.out.println("Enter the programming language of the developer");
                            String prog_lang = sc.nextLine();
                            System.out.println("If this developer is focused of BACKEND - Type 1; if he is focused on FRONTEND - Type 2");
                            ans2 = sc.nextInt();
                            sc.nextLine();
                            if (ans2 == 1) {
                                type = Types.BACKEND;
                            } else if (ans2 == 2) {
                                type = Types.FRONTEND;
                            } else {
                                System.out.println("You've entered the wrong input. Please try again");
                                continue;
                            }

                            System.out.println("If this developer is JUNIOR - Type 1; if he is MIDDLE - Type 2; if he is SENIOR - Type 3; if He is TEAM_LEAD - Type 4.");
                            ans2 = sc.nextInt();
                            sc.nextLine();
                            if (ans2 == 1) {
                                level = Levels.JUNIOR;
                            } else if (ans2 == 2) {
                                level = Levels.MIDDLE;
                            } else if (ans2 == 3) {
                                level = Levels.SENIOR;
                            } else if (ans2 == 4) {
                                level = Levels.TEAM_LEAD;
                            } else {
                                System.out.println("You've entered the wrong input. Please try again");
                                continue;
                            }

                            emp = new Developer(name, JobTitle.DEVELOPER, prog_lang, type, level);
                            break;
                        }
                    } else {
                        System.out.println("You've entered the wrong input. Please try again");
                        continue;
                    }

                    if (DBAddEmployee.addEmployee(c, p, emp) == 1) {
                        System.out.println("You have been successfully added the employee to the company");
                        System.out.println();
                        break;
                    } else {
                        System.out.println("Sorry, there have been some errors with database. Please, try again.");
                    }
                }
            } else {
                System.out.println("You've entered the wrong input. Please try again");
            }
        }
    }
}
