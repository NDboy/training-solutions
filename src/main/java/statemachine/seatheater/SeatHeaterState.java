package statemachine.seatheater;

public enum  SeatHeaterState {
    OFF {
        public SeatHeaterState next() {
            return SeatHeaterState.THREE;
        }
    },
    THREE {
        public SeatHeaterState next() {
            return SeatHeaterState.TWO;
        }
    },
    TWO {
        public SeatHeaterState next() {
            return SeatHeaterState.ONE;
        }
    },
    ONE {
        public SeatHeaterState next() {
            return SeatHeaterState.OFF;
        }
    };


    public abstract SeatHeaterState next();

}
