package ejercicioevaluable;

public class Deposito {
    
    // Propiedades
    
    int volumenMaxEnLitros;
    double volumenEnLitros;
    boolean grifoAbierto;
    int porcentajeDeLLenado; // 100. * (volumenEnLitros/volumenMaxEnLitros) 
    String nombreDeposito;
    String colorDeposito;
    
    //Constructores
    
    Deposito (){
    this.volumenMaxEnLitros = 50;
    this.colorDeposito = "blanco";
    this.porcentajeDeLLenado = 0;
    }
    
    Deposito (int volumenMaxEnLitros, String colorDeposito){
    this.volumenMaxEnLitros = (volumenMaxEnLitros >= 25 && volumenMaxEnLitros
            <= 350) ? volumenMaxEnLitros : (volumenMaxEnLitros < 25) ? 25 : 
            (volumenMaxEnLitros > 350) ? 350 : volumenMaxEnLitros;
    this.colorDeposito = colorDeposito;
    this.volumenEnLitros = (volumenEnLitros >= 0 && volumenEnLitros <= 
            volumenMaxEnLitros) ?
            volumenEnLitros : (volumenEnLitros < 0) ? 0 : (volumenEnLitros > 
            350) ? 350 : volumenEnLitros;
    this.porcentajeDeLLenado = (int) ((volumenEnLitros / volumenMaxEnLitros) 
            * 100);
    this.colorDeposito = (colorDeposito == "blanco" || colorDeposito == "verde"
            || colorDeposito == "negro" || colorDeposito == "azul") ?
            colorDeposito : "Blanco";
    }
    
    //------------------------------------------------------------------------
    // Métodos extra para solucionar error
    
    public double setVolumenMaxEnLitros(int litros){
        this.volumenMaxEnLitros = (litros >= 25 && litros
            <= 350) ? litros : (litros < 25) ? 25 : 
            (litros > 350) ? 350 : litros;
        return this.volumenMaxEnLitros;
    }
    
    public int setporcentaje(int porcentaje){     
        this.porcentajeDeLLenado = (int) (100. * (this.volumenEnLitros / this.volumenMaxEnLitros));
        return this.porcentajeDeLLenado;
    }
    
    //-------------------------------------------------------------------------
    
    // Métodos
    
    public void show(){
        System.out.printf("Depósito '%s' %s de %d litros de capacidad "
                + "lleno al %d %% con el grifo %s %n",nombreDeposito,
                colorDeposito,volumenMaxEnLitros,porcentajeDeLLenado,
                (grifoAbierto == true ) ? "abierto" : "cerrado");
    } 
    
    // ------------------------------------------------------------------
    public void showDePrueba(){
        System.out.printf("Depósito '%s' %s de %d litros de capacidad "
                + "lleno al %d %% con el grifo %s %f %n",nombreDeposito,
                colorDeposito,volumenMaxEnLitros,porcentajeDeLLenado,
                (grifoAbierto == true ) ? "abierto" : "cerrado",volumenEnLitros);
    } 
    // -------------------------------------------------------------------
    
    int llenaDeposito(int litros){
        if (litros > (volumenMaxEnLitros - volumenEnLitros)) {
            return (int) (volumenEnLitros = volumenMaxEnLitros);
        } else {
            this.volumenEnLitros += litros;
            return litros;
        }
    }
    
    int llenaDeposito(double porcentaje){
        return llenaDeposito((int) this.volumenMaxEnLitros * porcentaje / 100);
    }
    
    int vaciaDeposito(int litros){
        this.volumenEnLitros = this.volumenEnLitros - litros;
        return litros;
    }
    
    int vaciaDeposito(double porcentaje){
        int cantidad = (int)(porcentaje / 100) * this.volumenMaxEnLitros;
        this.volumenEnLitros = this.volumenEnLitros - cantidad;
        return cantidad;
    }
    
    int llenaDeposito(){
        int anteriorCantidad = (int) this.volumenEnLitros;
        int cantiadALlenar = this.volumenMaxEnLitros - anteriorCantidad;
        this.volumenEnLitros += cantiadALlenar;
        return anteriorCantidad;
    }
    
    int vaciaDeposito(){
        int anteriorCantidad = (int) this.volumenEnLitros;
        this.volumenEnLitros = this.volumenEnLitros - anteriorCantidad;
        return anteriorCantidad;
    }
    
