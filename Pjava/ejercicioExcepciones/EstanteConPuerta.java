package ejercicioExcepciones;

// Excepciones
class EstanteConPuertaOutOfOrderException extends Exception {}
class BadNumberOfSlotsException extends Exception {}
class NoMoreSpaceException extends Exception {}

public class EstanteConPuerta {
    // Propiedades
    private int numberOfSlots;
    private String[] slots;
    private boolean doorOpen;
    private boolean doorBroken;
    
    // Constructores
    EstanteConPuerta(int n) throws BadNumberOfSlotsException{
        if (n < 1 || n > 10) {
            throw new BadNumberOfSlotsException();
        }
        this.numberOfSlots = n;
        this.slots = new String[n];
    }
    
    // Métodos
    void breakDoor(){
        this.doorBroken = true;
    }
    
    void openDoor() throws EstanteConPuertaOutOfOrderException {
        if (this.doorBroken == true) {
            throw new EstanteConPuertaOutOfOrderException();
        } else if (!this.doorOpen){
            this.doorOpen = true;
        } 
    }
    
    void closeDoor() throws EstanteConPuertaOutOfOrderException {
        if (this.doorBroken == true) {
            throw new EstanteConPuertaOutOfOrderException();
        } else if (this.doorOpen) {
                this.doorOpen = false;
        } 
    }
    
    void AddString(String s) throws EstanteConPuertaOutOfOrderException, 
            NoMoreSpaceException {
        
        this.openDoor();
        boolean hueco = false;;
        
        for (int i = 0; i < this.slots.length;i++) {
            if (slots[i] == null) {
                hueco = true;
            }else {
                hueco = false;
            }
        }
        
        for (int i = 0; i < this.slots.length;i++) {
            if (!hueco){
                throw new NoMoreSpaceException();
            }
            if (slots[i] == null) {
                slots[i] = s;
                break;
            }  
        }
        this.closeDoor();
    }
    
    // Main
    public static void main(String[] args) {
        try {
            // Están comentadas las que a proposito dan excepción
            //EstanteConPuerta e1 = new EstanteConPuerta(25);
            EstanteConPuerta e2 = new EstanteConPuerta(5);
            e2.AddString("Patata");
            e2.AddString("Pera");
            e2.AddString("Leche");
            e2.AddString("Lata");
            e2.AddString("Tomate");
            //e2.AddString("SEXTA");
            
            EstanteConPuerta e3 = new EstanteConPuerta(4);
            e3.AddString("Tomate");
            e3.breakDoor();
            //e3.AddString("Lata");
            
        } catch (BadNumberOfSlotsException ex) {
            System.out.println("BadNumberOfSlotsException");
        } catch (EstanteConPuertaOutOfOrderException ex) {
            System.out.println("EstanteConPuertaOutOfOrderException");
        } catch (NoMoreSpaceException ex) {
            System.out.println("NoMoreSpaceException");
        }
    }
    
}


