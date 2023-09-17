import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        boolean playing = true;
        int maxSizeStack = 5;
        int countPlays = 0;

        Stack stackLeft = randomUniqueStack(maxSizeStack);
        Stack stackMiddle = new Stack();
        Stack stackRight = new Stack();

        // stackLeft.push(3);
        // stackLeft.push(2);
        // stackLeft.push(1);

        Scanner scan = new Scanner(System.in);  

        while(playing){
            System.out.println("\n\n\n");
            System.out.println("=======================");

            int valuePopped = 0;

            stackLeft.printH();
            stackMiddle.printH();
            stackRight.printH();



            boolean choosingCheck = false;

            do {
                System.out.println("Escolha a torre:");
                System.out.println("1 -> left");
                System.out.println("2 -> middle");
                System.out.println("3 -> right");
                System.out.println("Plays: "+ countPlays);

                String towerChoice = scan.nextLine();
    
                if (towerChoice.equals("1")) {
                    if (!stackLeft.isEmpty()) {
                        valuePopped = stackLeft.pop();
                        choosingCheck = true;
                    }
                    else {
                        System.out.println("Esta torre esta vazia.");
                    }
                }

                if (towerChoice.equals("2")) {
                    if (!stackMiddle.isEmpty()) {
                        valuePopped = stackMiddle.pop();
                        choosingCheck = true;
                    }
                    else {
                        System.out.println("Esta torre esta vazia.");
                    }
                }

                if (towerChoice.equals("3")) {
                    if (!stackRight.isEmpty()) {
                        valuePopped = stackRight.pop();
                        choosingCheck = true;
                    }
                    else {
                        System.out.println("Esta torre esta vazia.");
                    }
                }
            } while (!choosingCheck);

            boolean choosingDestinationCheck = false;
            do {
                System.out.println("Escolha a torre de destino:");
                System.out.println("1 -> left");
                System.out.println("2 -> middle");
                System.out.println("3 -> right\n");
                
                String towerTargetChoice = scan.nextLine();

                
                //Left
                if (towerTargetChoice.equals("1")) {
                    if (stackLeft.isEmpty()){
                        stackLeft.push(valuePopped);
                        choosingDestinationCheck = true;
                        if (stackLeft.size() >= maxSizeStack) {
                            System.out.println("\nVOCE VENCEU\n");
                            playing = false;
                        }
                    }
                    else if (valuePopped < stackLeft.peek()) {
                        stackLeft.push(valuePopped);
                        choosingDestinationCheck = true;
                        if (stackLeft.size() >= maxSizeStack) {
                            System.out.println("\nVOCE VENCEU\n");
                            playing = false;
                        }
                    } else {
                        System.out.println("Esta torre tem no topo menor");
                    }
                }

                //Middle
                if (towerTargetChoice.equals("2")) {
                    if (stackMiddle.isEmpty()){
                        stackMiddle.push(valuePopped);
                        choosingDestinationCheck = true;
                        if (stackMiddle.size() >= maxSizeStack) {
                            System.out.println("\nVOCE VENCEU\n");
                            playing = false;
                        }
                    }
                    else if (valuePopped < stackMiddle.peek()) {
                        stackMiddle.push(valuePopped);
                        choosingDestinationCheck = true;
                        if (stackMiddle.size() >= maxSizeStack) {
                            System.out.println("\nVOCE VENCEU\n");
                            playing = false;
                        }
                    } else {
                        System.out.println("Esta torre tem no topo menor");
                    }
                }

                //Right
                if (towerTargetChoice.equals("3")) {
                    if (stackRight.isEmpty()){
                        stackRight.push(valuePopped);
                        choosingDestinationCheck = true;
                        if (stackRight.size() >= maxSizeStack) {
                            System.out.println("\nVOCE VENCEU\n");
                            playing = false;
                        }
                    }
                    else if (valuePopped < stackRight.peek()) {
                        stackRight.push(valuePopped);
                        choosingDestinationCheck = true;
                        if (stackRight.size() >= maxSizeStack) {
                            System.out.println("\nVOCE VENCEU\n");
                            playing = false;
                        }
                    } else {
                        System.out.println("Esta torre tem no topo menor");
                    }
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
            int randomNumber = random.nextInt(100); // Altere o limite conforme necessário

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

