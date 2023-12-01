import java.util.*;
class Pet {
    Map<String, Object> variableMap = new HashMap<>();
    Pet(String[] variables){
        //If variables array length isnt 5 then creates new array with a predefined length of 5 
        //then adding the the variables array elements. Any elements not defined is then set to ""
        if(variables.length != 5){
            String[] newArray = new String[5];
            for(int i=0; i<variables.length; i++){
                newArray[i] = variables[i];
            }
            for(int i=variables.length; i<5; i++){
                newArray[i] = "";
            }
            variables = newArray;
        }
        //Assigns variable names and values
        variableMap.put("name", variables[0]);
        variableMap.put("type", variables[1]);
        variableMap.put("breed", variables[2]);
        variableMap.put("age", variables[3]);
        variableMap.put("weight", variables[4]);
    }
    void setVariable(String variableName, Object variableValue){
        variableMap.put(variableName.toLowerCase(),variableValue);
        System.out.println("variable "+variableName.toLowerCase()+" has been created and assigned");
    }
    void getVariable(String variableName){
        //Prints the variable name and value neatly unless the variable name does not exist. If the value was never defined it just prints Unknown
        if(variableMap.get(variableName.toLowerCase()) == null){
            System.out.println("The variable "+'"'+variableName+'"'+" does not exist");
        }
        else if(variableMap.get(variableName.toLowerCase()) == ""){
            System.out.println(variableName.substring(0,1).toUpperCase()+variableName.substring(1,variableName.length()).toLowerCase()+" : Unknown");
        }
        else{
            System.out.print(variableName.substring(0,1).toUpperCase()+variableName.substring(1,variableName.length()).toLowerCase()+" : ");
            System.out.println(variableMap.get(variableName.toLowerCase()));
        }
    }
    void printInfo(){
        //Prints all the variables
        System.out.println();
        String[] variableNames = {"name","type","breed","age","weight"};
        for(int i=0; i<variableNames.length; i++){
            getVariable(variableNames[i]);
        }
    }
}
public class TesterClass {
    public static void main(String[] args){
        Pet pet1 = new Pet(new String[]{"Cocoa","cat","Siamese","11","10.4"});
        Pet pet2 = new Pet(new String[]{"Pippins","Dog","","3"});
        pet1.getVariable("Height");
        pet1.setVariable("HEIGHT", "11.4");
        pet1.getVariable("Height");
        pet2.getVariable("Age");
        pet1.printInfo();
        pet2.printInfo();
    }
}
