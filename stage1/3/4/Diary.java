import java.io.BufferedReader;
import java.io.IOException;
import java.nio.Buffer;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class Diary {
    private HashSet<BuisinessRecord> buisinessRecords;
    private  BuisinessRecord lastRecord;
    private BufferedReader br;

    public Diary(BufferedReader reader){
        br = reader;
        buisinessRecords = new HashSet<>();
    }

    private void showRecord(BuisinessRecord rec){
        if(rec == null){
            System.out.println("Record doesn't exist" +
                    "\n-------------------");
        }
        System.out.println(rec.toString() +
                "\n-------------------");
    }

    public void AddRecord(){
        try{
            LocalDate date;
            System.out.println("Введите дату:");
            date = LocalDate.parse(br.readLine());

            if(searchByLocalDate(date) != null){
                System.out.println("Запись с датой от " + date + " уже существует");
                return;
            }

            System.out.println("Введите тело записи:");
            var words = br.readLine().split(" ");
            var record = new BuisinessRecord(words,date);
            buisinessRecords.add(record);
        } catch (Exception e){
            System.out.println("Ошибка ввода/вывода");
        }
    }

    public BuisinessRecord searchByLocalDate(LocalDate date){
        for(var rec : buisinessRecords){
            if(rec.getCreatedWhen().equals(date))
                return rec;
        }
        return null;
    }
    public boolean delete(LocalDate date) {
        return buisinessRecords.removeIf((r) -> r.getCreatedWhen().equals(date));
    }
    public boolean correctExecutedDate(LocalDate originalDate) throws IOException {
        var rec = searchByLocalDate(originalDate);
        if(rec == null)
            return false;
        System.out.println("Введите дату выполнения:");
        var newDate = LocalDate.parse(br.readLine());
        rec.setExecuteDate(newDate);
        return true;
    }
    public void showAll(boolean asc){
        if(buisinessRecords.isEmpty()){
            System.out.println("Здесь пока нет записей");
        }
        var recs = new BuisinessRecord[buisinessRecords.size()];
        buisinessRecords.toArray(recs);
        Arrays.sort(recs,new Comparator<BuisinessRecord>() {
            @Override
            public int compare(BuisinessRecord o1, BuisinessRecord o2) {
                return asc ? o1.getCreatedWhen().compareTo(o2.getCreatedWhen()) :
                        o2.getCreatedWhen().compareTo(o1.getCreatedWhen());
            }
        });

        var sb = new StringBuilder();
        int i = 0;
        while(i < recs.length){
            sb.append("\n-------------------\n");
            sb.append(recs[i].toString());
            i++;
        }
        sb.append("\n-------------------");
        System.out.println(sb.toString());
    }

    public BuisinessRecord showByLocalDate(LocalDate date){
        var rec = searchByLocalDate(date);
        if(rec == null){
            throw new RuntimeException("Record from " + date + " doesn't exist");
        }
        showRecord(rec);
        return rec;
    }
    public BuisinessRecord showLast(){
        showRecord(lastRecord);
        return lastRecord;
    }
}
