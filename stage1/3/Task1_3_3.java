import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;

public class Task1_3_3 {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int[] powers = new int[3];
        int i = 0;
        System.out.println("Последовательно введите мощность в Ваттах к приборам:Пылесос, мыксер, стиральная машина:");
        while(i<3){
            powers[i] = Integer.parseInt(br.readLine());
            i++;
        }
        var apps = new ElectricalAppliance[]{
                new VacuumCleaner(powers[0]),
                new Mixer(powers[1]),
                new WashingMachine(powers[2])
        };

        System.out.println("Введите максимальный ампераж:");
        double maxAmperage = Double.parseDouble(br.readLine());
        ElectricHouse house = new ElectricHouse(maxAmperage,apps);

        System.out.println("------------------\n"+
                "Команды\n"+
                "------------------\n"+
                "show--включить компьютер\n"+
                "turnOn [index]--включить прибор по индексу\n"+
                "turnOff [index]--выключить прибор по индексу\n"+
                "work--процесс работы приборов\n"+
                "exit--выход\n"+
                "------------------");

        while (true){
            var str = br.readLine().split(" ");
            switch (str[0]){
                case "show":
                    System.out.println(house + "\nНагрузка: " + house.getAmperage() + " Ампер");
                    break;
                case "turnOn":
                    try{
                        int index = Integer.parseInt(str[1]);
                        house.turnOn(index);
                    } catch (OverchargeException e){
                        HandleOverchargeException(e);
                    }
                    break;
                case "turnOff":
                    int index = Integer.parseInt(str[1]);
                    house.turnOff(index);
                    break;
                case "work":
                    house.work();
                    break;
                default:
                    return;
            }
        }
    }
    public static void HandleOverchargeException(OverchargeException e){
        var maxAmperage = e.house.getMaxAmperage();
        var curAmperage = e.house.getAmperage();

        var minIndex = e.apps.size()-1;
        var minAmp = e.apps.get(minIndex).getAmperage();

        int i = e.apps.size()-2;
        while(i >= 0){
            double amp = e.apps.get(i).getAmperage();
            if(maxAmperage >= curAmperage-amp &&
                    minAmp > amp){
                minAmp = amp;
                minIndex = i;
            }
            i--;
        }
        System.out.println("Перегрузка. Рекомендуется отключить прибор с индексом " + minIndex);
    }
}

class OverchargeException extends Exception{
    public AbstractList<ElectricalAppliance> apps;
    public ElectricHouse house;
    public OverchargeException(ElectricHouse house, AbstractList<ElectricalAppliance> apps){
        this.apps = apps;
        this.house = house;
    }
}
class ElectricHouse extends ElectricalAppliance{
    private final ArrayList<ElectricalAppliance> appliances;
    private final double maxAmperage;
    private int workingNumber;

    public ElectricHouse(double maxAmperage, ElectricalAppliance...apps){
        this.maxAmperage = maxAmperage;
        appliances = new ArrayList<>(Arrays.stream(apps).toList());
    }

    public double getMaxAmperage(){
        return maxAmperage;
    }

    @Override
    public String toString(){
        var sb = new StringBuilder();
        sb.append("\n"+ "0." + appliances.get(0));

        int i = 1;
        while(i < appliances.size()){
            sb.append("\n"+ i + "." + appliances.get(i));
            i++;
        }
        return sb.toString();
    }
    @Override
    public String getName(){
        return "'Умный' дом";
    }
    @Override
    public int getPower(){
        int power = 0;
        for(var app : appliances){
            if(app.isOn())
                power+=app.getPower();
        }
        return power;
    }

    @Override
    public double getAmperage(){
        return (double)getPower()/ DEFAULT_VOLTAGE;
    }

    public void turnOn(int index) throws OverchargeException{
        var app = appliances.get(index);
        if(app.isOn()){
            return;
        }
        app.turnOn();
        workingNumber++;
        if(getAmperage() > maxAmperage){
            var list = new ArrayList<ElectricalAppliance>();
            for(var a : appliances){
                if(a.isOn())
                    list.add(a);
            }
            throw new OverchargeException(this,list);
        }
    }

    public void turnOff(int index){
        var app = appliances.get(index);
        if(!appliances.contains(app))
            throw new RuntimeException(app.getClass().toString() + " is not in house");
        if(!app.isOn()){
            return;
        }
        app.turnOff();
        workingNumber--;
    }

    @Override
    public boolean isOn(){
        return workingNumber > 0;
    }
    @Override
    public void turnOn() throws OverchargeException{
        for(int i = 0; i < appliances.size(); i++){
            turnOn(i);
        }
    }
    @Override
    public void turnOff(){
        for(int i = 0; i < appliances.size(); i++){
            turnOff(i);
        }
    }
    @Override
    public void work() {
        for(var app : appliances){
            if(app.isOn())
                app.work();
        }
    }
}

abstract class ElectricalAppliance{
    private int power;
    private boolean isOn;
    public final int DEFAULT_VOLTAGE = 220;

    public abstract String getName();
    public abstract void work();

    public boolean isOn(){
        return isOn;
    }
    public void turnOn() throws OverchargeException{
        isOn = true;
    }
    public void turnOff(){
        isOn = false;
    }
    public double getAmperage(){
        return (double)getPower()/ DEFAULT_VOLTAGE;
    }
    public int getPower(){
        return power;
    }
    public ElectricalAppliance(int power){
        this.power = power;
    }
    public ElectricalAppliance(){}

    @Override
    public String toString(){
        return getName() + ": " + getAmperage() + " Амер. " + (isOn() ? "Включен" : "Выключен");
    }

}
class VacuumCleaner extends ElectricalAppliance{

    public VacuumCleaner(int power){
        super(power);
    }
    @Override
    public void work(){
        System.out.println("Я пылесос. ВШШШШШШШШШ");
    }
    @Override
    public String getName(){
        return "Пылесос";
    }
}

class WashingMachine extends ElectricalAppliance{
    public WashingMachine(int power){
        super(power);
    }
    @Override
    public void work(){
        System.out.println("Я стиральная машина. ВЖ-ВЖ-ВЖ-ВЖ");
    }
    @Override
    public String getName(){
        return "Стиральная машина";
    }
}

class Mixer extends ElectricalAppliance{
    public Mixer(int power){
        super(power);
    }
    @Override
    public void work(){
        System.out.println("Я мыксер. ТРРРРРРРРР");
    }
    @Override
    public String getName(){
        return "Мыксер";
    }
}
