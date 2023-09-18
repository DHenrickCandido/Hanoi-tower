import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        boolean playing = true;
        int maxSizeStack = 5;
        int countPlays = 0;

        Stack[] stacks = new Stack[3];
        stacks[0] = randomUniqueStack(maxSizeStack);
        stacks[1] = new Stack();
        stacks[2] = new Stack();

        Scanner scan = new Scanner(System.in);  

        while(playing){
            System.out.println("\n\n\n");
            System.out.println("=======================");

            int valuePopped = 0;

            stacks[0].printH();
            stacks[1].printH();
            stacks[2].printH();



            boolean choosingCheck = false;
            String towerChoice;
            int towerChoiceInt;

            do {
                System.out.println("Escolha a torre:");
                System.out.println("0 -> left");
                System.out.println("1 -> middle");
                System.out.println("2 -> right");
                System.out.println("Plays: "+ countPlays+"\n");

                do {
                    towerChoice = scan.nextLine();
                } while(!towerChoice.equals("0") && !towerChoice.equals("1") && !towerChoice.equals("2"));

                towerChoiceInt = Integer.parseInt(towerChoice);
                if (!stacks[towerChoiceInt].isEmpty()) {
                    valuePopped = stacks[towerChoiceInt].pop();
                    choosingCheck = true;
                }
                else {
                    System.out.println("Esta torre esta vazia.");
                }
                

            } while (!choosingCheck);

            boolean choosingDestinationCheck = false;
            do {
                System.out.println("Escolha a torre de destino:");
                System.out.println("0 -> left");
                System.out.println("1 -> middle");
                System.out.println("2 -> right");
                System.out.println("-1 -> cancelar acao\n");

                
                String towerTargetChoice;
                do {
                    towerTargetChoice = scan.nextLine();
                } while(!towerTargetChoice.equals("-1") && !towerTargetChoice.equals("0") && !towerTargetChoice.equals("1") && !towerTargetChoice.equals("2"));
                
                if (towerTargetChoice.equals("-1")) {
                    stacks[towerChoiceInt].push(valuePopped);
                    countPlays-=1;
                    break;
                }
                int towerTargetChoiceInt = Integer.parseInt(towerTargetChoice);

                
                if (stacks[towerTargetChoiceInt].isEmpty()){
                    stacks[towerTargetChoiceInt].push(valuePopped);
                    choosingDestinationCheck = true;
                    if (stacks[towerTargetChoiceInt].size() >= maxSizeStack) {
                        System.out.println("\nVOCE VENCEU\n");
                        playing = false;
                    }
                }
                else if (valuePopped < stacks[towerTargetChoiceInt].peek()) {
                    stacks[towerTargetChoiceInt].push(valuePopped);
                    choosingDestinationCheck = true;
                    if (stacks[towerTargetChoiceInt].size() >= maxSizeStack) {
                        System.out.println("\nVOCE VENCEU\n");
                        playing = false;
                    }
                } else {
                    System.out.println("Esta torre tem no topo menor");
                }
                

            } while(!choosingDestinationCheck);
            countPlays += 1;
        }

    }

    public static Stack randomUniqueStack(int maxSizeStack){
        Stack stack = new Stack();

        int[] jaForam = new int[maxSizeStack];
        int count = 0;
        Random random = new Random();

        while (count < maxSizeStack) {
            int randomNumber = random.nextInt(100); 

            if (!contains(jaForam, count, randomNumber)) {
                stack.push(randomNumber);
                jaForam[count] = randomNumber;
                count++;
            }
        }

        return stack;
    }

    public static boolean contains(int[] array, int count, int value) {
        for (int i = 0; i < count; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

}

