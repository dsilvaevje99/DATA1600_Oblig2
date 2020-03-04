package skaar;

interface BensinStatus {
    String getStatus(BensinStateContext ctx);
}

class BensinStateContext
{
    private BensinStatus currentState;

    public BensinStateContext()
    {
        currentState = new Tank_full();
    }

    public void setState(BensinStatus state)
    {
        currentState = state;
    }

    public String getStatus(){
        return currentState.getStatus(this);
    }
}

class Tank_full implements BensinStatus {

    @Override
    public String getStatus(BensinStateContext ctx) {
        return "Tank Full!";
    }
}
class Tank_lav implements BensinStatus {

    @Override
    public String getStatus(BensinStateContext ctx) {
        return "Tank lav!";
    }
}

class Tank_kritisk implements BensinStatus {

    @Override
    public String getStatus(BensinStateContext ctx) {
        return "Tank kritisk lav!";
    }
}