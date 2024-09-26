package com.campusdual.classroom;

public class Car {
    // Atributos del coche
    public String brand;
    public String model;
    public static final int MAX_SPEED = 120; // Velocidad máxima constante
    public String fuel;
    public int speedometer = 0; // Velocímetro inicializado en 0
    public int tachometer = 0; // Tacómetro inicializado en 0
    public String gear = "N";
    public boolean reverse = false;
    public int wheelsAngle = 0;

    // Constructor
    public Car(String brand, String model, String fuel) {
        this.brand = brand;
        this.model = model;
        this.fuel = fuel;
    }

    public Car() {

    }

    // Método para encender el coche
    public void start() {
        if (this.tachometer == 0) {
            this.tachometer = 1000;
            System.out.println("Vehículo encendido");
        } else {
            System.out.println("El vehículo ya está encendido");

        }
    }

    // Método para apagar el coche
    public void stop() {
        if (this.speedometer == 0) {
            this.tachometer = 0;
            System.out.println("Vehículo apagado");
        } else {
            System.out.println("No se puede apagar el vehículo,primero tiene que estar detenido");
        }
    }

    // Otros métodos (aún no implementados)
    public void accelerate() {
        if (speedometer >= MAX_SPEED){
            System.out.println("La velocidad no puede superar los 120Km/h");
        }else{

            speedometer += 20;
        }
    }

    public void brake() {
        if (speedometer<= 0){
            System.out.println("No se puede frenar estando parado.");
        }else{
            speedometer-=20;
        }
    }

    public void turnAngleOfWheels(int angle) {

        if (angle < -45){
            System.out.println("El angulo no puede ser menor a -45");
            this.wheelsAngle = -45;
        }else if(angle >45){
            System.out.println("El angulo no puede ser mayor a 45");
            this.wheelsAngle = 45;
        }else{
            this.wheelsAngle = angle;

        }

    }

    public String showSteeringWheelDetail() {
        return null;
    }

    public boolean isReverse() {
        return reverse;
    }

    public void setReverse(boolean reverse) {
        if (this.speedometer>0 && reverse){
            System.out.println("No se puede poner la marcha atrás con el coche en movimiento");
            this.gear="N";
            this.reverse=false;
        }else{
            this.gear="R";
            reverse = true;

        }

    }

    public void showDetails() {
    }

    public boolean isTachometerEqualToZero() {
        return tachometer == 0;
    }

    public boolean isTachometerGreaterThanZero() {
        return tachometer > 0;
    }


    // Método principal (punto de entrada del programa)
    public static void main(String[] args) {
        // Aquí se crearían objetos de tipo Car y se llamarían a sus métodos

        Car coche1 = new Car();
        Car coche2 = new Car();


        //Se comprueba que el tacometro está en 0
        System.out.println("\u001B[33mComprueba que el tacometro está en 0 \u001B[0m");
        if (coche1.isTachometerEqualToZero()) System.out.println("El tacometro está en 0");
        System.out.println("");


        //Se arranca el coche y se vuelve a comprobar
        System.out.println("\u001B[33mComprueba que al arrancar el coche el tacometro aumenta\u001B[0m");
        coche1.start();
        if (coche1.isTachometerGreaterThanZero()) System.out.println("El tacometro está en " + coche1.tachometer);
        System.out.println("");

        //Se enciende el coche estando ya encendido
        System.out.println("\u001B[33mComprueba que el coche no se puede volver a encender\u001B[0m");
        coche1.start();
        System.out.println("");


        //Se apaga el coche y se comprueba el valor del tacometro
        System.out.println("\u001B[33mSe apaga el coche y se conprueba el valor del tacometro \u001B[0m");
        coche1.stop();
        if (coche1.isTachometerEqualToZero()) System.out.println("El tacometro esta en " + coche1.tachometer);
        System.out.println("");


        //Se enciende el coche, se mueve y se intenta apagar
        System.out.println("\u001B[33mSe comprueba que el coche no pueda apagarse en movimiento \u001B[0m");
        coche1.start();
        coche1.accelerate();
        coche1.stop();
        System.out.println("");

        //Comprobar que no se puede acelerar más de 120
        System.out.println("\u001B[33mSe comprueba que no se puede acelerar a más de 120Km/h\u001B[0m");
        for (int i = 0; i < 6; i++) {
            coche1.accelerate();
        }
        System.out.println("");

        //Se comprueba que se reduzca la velocidad al frenar
        System.out.println("\u001B[33mComprobando frenado...\u001B[0m");
        System.out.println("Velocidad inicial: "+coche1.speedometer);
        coche1.brake();
        System.out.println("Velocidad después de frenar: "+coche1.speedometer);
        System.out.println("");

        //Se comprueba que no se pueda frenar por debajo de 0
        System.out.println("\u001B[33mComprobando frenado en negativo...\u001B[0m");
        for (int i = 0; i<6; i++){
            coche1.brake();
        }
        System.out.println("");

        //Girar el volante 20 grados
        System.out.println("\u001B[33mGirando el volante 20º...\u001B[0m");
        coche1.turnAngleOfWheels(45);
        System.out.println("");

        //Girar el volante más de 45 o -45 grados
        System.out.println("\u001b[33mHaciendo giros imposibles...\u001b[0m");
        coche1.turnAngleOfWheels(46);
        coche1.turnAngleOfWheels(-50);
        System.out.println("");

        //Intentar dar marcha atrás mientras el coche está en movimiento
        System.out.println("\u001b[33mIntentado poner reversa...\u001b[0m");
        coche1.accelerate();
        coche1.setReverse(true);


    }
}