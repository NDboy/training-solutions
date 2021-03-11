package week08.week08d01;

public enum DoorStatus {
    OPEN{
        @Override
        public DoorStatus change() {
            return DoorStatus.CLOSED;
        }
    },
    CLOSED{
        @Override
        public DoorStatus change() {
            return DoorStatus.OPEN;
        }
    };

    public abstract DoorStatus change();
}
