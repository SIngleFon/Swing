package ArrayCompare;

public class ArrayCompare {
    public static  <T> boolean compareArrays(T[] arrayFirst, T[] arraysSecond){
        if(arrayFirst.length != arraysSecond.length){
            return false;
        }
        for (int i = 0; i < arrayFirst.length; i++) {
            if(!arrayFirst[i].equals(arraysSecond[i])){
                return false;
            }
        }
        return true;
    }
}
