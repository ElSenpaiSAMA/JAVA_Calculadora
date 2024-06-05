public class Operaciones {
    public static double op(double pri, double seg, String ope) {
        double resultado = 0;
        if (ope.equals("+")) {
            resultado = pri + seg;
        } 
        else if (ope.equals("-")) {
            resultado = pri - seg;
        } 
        else if (ope.equals("*")) {
            resultado = pri * seg;
        } 
        else if (ope.equals("÷")) {
            if (seg != 0) {
                resultado = pri / seg;
            } 
            else {
                throw new ArithmeticException("ERROR");
            }
        } 
        else if (ope.equals("^")) {
            resultado = Math.pow(pri, seg);
        } 
        else {
            throw new IllegalArgumentException("ERROR");
        }
        return resultado;
    }
}
