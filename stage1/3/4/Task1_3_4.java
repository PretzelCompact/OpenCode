import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class Task1_3_4 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var diary = new Diary(br);

        System.out.println("-------------------\n" +
                "Команды\n" +
                "-------------------\n"+
                "add--добавить запись\n"+
                "delete--удалить запись\n"+
                "showAsc--показать записи в порядке возрастания даты добавления\n"+
                "showDesc--показать записи в порядке убывания даты добавления\n"+
                "setExecuted--установить дату выполнения\n" +
                "-------------------\n"+
                "Формат ввода даты: YYYY-MM-DD\n" +
                "-------------------"
        );

        LocalDate date;
        while(true){
            var str = br.readLine();
            switch (str){
                case "add":
                    diary.AddRecord();
                    break;
                case "delete":
                    System.out.println("Введите дату:");
                    date = LocalDate.parse(br.readLine());
                    if(diary.delete(date)) {
                        System.out.println("Запись удалена");
                    } else{
                        System.out.println("Запись не найдена");
                    }
                    break;
                case "showAsc":
                    diary.showAll(true);
                    break;
                case "showDesc":
                    diary.showAll(false);
                    break;
                case "setExecuted":
                    System.out.println("Введите дату добавления записи:");
                    date = LocalDate.parse(br.readLine());
                    if(diary.correctExecutedDate(date)){
                        System.out.println("Дата выполнения успешно обновлена");
                    }
                    break;
            }
        }
    }
}
