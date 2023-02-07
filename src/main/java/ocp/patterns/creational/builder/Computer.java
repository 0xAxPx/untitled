package ocp.patterns.creational.builder;

public class Computer {

    private String hdd;
    private String ssd;
    private String ram;

    public String getHdd() {
        return hdd;
    }

    public String getSsd() {
        return ssd;
    }

    public String getRam() {
        return ram;
    }

    private Computer(ComputerBuilder builder) {
        this.hdd = builder.hdd;
        this.ssd = builder.ssd;
        this.ram = builder.ram;
    }

    static class ComputerBuilder{

        private String hdd;
        private String ssd;
        private String ram;


        public ComputerBuilder() {
        }



        @Override
        public String toString() {
            return "ComputerBuilder{" +
                    "hdd='" + hdd + '\'' +
                    ", ssd='" + ssd + '\'' +
                    ", ram='" + ram + '\'' +
                    '}';
        }

        public ComputerBuilder(String hdd, String ssd, String ram) {
            this.hdd = hdd;
            this.ssd = ssd;
            this.ram = ram;
        }

        ComputerBuilder setHDD(String hdd) {
            this.hdd = hdd;
            return this;
        }

        ComputerBuilder setSSD(String sdd) {
            this.ssd = sdd;
            return this;
        }

        ComputerBuilder setRAM(String ram) {
            this.ram = ram;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

}
