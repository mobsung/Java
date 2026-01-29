package app2;

import app2.dao.TodoDao;
import app2.dto.Todo;

import java.util.List;
import java.util.Scanner;

public class Main {
    static void main() {

        List<Todo> todos = TodoDao.findAll();
        todos.forEach(t -> System.out.println(t.toString()));

        Scanner sc = new Scanner(System.in);
        String s = " ";

        while(!s.isEmpty()){
            System.out.println("""
                    =========> Digita <=========
                    1 - aggiungi risorsa
                    2 - rimuovi risorsa
                    3 - completare task""");
            s = String.valueOf(sc.nextLine());

            switch (s){
                case "1":
                    System.out.println("----------Inserisci il nuovo task----------");
                    String task = sc.nextLine();
                    if (task.isBlank()){
                        System.out.println("Task non valido");
                        break;
                    }

                    boolean ok = TodoDao.inserisciTask(task);

                    if (ok){
                        System.out.println("Task inserito corretamente!");
                    } else {
                        System.out.println("Task non salvato!");
                    }
                    break;
                case "2":
                    System.out.println("----------Inserisci l'id da rimuovere----------");
                    int id = sc.nextInt();
                    if (String.valueOf(id).isBlank()){
                        System.out.println("ID non valido");
                        break;
                    }
                    boolean okID = TodoDao.rimuoviRisorsa(id);

                    if (okID){
                        System.out.println("Task rimossa crrettamente");
                    } else {
                        System.out.println("Tank non presente");
                    }
                    break;
            }
        }

    }
}
