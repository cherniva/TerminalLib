package cherniva.project;import cherniva.project.TerminalLib.*;import java.io.*;import java.util.HashMap;public class Main {//    public static void function(MultiConsumer<Integer> consumer, Integer a1, Integer a2, Integer a3) {//        Integer[] arr = {a1, a2, a3};//        consumer.accept(arr);//    }    public static void main(String[] args) throws IOException {        HashMap<String, Option<?>> optionHashMap = new HashMap<>();        Option<Integer> leftOperand = new Option<>(                "-l",                2,                "Stores value of left operand",                null);        Option<Integer> rightOperand = new Option<>(                "-r",                7,                "Stores value of right operand",                null);        Option<Boolean> verbose = new Option<>(                "-v",                true,                "Influences behavioral of printing functions",                null);        Option<ArithmeticOperations> addiction = new Option<>(                "-o",                ArithmeticOperations.PLUS,                "Do operation based on passed argument",                (hashMap) -> {                    ArithmeticOperations operation = (ArithmeticOperations) hashMap.get("-o").getOptionArgument();                    Integer operand1 = (Integer) hashMap.get("-l").getOptionArgument();                    Integer operand2 = (Integer) hashMap.get("-r").getOptionArgument();                    Boolean _verbose = (Boolean) hashMap.get("-v").getOptionArgument();                    int result = 0;                    switch (operation) {                        case PLUS:                            result = operand1 + operand2;                            break;                        case MINUS:                            result = operand1 - operand2;                            break;                        case MULTIPLY:                            result = operand1 * operand2;                            break;                        case DIVIDE:                            result = operand1 / operand2;                            break;                    }                    if(_verbose)                        System.out.println(operand1 + "+" + operand2 + "=" + result);                    else                        System.out.println(result);                });        optionHashMap.put(leftOperand.getOptionName(), leftOperand);        optionHashMap.put(rightOperand.getOptionName(), rightOperand);        optionHashMap.put(verbose.getOptionName(), verbose);        optionHashMap.put(addiction.getOptionName(), addiction);        addiction.doJob(optionHashMap);//        File file = new File("src/main/java/cherniva/project/TerminalLib/options.txt");//        System.out.println(file.exists());        Option<Object> help = new Option<>(                "-h",                null,                "List all added options",                (arguments) -> {                    File file = new File("src/main/java/cherniva/project/TerminalLib/options.txt");                    BufferedReader br = null;                    try {                        br = new BufferedReader(new FileReader(file));                    } catch (FileNotFoundException e) {                        throw new RuntimeException(e);                    }                    String line;                    while (true) {                        try {                            if (!((line = br.readLine()) != null)) break;                        } catch (IOException e) {                            throw new RuntimeException(e);                        }                        System.out.println(line);                    }                });        optionHashMap.put(help.getOptionName(), help);        help.doJob();//        MultiConsumer<Integer> consumer = (a) -> {//            int s = a[0]+a[1]+a[2];//            if(s > 7)//                System.out.println(s);//            else//                System.out.println("Nope");//        };//        function(consumer, 1, 4, 3);//        ReaderWriter terminalLib = new ReaderWriterImpl();//        String line = terminalLib.getLine();//        System.out.println(line);    }}