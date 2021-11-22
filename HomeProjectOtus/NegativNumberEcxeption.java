package HomeProjectOtus;

class NegativNumberEcxeption extends Exception{


    private String exc;

    public NegativNumberEcxeption (String exc) {

        this.exc = exc;
    }
}