    boolean actualizaNombreDeposito(String nombre){
        if (!(nombre == null || "".equals(nombre))){
            this.nombreDeposito = this.nombreDeposito == null ? nombre : this.nombreDeposito;
            return true;
        }
        return false;
    }
    
    //----------------------------------------------------------------------
    // pruebas para ver el problema
    
    public double getDeposito (){
        return this.volumenEnLitros;
    }
    
    public double getporcentaje (){
        return this.porcentajeDeLLenado;
    }
    //-----------------------------------------------------------------------
    public static void main(String[] args) {
        //------------------------------------------------
        System.out.println("-------Inicio deprueba-------------");
        Deposito dp0 = new Deposito();
        dp0.llenaDeposito(); // deberia marcar 350 que es el max segun el contructor
        System.out.println(dp0.getDeposito());
        System.out.println(dp0.getporcentaje()); // ya tendria que saber quel volumen es 50 y el deposito es 50 deberia dar 100%
        System.out.println(dp0.actualizaNombreDeposito("pepe"));
        dp0.setporcentaje(25);
        System.out.println(dp0.getporcentaje());
        
        //dp0.show();
        dp0.showDePrueba();
        System.out.println("------Fin de prueba 1---------------");
        //-----------------------------------------------
        
        Deposito dp1 = new Deposito(10,"blanco");
        dp1.actualizaNombreDeposito("DEP01");
        Deposito dp2 = new Deposito(50,"verde");
        dp2.actualizaNombreDeposito("DEP02");
        Deposito dp3 = new Deposito(200,"negro");
        dp3.actualizaNombreDeposito("DEP03");
        Deposito dp4 = new Deposito(500,"azul");
        dp4.actualizaNombreDeposito("DEP04");

        //dp1.show();
        
                       dp1.showDePrueba(); //0 funciona

        dp1.llenaDeposito();
                       dp1.showDePrueba(); //25 funciona

        dp1.vaciaDeposito(10); //15 funciona
                       dp1.showDePrueba();

        dp1.vaciaDeposito(50.); // no resta 12,5
                       dp1.showDePrueba();

        dp1.llenaDeposito(25); // funciona
                       dp1.showDePrueba();

        dp1.llenaDeposito((double)25);
                       dp1.showDePrueba(); // no suma 
        
        dp1.vaciaDeposito(); // funciona
                       dp1.showDePrueba();
                       
        System.out.println("------Fin de prueba 2---------------");

        //---------------------------------------------------------------
        
        //dp2.show();
        dp2.llenaDeposito();
        dp2.vaciaDeposito(10);
        dp2.vaciaDeposito((double)50);
        dp2.llenaDeposito(25);
        dp2.llenaDeposito((double)25);
        dp2.vaciaDeposito();
        
        //dp3.show();
        dp3.llenaDeposito();
        dp3.vaciaDeposito(10);
        dp3.vaciaDeposito((double)50);
        dp3.llenaDeposito(25);
        dp3.llenaDeposito((double)25);
        dp3.vaciaDeposito();
        
        //dp4.show();
        dp4.llenaDeposito();
        dp4.vaciaDeposito(10);
        dp4.vaciaDeposito((double)50);
        dp4.llenaDeposito(25);
        dp4.llenaDeposito((double)25);
        dp4.vaciaDeposito();
        
        System.out.println("------------------");
        // Ejecicio 4 C
        
        Deposito depA = new Deposito(10,"blanco");
        depA.actualizaNombreDeposito("DEP01");
        Deposito depB = new Deposito(50,"verde");
        depB.actualizaNombreDeposito("DEP02");
        Deposito depC = new Deposito(200,"negro");
        depC.actualizaNombreDeposito("DEP03");
        Deposito depD = new Deposito(500,"azul");
        depD.actualizaNombreDeposito("DEP04");
        
        depA.show();
        depB.show();
        depC.show();
        depD.show();
        
        System.out.println("-----------------");
        
        //depD.llenaDeposito();
        int cantidadDeDepA = depD.llenaDeposito();
        depC.llenaDeposito(cantidadDeDepA);
        depB.llenaDeposito(cantidadDeDepA);
        depA.llenaDeposito(cantidadDeDepA);
        
        int cantidadAVaciarA = depA.vaciaDeposito();
        depD.llenaDeposito(cantidadAVaciarA);
        
        int cantidadAVaciarB = depB.vaciaDeposito();
        depA.llenaDeposito(cantidadAVaciarB);
       
        depA.show();
        depB.show();
        depC.show();
        depD.show();

    }
}
