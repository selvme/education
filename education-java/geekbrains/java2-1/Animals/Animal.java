/**
 * Abstract class Animal - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
abstract class Animal {
    protected String name;
    protected int run_limit;

    abstract String voice();

    boolean run(int length) {
        return run_limit >= length;
    }
    
    @Override
    public String toString() {
        return this.getClass().getName() + " " + name;
    }    
}
