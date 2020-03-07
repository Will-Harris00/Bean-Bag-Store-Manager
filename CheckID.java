package beanbags;

public class CheckID {
    public static boolean validID(String id) {
        boolean valid = false;
        try {
            long decimal = Long.parseLong(id, 16);
            if (decimal > 0) {
                valid = true;
            }
        }
        catch(NumberFormatException e) {
        }
        return valid;
    }
}

