import java.util.Random;
import java.util.Scanner;

public class Egzersiz01
{
    public static void main(String[] args) {
        printMenu();
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        int choice = input.nextInt();
        while(choice < 7 && choice > 0 && choice != 7)
        {
            if (choice == 1)
            {
                System.out.println("How many words do you wish to enter?");
                int count= input.nextInt();
                String [] words= new String [count];
                isPolindrome(words);
                System.out.println("");
                System.out.println("enter 0 to terminate the programme, \n" +
                        "enter 1 to continue playing Is it a Polindrome \n" +
                        "enter 9 to print the menu");
                choice = input.nextInt();

            }

            if (choice == 2 )
            {
                System.out.println("How many words do you wish to enter?");
                int count = input.nextInt();
                String [] words= new String [count];
                countLetters(words);
                System.out.println("");
                System.out.println("enter 0 to terminate the programme, \n" +
                        "enter 2 to continue playing How Many Letters? \n" +
                        "enter 9 to print the menu");
                choice = input.nextInt();
            }

            if (choice == 3)
            {
                input = new Scanner (System.in);
                System.out.println("For this one, you may enter a sentence. We'll comb it through and tell you if it has any numbers in it");
                System.out.println("Please enter your sentence:");
                String s = input.nextLine();
                isNumber(s);
                System.out.println("");
                System.out.println("enter 0 to terminate the programme, \n" +
                        "enter 3 to continue playing Does it contain numbers \n" +
                        "enter 9 to print the menu");
                choice = input.nextInt();
            }

            if (choice == 4)
            {
                input = new Scanner(System.in);
                System.out.println("Please enter a word, we'll reverse it for you");
                String word = input.nextLine();
                backwards(word);
                System.out.println("");
                System.out.println("enter 0 to terminate the programme, \n" +
                        "enter 4 to continue playing Reverse the Word \n" +
                        "enter 9 to print the menu");
                choice = input.nextInt();
            }

            if (choice == 5)
            guessTheNumber();

            System.out.println("enter 0 to terminate the programme, \n" +
                    "enter 5 to continue playing Can you guess the number \n" +
                    "enter 9 to print the menu");
            choice = input.nextInt();
            if (choice == 6)
            {
                System.out.println("Today is the day we create you a free bank account with 300 Turkish liras in it. To get your started, What's your name");
                String name = input2.nextLine();
                System.out.println("Now, your family name");
                String familyName = input2.nextLine();
                System.out.println("We've got all we need. Now setting your account up.");
                BankFundamentals c1 = new BankFundamentals(name,familyName,300);
                createBankAccount(c1);
                choice = input.nextInt();

            }
              //  createBankAccount();
            if (choice == 7)
            {
                System.out.println("See you later");
                break;
            }
            if (choice == 9)
            {
                printMenu();
                choice = input.nextInt();
            }



        }
    }



    private static void printMenu ()
        {
            System.out.println("What would you like to do? \n" +
                    "1-) Is the word I am entering a polindrome? \n" +
                    "2-) How many letters does my word have? \n" +
                    "3-) Does my word contain any numbers \n" +
                    "4-) Print my word backwards \n" +
                    "5-) Can you guess the number though? \n" +
                    "6-) I feel so lucky\n " +
                    "7-) I don't want to do anything, exit.");
        }
    private static void createBankAccount(BankFundamentals c1)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Your bank account has been created. Details are as follows: ");
        System.out.println("customer name: "+ c1.ad);
        System.out.println("customer surname: " + c1.soyad);
        System.out.println("balance: "+ c1.bakiye);

