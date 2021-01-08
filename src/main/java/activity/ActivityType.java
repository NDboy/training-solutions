package activity;

public enum ActivityType {
    BIKING{
        @Override
        public ActivityType next() {
            return HIKING;
        }
    },
    HIKING{
        @Override
        public ActivityType next() {
            return RUNNING;
        }
    },
    RUNNING{
        @Override
        public ActivityType next() {
            return BASKETBALL;
        }
    },
    BASKETBALL{
        @Override
        public ActivityType next() {
            return BIKING;
        }
    };

    public abstract ActivityType next();
}
