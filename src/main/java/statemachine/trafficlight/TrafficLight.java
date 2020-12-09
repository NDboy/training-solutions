package statemachine.trafficlight;


public enum TrafficLight {
    RED {
        public TrafficLight next() {
            return TrafficLight.RED_YELLOW;
        }
    },
    RED_YELLOW {
        public TrafficLight next() {
            return TrafficLight.GREEN;
        }
    },
    GREEN {
        public TrafficLight next() {
            return TrafficLight.YELLOW;
        }
    },
    YELLOW {
        public TrafficLight next() {
            return TrafficLight.RED;
        }
    };


    public abstract TrafficLight next();

}