        System.out.println("Now, there are 3 things you can do");
        System.out.println("Enter 1 to deposit money \n Enter 2 to withdraw money \n Enter 3 to transfer money to a friend");
        int choice = input.nextInt();
        while(choice == 1 || choice == 2 || choice == 3) {
            if (choice == 1) {
                System.out.println("How much do you want to deposit?");
                double amount = input.nextDouble();
                c1.deposit(amount);
                System.out.println("Enter 1 to deposit more money \n Enter 2 to withdraw money \n Enter 3 to transfer money \n Enter 4 to go back to the main menu and exit this game");
                choice = input.nextInt();
                if (choice == 4) {
                    printMenu();
                }

            }
            if (choice == 2) {
                System.out.println("How much do you want to withdraw?");
                double amount = input.nextDouble();
                c1.withdraw(amount);
                System.out.println("Enter 1 to deposit more money \n Enter 2 to withdraw money \n Enter 3 to transfer money \n Enter 4 to go back to the main menu and exit this game");
                choice = input.nextInt();
                if (choice == 4) {
                    printMenu();
                }
            }
            if (choice == 3) {
                System.out.println("For that we need to create an account for your friend. Let's give him an account with 300 Turkish liras in it as well! What's his full name?");
                String friendName = input.nextLine();
                System.out.println("And the family name?");
                String friendFamilyName = input.nextLine();
                BankFundamentals c2 = new BankFundamentals("friendName", "friendFamilyName", 300);
                System.out.println("We've created your friend's account! How much money do you want to transfer to him=");
                double amount = input.nextDouble();
                c1.transfer(c1, c2, amount);
                System.out.println("Enter 1 to deposit more money \n Enter 2 to withdraw money \n Enter 3 to transfer money \n Enter 4 to go back to the main menu and exit this game");
                choice = input.nextInt();
                if (choice == 4) {
                    printMenu();
                }

            }
        }


    }
    private static void guessTheNumber()
    {
        int random, guess, attempts;
        Scanner input = new Scanner(System.in);
        Random generator = new Random();
        random = generator.nextInt(100) + 1;
        attempts = 1;

        System.out.print("I am thinking of a number between 0 and 100, what do you think it is?");

        guess = input.nextInt();
        while (guess != random) {
            if (guess > random)
            {
                System.out.print("Lower!");
                attempts += 1;
                guess = input.nextInt();

            }
            else
                {
                System.out.print("Higher!");
                attempts +=1;
                guess = input.nextInt();
            }
        }

        System.out.print(random + " is the correct answer and it took you " + attempts + " attempts to guess it!");
        System.out.println("");
    }
    private static void backwards(String s)
    {

        String str = s;
        String reverse = "";


        for(int i = str.length() - 1; i >= 0; i--)
        {
            reverse = reverse + str.charAt(i);
        }

        System.out.println("Reversed string is:");
        System.out.println(reverse);

    }
    private static void isNumber(String s)
    {

        if (s.contains("1")|| s.contains("2")||s.contains("3")||s.contains("4")||s.contains("5")||s.contains("6")|| s.contains("7")|| s.contains("8")||s.contains("9"))
        {
            System.out.println(" Your sentence has numbers in it ");
        }
        else
        {
            System.out.println(" Nope, it doesn't seem like your sentence has numbers in it");
        }


    }

    private static void countLetters (String [] s)
    {
        for (int i = 0; i < s.length; i++)
        {
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter the " + (i+1) + ". word");
            s[i]  = input.nextLine();
            int size = s[i].length();
            System.out.println(i+1+ ". word has " + size + "letters");
        }


    }
    private static void isPolindrome (String [] s)
    {
        boolean [] isPolindrome = new boolean[s.length];
        for (int i = 0; i < s.length; i++)
        {
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter the " + (i+1) + ". word");
            s[i]  = input.nextLine();
            int low = 0;
            int high = s[i].length() - 1;
            isPolindrome[i] = true;

            while(low<high)
            {
                if(s[i].charAt(low) != s[i].charAt(high))
                {
                    isPolindrome[i] = false;
                    break;
                }
                low++;
                high--;
            }
        }

        for (int i = 0; i < s.length; i++)
        {
            if (isPolindrome[i]==true )
                System.out.println(s[i] + " is a polindrome");
            else
                System.out.println(s[i]+ " is not a polindrome");

        }
    }


    public static class BankFundamentals {
        public String ad;
        public String soyad;
        public double bakiye;

        public  BankFundamentals (String ad, String soyad, double bakiye)
        {
            this.ad = ad;
            this.soyad = soyad;
            this.bakiye = bakiye;
        }

        public void deposit (double money)
        {
            this.bakiye += money;
            System.out.println(money+ "amount has been deposited to your account. The new balance is: " + this.bakiye);
        }
        public void withdraw (double money)
        {
            this.bakiye -= money;
            System.out.println(money + "amount has been withdrawn from your account. The new balance is: " + this.bakiye);
        }

        public void transfer (BankFundamentals sender, BankFundamentals receiver, double amount)
        {
            if (amount > 0)
            {
                sender.bakiye -= amount;

                receiver.bakiye += amount;

                System.out.println("Transfer successfull. Your new balance is: " +sender.bakiye+ " \n The receiver's new balance is: " + receiver.bakiye);
            }
            else
            {
                System.out.println("Geçersiz miktar girildi");

            }
        }

    }


}

