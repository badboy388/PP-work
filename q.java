/* ***************************************
  Author: Shahrukh Khan Durrani
  Mini-project: Music Quiz
******************************************/

import java.util.*;// importing all util libraries.


class q
{
    public static void main(String[] p)
    {
        Qa [] a = new Qa[4];
        for(int i=0; i<4; i++)
        {
            a [i] = creata(i);
        }

        Qa [] b = new Qa[4];
        for(int j=0; j<4; j++)
        {
            a [j] = creatb(j);
        }

        askquestions(a, b);
        System.exit(0);
    } // endmain

    public static void askquestions(Qa a[], Qa b[])// Intializing questions and true answeres.

    {
        String welcomemessage;
        welcomemessage = (" welcome to the music quiz!.......lets begin");// welcome messge.
        System.out.println(welcomemessage);// This method outputs welcome message.

        // Intializing variables.
        boolean ans1 = false;
        int[] questionscore = new int[4];// making array to store score of each question.
        Scanner scanner = new Scanner(System.in);// importing scanner
        System.out.println("How many players are going to take the quiz?");// asking how many players will answere.
        int c = Integer.parseInt(scanner.nextLine());// storing answere of number of players playing.
        int[] playerscore = new int[c];// array to keep indiviual player score.
        
        for (int i = 0; i < c; i++)
        {
            int score = 0;
            int round = 1;
            System.out.println("Round " + round);
            System.out.println("Player " + (i + 1));


            while(round == 1)
            {
                for (int j = 0; j < 4; j++)
                {

                    System.out.println(getques(a[j]));// this method outputs questions.
                    String ans = input();// storing ans in variable.
                    ans1 = checking(ans, getans(a[j]));
                    int s = points(ans1);
                    score = addornot(s, score);
                    questionscore[j] = score;
                }

                playerscore[i] = questionscore[0] + questionscore[1] + questionscore[2] + questionscore[3];
                round++;


            }



          //  while(round <= 2)
           /* {
                    for (int k = 0; k < 4; k++)
                    {
                        System.out.println(getques(b[k]));// this method outputs questions.
                        String ans = input();// storing ans in variable.
                        ans1 = checking(ans, getans(b[k]));
                        int s = points(ans1);
                        score = addornot(s, score);
                        questionscore[k] = score;

                    }

                playerscore[i] = questionscore[0] + questionscore[1] + questionscore[2] + questionscore[3];

            }*/

        }

        fmessage(playerscore , c);// method for printing final message.


    }
    public static Qa creata(int i)
    {
        String [] ques = {"Which song is Status Quo's only number one single in the UK Singles Chart?", "Which subscription based music streaming service was launched by Jay Z in 2014?", "Which pop band feature Sharleen Spiteri on lead vocals?", "Whose band was the Tijuana Brass?"};
        String [] ans = {"Down Down", "Tidal", "Texas", "Herb Alpert"};
        Qa q = new Qa();
        q = setques(q, ques[i]);
        q = setans(q, ans[i]);

        return q;
    }

    public static Qa creatb(int j)
    {
        String [] ques = {"Which girls name featured in a top ten hit for David Bowie in 1984 and a number one for Michael Jackson in 1983?", "Which rock group provided the soundtrack music for the film 'Flash Gordon'?", "What nationality were the rock band Thin Lizzy?", "What was the first name of singing duo Simon and Garfunkel?"};
        String [] ans = {"Jean", "Queen", "Irish", "Pual"};
        Qa q = new Qa();
        q = setques(q, ques[j]);
        q = setans(q, ans[j]);

        return q;

    }



    //This following method checks if the answere is right or wrong and return bolean.
    public static boolean checking(String ans, String a)
    {
        boolean answere = false;

        if (ans.equals(a))
        {
            System.out.println("Your answere was correct.");
            answere = true;
            return answere;
        }

        else
        {
            System.out.println("Your answere was wrong.");
            return answere;

        }
    }

    // This method gives 3 score if dice throw is between 1-5 and 6 to those whose dicethrow value is 6.
    public static int points(boolean ans)
    {
        int roll = random();
        int score1 = 0;
        if (ans == true)
        {
            if (roll == 6)
            {
                score1 = 6;
            }
            else
            {
                score1 = 3;
            }

        }
        else
        {
            score1 = 0;
        }


        return score1;

    }



    // This method is an adds score if the value given is 3 or else just returns 6 if score is 6.
    public static int addornot(int s,int score)
    {

        if (s != 0)
        {
            if (s == 3)
            {
                score = score + 3;
                return score;
            }
            else
            {
                score = 6;
                return score;
            }
        }
        else
        {
            return 0;
        }
    }



    // It is a method that records person input and return the answere.
    public static String input()

    {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }


    // This method output player score and the total.
    public static void fmessage(int [] playerscore, int c)
    {
        for(int i = 0; i<c; i++)
        {
            System.out.println("Player " + (i+1) + " scored  " + playerscore[i] + " points.");
        }

        int sum = 0;
        for(int j =0; j<c; j++)
        {
            sum = sum + playerscore[j];
        }


        System.out.println("Whole team scored " + sum + " points.");

    }


    //getter methods
    public static String getques(Qa q)
    {
        return q.questions;
    }

    public static String getans(Qa q)
    {
        return q.answeres;
    }


    // setter method
    public static Qa setques(Qa q, String ques)
    {
        q.questions = ques;
        return q;
    }
    public static Qa setans(Qa q, String ans)
    {
        q.answeres = ans;
        return q;
    }

    // Method for random score.
    public static int random()
    {
        Random dice = new Random();
        int dicethrow = dice.nextInt(6) + 1;
        return dicethrow;

    }



}

// making class Qa.
class Qa
{
    String questions;
    String answeres;
}

