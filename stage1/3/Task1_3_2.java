import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Task1_3_2 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        var ram = new RAM(256);
        var disk = new HardDisk(1024);
        var comp = new Computer(disk,ram);

        System.out.println("------------------\n"+
                "Команды\n"+
                "------------------\n"+
                "turnOn--включить компьютер\n"+
                "turnOff--выключить компьютер\n"+
                "checkVirus--включить компьютер\n"+
                "showDiskSize--показать вместимость диска\n"+
                "showRamSize--показать вместимость ОЗУ\n" +
                "exit--закрыть приложение\n"+
                "------------------");
        while(true){
            commands com = commands.valueOf(br.readLine());
            switch (com){
                case turnOn:
                    comp.turnOn();
                    break;
                case turnOff:
                    comp.turnOff();
                    break;
                case checkVirus:
                    comp.checkVirus();
                    break;
                case showDiskSize:
                    comp.showDiskSize();
                    break;
                case showRamSize:
                    comp.showRAMSize();
                    break;
                default:
                    return;
            }
        }
    }
}

enum commands{
    turnOn,
    turnOff,
    checkVirus,
    showDiskSize,
    showRamSize,
    exit
}

class Computer{
    private boolean isOn;
    private HardDisk disk;
    private RAM ram;

    public Computer(HardDisk disk, RAM ram){
        this.disk = disk;
        this.ram = ram;
    }
    public void turnOn(){
        if(isOn){
            System.out.println("Компьютер уже включен");
            return;
        }
        System.out.println("Компьютерн включен");
        isOn = true;
    }
    public void turnOff(){
        if(!isOn){
            System.out.println("Компьютер уже выключен");
            return;
        }
        System.out.println("Компьютер выключен");
        isOn = false;
        Runtime runtime = Runtime.getRuntime();
        try{
            runtime.exec("shutdown -s -t 0");
        } catch (Exception e){
            System.out.println("Не удалось выключить компьютер");
        }
        System.exit(0);
    }

    public void showDiskSize(){
        System.out.println("Disk size is " + disk.getSize() + " bytes");
    }
    public void showRAMSize(){
        System.out.println("RAM size is " + ram.getSize() + " bytes");
    }
    public void checkVirus(){
        if(!isOn){
            System.out.println("Включите компьютер");
            return;
        }
        try{
            String[] msg = new String[]{
                    "5ds554@fF5@5fd",
                    "sd5d4asf21wqer122",
                    "1@@@#$!f2#$fg",
                    "as@#$!f2#asf21f21wq",
                    "@#@fF5@5$sf21wqer12!f2#",
                    "5d4asf@#$!fF5@5f2#",
                    "@#$!d4asf2f2#",
            };
            Random rnd = new Random(666);
            int i = 10;
            while(i>0){
                Thread.sleep(300);
                System.out.println(msg[Math.abs(rnd.nextInt()%7)]);
                i--;
            }
            System.out.print("\nВирусы не обнаружены");
            Thread.sleep(2000);
            System.out.print("(честно)\n");
        } catch (InterruptedException e){
            System.out.println("Поток был прерван!?");
        }
    }
}

interface Memory{
    int getSize();
}

class HardDisk implements Memory{
    private int size;
    public HardDisk(int size){
        if(size<0)
            throw new RuntimeException("Memory can't be negative");
        this.size = size;
    }
    @Override
    public int getSize(){
        return  size;
    }
}
class RAM implements Memory{
    private int size;
    public RAM(int size){
        if(size<0)
            throw new RuntimeException("Memory can't be negative");
        this.size = size;
    }
    @Override
    public int getSize(){
        return  size;
    }
}
