package lang.JaVALOR.utils.ConsoleMenu;

import lang.JaVALOR.utils.KeyboardScanner.KeyboardScanner;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;


public class ConsoleMenu extends ArrayList<MenuItem> {

    public ConsoleMenu(int initialCapacity) {
        super(initialCapacity);
    }

    public ConsoleMenu() {
    }

    public ConsoleMenu(Collection<? extends MenuItem> c) {
        super(c);
    }

    public void show() {
        show(System.out);
    }

    public void show(PrintStream printStream) {

        for (int index = 0; index < this.size(); index++) {
            printStream.printf("%10s %-60s\n",String.format("[%s]",index+1),get(index).getLabel());
        }

    }

    public Integer waitForChoice() {
        return waitForChoice(String.format(" [1] to [%d]> ", this.size()));
    }

    public void action(Integer index) {
        if ((index < 0)||(index >= this.size()))
            return;

        if (this.get(index).getAction() == null)
            return;

        MenuItem menuItem = this.get(index);
        menuItem.getAction().accept(index,menuItem);

    }

    public Integer waitForChoice(String prompt) {
        return waitForChoice(System.in, System.out, prompt);
    }

    public Integer waitForChoice(InputStream inputStream, PrintStream printStream, String prompt) {
        if (this.isEmpty())
            return null;

        KeyboardScanner keyboardScanner = new KeyboardScanner(inputStream, printStream);
        Integer index;
        String s;

        do {
            index = Integer.parseInt(s=keyboardScanner.getToken(prompt))-1;
            if (index < 0)
                printStream.printf(" * Please enter a valid number, '%s' is not valid\n",s);
            else if (index >= this.size())
                printStream.println(" * Selected choice out of range");
            else
                break;
        } while(true);


        return index;
    }

}
