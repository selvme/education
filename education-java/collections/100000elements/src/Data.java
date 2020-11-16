import java.util.Random;

class Data {
    final private int SIZE;
    private final Box[] BOX;

    Data(int capArr){
        this.SIZE = capArr;
        this.BOX = new Box[this.SIZE];
        for (int i=0; i < this.SIZE; i++){
            Random rnd = new Random();
            String s = "Class" + rnd.nextInt(this.SIZE) * i;
            long date = 1 + rnd.nextInt(this.SIZE) * this.SIZE;
            BOX[i] = new Box(s, date);
        }
    }

    public Box[] getBox(){
        return this.BOX;
    }
    public int getSize(){
        return this.SIZE;
    }

    protected class Box{
        private String name;
        private long date;

        Box(String name, long date){
            this.name = name;
            this.date = date;
        }

        public long getDate() {
            return date;
        }

        public String getName() {
            return name;
        }

        @Override
        public int hashCode() {
            return (int) (this.name.hashCode() / this.date);
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof Box
                    && ((Box) obj).getName().equals(this.getName())
                    && ((Box) obj).getDate() == this.getDate();
        }

        @Override
        public String toString() {
            return " Name: " + this.name + " Date: " + this.date;
        }
    }
}
